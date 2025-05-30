package ch04.PracticeExam;

import java.util.Scanner;

public class CarExam {

	public static void main(String[] args) {
		// 자동차 주실행 프로그램
		
		Scanner input = new Scanner(System.in);
		System.out.println("===== 차량정보 입력 =====");
		Car myCar = new Car(); // 기본생성자로 객체 생성
		// speed, rpm, oil, oilType 은 기본값으로 생성
		System.out.print("제조회사: ");
		myCar.company = input.next();
		System.out.print("모델명: ");
		myCar.model = input.next();
		System.out.print("색상: ");
		myCar.color = input.next();
		
		boolean run = true;
		while (run){
			System.out.println("1. 차량 정보확인");
			System.out.println("2. 차량 시동걸기");
			System.out.println("3. 차량 주행시작");
			System.out.println("4. 차량 주행종료");
			System.out.print(">>>");
			String select = input.next();
			switch (select) {

			case "1":
				System.out.println("차량회사: " + myCar.company);
				System.out.println("모델명: " + myCar.model);
				System.out.println("색상: " + myCar.color);

				break;

			case "2":
				System.out.println("===== 시동이 걸렸습니다 =====");
				myCar.start(); //start 메서드 불러오기
				break;

			case "3":
				myCar.carRun();
				
				break;

			case "4":
				System.out.println("===== 차량 주행을 정지합니다 =====");
				System.out.println("===== 시동이 꺼집니다 =====");
				run =false;
				
				break;

			default:
				System.out.println(" 차량 운행이 종료됩니다 ");
				run = false;

			}// switch select 종료
		}

	}//main method 종료
}//class 종료
