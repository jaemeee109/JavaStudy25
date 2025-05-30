package ch04.PracticeExam;

import java.util.Scanner;

public class Grade {
	// main() 메서드는 exam 에서 진행함
	// class 기본속성 3가지 필요 : 필드, 생성자, 메서드
	
	//필드 : 이름,학번, 성적, 석차, 등급
	
	public String name;
	public String number;
	public int score;
	public String grade ; 

	
	//생성자 Exam 클래스에서 main()메서드에서 new로 호출
	
	public Grade() {
		
	}//Grade 메서드 종료
	//기본 생성자 : 클래스명과 같은 메서드

	
	
	// 메서드 : Grade 클래스에서 행해지는 동작 C R U D
	
	public Grade studentAdd(Scanner input) {
		
		Grade grade = new Grade();
		System.out.println("=== 성적등록을 시작합니다 ===");
		System.out.print("학생 이름: ");
		grade.name = input.next();
		System.out.print("학생 점수: ");
		grade.score = input.nextInt();
		
		return grade;
		
	}//studentAdd 종료
	
	public void studentScore(Grade[] grades) {
		
		
		
		System.out.println("=== 성적조회를 시작합니다 ===");
		for (int i = 0; i< grades.length; i++) {
			
			if (grades[i].score<=100 && grades[i].score>90){
				grades[i].grade = "A";
			}else if (grades[i].score<=90 && grades[i].score>80){
				grades[i].grade = "B";
			}else if (grades[i].score<=80 && grades[i].score>70){
				grades[i].grade = "C";
			}else if (grades[i].score<=70 && grades[i].score>60){
				grades[i].grade = "D";
			}else {
				grades[i].grade = "F";
			}//if종료
			
			System.out.println("이름: "+ grades[i].name +"/ 성적: "+grades[i].score + "/ 등급: "+ grades[i].grade);

		}//for종료
	}//studentScore종료
	
	
	public Grade studentUpdate(Scanner input) {
		
		Grade grade = new Grade();
		System.out.println("=== 성적 수정을 시작합니다 ===");
		System.out.println("수정하고 싶은 학생의 이름을 입력하세요");
		System.out.print(">>>");
		grade.name = input.next();
		return grade;
	}//studentUpdate 종료
	
	
	public void studentDel() {
		
	}//studentDel 종료
	
	
		
	
	

}//Grade 종료
