package ch01;

public class promotionExam {

	public static void main(String[] args) {
		// 자동 타입 변환 연습
		// : 작은 타입 값을 손실 없이 큰 타입 값으로 변환 한다.
		// byte (1byte : 8bit)
		// short (2byte : 16bit) & char (유니코드용:문자표현)
		// int (4byte : 32bit)
		// long (8byte : 64bit) // 접미사 L
		// float (4byte : 32bit) // 실수형 접미사 f 
		// double (8byte : 64bit) 
		
		byte byteValue = 8 ; // byte 타입의 변수에 8 을 넣음.
		int intValue = byteValue ; // 자동 타입 변환
		
		System.out.println("자동타입된 int " + intValue);
		
		char charValue = '하';
		intValue = charValue ;
		System.out.println("자동타입된 int " + intValue);
		// 10진법 코드로 변환됨
		
		intValue = 560;
		long longValue = intValue ;
		System.out.println("자동타입된 long : " + longValue);
		//작은걸 큰 그릇에 담을 때는 무리가 없음
		
		double doubleValue = intValue ;
		System.out.println("자동타입된 double : " + doubleValue);
		// 출력값에 소수점이 표기 됨
 
	}

}
