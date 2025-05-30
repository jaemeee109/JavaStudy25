package ch05.SchoolProgram.dto;

public class TeacherDTO extends SchoolDTO {
	
	public String tcname; // 교직원이름
	public int tcnumber; //교직원코드	

//	public TeacherDTO() {
//	
//	}

	public TeacherDTO(String tcname, int tcnumber) {
		super();
		this.tcname = tcname;
		this.tcnumber = tcnumber;
	}

	


}
