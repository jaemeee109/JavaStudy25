package ch04.ShinChanKart.dto;

public class MemberDTO {
	//필드
	public String id; //아이디 (로그인용)
	public String pw; //암호 (로그인용)
	public String nickName; // 별명(게임용)
	public String email; // 이메일(암호찾기용)

	
	public CharacterDTO characterDTO ; // 계정벌 캐릭터 객체
	public GliderDTO gliderDTO;
	public KartDTO kartDTO;
	public ItemDTO itemDTO;
	public TireDTO tireDTO;
	
	
	//생성자
	
	//메서드

}//memberDTO Class 종료
