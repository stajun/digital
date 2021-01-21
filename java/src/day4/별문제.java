package day4;

public class 별문제 {

	public static void main(String[] args) {
		/* 이중 반복문을 이용하여 아래와 같이 출력되도록 작성하세요.
		 * *****
		 * *****
		 * *****
		 * *****
		 * *****
		 * */
		int i,j;
		for(i=1; i<=5; i++) {
			for(j=1; j<=5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		/* 이중 반복문을 이용하여 아래와 같이 출력되도록 작성하세요.
		 * *			i=1 *=1
		 * **			i=2 *=2
		 * ***		i=3 *=3
		 * ****		i=4 *=4
		 * *****	i=5 *=5
		 *            *=i
		 * */
		for(i=1; i<=5; i++) {
			for(j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		/* 이중 반복문을 이용하여 아래와 같이 출력되도록 작성하세요.
		 *     *	i=1 공=4 	*=1
		 *    **	i=2 공=3 	*=2
		 *   ***	i=3 공=2 	*=3
		 *  ****	i=4 공=1 	*=4
		 * *****	i=5 공=0 	*=5
		 *            공=5-i	*=i
		 * */
		for(i=1; i<=5; i++) {
			//반복문을 이용하여 공백을 출력
			for(j=1; j<=5-i; j++) {
				System.out.print(" ");
			}
			//반복문을 이용하여 *을 출력
			for(j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(i=1; i<=5; i++) {
			for(j=1; j<=5; j++) {
				if(j<=5-i) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
	}

}
