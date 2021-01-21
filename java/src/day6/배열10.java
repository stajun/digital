package day6;

public class 배열10 {
	public static void main(String[] args) {
		/* 빈도수 예제(예제5-11, p.204)
		 * 단, 배열의 값은 1에서 10사이
		 * 배열 arr에 있는 값들의 빈도수를 count 배열에 저장한 후 출력하는 예제
		 * 이 예제 방법을 이용하려면 배열 arr에 음수 값이 없어야 한다.
		 */
		int arr[] = new int[] {1,1,3,3,4,5,6,7,9,9,10};//값이 저장된 배열
		int count[] = new int[11];//빈도수를 저장할 배열
		for(int i=0; i<arr.length ; i++) {
			//count[arr[i]]++;
			int index = arr[i];
			count[index] = count[index] + 1;
		}
		//숫자 출력
		for(int i = 0; i<count.length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		//숫자 개수 출력
		for(int i = 0; i<count.length; i++) {
			int tmp = count[i];
			System.out.print(tmp + " ");
		}
		System.out.println();
		/* 향상된 for문
		 * for(변수명 A : 배열명){
		 * 
		 * }
		 *  - 배열에서 하나 꺼내서 변수 A에 저장하여 사용
		 *  - 배열 전체를 탐색하는 경우 사용
		 *  - 배열값을 확인할 때 사용
		 *  - 배열값을 수정할 때 사용하지 않음(사용할 수 있지만 그럴바에는 그냥 for문 이용)
		 * */
		for(int tmp : count) {
			System.out.print(tmp + " ");
		}
		System.out.println();
	}
}




