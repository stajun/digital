package day9;

public class 메소드8 {

	public static void main(String[] args) {
		System.out.println(sum(1));
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3));

	}
	//가변인자를 이용한 메소드 구현
	//가변 : 매개변수의 갯수가 고정이 아닌
	public static int sum(int... num) {
		int res = 0;
		for(int tmp : num) {
			res = res + tmp;
		}
		return res;
	}
	/* 기능 : 길이가 주어지면 주어진 길의 정수 배열을 만들고, 만들어진 배열에
	 *       주어진 정수로 초기화하여 배열을 돌려주는 메소드 */
}
