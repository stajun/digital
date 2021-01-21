package day3;

import java.util.Scanner;

public class 복습문제 {

	public static void main(String[] args) {
		/* 정보처리기사는 sw1(소프트웨어 설계), sw2(소프트웨어 개발)
		 * db(데이터베이스 구축), program(프로그래밍 언어 활용), info
		 * (정보시스템 구축관리)로 구성되어 있다. 
		 * 1. 각 과목의 성적을 입력받고 입력받은 성적을 출력하는 코드를 작성하세요.
		 *  - 성적은 정수
		 * 2. 과목 중 한 과목이라도 40점 미만이 있으면 과락이라고 출력
		 *  - sw1이 40점보다 (작으)(면) 과락을 출력
		 *    (아니면), sw2가 40점보다 (작으)(면) 과락을 출력
		 *    (아니면), db가 40점보다 (작으)(면) 과락을 출력
		 *    (아니면), program가 40점보다 (작으)(면) 과락을 출력
		 *    (아니면), info가 40점보다 (작으)(면) 과락을 출력
		 *  - sw1이 40점보다 (작)(거나) sw2가 40점보다 (작)(거나) db가 40점보다 (작)(거나)
		 *    program이 40점보다 (작)(거나) info가 40점보다 (작으)(면) 과락이라고 출력
		 * 3. 과목의 평균을 구하여서 평균이 60점미만이면 탈락이라고 출력
		 * */
		int sw1, sw2, db, program, info;
		Scanner scan = new Scanner(System.in);
		System.out.println("성적을 입력하세요(sw1, sw2, db, program, info순):");
		sw1 = scan.nextInt();
		sw2 = scan.nextInt();
		db = scan.nextInt();
		program = scan.nextInt();
		info = scan.nextInt();
		
		//System.out.println(sw1+","+sw2+","+db+","+program+","+info);
		double avr = (sw1 + sw2 + db + program + info) / 5.0;
		
		
		//sw1이 40점보다 (작으)(면) 과락을 출력
		if(sw1 < 40) {
			System.out.println("과락");
		}
		//(아니면), sw2가 40점보다 (작으)(면) 과락을 출력
		else if(sw2 < 40 ) {
			System.out.println("과락");
		}
		else if(db < 40 ) {
			System.out.println("과락");
		}
		else if(program < 40 ) {
			System.out.println("과락");
		}
		else if(info < 40 ) {
			System.out.println("과락");
		}else if(avr < 60) {
			System.out.println("탈락");
		}else {
			System.out.println("합격");
		}
		
		// sw1이 40점보다 (작)(거나) sw2가 40점보다 (작)(거나) db가 40점보다 (작)(거나)
		// program이 40점보다 (작)(거나) info가 40점보다 (작으)(면) 과락이라고 출력
		if(sw1 < 40  || sw2 < 40  || db < 40 ||	
				program < 40  || info < 40 ) {
			System.out.println("과락");
		}else if(avr < 60) {
			System.out.println("탈락");
		}else {
			System.out.println("합격");
		}
		scan.close();
	}

}
