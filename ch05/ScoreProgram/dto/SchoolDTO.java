package ch05.ScoreProgram.dto;

import java.util.Scanner;

public class SchoolDTO {
	
	//필드 
	String name ; // 학생 이름
	int schoolNumber ; // 학생 학번
	int score ; // 학생 점수
	String grade ; // 학생 등급

	//생성자	
	public SchoolDTO() {
		
	}
	public SchoolDTO (String name, int schoolNumber, int score, String grade) { 
		this.name = name;
		this.schoolNumber = schoolNumber;
		this.score = score;
		this.grade = grade;		
	}
	public String getName() { //출력
		return name;
	}
	public int getSchoolNumber() {//출력
		return schoolNumber;
	}

	public int getScore() {//출력
		return score;
	}

	public String getGrade() {//출력
		return grade;
	}

	public void setName(String name) { //입력
		this.name = name;
	}

	public void setSchoolNumber(int schoolNumber) {//입력
		this.schoolNumber = schoolNumber;
	}

	public void setScore(int score) {//입력
		this.score = score;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	

}






