package day6;

public class 배열3 {

	public static void main(String[] args) {
		/* 10개짜리 배열을 생성하여 0번지에 1, 1번지에 2, .. 9번지에 10을 
		 * 저장하고 출력하는 예제 */
		int size = 10;
		int arr[] = new int[size];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		arr[5] = 6;
		arr[6] = 7;
		arr[7] = 8;
		arr[8] = 9;
		arr[9] = 10;
		
		System.out.println("arr["+0+"]="+arr[0]);
		System.out.println("arr["+1+"]="+arr[1]);
		System.out.println("arr["+2+"]="+arr[2]);
		System.out.println("arr["+3+"]="+arr[3]);
		System.out.println("arr["+4+"]="+arr[4]);
		System.out.println("arr["+5+"]="+arr[5]);
		System.out.println("arr["+6+"]="+arr[6]);
		System.out.println("arr["+7+"]="+arr[7]);
		System.out.println("arr["+8+"]="+arr[8]);
		System.out.println("arr["+9+"]="+arr[9]);
		System.out.println("-------------------");
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.println("arr["+i+"]="+arr[i]);
		}
	}
}
