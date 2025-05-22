package ch03;

import java.util.Scanner;

public class VendingMachineExam {
	
	static String[] menunames;
	static int[] menucosts;
	static int[] menuprices;
	static int[] menuinvs;
	static int[] buyerSelectno;

	public static void main(String[] args) {
		// 자판기머신 프로그램 만들기
		

		
		Scanner inputStr = new Scanner (System.in);
		Scanner inputInt = new Scanner(System.in);
		String masterid = "master";
		String masterpw = "000000" ;
	


		
		
		boolean run = true;
		while (run) {		
		System.out.println("===== 자판기 프로그램을 실행합니다 =====");
		System.out.println("* 관리자모드");
		System.out.println("* 사용자모드");
		System.out.println("- 원하시는 모드를 입력해주세요");
		System.out.print(">>>>> ");
		String usermod = inputStr.next();	
		
			switch (usermod) {
			case "관리자모드":
			case "관리자":
				System.out.println("===== 관리자 모드 로그인 =====");
				System.out.print("ID : ");
				String usermodid = inputStr.next();
				System.out.print("PW : ");
				String usermodpw = inputStr.next();

				if (usermodid.equals(masterid) && usermodpw.equals(masterpw)) {
		
					Mastermod (usermod,usermodid, masterid,usermodpw,masterpw);
				} else { // 관리자 로그인 실패
					System.out.println("===== 다시 입력해주세요 =====");
				} // if 종료
				break; // 관리자모드 종료

			case "사용자모드":
			case "사용자":
				System.out.println("===== 사용자 모드 =====");
				Buyermod (menunames,menucosts,menuprices,menuinvs,buyerSelectno);
				break;
			default:
				System.out.println("잘못입력하셨습니다");
			
			}//switch usermod 종료
		}//while 종료
		
	}//main method 종료

	  static void Buyermod(String[] menunames, int[] menucosts, int[] menuprices, int[] menuinvs,int[] buyerSelectno) {
		// 사용자모드
		  Scanner inputStr = new Scanner(System.in);
		  Scanner inputInt = new Scanner(System.in);
		  
		  
		 boolean runselect = true;
			for(int i = 0; i < menunames.length; i++) { 
				System.out.println("======= 자판기 메뉴 =======");
				System.out.println("["+menunames[i]+"]"+": "+menuprices[i]+"원");
				}//for 종료
			System.out.println("-----------------------------------------");
			System.out.println("*충전하실 금액을 입력하세요");
			System.out.print(">>>>> ");
			int money1 = inputInt.nextInt();
			System.out.println("* 원하시는 메뉴를 입력하세요");
			System.out.print(">>>>> ");
			String buyerselect = inputStr.next();
				for (int i= 0; i< menunames.length; i++) {
					if (buyerselect.equals(menunames[i])){
						System.out.println("* 원하시는 메뉴의 구매 개수를 입력하세요");
						System.out.print(">>>>> ");
						buyerSelectno[i] = inputInt.nextInt();
						System.out.println("* 구매완료");
						System.out.println("*거스름돈 : "+ (money1-(menuprices[i]*buyerSelectno[i])+ "원"));
				}//if종료
					
				//default : 
					//	System.out.println("* 등록되지 않은 메뉴입니다");
					}//else 종료
				}//for종료
				

			
			
		
//Buyermod method 종료

	static void Mastermod(String usermod, String usermodid, String masterid, String usermodpw,
			String masterpw) {
		// 관리자모드 
		 
		 boolean mastermodrun = true;
		 while (mastermodrun) {
			Scanner inputStr = new Scanner(System.in);
			Scanner inputInt = new Scanner(System.in);
			System.out.println("===== 관리자 모드  =====");
			System.out.println("* 원하시는 카테고리를 선택해주세요");
			System.out.println("1. 메뉴입력");
			System.out.println("2. 메뉴관리");
			System.out.println("3. 메뉴수정");
			System.out.println("4. 통계");
			System.out.println("5. 로그아웃");
			System.out.print(">>> ");
			String select = inputStr.next();
			switch (select) {
			case "1":
			case "메뉴입력":
				System.out.println("* 자판기에 등록할 메뉴를 입력해주세요");
				System.out.print("등록할 메뉴 개수 입력 : ");
				int menuadd = inputInt.nextInt();

				menunames = new String[menuadd];
				menucosts = new int[menuadd];
				menuprices = new int[menuadd];
				menuinvs = new int[menuadd];
				buyerSelectno = new int [menuadd];

				for (int i = 0; i < menunames.length; i++) {
					System.out.print("메뉴명 : ");
					menunames[i] = inputStr.next();
					System.out.print("원가 : ");
					menucosts[i] = inputInt.nextInt();
					System.out.print("판매가격 : ");
					menuprices[i] = inputInt.nextInt();
					System.out.print("재고 : ");
					menuinvs[i] = inputInt.nextInt();
					System.out.println("===============================");
				} // for 종료
				System.out.println("===== 자판기 메뉴 등록이 완료되었습니다 =====");
				break;
			case "2":
			case "메뉴관리":
				System.out.println("========== 자판기 메뉴 현황 ==========");
				for (int i = 0; i < menunames.length; i++) {
					System.out.println("[" + menunames[i] + "] 재고: " + (menuinvs[i]-buyerSelectno[i]) + "개 / 원가: " + menucosts[i]
							+ "원/ 판매가격: " + menuprices[i] + "원");
					System.out.println("===============================");
				} //for 종료
				break;
			case "3":
			case "메뉴수정":
				System.out.println("========== 자판기 메뉴 수정 ==========");
				System.out.println("* 수정을 원하시는 상품을 입력하세요");
				System.out.print(">>>>> ");
				String change = inputStr.next();

				boolean edit = true;
				for (int i = 0; i < menunames.length; i++) {
					if (menunames[i].equals(change)) {
						System.out.println("[" + menunames[i] + "] 재고: " + menuinvs[i] + "개 / 원가: " + menucosts[i]
								+ "원/ 판매가격: " + menuprices[i] + "원");
						System.out.println("--------위 상품에 대한 정보를 수정합니다--------");
						System.out.print(" 상품명 : ");
						menunames[i] = inputStr.next();
						System.out.print(" 재고 : ");
						menuinvs[i] = inputInt.nextInt();
						System.out.print(" 원가 : ");
						menucosts[i] = inputInt.nextInt();
						System.out.print(" 판매가격 : ");
						menuprices[i] = inputInt.nextInt();
						System.out.println("-------- 상품에 대한 수정이 완료되었습니다 --------");
					}//if 종료
					if (!edit) {
						System.out.println("* 잘못 입력 하셨습니다");
						edit = false;

					} //if종료
				} //for 종료
				break;
			case "4":
			case "통계":
				
				for (int i = 0; i < menunames.length; i++) {
					int total = buyerSelectno[i] * menuprices[i];
					int sales = buyerSelectno[i] * menucosts[i];
					
					System.out.println("========== 자판기 매출 현황 ==========");
					System.out.println("[" + menunames[i] + "]의  판매량: " +buyerSelectno[i] + "개/ 총매출: " + total + "원/ 순매출: " + sales + "원");
				}//for종료
				break;
			case "5":
			case "로그아웃":
				System.out.println("* 로그아웃 되었습니다 ");
				mastermodrun = false; 
				break;
			default:
				System.out.println("* 로그아웃 되었습니다");
				break;
			}//select case 종료
		}//mastsermod while종료
			
		 
		
	}// Mastermod method 종료



}//class 종료
