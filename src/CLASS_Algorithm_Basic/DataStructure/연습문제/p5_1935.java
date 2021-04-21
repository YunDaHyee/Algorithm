package DataStructure.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**

@문제
	후위 표기식과 각 피연산자에 대응하는 값들이 주어져 있을 때, 그 식을 계산하는 프로그램을 작성하시오.
	
@입력
	첫째 줄에 피연산자의 개수(1 ≤ N ≤ 26) 가 주어진다.
	그리고 둘째 줄에는 후위 표기식이 주어진다.
	(여기서 피연산자는 A~Z의 영대문자이며, A부터 순서대로 N개의 영대문자만이 사용되며, 길이는 100을 넘지 않는다)
	그리고 셋째 줄부터 N+2번째 줄까지는 각 피연산자에 대응하는 값이 주어진다.
	(3번째 줄에는 A에 해당하는 값, 4번째 줄에는 B에 해당하는값 , 5번째 줄에는 C ...이 주어진다, 그리고 피연산자에 대응 하는 값은 정수이다)
	1.
		5
		ABC*+DE/-
		1
		2
		3
		4
		5
	
	2.
		1
		AA+A+
		1

@출력
	계산 결과를 소숫점 둘째 자리까지 출력한다.
	6.20
	3.00
	
@HISTORY
	
 */	
public class p5_1935 {
	public static void main(String args[]) throws IOException {
		BufferedReader 	br	= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw	= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int				cnt = Integer.parseInt( br.readLine() );
		String			str = br.readLine();
		Stack<Integer>	stk = new Stack<Integer>();
		
		while( cnt-->0 ){
			int	idx			= Integer.parseInt( br.readLine() )-1; // 입력받은 숫자가 문자열에서의 인덱스가 된다
			char curValue	= str.charAt(idx);
			int returnValue	= 0;
			
			switch( curValue ){
				case '*' :
					returnValue = stk.pop() * stk.pop();
					break;
				case '+' :
					returnValue = stk.pop() + stk.pop();
					break;
				case '/' :
					returnValue = stk.pop() / stk.pop();
					break;
				case '-' :
					returnValue = stk.pop() - stk.pop();
					break;
				default :
					returnValue =  curValue;
					break;
			}
			
			stk.push( returnValue );
		}
		
		bw.write( String.valueOf(Math.round(stk.pop()*100)/100.0) );
		
		br.close();
		bw.flush();
		bw.close();
	}
}





















































