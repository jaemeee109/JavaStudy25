package ch04.PracticeExam;

import java.util.Calendar;

public class EnumWeekExam {

	public static void main(String[] args) {
		// 이늄과 내장된 객체 (달력)을 연결하여
		// 날짜 출력해보기
		
		Week today = null;
	 // 타입    변수 =   빈값 ;
		
		Calendar calendar = Calendar.getInstance();
	 //  타입        변수    =   객체.메서드 ;
	 // 캘린더 타입에 객체가 만들어지면서 캘린더라는 변수에 들어간다
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		// 정수 타입의 변수에 캘린더에서 가져온 값을 넣기
		System.out.println("현재는 "+year+"년 "+month +"월 "+ day + "일 입니다");
	 
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("오늘은 "+week+"요일 입니다");
		
		System.out.println("==================================================");
		
		switch (week) {
		case 1: today = Week.SUNDAY;
		break;
		case 2: today = Week.MONDAY;
		break;
		case 3: today = Week.TUESDAY;
		break;
		case 4: today = Week.WEDNESDAY;
		break;
		case 5: today = Week.THURSDAY;
		break;
		case 6: today = Week.FRIDAY;
		break;
		case 7: today = Week.SATURDAY;
		break;
		

		
		}//week switch 종료
		
		System.out.println("현재는 "+year+"년 "+month +"월 "+ day + "일 ("+ today + ") 입니다");
		

		
		int hour = calendar.get(calendar.HOUR);
		int minute = calendar.get(calendar.MINUTE);
		int second = calendar.get(calendar.SECOND);
		
		System.out.println("현재 시간은 "+hour+"시 "+ minute +"분 "+ second + "초 입니다");
		
		// 이늄타입을 이용하여 == 사용하기
		
		if (today == Week.SUNDAY) {
			System.out.println("일요일");
		}else if (today == Week.MONDAY) {
			System.out.println("월요일");
		}else if (today == Week.TUESDAY) {
			System.out.println("화요일");
		}else if (today == Week.WEDNESDAY) {
			System.out.println("수요일");
		}else if (today == Week.THURSDAY) {
			System.out.println("목요일");
		}else if (today == Week.FRIDAY) {
			System.out.println("금요일");
		}else if (today == Week.SATURDAY) {
			System.out.println("토요일");
		}//if종료				
		
		// name() 메서드 사용하기 열거객체가 갖고있는 문자열 가져옴
		Week day0 = Week.SUNDAY;
		String name = day0.name();
		System.out.println("객체의 이름은 : "+ name);
		// SUNDAY가 name 안에 들어간다
		
		// ordinal() 사용하기, 열거객체에서 몇번째 순서인지 알려줌
		int ordinal = day0.ordinal();
		System.out.println("객체의 순서는 : "+ ordinal);
		
		//cmopareTo() 주어진 열거객체를 기준으로 몇번째 순서인지 알려줌
		Week day1 = Week.MONDAY;
		Week day2 = Week.WEDNESDAY;
		int result1 = day1.compareTo(day2);
		int result2 = day2.compareTo(day1);
		System.out.println(result1); // 월요일은 수요일 기준으로 -2
		System.out.println(result2); // 수요일은 월요일 기준으로 2
		
		//valueof() 매개값으로 주어지는 문자열과 동일한 문자열을 가진 열거객체를 가져옴
		Week weekday = Week.valueOf("MONDAY");
		if (weekday == Week.SATURDAY || weekday == Week.SUNDAY){
			System.out.println("주말");
	 } else {
		 System.out.println("평일");
	 }//if종료
		
		//value() 모든 열거객체를 배열로 만들어 가져옴
		
		Week[] days =  Week.values();
		for (Week a : days) {
			System.out.println(a + " ");
		}//for종료
		
		

	}//main method 종료

}//class 종료
