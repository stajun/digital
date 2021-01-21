package day10;

public class 인터페이스 {

	public static void main(String[] args) {
		Tv t = new Tv();
		t.turnOn();
		System.out.println(t.power);
		//Power p = new Power();
		Power p = new Tv();
		p.turnOn();
		//System.out.println(p.power);
	}

}
/* 인터페이스 : 추상메소드와 클래스 상수로만 이루어진 것
 * 추상클래스 : 추상메소드 + 일반메소드 + 변수 + 상수로 이루어진 것 
 * 인터페이스는 다중 상속 가능, 다중 구현이 가능
 * */
interface Power{
	public abstract void turnOn();
	public abstract void turnOff();
}
interface Remotecon{
	void channelUp();
	void channelDown();
}
class Tv implements Power,Remotecon{
	boolean power;
	@Override
	public void turnOn() {
		power = true;
		System.out.println("전원이 켜졌습니다.");
	}

	@Override
	public void turnOff() {
		power = false;
		System.out.println("전원이 꺼졌습니다.");
	}

	@Override
	public void channelUp() {
		System.out.println("채널 업");
	}

	@Override
	public void channelDown() {
		System.out.println("채널 다운");
		// TODO Auto-generated method stub
		
	}
}