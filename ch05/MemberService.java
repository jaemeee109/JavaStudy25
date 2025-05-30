package ch05;

import java.util.Scanner;

public class MemberService {

	public static void main(String[] args) {
		

		
		Scanner input = new Scanner(System.in);
		System.out.print("이름: ");
		String name = input.next();
		
		System.out.print("나이: ");
		int age = input.nextInt();
		
		System.out.println("관리자 |  true / false 로 입력해주세요");
		System.out.print(": ");
		boolean admin = input.nextBoolean();
		
		MemberDTO memberDTO = new MemberDTO();
		// 같은 패키지인 경우에는 import가 없음 (상단에 import를 반드시 확인 할 것)
		
		memberDTO.setName(name);
		memberDTO.setAge(age);
		memberDTO.setAdmin(admin);
		
		System.out.println("저장된 이름: "+memberDTO.getName());
		System.out.println("저장된 나이: "+memberDTO.getAge());
		System.out.println("저장된 관리자: "+memberDTO.isAdmin());
		
	}// main 메서드 종료

}//class 종료
