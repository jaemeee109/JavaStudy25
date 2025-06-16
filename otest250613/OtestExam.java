package otest250613;

import java.sql.SQLException;
import java.util.Scanner;

import otest250613.dto.OtestDTO;
import otest250613.service.BoardService;
import otest250613.service.OtestService;

public class OtestExam {
	
	public static Scanner inputStr = new Scanner(System.in);
	public static Scanner inputInt = new Scanner(System.in);
	public static OtestService otestService = new OtestService();
	public static BoardService boardService = new BoardService();
	public static OtestDTO session = null;
	

	public static void main(String[] args) throws SQLException {
		
		boolean run = true;
		while (run) {
			
			System.out.println(" * 프로그램에 오신것을 환영합니다 ");
			System.out.println(" 1. 회원가입 ");
			System.out.println(" 2. 로그인 ");
			System.out.println(" 3. 회원정보수정 ");
			System.out.println(" 4. 회원탈퇴 ");
			System.out.println(" 5. 회원정보조회");
			System.out.println(" 6. 게시판");
			System.out.println(" 7. 종료");
			System.out.print(">>>");
			String select = inputStr.next();
			
			switch (select) {
			
			case "1" :
				System.out.println(" * 회원가입을 시작합니다 ");
				otestService.MemberJoin(inputStr,inputInt, session);
				
				break;
			case "2" :
				System.out.println(" * 로그인을 시작합니다 ");
				session = otestService.Login(inputStr,inputInt,session);
				if (session != null && session.getId() != null) {
					
				}
				break;
			case "3" :
				if (session != null && session.getId() != null) {
				System.out.println(" * 회원 정보 수정을 시작합니다 ");
				otestService.Update (inputStr,inputInt,session);
				} else {
					System.out.println("* 로그인한 사용자만 이용이 가능합니다");
				}
					
				break;
			case "4" :
				if (session != null && session.getId() != null) {
				System.out.println(" * 회원 탈퇴를 시작합니다 ");
				otestService.Delete(inputStr, inputInt, session);
				}else {
					System.out.println("* 로그인한 사용자만 이용이 가능합니다");
				}
				break;
			case "5" :
				if (session != null && session.getId() != null) {
					System.out.println(" * 회원 정보 조회를 시작합니다 ");
					otestService.MemberList(session);
				}else {
					System.out.println("* 로그인한 사용자만 이용이 가능합니다");
				}
				break;
			case "6" :
				if (session != null && session.getId() != null) {
					System.out.println(" * 게시판으로 안내합니다 ");
					boardService.SubMenu(inputStr,inputInt, session);
				}else {
					System.out.println("* 로그인한 사용자만 이용이 가능합니다");
				}
				break;
			case "7" : 
				System.out.println(" * 프로그램을 종료합니다 ");
				run = false;
				break;
			default :
				System.out.println(" * 잘못 입력하셨습니다 다시 입력해주세요 ");
				break;
			
			
			
			}// switch 종료
			
		}// while 종료
		

	} // 메인메서드 종료

} // class 종료
