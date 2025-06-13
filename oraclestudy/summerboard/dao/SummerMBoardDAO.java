package summerboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import summerboard.summerBoardExam;
import summerboard.dto.SummerBoardDTO;
import summerboard.dto.SummerMemberDTO;

public class SummerMBoardDAO {
	// 게시판의 db와 연동을 담당
	// jdbc 5단계를 사용
	// 1단계 : connect 객체를 사용하여 ojdbc.jar 생성
	// 2단계 : url, id, pw, sql 쿼리문 작성
	// 3단계 : 쿼리문 실행
	// 4단계 : 쿼리문 실행 결과 받기
	// 5단계 : 연결 종료를 진행
	
	// 필드
	public SummerMemberDTO summerMemberDTO = new SummerMemberDTO();
	public SummerBoardDTO summerBoardDTO = new SummerBoardDTO();
	public Connection connection = null;
	public Statement statement = null;
	public PreparedStatement preparedStatement = null;
	public ResultSet resultSet = null;
	public int result= 0;
	
	// 기본생성자
	public SummerMBoardDAO() {
		
		try { // 예외가 발생 할 수 있는 실행문, 프로그램 강제종료 처리용
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1단계 호출
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","summerboard","summerboard");
		}catch (ClassNotFoundException e) {
			System.out.println("~ 드라이버 이름이나 ojdbc6.jar 파일이 잘못 되었습니다 -_-^ ~ ");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("~ URL, ID, PW가 잘못되었습니다 -_-^ summerMemberDAO를 확인하세요 ㅠ.ㅠ ~ ");
			e.printStackTrace();
			System.exit(0);//강제종료
		}// catch 종료
		
	}// 기본생성자 종료

	public void MboardAll() throws SQLException {
		// 전체 글 목록
		
		try {
		String sql = "select bno, btitle, bwriter, bdate from board order by bdate desc";
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		
		System.out.println("번호\t   제목\t\t\t\t  작성자\t\t     작성일\t");
		while (resultSet.next()) {
			System.out.print(resultSet.getInt("bno") +" : ");
			System.out.print(resultSet.getString("btitle") + "\t"+" : ");
			System.out.print(resultSet.getString("bwriter") + "\t "+" : ");
			System.out.println(resultSet.getDate("bdate") + "\t" );
			System.out.println("--------------------------------------------------");
		} // while 종료
		} catch (SQLException e) {
			System.out.println("MboardALL() 메서드에 쿼리문이 잘 못 되었습니다");
			e.printStackTrace();
			System.exit(0);
		}finally {
			resultSet.close();
			statement.close();
		}// finally 종료
	} // MboardAll 메서드 종료

	public void MboardAdd(SummerBoardDTO summerBoardDTO, Scanner inputLine)throws SQLException {
		// 게시물 작성
		
		try { String sql = "insert into board (bno, btitle,bcontent,bwriter, bdate)"  + "values (board_seq.nextval,?,?,?,sysdate)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, summerBoardDTO.getBtitle());
		preparedStatement.setString(2, summerBoardDTO.getBcontent());
		preparedStatement.setString(3, summerBoardDTO.getBwriter());
		//System.out.println(summerBoardDTO.getBwriter());
		System.out.println("쿼리확인: " + sql ); // 테스트코드
		result = preparedStatement.executeUpdate();
		
		if (result>0) {
			System.out.println(" ☆ ★ ☆ 게 시 물 등 록 완 료 ★ ☆ ★");
			connection.commit();
		}else {
			System.out.println("~ 게 시 물 등 록 에 실 패 했 습 니 다 ㅠ . ㅠ ~ ");
			connection.rollback();
		} // if종료
		}catch (SQLException e) {
			System.out.println("MboardAdd() 메서드에서 쿼리문을 확인하세요");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}//finally 종료
		
	} // MboardAdd 메서드 종료

	public void Myboard(String mname) throws SQLException {
		// 내가 쓴 글 조회
		
		try {
		
		String sql = "select * from board where bwriter = ? ";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, mname);
		resultSet = preparedStatement.executeQuery();
		
		boolean mylist = false;
		while(resultSet.next()) {
			mylist = true;
			System.out.println("------------------- ☆ ★ ☆ -------------------");
			System.out.print("번호 : "+resultSet.getInt("bno")+ " | ");
			System.out.println("제목 : "+resultSet.getString("btitle"));
			System.out.println("------------------------------------------------");
			System.out.println(" 내용 : " + resultSet.getString("bcontent"));
			System.out.println("------------------------------------------------");
			System.out.print("작성자 : " + resultSet.getString("bwriter") + " | ");
			System.out.println("작성일 : " + resultSet.getDate("bdate"));
		}// while 종료
		
		if (! mylist) {
			System.out.println(" ~ 작 성 한 글 이 없 습 니 다 ㅠ.ㅠ ~ ");
		} // if 종료
		
		System.out.println(" ☆ ★ ☆ 조 회 가 완 료 되 었 습 니 다 ☆ ★ ☆ ");
		
	} catch (SQLException e) {
		System.out.println("Myboard() 메서드에 쿼리문이 잘 못 되었습니다");
		e.printStackTrace();
		System.exit(0);
	}finally {	
		resultSet.close();
		preparedStatement.close();
		
	}// finally 종료
	}//Myboard 메서드 종료
	

	public void MyboardUp(String mname, Scanner inputStr, Scanner inputLine)throws SQLException {
		// 내가쓴글 수정
		

			System.out.print(" 수정하고 싶은 글 제목 입력 ▷ ");
			//inputLine.nextLine();
			String select = inputStr.next();
			
			try{String sql2 = "select * from board where bwriter =? and btitle = ? ";
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setString(1, mname);
			preparedStatement.setString(2, select);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				System.out.print(" 수정 할 제목 ▷ ");
				String newTitle = inputLine.nextLine();
				System.out.print("수정 할 내용 ▷ ");
				String newCont = inputLine.nextLine();
		
				try { String sql3 = "update board set  btitle =?, bcontent =?, bdate = sysdate where btitle =? and bwriter =?"; 
					preparedStatement = connection.prepareStatement(sql3);
					preparedStatement.setString(1, newTitle);
					preparedStatement.setString(2, newCont);
					preparedStatement.setString(3, select);
					preparedStatement.setString(4, mname);
					
					result = preparedStatement.executeUpdate();
					
					if (result>0) {
						System.out.println("☆ ~ 수 정 이 완 료 되 었 습 니 다 ~ ☆");
						connection.commit();
					}else {
						System.out.println(" ~ 수 정 에 실 패 했 습 니 다 ㅠ . ㅠ ~");
						connection.rollback();
					}//if종료
				}catch (SQLException e) { // 3번 try catch
					System.out.println(" myboardUp메서드의 sql3문을 확인하세요 ");
					e.printStackTrace();
				}finally { // 3번 try finally
					preparedStatement.close();
				} //3번finally 종료
			
			
			
			}else { System.out.println(" ~ 잘 못 입 력 하 셨 습 니 다 ㅠ.ㅠ ~");
				
			}//if 종료
			
//	
		

		}catch (SQLException e) {
			System.out.println("myboardUp메서드의 sql1문을 확인하세요");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}
		
		
	}// MyboardUp 메서드 종료

	public void MyboardDel(int myNo ) throws SQLException {
		// 내가 쓴 글 삭제
		 
		
		try {
			String sql = "delete from board where bno = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, myNo);
			result = preparedStatement.executeUpdate();
			
			if (result>0) {
				System.out.println("☆ ★ ☆ 삭 제 완 료 ☆ ★ ☆");
				connection.commit();
			}else { System.out.println(" ~ 삭 제 에 실 패 했 습 니 다 ㅠ.ㅠ ~");
			connection.rollback();
			}//if종료
			
			
		}catch (SQLException e) {
			System.out.println("MyboardDEL() 메서드와 sql문을 확인해주세요");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}//finally 종료
		
	} // MyboardDel 메서드 종료


	
	
} // class 종료
