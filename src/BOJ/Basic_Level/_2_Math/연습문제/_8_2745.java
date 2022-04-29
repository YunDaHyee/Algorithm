/**
 * 
 */
package _2_Math.연습문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
	@문제
		B진수 -> 10진수
		B진법 수 N이 주어진다.
		이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.
		10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다.
		이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
		A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
	@입력
		첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36)
		B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.
		ZZZZZ 36
	@출력
		첫째 줄에 B진법 수 N을 10진법으로 출력한다.
		60466175
	@HISTORY
		나는 뭔가 1차원적으로 HashMap을 이용해 풀었는데 (성능 괜춘)
		아스키코드로 풀어야할 것 같아서 다시 품
		
		숫자 0~9	: 48~57
		대문자		: 65~90
		소문자		: 97~122
		제일 큰 수에서 x 뺐을 때 10진수의 값이 나오게 하는거니까
		각각 55,48을 빼줌.
		2/8/16진법에서 10진법으로 바뀌는 계산법만 기억하기.
		아 그리고 자료형 주의
		int 자료형은 10억까지 받지 못하므로 long으로 처리
	@Date
		2021. 12. 13.
 */

public class _8_2745 {
	public static void main(String args[]) throws IOException {
		BufferedReader			br			= new BufferedReader( new InputStreamReader(System.in) );
		StringTokenizer			raw			= new StringTokenizer(br.readLine());
		char[]                  numbers     = raw.nextToken().toCharArray();
		int	                    notation    = Integer.parseInt(raw.nextToken());
		long	                sum		    = 0;
		
		/*
		Map<Character,Integer>	remainder	= new HashMap<Character,Integer>();
		int		                power	    = numbers.length-1,
				alphabetNumber= 10;
				
		for( char i='A';i<='Z';i++){
			remainder.put(i, alphabetNumber++);
		}
		
		for( char rawNumber : numbers ){
			int transNumber = 0;
			if( remainder.containsKey(rawNumber) ){
				transNumber = remainder.get(rawNumber);
			}else{
				transNumber = Integer.parseInt(rawNumber+"");
			}
			sum += transNumber*Math.pow(notation,power--);
		}
		*/
		
		for( int power=numbers.length-1,index=0;power>=0;power--,index++){
			char rawNumber = numbers[index];
			if( rawNumber>=65 ){
				sum += (rawNumber-55)*Math.pow(notation,power); // 젤 큰 수를 뺐을 때 35가 나와야 돼서 -55 해줌
				continue;
			}
			sum += (rawNumber-48)*Math.pow(notation,power); // 젤 큰 수를 뺐을 때 9가 나와야 돼서 -48 해줌
		}
		
		System.out.println(sum);
		
		br.close();
	}
}
