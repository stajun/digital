package day11;

import java.awt.Button;

public class 익명클래스 {

	public static void main(String[] args) {
		/* 익명 클래스 : 이름이 없는 클래스로, 인터페이스를 이용하여 객체를
		 * 						만들때 사용
		 * 인터페이스(Power)를 구현한 구현 클래스(Tv)를 이용하여 객체를 생성할 수 있는데,
		 * 인터페이스의 기능이 적고, 해당 객체가 하나만 필요하면 익명클래스를 이용한다.
		 * 익명 클래스는 주로 메소드의 매개변수로 많이 사용이 된다.
		 *  => 라이브러리에서 제공하는 클래스들중에서 일부 메소드들이 이미 만들어져있는 
		 *     인터페이스를 매개변수로 요구하는 경우가 있다. 이때, 해당 인터페이스를
		 *     구현한 클래스의 객체를 매개변수로 넘겨주거나(Tv 클래스의 객체 t), 
		 *     익명클래스를 이용하여 객체를 만들어서 넣어준다.
		 * */
		Tv t = new Tv();
		//t.turnOn();
		product(t);
		product(new Power() {
			public void turnOn() {
				System.out.println("익명클래스 : 전원이 켜집니다.");
			}
			public void turnOff() {
				System.out.println("익명클래스 : 전원이 꺼집니다.");
			}
		});
	}
	public static void product(Power p) {
		p.turnOn();
		System.out.println("작동중입니다.");
		p.turnOff();
	}
}
interface Power{
	void turnOn();
	void turnOff();
}
class Tv implements Power{

	@Override
	public void turnOn() {
		System.out.println("전원이 켜집니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("전원이 꺼집니다.");
	}
	
}
