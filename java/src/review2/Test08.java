package review2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
		/* - 정수 n을 입력 받고 입력받은 수만큼 단어와 뜻을
		 *   입력받아 저장하고 출력하는 코드를 작성하세요.
		 * */
		HashMap<String, String> map 
			= new HashMap<String, String>();
		Scanner scan = new Scanner(System.in);
		System.out.print("입력할 단어의 갯수 : ");
		int size = scan.nextInt();
		
		while(map.size() < size) {
			System.out.print("단어 : ");
			String word = scan.next();
			System.out.print("의미 : ");
			String mean = scan.next();
			map.put(word, mean);
		}
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String word = it.next();
			String mean = map.get(word);
			System.out.println("단어 : " + word + ", 뜻 : " + mean);
		}
		scan.close();
	}

}
