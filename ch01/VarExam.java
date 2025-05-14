package ch01;

public class VarExam {

	public static void main(String[] args) {
		// 변수 선언 테스트
		
		int x = 1 ;
		char y = 65 ;
		char z = 'A' ;
		
		System.out.println("int x = " + x );
		System.out.println("char y = " + y );
		System.out.println("char z = " + z);
		
	
		char firstname = 'A' ;
		char firstName = 'a' ;
		
		System.out.println("A" + firstname);
		System.out.println("a" + firstName);
		
		// 대문자 소문자 구분하여 넣어야됨
		//리터럴
	
		int literal1 = 75 ;
		int literal2 = 075 ;
		int literal3 = 0b0011 ;
		int literal4 = 0xA ;
		
		System.out.println("10진수 75: " + literal1);
		System.out.println("8진수 75: " + literal2);
		System.out.println("2진수 0011: " + literal3);
		System.out.println("16진수 A: " + literal4);
		
	
		
		// 다중 변수 선언
		
		
		
		
		int kor, math, eng, total, avg ;
		
		kor = 100;
		math = 20;
		eng = 10;
		total = kor + math + eng ; // 총점
		avg = total /3 ; // 평균
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
		

	}

}
