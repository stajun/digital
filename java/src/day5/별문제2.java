package day5;

public class 별문제2 {

	public static void main(String[] args) {
		/* - 일반변수 vs 참조변수
		 * - 일반변수는 변수타입(자료형)을 이용한 변수들로 값을 저장
		 * - 참조변수는 주소를 저장하는 변수로, 객체, 배열 등이 있다
		 * 
		 * - 지역변수 : 특정지역에서 사용하는 변수
		 *     *			i=1	공=4		*=1	추*=0
		 *    ** *		i=2 공=3		*=2 추*=1
		 *   *** **		i=3 공=2		*=3 추*=2
		 *  **** ***	i=4 공=1		*=4 추*=3
		 * ***** ****	i=5 공=0		*=5 추*=4
		 * 								공=5-i *=i 추*=i-1
		 * */
		int num = 5;
		for(int i = 1; i<=num; i++) {
			for(int j = 1; j<=num-i; j++) {
				System.out.print(" ");
			}
			for(int j = 1; j<=i; j++) {
				System.out.print("*");
			}
			for(int j = 1; j<=i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/*     *			i=1 공=4		*=1
		 *    ***			i=2 공=3 	*=3
		 *   *****		i=3 공=2 	*=5
		 *  *******		i=4 공=1 	*=7
		 * *********	i=5 공=0		*=9
		 * 								공=5-i	*=2*i-1  
		 * */
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=num-i; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		/* *********	i=1	공=0		*=9 8	4
		 *  *******		i=2	공=1		*=7 6	3
		 *   *****		i=3	공=2		*=5 4	2
		 *    ***			i=4	공=3		*=3 2	1
		 *     *			i=5	공=4		*=1 0	0
		 *     						공=i-1	*=2*(5-i)+1	
		 * */
		for(int i = 1; i<=num; i++) {
			for(int j=1; j<=i-1; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=2*(num-i)+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
