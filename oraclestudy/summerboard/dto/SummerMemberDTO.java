package summerboard.dto;

import java.sql.Date;

public class SummerMemberDTO {
	// 게시판의 객체를 담당하고 게터,세터 사용
	// 필드
	
	private int mno;
	private String mname;
	private String id ;
	private String pw;
	private Date regidate; // import java.sql.Date;
	
	//생성자
	
	
	//메서드
	
	

	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	
	


	
}//class 종료
