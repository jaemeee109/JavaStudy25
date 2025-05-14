package ch02;

import java.util.Scanner;

import javax.security.sasl.SaslClient;

public class WhileExam {

	public static void main(String[] args) {
		// while문은 조건식이 true일 때만 반복한다
		// while문을 종료하고 싶으면 false 처리를 한다
		// 무한반복용 코드를 작성할 때 사용한다
		
		//미션 ! 성적처리 프로그램 (if, while, switch 사용할 것)
		
		String name = "홍길동";
		String number = "20250514" ; // 학생에 대한 정보를 미리 저장
		
		Scanner input = new Scanner(System.in);

	
		System.out.println("===== 아카데미 성적확인 홈페이지 입니다 =====");
		System.out.print(" 성함을 입력해주세요 >>> ");
		String academyname = input.nextLine();
		System.out.print(" 학번을 입력해주세요 >>> ");
		String academynum = input.next(); // 성적확인 홈페이지 로그인
		
		if (academyname.equals(name) && academynum.equals(number)) {
			
			 int kor = (int)(Math.random()*100) + 1 ;
			 int math = (int)(Math.random()*100) + 1 ;
			 int eng = (int)(Math.random()*100) + 1 ;
			 int total = kor + math + eng ;
			 double avg = total /3;

			
			System.out.println("* 메뉴를 입력해주세요 ");
			Boolean list = true ; //무한반복용 변수
			while (list) {//반복구간 만들기
				System.out.println("A. 성적확인");
				System.out.println("B. 종료 ");
				System.out.print("원하시는 메뉴를 알파벳으로 입력해주세요 >>>>> ");
				char sublist = input.next().charAt(0);
				 System.out.println("===========================");
				 switch (sublist) {
				 case 'a' :
				 case 'A' :
					 System.out.println(" 성적확인을 원하시는 과목을 선택해주세요 ");
					 System.out.println("1. 국어 ");
					 System.out.println("2. 수학 ");
					 System.out.println("3. 영어 ");
					 System.out.println("4. 평균 및 전체 등급 ");
					 System.out.println("0. 종료 ");
					 System.out.print("원하시는 메뉴를 숫자로 입력해주세요 >>>>> ");
					 int sublist2 = input.nextInt();
					 System.out.println("===========================");
					 switch (sublist2) {
					 case 1 :
						
						 System.out.println(name + "님의 국어 성적은 " + kor + "입니다");
						 if (kor>=90) {
							 System.out.println(name + " 님의 국어 등급은 A 입니다 ");
							 System.out.println("===========================");
						 } else if (kor<=89 && kor>80) {
								 System.out.println(name + "님의 국어 등급은 B 입니다");
								 System.out.println("===========================");
							 }else if (kor<=79 && kor >70) {
								 System.out.println(name + "님의 국어 등급은 C 입니다");
								 System.out.println("===========================");
							 } else if (kor <=69 && kor >60) {
								 System.out.println(name +" 님의 국어 등급은 D 입니다");
								 System.out.println("===========================");
							 } else if (kor <=59 && kor >0) {
								 System.out.println(name + " 님의 국어 등급은 F입니다");
								 System.out.println("===========================");
							 } else {
								 System.out.println(" 성적 및 등급확인이 불가능합니다 ");
								 System.out.println("===========================");
							 
						 }//국어 종료
						 break ; //case1 중지
						 
					 case 2 :

						 System.out.println(name + "님의 수학 성적은 " + math + "입니다");
						 if (math>=90) {
							 System.out.println(name + " 님의 수학 등급은 A 입니다 ");
							 System.out.println("===========================");
						 } else if (math<=89 && math>80) {
								 System.out.println(name + "님의 수학 등급은 B 입니다");
								 System.out.println("===========================");
							 }else if (math<=79 && math >70) {
								 System.out.println(name + "님의 수학 등급은 C 입니다");
								 System.out.println("===========================");
							 } else if (math <=69 && math >60) {
								 System.out.println(name +" 님의 수학 등급은 D 입니다");
								 System.out.println("===========================");
							 } else if (math <=59 && math >0) {
								 System.out.println(name + " 님의 수학 등급은 F입니다");
								 System.out.println("===========================");
							 } else {
								 System.out.println(" 성적 및 등급확인이 불가능합니다 ");
								 System.out.println("===========================");
							 
					 }// 수학 종료
					  break; // case2 중지
						 
					 case 3 :
						 
						 System.out.println(name + "님의 영어 성적은 " + eng + "입니다");
						 if (eng>=90) {
							 System.out.println(name + " 님의 영어 등급은 A 입니다 ");
							 System.out.println("===========================");
						 } else if (eng<=89 && eng>80) {
								 System.out.println(name + "님의 영어 등급은 B 입니다");
								 System.out.println("===========================");
							 }else if (eng<=79 && eng >70) {
								 System.out.println(name + "님의 영어 등급은 C 입니다");
								 System.out.println("===========================");
							 } else if (eng <=69 && eng >60) {
								 System.out.println(name +" 님의 영어 등급은 D 입니다");
								 System.out.println("===========================");
							 } else if (eng <=59 && eng >0) {
								 System.out.println(name + " 님의 영어 등급은 F입니다");
								 System.out.println("===========================");
							 } else {
								 System.out.println(" 성적 및 등급확인이 불가능합니다 ");
								 System.out.println("===========================");
							 } // 영어 종료
						 break ; //case3 중지
						 
					 case 4 :{
						 System.out.println(name + "님의 평균 점수는 " + avg + "입니다");
						 if (avg>=90) {
							 System.out.println(name + " 님의 등급은 A 입니다 ");
							 System.out.println("===========================");
						 } else if (avg<=89 && avg>80) {
								 System.out.println(name + "님의 등급은 B 입니다");
								 System.out.println("===========================");
							 }else if (avg<=79 && avg >70) {
								 System.out.println(name + "님의 등급은 C 입니다");
								 System.out.println("===========================");
							 } else if (avg <=69 && avg >60) {
								 System.out.println(name +" 님의 등급은 D 입니다");
								 System.out.println("===========================");
							 } else if (avg <=59 && avg >0) {
								 System.out.println(name + " 님의 등급은 F입니다");
								 System.out.println("===========================");
							 } else {
								 System.out.println(" 평균 점수 및 등급확인이 불가능합니다 ");
								 System.out.println("===========================");
						 
					 }// case 4 종료
					 break; //case4 중지
					 }
					 case 0 :{
						 System.out.println(" 홈페이지가 종료 됩니다 ");
						 System.out.println("===========================");
					 }break ; //case0 중지
						 default :{
							 System.out.println(" 입력하신 메뉴는 존재하지 않습니다 ");
							 System.out.println("===========================");
					
						 }//default 종료
							 break;//default 중지
					
					 }//sublist2 switch 종료
					 break; // case A 중지
				 case 'b' :
				 case 'B' :
					 System.out.println(" 홈페이지가 종료 됩니다 ");
					 System.out.println("===========================");
					 break ; //case B 중지
					 default : 
						 System.out.println(" 입력하신 메뉴는 존재하지 않습니다");
						 System.out.println("===========================");
						 
					 
				 }//switch sublist 종료
			
				
			}//while list 종료
			
			
		}// 로그인 if 종료
		else { 
			System.out.println( "성함과 학번이 일치하지 않습니다 ");
			System.out.println(" 다시 입력해주세요 ");
			 System.out.println("===========================");
		}//로그인실패 else 종료
		
		
	}//main 종료

}//class종료
