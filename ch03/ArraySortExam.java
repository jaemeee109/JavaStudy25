package ch03;

public class ArraySortExam {

	public static void main(String[] args) {
		// 배열에 있는 값을 정렬하여 출력해보기
		// 오름차순 : 큰 값이 뒤에 (성적...)
		// 내림차순 : 작은 값이 뒤에 (육상경기, 게시판..)
		// 배열에 있는 값을 촤우로 변경하기 위해서는 임시방 (temp)이 필요함
		
		int[] scores = { 2,9,12,58,25,77};
		// 방번호 0,1,2,3,4,5에 각각 숫자를 넣음
		System.out.println("*** 정렬 전 배열 ***");
		for (int i =0 ;i<scores.length; i++) {
			System.out.print(scores[i]+" ");
		}//for 종료
		System.out.println(" ");
		System.out.println("*** 정렬 후 배열 ***");
		
		for (int j = 0; j<scores.length-1; j++ ) {
			// 0에서 6-1까지 반복 (앞)
			for (int k = 0; k<scores.length-1-j; k++) {
				if(scores[k]<scores[k+1]) {
					//앞에 있는 값이 뒤에 있는 값보다 크면 자리 바꿈
					int temp = scores[k];// 큰값을 임시방으로
					scores[k] = scores[k+1];// 작은값을 앞으로
					scores[k+1]=temp;// 임시방에 큰값을 뒤로
					//자리변경완료
				}// if 종료
				
				//검증코드
				System.out.println(" ");				
				System.out.println(">>>>>> 검증중 ");

				for (int i=0; i<scores.length;i++) {
					System.out.print(scores[i]+" ");

				}//검증for종료
				
			}//k for 종료
		}//j for 종료
				
				
				

	}//main method 종료

}//class 종료
