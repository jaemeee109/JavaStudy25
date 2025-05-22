package ch04;

public class gas {
	
	int gas ; // 필드
	
	
	
	//메서드 기입
	
	void setGas (int gas) {
		this.gas = gas;
	}//리턴값이 없는 메서드로 매개값을 받아서 gas 필드값 변경

	boolean isLeftGas() {
		if(gas ==0) {
			System.out.println("가스잔량이 부족합니다");
			System.out.println("운행이 종료됩니다");
			return false;
		}// if gas==0 종료
		System.out.println("가스잔량이 확인됩니다");
		return true;
	}//boolean isLeftGas 종료
	
	void run () {
		while ( true) {
			if (gas>0) {
			System.out.println("달립니다. 가스 잔량 : "+gas);	
			gas -= 1;
			}else {
				System.out.println("멈춥니다. 가스 잔량 : " +gas);
				return;
			}
			
		}// true while 종료
	}//void run 종료
}
