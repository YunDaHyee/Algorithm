/**
 * 
 */
package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.PortUnreachableException;
import java.util.Stack;
import java.util.StringTokenizer;

/**
	@문제
		단어 뒤집기
		문장이 주어졌을 때, 단어를 모두 뒤집어서 출력하는 프로그램을 작성하시오.
		단, 단어의 순서는 바꿀 수 없다.
		단어는 영어 알파벳으로만 이루어져 있다.
		
	@입력
		첫째 줄에 테스트 케이스의 개수 T가 주어진다.
		각 테스트 케이스는 한 줄로 이루어져 있으며, 문장이 하나 주어진다.
		단어의 길이는 최대 20, 문장의 길이는 최대 1000이다.
		단어와 단어 사이에는 공백이 하나 있다.
		2
		I am happy today
		We want to win the first prize
	@출력
		각 테스트 케이스에 대해서, 입력으로 주어진 문장의 단어를 모두 뒤집어 출력한다.
		I ma yppah yadot
		eW tnaw ot niw eht tsrif ezirpv
		
	@HISTORY
		n^3이 나오니까 3중 반복문을 피하고 싶었는데 어쩔 수가 없다..
 */
public class _2_9093_v2 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br		= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw		= new BufferedWriter( new OutputStreamWriter(System.out) );
		int				testCase= Integer.parseInt( br.readLine() );
		StringTokenizer st		= null;
		
		// 1. 문자열로 구현 - Stack을 선언해놓고 안씀;;
		/*
		StringBuilder 	sb		= new StringBuilder();
		
		while( testCase-->0 ) {
			st = new StringTokenizer(br.readLine());
			while( st.hasMoreTokens() ){
				String[] eachStr = st.nextToken().split("{1}");
				for( int i=eachStr.length-1;i>=0;i-- ){
					sb.append( eachStr[i] );
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		
		bw.write( sb.toString() );
		*/
		// 2. Stack으로 구현
		while( testCase-->0 ){
			st = new StringTokenizer(br.readLine()); // i, am, happy, today
			Stack<String>	stack	= new Stack<String>();
			Stack<String>	stack2	= new Stack<String>();
			
			String[] str = new String[st.countTokens()];
			for( int i=0;i<str.length;i++ ){
				str[i] = st.nextToken(); // i -> am -> happy -> today
				stack.push( str[str.length-1-i] );
			} // today -> happy -> am i
			
			
			
			while( stack.isEmpty() ){
				bw.write( stack.pop() );
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
