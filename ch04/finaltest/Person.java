package ch04.finaltest;

public class Person {
	// 필드값에 final 을 붙이면 초기값이 최종값이 된다
	// 변경되지 않는 값으로 사용한다
	
	public final  String nation = "korea";
	public final String ssn; // 초기값이 없을 때는 생성자로 밀어 넣는다
	public String name;
	
	// 생성자
	public Person() {
		ssn = null;
	}
	
	public Person (String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
	
	// 메서드

}
