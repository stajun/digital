package day6;

public class 배열4 {

	public static void main(String[] args) {
		/* 짝수 10개를 배열에 저장하고 저장된 배열의 값을 출력하는 예제 */
		int size = 10;
		int arr[] = new int[size];
		arr[0] = 2;
		arr[1] = 4;
		arr[2] = 6;
		arr[3] = 8;
		arr[4] = 10;
		arr[5] = 12;
		arr[6] = 14;
		arr[7] = 16;
		arr[8] = 18;
		arr[9] = 20;
		
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
			arr[i] = 2*i+2;
		}
		for(int i = 0; i<arr.length; i++) {
			System.out.println("arr["+i+"]="+arr[i]);	
		}
	}

}
