package day3;

public class For문3 {

	public static void main(String[] args) {
		/* 1부터 100까지 2의 배수들을 출력하는 예제
		 * */
		int num;
		for(num = 2; num <= 100; num = num + 2) {
			System.out.print(num + " ");
			//num가 10의 배수이면 엔터
			if(num % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}
}
