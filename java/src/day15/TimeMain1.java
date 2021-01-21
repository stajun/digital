package day15;

import java.util.Calendar;

public class TimeMain1 {

	public static void main(String[] args) {
		//아래 코드가 실행된 시간을 기준으로 날짜 객체를 생성
		Calendar today = Calendar.getInstance();
		/* get(int field) 
		 *  - field값에 따라 년, 월,일,주 등의 다양한 정보를 정수로 반환한다.
		 *  - 월의 경우 0~11을 반환 
		 *  - 요일 : 일-1, 월-2, 화-3, 수-4, 목-5, 금-6, 토-7
		 * */
//		System.out.println("년 : " + today.get(Calendar.YEAR));
//		System.out.println("월 : " + (today.get(Calendar.MONTH)+1));
//		System.out.println("일 : " + today.get(Calendar.DAY_OF_MONTH));
//		System.out.println("요일 :" + today.get(Calendar.DAY_OF_WEEK));
//		System.out.println("시 : " + today.get(Calendar.HOUR));
//		System.out.println("분 : " + today.get(Calendar.MINUTE));
//		System.out.println("초 : " + today.get(Calendar.SECOND));
//		System.out.println("오전(0), 오후(1) : "
//				+today.get(Calendar.AM_PM));
		int year 			= today.get(Calendar.YEAR);
		int month 		= (today.get(Calendar.MONTH)+1);
		int day 			= today.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
		int hour 			= today.get(Calendar.HOUR);
		int minute 		= today.get(Calendar.MINUTE);
		int second 		= today.get(Calendar.SECOND);
		int ampm 			= today.get(Calendar.AM_PM);
		String ampmString = ampm == 1?"오후":"오전";
		String dayOfWeekString="";
		switch(dayOfWeek) {
		case 1:	dayOfWeekString="일";	break;
		case 2:	dayOfWeekString="월";	break;
		case 3:	dayOfWeekString="화";	break;
		case 4:	dayOfWeekString="수";	break;
		case 5:	dayOfWeekString="목";	break;
		case 6:	dayOfWeekString="금";	break;
		case 7:	dayOfWeekString="토";	break;
		}
		System.out.println(year+"-"+month+"-"+day+" " 
				+ dayOfWeekString + "요일");
		System.out.println(ampmString+" "+hour+":"+minute+":"+second);
	}

}
