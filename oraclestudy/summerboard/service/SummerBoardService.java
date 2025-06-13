package summerboard.service;

import java.sql.SQLException;
import java.util.Scanner;

import summerboard.dao.SummerBoardDAO;
import summerboard.dto.SummerBoardDTO;

public class SummerBoardService   {
	// dao와 dto를 사용해 부메뉴와 CRUD 처리
	// 필드
	public SummerBoardDAO summerBoardDao = new SummerBoardDAO();
	
	// 생성자
	// 메서드
	public void SubMenu(Scanner inputStr) throws SQLException {
		//  부메뉴, 생성, 모두보기, 1개보기, 수정하기, 삭제하기
		
		boolean subRun = true;
		while (subRun) {
			System.out.println("=============== ☆ ★ ☆ 자유게시판 ☆ ★ ☆ ===============");
			System.out.println("| 1. 글목록 | 2. 글작성 | 3. 글읽기 | 4. 글수정 | 5. 글삭제 | 6. 종료 |");
			System.out.print("▷ ");
			String subSelect = inputStr.next();
			switch (subSelect) {
			
			case "1":
				System.out.println("=============== ☆ ★ ☆ 전체 글 목록 ☆ ★ ☆ ===============");
				selectAll(summerBoardDao);
				break;
			case "2":
				System.out.println("=============== ☆ ★ ☆ 게시글 작성 ☆ ★ ☆ ===============");
				insertBoard(summerBoardDao,inputStr);
				break;
			case "3":
				System.out.println("=============== ☆ ★ ☆ 게시글 읽기 ☆ ★ ☆ ===============");
				readOne(inputStr);
				break;
			case "4":
				System.out.println("=============== ☆ ★ ☆ 게시글 수정 ☆ ★ ☆ ===============");
				modify (inputStr);
				break;
			case "5":
				System.out.println("=============== ☆ ★ ☆ 게시글 삭제 ☆ ★ ☆ ===============");
				deleteOne();
				break;
			case "6":
				System.out.println("=============== ☆ ★ ☆ 자유게시판 종료 ☆ ★ ☆ ===============");
				subRun=false;
				break;
			default : 
				System.out.println(" ~ 잘 못 입 력 하 셨 습 니 다 ㅠ . ㅠ ~ ");
				break;
				
			
			}//switch 종료
			
		}//while 종료
		
	} // SubMenu 메서드 종료
	private void deleteOne() throws SQLException {
		// 게시물의 번호를 받아 삭제
		
		Scanner inputInt = new Scanner(System.in);
		System.out.print("삭제할 게시글 번호를 입력하세요 ▷");
		int selectBno = inputInt.nextInt();
		summerBoardDao.deleteOne(selectBno);
		System.out.println(" ☆ ★ ☆ 게시물 삭제 완료 ☆ ★ ☆ ");
		
		
	} // deleteOne 메서드 종료
	private void modify(Scanner inputStr) throws SQLException{
		// 제목을 찾아서 내용을 수정
		System.out.print("수정할 게시글 제목을 입력하세요 ▷");
		String title = inputStr.next();
		
		summerBoardDao.modify(title, inputStr);
		System.out.println(" ☆ ★ ☆ 게시물 수정 완료 ☆ ★ ☆ ");
		
		
	} // modify 메서드 종료
	private void readOne(Scanner inputStr) throws SQLException {
		// 제목을 입력하면 내용이 조회 되도록 select 처리
		System.out.print("보고싶은 게시글 제목을 입력하세요 ▷");
		String title = inputStr.next();
		
		summerBoardDao.readOne(title);
	
		
		
	} // readOne 메서드 종료
	private void insertBoard(SummerBoardDAO summerBoardDao, Scanner inputStr) throws SQLException {
		// 키보드로 입력한 데이터를 dto를 사용하여 데이터베이스에 insert 
		SummerBoardDTO summerBoardDTO = new SummerBoardDTO();
		
		System.out.print("작성자: ");
		summerBoardDTO.setBwriter(inputStr.next());
		System.out.print("제목 : ");
		summerBoardDTO.setBtitle(inputStr.next());
		
		Scanner inputLine = new Scanner(System.in);
		System.out.print("내용: ");
		summerBoardDTO.setBcontent(inputLine.nextLine());
		
		summerBoardDao.insertBoard(summerBoardDTO,inputStr); // 위에서 만든 객체를 DAO에게 전달
		System.out.println(" ☆ ★ ☆ 게시물 등록 완료 ☆ ★ ☆ ");
		
		
	} // insertBoard 메서드 종료 
	private void selectAll(SummerBoardDAO summerBoardDao) throws SQLException {
		// 전체 글 보기
		
	 summerBoardDao.selectAll();
		
	} // selectALL 메서드 종료

}
