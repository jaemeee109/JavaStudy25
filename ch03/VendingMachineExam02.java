package ch03;

import java.util.Scanner;

public class VendingMachineExam02 {

	static String[] menuNames; //메뉴명
	static int[] menuCosts; //메뉴원가
	static int[] menuPrices; //메뉴판매가격
	static int[] menuInvs; // 메뉴재고
	static int[] buyerSelectNo; //사용자의 구매 개수


	public static void main(String[] args) {
		// 자판기 프로그램 만들기


		
		Scanner inputStr = new Scanner(System.in);
		Scanner inputInt = new Scanner(System.in);
		String masterId = "master";
		String masterPw = "000000";
		
		boolean run = true;
		while (run) {
			System.out.println("=== 자판기 프로그램을 시작합니다 ===");
			System.out.println("* 관리자모드");
			System.out.println("* 사용자모드");
			System.out.println("*원하시는 모드를 입력해주세요");
			System.out.print(": ");
			String mod = inputStr.next();

			switch (mod) {

			case "관리자모드":
			case "관리자":
				System.out.println("===== 관리자모드 실행을 위해 로그인 해주세요 =====");
				System.out.print("ID : ");
				String modId = inputStr.next();
				System.out.print("PW : ");
				String modPw = inputStr.next();

				if (modId.equals(masterId) && modPw.equals(masterPw)) {
					MasterMod(mod, modId, modPw, masterId, masterPw);
				} else {
					System.out.println("※ 다시 입력 해주세요 ※");

				} //if종료
				break; // 관리자모드 중지
			case "사용자모드":
			case "사용자":
				 if (menuNames == null || menuNames.length == 0) {
				        System.out.println("※ 상품이 등록되지 않아 구매가 불가능합니다 ※");
			   } else { 
				   System.out.println("===== OOO 자판기를 이용해주셔서 감사합니다 =====");
				   BuyerMod (menuNames, menuCosts, menuPrices, menuInvs, buyerSelectNo);
			   }
			break; // 사용자모드 중지
			default:
				System.out.println("※ 존재하지 않는 모드입니다 ※");
				break;

			}//mod switch 종료
		}//while 종료
		
		
	}// main method 종료

	  static void BuyerMod(String[] menuNames, int[] menuCosts, int[] menuPrices, int[] menuInvs, int[] buyerSelectNo
			) {
		// 사용자모드
		  Scanner inputStr = new Scanner(System.in);
		  Scanner inputInt = new Scanner(System.in);
		  
			System.out.println("======= 자판기 메뉴 =======");	  
			
			
			 	for(int i = 0; i < menuNames.length; i++) { 
					System.out.println("["+menuNames[i]+"]"+": "+menuPrices[i]+"원");
					}//for 종료
				System.out.println("-----------------------------------------");
				System.out.println("*충전하실 금액을 입력하세요");
				System.out.print(">>>>> ");
				int money1 = inputInt.nextInt();
				System.out.println("* 원하시는 상품을 입력하세요");
				System.out.print(">>>>> ");
				String buyerSelect = inputStr.next();
				
				
					for (int i= 0; i< menuNames.length; i++) {
						if (buyerSelect.equals(menuNames[i])){
							System.out.println("* 원하시는 상품 구매 수량을 입력하세요");
							System.out.print(">>>>> ");
							buyerSelectNo[i] = inputInt.nextInt();
							if ((buyerSelectNo[i] * menuPrices[i]) <= money1)
								{System.out.println("* 구매완료");
								System.out.println("*남은금액 : "+ (money1-(menuPrices[i]*buyerSelectNo[i])+ "원"));
								
								System.out.println("다른 상품도 구매하시겠습니까?");
								System.out.println("1. 예 / 2. 아니오 ");
								System.out.print(">>>>>");
								String buyAdd = inputStr.next();
								
									switch (buyAdd) {
									
									case "예" :
									case "1" :
										System.out.println("*추가로 구매를 원하시는 상품을 입력하세요");
										System.out.print(">>>>> ");
										String buyerSelectAddName = inputStr.next();
										boolean found = false;
										for (int x = 0; x <menuNames.length;x++)
											if (buyerSelectAddName.equals(menuNames[x])) {
												found = true;
												System.out.println("*추가 구매할 상품 수량을 입력하세요 ");
											System.out.print(">>>>>");
											int buyerSelectAdd =inputInt.nextInt();
												if (menuInvs[x]-buyerSelectNo[x]>=buyerSelectAdd) {
													buyerSelectNo[x] += buyerSelectAdd ;
													System.out.println("*추가 구매가 완료되었습니다");
													int money2 = menuPrices[i]*buyerSelectNo[i];
													int money3 = menuPrices[x]*buyerSelectNo[x];
													System.out.println("*거스름돈 : "+ (money1-money2-money3) + "원을 사용자에게 반환합니다");
												} else {
												System.out.println("*** 구매가 불가능합니다 ***");
												
											}break;
									
								} if(!found) {
												System.out.println("*** 구매가 불가능합니다 ***");
											}
						

									break;
								    case "아니오" :
								    case "2" :
								    break;
								    default:
										System.out.println("*** 잘못 입력하셨습니다 다시 입력해주세요");
									
							        break;
					                }//switch 종료
							}else  {
						System.out.println("*** 구매가 불가능합니다");
					}//else if종료
						}//buyerSelectif종료
						}//for종료
	}//BuyerMod method종료

	static void MasterMod(String mod, String modId, String modPw, String masterId, String masterPw) {
		// 관리자모드
		
		 Scanner inputStr = new Scanner(System.in);
		 Scanner inputInt = new Scanner(System.in);
		 
		 boolean masterModRun = true;
		 while (masterModRun) {
			System.out.println("========== 관리자모드 ==========");
			System.out.println("* 원하시는 카테고리를 입력해주세요");
			System.out.println("1. 메뉴입력");
			System.out.println("2. 메뉴관리");
			System.out.println("3. 메뉴수정");
			System.out.println("4. 통계");
			System.out.println("5. 로그아웃");
			System.out.print(": ");
			String select = inputStr.next();
			switch (select) {
			case "1":
			case "메뉴입력":
				System.out.println("===== 자판기에 등록할 메뉴를 입력합니다 =====");
				System.out.println("------------------------------");
				System.out.print("등록할 메뉴 개수 : ");
				int menuAdd = inputInt.nextInt();

				menuNames = new String[menuAdd];
				menuCosts = new int[menuAdd];
				menuPrices = new int[menuAdd];
				menuInvs = new int[menuAdd];
				buyerSelectNo = new int[menuAdd];
				for (int i = 0; i < menuNames.length; i++) {
					System.out.print("상품명 : ");
					menuNames[i] = inputStr.next();
					System.out.print("원가 : ");
					menuCosts[i] = inputInt.nextInt();
					System.out.print("판매가격 : ");
					menuPrices[i] = inputInt.nextInt();
					System.out.print("입고 : ");
					menuInvs[i] = inputInt.nextInt();
					System.out.println("------------------------------");
				} //for종료
				System.out.println("===== 자판기 메뉴 등록이 완료되었습니다 =====");
				break; // 1 중지
			case "2":
			case "메뉴관리":
				System.out.println(" === 자판기에 등록되어있는 상품의 현황 안내 ===");
				for (int i = 0; i < menuNames.length; i++) {
			System.out.println("[" + menuNames[i] + "] 재고: " + (menuInvs[i] - buyerSelectNo[i]) + "개 / 원가: "
							+ menuCosts[i] + "원/ 판매가격: " + menuPrices[i] + "원");
					System.out.println("------------------------------");
				} //for i 종료
		
				break; //2 중지
			case "3":
			case "메뉴수정":
				System.out.println("========== 자판기 메뉴 수정 ==========");
				System.out.println("* 수정을 원하시는 상품을 입력하세요");
				System.out.print(": ");
				String change = inputStr.next();

				boolean edit = false;
				for (int i = 0; i < menuNames.length; i++) {
					if (menuNames[i].equals(change)) {
						System.out.println("[" + menuNames[i] + "] 재고: " + menuInvs[i] + "개 / 원가: " + menuCosts[i]
								+ "원/ 판매가격: " + menuPrices[i] + "원");
						System.out.println("--------위 상품에 대한 정보를 수정합니다--------");
						System.out.print(" 상품명 : ");
						menuNames[i] = inputStr.next();
						System.out.print(" 재고 : ");
						menuInvs[i] = inputInt.nextInt();
						System.out.print(" 원가 : ");
						menuCosts[i] = inputInt.nextInt();
						System.out.print(" 판매가격 : ");
						menuPrices[i] = inputInt.nextInt();
						System.out.println("-------- 상품에 대한 수정이 완료되었습니다 --------");
						edit = true;
						break;
					}//if종료
					} //for종료
					if (!edit) {
						System.out.println("* 잘못입력하셨습니다");
					} //if종료
				
				break; //3 중지
			case "4":
			case "통계":
				System.out.println("========== 자판기 매출 현황 ==========");
				for (int i = 0; i < menuNames.length; i++){
					int total = buyerSelectNo[i]* menuPrices[i];
					int sales = buyerSelectNo[i]* menuCosts[i];

					System.out.println("[" + menuNames[i] + "]의  판매량: " + buyerSelectNo[i] + "개/ 총매출: " + total
							+ "원/ 순이익: " + sales + "원/ 남은재고: "+ (menuInvs[i]-buyerSelectNo[i]));
				
				}//for종료
				break; //4 중지
			case "5":
			case "로그아웃":
				System.out.println("* 로그아웃 되었습니다 ");
				masterModRun = false; 
				break;//5 중지
			default:
				System.out.println("* 로그아웃 되었습니다 ");
				break;//default 중지

			}//select switch 종료
		}//masterModRun While 종료
		 
		 
	}// MasterMod method 종료
}//class 종료
