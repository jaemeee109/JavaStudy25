package ch05.Override;

public  class Computer extends Calculator {

	@Override // Source -> Override /Implement methods
	double areaCircle(double r) {
		System.out.println("Calculator 객체의 areaCircle() 실행");
		return Math.PI*r*r;
	} // 자식클래스
	
	

}
