package ch01;

public class AccuracyExam2 {

	public static void main(String[] args) {
		// AccuracyExam1 내용을 소수점 처리하지 않고 10으로 곱해서 활용하기
		// int (정수) 타입만 활용
		
		int apple = 1; // 사과 1개
		int totalpieces = apple * 10; // 사과 전체를 10조각으로 처리
	    int number = 7; // 사과 조각 개수
	    int temp = totalpieces - number ; // 10조각(전체)-사과조각개수 7 조각
		
		double result = temp / 10.0 ; // 10조각을 원위치 , int가아닌 double임을 알려주기위해 타입을 double로 변경해준거임
		System.out.println("남은 사과 조각 수  : " +result);
		


}
}