package ch04.PracticeExam;

import java.util.Scanner;

public class CalculaterExam {

	public static void main(String[] args) {
		
		Calculator myCal = new Calculator();
		
		myCal.powerOn();
		
		int x = 40;
		int y = 20;
		int result2 = myCal.minus(x, y);
		System.out.println(x+ "-"+y+"="+result2);
		
		//키보드로 입력받아 곱하기 진행
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("첫번째 숫자를 입력해주세요:");
		int a = input.nextInt();
		System.out.print("두번째 숫자를 입력해주세요:");
		int b = input.nextInt();
		int result3 = myCal.multiply(a, b);
		System.out.println(a+ "x"+b+"="+result3);
		
		myCal.powerOff();
		

				

	}//main method 종료

}//class 종료
