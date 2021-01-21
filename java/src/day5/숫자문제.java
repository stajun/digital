package day5;

public class 숫자문제 {
	public static void main(String []args) {
		/* 다음과 같이 출력되도록 반복문을 이용하여 코드를 작성하세요.
		 * 1 2 3
		 * 4 5 6
		 * 7 8 9
		 * */
		int cnt = 1;
		for(int i = 1; i<=3; i++) {
			for(int j = 1; j<=3; j++) {
				System.out.print(cnt++ + " ");
			}
			System.out.println();
		}
	}
}
