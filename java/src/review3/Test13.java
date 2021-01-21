package review3;

public class Test13 {

	public static void main(String[] args) {
		/* 상속 : 부모의 멤버 변수/메소드를 물려 받는 것
		 * - 접근제한자가 public, protected인 멤버 변수/메소드만
		 * 	 물려 받는다. 단, 부모 클래스와 같은 패키지에 있는 경우
		 * 	 default도 물려 받을 수 있다.
		 * - 언제? 미리 만들어서 사용하는 클래스가 있는데, 해당
		 *   클래스를 수정하지 않고 해당 클래스의 멤버 변수와 메소드가
		 *   필요하면서 새로운 기능들이 필요한 경우
		 * - 언제? 라이브러리에서 제공하는 클래스 중 일부는 특정 클래스의 
		 *   기능을 필요로 하는 경우 상속을 받아 재정의하여 사용한다.
		 * */
		/* 컬렉션 프레임워크
		 * - list : 중복 o => 순서 보장
		 * - set : 중복 x => 순서 보장 x
		 * - map
		 *  - key : 중복 x => 순서 보장 x
		 *  - value : 중복 o
		 * - 여러 동일한 데이터를 관리할때 사용
		 * - 배열보다 편리=> 다양한 관련 메소드를 제공
		 * */
		/* 예외처리
		 * - 특정 상황에서 문제가 발생할 때 발생하는 상황을 처리하기위한
		 * 	 문법
		 * - RuntimeException을 제외한 예외들은 무조건 예외 처리해야한다
		 * - RuntimeException
		 * 	- ArithmeticException : 0으로 나눌때 발생
		 *  - ArrayIndexOutOfBoundsException : 배열의 잘못된 
		 *  	번지를 접근할 때
		 * - 예외처리 방법
		 *  - 1. 직접처리 try~catch()
		 *  - 2. 간접처리 throw : 메소드를 정의할 때 
		 * - 예외가 발생했는데 예외처리하지 않으면 프로그램이 중단된다
		 * - 예외 처리를 하면 프로그램을 중단 하지 않을 수 있다. 
		 * - catch를 이용하여 예외 클래스를 추가할 수 있는데,
		 * 	 자식 클래스가 부모 클래스 다음에 오면 안됨
		 * - finally는 해당 메소드가 종료되더라도 메소드가 종료후에도
		 *   실행되는 코드
		 * - throw를 이용하여 다른 메소드에게 예외처리를 맡기는 경우
		 *   해당 메소드에 어떤 예외가 발생하는지 throws로 명시해줘야한다.
		 *   단, 예외가 RuntimeException인 경우 생략 가능, 나머지는
		 *   생략 불가
		 * */
		int num1 = 1, num2 = 0;
		int res = 0;
		int [] arr = new int[5];
		
		try {
			insertArray(arr,10, 5);
			//res = num1 / num2;
		}
		catch(ArithmeticException e) {
			System.out.println("예외1 발생");
			return ;
		}
		catch(Exception e) {
			System.out.println("예외 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			System.out.println("예외에 상관없이 무조건 실행");
		}
		System.out.println("결과 : " + res);
	}
	
	public static void insertArray(int []arr, int data, int index)
	throws Exception
	{
		if(index >= arr.length)
			throw new Exception("배열 예외");
		arr[index] = data;
	}
}
class Board2{
	//게시판 관련 멤버 변수와 메소드가 있다고 가정
}
class NoticeBoard extends Board2{
	//게시판 관련 멤버 변수와 메소드를 상속
	
	//공지사항에 필요한 멤버 변수와 메소드를 추가
}




