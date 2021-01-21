package day6;

public class 랜덤 {

	public static void main(String[] args) {
		/* Math.random()은 0보다 크거나 같고, 1보다 작은 실수를 임의로(랜덤으로) 생성
		 * 0 <= Math.random() < 1
		 * A ~ B 사이의 정수를 갖는 랜덤한 수 공식 설명
		 * (B-A+1)*0 <= (B-A+1)*Math.random < (B-A+1) * 1
		 * 0 <= (B-A+1)*Math.random < B-A+1
		 * A <= (B-A+1)*Math.random + A < B-A+1 + A
		 * A ~ B 사이의 정수를 갖는 랜덤한 수
		 * A <= (B-A+1)*Math.random + A < B+1
		 * */
		int min = 1;
		int max = 3;
		int random = (int)((max - min + 1) * Math.random() + min);
		System.out.println(random);
	}
	
}


