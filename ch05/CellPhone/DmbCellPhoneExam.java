package ch05.CellPhone;

public class DmbCellPhoneExam {

	public static void main(String[] args) {
		
		DmbCellPhone dmbphone = new DmbCellPhone ("디엠비폰", "실버", 10);
		// 생성자로 초기값 전달 ( 모델명, 색상, 채널번호)
		
		System.out.println("모델: " + dmbphone.model);
		System.out.println("색상: " + dmbphone.color);
		//부모로부터 받은 필드를 활용하여 출력
		
		System.out.println("채널번호: "+ dmbphone.channel);
		System.out.println("--------------------------------");
		// 부모 메서드 활용
		
		dmbphone.powerOn();
		dmbphone.bell();
		dmbphone.sendVoice("Hi~");
		dmbphone.receiveVoice("Hi!");
		dmbphone.hangUp();
		System.out.println("--------------------------------");
		
		//dmb 자식 메서드 활용
		dmbphone.turnOnDmb();
		dmbphone.changeChannelDmb(97);
		dmbphone.turnOffDmb();
		

	}// main method 종료

}// class 종료
