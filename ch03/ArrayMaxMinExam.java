package ch03;

public class ArrayMaxMinExam {

	public static void main(String[] args) {
		// // 배열에 있는 자료를 for문을 사용하여 최대값과 최소값을 알아내보자
		
		int [] scores = {100,44,57,58,6};
		// 배열 만들고 0~4 인덱스에 값을 넣음
		
		int max = 0; //최대값을 저장할 변수
		int min = 101; // 최소값을 저장할 변수
		
		for(int i = 0; i<scores.length; i++) {
			//0번 인덱스부터 배열을 길이까지 1씩 증가시키는 for문
			// 최대값과 최소값 판단하기
			if (scores[i]>max ) {
				//배열에 있는 값이 변수 max보다 큰가? true
				max = scores[i]; // 배열에있는 값을 max변수에 넣기
			}// 최대값과 최소값 비교문 종료
			else if (scores[i]<min) {
				//배열에 있는 값이 min보다 작으면
				min= scores[i];// 배열에 있는 값을 min 변수에 넣음
				
			}//if 종료
		}//for종료
		
		System.out.println("최대값 :" + max);
		System.out.println("최소값 :" + min);

	}// main method 종료
}//class 종료
