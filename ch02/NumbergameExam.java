package ch02;

import java.util.Scanner;

import javax.security.sasl.SaslClient;

public class NumbergameExam {

	public static void main(String[] args) {
		// 랜덤 숫자 맞추기 게임
		
		Scanner input = new Scanner(System.in);
		boolean game = true;
				while (game) {
		System.out.print(" 1~10 까지 중 숫자를 입력하세요 >>> ");
		int num1 = input.nextInt();
		 if (num1<=10) {
			            int num2 = (int)(Math.random()*10)+1;
			            System.out.println(" 랜덤 숫자 결과 >>> " + num2);
			            if (num1==num2) {
			            	System.out.println(" 정답입니다 ");
			            }else if (num1 != num2) {
			            	System.out.println(" 틀렸습니다 ");
			            }else {
			            	System.out.println(" 숫자를 다시 입력해주세요 ");
			            }//else 종료
			}else { 
				System.out.println(" 숫자를 다시 입력해주세요 ");
			
				
			
			} //if종료
		
				}// while 종료
	}//main메서드종료

}//class 종료
