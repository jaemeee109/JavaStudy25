package summerboard.dao;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import summerboard.dto.SummerMemberDTO;




public class SummerMemberDAO {
	// 게시판의 db와 연동을 담당
	// jdbc 5단계를 사용
	// 1단계 : connect 객체를 사용하여 ojdbc.jar 생성
	// 2단계 : url, id, pw, sql 쿼리문 작성
	// 3단계 : 쿼리문 실행
	// 4단계 : 쿼리문 실행 결과 받기
	// 5단계 : 연결 종료를 진행
	
	public SummerMemberDTO summerMemberDTO = new SummerMemberDTO();
	public Connection connection = null;
	public Statement statement = null;
	public PreparedStatement preparedStatement = null;
	public ResultSet resultSet = null;
	public int result = 0;
	// 1개의 행이 삽입 | 수정 | 삭제 되었습니다 ( 정상처리 -> commit )
	// 0개의 행이 삽입 | 수정 | 삭제 되었습니다 ( 비정상처리 -> rollback )
	
	// 기본생성자
	public SummerMemberDAO() {
		
		try { // 예외가 발생 할 수 있는 실행문, 프로그램 강제종료 처리용
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1단계 호출
			connection =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","summerboard","summerboard");
			
		}catch (ClassNotFoundException e) {
			System.out.println(" ~ 드라이버 이름이나 ojdbc6.jar 파일이 잘못 되었습니다 -_-^ ~ ");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("~ URL, ID, PW가 잘못되었습니다 -_-^ summerMemberDAO를 확인하세요 ㅠ.ㅠ ~ ");
			e.printStackTrace();
			System.exit(0);//강제종료
		
		}// catch 종료
		}//기본생성자 종료
	
	
	
	
	public void memberJoin(SummerMemberDAO summerMemberDAO, SummerMemberDTO summerMemberDTO, Scanner inputStr) throws SQLException {
		// 회원가입 처리용
		
		try { String sql = "insert into member (mno, mname, id, pw, regidate)"+ "values (board_seq.nextval,?,?,?,sysdate)";
		
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, summerMemberDTO.getMname());
		preparedStatement.setString(2, summerMemberDTO.getId());
		preparedStatement.setString(3, summerMemberDTO.getPw());
		System.out.println("쿼리확인: "+sql); // 테스트용 코드
		result = preparedStatement.executeUpdate(); // 쿼리문 실행해서 결과를 정수로 받음
		
		if (result > 0) {
			System.out.println("☆ ★ ☆ 회 원 가 입 완 료 ☆ ★ ☆ ");
			connection.commit();
		}else {
			System.out.println("~ 회 원 가 입 에 실 패 했 습 니 다 ㅠ.ㅠ ~");
			connection.rollback();
		}//if 종료
		}catch (SQLException e) {
			System.out.println("~ memberJoin() 에서 쿼리문을 확인하세요 ㅠ.ㅠ ~");
			e.printStackTrace();
		}finally { // 예외 발생 및 정상 실행 후 무조건 처리되는 실행문
			preparedStatement.close();
			
		}// finally 종료
		
	}// memberJoin 메서드 종료




	public SummerMemberDTO memberLogin(String id, String pw) throws SQLException {
		// 로그인 메서드
		
		SummerMemberDTO summerMemberDTO = new SummerMemberDTO();
		
		try {
		String sql = "select * from member where id =? and pw =?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);
		preparedStatement.setString(2, pw);
		resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {
			summerMemberDTO.setMno(resultSet.getInt("mno"));
			summerMemberDTO.setMname(resultSet.getString("mname"));
			summerMemberDTO.setId(resultSet.getString("id"));
			summerMemberDTO.setPw(resultSet.getString("pw"));
			summerMemberDTO.setRegidate(resultSet.getDate("regidate"));
			
			System.out.println("☆ ★ ☆ 로 그 인 성 공 ☆ ★ ☆ ");
			} else {
				System.out.println("~ 로 그 인 실 패 ㅠ . ㅠ ~");
			} // if 종료
	}catch (SQLException e) {
		System.out.println("예외발생 : memberLogin() 메서드를 확인하세요");
		e.printStackTrace();
	} finally {
		resultSet.close();
		preparedStatement.close();
	}// finally 종료
		return summerMemberDTO;
	} //memberLogin 메서드 종료




	public void memberUpdate(String checkpw, Scanner inputStr) throws SQLException{
		// 회원수정
		
		SummerMemberDTO summerMemberDTO = new SummerMemberDTO();
		
		System.out.println(" ☆ ★ 수 정 할 정 보 를 입 력 하 세 요 ★ ☆ ");
		System.out.print("PW ▷ ");
		summerMemberDTO.setPw(inputStr.next());
		System.out.print("Nickname ▷ ");
		summerMemberDTO.setMname(inputStr.next());
		try { 
			String sql = "update member set pw =?, mname =? where pw = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, summerMemberDTO.getPw());
			preparedStatement.setString(2, summerMemberDTO.getMname());
			preparedStatement.setString(3, checkpw);
			
			result = preparedStatement.executeUpdate();
			if (result>0) {
				System.out.println("☆ ★ ☆ 회 원 정 보 수 정 완 료 ☆ ★ ☆ ");
				connection.commit();
			} else {
				System.out.println("~ 수 정 이 되 지 않 았 습 니 다 ㅠ.ㅠ ~ ");
				connection.rollback();
			}// if 종료
			
			
		}catch (SQLException e) {
			System.out.println("예외발생 : memberUpdate() 메서드를 확인하세요");
			e.printStackTrace();
		} finally {
			
			preparedStatement.close();
		}// finally 종료
		
		
		
	}// memberUpadate 메서드 종료




	public void memberInfor(String checkid, Scanner inputStr) throws SQLException {
		// 회원 정보
		
		try {

			String sql = " select mno, mname, id, pw, regidate from member where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, checkid);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
			 SummerMemberDTO  summerMemberDTO = new SummerMemberDTO(); // 빈객체 생성
			 summerMemberDTO.setMno(resultSet.getInt("mno"));
			 summerMemberDTO.setMname(resultSet.getString("mname"));
			 summerMemberDTO.setId(resultSet.getString("id"));
			 summerMemberDTO.setPw(resultSet.getString("pw"));
			 summerMemberDTO.setRegidate(resultSet.getDate("regidate"));
			 
			 System.out.println("* ~ [" + summerMemberDTO.getMname() + " 회원님] 안녕하세요 ~ * ");
			 System.out.println("아 이 디 ▷ " + summerMemberDTO.getId());
			 System.out.println("비 밀 번 호 ▷ " + summerMemberDTO.getPw());
			 System.out.println("가 입 일 ▷ " + summerMemberDTO.getRegidate());
		}else {
			System.out.println("~ 다 시 입 력 해 주 세 요 ㅠ.ㅠ ~");
		} // if 종료
		} catch (SQLException e) {
			System.out.println("예외발생 : memberInfor() 메서드를 확인하세요");
			e.printStackTrace();
			
		} finally {
			resultSet.close();
			preparedStatement.close();
		} // finally 종료
		
		
		
	} // memberInfor 메서드 종료




	public void memberDelete(String delId, String delPw, Scanner inputStr) throws SQLException{
		// 회원 삭제
		
		try {
			String sql = "delete from member where id =?, pw = ?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, delId);
			preparedStatement.setString(2, delPw);
			result = preparedStatement.executeUpdate();
			
			if (result>0) {
				System.out.println(" ☆ ★ ☆ 회 원 탈 퇴 가 완 료 되 었 습 니 다 ☆ ★ ☆ ");
				connection.commit();
			}else {
				System.out.println(" ~ 회 원 탈 퇴 가 되 지 않 았 습 니 다 ㅠ . ㅠ ~ ");
				connection.rollback();
				
			}// if 종료
		}catch (SQLException e) {
			System.out.println(" ~ memberDelete() 메서드 sql 문을 확인해주세요 ㅠ.ㅠ ~");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}// finally 종료
		
	} // memberDelte 메서드 종료




	

}//class 종료
