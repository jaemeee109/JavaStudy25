package otest250613.service;

import java.sql.SQLException;
import java.util.Scanner;

import otest250613.dao.BoardDAO;
import otest250613.dto.BoardDTO;
import otest250613.dto.OtestDTO;

public class BoardService {
	
	public OtestDTO otestDTO = new OtestDTO();
	public BoardDTO boardDTO = new BoardDTO();
	public BoardDAO boardDAO = new BoardDAO();
	


	public void SubMenu(Scanner inputStr, Scanner inputInt, OtestDTO session) throws SQLException {
		// 게시판 메뉴
		
		boolean run = true;
		while (run) {
		System.out.println("a. 게시판 조회");
		System.out.println("b. 게시글 작성");
		System.out.println("c. 게시글 수정");
		System.out.println("d. 게시글 삭제");
		System.out.println("e. 게시판 종료");
		System.out.print(">>>");
		String select = inputStr.next();
		switch (select) {
		
		case "a" :
		case "A" :
			System.out.println(" * 게시판을 조회 합니다 ");
			BoardList(boardDAO);
			break;
		case "b" :
		case "B" :
			System.out.println(" * 게시글을 작성 합니다 ");
			BoardAdd (session);
			break;
		case "c" :
		case "C" :
			System.out.println(" * 게시물을 수정 합니다");
			Scanner inputLine = new Scanner(System.in);
			BoardUp (session, inputStr,inputLine, inputInt);
			break;
		case "d" :
		case "D" :
			System.out.println(" * 게시글을 삭제 합니다 ");
			BoardDel (session, inputInt);
			break;
		case "E" :
		case "e" :
			System.out.println(" * 게시판을 종료 합니다");
			run = false;
			break;
		default :
			System.out.println(" * 잘못 입력하셨습니다 다시 입력해주세요 ");
			break;
		
		} //switch 종료
		
		}//while 종료
	} // SubMenu 메서드종료

	

	private void BoardDel(OtestDTO session, Scanner inputInt)throws SQLException {
		// 게시글 삭제
		
		boardDAO.BoardDel(session.getId(),inputInt);
		
	} // BoardDEl 메서드 종료
	
	private void BoardUp(OtestDTO session, Scanner inputStr, Scanner inputLine, Scanner inputInt) throws SQLException {
		// 게시글 수정
		
		boardDAO.BoardUp(session.getMname(), inputStr, inputLine, inputInt);
	
		
	}// BoardUp 메서드종료

	private void BoardAdd(OtestDTO session) throws SQLException {
		// 게시글 작성
		BoardDTO boardDTO = new BoardDTO();
		Scanner inputLine = new Scanner(System.in);
		
		System.out.println("※ 게시글 작성 후에는 관리자만 삭제 할 수 있습니다 신중히 작성 해주세요 ※");
		System.out.print("제목: ");
		boardDTO.setBtitle(inputLine.nextLine());
		System.out.print("내용: ");
		boardDTO.setBcontent(inputLine.nextLine());
		
		boardDTO.setBname(session.getMname());
		
		boardDAO.BoardAdd(boardDTO, inputLine);
		
		
		
	} // BoardAdd 메서드 종료

	private void BoardList(BoardDAO boardDAO) throws SQLException{
		// 게시글 전체조회
		
		boardDAO.BoardList();
		
	} // BoardList 메서드 종료

} // class 종료
