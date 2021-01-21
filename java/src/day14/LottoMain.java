package day14;

import java.util.Scanner;

public class LottoMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		LottoManager lm = new LottoManager();
		int menu = 0;
		do {
			lm.printMenu();
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				lm.createLotto(scan);
				break;
			case 2:
				lm.createLottoAuto();
				break;
			case 3:
				lm.insertLotto(scan);
				break;
			case 4:
				lm.checkLotto();
				break;
			case 5:
				lm.printLotto();
				break;
			case 6:	break;
			default:
				lm.printString("잘못된 메뉴!!!");
			}
		}while(menu != 6);
		lm.printString("프로그램 종료!!!");
	}

}
