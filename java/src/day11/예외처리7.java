package day11;

public class 예외처리7 {

	public static void main(String[] args) {
		method1();
		method2();
	}
	public static void method1() {
		try {
			System.out.println("method1이 실행중입니다.");
			return;
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("메소드1 종료");
	}
	public static void method2() {
		try {
			System.out.println("method2가 실행중입니다.");
			return;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("메소드2 종료");	
		}
	}
}
