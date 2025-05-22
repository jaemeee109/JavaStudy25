package ch04;

import java.util.Scanner;

public class GradeExam {

	public static void main(String[] args) {
		// Grade 클래스를 호출하여 처리하기
		
		Scanner input = new Scanner(System.in);
		Grade[] grades = null;
		
		String adminid = "admin";
		int adminpw = 000000 ;
		
		System.out.println("=== 학생 성적관리 프로그램 입니다 ===");
		System.out.println("※ 관리자만 사용이 가능합니다 ");
		System.out.print("ID :");
		String id = input.next();
		System.out.print("PW :");		
		int pw = input.nextInt();
		
		if (id.equals(adminid) && (pw==adminpw)){
			
			System.out.println("=== 학생 성적관리 프로그램을 시작합니다 ===");
			System.out.println("성적을 등록할 학생 수를 입력해주세요");
			System.out.print(">>>");
			int count = input.nextInt();
			grades = new Grade[count];// 입력받은 만큼 배열 생성
			boolean run = true;
			while (run) {
				System.out.println("------------------------");
				System.out.println(" 1. 성적등록");
				System.out.println(" 2. 성적조회");
				System.out.println(" 3. 성적수정");
				System.out.println(" 4. 성적삭제");
				System.out.println(" 5. 프로그램종료");
				System.out.print(">>>");
				int select = input.nextInt();
				switch (select) {

				case 1:
					Grade student1 = new Grade();//객체생성
					for (int i = 0; i<grades.length; i++) {
					grades[i] = new Grade().studentAdd(input);//생성된 객체 메서드 호출 및 실행
					}// for종료
					break;
				case 2:
					Grade student2 = new Grade();//객체생성
					student2.studentScore(grades);//생성된 객체 메서드 호출 및 실행

					break;
				case 3:
					Grade student3 = new Grade();//객체생성
					for (int i = 0;  i< grades.length; i++) {
					grades[i] = new Grade().studentUpdate(input);
					}//for 종료
					break;
				case 4:
					Grade student4 = new Grade();//객체생성
					student4.studentDel();//생성된 객체 메서드 호출 및 실행
					break;
				case 5:
					System.out.println("프로그램을 종료합니다");
					break;
				default:
					System.out.println("잘못입력하셨습니다");
					run = false;

				}// select switch 종료
			}// while run 종료
			
			
			
		}//if종료
		else {
			System.out.println("※프로그램 사용이 불가능합니다※");
			
		}//else 종료
			
		
		
	}//main method 종료

}//class 종료
