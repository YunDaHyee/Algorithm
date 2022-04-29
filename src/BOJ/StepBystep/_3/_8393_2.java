package _3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
	@Question
		n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.
		3
	@Output
		1부터 n까지 합을 출력한다.
		6		
	@history
		간단,,
 *
 */
public class _8393_2 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int fac = Integer.parseInt( br.readLine() );
		int sum = 0;
		for( int i=1;i<=fac;i++ ){
			sum += i;
		}
		bw.write(Integer.toString(sum));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
