package ch01;

public class intToFloatExam {

	public static void main(String[] args) {
		// float은 32bit로 되어있는 부동소수점 연산에 사용 됨.
		// 정수타입을 실수타입으로 변환 할 때 손실이 발생한다.
		// int (32bit) = float (32bit) 같은 32bit지만 float은 소수점이 반영되어 범위가 다름.
		
		int num1 = 99992222 ;
		int num2 = 99992222 ;
		
		float num3 = num2 ; //int 타입 값을 float에 넣음.
		num2 = (int) num3 ; // 위에서 선언한 변수에 값을 다시 넣음.
		
		System.out.println("num1 : " + num1); //99992222
		System.out.println("num2 : " + num2); //99992224
		System.out.println("num3 : " + num3); 
		//num3 : 9.9992224E7 지수형식으로 나옴 E는 앞에 숫자를 부동 소수점 처리. 숫자는 소수점 위치를 표현
		
		int result = num1 - num2;
		System.out.println("float으로 다녀온 후에 num2 값 변경 됨 : ");
		System.out.println("num1 = num2 : " + result);

		// 같은 숫자였지만 float으로 변형된 후에 값이 달라짐
		
	}

}
