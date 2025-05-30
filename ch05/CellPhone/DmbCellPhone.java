package ch05.CellPhone;

public class DmbCellPhone extends CellPhone {//자식클래스
	
	int channel; //자식필드

	
	// 생성자
	
public DmbCellPhone(String model, String color, int channel) {
	
	this.model = model; // 부모필드
	this.color = color; 
	this.channel = channel; // 자식필드
}
	
void turnOnDmb() {
	System.out.println("채널 " + channel + "번 DMB 방송 수신을 시작합니다");
}
void changeChannelDmb(int channel) {
	this.channel = channel; // 채널 번호를 입력 받아 채널 변경 진행
	System.out.println("채널을 " + channel +"번으로 변경합니다");
}

void turnOffDmb() {
	System.out.println("DMB 방송 수신을 중지합니다");
}
	

	

}
