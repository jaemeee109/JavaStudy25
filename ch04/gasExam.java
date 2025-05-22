package ch04;

import java.util.Scanner;

public class gasExam {

	public static void main(String[] args) {
	
	gas gas = new gas();
	
	gas.setGas(100);//gas양을 100으로 충전
	
	boolean gasState = gas.isLeftGas();
	if (gasState) { // isLeftGas 메서드를 이용하여 0이면 false
		System.out.println("출발합니다");
		gas.run(); // 가스를 소모하여 주행하는 메서드 호출
	}
	if (gas.isLeftGas()) {
		System.out.println("가스를 주입할 필요가 없습니다");
		
	}else {
		System.out.println("가스를 주입하세요");
	}
		

	}//main method 종료

}//class종료
