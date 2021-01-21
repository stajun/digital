package day10;
//p.316 포함관계 설명 예제
public class 상속4 {

	public static void main(String[] args) {
		/* 원은 도형이다 
		 *  - is a관계(상속)
		 *  - 도형 클래스가 부모, 원 클래스가 자식
		 * 스마트폰은 카메라를 가지고 있다
		 *  - has a관계(포함)
		 *  - 카메라 클래스는 스마트폰 클래스의 멤버 변수이다.
		 * */
	}
}
class SmartPhone{
	Camera camera;//포함
}
class Camera{
	
}
class Shape{
	
}
class Circle extends Shape{//상속
	
}