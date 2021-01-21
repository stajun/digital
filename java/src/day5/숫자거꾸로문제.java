package day5;

import java.util.Scanner;

public class 숫자거꾸로문제 {

	public static void main(String[] args) {
		//숫자를 거꾸로 출력하는 예제
		System.out.print("양의 정수를 입력하세요 : ");
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int sum = 0;
		int num2 = num;
		System.out.print(num2+"를 거꾸로 하면 ");
		while(num != 0) {
			int tmp = num % 10;
			System.out.print(tmp);
			sum = sum + tmp;//sum += tmp;
			num = num / 10; //num /= 10;
		}
		System.out.println();
		System.out.println(num2+"의 각 자리의 합 : " + sum);
		scan.close();
	}

}
