package day8;

/* Card 클래스 : 포커게임에서 사용하는 카드를 나타내는 클래스
 *  - 숫자 : 1~10, J, Q, K
 *  - 문양 : 세잎, 하트, 클로버, 다이아
 *  - 카드 정보 출력 기능
 *    - ♡1, 하트1 
 * 1. 멤버변수 설정
 * 2. 메소드 구현
 * */
/* - 클래스의 구성
 *  - 멤버 변수 : 클래스의 속성/정보
 *  - 멤버 메소드 : 클래스의 기능
 *  - 생성자 : 클래스의 멤버 변수를 초기화하는 메소드라 생각하면 된다
 * - 생성자의 이름은 클래스명으로 고정, 리턴타입 자리가 없다.
 * - 클래스의 생성자가 하나도 없으면 기본 생성자가 자동으로 생성된다.
 * - 생성자 선언 방법
 * public 클래스명(){
 * }//생성자
 * public void 클래스명(){
 * }//메소드
 * */
public class Card{
	//숫자
	private int num;
	//문양
	private char shape;
	
	public void print() {
		System.out.print(shape);
		
		switch(num) {
		case 11:
			System.out.print("J ");
			break;
		case 12:
			System.out.print("Q ");
			break;
		case 13:
			System.out.print("K ");
			break;
		default:
			System.out.print(num+" ");
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		if(num < 1 || num > 13) {
			this.num = 1;
		}
		else {
			this.num = num;
		}
	}

	public char getShape() {
		return shape;
	}

	public void setShape(char shape) {
		//♥♣◆♠
		switch(shape) {
		case '♥':	case '♣': case '◆': case '♠':
			this.shape = shape;
			break;
		default:
			this.shape = '♥';
		}
	}
	public Card() {
		setShape('♥');
		setNum(1);
	}

}
