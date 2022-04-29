package StepBystep._3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
	@Question
		첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
		하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
	@Input
		첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
		5
	@Output
		첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
		    *
		   **
		  ***
		 ****
		*****
	@history
		while문으로 하면 좀 빠르대서 while문으로 하는 연습을 하고 있는데
		아직도 조금은 어색하고 잘 안되는 느낌..
		그리고 복잡한 그건 아녀서 그런지 성능이 크게는 차이 안남 ..
		하지만 for문은 쉽게 잘 하니까 while문으로도 해보는 연습하기!
 *
 */
public class _2439_2 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int size = Integer.parseInt( br.readLine() ); // 총 사이즈
		int cnt	 = -1;
		
		while( ++cnt<size ){
			for( int i=cnt;i<size-1;i++ ){ // 띄어쓰기 반복문 : 첫 행의 마지막은 별이기 때문에 size-1 해줌
				bw.write(" ");
			}
			for( int j=0;j<=cnt;j++ ){ // 별 반복문 : 별의 갯수 == cnt 수
				bw.write("*");
			}
			bw.newLine();
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
