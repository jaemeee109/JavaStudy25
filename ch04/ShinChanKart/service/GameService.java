package ch04.ShinChanKart.service;

import java.util.Scanner;

import ch04.ShinChanKart.dto.CharacterDTO;
import ch04.ShinChanKart.dto.GliderDTO;
import ch04.ShinChanKart.dto.ItemDTO;
import ch04.ShinChanKart.dto.KartDTO;
import ch04.ShinChanKart.dto.MemberDTO;
import ch04.ShinChanKart.dto.TireDTO;

public class GameService {

	public void play(Scanner input, CharacterDTO[] characterDTOs, KartDTO[] kartDTOs, GliderDTO[] gliderDTOs,
			TireDTO[] tireDTOs, ItemDTO[] itemDTOs, MemberDTO loginState, MemberDTO[] memberDTOs) {
		// 게임 실행 메서드
		
		System.out.println ("☆"+loginState.nickName +"님의 "+ loginState.characterDTO.name+"가(이) 주행을 시작합니다☆");
		System.out.println("카트: " + loginState.kartDTO.kart+" / 글라이더: "+loginState.gliderDTO.glider+" / 타이어: "+loginState.tireDTO.tire);
		boolean run = true;
		while (run) {
			System.out.println("-----------------------------------");
			System.out.println("| 1.엑셀 | 2.브레이크 | 3.아이템 | 4.종료 |");
			System.out.println("-----------------------------------");
			System.out.print(">>> ");
			int select = input.nextInt();
			boolean subRun = true;
			while (subRun) {
				switch (select) {
				case 1:
					System.out.println("☆ 부르르르릉 - - - - -  - - -  - - ☆");
					loginState.characterDTO.speed += 30;
					if (loginState.characterDTO.speed <= 300 && loginState.characterDTO.speed>=0 ) {
						System.out.println("현재속도: " + loginState.characterDTO.speed + "km/h");
						System.out.println("☆ - - - - - - - - -  - - -  - - ☆");

						subRun = false;
					} else {
						System.out.println("☆ 너무 빨라요 ! 속도를 줄여주세요 ! ☆");
						subRun = false;
					}
					break;
				case 2:
					System.out.println("☆ 끼이이이이익 - - - -  - - -  - - ☆");
					loginState.characterDTO.speed -= 10;
					if (loginState.characterDTO.speed <= 0) {
						System.out.println("☆ 차가 멈췄어요 - - - -  - - -  - - ☆");
						subRun = false;
					} else if (loginState.characterDTO.speed>0 && loginState.characterDTO.speed<=300) {
						System.out.println("현재속도: " + loginState.characterDTO.speed + "km/h");
						System.out.println("☆ - - - - - - - - -  - - -  - - ☆");
						subRun = false;
					} else {
						System.out.println("☆ 차가 멈췄어요 - - - -  - - -  - - ☆");
						subRun = false;
						
					}
					break;
				case 3:
					System.out.println("☆ 앗! 아이템 사용 - - - -  - - -  - - ☆");
					System.out.println(loginState.itemDTO.item);
					System.out.println("☆ - - - - - - - - - -  - - -  - - ☆");
					subRun = false;
					break;
				case 4:
					System.out.println(
							"☆" + loginState.nickName + "님의 " + loginState.characterDTO.name + "가(이) 주행을 종료합니다☆");
					subRun = false;
					run = false;
					break;
				default:

				}//select 종료
			} //while run 종료
		}
		
		
		
		
		
	}//게임서비스 메서드종료

}//클래스종료
