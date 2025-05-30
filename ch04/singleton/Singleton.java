package ch04.singleton;

public class Singleton {
	// 싱글톤은 단 1개의 객체만 만들 수 있도록 보장하는 방법
	// 싱글톤은 예약어로 존재하지 않는다
	// 단, 생성할 때 private static을 선언한다
	
	// 정적필드 (싱글톤은 자신 객체를 미리 1개 만들어놓고, 정적 메서드에서 호출한다)
	
	private static Singleton singleton = new  Singleton();
	

	
	// 정적생성자 (기본 생성자)
	private Singleton() {
		

		// private란 클래스 자신만 객체를 생성할 수 있다
		
	}
	
	// 정적메서드
	
	public static Singleton getInstance() {// 싱글톤 객체를 만드는 메서드
		return singleton;
	}

}
