package ch02;

import java.util.Scanner;

public class SwitchExam {

	public static void main(String[] args) {
		// Switch는 조건 제어문
		// 조건이 맞으면 case : 에 있는 실행문이 실행된다
		// Switch 조건문에서는 break 가 중요하다
		// if문은 true 이거나 false인 조건이 2개 있지만 Switch 문은 여러개의 조건 결과를 받는다
		
		// Key Point : C (생성) / R (읽기) / U (수정) / D (삭제)
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("==================");
		System.out.println("===== 카테고리 ===== ");
		System.out.println("a . 상의 ");
		System.out.println("b. 하의 ");
		System.out.println("c. 원피스 ");
		System.out.println("d. 아우터 ");
		System.out.println("z. 프로그램 종료");
		System.out.print(" 카테고리'a~z' 중 선택해주세요 >>>>> ");
		
		char select = input.next().charAt(0);
		switch(select) {
		case 'A' :
		case 'a' :
			System.out.println("상의");
			System.out.println("11. 블라우스 & 셔츠 ");
			System.out.println("22. 티셔츠 ");
			System.out.println("33. 후드 ");
			System.out.println("44. 니트 ");
			System.out.print(" 1~4 중 선택해주세요 >>>>> ");
			int top = input.nextInt();
			switch (top) {
			case 11 :
				System.out.println("블라우스 & 셔츠 상품목록 ");
				break ;
			case 22 :
				System.out.println(" 티셔츠 상품목록 ");
				break ;
			case 33 :
				System.out.println(" 후드 상품목록 ");
				break ;
			case 44 : 
				System.out.println(" 니트 상품목록 ");
				break ;
				default :
				System.out.println(" 다시 입력해주세요");
				break ;
			}//top switch 종료
			break; // top  break
		case 'B' :
		case 'b' :
			System.out.println(" 하의 ");
			break;
		case 'C' :
		case 'c' :
			System.out.println(" 원피스 ");
			break;
		case 'D' :
		case 'd' :
			System.out.println(" 아우터 ");
			break;
		case 'Z' :
		case 'z' :
			System.out.println(" 프로그램 종료 ");
			break;
		default :
			System.out.println("다시 입력해주세요");
			break;
		}//메인 switch 종료
		
		// break 생략 switch문
		int time = (int)(Math.random()*12)+1;
		System.out.println("[ 현재 시간 : " + time + "시 ]");
		
		switch (time) {
		case 9 :
			System.out.println(" 출근하여 일을 시작합니다 ");
		case 10 :
			System.out.println(" 오전 업무에 시달립니다 ");
		case 11 :
			System.out.println(" 카페인을 수혈합니다 ");
		case 12 :
			System.out.println(" 점심식사를 합니다 ");
		case 13 : 
			System.out.println(" 오후업무를 시작합니다 ");
		case 14 :
			System.out.println(" 스트레칭을 가볍게 해줍니다 ");
		case 15 :
			System.out.println(" 가벼운 간식을 먹습니다 ");
		case 16 :
			System.out.println(" 퇴근이 2시간이나 남았습니다 ");
		case 17 :
			System.out.println(" 오늘의 업무 마무리를 시작합니다 ");
		case 18 :
			System.out.println(" 퇴근 합니다 ");
		case 19 :
			System.out.println(" 저녁 식사를 합니다 ");
		case 20 :
			System.out.println(" 살기 위해 운동 합니다 ");
		case 21 : 
			System.out.println(" 씻고 취침할 준비를 시작합니다 ");
		break;
		default :
			System.out.println(" 수면시간입니다 ");
		}// break 생략 switch문 종료
		
		//주민번호를 사용한 성별 구분
		
		System.out.println(" 당신의 주민번호 13자리를 입력해주세요 '(-)' 생략 >>> ");
		Scanner xyz = new Scanner(System.in);
		String abc = xyz.nextLine();
		char gender = abc.charAt(7);// 8번째 글자를 추출하면 성별판단이 가능
		
		switch (gender) {
		case '1' : case '3' : case '5' : case '7' :
			System.out.println(" 남자 ");
			break;
		case '2' : case '4' : case '6' : case '8' :
			System.out.println(" 여자 ");
			break;
			default :
				System.out.println(" 성별 알 수 없음 ");
		}//성별추출 if 종료

	}// main 메서드 종료

}//class종료
