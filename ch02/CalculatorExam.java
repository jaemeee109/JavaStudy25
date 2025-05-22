package ch02;

import java.util.Scanner;

public class CalculatorExam {

	public static void main(String[] args) {
		// 계산기 프로그램 만들기
		//입력받기 : 숫자 > 연산자 > 숫자
		
		int x1 =0, x2 =0, x3=0, x4=0, x5=0;
		//변수 5개 생성
		boolean run = true, run2 = true;
		//while 사용하기위해 boolean 
		
		String y1 = "연산기호";//정답표시용
		Scanner scInt = new Scanner(System.in);
		
		while (run) {
			if (x1 == 0) {
				System.out.print("숫자를 입력해주세요 >>> ");
				x1 = scInt.nextInt();

			} //if 종료
			
			System.out.println("부호를 선택해주세요");
			System.out.println("1. + (더하기)");
			System.out.println("2. - (빼기)");
			System.out.println("3. * (곱하기)");
			System.out.println("4. / (나누기)");
			System.out.print("숫자를 입력해주세요 >>> ");
			x2 = scInt.nextInt();
			
			System.out.print("숫자를 입력해주세요 >>> ");
			x3 = scInt.nextInt();
			
			run2 = true;
			switch (x2) {
			case 1:
				x4 = Plus(x1, x3);
				y1 = "+";
				break;
			case 2:
				x4 = Minus(x1, x3);
				y1 = "-";
				break;
			case 3:
				x4 = Time(x1, x3);
				y1 = " × ";
				break;
			case 4:
				x4 = Divide(x1, x3);
				y1 = "÷";
				break;
			//default 생략

			}//switch x2 종료
			System.out.println("계산결과 : " + x1 + "" + y1 + "" + x3 + " = " + x4);
			System.out.println("==========================");
			while (run2) {
				if (x4 != 0) { // ========================run2 if랑 else수정하기
					System.out.println("1. 종료");
					System.out.println("2. 다시");
					System.out.println("3. 이어서");
					System.out.print(">>> ");
					x4 = scInt.nextInt();
				} else {
					System.out.println("1. 종료");
					System.out.println("2. 다시");
					System.out.println("3. 이어서");
					System.out.print(">>> ");
					x5 = scInt.nextInt();
				} //if 종료
				switch (x5) {
				case 2:
					x1 = 0;
					x2 = 0;
					x3 = 0;
					run2 = false;
					break; // case2 종료
				case 3:
					x1 = x4;
					x2 = 0;
					x3 = 0;
					run2 = false;
					break;// case 3 종료
				case 1:
					run = false;
					break; //case1종료
				default:
					System.out.println("숫자를 잘못 입력하셨습니다");

				}//switch x5종료
			}//while(run2)종료
		}//while(run)종료
		
				

	}//main method 종료

	    static int Divide(int x1, int x3) {
		// 나누기 
	    	int x4 = 0;
	    	x4 = x1 / x3;
		return x4;
	}//나누기 메서드 종료

	static int Time(int x1, int x3) {
		// 곱하기 
		   int x4 = 0;
		   x4 = x1 * x3;
		return x4;
	}//곱하기 메서드 종료

	static int Minus(int x1, int x3) {
		// 마이너스 
		  int x4 = 0;
		  x4 = x1 - x3;
		return x4;
	}//마이너스 메서드 종료

	static int Plus(int x1, int x3) {
		// 플러스 
		 int x4 =0;
		 x4= x1 + x3;
		return x4;
	}//플러스 메서드 종료

}//class 종료
