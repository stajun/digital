package day6;

public class 배열7 {
	public static void main(String[] args) {
		/* 5개짜리 배열에 랜덤으로 값을 생성하여 저장한 후 출력하는 예제(예제5-9,p.200) 
		 * 단, 10~20사이의 랜덤한 수*/
		//랜덤 생성 코드
		int min = 10;
		int max = 20;
		//1부터 10까지 저장하고 출력하는 코드
		int size = 5;
		int arr[] = new int[size];
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)((max - min + 1) * Math.random() + min);
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
