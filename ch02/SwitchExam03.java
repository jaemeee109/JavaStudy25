package ch02;

import java.util.Scanner;

public class SwitchExam03 {
	public static void main(String[] args) {//main 메서드
		// return을 사용하면 사용자지정 메서드에 void를 사용하지 않음
		
		Scanner inputStr = new Scanner(System.in);
			System.out.println("원하는 동물을 입력하세요");
			System.out.print(">>>>> ");
			String animal = inputStr.next();
			String kind = whoIsIt(animal); 
			
			System.out.println(animal +"는 "+ kind + "로 판단됩니다");
			
	}//main 메서드 종료

	 static String whoIsIt(String animal) { //사용자지정 메서드 생성
		
	 String kind = null ; // 값이 없는 kind 변수를 문자열 타입으로 선언
	 switch (animal) {
	 case "호랑이","사자","곰","토끼","여우" -> kind = "포유류";
	 case "독수리","참새","매","뱁새" -> kind = "조류";
	 default -> kind = "알 수 없는 개체";
	 
	 }//switch 종료
		return kind; // 메서드에 void를 삭제하면 생성됨
	}// 사용자지정 메서드 종료




}//class 종료
