package day14;

public class LottoE extends Lotto2 {
	private int bonus;
	
	@Override
	protected void init() {
		super.init();
		bonus = 0;
	}
	@Override
	public void randomLotto() {
		super.randomLotto();
		//보너스 번호가 중복되지 않게 랜덤으로 생성
		while(true) {
			int r = random();
			if(!contain(r)) {
				bonus = r;
				break;
			}
		}
	}
	@Override
	public String toString() {
		return super.toString()+", [" + bonus + "]";
	}
	public void insertNumber(int []arr,int bonus) {
		if(arr.length < numbers.length)
			throw new RuntimeException("저장하려는 배열의 숫자가 적습니다.");
		super.insertNumber(arr);
		this.bonus = bonus;
	}
	@Override
	public void insertNumber(int []arr) {
		if(arr.length < numbers.length+1)
			throw new RuntimeException("저장하려는 배열의 숫자가 적습니다.");
		super.insertNumber(arr);
		bonus = arr[numbers.length];
	}
	public int getBonus() {
		return bonus;
	}
}
