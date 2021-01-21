package day5;

import java.util.Scanner;

public class 배열2 {

	public static void main(String[] args) {
		/* 배열 복사 */
		//일반 변수 복사
//		int num1 = 10, num2;
//		num2 = num1;
		int arr1[] = new int[]{1,2,3,4,5};
		int arr2[] = arr1;
		/*arr2[0] = 100;
		System.out.println("arr1[0] : " + arr1[0]);
		System.out.println("arr2[0] : " + arr2[0]);
		*/
		arr2 = new int[arr1.length];
		for(int i=0; i<arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		arr2[0] = 100;
		System.out.println("arr1[0] : " + arr1[0]);
		System.out.println("arr2[0] : " + arr2[0]);
		//System.arraycopy()를 이용한 복사
		int arr3[] = new int[arr1.length*2];
		System.arraycopy(arr1, 1, arr3, 3, arr1.length-1);
		//arr1 출력하는 코드
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		//arr3 출력하는 코드
		for(int i=0; i<arr3.length; i++) {
			System.out.print(arr3[i]+" ");
		}
		System.out.println();
		
		//Scanner를 통해 배열의 값 저장하는 코드
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i<arr1.length; i++) {
			System.out.print(i+1+"번째 정수를 입력 : ");
			arr1[i] = scan.nextInt();
		}
		scan.close();
		
		//arr1 출력하는 코드
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
	}

}
