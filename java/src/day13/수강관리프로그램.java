package day13;

import java.util.Scanner;

public class 수강관리프로그램 {

	public static void main(String[] args) {
		/*Subject s = new Subject("대학수학","MSC001","이순신",
				4,4,2020,"2학기","공통필수","월1A,월1B,수1A,수1B");
		//System.out.println(s);
		Student std = new Student("홍길동", "010101-3234567", 
				"2020160123", "컴퓨터공학부", "소프트웨어과", 2);
		std.insertSubject(s);
		std.print();
		System.out.println("---------");
		std.insertSubject(new Subject("대학영어","MSC002","유관순",
				4,4,2020,"2학기","공통필수","월1A,월1B,수1A,수1B"));
		std.print();
		System.out.println("---------");
		std.deleteSubject("대학수학");
		std.print();
		*/
		StudentManager sm = new StudentManager();
		char menu = '0';
		Scanner scan = new Scanner(System.in);
		do {
			sm.printMenu();
			menu = scan.next().charAt(0);
			switch(menu) {
			case '1':	sm.insertStudent(scan);;	break;
			case '2':	sm.printStudent();		break;
			case '3':	sm.searchStudent(scan);		break;
			case '4':	sm.registerSubject(scan);	break;
			case '5':	sm.deleteSubject(scan);		break;
			case '6':	break;
			default:
				sm.printAlert();
			}
		}while(menu != '6');
		sm.printExit();
		scan.close();
	}
}


 