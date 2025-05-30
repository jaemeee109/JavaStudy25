package ch05.ScoreProgram.service;

import java.io.InputStream;
import java.util.Scanner;

import ch05.ScoreProgram.dto.SchoolDTO;


public class ScoreService {



	public static void scoreAdd(Scanner inputStr, Scanner inputInt, SchoolDTO[] schoolDTOs) {
		// 학생성적입력
		SchoolDTO SchoolDTOs= new SchoolDTO();
		for (int i =0; i< schoolDTOs.length ; i++) {
		System.out.print("학생이름: ");
		SchoolDTOs.setName(inputStr.next());
		System.out.print("학생학번: ");
		SchoolDTOs.setSchoolNumber(inputInt.nextInt());
		System.out.print("학생점수: ");
		SchoolDTOs.setScore(inputInt.nextInt());
		System.out.print("학생등급: ");
		SchoolDTOs.setGrade(inputStr.next());
		
		


	
		}//for 종료
	}//scoreAdd 메서드 종료

	public static void scoreList(Scanner inputStr, Scanner inputInt, SchoolDTO[] SchoolDTO) {
		// 학생성적조회
		SchoolDTO SchoolDTOs = new SchoolDTO();
		for (int i = 0; i < SchoolDTO.length ; i++) {
		System.out.print("학생이름: "+ SchoolDTOs.getName());
		System.out.print("학생학번: "+ SchoolDTOs.getSchoolNumber());
		System.out.print("학생점수: "+ SchoolDTOs.getScore());
		System.out.print("학생등급: "+ SchoolDTOs.getGrade());
		break;
		}//for종료
		
	}// scoreList 메서드 종료

	public static void scoreUpdate(Scanner inputStr, Scanner inputInt, SchoolDTO[] schoolDTO) {
		// 학생성적수정
		SchoolDTO SchoolDTO = new SchoolDTO();
		
		System.out.print("학생이름: ");
		String stName = inputStr.next();
		System.out.println("학생학번: ");
		int stNumber = inputInt.nextInt();
		
		for (int i = 0; i < schoolDTO.length; i++) {
		if ( schoolDTO[i].getName().equals(stName)&&
				schoolDTO[i].getSchoolNumber()==stNumber) {
			System.out.println("----------------------------");
			System.out.println("*이름과 학번은 수정이 불가능합니다");
			System.out.print("수정점수: ");
			SchoolDTO.setScore(inputInt.nextInt());
			System.out.print("수정등급: ");
			SchoolDTO.setGrade(inputStr.next());
			
			System.out.println(" 수정이 완료되었습니다 ");
			System.out.println("["+stName+"/"+stNumber+"]"+SchoolDTO.getScore()+SchoolDTO.getGrade());
			System.out.println("----------------------------");
		}//if 종료
		}//for 종료
		
		
	}// scoreUpdate 메서드 종료

	public static void scoreDelete(Scanner inputStr, Scanner inputInt, SchoolDTO[] schoolDTOs) {
		// 점수삭제
		
		SchoolDTO SchoolDTO = new SchoolDTO();
		
		System.out.print("이름: ");
		String stName = inputStr.next();
		
		boolean run =false;
		for (int i = 0; i< SchoolDTO.getName().length(); i++) {
			if ( schoolDTOs[i].equals(stName)) {
				schoolDTOs[i].getName()=null;
				schoolDTOs[i].getGrade() =0;
				schoolDTOs[i].getSchoolNumber()=0;
				
			}
			run= true;
			break;
			
		}
		
		
	}

}//class 종료
