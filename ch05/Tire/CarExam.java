package ch05.Tire;

public class CarExam {

	public static void main(String[] args) {
	
		Car car = new Car ();
		
		for (int i = 1; i<=10 ; i++) {
			int problemLocation = car.run();
			switch (problemLocation) {
			
			case 1 :
				System.out.println("앞왼쪽 고양이 타이어로 교체");
				car.frontLeftTire = new CatTire("앞왼쪽", 15);
				break;
			case 2 :
				System.out.println("앞오른쪽 고양이 타이어로 교체");
				car.frontRightTire = new CatTire("앞오른쪽", 20);
				break;
			case 3 :
				System.out.println("뒤왼쪽 강아지 타이어로 교체");
				car.backLeftTire = new CatTire("뒤왼쪽", 12);
				break;
			case 4 :
				System.out.println("앞왼쪽 고양이 타이어로 교체");
				car.backRightTire = new CatTire("뒤오른쪽", 17);
				break;
				
			}//switch 종료
			//마일리지 소모후 자동교체되는 코드
			System.out.println("--------------------------");
			//1회전 종료에 대한 구분선
		}//for종료

	}//main method 종료

}//class 종료
