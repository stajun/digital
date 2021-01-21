package day8;

public class 클래스2 {

	public static void main(String[] args) {
//		Card c = new Card();
//		c.print();
//		//카드 모양과 숫자 설정
//		c.setNum(12);
//		c.setShape('◆');
//		//카드 모양과 숫자를 출력하는 코드
//		c.print();
		CardPack cp = new CardPack();
		cp.shuffle();
		Card tmp;
		for(int i = 1; i<=4; i++) {
			for(int j = 1; j<=13; j++) {
				tmp = cp.pick();
				tmp.print();
			}
			System.out.println();
		}
	}
}
/* CardPack 클래스
 *  - 카드팩 : 52장의 카드들
 *  - 카드 섞기 기능 
 *  - 카드 빼내는 기능
 *  - 카드 초기화 기능
 * */
class CardPack{
	private Card [] pack = new Card[52];
	private int cnt = 0;//현재 남은 카드 갯수
	
	public void shuffle() {
		int min = 0;
		int max = pack.length-1;
		for(int i=0; i<pack.length; i++) {
			int index = (int)((max - min + 1) * Math.random() + min);
			Card tmp = pack[i];
			pack[i] = pack[index];
			pack[index] = tmp;
		}
	}
	//리턴타입 : 꺼내간 카드=>Card
	public Card pick(){
		if(cnt == 0) {
			return null;
		}
		cnt--;
		return pack[cnt];
	}
	
	public void init() {
		cnt = 52;
		shuffle();
	}
	public int getCnt() {
		return cnt;
	}
	public CardPack() {
		char shape='♥';
		for(int i = 1; i<=4; i++) {
			//i 값에 따라 카드 모양을 결정
			switch(i) {
			//♥◆♣♠
			case 1:	shape='♥'; break;
			case 2:	shape='◆'; break;
			case 3:	shape='♣'; break;
			case 4:	shape='♠'; break;
			}
			for(int j = 1; j<=13; j++) {
				//카드 1장 생성
				Card tmp = new Card();
				tmp.setNum(j);
				tmp.setShape(shape);
				//카드 팩에 카드를 추가
				pack[cnt] = tmp;
				//카드팩에 들어있는 카드 갯수 증가
				cnt++;
			}
		}
	}
}



