package ch04.PracticeExam;

import java.util.Scanner;

import javax.security.sasl.SaslClient;

public class Car {
	
	// 필드
	// 고유 데이터
	public String company ; //제작회사
	public String model ;
	public String color ;
	public String oilType ;
	public int maxSpeed ;
	public int minSpeed ;
	

	
	// 상태값 (변동가능)
	public int speed ;
	public int rpm ;
	public int oil ;
	
	// 부품 -> 다른 클래스를 생성하여 연결
	
	// public Body body ;
	// public Engine engine;
	// public Tire tire ;
	
	// 부품 필드 사용법
	// Car myCar = new Car(); -> 객체 생성 (인스턴스)
	// myCar.maxSpeed = 300; -> 객체에 있는 maxSpeed에 300 정수를 넣음
	// ------------------------------------------
	
	// 기본 생성자 : 생략 가능 (객체 생성할 때 사용되는 메서드 : 클래스 이름과 같게 한다) 
	
	public Car() {
		
		speed = 0;
		rpm =  2900;
		oil = 100;
		oilType = "Gasoline";
		maxSpeed = 210;
		minSpeed = 30;
		

		
	}//  Car method 종료
	//객체가 생성되면서 변수에 값이 저장됨
	
	//사용자 지정 생성자 : 개발자가 응용하는 기법
	// 사용자 지정 생성자가 만들어지면 기본 생성자는 자동으로 생성되지 않는다
	
	public Car(String company, String model, String color) {
		
		this.company = company;
		this.model = model;
		this.color = color;
		
		
		
	}//Car myCar = new Car ("차종","모델명","색상");
	
	// 메서드 (객체가 수행해야 되는 동작)
	// C (시동시작) R (주행상태, 차량상태)  U (가속, 감속, 주차) D (시동종료)
	
	public void start() {
		
		System.out.println("※"+ this.model + "가(이) 출발합니다");
		System.out.println("현재 속도: " + this.speed);
		System.out.println("현재 rpm: " + this.rpm);
		System.out.println("현재 주유량: "+ this.oil);
		System.out.println("주유타입 : " + this.oilType);
		
		
	}//start method 종료
	
	public void carRun () {
		
		Scanner input = new Scanner(System.in);
		System.out.println("※" + this.model +"가(이) 주행합니다");
		System.out.println("1. 엑셀");
		System.out.println("2. 브레이크");
		System.out.println("3. 주유하기");
		System.out.print(">>>");
		int choice = input.nextInt();

			boolean carRun =  true;
			while (carRun) {
				switch (choice) {

				case 1:
					System.out.println("===== 가속을 진행합니다 =====");
					
					
					this.speed += 30;
					
					 if (this.speed >= this.maxSpeed) {
						 
						 this.speed = this.maxSpeed;
						 
					 carRun = false;
					 
					 }//if종료
					 
					 System.out.println("현재 속도는 " + this.speed + "km/h 입니다");

					
					 break;

				case 2:
					System.out.println("===== 감속을 진행합니다 =====");
					this.speed += -10;
					if (this.speed <= this.minSpeed) {
						this.speed = this.minSpeed;
						
						carRun = false;
						
					} //if종료
					
					 System.out.println("현재 속도는 " + this.speed + "km/h 입니다");

					

					break;

				case 3:
					System.out.println("===== 주유를 진행합니다 =====");
					System.out.println("===== 주유가 완료되었습니다 =====");
					carRun = false;
					break;

				default:
					System.out.println("※ 시동이 꺼집니다");

				}// switch (choice) 종료
			}
		
	}//run method 종료
	

}//class 종료
