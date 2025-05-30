package ch05.SchoolProgram.dto;


public class SchoolDTO { //부모클래스
	
	public String stname; //학생이름
	public int stnumber; //학생학번
	public int stscore; //학생성적
	public String stgrade; //학생등급
	public String tcname; // 교직원이름
	public int tcnumber; //교직원코드	

	
	public StudentDTO StudentDTO;
	public TeacherDTO TeacherDTO;

	public SchoolDTO() {
		
	}


	public SchoolDTO(String stname, int stnumber, int stscore, String stgrade) {
		super();
		this.stname = stname;
		this.stnumber = stnumber;
		this.stscore = stscore;
		this.stgrade = stgrade;
	
	}


	public String getStname() {
		return stname;
	}

	public int getStnumber() {
		return stnumber;
	}

	public int getStscore() {
		return stscore;
	}

	public String getStgrade() {
		return stgrade;
	}

	public String getTcname() {
		return tcname;
	}

	public int getTcnumber() {
		return tcnumber;
	}



	public StudentDTO getStudentDTO() {
		return StudentDTO;
	}

	public TeacherDTO getTeacherDTO() {
		return TeacherDTO;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	public void setStnumber(int stnumber) {
		this.stnumber = stnumber;
	}

	public void setStscore(int stscore) {
		this.stscore = stscore;
	}

	public void setStgrade(String stgrade) {
		this.stgrade = stgrade;
	}

	public void setTcname(String tcname) {
		this.tcname = tcname;
	}

	public void setTcnumber(int tcnumber) {
		this.tcnumber = tcnumber;
	}



	public void setStudentDTO(StudentDTO studentDTO) {
		StudentDTO = studentDTO;
	}

	public void setTeacherDTO(TeacherDTO teacherDTO) {
		TeacherDTO = teacherDTO;
	}

	@Override
	public String toString() {
		return "SchoolDTO [stname=" + stname + ", stnumber=" + stnumber + ", stscore=" + stscore + ", stgrade="
				+ stgrade + ", tcname=" + tcname + ", tcnumber=" + tcnumber + ", StudentDTO=" + StudentDTO
				+ ", TeacherDTO=" + TeacherDTO + "]";
	}


	
}

