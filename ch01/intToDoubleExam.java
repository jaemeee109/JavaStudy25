package ch01;

public class intToDoubleExam {

	public static void main(String[] args) {
		// int 타입과 float 타입은 같은 32bit를 사용하지만 float이 소수점을 사용하기 때문에 값에 변조가 일어난다.
		// float 보다 큰 double을 사용하여 해결해보자.
		
		int num1 = 99997777 ;
		int num2 = 99997777 ;
		
		double num3 = num2 ; //int 타입 값을 double에 넣음.
		num2 = (int) num3 ; // 위에서 선언한 변수에 값을 다시 넣음.

		System.out.println("num1 : " + num1); 
		System.out.println("num2 : " + num2); 
		System.out.println("num3 : " + num3); 
		
		//double로 다녀온 후에 num값 변경 안됨.
		
		int result = num1 - num2;
		System.out.println("double 로 다녀온 후에 num2 값 변경 됨 : ");
		System.out.println("num1 = num2 : " + result);


	}

}
