package ch05.ShinChanBank.service;

import java.util.Scanner;

import ch05.ShinChanBank.dto.AccountDTO;

public class KasukabeBankService { // 서비스 계층은 CRUD 위주로 생성
	
	String kasukabeMasterid = "kkmaster";
	String kasukabeMasterpw = "1234";
	//필드
	//생성자
	//메서드 (부메뉴,계좌생성,입출금,계좌이체,계좌삭제)

	public void menu(Scanner inputInt, Scanner inputStr, AccountDTO[] kasukabeBank, AccountDTO[] ActionBank) {
		
		boolean subRun = true;
		while (subRun) {
			
			System.out.println("↓↓↓ 떡잎은행 메뉴 ↓↓↓");
			System.out.println("---------------------------");
			System.out.println("1. 계좌만들기");
			System.out.println("2. 계좌목록");
			System.out.println("3. 입금하기");
			System.out.println("4. 출금하기");
			System.out.println("5. 계좌이체");
			System.out.println("6. 종료");
			System.out.println("---------------------------");
			System.out.print(">>> ");
			String select = inputStr.next();
			switch (select) {
			
			case "1" :

				System.out.println("☆ 계좌 만들기 ☆");
				System.out.println("---------------------------");
				CreateAccount(inputInt, inputStr, kasukabeBank);
				System.out.println("---------------------------");
				break;
			case "2" : // 직원용
				System.out.println("☆ 계좌 목록 ☆");
				System.out.println("---------------------------");
				AccountList(inputInt, inputStr, kasukabeBank);
				System.out.println("---------------------------");
				break;
			case "3" :
				System.out.println("☆ 입금하기 ☆");
				System.out.println("---------------------------");
				deposit (inputInt, inputStr, kasukabeBank, ActionBank);
				System.out.println("---------------------------");
				break;
			case "4" :
				System.out.println("☆ 출금하기 ☆");
				System.out.println("---------------------------");
				withdraw (inputInt, inputStr, kasukabeBank, ActionBank);
				System.out.println("---------------------------");
				break;
			case "5" :
				System.out.println("☆ 계좌이체 ☆");
				System.out.println("---------------------------");
				accountTransfer (inputInt, inputStr, kasukabeBank, ActionBank);
				System.out.println("---------------------------");
				break;
			case "6" :
				System.out.println("☆ 떡잎은행 종료하기 ☆");
				System.out.println("※ 크레용신짱 은행 시스템 화면으로 돌아갑니다 ※");
				subRun = false;
				break;
			default :
				System.out.println(" ! 잘못입력하셨습니다 다시입력해주세요 ! ");
				break;
				
				
			
			}// switch select 종료
			
			 
			
		}// subRun while 종료
		
	}//menu method 종료

private void accountTransfer(Scanner inputInt, Scanner inputStr, AccountDTO[] kasukabeBank, AccountDTO[] ActionBank) {
		// 계좌이체 메서드
	
	System.out.print("계좌번호: ");
	String ano = inputStr.next();
	System.out.print("받을계좌: ");
	String transferAno = inputStr.next();
	System.out.print("보낼금액: ");
	int money = inputInt.nextInt();
	
	
	// find Account 메서드는 배열에서 객체를 찾고, 찾은 객체를 리턴하는 역할을 함 (반복코드 배제용)
	// 돈을 보내주는 계좌 찾기
	AccountDTO sendAccount = findAccount (ano,kasukabeBank, ActionBank);
	// 돈을 받는 계좌 찾기
	AccountDTO receiveAccount = findAccount (ano,kasukabeBank, ActionBank);
	if (sendAccount == null) {
		System.out.println(" ~ 입력하신 계좌번호가 존재하지 않습니다 ㅠ.ㅠ ~ ");
		return;}
	
	if (receiveAccount == null) {
		System.out.println(" ~ 입력하신 계좌번호가 존재하지 않습니다 ㅠ.ㅠ ~ ");
		return;
	}
	
	if (sendAccount.getBalance() < money) {
		System.out.println(" ~ 잔액이 부족합니다 ㅠ.ㅠ ~ ");
		return;
	}
	sendAccount.setBalance(sendAccount.getBalance() - money);
	receiveAccount.setBalance(receiveAccount.getBalance() + money);
	System.out.println("계좌이체가 성공적으로 되었습니다");
	System.out.println("잔액: "+sendAccount.getBalance()+"원");
	
	
	}// 계좌이체 메서드 종료

private void withdraw(Scanner inputInt, Scanner inputStr, AccountDTO[] kasukabeBank, AccountDTO[] ActionBank) {
		// 출금 메서드
	
	System.out.print("계좌번호: ");
	String ano = inputStr.next();
	System.out.print("출금액: ");
	int money = inputInt.nextInt();
	
		AccountDTO inputAccount = findAccount (ano, kasukabeBank, ActionBank);
		// find Account 메서드는 배열에서 객체를 찾고, 찾은 객체를 리턴하는 역할을 함 (반복코드 배제용)
		if (inputAccount == null) {
			System.out.println(" ~ 입력하신 계좌번호가 존재하지 않습니다 ㅠ.ㅠ ~ ");
		}// if 종료
		else {
			if ((inputAccount.getBalance())>= money){
			
		inputAccount.setBalance(inputAccount.getBalance()-money);
		
		System.out.println("★ "+inputAccount.getOwner()+"님 출금이 완료되었습니다 ★");
		System.out.println("잔액: "+ inputAccount.getBalance()+"원");
		System.out.println("--------------------------------------------");
		}
			else  {
				System.out.println("~ 잔액이 부족합니다 ㅠ.ㅠ ~");
				
			}
		}
		}//withdraw 메서드 종료

private void deposit(Scanner inputInt, Scanner inputStr, AccountDTO[] kasukabeBank, AccountDTO[] ActionBank) {
		// 입금 메서드
		
	System.out.print("계좌번호: ");
	String ano = inputStr.next();
	System.out.print("입금액: ");
	int money = inputInt.nextInt();
	
	AccountDTO inputAccount = findAccount (ano, kasukabeBank,ActionBank);
	// find Account 메서드는 배열에서 객체를 찾고, 찾은 객체를 리턴하는 역할을 함 (반복코드 배제용)
	 if (inputAccount == null) {
		 System.out.println(" ~ 입력하신 계좌번호가 존재하지 않습니다 ㅠ.ㅠ ~ ");
	 }// if 종료
	 else {
	 
	 inputAccount.setBalance(inputAccount.getBalance()+money);
	 System.out.println("★ "+inputAccount.getOwner()+"님 입금이 완료되었습니다 ★");
	 System.out.println("잔액: "+ inputAccount.getBalance()+"원");
	 System.out.println("--------------------------------------------");
	 
	 
	 }
	}// deposit 메서드 종료

private AccountDTO findAccount(String ano, AccountDTO[] kasukabeBank, AccountDTO[] ActionBank) {
	// 입출금 , 이체에서 계좌번호를 이용해 객체를 찾는 반복코드 메서드
	
	AccountDTO account = null ; // 빈객체
	for (int i = 0; i<kasukabeBank.length; i++ ) {
		if (kasukabeBank[i] != null && kasukabeBank[i].getAno().equals(ano)) {
			// ano가 kasuakbeBank[i] 혹은 ActionBank[i]와 일치하는지 검사
			// kasukabeBank 에서 찾았다면
			// 일치하는게 있다면, 그 객체를 account에 넣기
				account = kasukabeBank[i];
				break;
			
		}
		if (ActionBank[i] != null && ActionBank[i].getAno().equals(ano)) {
				// acitonBank 에서 찾았다면
				// 일치하는게 있다면, 그 객체를 account에 넣기
				account = ActionBank[i];
				break;
			}
		
		
		}
	return account;
	}//for 종료
	


private void AccountList(Scanner inputInt, Scanner inputStr, AccountDTO[] kasukabeBank) {
	// 떡잎은행 직원용 계좌목록 관리 메뉴
	
	System.out.println("※ 관계자 외 출입금지 ※");
	System.out.print("ID: ");
	String id = inputStr.next();
	System.out.print("PW: ");
	String pw = inputStr.next();
	
	if (id.equals(kasukabeMasterid) && pw.equals(kasukabeMasterpw)) {
		
		System.out.println("↓↓↓ 떡잎마을 계좌 리스트 ↓↓↓");
		System.out.println("---------------------------");
		
		for (int i = 0; i< kasukabeBank.length; i++) {
			AccountDTO accountList = kasukabeBank[i];
			if (accountList != null) {
				System.out.print(accountList.getAno());
				System.out.print("\t");
				System.out.print(accountList.getOwner());
				System.out.print("\t");
				System.out.print(accountList.getBalance());
				System.out.print("\t\n");
			}//accountList null판단 if종료
			break;
		}//for종료
	
	}//관계자 로그인 성공 if 종료
	
	else {
		System.out.println(" ~ 관계자가 아니라서 출입할수없어요 ㅠ.ㅠ ~");
		
	} //else 종료
	
}// AccountList 메서드 종료

private void CreateAccount(Scanner inputInt, Scanner inputStr, AccountDTO[] KasukabeBank) {
	// 떡잎은행 배열에 새로운 객체를 넣는다
	
	AccountDTO myAccount = new AccountDTO(); // 빈객체 생성
	System.out.print("계좌번호: ");
	myAccount.setAno(inputStr.next());
	System.out.print("계좌주: ");
	myAccount.setOwner(inputStr.next());
	System.out.print("입금액: ");
	myAccount.setBalance(inputInt.nextInt()); // 21억 한도
	myAccount.setBankName("떡잎"); // 빈객체에 데이터 입력 완료
	
	// 떡잎은행 배열에 객체를 삽입 (null인지 확인하고 넣을것)
	for (int i = 0; i<KasukabeBank.length; i++) {
		
		if (KasukabeBank[i] == null) {
			//떡잎은행 배열에 null 값이 있으면 처리하는 코드
			KasukabeBank[i] = myAccount; // 배열에 입력한 객체가null에 삽입된다
		//	System.out.println("계좌 입력 완료 테스트: "+KasukabeBank[i]);
			break;
		}//if종료
		else { System.out.println("~ 계좌 만들기가 안돼요 다시 해주세요 ㅠ.ㅠ ~");
		
		}// else 종료
	}//for 종료
	
	System.out.println(" ☆ 떡잎은행 계좌가 성공적으로 만들어졌습니다 ☆ ");
	
}// 계좌생성 메서드종료

}//class 종료
