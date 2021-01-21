package day6;

public class 이차배열1 {

	public static void main(String[] args) {
		/* 2차원배열 선언
		 * 자료형 [][]배열명 = new 자료형[길이1][길이2];
		 * */
		int arr[][] = new int[5][3];
		int cnt = 1;
		//arr.length는 5를
		for(int i = 0; i<arr.length; i++) {
			//arr[0].length는 3을
			for(int j = 0; j<arr[0].length; j++) {
				arr[i][j] = cnt;
				System.out.print(arr[i][j] + " ");
				cnt++;
			}
			System.out.println();
		}

	}

}
