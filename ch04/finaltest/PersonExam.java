package ch04.finaltest;

public class PersonExam {

	public static void main(String[] args) {
		// 필드에 final 붙인 객체를 사용하기
		
		Person person = new Person("123456-1234567", "홍길동");
		System.out.println("국가명: " +person.nation);
		System.out.println("주민번호: "+person.ssn);
		System.out.println("성명: " + person.name);
		
		//person.nation = "USA";
		//person.ssn = "654321-7654321";
		// -> final이 적용 되어있기 때문에 변경 불가능
		person.name="김춘식";	
		System.out.println("국가명: " +person.nation);
		System.out.println("주민번호: "+person.ssn);
		System.out.println("성명: " + person.name);
		//-> final 적용이 안되서 변경 가능
	}

}
