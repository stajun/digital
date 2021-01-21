package day12;

import java.util.Scanner;

public class String메소드2 {

	public static void main(String[] args) {
		/* 5개짜리 문자열 배열을 생성한 후, 5개의 파일명을 입력받는 코드를 작성하세요.
		 * 입력받은 파일 중 이미지 파일들을 출력하는 코드를 작성하세요. 
		 * */
		//5개짜리 문자열 배열 생성
		//String [] fileName = new String[5];
		String [] fileName = {"java의 정석.txt","String메소드.java",
				"java의 정석 앞표지.png","java의 정석 뒷표지.jpg","java의 정석.hwp"};
		Scanner scan = new Scanner(System.in);
		//반복문을 이용하여 콘솔에서 파일명 입력
		/*for(int i = 0; i<fileName.length; i++) {
			System.out.print((i+1)+"번째 파일명 입력 : ");
			fileName[i] = scan.next();
		}*/
		String [] img = { "png","jpg","bmp","gif"};
		System.out.println("--이미지 파일 리스트--");
		for(String tmpFileName: fileName) {
			int index = tmpFileName.lastIndexOf('.');
			String suffix=null;
			if(index == -1) {
				continue;
			}
			suffix = tmpFileName.substring(index+1);
			if(cotains(img, suffix))
				System.out.println(tmpFileName);
		}
		scan.close();
	}
	/* 기능 : 배열과 찾을 문자열이 주어지면 배열에서 찾을 문자열이 있는지 없는지 확인하여
	 *       알려주는 메소드*/
	public static boolean cotains(String[]arr, String search) {
		if(arr == null || arr.length == 0)
			return false;
		if(search == null){
			return false;
		}
		for(String tmp : arr) {
			if(search.equals(tmp)) {
				return true;
			}
		}
		return false;
	}
}
