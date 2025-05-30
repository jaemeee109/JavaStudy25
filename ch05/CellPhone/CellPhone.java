package ch05.CellPhone;

public class CellPhone { //부모클래스
	
	String model;
	String color; //부모필드
	
	// 생성자
	
	void powerOn() {
		System.out.println("띠리링 ☆ 전원을 켭니다");
		
	}
	void powerOff() {
		System.out.println("~ 전원을 끕니다 bye bye ");
	}
	void bell() {
		System.out.println("~♪♩♬♪♩♬~");
	}
	void sendVoice (String message) {
		System.out.println("보낸사람: " + message);
	}
	void receiveVoice (String message) {
		System.out.println("받는사람: "+message);
		
	}
	void hangUp() {
		System.out.println("뚝");
		
	}

}//class 종료
