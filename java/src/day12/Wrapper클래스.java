package day12;

public class Wrapper클래스 {

	public static void main(String[] args) {
		/* Wrapper 클래스는 기본 자료형을 클래스로 변환한것
		 * 차이점
		 *  - 래퍼 클래스는 null을 허용, 기본 자료형은 null을 허용하지 않음
		 *  - 래퍼 클래스는 기능(메서드)을 제공 */
		//int num1 = null; //기본 자료형은 null을 사용할 수 없음
		Integer num2 = null;
		num2 = Integer.parseInt("1234");
		System.out.println(num2);
		num2 = Integer.valueOf("5678");
		System.out.println(num2);
		num2 = Integer.valueOf("FF",16);//16진수 ff
		System.out.println(num2);
		//num2 = null;
		int num3 = num2; //언박싱
		System.out.println(num3);
		num2 = 23;//오토박싱

	}

}
