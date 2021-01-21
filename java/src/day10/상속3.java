package day10;

public class 상속3 {

	public static void main(String[] args) {
		/* 모든 클래스의 최고 조상은 Object 클래스
		 * 모든 클래스는 Object 클래스가 제공하는 클래스를 사용할 수 있고,
		 * 오버라이딩 할 수 있다.
		 * */
		A1 a = new A1();
		System.out.println(a.hashCode());
		//객체를 출력하면, 객체의 toString()메소드가 실행된다
		System.out.println(a);
	}

}
class A1{
	int num;

	@Override
	public String toString() {
		return "A1 [num=" + num + "]";
	}

}