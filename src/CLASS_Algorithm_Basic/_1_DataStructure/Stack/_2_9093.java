/**
 * 
 */
package _1_DataStructure.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

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
		남들 코드 본 뒤 수정한 점 :
		1. foreach문 활용 - String을 toCharArray로,
		2. clean code
			- 굳이 st가 공백인지 개행문자인지 구분해서 출력해줄 필요없이 어차피 그 자체는 그 자체들을 출력해줌 되니까
			- Cast를 char로 해줬더니 참조형타입 어쩌구 하면서 안돼서 안되는 줄 알았는데 안되는 게 아니라 역시 내가 모르는 거였따..ㅠ Character를 쓰면 됐음..
			  그래서 안되는 줄 알고 String으로 받아서 valueOf까지 일일이 해줬는데
		-> 이 두가지만 했더니 코드가 훠얼~씬 깔끔해지고 메모리도 반이나 줄어듦,,
 */
public class _2_9093 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br		= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw		= new BufferedWriter( new OutputStreamWriter(System.out) );
		Stack<Character>stack	= new Stack<Character>();
		int				testCase= Integer.parseInt( br.readLine() );
		
		while( testCase-->0 ) {
			String rawSt = br.readLine()+'\n';
			for( char st : rawSt.toCharArray() ) {
				if( st==' ' || st=='\n' ) {
					while( !stack.isEmpty() ){
						bw.write( stack.pop() );
					}
					
					bw.write(st);
					bw.flush();
					
				}else{
					stack.push( st );
				}
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
