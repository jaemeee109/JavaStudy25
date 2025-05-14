package ch02;

import java.util.Scanner;

public class forExam {

	public static void main(String[] args) {
		// for문은 반복문으로 초기화식, 조건식, 증감식으로 만든다
		// FOR (int  i = o ; i<10 ; i++){반복실행문;}
		// i는 0부터 10 이전까지 1씩 반복하는 실행문 !
		// for문에서 사용하는 i 초기값은 for{} 끝나면 사라진다
		
		Scanner inputInt = new Scanner(System.in);
		
		System.out.print( "원하는 최소값을 입력하세요 >>> ");
		int min = inputInt.nextInt();
		
		System.out.print("원하는 최대값을 입력하세요 >>> ");
		int max = inputInt.nextInt();
		
		System.out.println(min + " 부터 " + max + " 사이의 원하는 증가값을 입력하세요");
		System.out.print(" >>> ");
		int add = inputInt.nextInt();
		
		System.out.println("원하시는 범위 내에서 " + add + "씩 증가한 결과를 알려드립니다 ");
		int total = 0 ; // 초기값 설정
		for ( total = min ; total <= max; total += add ) {
			System.out.println("출력값 테스트 :" + total);
		}//for종료

	}//main 메서드 종료

} //class 종료 
