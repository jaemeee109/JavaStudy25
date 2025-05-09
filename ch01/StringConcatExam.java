package ch01;

public class StringConcatExam {

	public static void main(String[] args) {
		// 문자열 연결 테스트
		// print ("테스트" + "입니다." -> + 가 연결 연산자
		// 피연산자 중 한쪽이 문자열이면 + 연산자는 문자열 연결로 반응함
		
		String str1 = "twinkle " + 2000.0;
		System.out.println(str1); // 2000.0도 문자 그대로 출력이 됨
		
		String str2 = str1 + " 반짝반짝 " ;
		System.out.println(str2); // 마찬가지로 모두 문자 그대로 출력 됨
		
		String str3 = "TWINKLE " + 2000  +  2004.0 ; // 앞에 문자가 와서 모든게 문자로 인식되어 출력
		String str4 = 2000 + 2004.0 + " TWINKLE" ; // 앞에 숫자가 와서 계산 후 출력
		
		System.out.println(str3);
		System.out.println(str4);

	}

}
