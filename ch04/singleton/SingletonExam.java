package ch04.singleton;

public class SingletonExam {

	public static void main(String[] args) {
		// 싱글톤 객체 생성 테스트
		
		// Singleton obj1 = new Singleton();
		// Singleton obj2 = new Singleton();
		
		Singleton obj3 = Singleton.getInstance(); //
		Singleton obj4 = Singleton.getInstance();//
		

		
		System.out.println("obj3은 obj4와 같은가? "+ (obj3 == obj4));

	}

}
