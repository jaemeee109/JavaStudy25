package otest250613.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import otest250613.dto.OtestDTO;

public class OtestDAO {
	
	// 필드
	
	public OtestDTO otestDTO = new OtestDTO();
	public Connection connection = null;
	public Statement statement = null;
	public PreparedStatement preparedStatement = null;
	public ResultSet resultSet = null;
	public int result = 0;
	
	//	기본생성자
	public OtestDAO() {
		
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
			
		}
		
	} // 기본생성자 종료

	public  void MemberJoin(OtestDTO otestDTO, Scanner inputStr, Scanner inputInt) throws SQLException{
		// 회원가입
		try { 
			String sql = "insert into member (mno, id, pw, name, email, mname, pno, mdate)" + "values (member_seq.nextval,?,?,?,?,?,?,sysdate)" ;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, otestDTO.getId());
			preparedStatement.setString(2, otestDTO.getPw());
			preparedStatement.setString(3, otestDTO.getName());
			preparedStatement.setString(4, otestDTO.getEmail());
			preparedStatement.setString(5, otestDTO.getMname());
			preparedStatement.setInt(6, otestDTO.getPno());
			// System.out.println("쿼리확인" + sql); // 테스트코드
			result = preparedStatement.executeUpdate();
			
			if (result>0) {
				System.out.println(" * 회원가입이 완료 되었습니다 ");
				connection.commit();
			}else {
				System.out.println(" * 회원가입에 실패 했습니다 ");
				connection.rollback();
				
			}// if종료
		} catch (SQLException e) {
			System.out.println(" memberJoin 쿼리문을 확인하세요 ");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}//finally 종료
		
	} // MemberJoin 메서드종료

	public OtestDTO Login(String id, String pw, OtestDTO session) throws SQLException {
		// 로그인 메서드
		OtestDTO otestDTO = new OtestDTO();
		
		try {
			String sql = "select * from member where id =? and pw = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pw);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				otestDTO.setMno(resultSet.getInt("mno"));
				otestDTO.setId(resultSet.getString("id"));
				otestDTO.setPw(resultSet.getString("pw"));
				otestDTO.setName(resultSet.getString("name"));
				otestDTO.setMname(resultSet.getString("mname"));
				otestDTO.setPno(resultSet.getInt("pno"));
				otestDTO.setMdate(resultSet.getDate("mdate"));
				
				System.out.println(" * 로그인 완료 ");
			}else {
				System.out.println(" * 로그인 실패");
			}// if 종료
		}catch (SQLException e) {
			System.out.println(" Login 쿼리문을 확인하세요 ");
			e.printStackTrace();
		} finally {
			resultSet.close();
			preparedStatement.close();
			
		}//finally 종료
		
		return otestDTO;
	} // Login 메서드 종료


	public void Update(String checkId, Scanner inputStr, Scanner inputInt) throws SQLException {
		// 회원정보 수정
		
		OtestDTO otestDTO = new OtestDTO();
		System.out.println(" * 수정 할 정보를 입력하세요 ");
		System.out.println(" - 아이디와 이름은 변경이 불가능합니다 ");
		System.out.print(" 닉네임 : ");
		otestDTO.setMname(inputStr.next());
		System.out.print(" 비밀번호 : ");
		otestDTO.setPw(inputStr.next());
		System.out.print(" 연락처 : ");
		otestDTO.setPno(inputInt.nextInt());
		System.out.print(" 이메일 : ");
		otestDTO.setEmail(inputStr.next());
		
		try {
			String sql = "update member set pw =?, email =?, mname =?, pno =? where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, otestDTO.getPw());
			preparedStatement.setString(2, otestDTO.getEmail());
			preparedStatement.setString(3, otestDTO.getMname());
			preparedStatement.setInt(4, otestDTO.getPno());
			preparedStatement.setString(5, checkId);
			result = preparedStatement.executeUpdate();
			
			if (result>0) {
				System.out.println(" * 회원 정보 수정 완료 ");
				connection.commit();
			}else {
				System.out.println(" * 회원 정보 수정 실패 ");
				connection.rollback();
			} //if 종료
		}catch (SQLException e) {
			System.out.println(" Update 쿼리문을 확인하세요");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}// finally 종료


	} // Update 메서드 종료

	public  void Delete(String checkPw) throws SQLException {
		// 회원탈퇴
		
		try { 
			String sql = "delete from member where pw = ? " ;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, checkPw);
			result = preparedStatement.executeUpdate();
			
			if (result>0) {
				System.out.println(" * 회원 탈퇴가 완료 되었습니다");
				connection.commit();
			}else {
				System.out.println(" * 회원 탈퇴에 실패 했습니다 ");
				connection.rollback();
			} // if 종료
			
		}catch (SQLException e) {
			System.out.println("Delete 쿼리문을 확인하세요");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}//finally 종료
		
	} // Delete 메서드 종료

	public void MemberList(String id) throws SQLException {
		// 회원 정보 조회
		OtestDTO otesDTO = new OtestDTO();
		if (!"master".equals(id)) {
			System.out.println(" * 관리자만 접근이 가능합니다 ");
			return;
		}
		try {
			String sql = "select mno, id, name, email, mname, pno, mdate from member order by mno asc";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				System.out.println("-------------------------------------------");
				System.out.println("회원번호: "+ resultSet.getInt("mno"));
				System.out.println("아이디: " + resultSet.getString("id"));
				System.out.println("이름: " + resultSet.getString("name"));
				System.out.println("닉네임: " + resultSet.getString("mname"));
				System.out.println("이메일: " +resultSet.getString("email"));
				System.out.println("연락처: " + resultSet.getString("pno"));
				System.out.println("가입일: " + resultSet.getDate("mdate"));
				System.out.println("-------------------------------------------");
				
			}// while 종료
		} catch (SQLException e) {
			System.out.println(" MemberList 쿼리문을 확인하세요 ");
			e.printStackTrace();
			System.exit(0);
		}finally {
			resultSet.close();
			statement.close();
		}// finally 종료
		
		
		
		
	} // MemberList 메서드 종료
} // class 종료









