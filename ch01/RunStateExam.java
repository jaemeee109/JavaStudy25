package ch01;

public class RunStateExam {

	public static void main(String[] args) {
		// 
		int x = 1 ; // x 변수에 숫자 1을 넣는다.
		int y = 2 ; // y 변수에 숫자 2를 넣는다.
		int result = x + y ; // result 변수에 x + y 값을 넣어준다. 
		
		System.out.println("x+y=" + result); // 출력
		
		int t = 8 ;
		int v = 12 ;
		int cat = v - t ;
		
		System.out.println("cat=" + cat);
		System.out.println("8=" + cat);
		// 따옴표 안에 있는건 따옴표에 적힌거 그대로 출력되고 + 이후에 적힌건 변수값이 나옴

	}

}
