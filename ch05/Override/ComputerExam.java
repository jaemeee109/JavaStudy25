package ch05.Override;

public class ComputerExam {

	public static void main(String[] args) {
		int r = 10; // r 값을 실수 10으로 넣음
		
		Calculator cal = new  Calculator(); //3.14159 값으로 계산
		System.out.println("원면적: " + cal.areaCircle(r));
		System.out.println();// 부모 객체에 대한 원면적 계산값
		
		Computer com = new Computer(); //Math.PI 값으로 메소드를 재정의했음
		System.out.println("원면적: " + com.areaCircle(r));
		System.out.println();
		

	}//main method 종료

} // class 종료
