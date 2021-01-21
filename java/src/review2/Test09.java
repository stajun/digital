package review2;

import java.util.ArrayList;
import java.util.Scanner;

public class Test09 {

	public static void main(String[] args) {
		/* - 정수 n을 입력 받고 입력받은 수만큼 단어와 뜻을
		 *   입력받아 저장하고 출력하는 코드를 작성하세요.
		 * */
		ArrayList<String> wordList = new ArrayList<String>();
		ArrayList<String> meanList = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		System.out.print("입력할 단어의 갯수 : ");
		int size = scan.nextInt();
		
		while(wordList.size() < size) {
			System.out.print("단어 : ");
			String word = scan.next();
			System.out.print("의미 : ");
			String mean = scan.next();
			wordList.add(word);
			meanList.add(mean);
		}
		for(int i = 0; i<wordList.size(); i++) {
			String word = wordList.get(i);
			String mean = meanList.get(i);
			System.out.println(word + " : " + mean);
		}
		scan.close();
	}

}
