package day1;

public class 변수 {

	public static void main(String[] args) {
		// 주석 : 코드의 영향을 미치지 않은 문구로, 
		// 설명을 위해사용
		// //는 한줄 주석
		/* 주석입니다.
		 * 여러줄 주석입니다.
		 * */
		//변수 선언 방법
		//변수타입 변수명;
		char ch;//문자형 변수 ch를 선언
		int num1;
		long num2;
		float num3;
		double num4;
		boolean bool;
		int appleCount;//변수의 이름은 의미있게
		int applecount;//대소문자 구별한다
		//int ch;//중복 선언 불가
		//변수 선언 및 초기화 방법
		//변수타입 변수명 = 값;
		//문자는 한글자를 의미, 문자는 앞뒤로 ''를 붙인다
		char cha1 = 'A';
		char cha2 = '1';
		char cha3 = '한';
		char cha4 = '\'';
		char cha5 = '_';
		
		int numb1 = 10;		//십진수 10을 저장
		int numb2 = 010;	//8진수 10을 저장=>10진수 8
		int numb3 = 0x10;	//16진수 10을 저장=>10진수 16
		//int numb4 = 123456789012;
		
		//기본 정수값은 int형으로 인식이 된다.
		//큰 수의 경우 int형으로 표현할 수 없는경우
		//에러가 발생한다.
		//long은 접미사 L을 쓸수 있는데
		//큰 수를 다룰 때에는 꼭 써야한다.
		//long numb5 = 123456789012;//에러 발생
		long numb5 = 123456789012L; 
		
		//기본 실수값은 double형으로 인식이된다.
		//float형의 실수값은 접미사 f를 꼭 붙인다.
		float numb6 = 1.234F;
		
		double numb7 = 1.23456;
		
		boolean bool1 = true;
		boolean bool2 = false;
		
		//변수 선언후 초기화2
		//변수타입 변수명 = 변수명;
		int kor1 = 100;
		int kor2 = kor1;
		
		//여러 변수를 한번에 선언하는 방법
		//단, 같은 변수 타입만 가능
		//정수형 변수 a는 10을, b는 20을, c는 30을 저장하도록 선언
		int a = 10, b = 20, c = 30;
		int e, d = 20;
	}

}
