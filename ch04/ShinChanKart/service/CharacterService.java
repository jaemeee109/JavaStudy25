package ch04.ShinChanKart.service;

import java.util.Scanner;

import ch04.ShinChanKart.dto.CharacterDTO;
import ch04.ShinChanKart.dto.GliderDTO;
import ch04.ShinChanKart.dto.ItemDTO;
import ch04.ShinChanKart.dto.KartDTO;
import ch04.ShinChanKart.dto.MemberDTO;
import ch04.ShinChanKart.dto.TireDTO;

public class CharacterService {

	public void menu(Scanner input, CharacterDTO[] characterDTOs, KartDTO[] kartDTOs, GliderDTO[] gliderDTOs,
			TireDTO[] tireDTOs, ItemDTO[] itemDTOs, MemberDTO loginState) {
		
		System.out.println("*"+loginState.nickName +"님의 캐릭터를 선택합니다");
		System.out.println("1. 짱구");
		System.out.println("2. 철수");
		System.out.println("3. 유리");
		System.out.println("4. 훈이");
		System.out.println("5. 맹구");
		System.out.println("6. 짱아");
		System.out.println("7. 흰둥이");
		System.out.println("8. 봉미선");
		System.out.println("9. 신형만");
		System.out.println("10. 종료");
		System.out.print(">>> ");
		int select = input.nextInt();
		switch (select) {
		
		case 1 :
			System.out.println("* 짱구");
			System.out.println("|무게: 23 |속도: 30 |가속: 30 |핸들링: 10 |마찰력: 20 |");
			loginState.characterDTO = characterDTOs[0];
			loginState.kartDTO = kartDTOs[0];
			loginState.itemDTO = itemDTOs[0];
			loginState.gliderDTO = gliderDTOs[0];
			loginState.tireDTO = tireDTOs[0];
			
			break;
		case 2 :
			System.out.println("* 철수");
			System.out.println("|무게: 23 |속도: 30 |가속: 30 |핸들링: 10 |마찰력: 20 |");
			loginState.characterDTO = characterDTOs[1];
			loginState.kartDTO = kartDTOs[0];
			loginState.itemDTO = itemDTOs[0];
			loginState.gliderDTO = gliderDTOs[0];
			loginState.tireDTO = tireDTOs[0];
			break;
		case 3 :
			System.out.println("* 유리");
			System.out.println("|무게: 23 |속도: 30 |가속: 30 |핸들링: 10 |마찰력: 20 |");
			loginState.characterDTO = characterDTOs[2];
			loginState.kartDTO = kartDTOs[0];
			loginState.itemDTO = itemDTOs[0];
			loginState.gliderDTO = gliderDTOs[0];
			loginState.tireDTO = tireDTOs[0];
			break;
		case 4 :
			System.out.println("* 훈이");
			System.out.println("|무게: 23 |속도: 30 |가속: 30 |핸들링: 10 |마찰력: 20 |");
			loginState.characterDTO = characterDTOs[3];
			loginState.kartDTO = kartDTOs[0];
			loginState.itemDTO = itemDTOs[0];
			loginState.gliderDTO = gliderDTOs[0];
			loginState.tireDTO = tireDTOs[0];
			break;
		case 5:
			System.out.println("* 맹구");
			System.out.println("|무게: 23 |속도: 30 |가속: 30 |핸들링: 10 |마찰력: 20 |");
			loginState.characterDTO = characterDTOs[4];
			loginState.kartDTO = kartDTOs[0];
			loginState.itemDTO = itemDTOs[0];
			loginState.gliderDTO = gliderDTOs[0];
			loginState.tireDTO = tireDTOs[0];
			break;
		case 6:
			System.out.println("* 짱아");
			System.out.println("|무게: 8 |속도: 10 |가속: 30 |핸들링: 15 |마찰력: 10 |");
			loginState.characterDTO = characterDTOs[5];
			loginState.kartDTO = kartDTOs[2];
			loginState.itemDTO = itemDTOs[2];
			loginState.gliderDTO = gliderDTOs[0];
			loginState.tireDTO = tireDTOs[0];
			break;
		case 7:
			System.out.println("* 흰둥이");
			System.out.println("|무게: 2 |속도: 35 |가속: 30 |핸들링: 14 |마찰력: 8 |");
			loginState.characterDTO = characterDTOs[6];
			loginState.kartDTO = kartDTOs[3];
			loginState.itemDTO = itemDTOs[5];
			loginState.gliderDTO = gliderDTOs[0];
			loginState.tireDTO = tireDTOs[0];
			break;
		case 8:
			System.out.println("* 봉미선");
			System.out.println("|무게: 55 |속도: 40 |가속: 30 |핸들링: 8 |마찰력: 40 |");
			loginState.characterDTO = characterDTOs[7];
			loginState.kartDTO = kartDTOs[1];
			loginState.itemDTO = itemDTOs[1];
			loginState.gliderDTO = gliderDTOs[1];
			loginState.tireDTO = tireDTOs[0];
			break;
		case 9:
			System.out.println("* 신형만");
			System.out.println("|무게: 70 |속도: 50 |가속: 30 |핸들링: 5 |마찰력: 50 |");
			loginState.characterDTO = characterDTOs[8];
			loginState.kartDTO = kartDTOs[1];
			loginState.itemDTO = itemDTOs[3];
			loginState.gliderDTO = gliderDTOs[1];
			loginState.tireDTO = tireDTOs[0];
			break;
		case 10:
			System.out.println("* 메인 메뉴로 돌아갑니다");
			break;
		default :
			System.out.println("*다시 입력해주세요");
				
			
		
		}//switch select 종료
		
		
		
	}// CharacterService method 종료

}//class 종료
