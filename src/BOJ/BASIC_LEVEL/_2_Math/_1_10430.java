/**
 * 
 */
package Basic_Level._2_Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
	@문제
		(A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
		(A×B)%C는 ((A%C) × (B%C))%C 와 같을까?
		세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
	@입력
		첫째 줄에 A, B, C가 순서대로 주어진다. (2 ≤ A, B, C ≤ 10000)
		5 8 4
		
	@출력
		첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
		1
		1
		0
		0
	@HISTORY
	 	나머지 연산일 경우, 아래의 식이 성립한다 
	 	(A+B)%C == ( (A%C) + (B%C) )%C
	 	(A*B)%C == ( (A%C) * (B%C) )%C
	 	즉, 나머지 연산은 덧셈,뺄셈,곱셈의 경우에만 성립한다.
	 	따라서, 같을까?에 대한 물음의 답 : 같다
	 	
	 	cf)
	 	- 나누기 연산일 경우, 성립하지 않는다.(역연산 해아함)
	 	- 뺼셈의 경우, 먼저 나머지 연산을 한 결과가 음수가 나올 수 있으므로 아래의 식으로 해야함
	 	(A-B)%C == ( (A%C)-(B%C) + C) )% C
	 	
 */

public class _1_10430 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw			= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		String[] raws = br.readLine().split(" ");
		
		int A = Integer.parseInt(raws[0]), B = Integer.parseInt(raws[1]), C = Integer.parseInt(raws[2]);
		bw.write((A+B)%C+"\n"+((A%C)+(B%C))%C+"\n"+(A*B)%C+"\n"+((A%C)*(B%C))%C);
		
		bw.flush();
		bw.close();
		br.close();
	}
}
