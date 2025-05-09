package ch01;

import java.util.Scanner;

public class LogicalExam {

	public static void main(String[] args) {
		
		String loginid = "wawa109";
		String loginpw = "whitecat";
	
		Scanner input = new Scanner(System.in);
		
		System.out.print("ID를 입력하세요 : ");
		String id = input.nextLine();
		
		System.out.print("PW를 입력하세요 : ");
		String pw = input.nextLine();
		System.out.println("=== 확인 중 ===");
	
		if ((loginid.equals(id))& loginpw.equals(pw)) {
			
			System.out.println("☆ 로그인 성공 ☆");
			
		} else {
			System.out.println("일치하지 않습니다");
			System.out.println("로그인 실패");
		} //if문 종료
		

	} // main 메서드 종료

} // class 종료
