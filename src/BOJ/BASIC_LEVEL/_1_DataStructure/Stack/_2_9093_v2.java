/**
 * 
 */
package Basic_Level._1_DataStructure.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
		eW tnaw ot niw eht tsrif ezirp
		
	@HISTORY
		n^3이 나오니까 3중 반복문을 피하려고 반복문을 몇개나 돌린건지..
		하지만 단어 자체를 뒤집으려면 3중 반복문을 피할 순 없다..ㅠㅠ.. 
		첫 번째 시도 :
		아 근데 너무 오래 걸려서 수정을 함..;;;
		StringTokenizer로 분리한 단어들을 다시 문자열 배열에 넣는 건 효율에 어긋나는 것 같아서 지웠다.
		1년 전 풀이를 참고하려고 봤더니 거기선 입력을 받아서 그 자체에서 공백이나 EOF를 처리 했었다.
		그 작업은 StringTokenizer를 이용하면 따로 필요 없을 것 않아서 자체 처리를 생략했었는데
		역시나 훨씬 깔끔해지고 메모리나 시간도 1/3이나 줄어들었다.
		
		
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
			Stack<Character>	stack	= new Stack<Character>();
			
			while( st.hasMoreTokens() ){
				for( char c : st.nextToken().toCharArray() ) {
					stack.push( c ); // 각 단어 뒤집기
				}
				while( !stack.isEmpty() ){
					bw.write( stack.pop() );
				} // today -> happy -> am -> i
				bw.write( ' ' );
			}
			bw.write( '\n' );
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
