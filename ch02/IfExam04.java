package ch02;

import java.util.Scanner;

public class IfExam04 {

	public static void main(String[] args) {
		
		System.out.println(" Sandwich & Hamburger Restaurant ");
		System.out.println(" ");
		System.out.println("========== 메뉴와 열량을 안내합니다 ==========");
		System.out.println();
		Scanner input = new Scanner(System.in);
		String main1 = "샌드위치";
		String main2 = "햄버거";

		System.out.println(" 샌드위치 / 햄버거 중 원하시는 메뉴를 입력하세요 ");
		System.out.print(" >>>>> ");
		String main = input.nextLine();
		
		if(main.equalsIgnoreCase(main1))
		{ System.out.println("1. 쉬림프 ");
		System.out.println("2. 에그마요 ");
		System.out.println("3. 베이컨 ");
		System.out.println("4. 연어 아보카도 ");
		System.out.println("5. 베지 ");
		System.out.print(" 원하는 메뉴의 번호를 입력하세요 >>>>> ");
		int sub1 = input.nextInt();
		switch (sub1) {
		case 1 :
			System.out.println(" 선택하신 쉬림프 샌드위치의 칼로리는 271 kcal 입니다 ");
			break;
		case 2 :
			System.out.println(" 선택하신 에그마요의 샌드위치의 칼로리는 516 kcal 입니다");
			break;
		case 3 :
			System.out.println("선택하신 베이컨의 샌드위치의 칼로리는 430 kcal 입니다");
			break;
		case 4 :
			System.out.println("선택하신 연어 아보카도의 샌드위치의 칼로리는 518 kcal 입니다");
			break;
		case 5 :
			System.out.println("선택하신 베지 샌드위치의 칼로리는 239 kcal 입니다");
			break;
		default :
			System.out.println("입력하신 메뉴는 존재하지 않습니다 입니다");
			break;
		}// switch sub1 종료
		} //main if 종료
		else if (main.equalsIgnoreCase(main2))
		{System.out.println("a.발사믹바질  ");
		System.out.println("b.토마토바질 ");
		System.out.println("c.더블치즈 ");
		System.out.println("d.불고기 ");
		System.out.println("e. 할라피뇨치킨 ");
		System.out.print(" 원하는 메뉴를 입력하세요 >>>>> ");
		char sub2 = input.next().charAt(0);
		switch (sub2) {
		case 'a' :
		case 'A' :
			System.out.println("선택하신 발사믹 바질 버거의 칼로리는 737 kcal 입니다 ");
			break;
		case 'b' :
		case 'B' :
			System.out.println("선택하신 발사믹 토마토 버거의 칼로리는 737 kcal 입니다 ");
			break;
		case 'c' :
		case 'C' :
			System.out.println("선택하신 더블치즈 버거의 칼로리는 479 kcal 입니다 ");
			break;
		case 'd' :
		case 'D' :
			System.out.println("선택하신 불고기 버거의 칼로리는 409 kcal 입니다 ");
			break;
		case 'e' :
		case 'E' :
			System.out.println("선택하신 할라피뇨 치킨 버거의 칼로리는 631 kcal 입니다 ");
			break;
			default :
				System.out.println(" 입력하신 메뉴는 존재하지 않습니다 ");
				break;
				
		}
				
		}
	}//main 메서드 종료

}//class종료
