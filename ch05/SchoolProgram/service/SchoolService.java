package ch05.SchoolProgram.service;

import java.util.Scanner;

import ch05.SchoolProgram.dto.StudentDTO;
import ch05.SchoolProgram.dto.TeacherDTO;
import ch05.SchoolProgram.dto.SchoolDTO;

public class SchoolService {

	public void scoreAdd(Scanner inputInt, Scanner inputStr, SchoolDTO[] schoolDTOs, 
			StudentDTO[] studentDTOs, TeacherDTO[] teacherDTOs) {
		// 성적입력
		
		SchoolDTO schoolDTO = new SchoolDTO();
		for (int i = 0; i < schoolDTOs.length; i++) {
		System.out.print("이름: ");
		studentDTOs[i].stname = inputInt.next();
		System.out.print("학번: ");
		studentDTOs[i].stnumber=inputInt.nextInt();
		System.out.print("성적: ");
		studentDTOs[i].setStscore(inputInt.nextInt());
		System.out.print("등급: ");
		studentDTOs[i].setStgrade(inputStr.next());
		System.out.println("-----------------");
		
		}//for 종료
		System.out.println("* 성적 입력이 완료되었습니다");
	}// 성적입력 메서드 종료

	public void scoreAllList(Scanner inputInt, Scanner inputStr, 
			SchoolDTO[] schoolDTOs, StudentDTO[] studentDTOs,
			TeacherDTO[] teacherDTOs) {
		// 성적전체조회
			
		for (int i = 0; i< schoolDTOs.length; i++) {
		System.out.println("["+studentDTOs[i].stnumber+"/"+studentDTOs[i].stname+"] 성적: "
		+studentDTOs[i].getStscore()+"/ 등급: "+studentDTOs[i].getStgrade());
		
		
		} //for 종료
	} // 성적전체조회 메서드 종료

	public void scoreIndiv(Scanner inputInt, Scanner inputStr, 
			SchoolDTO[] schoolDTOs, StudentDTO[] studentDTOs,
			TeacherDTO[] teacherDTOs) {
		// 성적 개인조회
		
		for (int i = 0; i<schoolDTOs.length; i++) {
			System.out.print("이름: ");
			String indivName = inputStr.next();
			System.out.print("학번: ");
			int indivNum = inputInt.nextInt();
			
			if (indivName.equals(studentDTOs[i].stname) && (indivNum==studentDTOs[i].stnumber)){
				
				System.out.println("이름: "+ studentDTOs[i].stname + "님의 성적을 조회합니다" );
				System.out.println("성적: "+studentDTOs[i].getStscore());
				System.out.println("등급: "+studentDTOs[i].getStgrade());
				System.out.println("----------------------------------------------------");
			
				
				break;
			}else {
				System.out.println("입력하신 정보가 일치하지 않습니다");
			}
			
			
			
		}//for 종료
		
	} //성적 개인조회 종료

	public void schoolUpdate(Scanner inputInt, Scanner inputStr, 
			SchoolDTO[] schoolDTOs, StudentDTO[] studentDTOs,
			TeacherDTO[] teacherDTOs) {
		// 성적 수정
		
		for (int i = 0; i<schoolDTOs.length; i++) {
			System.out.print("이름: ");
			String indivName = inputStr.next();
			System.out.print("학번: ");
			int indivNum = inputInt.nextInt();
			
			if (indivName.equals(studentDTOs[i].stname) && (indivNum==studentDTOs[i].stnumber)){
				
				System.out.println("* 정보확인 완료");
				System.out.println("* 수정사항을 입력하세요");
				System.out.print("이름: ");
				studentDTOs[i].stname = inputStr.next();
				System.out.print("학번: ");
				studentDTOs[i].stnumber = inputInt.nextInt();
				System.out.print("성적: ");
				studentDTOs[i].setStscore(inputInt.nextInt());
				System.out.print("등급: ");
				studentDTOs[i].setStgrade(inputStr.next());
				
				System.out.println("------성적 수정이 완료되었습니다------");
				
				
			}else {
				System.out.println("입력하신 정보가 일치하지 않습니다");
			}
		
			break;
		
	}//for종료
	}//성적수정 메서드 종료

	public void schoolDel(Scanner inputInt, Scanner inputStr,
			SchoolDTO[] schoolDTOs, StudentDTO[] studentDTOs,
			TeacherDTO[] teacherDTOs) {
		// 성적삭제 메서드
		
		for (int i = 0; i<schoolDTOs.length; i++) {
			System.out.print("이름: ");
			String delName = inputStr.next();
			System.out.print("학번: ");
			int delNum = inputInt.nextInt();
			
			if (delName.equals(studentDTOs[i].stname) && (delNum ==studentDTOs[i].stnumber)){
				
				System.out.println("* 정보확인 완료");
				
				System.out.print("이름: ");
				studentDTOs[i].stname = null;
				System.out.print("학번: ");
				studentDTOs[i].stnumber = 0;
				System.out.print("성적: ");
				studentDTOs[i].stscore = 0;
				System.out.print("등급: ");
				studentDTOs[i].stgrade= null;
				System.out.println("* 삭제가 완료되었습니다");
				
				break;
				
			} else {
				System.out.println("* 정보가 일치하지 않습니다 ");
			}
			
			
		}//for 종료
		
		
	} // 성적삭제 메서드 종료
} //class 종료
