package ch04.staticblock;

public class CalculatorExam {

	public static void main(String[] args) {
		// 정적 필드와 정적 메서드 사용하기
		
		System.out.println("계산기 내부의 파이 값: "+Calculator.pi);
		double result1 = 10*10*Calculator.pi;
		System.out.println("정적필드로 파이 계산 결과: "+ result1);
		int result2 =  Calculator.plus(56, 91);
		System.out.println("정적 메서드 플러스 결과: "+ result2);
		int result3 = Calculator.minus(31, 12);
		System.out.println("정적 메서드 마이너스 결과: "+result3);
		System.out.println("-----------------------------------------");
		System.out.println("김춘식이 계산기를 이용하여 값을 계산한다");
		Calculator.result = 2*2;
		System.out.println("계산기 결과 값: "+Calculator.result);
		System.out.println("홍길동이 계산기를 빌려달라고 한다");
		Calculator.result = 100 + 4 ;
		System.out.println("김춘식이 전에 계산했던 2x2 값에 200을 더했다");
		Calculator.result = Calculator.result+200;
		System.out.println("계산기 결과 값: " + Calculator.result);
		// 결론 : static은 객체 (인스턴스화)가 되지 않기 때문에
		//		 값이 중복 처리 된다
				
		

	}

}
