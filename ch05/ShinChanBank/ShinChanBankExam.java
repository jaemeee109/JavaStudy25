package ch05.ShinChanBank;

import java.util.Scanner;

import ch05.ShinChanBank.dto.AccountDTO;
import ch05.ShinChanBank.service.ActionBankService;
import ch05.ShinChanBank.service.KasukabeBankService;

public class ShinChanBankExam {
	
	//필드
	public static Scanner inputInt = new Scanner(System.in);
	public static Scanner inputStr = new Scanner(System.in);
	
	public static AccountDTO[] KasukabeBank = new AccountDTO [10];
	public static AccountDTO[] ActionBank = new AccountDTO [10];
	public static AccountDTO session = null;

	
	// 생성자 -> 정적블럭 : 메인메서드 초기화값
		
		static {
			AccountDTO accountDTO0 = new AccountDTO("1234","신짱구",200000,"액션");
			AccountDTO accountDTO1 = new AccountDTO("5678","신형만",200000,"떡잎");
			AccountDTO accountDTO2 = new AccountDTO("9876","봉미선",200000,"떡잎");
			
		}
		
		public static void main(String[] args) {
			// 은행을 만들어 계좌를 관리
			// 테스트 코드 작성
			// 기본값 입력 더미데이터 출력용 코드 → to String 오버라이딩으로 볼 수 있다
			
			//System.out.println("떡잎은행 더미데이터 출력 테스트: "+ KasukabeBank[0]);
		//	System.out.println("액션은행 더미데이터 출력 테스트: "+ ActionBank[0]);
			

			
			
			
			boolean run = true ; // 주메뉴 반복용
			while (run) {// 주메뉴 반복용
				

				System.out.println("======== ☆ 크레용신짱 은행시스템 ☆ ========");
				System.out.println("1. 떡잎은행");
				System.out.println("2. 액션은행");
				System.out.println("3. 종료");
				System.out.print(">>> ");
				String select = inputStr.next();
				switch (select) {
				
				case "1" :
					System.out.println(" ☆ 안녕하세요 떡잎은행 입니다 ☆ ");
					KasukabeBankService kasukabeBankService = new KasukabeBankService();
					kasukabeBankService.menu(inputInt,inputStr,KasukabeBank,ActionBank);
					break;
				case "2" :
					System.out.println(" ☆ 안녕하세요 액션은행 입니다 ☆ ");
					ActionBankService actionBankService = new ActionBankService();
					actionBankService.menu(inputInt,inputStr,ActionBank,KasukabeBank);
					break;
				case "3" :
					System.out.println(" ☆ 안녕히가세요 ☆ ");
					run = false;
					break;
				default :
					System.out.println(" ! 잘못입력하셨습니다 다시입력해주세요 ! ");
					break;
				
				}// switch select 종료
			}//while run 종료

		

	} // main method 종료

} // class 종료
