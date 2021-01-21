package day6;

public class 배열6 {

	public static void main(String[] args) {
		/* 다음과 같은 배열이 있을 때 최소값과 최대값을 찾아 출력하는 예제 (예제5-6,p.197) */
		int arr[] = new int[]{3,1,5,10,20,4,8};
		/* min은 주어진 숫자가 범위가 있으면 주어진 범위의 최대값으로 초기화하고,
		 * 범위가 주어지지 않으면 0번지의 값으로 초기화를 많이 한다.
		 * max은 주어진 숫자가 범위가 있으면 주어진 범위의 최소값으로 초기화하고,
		 * 범위가 주어지지 않으면 0번지의 값으로 초기화를 많이 한다.
		 * 이 문제에서는 주어진 숫자의 범위가 없으므로 0번지의 값으로 초기화*/
		int min = arr[0];
		int max = arr[0];
		/*
		if(min > arr[1]) {
			min = arr[1];
		}
		if(min > arr[2]) {
			min = arr[2];
		}
		if(min > arr[3]) {
			min = arr[3];
		}
		if(min > arr[4]) {
			min = arr[4];
		}
		if(min > arr[5]) {
			min = arr[5];
		}
		if(min > arr[6]) {
			min = arr[6];
		}
		*/
		for(int i = 1; i<arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println("최소값 : " + min);
		System.out.println("최대값 : " + max);
	}

}
