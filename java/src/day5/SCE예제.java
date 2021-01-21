package day5;

public class SCE예제 {
	public static void main(String []args) {
		/* 논리연산자에서 &&연산일 경우 앞의 조건식이 거짓이면
		 * 뒤의 조건식을 보지않아도 거짓이므로 뒤의 조건식을 실행하지 않음
		 * ||연산일 경우 앞의 조건식이 참이면 
		 * 뒤의 조건식을 보지 않아도 참이므로 뒤의 조건식을 실행하지 않음
		 * */
		int num = 90;
		if(num <= 100 && (num = 10) > 0) {
			System.out.println("정상적인 점수: " +num);
		}else {
			System.out.println("비정상적인 점수: " +num);
		}
	}
}
