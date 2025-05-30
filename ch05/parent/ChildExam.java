package ch05.parent;

public class ChildExam {

	public static void main(String[] args) {
		
		Child ch = new Child();
		Parent pr = ch;
		
		pr.method1();
		pr.method2();
		// pr.method3(); 부모객체에서 호출한거기 때문에
		// 자식객체에 있는 method3은 호출 불가능
		
		ch.method3();
		// 자식객체에서는 호출 가능
		
	}//main method 종료

}//class종료
