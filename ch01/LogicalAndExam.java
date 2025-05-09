package ch01;

import java.util.Scanner;

public class LogicalAndExam {

	public static void main(String[] args) {
		// 논리곱 테스트용
		// & 연산은 대부분 조건이 2개 이상일 경우 판단하는 용도로 사용한다
		// 예를 들어 id 와 pw가 둘다 맞아야 로그인이 성공하는 경우!!!
		// (가지고 있던 id == 키보드로 입력한 id & 가지고 있던 pw == 키보드로 입력한 pw)
		//            false                        false                  = false
		//             true                        false                  = false
		//            false                         true                  = false
		//             true                         true                  = true
		
		Scanner input = new Scanner(System.in); 

		
		System.out.println( " ※ 숫자 -> 유니코드 : 대문자, 소문자, 숫자, 특수문자 변환 ※ ");
		System.out.print(" ▶ 숫자를 입력해주세요 >>>>> ");
		
		int charCode = input.nextInt(); // 키보드로 넣을 수 있음
		
		if ((charCode >= 65) && (charCode <=90)) {
			System.out.println(" 현재 입력 된 숫자는 유니코드의 대문자 입니다 >>> " + (char)charCode);
		}else if ((charCode>=97)&& (charCode<=122)) {
			System.out.println("현재 입력 된 문자는 유니코드의 소문자 입니다 >>> " + (char)charCode);
		
		}else if (!(charCode<48) && !(charCode>57)) {
			System.out.println("현재 입력된 숫자는 유니코드의 문자형 숫자입니다 >>> " +(char)charCode);
		}else if (!(charCode<33) && !(charCode>47)) {
			System.out.println("현재 입력된 숫자는 유니코드의 특수문자 입니다 >>> " +(char)charCode);
		}else {
			System.out.println("");
			System.out.println("유니코드 대문자, 소문자, 숫자, 특수문자에 포함되지 않는 문자 입니다 ");
			System.out.println("");
			System.out.println("===== 프로그램을 다시 실행해주세요 =====");
		
	}//if종료
	}//main종료
}//class종료
