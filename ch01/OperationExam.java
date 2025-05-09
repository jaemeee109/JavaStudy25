package ch01;

public class OperationExam {

	public static void main(String[] args) {
		// 연산자는 프로그램에서 데이터를 처리하여 결과를 산출
		// 연산자는 +,-,+,/,% ( 4칙연산 + 나머지 계산)
		// 피연산자는 변수, 값을 말한다.
		
		// 단항 연산 ( 변수가 1개)
		
		int x = 100 ;
		x++ ; // 값을 넣지 않아도 ++은 1씩 증가 ( x = x + 1이라는 뜻이 됨)
		System.out.println("100에 ++ 단항연산 결과 : " + x);

		x-- ; // x= x-1, 위에서 이미 101이 되었기 때문에 101-1 = 100이 됨
		System.out.println("100에 -- 단항연산 결과 : " + x);
		
		// 이항 연산 (변수가 2개인 것)
		
		int y = 270 ;
		int result = x + y ;
		// x = 100, y = 270 이기 때문에 result 에는 370이 들어감
		
		System.out.println(" x + y = " + result);
		
		// 삼항 연산 ( 항이 3개인 것)
		
		boolean result1 = (result>500) ? true : false ;
		
		System.out.println("result >  500 의 결과 : " + result1);
		
		String result2 = (result > 500) ? "맞다" : "틀리다" ;
		
		System.out.println("result > 500 의 결과 : " + result2);
		
		int x1 = 9*3 ;
		int x2 = 9/3 ;
		
		System.out.println(" 9 * 3 의 결과는 : " + x1);
		System.out.println(" 9 / 3 의 결과는 : " + x2);
		
		int xx1 = 9%3 ;
		System.out.println("  9를 3으로 나눈 값의 나머지 : " + xx1);
		int xx2 = 9%2 ;
		System.out.println(" 9를 2로 나눈 값의 나머지 : " + xx2);
		
		// 3항 연산자 사용 홀짝 계산
		
		boolean resultx = (result>30) ? true : false ;
		System.out.println("result > 30 결과 : " + resultx);
		
		int happy = 45 ;
		int sad = happy%3;
		String resultemotion = (sad == 0) ? "맞다" : "아니다" ;
		System.out.println(" happy와 sad는 감정이 맞다 vs 아니다 : " + resultemotion);
		
		
	
		
		// 7의 배수
		
		int lucky = 49 ;
		int clover = lucky%7;
		String resultlucky = (clover == 0) ? "7의배수" : "4의배수" ;
		System.out.println(" 49는 7의 배수 vs 4의 배수 : " + resultlucky);
		
		// 증감연산자 TEST
		System.out.println("==================증감연산자 위치에 따른 결과==================");
		
		int a = 56;
		a++; // 56 + 1 이 되어서 57
		++a; // 57 + 1 이 되어서 58
		System.out.println(" 56 -> a++ -> ++a 의 결과 : " + a);
		
		int b = 91;
		b-- ;
		System.out.println("b-- 의 결과 값 : " + b);
		--b ;
		System.out.println("--b 의 결과 값 : " + b);
		
		int c ;
		c = a++;
		System.out.println("a의 결과 : " + a); //59
		System.out.println("c의 결과 : " + c); // c에 58 이 먼저 들어간다음에 a++이 됨
				
		c= ++a;
		System.out.println("a의 결과 : " + a); // c = a = a + 1 / 59+1이 먼저 들어가서 c는 60
		System.out.println("c의 결과 : " + c); //60
		
		c = ++a  + b++ ; // a,c는 마지막 결과 60, b는 89
		System.out.println("a의 결과 : " + a); // 61
		System.out.println("b의 결과 : " + b); // 90
		System.out.println("c의 결과 : " + c); // 150

		
		
	}

}
