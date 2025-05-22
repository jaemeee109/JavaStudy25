package ch03;

public class ArrayExam {

	public static void main(String[] args) {
		// 자바 배열 연습
		// 배열은 같은 타입에 표를 만드는 행위
		// String[] str = new String [30]; -> 30개의 문자열이 들어가는 표가 생성되는것 
		// int[] int1 = new int [30]; -> 30개의 정수가 들어가는 표가 생성되는 것
		// 배열은 방번호를 인덱스라고 부르며 0부터 시작한다
		
		int[] scores = {56,97,12,31}; // 객체가 생성되면서 값이 들어감
		System.out.println("첫번째 : "+scores[0]);
		System.out.println("두번째 : "+scores[1]);
		System.out.println("세번째 : "+scores[2]);
		System.out.println("네번째 : "+scores[3]);
		
		for(int i = 0; i < scores.length; i++) { //length 사용할땐 <=말고, < 사용
			System.out.println("for문을 사용한 "+i+"번째 출력값 : "+scores[i]);
			System.out.println("for문을 사용한 "+(i+1)+"번째 출력값 : "+scores[i]);
			System.out.println("-----------------------------------------");
		}//for 종료
		
		// 총점 계산하기
		
		int total = 0;
		double avg = 0.0;
		for (int i = 0; i <scores.length; i ++) {
			total = total + scores[i];
		}//for 종료
		
		System.out.println("총점 : " + total);
		System.out.println("학생 수 : " + scores.length+" 명");
		System.out.println("평균 : " +(avg= total/scores.length));
		
		
	}//main method 종료

}//class 종료
