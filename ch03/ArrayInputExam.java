package ch03;

import java.util.Scanner;

public class ArrayInputExam {

	public static void main(String[] args) {
		// 키보드로 입력받은 값을 배열에 저장 후 CRUD TEST
		// C 성적입력 / R 성적열람(전체,개인) / U 성적수정 / D 성적삭제
		// 개선사항 : 성적 입력시 null 값을 보고 넣어보기
		
		Scanner inputInt = new Scanner(System.in);
		
		System.out.println("※ 성적처리 프로그램 ※");
		System.out.println("===================");
		System.out.print("학생 수를 입력해주세요 : ");
		int count = inputInt.nextInt();
		System.out.println("===================");
		
	    String[] names = new String[count]; // 이름배열
		int[] kors = new int[count]; // 국어
		int[] maths = new int[count]; //수학
		int[] engs = new int[count]; // 영어
		//학생 수 만큼 각 과목의 배열을 생성
		
		boolean run = true;
		while (run) {
			System.out.println("1. 성적입력");
			System.out.println("2. 전체성적");
			System.out.println("3. 개인성적");
			System.out.println("4. 성적수정");
			System.out.println("5. 성적삭제");
			System.out.println("6. 프로그램종료");
			System.out.print(">>> ");
			int select = inputInt.nextInt();
			switch (select) {
			case 1:
				System.out.println("===== 성적입력 =====");
				ScoreAdd(names, kors, maths, engs);
				break;
			case 2 :
				System.out.println("===== 전체성적 =====");
				AllScore (names, kors, maths, engs);
				break;
			case 3 :
				System.out.println("===== 개인성적 =====");
				OneScore (names, kors, maths, engs);
				break;
			case 4 :
				System.out.println("===== 성적수정 =====");
				ScoreMod (names, kors, maths, engs);
				break;
			case 5 :
				System.out.println("===== 성적삭제 =====");
				ScoreDel (names, kors, maths, engs);
				break;
			case 6 :
				System.out.println("프로그램을 종료합니다");
				break;
				default:
				System.out.println(" 잘못 입력하셨습니다 ");
			}// while run 종료
		}//select switch 종료
		
	}//main method 종료
	static void ScoreDel(String[] names, int[] kors, int[] maths, int[] engs) {
		// 성적 삭제 
		
		Scanner inputInt = new Scanner(System.in);
		Scanner inputStr = new Scanner(System.in);
		
		System.out.println(" 성적을 삭제처리할 학생의 이름을 입력해주세요 ");
		System.out.println(">>>>> ");
		String namedel = inputStr.next();
		
		boolean found3 = false;
		for (int i = 0; i < names[i].length(); i++){
		if (names[i].equals(namedel)) {
			names[i] = null;
			kors [i] = 0;
			maths [i] =0;
			engs [i] =0;
			System.out.println("해당 학생의 성적 삭제가 완료되었습니다 ");
			found3 = true;
			
			break;
		}//if종료
		}//for종료
		if (!found3) {
			System.out.println("존재하지 않는 학생입니다 다시 입력해주세요");
		}//if종료
		
		
			}// ScoreDel method 종료
	static void ScoreMod(String[] names, int[] kors, int[] maths, int[] engs) {
		// 성적 수정
		Scanner inputInt = new Scanner(System.in);
		Scanner inputStr = new Scanner(System.in);
		
		System.out.println("성적을 수정할 학생의 이름을 입력해주세요");
		System.out.print(">>>>> ");
		String Modname = inputStr.next();
		
		boolean found2 = false;
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(Modname)) {
				System.out.println("===================");
				System.out.println(names[i] + "학생의 점수 ");
				System.out.println("국어 : "+kors[i]);
				System.out.println("수학 : "+maths[i]);
				System.out.println("영어 : "+engs[i]);
				System.out.println("===================");
				System.out.println("수정할 점수를 입력해주세요");
				System.out.print("국어 : ");
				kors[i] = inputInt.nextInt();
				System.out.print("수학 : ");
				maths[i] = inputInt.nextInt();
				System.out.print("영어 : ");
				engs[i] = inputInt.nextInt();
				System.out.println("=======수정완료=======");
				found2 = true;
				break;
			}
			}if (!found2){
				System.out.println("다시 입력해주세요");
			
			}//if종료
		
	}//ScoreMod method 종료

	  static void OneScore(String[] names, int[] kors, int[] maths, int[] engs) {
		// 개인성적 조회
		  
		  Scanner inputStr = new Scanner(System.in);
		  
		  

				System.out.print(" 이름 : ");
				String onename = inputStr.next();
				
				  boolean found = false;
				    for (int i = 0; i < names.length; i++) {
				    	if (names[i].equals(onename)&& names[i]!=null){ // 삭제처리된 학생이 보이지 않도록 null 같이넣어줌
			                System.out.println(names[i] + " 학생의 점수는 : 국어 " + kors[i] + " / 수학 " + maths[i] + " / 영어 " + engs[i] + " 입니다");
			                System.out.println("-----------------------------------------");
			                found = true;
					break;
				    	}//if종료
				    	} //for종료
				    if (!found) {
				    		System.out.println("다시 입력해주세요");
				    		System.out.println("-----------------------------------------");
				    	} //if 종료
			

	}// OneScore method 종료

	static void AllScore(String[] names, int[] kors, int[] maths, int[] engs) {
		// 전체 성적 보기
		
			for(int i = 0; i < names.length; i++) { 
				if (names[i]!=null) {//null을 넣어서 삭제된 학생이 출력되지않도록 함
				System.out.println(names[i]+" 학생의 점수: "+ "국어 : "+kors[i]+" / 수학 : "+maths[i]+" / 영어 : "+engs[i]);
				System.out.println("-----------------------------------------");
				}
				}//for 종료
		  
	}// AllScore method 종료

	static void ScoreAdd(String[] names, int[] kors, int[] maths, int[] engs) {
		// 성적입력메서드
		
		Scanner inputStr = new Scanner(System.in);
		Scanner inputInt = new Scanner(System.in);

			for (int i = 0; i < names.length; i++) {
				System.out.print("이름 : ");
				names[i] = inputStr.next();
				System.out.print("국어 : ");
				kors[i] = inputInt.nextInt();
				System.out.print("수학 : ");
				maths[i] = inputInt.nextInt();
				System.out.print("영어 : ");
				engs[i] = inputInt.nextInt();
				System.out.println("===================");
			} //for종료
			System.out.println("성적 입력이 완료 되었습니다");
			System.out.println("===================");
	
		}//ScoreAdd method 종료
		
	}// class 종료


