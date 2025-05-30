package ch05.SchoolProgram;

import java.util.Scanner;

import ch05.SchoolProgram.dto.StudentDTO;
import ch05.SchoolProgram.dto.TeacherDTO;
import ch05.SchoolProgram.service.SchoolService;
import ch05.SchoolProgram.dto.SchoolDTO;

public class ScoreProgramExam {
		
		public static Scanner inputStr = new  Scanner(System.in);
		public static Scanner inputInt = new Scanner(System.in);
		
		public static SchoolDTO[] schoolDTOs  = new SchoolDTO[2];
		public static StudentDTO[] studentDTOs = new StudentDTO[2];
		public static TeacherDTO[] teacherDTOs = new TeacherDTO[2];
		
		static {
			
			schoolDTOs[0] = new SchoolDTO ("김춘식",1,100,"A");
			schoolDTOs[1] = new SchoolDTO ("홍길동",1,100,"A");
			
		}
		
		static {
			teacherDTOs[0] = new TeacherDTO ("교직원1",1);
			teacherDTOs[1] = new TeacherDTO ("교직원2",2);
			
		}
	
		static {
			
			studentDTOs[0] = new StudentDTO ("김만식",1,100,"A");
			studentDTOs[1] = new StudentDTO ("홍길똥",1,100,"A");
		}
		
		public static void main(String[] args) {
			
			SchoolService schoolService = new SchoolService ();
			
			System.out.println("OOO학교 성적 프로그램을 시작합니다");
			
			boolean run = true;
			while (run) {
			System.out.println("| 1. 성적입력 | 2. 전체조회 | 3. 개인조회 | 4. 성적수정 | 5. 성적삭제 | 6. 종료 |");
			System.out.print(">>>");
			int select = inputInt.nextInt();
			switch (select) {
			
			case 1 :
				System.out.println(" === 성적입력 ===" );			
				schoolService.scoreAdd (inputInt, inputStr,schoolDTOs, studentDTOs, teacherDTOs);
			break;
			case 2 :
				System.out.println(" === 전체조회 === ");
				schoolService.scoreAllList (inputInt, inputStr,schoolDTOs, studentDTOs, teacherDTOs);
			
				
			break;
			case 3 :
				System.out.println(" === 개인조회 === ");
				schoolService.scoreIndiv (inputInt, inputStr,schoolDTOs, studentDTOs, teacherDTOs);
			break;
			case 4 :
				System.out.println(" === 성적수정 === ");
				schoolService.schoolUpdate (inputInt, inputStr,schoolDTOs, studentDTOs, teacherDTOs);
			break;
			case 5 :
				System.out.println(" === 성적삭제 === ");
				schoolService.schoolDel(inputInt, inputStr,schoolDTOs, studentDTOs, teacherDTOs);
			break;
			case 6 :
				System.out.println(" === 종료 === ");
				run = false;
			break;
			default: System.out.println("* 잘못 입력하셨습니다 다시 입력해주세요 *");
			
			
			}// switch 종료
			}// while 종료
	}//main 종료

}//class 종료
