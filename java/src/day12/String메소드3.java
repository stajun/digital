package day12;

import java.util.Scanner;

public class String메소드3 {

	public static void main(String[] args) {
		/* 5개의 파일명이 주어졌을 때, 원하는 단어를 입력하면 입력한 단어가 있는
		 * 파일들이 출력되도록 코드를 작성하세요.*/
		String []fileName = {"java의 정석.txt","String메소드.java",
				"java의 정석 앞표지.png","java의 정석 뒷표지.jpg","java의 정석.hwp"};
		Scanner scan = new Scanner(System.in);
		String search;
		System.out.print("검색할 단어를 입력 : ");
		search = scan.next();
		
		for(String tmp : fileName) {
			if(tmp.contains(search))
				System.out.println(tmp);
		}
		
		scan.close();
	}

}
