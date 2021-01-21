package day7;

public class 메소드1 {

	public static void main(String[] args) {
		/* 메소드 : 기능
		 * 매개변수 : 기능을 실행하기 위해 필요한 정보(필수 정보)
		 * 리턴타입 : 기능을 실행 후 알려주는 정보(자료형으로 표시)
		 * 메소드 선언 및 구현
		 * 리턴타입 메소드명(매개변수){
		 * 		구현;
		 * }
		 * */
		//int result = sum(1,2);
		//System.out.println(result);
		//System.out.println(sum(1,2));
		//sum2(3,4);
		
		/* isPrime 메소드를 이용하여 100이하의 소수를 출력하는 코드를
		 * 작성하세요.*/
		for(int i = 2; i<=100; i++) {
			if(isPrime(i)) {
				System.out.print(i+" ");
			}	
		}
		System.out.println();
	}
	/* 기능 : 두 정수가 주어지면 두 정수의 합을 알려주는 메소드 
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 합 => 정수 => int
	 * 메소드명 : sum 
	 * */
	static int sum(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}
	/* 기능 : 두 정수가 주어지면 두 정수의 합을 콘솔에 출력하는 메소드 
	 * 매개변수 : 두 정수 => int num1, int num2 
	 * 리턴타입 : 없음 => void
	 * 메소드명 : sum2
	 * */
	static void sum2(int num1, int num2) {
		int result = num1 + num2;
		System.out.println(result);
	}
	/* 기능 : 정수가 주어지면 정수가 소수인지 아닌지 알려주는 메소드
	 * 매개변수 : 정수 => int num
	 * 리턴타입 : 소수인지 아닌지 => 참 또는 거짓 => boolean
	 * 메소드명 : isPrime
	 * */
	static boolean isPrime(int num) {
		int cnt = 0;
		for(int i = 1 ; i <= num ; i++ ) {
			if(num % i == 0) {
				cnt++;
			}
		}
		if(cnt == 2) {
			return true;
		}else {
			return false;
		}
	}
}





