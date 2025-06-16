package otest250613.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import otest250613.dto.BoardDTO;
import otest250613.dto.OtestDTO;

public class BoardDAO {

	
	public OtestDTO otestDTO = new OtestDTO();
	public BoardDTO boardDTO = new BoardDTO();
	public Connection connection = null;
	public Statement statement = null;
	public PreparedStatement preparedStatement = null;
	public ResultSet resultSet = null;
	public int result = 0;
	
	//	기본생성자
	public BoardDAO() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.160:1521:xe","otest","otest");
		} catch (ClassNotFoundException e) {
			System.out.println(" !!! 확인 !!!  드라이버 이름이나 ojdbc6.jar 오류 ");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println(" !!! 확인 !!! URL 이나 ID / PW 오류");
			e.printStackTrace();
			System.exit(0);
			
		} //catch 종료
		
	} // 기본생성자 종료

	// 메서드
	public void BoardList() throws SQLException {
		// 전체 글 조회
		
		try {
			String sql = "select * from board order by bdate desc";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				System.out.println("----------------------------");
				System.out.print(resultSet.getInt("bno") +" / ");
				System.out.print("제목 : "+resultSet.getString("btitle"));
				System.out.print(" ["+resultSet.getString("bname")+"] ");
				System.out.println("- "+resultSet.getDate("bdate"));
				
			}// while 종료
		}catch (SQLException e) {
			System.out.println(" BoardList 쿼리문을 확인하세요 ");
			e.printStackTrace();
		}finally {
			resultSet.close();
			statement.close();
		}//finally 종료
		
	} // BoardList 메서드 종료

	public  void BoardAdd(BoardDTO boardDTO, Scanner inputLine)throws SQLException {
		// 게시글 작성
		
		try {String sql = "insert into board (bno,btitle,bcontent,bname,bdate)" + "values (member_seq.nextval,?,?,?,sysdate)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, boardDTO.getBtitle());
		preparedStatement.setString(2, boardDTO.getBcontent());
		preparedStatement.setString(3, boardDTO.getBname());
		result = preparedStatement.executeUpdate();
		
		if (result>0) {
			System.out.println(" * 게시글 등록이 완료 됐습니다");
			connection.commit();
		}else {
			System.out.println(" * 게시글 등록에 실패 했습니다");
			connection.rollback();
		}//if 종료
		}catch (SQLException e) {
			System.out.println(" Board Add 쿼리문을 확인하세요 ");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}
		
	}//BoardAdd 메서드종료

	public void BoardDel(String id, Scanner inputInt)throws SQLException{
		// 게시글 삭제
		BoardDTO boardDTO = new BoardDTO();
		if (!"master".equals(id)) {
			System.out.println(" * 관리자만 접근이 가능합니다 ");
			return;
		}
		System.out.println("삭제할 게시물 번호를 입력하세요");
		System.out.print(">>>");
		int delBno = inputInt.nextInt();
		
		try { String sql = "delete from board where bno = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, delBno);
		result = preparedStatement.executeUpdate();
		
		if (result>0) {
			System.out.println(" * 게시글 삭제가 완료 되었습니다 ");
			connection.commit();
		}else { 
			System.out.println(" * 게시글 삭제에 실패 했습니다");
			connection.rollback();
		} // if 종료
		} catch (SQLException e) {
			System.out.println("BoardDel 메서드의 쿼리문을 확인하세요 ");
			e.printStackTrace();
		}finally {
			preparedStatement.close();			
		}//finally 종료
		
		
	}// BoardDel 메서드 종료

	public void BoardUp(String mname, Scanner inputStr, Scanner inputLine, Scanner inputInt) throws SQLException {
		// 게시글 수정
		
		System.out.println(" * 수정하고 싶은 글의 번호를 입력하세요");
		System.out.print(">>>");
		int upBno = inputInt.nextInt();
		
		try {String sql1 = "select * from board where bname =? and bno =?";
		preparedStatement = connection.prepareStatement(sql1);
		preparedStatement.setString(1, mname);
		preparedStatement.setInt(2, upBno);
		resultSet = preparedStatement.executeQuery();
		
		
		
		if (resultSet.next()) {
			System.out.print(" 수정 할 제목 : ");
			String upTitle = inputLine.nextLine();
			System.out.print("수정 할 내용 : ");
			String upContent = inputLine.nextLine();
			
			try { String sql2 = "update board set bititle =?, bcontent =?, bdate = sysdate where bno =? and bname = ?";
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setString(1, upTitle);
			preparedStatement.setString(2, upContent);
			preparedStatement.setInt(3, upBno);
			preparedStatement.setString(4, mname);
			
			result = preparedStatement.executeUpdate();
			
			if (result>0) {
				System.out.println(" * 수정이 완료 되었습니다");
				connection.commit();
			} else { 
				System.out.println(" * 수정에 실패 했습니다");
				connection.rollback();
			}//if종료
			}catch ( SQLException e) {
				System.out.println(" BoardUp메서드에서 sql2 쿼리문을 확인하세요");
				e.printStackTrace();
			}finally {
				preparedStatement.close();
			}//finally 종료
		
		} else {
			System.out.println(" * 본인이 작성한 게시글만 수정이 가능합니다 ");
		}
			
		}catch (SQLException e) {
			System.out.println(" BoardUp메서드에서 sql1 쿼리문을 확인하세요");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}//finally 종료
		
	} // BoardUp 종료
	
} // class 종료
