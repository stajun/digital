package day1;

public class 문자열 {

	public static void main(String[] args) {
		// 문자는 1글자, 문자열을 0글자이상
		// 문자는 유니코드표에 있는 값에 따라 저장된다.
		char ch = 'A';
		//문자 A에 대한 유니코드 값이 출력
		System.out.println((int)ch);
		ch = '가';
		//문자 가에 대한 유니코드 값이 출력
		System.out.println((int)ch);
		ch = (char)66;
		//66에 일치하는 유니코드 문자가 출력
		System.out.println(ch);
		System.out.println("------------");
		//문자열을 저장하기 위한 클래스 String
		//문자열 ''가 아닌 ""를 이용
		String str = "";
		System.out.println("문자열:"+str);
		str = "안녕하세요";
		System.out.println("문자열:"+str);
	}
}
