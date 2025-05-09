package ch01;

public class LocalVariableExam {

	public static void main(String[] args) {
		// 변수의 사용범위는 괄호 () 안에서 사용됨
		
		int v1 = 10;
		int v2 = 0;
		
		if (v1>10) {
			v2 = v1 + 10;
			
		}
		
		int v3 = v1 + v2 + 25 ;
		
		System.out.println("v1의 값 : " + v1);
		System.out.println("v2의 값 : " + v2);
		System.out.println("v3의 값 : " + v3);
	}

}
