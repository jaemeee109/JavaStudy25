package ch01;

public class CompareExam {

	public static void main(String[] args) {
		// 비교 연산자는 동등비교와 크기비교가 있음
		// 동등비교 : == (같냐?), !=(다르냐?)
		// 크기비교 : > (초과,같냐?), >=(이상,크거나같냐?),<(미만,작냐?),<=(이하, 작거나 같냐?)
		
		int num1 = 97;
		int num2 = 91;
		boolean result1 = (num1 == num2) ; // false
		boolean result2 = (num1 != num2) ; // true
		boolean result3 = (num1 > num2) ; // true
		boolean result4 = (num1 >= num2) ; // true
		boolean result5 = (num1 < num2) ; // false
		boolean result6 = (num1 <= num2) ; // false
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
		System.out.println(result6);
		// boolean은 true, false 값을 가질 수 있다.
		
		System.out.println("============================================");
		
		char char1 = '9'; // 유니코드 9는 57
		char char2 = 9; // 얘는 그냥 숫자 9
		boolean result7 = (char1 == char2); 
		System.out.println(result7); // 57 과 9는 다르기 때문에 false
		
		char char3 = 'J';
		char char4 = 'j';
		boolean result8 = (char3 == char4) ;
		System.out.println(result8); // J는 74, j는 106 false
		
		System.out.println("============================================");
		
		int v1 = 31 ;
		double v2 = 31.0 ;
		System.out.println( v1 == v2 ); // 자동타입변환으로 int가 31.0이 되어 double과 매칭됨 (큰 값으로 타입을 매칭)
		
		System.out.println("============================================");
		
		double v3 = 12.1 ;
		float v4 = 12.1F ;
		System.out.println(v3==v4);//false 소수점이 근사값이라서 정확히 떨어지지 않음
		System.out.println("강제 타입 변환 해주기↓");

		System.out.println((float)v3 == v4); // v3을 float으로 강제 변환
		System.out.println(v3 == (double)v4); // v4를 double로 변환 자동변환이랑 똑같음
		
		System.out.println("정수 타입으로 강제 변환해주기 ↓");
		
		System.out.println((int)v3 == (int)v4); // 12 == 12
		System.out.println((int)(v3*100) == (int)(v4*100)); // 1210 == 1210
		System.out.println(v3); //12.1
		System.out.println(v4); //12.1
		
		
		
	}

}
