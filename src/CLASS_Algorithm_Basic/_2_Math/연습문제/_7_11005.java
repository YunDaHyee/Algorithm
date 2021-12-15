/**
 * 
 */
package _2_Math.연습문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
	@문제
		10진수 -> B진수
		10진법 수 N이 주어진다.
		이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.
		10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다.
		이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
		A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
	@입력
		첫째 줄에 N과 B가 주어진다.(2 ≤ B ≤ 36) N은 10억보다 작거나 같은 자연수이다.
		60466175 36
	@출력
		첫째 줄에 10진법 수 N을 B진법으로 출력한다.
		ZZZZZ
	@HISTORY
		밖에서만 몫이 0일 때의 중단처리를 했었는데 
		자꾸 틀렸던 이유가 연산을 하다가 몫이 0이 나온 경우에 멈춰주지 않아서 그랬던 듯 하다.
		
	@Date
		2021. 12. 13.
 */

public class _7_11005 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
		StringTokenizer	raw			= new StringTokenizer(br.readLine());
		StringBuilder	remainders	= new StringBuilder();
		
		int		dividend	= Integer.parseInt(raw.nextToken()),
				divisor		= Integer.parseInt(raw.nextToken());
		//		,quotient	= dividend/divisor;
		char[] remainder = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		//처음에 알파벳만 나열했었는데 36진수이니까 나머지가 35까지 나올 수 있으므로 그걸 이용해서 0~9도 여기에 넣음 된다.
		//char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		while( true ){
			//quotient = dividend/divisor;
			if(dividend==0){
				break;
			}
			
			//int remainder = dividend%divisor;
			//remainders.append(remainder>=10 ? alphabet[remainder-10]+"" : remainder);
			remainders.append(remainder[dividend%divisor]);
			dividend/=divisor;
		}
		
		System.out.print(remainders.reverse());
		
		br.close();
	}
}
