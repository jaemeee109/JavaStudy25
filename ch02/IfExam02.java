package ch02;

import java.util.Scanner;

public class IfExam02 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("이름을 입력하세요 : "); //이름 입력
		String name = input.nextLine();
		System.out.print("주민등록번호를 입력하세요 : ");
		String ssn = input.next();
		char ssn2 = ssn.charAt(6);
		int num = Character.getNumericValue(ssn2);
		
		if(num %2==0) {
			System.out.println("여자");
		}else if (num%2==1) {
			System.out.println("남자");
		
		}else {
			System.out.println("다시 작성해주세요");
		} // 성별확인
		
		int year = Integer.parseInt(ssn.substring(0, 2)); // 태어난 년도 추출
		
		if (num ==1 || num ==2 || num == 5 || num ==6) {
			System.out.println("나이는 " + (2023-(1900 + year)+1)+ "입니다");
		}else if (num==3 || num==4 || num == 7 || num == 8){
			System.out.println("나이는 "+ (2023 - (2000 + year)+1) + "입니다");
		}else {
			System.out.println("다시 작성해주세요"); 
		}
		int month = Integer.parseInt(ssn.substring(2, 4)); // 계절
		
		if(month <=0 || month >= 13) {
			System.out.println("다시 작성해주세요");
		}else if (month >= 3 && month <=5) {
			System.out.println("봄에 태어났습니다");
		}else if (month >= 6 && month <=8) {
			System.out.println("여름에 태어났습니다");
		}else if (month>=9 && month <=11) {
			System.out.println("가을에 태어났습니다");
		}else {
			System.out.println("겨울에 태어났습니다");
		}
		
		System.out.print("회원가입 ID를 입력하세요 : " );
		String id = input.next();
		System.out.print("회원가입 PW를 입력하세요 : ");
		String pw = input.next();
		
		
		
		System.out.println("===== 확인 중 =====");
		System.out.println(">>>>> 회원가입에 성공하였습니다 <<<<<");
		System.out.println(" 로그인을 해주세요");
		
		System.out.println("===================================" );
	
		System.out.print("로그인 할 ID를 입력하세요 : " );
		String loginid = input.next();

		System.out.print("로그인 할 PW를 입력하세요 : ");
		String loginpw = input.next();
		
		if (id.equals(loginid) && (pw.equals(loginpw))) {
			System.out.println("로그인에 성공하였습니다");
		}else {System.out.println("ID와 PW가 일치하지 않습니다");
		System.out.println("다시 입력해주세요");
	}//if종료
	
		

	}//main메서드종료
}//class종료
	


