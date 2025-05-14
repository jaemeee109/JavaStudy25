package ch02;

import java.util.Scanner;

public class IfExam {

	public static void main(String[] args) {
		// if (조건문) { 실행문 }
				// 조건문 true 가 처리되면 중괄호 안쪽이 실행된다
				// 조건문에 false가 처리되면 중괄호 안쪽이 실행되지 않는다
				
				Scanner input = new  Scanner(System.in);
				// 키보드로 입력 받을 수 있는 객체를 생성하여 input 변수에 연결
				
				System.out.println("===== 프로그램을 시작합니다 =====");
				System.out.println("");
			    System.out.println("- 귀하의 성함을 입력해주세요");
				System.out.print("   >>>>> ");
				String name = input.next(); //키보드로 입력받은 이름을 name 변수에 녛음
				

				System.out.println("- 귀하의 국어 점수를 입력해주세요");
				System.out.print("   >>>>> ");
				int score = input.nextInt();//키보드로 입력받는 정수를 score에 넣음
				if (score > 0 && score <= 100) {
					System.out.println("점수가 검증 되었습니다");
				}else System.out.println("점수를 다시 입력해주세요");
				System.out.println("- 귀하의 수학 점수를 입력해주세요");
				System.out.print("   >>>>> ");
				int score2 = input.nextInt();
				if (score2 >0 && score <=100) {
					System.out.println("점수가 검증 되었습니다");
				}else
					System.out.println("점수를 다시 입력해주세요");
				System.out.println("- 귀하의 영어 점수를 입력해주세요");
				System.out.print("   >>>>> ");
				int score3 = input.nextInt();
				if (score3 >0 && score <=100) { 
					System.out.println("점수가 검증 되었습니다");
				}else
					System.out.println("점수가 검증 되었습니다");

				double avg = (score+score2+score3)/3;
				
				System.out.println(name+" 님의 평균 점수는 " + avg + "입니다");
				
				System.out.print("평균점수에 따른 등급을 안내 받으시겠습니까?");
				
				String answer = input.next();
				if (answer.equalsIgnoreCase("yes")) {
					System.out.println("===== " + name + " 님의 평균 점수에 따른 등급 안내 ===== ");
				}else System.out.println("다시 입력해주세요");
				
				if (avg > 0 && avg<=100) {
							if (avg >= 90) {//score 변수에 입력된 값이 90 이상이냐?
								System.out.println(name + " 님이 입력하신 점수는 평균 90점 이상 입니다 ");
								System.out.println(name + " 님의 점수는 " + avg + "점 이므로 등급 (A) 입니다");
							} else if (avg / 3 >= 80) {
								System.out.println(name + "님이 입력하신 점수는 평균 80~89점 입니다 ");
								System.out.println(name + " 님의 점수는 " + avg + "점 이므로 등급 (B) 입니다");
							} else if (avg >= 70) {
								System.out.println(name + "님이 입력하신 점수는 평균 70~79점 입니다 ");
								System.out.println(name + " 님의 점수는 " + avg+ "점 이므로 등급 (C) 입니다");
							} else if (avg >= 60) {
								System.out.println(name + "님이 입력하신 점수는 평균 60~69점 입니다 ");
								System.out.println(name + " 님의 점수는 " + avg + "점 이므로 등급 (D) 입니다");
							} else {System.out.println(name + " 님이 입력하신 점수는 평균 " + avg + "점 이므로 등급 (F) 입니다");
							} //정상값이 입력 되었을 때 실행문
						} else System.out.println( name + " 님이 입력하신 평균 점수는 A~F등급 내에 해당되지 않습니다");
						
						System.out.println("===== 프로그램이 종료되었습니다 =====");
						


		

	}//main 메서드 종료 →  변수가 사라짐 (input, name, score)
	
}//class 종료 → 메서드가 사라짐 → 프로그램 종료

