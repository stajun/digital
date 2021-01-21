package day16;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class ListEx1 {

	public static void main(String[] args) {
		//ArrayList<클래스명A> 객체명 = new ArrayList<클래스명A>();
		//저장할 데이터의 클래스명이 클래스명A
		//예를 들어 오늘의 할일을 ArrayList에 저장하려고 한다
		//이 때 클래스명A에 적당한 클래스는?
		//하루일과를 문자열로 저장 => String
		ArrayList<String> list = new ArrayList<String>();
		list.add("오전수업");
		list.add("점심");
		list.add("오후수업");
		list.add("하원");
		list.remove(0);//0번지에 있는 오전 수업 삭제
		list.remove("점심");//점심.equals()의 결과가 true인 정보를 삭제
		list.add("저녁");
		ArrayList<String> eat = new ArrayList<String>();
		eat.add("점심");
		eat.add("저녁");
		list.retainAll(eat);//list에 있는 데이터 중 eat에 있는 목록만 남김
		list.add("운동");
		list.add("복습");
		list.add("취침");
//		list.sort(new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				return -o1.compareTo(o2);
//			}
//		});
		list.sort(new Test());
		
		//list 출력
		System.out.println("-오늘의 할일-");
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("----------");
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String tmp = it.next();
			System.out.println(tmp);
		}
	}

}
class Test implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return -o1.compareTo(o2);
	}
	
}
