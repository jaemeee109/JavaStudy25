package ch02;

import java.io.InputStream;
import java.util.Scanner;

public class MethodExam00 {

	public static void main(String[] args) {

		Scanner inputStr = new Scanner(System.in);
		String user1name = "홍길동";
		String user1pw = "12345678";
		boolean run = true;
		
		while (run) {//
			System.out.println("=== OOO 아카데미 홈페이지 ===");
			System.out.print("성함을 입력해주세요 >>> ");
			String userid = inputStr.next();
			System.out.print("학번을 입력해주세요 >>> ");
			String userpw = inputStr.next();
			if (userid.equals(user1name) && userpw.equals(user1pw)) {
			 Grade(userid);
			}else {
				System.out.println("로그인이 실패했습니다");
			}//else 종료
		
		} // while종료
	

	}//main method종료

	 static void Grade(String userid) {
		
		 
		 Scanner inputStr2 = new Scanner(System.in);
		 
		 int kor = (int) (Math.random()*100)+1;
			int math = (int)(Math.random()*100)+1;
			int eng = (int)(Math.random()*100)+1;
			int total = kor + math + eng;
			double avg = total/3;
			boolean grademenu =true;
			
		while (grademenu) {
			System.out.println("=======================");
			System.out.println("원하시는 메뉴를 입력하세요");
			System.out.println("-----------------------");
			System.out.println(" * 성적확인");
			System.out.println(" * 등급확인");
			System.out.println(" * 로그아웃");
			System.out.println("-----------------------");
			System.out.print(">>>>> ");
			String menu = inputStr2.next();
		switch (menu) {
			case "성적확인","성적":
				System.out.println("=======================");
				System.out.println(userid + "님의 성적입니다");
				System.out.println("-----------------------");
				System.out.println("국어 " + kor + "점");
				System.out.println("수학 " + math + "점");
				System.out.println("영어 " + eng + "점");
				System.out.println("총점 " + total +"점");
				System.out.println("평균 " + avg + "점");
				System.out.println("-----------------------");
			break;//성적확인 case종료
			case "등급확인","등급":
				System.out.println("=======================");
				System.out.println(userid + "님의 전과목 합산 등급입니다");
				System.out.println("-----------------------");
					if (avg <= 100 && avg > 95) {
						System.out.println(" : A");
						System.out.println("-----------------------");
				} else if (avg < 95 && avg >= 90) {
						System.out.println(" : B");
						System.out.println("-----------------------");
				} else if (avg < 90 && avg >= 80) {
						System.out.println(" : C");
						System.out.println("-----------------------");
				} else if (avg < 80 && avg >= 70) {
						System.out.println(" : D");
						System.out.println("-----------------------");
				} else if (avg < 70) {
						System.out.println(" : F");
						System.out.println("-----------------------");
				} else {
						System.out.println("등급 조회가 불가능합니다");
				}
			break;
			case "로그아웃":
				System.out.println("====== 로그아웃 됩니다 ======");
				grademenu = false;
			break; //로그아웃 break
							
			default:
				System.out.println("잘못 입력하셨습니다");
			break;
		}//switch종료
		}//while종료
			
	 }//부메서드종료
}//class종료

