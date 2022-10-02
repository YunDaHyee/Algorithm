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
		0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
	@입력
		첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.
		10
		0
	@출력
		첫째 줄에 N!을 출력한다.
		3628800
		1
	@HISTORY
	
	@Date
		2021. 11. 23. 
 */

public class _7_10872 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw			= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int number = Integer.parseInt(br.readLine());
		int mutiple = 1;
		
		for(int i=2;i<=number;i++){
			mutiple*=i;
		}
		
		bw.write(String.valueOf(mutiple));
		bw.flush();
		bw.close();
		br.close();
	}
}
