package day6;

public class 배열8 {

	public static void main(String[] args) {
		/* 1부터 10까지 들어 있는 배열의 값을 섞는 예제(예제5-7, p.197) */
		int size = 45;
		int arr[] = new int[size];
		//1부터 10까지 배열에 저장하는 코드
		for(int i = 0; i<arr.length; i++) {
			arr[i] = i+1;
		}
		//배열을 섞는 코드
		int min = 0;
		int max = arr.length-1;
		for(int i=0; i<arr.length; i++) {
			int index = (int)((max - min + 1) * Math.random() + min);
			int tmp = arr[i];
			arr[i] = arr[index];
			arr[index] = tmp;
		}
		for(int i = 0; i<6; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
