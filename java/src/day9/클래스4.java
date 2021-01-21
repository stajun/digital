package day9;

public class 클래스4 {

	public static void main(String[] args) {
		/* 
		 * - static이 붙은 멤버 변수/메소드는 클래스 멤버/메소드가 된다.
		 * - static이 안 붙은 멤버 변수/메소드는 객체(인스턴스) 멤버 변수/메소드가 된다.
		 * 
		 * - 객체 멤버변수/메소드는 객체를 통해 사용된다. 
		 * - 객체 멤버변수는 각 객체마다 멤버 변수를 생성한다.
		 * - 클래스 멤버변수/메소드는 클래스를 통해 사용된다.
		 *   (객체를 통해서도 사용되지만 일반적이진 않다)
		 * - 클래스 멤버변수는 하나의 멤버변수를 모든 객체가 사용(공유)한다. 
		 * 
		 * - 클래스/객체 변수의 생성시점이 달라서 메소드에 사용될 수 있는 환경이 다르다
		 * - 객체 멤버 변수는 클래스 멤버 메소드에서 사용할 수 없다.
		 * - 객체 멤버 변수는 객체 멤버 메소드에서만 사용할 수 있다.
		 * - 클래스 멤버 변수는 클래스/객체 멤버 메소드에서 사용할 수 있다.
		 * - 클래스 멤버 메소드는 클래스/객체 멤버 메소드에서 사용할 수 있다.
		 * - 객체 멤버 메소드는 객체 멤버 메소드에서만 사용할 수 있다.
		 * 
		 * - 객체 멤버 변수는 생성 시점이 객체가 생성될 때 변수가 생성된다.
		 * - 클래스 멤버 변수는 클래스가 메모리에 올라간 순간에 생성된다.
		 *   => 클래스 멤버 변수는 객체가 만들어지지 않아도 생성된다.
		 *  */
		/* 다른 클래스에서 클래스 A의 객체 멤버 변수 num1에 10을 저장하려면?
		 * 클래스 A의 객체를 생성하고, 생성된 객체를 통해 num1에 값을 10으로 저장
		 * */
		A a = new A();
		a.num1 = 10;
		
//		SamsungTv tv1 = new SamsungTv();
//		tv1.turnOn();
//		SamsungTv tv2 = new SamsungTv();
//		tv1.printPower();
//		tv2.printPower();
//		System.out.println(SamsungTv.brand);
//		System.out.println(tv1.brand);
//		System.out.println(tv2.brand);
		/* 다음 코드에서 객체 tv의 객체 멤버 변수 power는 생성이 되었을까요? 아니요
		 * 다음 코드에서 객체 tv의 클래스 멤버 변수 brand는 생성이 되었을까요? 예
		 * */
		SamsungTv tv;
		SamsungTv.printBrand();
	}

}

class A{
	public int num1;
}

class SamsungTv{
	private boolean power=false;
	public final static String brand = "Samsung";
	
	public void turnOn() {
		power = true;
	}
	public void turnOff() {
		power = false;
	}
	public void printPower() {
		if(power) {
			System.out.println("TV가 켜져있습니다.");
		}else {
			System.out.println("TV가 꺼져있습니다.");
		}
		//System.out.println(brand);//가능
	}
	public static void printBrand() {
		System.out.println("제조사 : "+brand);
		//System.out.println(power);//불가능
	}
}
class Card3{
	int num;
	int shape;
	static int width;
	static int height;
}
