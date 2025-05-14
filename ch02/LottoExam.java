package ch02;

import java.util.Scanner;

public class LottoExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("1~45까지의 번호 중 6개의 번호를 입력하세요");
	
        
		int num1 = input.nextInt();
		System.out.println("첫번째 번호 : " + num1);	
		
		int num2 = input.nextInt();
		System.out.println("두번째 번호 : " + num2);
		
		int num3 = input.nextInt();
		System.out.println("세번째 번호 : " + num3);
		
		int num4 = input.nextInt();
		System.out.println("네번째 번호 : " + num4);
		
		int num5 = input.nextInt();
		System.out.println("다섯번째 번호 : " + num5);
		
		int num6 = input.nextInt();
		System.out.println("여섯번째 번호 : " + num6); // 번호입력받기
		System.out.println("");
		System.out.println("====================");
		System.out.println("고객님께서 입력하신 번호는 " +num1+" / "+num2+" / "+num3+" / "+num4+" / "+num5+" / "+num6+" 입니다");
		
		int no1 = (int)(Math.random()*45) + 1 ;
		int no2 = (int)(Math.random()*45) + 1;
		int no3 = (int)(Math.random()*45) + 1;
		int no4 = (int)(Math.random()*45) + 1;
		int no5 = (int)(Math.random()*45) + 1;
		int no6 = (int)(Math.random()*45) + 1; // 로또 랜덤번호 생성
		
		int x = 0; // 맞는 숫자, 맞는 숫자 카운트용
		if (num1 == no1 || num1 == no2|| num1 == no3 || num1 == no4 || num1 == no5 || num1 == no6) {
			++ x ; // 증감연산자 내가 넣은 숫자가 로또의 랜덤번호와 몇개 일치하는지 일치하는 갯수 계산을 위해 넣는 것
		}if (num2 == no1 || num2 == no2 || num2 == no3 || num2 == no4 || num2 == no5 || num2 == no6 ) {
		 ++ x ;
		}if (num3 == no1 || num3 == no2 || num3 == no3 || num3 == no4 || num3 == no5 || num3 == no6) {
		 ++ x ;
		}if (num4 == no1|| num4 == no2 || num4 == no3 || num4 == no4 || num4 == no5 || num5 == no6 ) {
		++ x ;
		}if (num5 == no1 || num5== no2 || num5 == no3 || num5 == no4 || num5 == no5 || num5 == no6 ) {
		++ x ;
		}if (num6 == no1 ||num6 == no2 ||num6 == no3 ||num6 == no4 ||num6 == no5 ||num6 == no6 ) {
		++ x ;
		}//번호 일치 if종료
		System.out.println("=================================");
		System.out.println("이번주의 로또 당첨 번호입니다");
		System.out.println(no1 + " / " + no2 + " / " + no3 + " / " + no4 + " / " + no5 + " / " + no6 + "");
		System.out.println("=================================");
		
		if ( x == 0) {
			System.out.println(" 일치하는 번호가 없습니다 ");
		} else if (x == 1) {
			System.out.println("축하합니다 1개의 번호가 일치합니다");
		} else if (x ==2) {
			System.out.println("축하합니다 2개의 번호가 일치합니다");
		} else if (x == 3) {
			System.out.println("축하합니다 3개의 번호가 일치합니다");
		} else if (x==4) {
			System.out.println("축하합니다 4개의 번호가 일치합니다");
		} else if (x==5) {
			System.out.println("축하합니다 5개의 번호가 일치합니다");
		} else if (x==6) {
			System.out.println("축하합니다 모든 번호가 일치합니다");
		}else {
			System.out.println("시스템 오류입니다 프로그램을 다시 시작해주세요");
		}//몇개가 맞았는지 if 종료

	}//main 종료

}//class종료
