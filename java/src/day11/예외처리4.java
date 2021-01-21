package day11;

public class 예외처리4 {

	public static void main(String[] args) {
		char op = '?';
		try {
			switch(op) {
			case '+':case '-': case '*': case '/': case '%':
				System.out.println(op+"는 산술연산자입니다.");
				break;
			default:
				//op가 산술 연산자가 아닌 경우 산술연산자가 아니라는 예외를 발생 
				RuntimeException e = new RuntimeException(op+"는 잘못된 산술연산자입니다.");
				throw e;
				//throw new RuntimeException(op+"는 잘못된 산술연산자입니다.");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("프로그램 종료");
	}

}
