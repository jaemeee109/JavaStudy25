package otest250613.service;

import java.sql.SQLException;
import java.util.Scanner;

import otest250613.dao.OtestDAO;
import otest250613.dto.OtestDTO;

public class OtestService {
	
	public OtestDTO otestDTO = new OtestDTO();
	public OtestDAO otestDAO = new OtestDAO();
	

	public void MemberJoin(Scanner inputStr, Scanner inputInt, OtestDTO session) throws SQLException {
		// 회원가입
		
		System.out.print("아이디: ");
		otestDTO.setId(inputStr.next());
		System.out.print("패스워드: ");
		otestDTO.setPw(inputStr.next());
		System.out.print("이름: ");
		otestDTO.setName(inputStr.next());
		System.out.print("이메일: ");
		otestDTO.setEmail(inputStr.next());
		System.out.print("닉네임: ");
		otestDTO.setMname(inputStr.next());
		System.out.print("연락처: ");
		otestDTO.setPno(inputInt.nextInt());

		
		
		OtestDAO otestDAO = new OtestDAO();
		otestDAO.MemberJoin(otestDTO, inputStr, inputInt);
		
	} // MemberJoin 메서드 종료


	public OtestDTO Login(Scanner inputStr, Scanner inputInt, OtestDTO session) throws SQLException{
		// 로그인 
		
		System.out.print("아이디: ");
		String id = inputStr.next();
		System.out.print("패스워드: ");
		String pw = inputStr.next();
		OtestDTO otestDTO = new OtestDTO();
		otestDTO = otestDAO.Login(id,pw,session);
		
		return otestDTO;
		
	} // Login 메서드종료


	public void Update(Scanner inputStr, Scanner inputInt, OtestDTO session) throws SQLException{
		// 회원정보 수정 
		
		System.out.println(" * 본인 확인을 위해 아이디를 입력해주세요 ");
		String checkId = inputStr.next();
		otestDAO.Update(checkId, inputStr, inputInt);
		


	}// Update 메서드 종료


	public void Delete(Scanner inputStr, Scanner inputInt, OtestDTO session) throws SQLException{
		// 회원탈퇴
		
		System.out.println(" * 본인 확인을 위해 비밀번호를 입력해주세요 ");
		String checkPw = inputStr.next();
		
		otestDAO.Delete(checkPw);
		
	}//Delete 메서드 종료


	public void MemberList(OtestDTO session) throws SQLException {
		// 회원 정보 조회
		
		otestDAO.MemberList(session.getId());
		
	}// MemberList 메서드 종료

}// class 종료
