package DataStructure.연습문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/**
@문제
	문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.
	
	먼저, 문자열 S는 아래와과 같은 규칙을 지킨다.
	
	알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
	문자열의 시작과 끝은 공백이 아니다.
	'<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다.
	또, 두 문자의 개수는 같다.
	태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다.
	단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다.
	태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.
	
@입력
	첫째 줄에 문자열 S가 주어진다. S의 길이는 100,000 이하이다.
	baekjoon online judge
	<open>tag<close>
	<int><max>2147483647<long long><max>9223372036854775807
	<   space   >space space space<    spa   c e>
	
@출력
	첫째 줄에 문자열 S의 단어를 뒤집어서 출력한다.
	noojkeab enilno egduj
	<open>gat<close>
	<int><max>7463847412<long long><max>7085774586302733229
	<   space   >ecaps ecaps ecaps<    spa   c e>
	
@HISTORY
	각 단어의 순서만 뒤집는 것임..
*/
public class p1_17413_v2 {
	public static void main(String args[]) throws IOException {
		BufferedReader br	= new BufferedReader( new InputStreamReader(System.in) );
		
		String[] st = br.readLine().split("{1}");
		
		Stack<String>	stack	= new Stack<String>();
		StringBuilder	sb  	= new StringBuilder();
		boolean 		flag	= false;
		
		for( int i=0;i<st.length;i++ ){
			String str = st[i];
			if( str.equals("<") ){
				while( !stack.isEmpty() ){
					sb.append(stack.pop());
				}
				sb.append(str);
				flag = true;
				continue;
			}else if( str.equals(">") ){
				sb.append(str);
				flag = false;
				continue;
			}
			
			if( flag ){
				sb.append(str);
			}else{
				stack.push(str);
			}
		}
		
		while( !stack.isEmpty() ){
			sb.append(stack.pop());
		}
		
		System.out.println( sb );
		
		br.close();
	}
}
