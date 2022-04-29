/**
 * 
 */
package StepBystep._2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
	문제
		상근이는 매일 아침 알람을 듣고 일어난다. 알람을 듣고 바로 일어나면 다행이겠지만, 항상 조금만 더 자려는 마음 때문에 매일 학교를 지각하고 있다.
		상근이는 모든 방법을 동원해보았지만, 조금만 더 자려는 마음은 그 어떤 것도 없앨 수가 없었다.
		이런 상근이를 불쌍하게 보던, 창영이는 자신이 사용하는 방법을 추천해 주었다.
		바로 "45분 일찍 알람 맞추기"이다.
		이 방법은 단순하다. 원래 맞춰져있는 알람을 45분 앞서는 시간으로 바꾸는 것이다. 어차피 알람 소리를 들으면, 알람을 끄고 조금 더 잘 것이기 때문이다.
		이 방법을 사용하면, 매일 아침 더 잤다는 기분을 느낄 수 있고, 학교도 지각하지 않게 된다.
		현재 상근이가 맞춰논 알람 시각이 주어졌을 때, 창영이의 방법을 사용한다면, 이를 언제로 고쳐야 하는지 구하는 프로그램을 작성하시오.
	
	입력
		첫째 줄에 두 정수 H와 M이 주어진다. (0 ≤ H ≤ 23, 0 ≤ M ≤ 59) 그리고 이것은 현재 상근이가 맞춰놓은 알람 시간 H시 M분을 의미한다.
		입력 시간은 24시간 표현을 사용한다. 24시간 표현에서 하루의 시작은 0:0(자정)이고, 끝은 23:59(다음날 자정 1분 전)이다. 시간을 나타낼 때, 불필요한 0은 사용하지 않는다.
		10 10
	
	출력
		첫째 줄에 상근이가 창영이의 방법을 사용할 때, 맞춰야 하는 알람 시간을 출력한다. (입력과 같은 형태로 출력하면 된다.)
		9 25
	HISTORY
		솔직히 또 시간 문제라서 지레 겁먹었었는데 생각보다 아주 단순한 거였다.
		자꾸 시간 관련 라이브러리를 쓴다고 생각해서 그런가? 시간 관련 문제가 좀 어렵게 다가온다.
		저번에 date 한번 했었을 떄 뭐 시간 1094인가 빼고 시작하는 그런 게 있었는데 그런 걸 해야한다고 생각하니까 어렵다고 느껴지는 듯.
		두려워 하지말자ㅏ...
		
 */

public class _2884 {
	public static void main(String[] args) throws IOException {
		BufferedReader br	= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw	= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		String[]	time	= br.readLine().split("\\s");
		int			hour	= Integer.parseInt( time[0] );
		int			minute 	= Integer.parseInt( time[1] );
		
		
		if( minute >= 45 ) {
			minute -= 45;
		}else {
			if( hour==0 ) { // 0시 일때는 -1하면 -1이 되는 예외처리를 안해주는 실수를 했었음. 그래도 금방 파악하고 해냈다!
				hour = 24;
			}
			hour -= 1;
			minute = 60 - 45 + minute;
		}
		
		bw.write( hour + " " + minute );
		
		br.close();
		bw.flush();
		bw.close();
	}
}
