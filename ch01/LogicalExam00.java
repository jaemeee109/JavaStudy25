package ch01;

import java.util.Scanner;

public class LogicalExam00 {

	public static void main(String[] args) {
		
	
		Scanner input = new Scanner(System.in);
		
		System.out.print("로그인 할 ID를 입력하세요 : " );
		String id = input.nextLine();
		System.out.print("로그인 할 PW를 입력하세요 : ");
		String pw = input.nextLine();
		
		System.out.println("=== 확인 중 ===");
		System.out.println("☆ 회원가입 성공 ☆");
		
		System.out.println("===================================" );
		

	
		
		System.out.print("로그인 할 ID를 입력하세요 : " );
		String loginid = input.nextLine();
		System.out.print("로그인 할 PW를 입력하세요 : ");
		String loginpw = input.nextLine();

		
		if ((id.equals(loginid)) & pw.equals(loginpw)) {
			
			System.out.println("☆ 로그인 성공 ☆");
			
		} else {
			System.out.println("일치하지 않습니다");
			System.out.println("로그인 실패");
		} //if문 종료
		

	} // main 메서드 종료

} // class 종료

