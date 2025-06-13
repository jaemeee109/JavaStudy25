package summerboard;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.Scanner;

import summerboard.dto.SummerMemberDTO;
import summerboard.service.SummerBoardService;
import summerboard.service.SummerMemberService;

public class summerBoardExam {
	
	// 필드
	public static Scanner inputStr = new Scanner(System.in);
	public static SummerMemberDTO session = null;
	
	// 생성자 -> static 블럭
	
	// 메서드
	
	public static void main(String[] args) throws SQLException {
		// summerboard  test
		// DTO : 객체담당 / DAO : 데이터베이스 연동 담당 / service : 부메뉴와 서비스 담당
		
		boolean run = true;
		while (run) {
			System.out.println(" === 2025 여름 ☆ sUmMeR ☆ 에 오신걸 환영합니다  === ");
			System.out.println(" 1. 회원");
			System.out.println(" 2. 게시판");
			System.out.println(" 3. 종료 ");
			System.out.print("▷ ");
			String select = inputStr.next();
			switch (select) {
			
			case "1" :
				System.out.println(" ~ ☆ 회원으로 안내합니다 ☆ ~ ");
				SummerMemberService summerMemberService = new SummerMemberService();
				summerMemberService.SubMenu(inputStr, session);
				break;
			case "2" :
				System.out.println("~ ☆ [ 비 회 원 ] 자 유 게 시 판 으로  안내합니다 ☆ ~ ");
			SummerBoardService summerBoardService = new SummerBoardService();
			summerBoardService.SubMenu(inputStr);
				break;
			case "3" :
				System.out.println("===== 2025 여름 ☆ sUmMeR ☆ 을 종료합니다  =====");
				run = false;
				break;
				default : 
					System.out.println(" ~ 잘 못 입력하셨습니다 다시 입력해주세요 ㅠ.ㅠ ~");
					break;
			
			}// switch 종료
			
		}// while 종료
		
		
		
		
	

	} // main 메서드 종료

} // class 종료
