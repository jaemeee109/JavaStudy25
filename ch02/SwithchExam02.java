package ch02;

import java.util.Scanner;

public class SwithchExam02 {

	public static void main(String[] args) {//main 메서드
		// 개선된 Switch문을 사용해보기 -> 람다식이 적용되어있음
		// 람다식 -> 화살표를 이용하여 값을 전달
		// 메서드는 동작이 해당하는 기능, main 바깥쪽에도 만들어서 사용해보기
		
		Scanner inputStr = new Scanner(System.in);
		boolean run = true ;// true일때 반복되게 함
		while (run) { // 반복문 만들어주기
			System.out.println("원하는 동물을 입력하세요");
			System.out.print(">>>>> ");
			String animal = inputStr.next();
			whoIsIt(animal); // 메서드 호출
			
		}//while 종료

	}//main 메서드 종료

	 static void whoIsIt(String value) {
		// 사용자정의 메서드 추가
		 // void는 리턴값이 없을때 사용
		 String kind = null;
		 switch (value) {
		 case "호랑이","사자","하이에나","표범" -> kind = "포유류";
		 case "독수리", "매", "뱁새","참새" -> kind = "조류";
		 case "고등어","연어","방어","참치" -> kind = "어류";
		 default -> kind = "알 수 없는 개체";
				 
		 }//switch 종료
		 
		 System.out.println(value + "는 "+kind+"로 판단됩니다");
		
	}//사용자정의 메서드 종료

}//class 종료
