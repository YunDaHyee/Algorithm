package _3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
	@Question
		첫째 줄에는 별 N개, 둘째 줄에는 별 N-1개, ..., N번째 줄에는 별 1개를 찍는 문제
		하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
	@Input
		첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
		5
	@Output
		첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
		*****
		 ****
		  ***
		   **
		    *
	@history
		
 *
 */
public class _2441_2 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int size = Integer.parseInt( br.readLine() );
		int cnt = size+1;
		
		while ( --cnt>0 ){
			for( int i=cnt;i<size;i++ ){
				bw.write(" ");
			}
			for( int j=0;j<cnt;j++ ){
				bw.write("*");
			}
			bw.newLine();
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
