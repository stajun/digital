package day2;

public class If문2 {

	public static void main(String[] args) {
		/* 조건식이 참이면 실행문1을 실행하고, 조건식이 거짓이면 실행문2를 실행해라
		 * 조건식이 참이면 실행문1을 실행하고, 아니면 실행문2를 실행해라
		 * else : else를 기준으로 위에 있는 조건식들이 거짓이면
		 * if(조건식){
		 * 	실행문1;
		 * }else{
		 * 	실행문2;
		 * }
		 * */
		int num = 2;
		/* num가 0과 같다면 0이라고 출력
		 * 아니면 0이 아니라고 출력 */
		if(num == 0) {
			System.out.println("0입니다.");
		}else {
			System.out.println(num + "는 0이 아닙니다");
		}
		/* num가 짝수이면 짝수라고 출력하고 아니면 홀수라고 출력
		 * num를 2로 나누었을 때 나머지가 0과 같다면 짝수라고 출력 
		 * 조건식 : num를 2로 나누었을 때 나머지가 0과 같다 
		 * 실행문 : 짝수라고 출력
		 * */
		if(num % 2 == 0) {
			System.out.println(num+"는 짝수");
		}else {
			System.out.println(num+"는 홀수");
		}
	}
}
