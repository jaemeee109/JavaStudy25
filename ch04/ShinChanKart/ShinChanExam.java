package ch04.ShinChanKart;

import java.util.Scanner;

import ch04.ShinChanKart.dto.CharacterDTO;
import ch04.ShinChanKart.dto.GliderDTO;
import ch04.ShinChanKart.dto.ItemDTO;
import ch04.ShinChanKart.dto.KartDTO;
import ch04.ShinChanKart.dto.MemberDTO;
import ch04.ShinChanKart.dto.TireDTO;
import ch04.ShinChanKart.service.CharacterService;
import ch04.ShinChanKart.service.GameService;
import ch04.ShinChanKart.service.MemberService;

public class ShinChanExam {
	
	// 필드 -> main() 메서드가 있는 필드는 static 용으로 만듦
	
	public static Scanner input = new Scanner(System.in);
	//static 으로 스캐너 객체를 생성했기 때문에 공용으로 사용 가능
	public static MemberDTO[] memberDTOs = new MemberDTO[30]; // 회원 30명
	public static CharacterDTO[] characterDTOs = new CharacterDTO[9]; // 캐릭터 9개
	public static KartDTO[] kartDTOs = new KartDTO [4] ; // 카트 4종
	public static GliderDTO[] gliderDTOs = new GliderDTO [2] ; // 글라이더 2종
	public static TireDTO[] tireDTOs = new TireDTO [2] ; // 타이어 2종
	public static ItemDTO[] itemDTOs = new ItemDTO [6];// 아이템 6종
	
	public static MemberDTO loginState; // 세션과 같은 기능
	// 로그인 성공시 객체를 가지고 있는 용도
	
	// 생성자 -> new ShinChanExam() 으로 객체를 생성하지 않음
	// 주 실행이기 때문에 내가 나를 호출하지 않기 때문
	
	// static {} 스태틱 블럭을 사용함 (초기화용)
	
	static { // 캐릭터블럭
		CharacterDTO characterDTO0 = new CharacterDTO("짱구", 23, 30, 30, 10, 20);
		CharacterDTO characterDTO1 = new CharacterDTO("철수", 23, 30, 30, 10, 20);
		CharacterDTO characterDTO2 = new CharacterDTO("유리", 21, 30, 30, 12, 20);
		CharacterDTO characterDTO3 = new CharacterDTO("훈이", 23, 30, 30, 10, 20);
		CharacterDTO characterDTO4 = new CharacterDTO("맹구", 23, 30, 30, 10, 20);
		CharacterDTO characterDTO5 = new CharacterDTO("짱아", 8, 10, 30, 15, 10);
		CharacterDTO characterDTO6 = new CharacterDTO("흰둥이", 5, 35, 30, 14, 8);
		CharacterDTO characterDTO7 = new CharacterDTO("봉미선", 55, 40, 30, 8, 40);
		CharacterDTO characterDTO8 = new CharacterDTO("신형만", 70, 50, 30, 5, 50);
		// 객체 생성 완료
		
		// 객체를 배열에 넣어서 관리
		characterDTOs[0] = characterDTO0;
		characterDTOs[1] = characterDTO1;
		characterDTOs[2] = characterDTO2;
		characterDTOs[3] = characterDTO3;
		characterDTOs[4] = characterDTO4;
		characterDTOs[5] = characterDTO5;
		characterDTOs[6] = characterDTO6;
		characterDTOs[7] = characterDTO7;
		characterDTOs[8] = characterDTO8;
		
		
	}// static 블럭 종료 (main method 실행시 초기화 값)
	
	static { // 카트 블럭
		KartDTO kartDTO0 = new KartDTO("떡잎마을방범대차");
		KartDTO kartDTO1 = new KartDTO("붕붕초록카");
		KartDTO kartDTO2 = new KartDTO("유모차");
		KartDTO kartDTO3 = new KartDTO("솜사탕차");
		
		kartDTOs[0] = kartDTO0;
		kartDTOs[1] = kartDTO1;
		kartDTOs[2] = kartDTO2;
		kartDTOs[3] = kartDTO3;
		
		
	}// static 블럭 종료
	
	static { // 아이템 블럭
		
		
		ItemDTO itemDTO0 = new ItemDTO ("액션가면발차기!");
		ItemDTO itemDTO1 = new ItemDTO ("떡잎유치원두목님 얼굴!");
		ItemDTO itemDTO2 = new ItemDTO ("붉은장미삼총사 주먹!");
		ItemDTO itemDTO3 = new ItemDTO ("부리부리맨엉덩이 !");
		ItemDTO itemDTO4 = new ItemDTO ("초코비");
		ItemDTO itemDTO5 = new ItemDTO ("액션로봇발사!");
		
		itemDTOs[0] = itemDTO0;
		itemDTOs[1] = itemDTO1;
		itemDTOs[2] = itemDTO2;
		itemDTOs[3] = itemDTO3;
		itemDTOs[4] = itemDTO4;
		itemDTOs[5] = itemDTO5;
		
		
		
		
	}// static블럭 종료
	
	
	static { // 글라이더 블럭
		
		GliderDTO gliderDTO0 = new GliderDTO ("액션가면글라이더");
		GliderDTO gliderDTO1 = new GliderDTO ("부리부리맨글라이더");
		
		gliderDTOs[0] = gliderDTO0;
		gliderDTOs[1] = gliderDTO1;
		
		
		
		
	} // static 블럭 종료
	
	static { // 타이어 블럭
		
		TireDTO tireDTO0 = new TireDTO ("액션타이어");
		TireDTO tireDTO1 = new TireDTO ("부리부리타이어");
		
		tireDTOs[0] = tireDTO0;
		tireDTOs[1] = tireDTO1;
		
	}// static 블럭 종료
	
	// 정적 메서드
	public static void main(String[] args) {
		// MVC 패턴을 이용하여 짱구카트 프로그램 제작
		// DTO : 객체용 (Data Transfer Object)
		// Service : 부메뉴용 (C R U D)
		// main() : 컨트롤러용
		
		System.out.println("※ 짱구는 못말려 카트 게임 시작 ※");
		boolean run = true ; // 처음 구동
		while (run) {
			System.out.println("1. 회원관리 | 2. 캐릭터관리 | 3. 게임실행 | 4. 게임종료 ");
			System.out.print(">>>");
			int select = input.nextInt();
			
			switch (select) {
			
			case 1 :
				System.out.println("* 회원관리 페이지 입니다");
				MemberService memberService = new MemberService();
				loginState = memberService.menu(input, memberDTOs, loginState);
				System.out.println("현재 로그인한 회원: "+ loginState.nickName);
			break;
			case 2 :
				System.out.println("* 캐릭터관리 페이지 입니다");
				CharacterService chracterService = new CharacterService();
				chracterService.menu(input ,characterDTOs,kartDTOs,gliderDTOs,tireDTOs,itemDTOs,loginState);
				
				
			break;
			case 3 :
				System.out.println("* 게임을 실행합니다");
				GameService gameService = new  GameService();
				gameService.play(input,characterDTOs,kartDTOs,gliderDTOs,tireDTOs,itemDTOs,loginState, memberDTOs);
				
			break;
			case 4 :
				System.out.println("※ 짱구는 못말려 카트 게임 종료 ※");
				run = false;
			break;
			default :
				System.out.println("* 다시입력해주세요");
			}// switch select 종료
			
		}// while run 종료
		

	}//main method 종료

}//class 종료
