package day10;

public class 상속1 {

	public static void main(String[] args) {
		/* 상속 : 부모의 것을 자식에게 물려주는 것
		 * 클래스의 상속 : 부모 클래스의 멤버 변수와 메소드를 물려 주는 것
		 * 상속하는 이유 : 재사용을 해서 코드의 중복을 제거
		 * 부모클래스가 A, 자식 클래스가 B이면 클래스 B는 다음과 같아 생성한다.
		 * class B extends A{
		 * 
		 * }
		 * 상속을 받으면 부모의 멤버 변수와 메소드를 사용할 수 있다.
		 *  - 하지만 접근제한자가 private이면 자식클래스는 접근할 수 없다.
		 * */
		B b = new B();
		System.out.println(b.getA());
	}

}
class A{
	private int a, b, c,d,e,f,g;
	protected int num;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}
	
}
class B extends A{
	private int h,i,j;
	
	public void print() {
		System.out.println(getA());
		System.out.println(num);
	}
	
	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
	
}