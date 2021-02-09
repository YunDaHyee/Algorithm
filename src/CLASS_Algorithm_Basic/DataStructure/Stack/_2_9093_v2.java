/**
 * 
 */
package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;

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
 */
public class _2_9093_v2 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br		= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw		= new BufferedWriter( new OutputStreamWriter(System.out) );
		Stack<Character>stack	= new Stack<Character>();
		int				testCase= Integer.parseInt( br.readLine() );
		StringTokenizer st		= null;
		
		for( int i=0;i<testCase;i++ ) {
			st = new StringTokenizer(br.readLine());
			while( st.hasMoreTokens() ) {
				for( int )
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
