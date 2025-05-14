package ch02;

public class MultiExam {

	public static void main(String[] args) {
		// for문 안쪽에 또 다른 for 문을 넣어 TEST
		
		// 3,6,9 구구단 만들어보기
		// 처음 : 3 × 1 = 3 ~ 3 × 9 = 27
		// 끝 : 9 × 1 = 9 ~ 9 × 9 = 81
		

		// 앞단에 for문 구현
		
		for (int m = 3 ; m <=9 ; m=m+3) {
			System.out.println(" ");
			System.out.println(" ===== " + m + " 단 ==== ");
			//구구단 앞쪽 구현
			
			for ( int n = 1 ; n <=9 ; n++) {
				System.out.println(m + " x " + n + " = " + m*n + (" "));
			
			}// 구구단 뒤에 for 종료
		}//for문 종료
		
	}//main메서드 종료

}// class 종료
