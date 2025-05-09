package ch01;

public class AccuracyExam1 {

	public static void main(String[] args) {
		// 사과 1개를 10조각으로 쪼개면 1조각이 0.1로 1개가 됨
		
		int apple = 1; // 사과 1개
		double pieceUnit = 0.1 ; // 조각 단위
		int number = 7; // 사과 조각 개수
		
		double result = apple - number*pieceUnit ;
		System.out.println("사과 7조각을 빼면 : " +result);
		System.out.println("7조각의 값 : " + number*pieceUnit);
		


}
}
