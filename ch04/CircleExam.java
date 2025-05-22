package ch04;

public class CircleExam {

	public static void main(String[] args) {
		// 주 실행 메서드
		// Circle 클래스를 객체로 받아서 동작하는 메서드
		
		Circle circle = new Circle (); // 생성자를 통해 객체를 생성
		// 객체는 circle이라는 변수와 연결한다
		
		circle.name="신짱구"; //name 필드에 String 값을 넣음
		circle.radius = 20; // radius 필드에 int 값을 넣음
		
		double result = circle.getArea(); //Circle 객체의 getArea 메서드 실행
		
		System.out.println("반지름이 " + circle.radius+"인 원의 넓이는 : "+ (int)result);
		System.out.println("작성자: "+circle.name);
		
		

		
		
	}//main method 종료

} // class 종료
