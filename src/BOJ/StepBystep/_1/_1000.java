/**
 * 
 */
package StepBystep._1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
	@Question
		두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)
		1 2
	@Output
		첫째 줄에 A+B를 출력한다.
		3
	@history
		2년 전에는 Scanner로 풀었던데 이것도 역시 입출력이 많지 않으니 Scanner로 해도 될 것 같긴 하다.
 *		
 */
public class _1000 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		bw.write( String.valueOf(sum) );
		
		bw.flush();
		br.close();
		bw.close();
	}
}
