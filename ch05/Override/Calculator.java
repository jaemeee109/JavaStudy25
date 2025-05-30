package ch05.Override;

public class Calculator { //부모클래스
	double areaCircle (double r) {
		System.out.println( "Calculater 객체의 areaCircle() 실행");
		
		return 3.14159*r*r;
	}

}//class종료
