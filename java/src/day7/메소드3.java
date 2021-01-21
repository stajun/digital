package day7;

public class 메소드3 {

	public static void main(String[] args) {
		int num = 2;
		printMulti(num);
		System.out.println(random(5,10));
	}
	/* 기능 : 구구단 한단을 출력하는 메소드
	 * 매개변수 : 한단 => int num
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printMulti*/
	static void printMulti(int num) {
		for(int i = 1; i<= 9; i++) {
			System.out.println(num + " X " + i + " = " + num*i);
		}
	}
	/* 기능 : 원하는 정수 범위의 랜덤 값을 알려주는 메소드
	 * 매개변수 : 원하는 정수 범위 => min부터 max까지 =>int min, int max
	 * 리턴타입 : 랜덤한 값 =>정수 =>int
	 * 메소드명 : random
	 * */
	static int random(int min, int max) {
		return (int)((max - min + 1) * Math.random() + min);
	}
}
