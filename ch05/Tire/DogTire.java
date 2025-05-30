package ch05.Tire;

public class DogTire extends Tire {
	// 필드 부모필드 활용
	// 생성자
	public DogTire(String location, int maxRotation) {
		super(location, maxRotation);
		
	}// DogTire 메서드 종료

	@Override
	public boolean roll() {
		++accRotation ; // 누적 회전수 1씩 증가
		if (accRotation < maxRotation) {
			System.out.println(location + " 강아지 타이어 수명: "+(maxRotation-accRotation)+" 마일리지");
			return true;
		}else {
			System.out.println("*****경고: "+location + " 강아지타이어 펑크 *****");
			return false;//주행 불가능 코드
		}
		
	}
	
	
}//class 종료
