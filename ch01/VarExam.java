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
		
		// 컴퓨터는 문자를 유니코드로 변환해서 처리한다
	
		char firstname = '롱' ;
		char firstName = '녕' ;
		
		System.out.println("메" + firstname);
		System.out.println("안" + firstName);
		
		// 대소문자 다르게 인식 됨
		
		// char z9 = "melon" ; 오류가 안나려면 char가 아니라 다른걸 사용해야됨
		
		int literal1 = 75 ;
		int literal2 = 075 ;
		int literal3 = 0b0011 ;
		int literal4 = 0xA ;
		
		System.out.println("10진수 75: " + literal1);
		System.out.println("8진수 75: " + literal2);
		System.out.println("2진수 0011: " + literal3);
		System.out.println("16진수 A: " + literal4);
		
		// 진수 리터럴
		
		char hi = '보' ;
		char Hi = '개' ;
		System.out.print("바"+ hi);
		System.out.println("똥"+Hi);
		
		
		// ln을 삭제하면 출력이 한줄로 된다
		
		//다중변수선언
		
		
		int kor, math, eng, total, avg ;
		
		kor = 100;
		math = 20;
		eng = 10;
		total = kor + math + eng ; // 총점
		avg = total /3 ; // 평균
		
		System.out.println("총점" + total);
		System.out.println("평균" + avg);
		

	}

}
