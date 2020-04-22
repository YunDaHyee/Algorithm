package _3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
	@Question
		오늘은 2007년 1월 1일 월요일이다.
		그렇다면 2007년 x월 y일은 무슨 요일일까? 이를 알아내는 프로그램을 작성하시오.
	@Input
		첫째 줄에 빈 칸을 사이에 두고 x(1≤x≤12)와 y(1≤y≤31)이 주어진다.
		참고로 2007년에는 1, 3, 5, 7, 8, 10, 12월은 31일까지 // 4, 6, 9, 11월은 30일까지 // 2월은 28일까지 있다.
		1) 1 1
		2) 3 14
		3) 9 2
		4) 12 25
	@Output
		첫째 줄에 x월 y일이 무슨 요일인지에 따라 SUN, MON, TUE, WED, THU, FRI, SAT중 하나를 출력한다.
		1) MON
		2) WED
		3) SUN
		4) TUE
	@history
		날짜 관련 클래스(Date,Calendar)를 갖다 써야한다고 생각했는데 생각해보면은 그렇게 쓰면 끝도 없겠단 생각을 함..
		모든 클래스들을 알 수도 없는 노릇이고 단순하게 생각 후에 접근하는 거로 해야함..
		그니까 수학적으로 접근하는 방법을 써야한다.. 
		사실 이 생각이 들었던 건 다 풀고나서 다른 사람들 답 보고 깨달음,,
		
		-타 코드 Review
		배열 2개 : 월별 말일,요일
		입력받은 월의 전까지의 일수들을 다 더하고 입력받은 일수만큼 더하는 원리
 *
 */
public class _1924_2 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br	= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw	= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		String[]		raw	= br.readLine().split(" ");
		int				mth	= Integer.parseInt(raw[0]); 
		int				day	= Integer.parseInt(raw[1]); 
		
		/*
		if( date[0].length() == 1 ){
			date[0] = "0"+date[0];
		}
		if( date[1].length() == 1 ){
			date[1] = "0"+date[1];
		}
		
		Date		today	= new SimpleDateFormat("yyyyMMdd").parse("2007"+date[0]+date[1]);
		Calendar	cal		= Calendar.getInstance(); // 현재 시간 객체 가져오기
		cal.setTime(today); // 내가 설정한 날짜로 맞추기.
		
		// 근데 꼭 굳이 이렇게 Date 클래스 안이용하고 Calendar클래스만으로 날짜 설정이 가능함
		// : cal.set(2007,date[0]-1,date[1])
		
		
		String		day		= "";
		
		switch( cal.get(Calendar.DAY_OF_WEEK) ){
			case 1 : 
				day = "SUN";
				break;
			case 2 : 
				day = "MON";
				break;
			case 3 : 
				day = "TUE";
				break;
			case 4 : 
				day = "WED";
				break;
			case 5 : 
				day = "THU";
				break;
			case 6 : 
				day = "FRI";
				break;
			case 7 : 
				day = "SAT";
				break;
		}
		
		bw.write( day );
		
		*/
		
		/* 타 코드 적용 ---------------------------------------------------------------- */
		int[]	endDateArr	= { 31,28,31,30,31,30,31,31,30,31,30,31 };
		String[]	dayArr	= { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		
		for( int i=1;i<mth;i++ ){
			day += endDateArr[i-1];
		}
		
		bw.write( dayArr[day%7] );
		/* ----------------------------------------------------------------------------- */
	
		br.close();
		bw.flush();
		bw.close();
		
	/*	타 코드 1)
		int[] daysOfYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT","SUN"};
		
		int result = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] mmdd = br.readLine().split(" ");
		int month = Integer.parseInt(mmdd[0]);
		int date = Integer.parseInt(mmdd[1]);
		
		if(month > 1) {
			for(int i = 1; i < month; i++) {
				result += daysOfYear[i-1];
			}
		}
		
		result += date - 1; // 여기서 1을 빼는 이유는 요일이 월요일부터 시작해서임. 걍 일욜부터 시작하면 똑같음
		System.out.println(days[result % 7]);
	*/
		
	/*	타 코드 2)
 		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));	
		String[] str = bfr.readLine().split(" ");
		int month = Integer.valueOf(str[0]);
		int days = Integer.valueOf(str[1]);
				
		int[] monthArr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] dateArr = {"SUN","MON", "TUE", "WED", "THU" ,"FRI","SAT"};

		for(int i=0;i<month-1;i++)
			days += monthArr[i];
			
		System.out.print(dateArr[days%7]);
	*/	 
		 
		
	}
}
