package ch03;

public class ForEachExam {

	public static void main(String[] args) {
		// for each 문은 향상된 for문으로 배열에 인덱스를 사용하지 않는다
		// 방법 : for (타입 변수 : 배열명){
		// 			실행문 1;
		// 		    }
		// for each문은 전체 리스트 출력용이다 

		int[] numbers = {92,91,31,12,56};
		for (int i : numbers) {
			System.out.println("numbers의 배열된 숫자는 " + i + " 입니다");
		}//for 종료
		System.out.println("===================================");
		String[] animals = {"강아지", "고양이", "토끼", "호랑이", "사자"};
		for(String i : animals) {
			System.out.println("-----------------------");
			System.out.println("animals에 호랑이가 있습니까?");
				if ("호랑이".equals(i)) {
					System.out.println("호랑이가 있습니다");
				}else {
					System.out.println("없습니다");
					
				}//if종료
			
		}//for종료
		
		
	}//main method 종료

}//class 종료
