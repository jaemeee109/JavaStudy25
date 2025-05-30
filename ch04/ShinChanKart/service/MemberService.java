package ch04.ShinChanKart.service;

import java.util.Scanner;

import javax.print.attribute.standard.DateTimeAtCreation;

import ch04.ShinChanKart.dto.MemberDTO;

public class MemberService {
	// 회원 관리용 클래스, CRUD+@ 제공
	// 부메뉴용
	
	// 필드
	// 기본 생성자는 자동으로 생성
	// 메서드
	
	// 부메뉴용 메서드 => 필요한 파라미터? -> (입력객체, 회원배열,로그인상태)
	
	public MemberDTO menu (Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
		
		System.out.println("* 회원관리 메뉴입니다");
		boolean subrun = true;
		while (subrun) {
			System.out.println(" 1. 가입 | 2. 로그인 | 3. 수정 | 4. 탈퇴 | 5. 종료");
			System.out.print(">>>");
			String select = input.next();
			switch (select) {
			case "1" :
				System.out.println("* 회원가입");
				create(input, memberDTOs);
				break;
				
			case "2" :
				System.out.println("* 로그인");
				loginState = login (input,memberDTOs,loginState);
				subrun = false;
				break;
				
			case "3" :
				System.out.println("* 회원정보 수정");
				loginUpdate (input, memberDTOs,loginState);
				break;
				
			case "4" :
				System.out.println("* 회원탈퇴");
				loginDelete (input, memberDTOs, loginState);
				
				break;
				
			case "5" :
				System.out.println("* 회원관리 페이지를 종료합니다");
				System.out.println("* 메인메뉴로 돌아갑니다");
				subrun = false;
				break;
				
			case "99" :
				System.out.println("* 히든메뉴로 진입했습니다");
				System.out.println("* 캐릭터 해킹을 시도합니다");
				
			default : 
				System.out.println("* 다시입력해주세요");
			}//switch select 종료
//			subrun = false;
		}// while subrun 종료
		
		return loginState;
		
	}// MemberDTO menu method 종료

	private void loginDelete(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
		// 회원 탈퇴용 메서드
		
		System.out.println("* 회원 정보를 확인하기 위한 인증을 시작합니다");
		System.out.print("ID:");
		String id = input.next();
		System.out.print("PW:");
		String pw = input.next();
		
		for (int i = 0; i< memberDTOs.length; i++) {
			if (memberDTOs[i]!=null && memberDTOs[i].id.equals(id)&&
					memberDTOs[i].pw.equals(pw)) {
				System.out.println("* 회원인증이 완료되었습니다");
				System.out.println("ID: "+ memberDTOs[i].id);
				System.out.println("PW: "+ memberDTOs[i].pw);
				System.out.println("E-mail: " + memberDTOs[i].email);
				System.out.println("Nickname: " + memberDTOs[i].nickName);
				System.out.println("-----------------------------------");
				System.out.println("* 회원탈퇴를 하시겠습니까?");
				System.out.println("1. 예 | 2. 아니오");
				System.out.print(">>>");
				int select = input.nextInt();
				switch (select) {
				case 1:
					memberDTOs[i]=null;
					System.out.println("* 회원 탈퇴를 완료하였습니다");
					break ;
				case 2:
					System.out.println("* 메인 메뉴로 돌아갑니다");
					break;
		
				default :
				
				
				}//switch select 종료
			}//if종료
			else {
				System.out.println("* 일치하지 않습니다 다시입력해주세요");
			}
		}//for 종료
				
				
			
				
	}// login Delete 메서드 종료

	private MemberDTO loginUpdate(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
		// 회원 수정용 메서드
		
		System.out.println("* 회원 정보를 수정하기 위한 인증을 시작합니다");
		System.out.print("ID:");
		String id = input.next();
		System.out.print("PW:");
		String pw = input.next();
		System.out.print("E-mail: ");
		String email = input.next();
		
		
		for (int i = 0; i< memberDTOs.length; i++) {
			if (memberDTOs[i]!=null && memberDTOs[i].id.equals(id)&&
					memberDTOs[i].pw.equals(pw)&& memberDTOs[i].email.equals(email)) {
				System.out.println("* 회원인증이 완료되었습니다");
				System.out.println("ID: "+ memberDTOs[i].id);
				System.out.println("PW: "+ memberDTOs[i].pw);
				System.out.println("E-mail: " + memberDTOs[i].email);
				System.out.println("Nickname: " + memberDTOs[i].nickName);
				System.out.println("-----------------------------------");
				System.out.println("ID는 수정이 불가능합니다");
				System.out.print("PW update: ");
				String updatepw = input.next();
				System.out.print("E-mail update: ");
				String updateemail = input.next();
				System.out.print("NickName update: ");
				String updatenickname = input.next();
				
				
				MemberDTO loginMember = new MemberDTO();
				loginMember.pw = memberDTOs[i].pw;
				loginMember.email = memberDTOs[i].email; 
				loginMember.nickName = memberDTOs[i].nickName;
				
				loginState = memberDTOs[i]; // 배열에 있는 정보가 login 상태 객체에 삽입
				
				System.out.println("* 회원정보 수정이 완료되었습니다");
				
				break;
				
			
			}//if종료
			
			else { System.out.println("* 다시입력해주세요");
				
			}
		}//for 종료
		return loginState;
		
	}// loginUpdate method 종료

	private MemberDTO login(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
		// 로그인용 메서드
		
		System.out.print("ID: ");
		String id = input.next();
		System.out.print("PW: ");
		String pw = input.next();
		
		MemberDTO loginMember = new MemberDTO();
		loginMember.id = id;
		loginMember.pw = pw;
		
		for (int i = 0; i< memberDTOs.length; i++) {
			if (memberDTOs[i]!=null && memberDTOs[i].id.equals(loginMember.id)&&
					memberDTOs[i].pw.equals(loginMember.pw)) {
				System.out.println("* 로그인 성공");
				loginState = memberDTOs[i]; // 배열에 있는 정보가 login 상태 객체에 삽입
				break;
			}//if종료
			
		}//for 종료
		
		return loginState;
	}// MemberDTO login method 종료

	private void create(Scanner input, MemberDTO[] memberDTOs) {
		// 회원가입용 메서드
		
		System.out.println("* 회원가입을 시작합니다");
		
		MemberDTO memberDTO = new MemberDTO(); // 빈 객체 생성
		
		System.out.print("ID: ");
		memberDTO.id = input.next();
		System.out.print("PW: ");
		memberDTO.pw = input.next();
		System.out.print("NICKNAME: ");
		memberDTO.nickName = input.next();
		System.out.print("E-mail: ");
		memberDTO.email = input.next();
		// 빈 memberDTO 객체에 필드값 입력 완료
		
		// 배열에 0~null 값이면 삽입 (exam)
		for (int i = 0; i< memberDTOs.length; i++) {
			if (memberDTOs[i]==null) {// null이면 값이 없음
				memberDTOs[i]=memberDTO;
				break;
			}//if종료
		}//for종료
		
		
	}//create method 종료

}// MemberService class 종료
