package day7;

public class 로또예제 {

	public static void main(String[] args) {
		int [] lotto = new int[7];//당첨번호, 6번지가 보너스번호
		int [] user = new int[6];
		int min = 1, max = 45;
		randomArray(lotto,min, max);
		
		printArray(lotto);
		randomArray(user,min,max);
		printArray(user);
		int rank = lottoRank(lotto, user);
		
		if(rank == -1) {
			System.out.println("꽝입니다. 다음기회에..");
		}else {
			System.out.println(rank+"등입니다. ");
		}
		switch(rank) {
		case 1:	case 2:	case 3:	case 4:	case 5:
			System.out.println(rank+"등입니다. ");
			break;
		default:
			System.out.println("꽝입니다. 다음기회에..");
		}
		
	}
	/* 기능 : 원하는 정수 범위의 랜덤 값을 알려주는 메소드
	 * 매개변수 : 원하는 정수 범위 => min부터 max까지 =>int min, int max
	 * 리턴타입 : 랜덤한 값 =>정수 =>int
	 * 메소드명 : random
	 * */
	static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)((max - min + 1) * Math.random() + min);
	}
	/* 기능 : 주어진 배열에 모든 번지에 있는 값을 랜덤으로 설정하는 메소드 
	 * 매개변수 : 주어진 배열, 랜덤 범위=>int []arr, int min, int max
	 * 리턴타입 : 없음=>void
	 * 메소드명 : randomArray
	 * */
	static void randomArray(int []arr, int min, int max) {
		if(max-min+1 <= arr.length) {
			System.out.println("정수의 범위가 배열의 크기보다 작습니다.");
			return ;
		}
		int cnt = 0;//현재까지 만들어진 중복되지 않은 랜덤수의 개수
		while(cnt < arr.length) {
			int r = random(min, max);
			if(!isContain(arr,r)) {
				arr[cnt] = r;
				cnt++;
			}
		}
	}
	/* 기능 : 주어진 정수 배열의 값들을 콘솔에 출력하는 메소드
	 * 매개변수 : 정수 배열 => int arr[]  
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printArray
	 * */
	static void printArray(int arr[]) {
		for(int i=0; i<arr.length ; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	/* 기능 : 배열에 특정 값이 있는지 없는지 알려주는 메소드
	 * 매개변수 : 배열, 특정 값=>int []arr, int num
	 * 리턴타입 : 있는지 없는지 => 참 또는 거짓=>boolean
	 * 메소드명 : isCotain
	 * */
	static boolean isContain(int []arr, int num) {
		for(int tmp : arr) {
			if(tmp == num) {
				return true;
			}
		}
		return false;
	}
	/* 기능 : 로또 번호의 등수를 알려주는 메소드
	 *    => 사용자가 자동으로 생성한 번호가 몇등인지 알려주는 메소드
	 *       (단, 등수에 없으면 -1을 알려줌) 
	 * 매개변수 : 로또번호, 사용자 번호=>int []lotto, int []user
	 * 리턴타입 : 당첨 등수 => int
	 * 매소드명 : lottoRank
	 * */
	static int lottoRank(int []lotto, int []user) {
		if(lotto.length <= user.length)
			return -1;
		int cnt = 0;//로또번호와 일치하는 사용자 번호 갯수(단, 보너스번호는 제외)
		//보너스 번호를 갯수에 포함시키지 않기 위해 user.length개만큼만 비교
		for(int i = 0; i<user.length; i++) {
			//로또번호에서 하나 꺼낸 번호가 사용자 번호에 있는 확인하여
			//있으면 갯수를 증가, 없으면 아무것도 안함
			if(isContain(user, lotto[i])) {
				cnt++;
			}
		}
		switch(cnt) {
		case 6:	return 1;
		case 5:
			return isContain(user,lotto[lotto.length-1])?2:3;
			/*
			 * if(isContain(user,lotto[lotto.length-1]))
			 * 	return 2;
			 * else
			 * 	return 3;
			 * */
		case 4:		return 4;
		case 3:		return 5;
		default:	return -1;
		}
	}
}
