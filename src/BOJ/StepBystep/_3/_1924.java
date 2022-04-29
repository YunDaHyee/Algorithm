package StepBystep._3;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
	@Question
		오늘은 2007년 1월 1일 월요일이다. 그렇다면 2007년 x월 y일은 무슨 요일일까? 이를 알아내는 프로그램을 작성하시오.
	@Input
		첫째 줄에 빈 칸을 사이에 두고 x(1≤x≤12)와 y(1≤y≤31)이 주어진다.
		참고로 2007년에는 1, 3, 5, 7, 8, 10, 12월은 31일까지, 4, 6, 9, 11월은 30일까지, 2월은 28일까지 있다.
	@Output
		첫째 줄에 x월 y일이 무슨 요일인지에 따라 SUN, MON, TUE, WED, THU, FRI, SAT중 하나를 출력한다.
	@history
		달력에 레알 약한데,,,ㅎㅎ,,이것도 수학을 잘 못해서 그런 것 같다. 막 빼고 이래야 하니까,,
		아무튼 이거 풀려고하는데 로직은 잘 짰는데 막혔던 부분이 두가지였따.
		
		===================================================
					1. 정규식 - 숫자 범위 처리
					2. 		요일 구하기
		===================================================
		
		1. 정규식
		정규식은 오히려 쉽게 짰는데 두자리 수는 틀렸다고 처리해버리는 것이다;;
		원래 숫자범위는 지정안하고 숫자만 입력하도록 정규식을 짜고 그 후에 if문으로 x와 y의 범위를 조건 걸었다.
		근데 두 자리 수에서 안걸리는 거 보고 그냥 숫자 범위까지 정규식으로 짜자는 생각으로 짜게 됐다. 
		[0-9] 자체가 '숫자' 만을 의미하는 줄 알았는데 그게 아니라 진짜 범위였음;;
			▶ 깨닫음	:
						(1) 특정숫자[범위] ex) 1[0-9][0-3]		: 1,0~9,0~3 까지 즉 숫자의 범위가 100~193 가능함
						(2) 특정숫자[범위]1|특정숫자[범위]2|... : 이런식으로 | 로 구분을 주면 특정 숫자간의 범위를 지정할 수 있음. [  ] 이거랑 같다고 함!
		
		2. 요일 구하기
		시발,, 진짜 이거땜에 이틀 고생함.. 진짜 휴ㅡㅡ;;; 
		아니 존나 쌩지랄을 다해도 요일이 안나오더라. 할 말이 존나 많은데 하 ..
		요약하자면, 요일을 구하는 함수가 있어서 그걸 썼는데 내가 넣은 날짜에 해당하는 요일이 안나오고 엉뚱한 요일을 쳐뱉어가지고 온갖 난리를 침.
			▶ 시행착오 : 주석에 처리
			▶ 깨닫음 	:
						=> 자세한 건 OneNote,,
						(1) SimpleDateFormat 클래스 : date 형식의 객체를 특정 날짜 format 으로 출력을 할 수 있게 해주는 클래스
						(2) Calendar 클래스			: Date 클래스와 같이 날짜,시간 정보를 출력할 수 있게 해주는 클래스
		
		 
	@author dada
 */
public class _1924 {
	public static void main(String[] args) {
		Scanner sc		= new Scanner(System.in);
		Pattern pt		= Pattern.compile("(([1-9]|1[0-2])\\s([1-9]|1[0-9]|2[0-9]|3[0-1]))"); // ("(([1-9]|1[0-2])\\s([1-9]|1\\d|2\\d|3[0-1]))"); -> 이것두 가능!
		String	ck		= "";	// 입력 받는 변수
		String[]ckArr	= null;
		int		x		= 0;	// 월
		int		y		= 0;	// 일
		int		endDay	= 0;	// 해당 월의 끝 일
		int		resDay	= 0;	// 결과 요일
		
		try {
			
			while (true) {
				ck = sc.nextLine();

				if (pt.matcher(ck).find() == true) {
					ckArr = ck.split(" ");
					x = Integer.parseInt(ckArr[0]);
					y = Integer.parseInt(ckArr[1]);

					// 특정 달에 끝 일 지정
					if( x == 2 ){
						endDay = 28;
                    }else if( x == 4 || x == 6 || x == 9 || x == 11 ){
                		endDay = 30;
                    }else{
                        endDay = 31;
                    }
					
					// 끝 일 유효성 검사
					if( y > endDay ){
						continue;
					}else{
						Calendar cd = Calendar.getInstance();
						cd.set( Calendar.YEAR	, 2007	);
						cd.set( Calendar.MONTH	, x-1	);
						cd.set( Calendar.DATE	, y		);
						resDay = cd.get( Calendar.DAY_OF_WEEK );
						
						if( resDay == 1 ){
							System.out.println("SUN");
							break;
						}else if( resDay == 2 ){
							System.out.println("MON");
							break;
						}else if( resDay == 3 ){
							System.out.println("TUE");
							break;
						}else if( resDay == 4 ){
							System.out.println("WED");
							break;
						}else if( resDay == 5 ){
							System.out.println("THU");
							break;
						}else if( resDay == 6 ){
							System.out.println("FRI");
							break;
						}else if( resDay == 7 ){
							System.out.println("SAT");
							break;
						}else{
							continue;
						}
					}
					
					/* ------------------------------------------------------------------------------------------------------------------------------- */
																				/* 시행착오 코드들,, */
					/*
						- 월/일에 한 자릿수는 앞에 0 붙이기 위해서 처음에 이렇게 했었음.
						if (ckArr[0].length() == 1) {
							ckArr[0] = '0' + ckArr[0];
						}

						if (ckArr[1].length() == 1) {
							ckArr[1] = '0' + ckArr[1];
						}
					*/
						
					/*
						 - 단순하게 날짜를 셋팅해서 Day, 그니까 요일을 가져오는 것도 해봄
						 Date dt = new Date(2017,x,y);
						 rs = dt.getDay(); //0 = Sunday, 1 = Monday, 2 = Tuesday, 3 = Wednesday, 4 = Thursday, 5 = Friday, 6 =
					*/
						
					/*
					  	- 이 코드 갖고 몇~~번을 이리저리 바꿔봤는지 모른다...,,,
						DateFormat format = new SimpleDateFormat("yyyymmdd");	// 날짜 format 지정
						Date dt = format.parse("2007" + ckArr[0] + ckArr[1]);	// 원하는 날짜를 저 format으로 설정
						Calendar cd = Calendar.getInstance();					// 현재 OS에 설정되어 있는 시간대를 기준으로 한 Calendar 하위 객체
						cd.setTime(dt);											// Calendar 객체에 원하는 날짜로 설정함
						rs = cd.get(Calendar.DAY_OF_WEEK)-1;					// 1부터 시작해야하니까 1 빼래..솔직히 이해 못함 이거;
						 														// 근데 아무튼 계쏙 여기서 다른 거 뱉어냈어.
					*/
						
					/*
					 	-
						정답 되기 전에 계~~~속 런타임 오류가 나는거야;
						진짜 다른 엄한 것들 다 바꿔봤는데도 계속 그러더라..
						그러다 문득, 대한통운 화물 정보망 고도화 프로젝트에서 파트너사앱 개발하면서
						어떤 특정 서비스에서 switch~case 문으로 로직을 짠 게 있는데
						허드슨으로 빌드하는데 오류가 나가지고 찾아보니 그게 java 몇 부터는 swich~case문 에러난다고
						씽크엠 서버 팀장님이 말해준 게 기억이 났다.
						그래서 혹시나,,혹시나 하고 if문으로 바꿔봤떠니 되더라;;;;;;;;;;;
						
						switch (rs) {
							case 0:
								System.out.println("SUN");
								break;
								
							case 1:
								System.out.println("MON");
								break;
	
							case 2:
								System.out.println("TUE");
								break;
	
							case 3:
								System.out.println("WED");
								break;
	
							case 4:
								System.out.println("THU");
								break;
	
							case 5:
								System.out.println("FRI");
								break;
	
							case 6:
								System.out.println("SAT");
								break;
						}
					 */
					/* ------------------------------------------------------------------------------------------------------------------------------- */
					
				} else {
					continue;
				}//regex
			}//while
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
	}
}
