package review3;

import java.util.ArrayList;

public class BoardMain {

	public static void main(String[] args) {
		/* 1. 게시글 등록
		 * 2. 게시글 조회
		 * 3. 게시글 수정
		 * 4. 게시글 삭제
		 * 5. 게시글 목록
		 * 6. 종료
		 * 번호		제목	작성자	작성일
		 * 게시글
		 *  - 번호, 제목, 내용, 작성자, 작성일
		 * */
		ArrayList<A> list = new ArrayList<A>();
		for(int i = 0; i<5; i++) {
			//객체 생성
			A tmp = new A();
			//리스트에 객체 추가
			list.add(tmp);
			System.out.println(tmp);
		}
		System.out.println("-----------------");
		for(A tmp : list) {
			System.out.println(tmp);
		}
	}
}
class A{
	static int count = 0;
	int num;
	public A() { 
		count ++;
		num = count;
	}
	public String toString() {
		return "번호 : " + num + "생성된 객체 수 : " + count;
	}
}
