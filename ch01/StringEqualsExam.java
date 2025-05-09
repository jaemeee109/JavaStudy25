package ch01;

public class StringEqualsExam {

	public static void main(String[] args) {
		// 지금까지 배운 변수 타입은 기본타입으로 자바에서 객체 없이 사용 됨
		// String으로 원래 객체를 생성하고 만들어야 하지만 편의상 생략
		
		String color1 = "pink" ;
		String color2 = "pink" ;
		String color3 = new String ("pink"); // 객체를 새로 생성하는 문구
		
		System.out.println(color1==color2);
		System.out.println(color1==color3);
		System.out.println(color2==color3);
		
		// color 1,2는 객체가 같음
		// color 1,2 < --- > 3 은 객체가 다르므로 false
		
		// 객체의 주소끼리 비교할때는 ==
		// 객체의 주소가 아닌 객체 값을 비교할 때는 내장된 메서드를 사용해야 함
		// String은 객체이고 객체의 안쪽 값에는 메서드들이 있다
		// 메서드를 보고싶으면 .을 찍으면 됨
		// ex) boolean eq1 = color1.(점)
		
		boolean eq1 = color1.equals(color3);
		System.out.println("color 1 과 color3의 equals 메서드 사용 결과 : " + eq1); 
		
		//boolean은 true & false를 가리는 것
		// equals 는 안쪽 메서드 값을 비교하게 하는 동작
		// color1과 color3 둘다 pink이기 때문에 true
		
		System.out.println("====================대입연산자=====================");
		
		int k = 100;
		k += 100 ;
		System.out.println("k : " + k); // 200
		k -= 3;
		System.out.println("k : " + k); // 197
		k *= 2;
		System.out.println("k : " + k);// 394
		k /= 3;
		System.out.println("k : " + k); // 131
		k %= 5;
		System.out.println("k : " +k); // 1
		

	}

}
