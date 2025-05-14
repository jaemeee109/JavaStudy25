package ch02;

import java.util.Scanner;

public class IfExam03 {

	public static void main(String[] args) {
		// 중첩 if
	
		int score = (int)(Math.random()*100) + 1 ;
		//1~100까지 랜덤숫자 
		
		System.out.println("현재 점수는 : " + score);
		
		String grade ; //  객체 생성
		if (score >=90) {
			if(score > 95 || score <=100) {
				grade = "A+" ; // 점수가 90이상이면 A, 95초과 100이하이면 A+
		} else {
			grade = "A" ;
		}// 1 if 종료
		}else {
			if(score <90 || score > 60) {
			grade = "B~D";
			} else {
				grade = "F";
			}// 중첩else 종료
		}//else 종료
		System.out.println("학점 : " + grade);
		
		//if 로 홀짝 계산하기
		Scanner abc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		int num = abc.nextInt();
		
		if  (num % 2 == 0) {
			System.out.println("짝수 입니다");
		}else {
			System.out.println("홀수 입니다");
		}
		System.out.println("프로그램을 종료합니다");
		
		
		
	}// main 종료
}//class 종료
			
			
	


