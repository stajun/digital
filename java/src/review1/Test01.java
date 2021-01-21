package review1;

public class Test01 {

	public static void main(String[] args) {
		/* '':문자, "" : 문자열 */
		System.out.println("Hello world!!");
		/* 변수이름이 num이고 정수 10을 num에 저장하고, 콘솔에
		 * 출력하세요. */
		int num = 10;
		System.out.println("num : " + num);
		/* 문자열 str1에 Hello를 문자열 str2에 Hi를 저장한 후
		 * 두 문자열이 같은 문자열인지 비교하는 코드를 작성하세요.
		 * */
		String str1 = "Hello";
		String str2 = "Hi";
		if(str1.equals(str2)) {
			System.out.println(str1+"과 "+str2+"는 같습니다.");
		}else {
			System.out.println(str1+"과 "+str2+"는 다릅니다.");
		}
	}
}
