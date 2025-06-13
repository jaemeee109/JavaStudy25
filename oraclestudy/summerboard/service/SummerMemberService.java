package summerboard.service;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.Scanner;

import summerboard.summerBoardExam;
import summerboard.dao.SummerMemberDAO;
import summerboard.dto.SummerMemberDTO;



public class SummerMemberService {
	
	public SummerMemberDAO summerMemberDAO = new SummerMemberDAO();
	public SummerMemberDTO summerMemberDTO =  new SummerMemberDTO();

	public void SubMenu(Scanner inputStr, SummerMemberDTO session) throws SQLException {
	//  부메뉴, 생성, 모두보기, 1개보기, 수정하기, 삭제하기
		
		
		boolean subRun = true;
		while (subRun) {
			
			System.out.println("=============== ☆ ★ ☆ 회 원 ☆ ★ ☆ ===============");
			System.out.println("| 1. 회원가입 | 2. 로그인 | 3. 게시판 | 4. 회원조회 | 5. 회원탈퇴 | 6. 종료 |");
			System.out.print("▷ ");
			String select = inputStr.next();
			
			switch (select) {
			case "1" :
				System.out.println("=============== ☆ ★ ☆ 회 원 가 입 ☆ ★ ☆ ===============");
				memberJoin(summerMemberDAO,summerMemberDTO, inputStr);
				break;
			case "2" :
				System.out.println("=============== ☆ ★ ☆ 로 그 인 ☆ ★ ☆ ===============");
				session = memberLogin(inputStr);
				break;
			case "3" :
				System.out.println("=============== ☆ ★ ☆ 회 원 용 게 시 판 ☆ ★ ☆ ===============");
				LoginMemberService loginMemberService = new LoginMemberService();
				if (session == null) {
					System.out.println(" ~ 로 그 인 해 주 세 요 ㅠ.ㅠ ~ ");
					return;
				}
				loginMemberService.SubMenu(inputStr, session);
				break;
			case "4" :
				System.out.println("=============== ☆ ★ ☆ 회 원 정 보 ☆ ★ ☆ ===============");
				memberInfor(inputStr);
				break;
			case "5" :
				System.out.println("=============== ☆ ★ ☆ 회 원 탈 퇴 ☆ ★ ☆ ===============");
				memberDelete(inputStr);
				break;
			case "6" :
				System.out.println("=============== ☆ ★ ☆ 회 원 안 내 종 료 ☆ ★ ☆ ===============");
				subRun = false;
				break;
			default : System.out.println(" ~ 잘 못 입 력 하 셨 습 니 다 ㅠ . ㅠ ~ ");
				break;
			
			}// select 종료
			
		}// while 종료
		
		
	} // SubMunu 메서드 종료

	private void memberDelete(Scanner inputStr) throws SQLException{
		// 회원 탈퇴
		
		System.out.println(" * 본 인 확 인 을 위 해 ID, PW 를 입 력 하 세 요 * ");
		System.out.print("ID ▷ ");
		String delId = inputStr.next();
		System.out.print("PW ▷ ");
		String delPw = inputStr.next();
		summerMemberDAO.memberDelete(delId,delPw,inputStr);
		
	}//memberDelete 메서드 종료

	private void memberInfor(Scanner inputStr) throws SQLException {
		// 회원정보 (개인 조회
		
		Scanner inputInt = new Scanner(System.in);
		boolean run = true;
		while(run) {
		System.out.println("------------------------------------");
		System.out.println(" 1. 회원정보 |  2. 회원정보수정 | 3. 종료 ");
		System.out.print("▷ ");
	    int select = inputInt.nextInt();
	    switch(select) {
	    
	    case 1 : 
	    	System.out.println(" ~ ~ ~ ☆ ★ ☆  회 원 정 보 확 인 ☆ ★ ☆ ~ ~ ~");
	    	System.out.println(" * ID를 한번 더 입력해주세요");
	    	System.out.print("▷ ");
	    	String checkid = inputStr.next();
	    	summerMemberDAO.memberInfor(checkid, inputStr);
	    	
	    	break;
	    	
	    case 2 :
	    	System.out.println(" ~ ~ ~ ☆ ★ ☆  회 원 정 보 수 정 ☆ ★ ☆ ~ ~ ~ ");
	    	System.out.println(" * PW 를 한번 더 입력해주세요 ");
	    	System.out.print("▷ ");
	    	String checkpw = inputStr.next();
	    	summerMemberDAO.memberUpdate(checkpw, inputStr);
	    	
	    	break;
	    case 3 :
	    	System.out.println(" ~ 회 원 정 보 를 종 료 합 니 다 ~");
	    	run = false;
	    	break;
	    
	    }//switch 종료
		} // while 종료
		
	}// memberInfor 메서드 종료

	private SummerMemberDTO memberLogin(Scanner inputStr) throws SQLException{
		// 로그인
		
		SummerMemberDTO summerMemberDTO = new SummerMemberDTO();
		
		System.out.print("ID ▷");
		String id = inputStr.next();
		System.out.print("PW ▷");
		String pw = inputStr.next();
		
		summerMemberDTO = summerMemberDAO.memberLogin(id, pw);
		
		return summerMemberDTO;
	} // memberLogin 메서드 종료

	private void memberJoin(SummerMemberDAO summerMemberDAO , SummerMemberDTO summerMemberDTO, Scanner inputStr) throws SQLException {
		// 회원가입
		
		System.out.print("ID ▷ ");
		summerMemberDTO.setId(inputStr.next());
		System.out.print("PW ▷ ");
		summerMemberDTO.setPw(inputStr.next());
		System.out.print("NICNAME ▷ ");
		summerMemberDTO.setMname(inputStr.next());
		
		
		
		summerMemberDAO.memberJoin (summerMemberDAO, summerMemberDTO ,inputStr); // 위에서 만든 객체를 DAO에게 전달
	
		
	} // memberJoin 메서드 종료

} //class 종료
