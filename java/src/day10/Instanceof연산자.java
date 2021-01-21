package day10;

public class Instanceof연산자 {

	public static void main(String[] args) {
		P p1 = new P();
		C c1;
		//객체 p1이 클래스 C로 형변환이 가능하면
		if(p1 instanceof C) {
			c1 = (C)p1;
			System.out.println(c1.num2);
		}else {
			System.out.println("형변환 할 수 없습니다.");
		}

		P p2 = new C();
		if(p2 instanceof C) {
			c1 = (C)p2;
			System.out.println(c1.num2);
		}else {
			System.out.println("형변환 할 수 없습니다.");
		}
	}

}
