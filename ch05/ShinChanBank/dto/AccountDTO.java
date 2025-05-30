package ch05.ShinChanBank.dto;

public class AccountDTO {
	
	// 필드, 보안을 위해 private
	private String ano; //계좌번호
	private String owner; //계좌주인
	private int balance; //잔고
	private String bankName; //은행이름
	
	//생성자
	
	public AccountDTO() {// 기본생성자 Source→Generate Constructor Using Fields (체크x)
		
	}

	public AccountDTO(String ano, String owner, int balance, String bankName) {
		// Generate Constructor Using Fields -> select all
		super();
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
		this.bankName = bankName;
	}

	
	// 메서드 getter and setter 이용
	
	public String getAno() { // 계좌번호 출력시 변조담당
		return ano;
	}

	public String getOwner() { // 계좌주 출력시 변조 담당
		return owner;
	}

	public int getBalance() { // 잔고 출력시 변조 담당
		return balance;
	}

	public String getBankName() { // 은행명 출력시 변조 담당
		return bankName;
	}

	public void setAno(String ano) { // 계좌번호 입력시 검증용
		this.ano = ano;
	}

	public void setOwner(String owner) { // 계좌주 입력시 검증용
		this.owner = owner;
	}

	public void setBalance(int i) { // 계좌금액 입력시 검증용
		this.balance = balance;
	}

	public void setBankName(String bankName) { // 은행명 입력시 검증용
		this.bankName = bankName;
	}

	@Override //  Source → to String
	public String toString() {
		return "AccountDTO [ano=" + ano + ", owner=" + owner + ", balance=" + balance + ", bankName=" + bankName + "]";
	}

	
	
	
	
	
	
	
	
	
	
}// class 종료
