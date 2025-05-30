package ch05.ScoreProgram;

import java.util.Scanner;

import ch05.ScoreProgram.dto.SchoolDTO;
import ch05.ScoreProgram.service.ScoreService;

public class SchoolScoreExam {

	public static  SchoolDTO[] SchoolDTOs = null;
	public static Scanner inputStr = new Scanner(System.in);
	public static Scanner inputInt = new Scanner(System.in);
	
	public static SchoolDTO[] name = new SchoolDTO [3];
	public static SchoolDTO[] shoolNumber = new SchoolDTO[3];
	public static SchoolDTO[] score = new SchoolDTO [3];
	public static SchoolDTO[] grade = new SchoolDTO [3];
	
	static {
		
		SchoolDTO schoolDTO0 = new SchoolDTO("홍길동",202501,82,"B");
		SchoolDTO schoolDTO1 = new SchoolDTO("김춘식",202502,46,"F");
		SchoolDTO schoolDTO2 = new SchoolDTO("박놀부",202503,99,"B");
		SchoolDTO schoolDTO3 = new SchoolDTO("박흥부",202504,100,"A");
	}
	
	public static void main(String[] args) {
		
		System.out.println("OOO학교 성적처리프로그램을 실행합니다");
		System.out.println("1. 성적입력");
		System.out.println("2. 성적조회");
		System.out.println("3. 성적수정");
		System.out.println("4. 성적삭제");
		System.out.println("0. 프로그램종료");
		System.out.print(">>>");
		String select = inputStr.next();
		
		boolean run = true;
		while (run) {
			switch (select) {

			case "1":
			case "성적입력":
				System.out.println("=== OOO학교 학생의 성적입력을 시작합니다 ===");
				ScoreService scoreService = new ScoreService();
				ScoreService.scoreAdd(inputInt, inputInt, SchoolDTOs);

				break;
			case "2":
			case "성적조회":
				System.out.println("=== OOO학교 학생 성적조회를 시작합니다 ===");
				ScoreService.scoreList(inputStr, inputInt, SchoolDTOs);
				break;
			case "3":
			case "성적수정":
				System.out.println("=== OOO학교 학생 성적수정을 시작합니다===");
				ScoreService.scoreUpdate(inputStr, inputInt, SchoolDTOs);
				break;
			case "4":
			case "성적삭제":
				System.out.println("===OOO학교 학생 성적삭제를 시작합니다===");
				ScoreService.scoreDelete(inputStr, inputInt, SchoolDTOs);
				break;
			case "0":
			case "프로그램종료":
				System.out.println("===프로그램을 종료합니다===");
				run=false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다 다시 입력해주세요 ");

			}//select switch 종료
		}
	
	} // main method 종료


} // class 종료
