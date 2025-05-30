package ch04.ShinChanKart.dto;

public class CharacterDTO {

	//필드
	
	public String name; // 캐릭터명
	public double weight; // 캐릭터 무게
	public double speed; // 속도
	public double acceleration; // 가속
	public double handling; // 핸들링
	public double friction; // 마찰력
	
	
	// 기본생성자 -> new CharacterDTO(); 이렇게 만들어냄
	// 사용자가 생성자를 만들게되면 기본생성자는 자동으로 만들어지지 않음
	// 기본 생성자는 자동으로 만들어지지만 사용자지정 생성자는 자동으로 만들어지지 않음
	
	// 생성자 -> 객체 생성시 값을 넣으면서 생성한다
	
	public CharacterDTO(String name, double weight, double speed, 
			double acceleration, double handling, double friction) {
		// CharacterDTO chracterDTO = new CharacterDTO(파라미터);
		
		this.name = name;
		this.weight = weight;
		this.speed = speed;
		this.acceleration = acceleration;
		this.handling = handling;
		this.friction = friction;
		
	}// characterDTO 메서드 종료
	
	// 메서드
}
