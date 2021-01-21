package day5;

public class 배열1 {

	public static void main(String[] args) {
		/* - 배열 : 같은 타입, 같은 의미의 변수들의 집합 (참조변수)
		 * - 배열 선언 방법 
		 * 타입 [] 배열이름;
		 * 타입 배열이름[];
		 * - 배열 선언 및 초기화
		 * 타입 [] 배열이름 = new 타입[길이];//가장 많이 사용, 타입의 초기값으로 초기화
		 * 타입 [] 배열이름 = new 타입[]{초기값1, 초기값2,...,초기값n};
		 * 타입 [] 배열이름 = {초기값1, 초기값2,...,초기값n};
		 * //new를 사용하지 않는 초기화는 반드시 선언과 동시에 초기화할때만 가능
		 * - 배열의 길이는 0이상이어야한다.
		 * */
		int []arr1, arr2;//arr1 : 배열, arr2 : 배열
		int arr3[]= {1,2,3,4,5}, arr4;//arr3 : 배열, arr4 : 변수
		arr1 = new int[5];
		arr2 = new int[] {1,2,3,4,5};
		
		/* 배열은 반복문을 이용할 수 있기 때문에 편리하다
		 * 배열의 값을 사용하기 위해서는 다음과 같이 사용한다.
		 * 배열이름[번지]
		 * 번지는 0부터 시작 길이-1번지 까지 
		 *  - 배열의 길이는 배열이름.lenth로 알 수 있다.
		 * */
		for(int i = 0; i < arr1.length ; i++) {
			System.out.println("배열 arr1의 "+(i+1)+"번째 값 : "+arr1[i]);
		}
		arr2[0] = 10;
		for(int i = 0; i < arr2.length; i++) {
			System.out.println("배열 arr2의 "+(i+1)+"번째 값 : "+arr2[i]);
		}
		//ArrayIndexOutOfBoundsException =>배열의 번지가 범위를 넘어가는 경우
		//System.out.println("배열 arr2의 5번째 값 : "+arr2[5]);
		for(int i = 0; i < arr3.length; i++) {
			System.out.println("배열 arr3의 "+(i+1)+"번째 값 : "+arr3[i]);
		}
		//int []arr5 = null;
		//System.out.println(arr5.length);
		/* 10개짜리 정수 배열 arr6를 생성하여 arr6에 1부터 10까지 저장하고 출력하는
		 * 코드를 작성하세요. */
		int arr6[] = new int[10];
		
		for(int i = 0; i < arr6.length; i++) {
			arr6[i] = i+1;
		}
		for(int i = 0; i < arr6.length; i++) {
			System.out.println("배열 arr6의 "+(i+1)+"번째 값 : "+arr6[i]);
		}
	}
}
