package ch01;

public class CastingExam01 {

	public static void main(String[] args) {
		// Casting = 강제 타입 변환
				// 큰 크기의 타입을 작은 크기의 타입으로 자동변환 할 수 없다.
				// int (21억) -> byte 타입으로 담으면 누수가 발생한다.
				// 이것을 누수가 발생해도 강제로 적용하는 법을 강제 타입 변환이라고 한다.
				
				int intValue = 95569791 ;
				byte byteValue = (byte) intValue ; // 강제로 byte 타입으로 변환
				//byte byteValue = intValue ; => Type mismatch: cannot convert from int to byte
				
				System.out.println("int type 값 출력 : " + intValue);
				System.out.println("byte type 값 출력 : " + byteValue);
			
				// 강제로 담았더니 출력값이 날라갔음.
				// byte 타입의 8bit를 만들고 앞에 값을 날려버림.
				// 0101 1011 0010 0100 0111 0111 1111 -> 앞에를 날리고 0111 1111 만 남김 (10진법 -> 127)
				
				int kor = 100;
				int eng = 98;
				int mat = 92;
				
				int total = kor + eng + mat ;
				System.out.println("=========== 성 적 표 ===========");
				System.out.println(" 국어 + 영어 + 수학 = 총점 : " + total);
				
				double avg = total/3 ; //자동타입 변한 됨
				System.out.println(" 평균 점수 (자동타입변환) : " + avg);
				// 문제 발생 : 어떤 값을 계산해도 소수점이 0으로 나옴.
				// 이유 : int 타입 total 이 3으로 나누어짐.
				// 문제 해결 : double 타입으로 강제타입 변환 후에 3으로 나누어야 함.
				
				avg = (double) total/3 ; //강제 타입 변환 됨
				System.out.println(" 평균 점수 (강제타입변환) : " + avg);
				
				
			
				

	}

}
