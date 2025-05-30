package ch05.SchoolProgram.dto;

public class StudentDTO extends SchoolDTO {

	public String stname; //학생이름
	public int stnumber; //학생학번
	public int stscore; //학생성적
	public String stgrade; //학생등급
	
	
//	public StudentDTO() {
//		
//	}


	public StudentDTO(String stname, int stnumber, int stscore, String stgrade) {
		super();
		this.stname = stname;
		this.stnumber = stnumber;
		this.stscore = stscore;
		this.stgrade = stgrade;
	}

	
	
	
	
}
