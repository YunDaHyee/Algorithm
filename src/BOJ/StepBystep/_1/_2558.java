/**
 * 
 */
package _1;

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
		1
		2
	@Output
		첫째 줄에 A+B를 출력한다.
		3
	@history
 *		
 */
public class _2558 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br	= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw	= new BufferedWriter( new OutputStreamWriter(System.out) );
		int				cnt	= 0;
		int				sum	= 0;
		
		while( cnt++<2 ) {
			sum += Integer.parseInt(br.readLine());
		};
		
		bw.write( String.valueOf(sum) );
		
		bw.flush();
		br.close();
		bw.close();
	}
}
