package review2;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point3D pt1 = new Point3D(1,2,3);
		pt1.print();
		pt1.move(3,3);
		pt1.print();
	}
}
/* 상속
 * - 부모클래스의 멤버 메소드와 변수를 물려 받는 것
 * - 재사용
 * - 라이브러리에서 제공하는 클래스들을 물려받아 해당 메소드와 멤버
 *   변수들을 편하게 사용하기 위해서
 * - 클래스 상속에서 부모클래스는 1개만 가능
 * 	 - A클래스에 a라는 기능, B클래스에 a라는 기능이 있을 때
 * 	   클래스 C가 A,B클래스 모두 상속가능하다면 클래스 C 입장에서
 * 	   a 기능을 호출했을 때 A클래스에 있는 기능인지, B클래스에 있는
 * 	   기능인지 알수가 없음 => 부모클래스는 1개만 가능 
 * - 인터페이스 상속에서 부모 인터페이스는 여러개 가능
 * 
 * 오버라이딩
 * - 부모클래스에 있는 메소드를 재정의하는 것
 * - 부모클래스에 있는 메소드 형태가 같아야한다(리턴타입, 메소드명, 매개변수)
 * - 접근제한자는 범위가 좁아지면 안된다(부모 접근제한자 <= 자식접근제한자)
 * */
class Point3D extends Point{
	private int z;

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	public void move(int x, int y, int z) {
		move(x,y);
		this.z = z;
	}
	public void move(Point3D pt) {
		move(pt.getX(), pt.getY(), pt.z);
	}
	@Override
	public void print() {
		System.out.println("("+getX()+","+getY()+","+z+")");
	}
	public Point3D() {}
	public Point3D(int x,int y,int z) {
		super(x,y);
		this.z = z;
	}
	public Point3D(Point3D pt) {
		this(pt.getX(),pt.getY(),pt.z);
	}
}


