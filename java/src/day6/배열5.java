package day6;

import java.util.Scanner;

public class 배열5 {

	public static void main(String[] args) {
		/* 3명의 국어 점수를 입력받아 배열에 저장하고, 3명의 국어 점수의 총점과 평균을
		 * 구하는 예제(예제5-5,p.196)  */
		int size = 3;
		int kor[] = new int[size];
		Scanner scan = new Scanner(System.in);
		int sum;
		double avg;
		
		System.out.print(1+"번 학생의 국어 성적 : ");
		kor[0] = scan.nextInt();
		System.out.print(2+"번 학생의 국어 성적 : ");
		kor[1] = scan.nextInt();
		System.out.print(3+"번 학생의 국어 성적 : ");
		kor[2] = scan.nextInt();
		
		
		sum = kor[0] + kor[1] + kor[2];
		avg = (double)sum / kor.length;
		System.out.println("3명 학생의 총점 : " + sum );
		System.out.println("3명 학생의 평균 : " + avg );
		System.out.println("------------------------");
		
		sum = 0;
		for(int i=0; i<kor.length; i++) {
			System.out.print(i+1+"번 학생의 국어 성적 : ");
			kor[i] = scan.nextInt();
			sum = sum + kor[i];
		}
		avg = (double)sum / kor.length;
		System.out.println("3명 학생의 총점 : " + sum );
		System.out.println("3명 학생의 평균 : " + avg );
		scan.close();
	}

}
