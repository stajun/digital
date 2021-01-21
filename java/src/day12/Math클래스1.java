package day12;

public class Math클래스1 {

	public static void main(String[] args) {
		/* round() : 소수점 첫째자리에서 반올림해서 결과값을 정수(long)으로 반환하는 메소드*/
		double num = 123.45678;
		System.out.println(num + "를 소수점 1번째자리에서 반올림 : " 
				+ Math.round(num));
		System.out.println(num + "를 소수점 "+3+"번째자리에서 반올림 : " 
				+ round(num,2));
		/* ceil : 소수점 첫째자리에서 올림해서 결과값을 실수로 반환하는 메소드*/
		System.out.println(num + "를 소수점 1번째자리에서 올림 : " 
				+ Math.ceil(num));
		/* floor: 소수점 첫째자리에서 내림해서 결과값을 실수로 반환하는 메소드*/
		System.out.println(num + "를 소수점 1번째자리에서 내림 : " 
				+ Math.floor(num));
		/* rint : 가장 가까운 정수로 반환하는 메소드로, .5와 같이 올려도 되고 버려도
		 * 				되는 경우 짝수 결과값으로 반환된다.*/
		System.out.println(num + "에서 가장 가까운 정수 : " 
				+ Math.rint(num));
		num = 123.5;
		System.out.println(num + "에서 가장 가까운 정수 : " 
				+ Math.rint(num));
	}
	
	public static double round(double num, int count) {
		//원래 값에 10의 count 제곱만큼 곱함
		for(int i=1; i<=count; i++) {
			num *= 10;
		}
		//결과에서 round()
		num = Math.round(num);
		//결과에서 10의 count제곱만큼 나누기함
		for(int i=1; i<=count; i++) {
			num /= 10;
		}
		return num; 
		
	}
}
