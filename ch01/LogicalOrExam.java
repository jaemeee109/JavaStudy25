package ch01;

import java.util.Scanner;

public class LogicalOrExam {

	public static void main(String[] args) {
		// 논리합 테스트용
		// | 연산은 대부분 조건이 2개 이상일 경우 판단하는 용도로 사용한다
		// 예를 들어 id 와 pw가 둘중 하나라도 맞아야 id찾기나 pw찾기로 가는 경우
		// (가지고 있던 id == 키보드로 입력한 id | 가지고 있던 pw == 키보드로 입력한 pw)
		//            false                        false                  = false
		//             true                        false                  = false
		//            false                         true                  = false
		//             true                         true                  = true
		
		// 키보드로 입력 받은 숫자가 5의 배수이거나 7의 배수인 것을 처리해보기
		Scanner input = new Scanner (System.in);
		System.out.println("5의 배수이거나 7의 배수 찾기");
		System.out.print("※ 숫자를 입력하세요 >>>>> ");
		int value = input.nextInt(); // 키보드로 입력
		if ((value%5==0)||(value%7==0)) {
			System.out.println(" >>>>> 5의배수 이거나 7의배수 입니다 " );
		}else if ((value%5==0)&&(value%7==0)) {
			System.out.println(" >>>>> 5의배수 이자 7의배수 입니다 " );
		} else {
			System.out.println("※ " + value + " 은(는) 5의 배수 또는 7의 배수에 해당되지 않습니다 ");
			if (value%5==0)
				System.out.println(" >>>>> 5의배수 입니다");
		if(value%7==0)
			System.out.println(" >>>>> 7의배수 입니다");

		}//if 종료

	
		}//main 종료

	}//class 종료


