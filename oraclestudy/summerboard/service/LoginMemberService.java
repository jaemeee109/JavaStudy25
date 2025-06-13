package summerboard.service;

import java.sql.SQLException;
import java.util.Scanner;

import summerboard.summerBoardExam;
import summerboard.dao.SummerMBoardDAO;
import summerboard.dto.SummerBoardDTO;
import summerboard.dto.SummerMemberDTO;

public class LoginMemberService {
	// 필드

	public SummerBoardDTO summerBoardDTO = new SummerBoardDTO();
	public SummerMemberDTO summerMemberDTO = new SummerMemberDTO();
	public SummerMBoardDAO summerMBoardDAO = new SummerMBoardDAO();
	
	public void SubMenu(Scanner inputStr, SummerMemberDTO session) throws SQLException {
		// 로그인회원 게시판 메뉴
		
		boolean run = true;
		while (run) {
		System.out.println(" 1. 전 체 글 목 록 ");
		System.out.println(" 2. 게 시 글 작 성 ");
		System.out.println(" 3. 내 가 쓴 글 목 록");
		System.out.println(" 4. 내 가 쓴 글 수 정 ");
		System.out.println(" 5. 내 가 쓴 글 삭 제");
		System.out.println(" 6. 회 원 게 시 판 종 료 ");
		System.out.print("▷ ");
		String select = inputStr.next();
		
		switch (select) {
		
		case "1" :
		System.out.println("=============== ☆ ★ ☆ 전 체 글 목 록 ☆ ★ ☆ ===============");
		MboardAll(summerMBoardDAO);
			break ;
		case "2" :
			System.out.println("=============== ☆ ★ ☆ 게 시 글 작 성 ☆ ★ ☆ ===============");
			MboardAdd(inputStr, session);
				break ;
		case "3" :
			System.out.println("=============== ☆ ★ ☆ 내 가 쓴 글 목 록 조 회 ☆ ★ ☆ ===============");
			Myboard(session);
				break ;
		case "4" :
			System.out.println("=============== ☆ ★ ☆ 내 가 쓴 글 수 정 ☆ ★ ☆ ===============");
			Scanner inputLine = new Scanner(System.in);
			MyboardUp(session, inputStr, inputLine);
				break ;
		case "5" :
			System.out.println("=============== ☆ ★ ☆ 내 가 쓴 글 삭 제 ☆ ★ ☆ ===============");
			MyboardDel();
				break ;
		case "6" :
			System.out.println("=============== ☆ ★ ☆ 회 원 게 시 판 종 료 ☆ ★ ☆ ===============");
				break ;
		default :
			System.out.println(" ~ 잘 못 입 력 하 셨 습 니 다 ㅠ . ㅠ ~ ");
			break;
		
		}//switch 종료
		} // while 종료
		
		
	}// SubMenu 메서드 종료

	



	private void MyboardDel() throws SQLException{
		// 내가 쓴 글 삭제
		SummerMemberDTO loginUser = summerBoardExam.session;
		Scanner inputInt = new Scanner(System.in);
		System.out.print("삭제하고 싶은 글 번호 ▷ ");
		int myNo = inputInt.nextInt();
		summerMBoardDAO.MyboardDel(myNo);
		
	}//MYboardDel 메서드 종료





	private void MyboardUp(SummerMemberDTO session, Scanner inputStr,Scanner inputLine) throws SQLException {
		// 내가 쓴 글 수정
		
		summerMBoardDAO.MyboardUp(session.getMname(), inputStr, inputLine);
		
	}//MyboardUp 메서드 종료





	private void Myboard(SummerMemberDTO session) throws SQLException {
		// 내 가 쓴 글 조회
		SummerBoardDTO summerBoardDTO = new SummerBoardDTO();
		summerMBoardDAO.Myboard(session.getMname());
		
	}//Myboard 메서드 종료

	private void MboardAdd(Scanner inputStr,  SummerMemberDTO session) throws SQLException{
		// 로그인 회원 글 작성
		SummerBoardDTO summerBoardDTO = new SummerBoardDTO();

		Scanner inputLine = new Scanner(System.in);
		System.out.print("제목 : ");
		summerBoardDTO.setBtitle(inputLine.nextLine());
		System.out.print("내용 : ");
		summerBoardDTO.setBcontent(inputLine.nextLine());
		summerBoardDTO.setBwriter(session.getMname());
		//System.out.println(session.getMname());
		
		summerMBoardDAO.MboardAdd(summerBoardDTO, inputLine);
		summerBoardDTO.setBwriter(session.getMname());
		
//		summerBoardDTO.setBwriter(loginUser.getMname());
//		summerMBoardDAO.MboardAdd(summerBoardDTO, loginUser,inputLine);
		
	} // MboardAdd 메서드 종료

	private static void MboardAll(SummerMBoardDAO summerMBoardDAO) throws SQLException {
		// 전체 글 목록
		
		summerMBoardDAO.MboardAll();
	} // MboardALL메서드 종료

} // class 종료
