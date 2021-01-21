package day4;

import java.util.Scanner;

public class 소수문제 {

	public static void main(String[] args) {
		/* 반복문 : 규칙성을 가진 반복적인 작업을 할 때 사용
		 * for(1.초기화; 2.5.8.조건식; 4.7.증감연산식){
		 * 		3.6.실행문;
		 * }
		 * 초기화 : 조건식이나 실행문에서 사용하는 변수를 초기화
		 * 조건식 : 반복문 실행을 결정하는 부분으로 참이면 반복문 진행, 거짓이면 종료
		 * 증감연산식 : 조건식에서 사용하는 변수를 증가 또는 감소
		 * 
		 * 반복문 문제 해결 과정
		 *  - 반복횟수 
		 *    - 초기화
		 *    - 조건식
		 *    - 증감연산식
		 *  - 규칙성(실행문)
		 * */
		/* 1부터 10까지 콘솔에 출력하는 예제
		 *  => i는 1부터 10까지 i를 출력하는 예제
		 * - 반복횟수 : i는 1부터 10까지 1씩 증가
		 *   - 초기화 : i는 1부터
		 *   - 조건식 : i는 10까지
		 *   - 증감연산식 : i는 1씩 증가
		 * - 규칙성 : i를 출력
		 * */
		int i;
		for(i = 1 ; i <= 10 ; i = i + 1) {
			System.out.println(i);
		}
		/* A = A + B;
		 * A += B;
		 * A = A - B;
		 * A -= B;
		 * A = A * B;
		 * A *= B;
		 * */
		/* num를 입력받아 입력받은 num가 소수인지 아닌지 판별하는 예제
		 * 소수 : 약수가 1과 자기자신인 수로 약수가 2개이다.
		 * 반복횟수 : i는 1부터 num까지 1씩 증가
		 *  - 초기화 : i는 1부터
		 *  - 조건식 : i는 num까지
		 *  - 증감식 : i는 1씩 증가
		 * 규칙성 : i가 num의 약수이면 약수의 갯수 cnt를 1증가
		 *  =>num를 i로 나누었을 때 나머지가 0과 같다면 cnt를 1증가
		 * 반복문 종료 후 : cnt가 2이면 소수라고 출력하고, 아니면 소수가 아님이라고 출력
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		int cnt = 0;
		for( i = 1 ; i <= num ; i++ ) {
			if(num % i == 0) {
				cnt++;
			}
		}
		if(cnt == 2) {
			System.out.println(num + "는 소수");
		}else {
			System.out.println(num + "는 소수가 아님");
		}
		scan.close();
	}
}
