package review4;

public class StaticTest {

	public static void main(String[] args) {
		/* 일반 멤버 변수/메소드 : 객체 멤버 변수/메소드 
		 * static 멤버 변수/메소드 : 클래스 멤버 변수/메소드
		 * 일반은 객체가 호출하고, static은 클래스가 호출한다.
		 * 단, static은 객체도 호출 가능
		 * 클래스 : 제품 설계도
		 * 객체 : 제품 설계도를 통해 만들어진 제품1, 제품2
		 * 일반 멤버는 각 객체마다 다른 값을 가짐
		 * static 멤버는 모든 객체가 동일한 값을 가짐
		 * */
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
		a1.print();
		a2.print();
		a3.print();
		/* - 클래스 멤버는 클래스가 언급된 시점에 생성 
		 * 	- A a1;이라는 코드가 있으면 이때 생성
		 * - 객체 멤버는 new 연산자를 통해 객체를 생성할 때 생성
		 * 	- A a1;이라는 코드가 있으면 이때 new 연산자가 없기 때문에
		 * 		생성되지 않음
		 * 	- A a1 = new A();이라는 코드가 있으면 이때 생성
		 *  - BoardMain.main()으로 main을 호출하면 이때 객체를
		 *  	생성하지 않고 호출되었기 때문에 객체 멤버를 사용할 수 없음
		 * 
		 * - 클래스 멤버 메소드는 클래스 멤버 변수/메소드만 사용 가능
		 * - 객체 멤버 메소드는 객체 멤버 변수/메소드와 
		 * 	 클래스 멤버 변수/메소드 모두 사용 가능
		 * */
	}
}
class A{
	static int count;
	int num = 0;
	public A() {
		count++;
		num = count;
	}
	public void print() {
		System.out.println("----------------");
		System.out.println("제품 갯수 : " + count);
		System.out.println("제품 번호 : " + num);
		System.out.println("----------------");
	}
}
