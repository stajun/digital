package day10;

public class 참조변수형변환 {
	//p.356 참조변수 형변환
	public static void main(String[] args) {
		//자식을 부모로 형변환하는 경우 무조건 가능하고 에러 발생하지 않음
		C c2 = new C();
		P p2 = c2; //자식을 부모로 형변환
		System.out.println(p2.num1);
		
		//부모를 자식으로 형변환하는 경우 형변환을 생략할 수 없으며,
		//조건부로 에러가 발생하지 않음
		//1.에러가 발생하지 않는 경우
		//  : 부모의 참조변수(p3)가 자식 객체(new C())랑 연결되어 있는 경우
		//    이 부모 객체를 다시 자식 객체로 형변환 가능하다
		P p3 = new C();
		C c3 = (C)p3;
		System.out.println(c3.num2);
		
		//2.에러가 발생하는 경우
		P p1 = new P();
		C c1 = (C)p1; //예외 발생
		System.out.println(c1.num1);
		
		
		//int num1 = (int)10.0;	//3
		//double num2 = 10;	//정수를 실수로 형변환
	}
}

class P{
	int num1=10;
}
class C extends P{
	int num2=20;
}
