package ch05;

public class MemberDTO {

	//필드
	private String name;
	private int age;
	private boolean admin;
	public String getName() {
		return name+"님";
	}
	
	//생성자
	
	public void setName(String name) {
		System.out.println("이름엔 숫자가 불가능 합니다");
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		System.out.println("19세 이상만 가능합니다");
		this.age = age;
	}
	public String isAdmin() { // boolean일 경우에만 is를 사용함
		String adminString = null;
		if (admin == true) {
			adminString = "관리자";
		}
		return adminString;
	}
	public void setAdmin(boolean admin) {
		System.out.println("관리자일 경우에는 true로 처리");
		this.admin = admin;
	}
	
	
	//메서드 -> 필드를 private로 변경했기 때문에 공용메서드가 필요함
	//			공용 메서드를 통해서 값을 주고 받는다
	
}//class 종료
