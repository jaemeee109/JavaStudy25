package ch05.Tire;

public class Tire { //부모클래스, 최상위
	
	// 필드
	public int maxRotation; // 최대 회전수 (타이어 수명)
	public int accRotation; // 누적 회전수 (1씩 증가)
	public String location; // 타이어 위치 
	
	//생성자
	public Tire (String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	// 메서드
	
	public boolean roll() {
		++accRotation;
		if (accRotation < maxRotation) {
			System.out.println(location + " 타이어 수명: "+ (maxRotation-accRotation)+ " 마일리지");
			return true; // 주행가능코드
			
		}//if종료
		else {
			System.out.println("*****경고: " +location + " 타이어 펑크 *****");
			
			return false; // 주행 불가능 코드
			
		}// else 종료
	}

}//class종료
