/**
 * 
 */
package BASIC_LEVEL._2_Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
	@문제
		두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
	@입력
		첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
		24 18
	@출력
		첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
		6
		72
	@HISTORY
 */

public class _2_2609 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw			= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		String[] raws = br.readLine().split(" ");
		
		int originalA = Integer.parseInt(raws[0]);
		int originalB = Integer.parseInt(raws[1]);
		
		int A = originalA;
		int B = originalB;
		
		while( B!=0 ){
			int r = A%B;
			A = B;
			B = r;
		}
		
		int GCD = A;
		int LCM = GCD * originalA/GCD * originalB/GCD;
		
		bw.write(GCD+"\n"+LCM);
		
		bw.flush();
		bw.close();
		br.close();
	}
}
