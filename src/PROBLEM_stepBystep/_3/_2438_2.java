package _3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
	@Question
		첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
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
		이중 for문으로 할 수 있었는데 그렇게 하는 것 말고
		while이 빠르니까 다른 방법이 있나 싶어서 고안해낸 방법..
		당연 이중 for문으로 짜면 금방 짰지~~~~~~~~~~~~~~~~~~~~~~~~~!ㅡㅡ
		타 코드들은 다 거의 이중 for문으로 짜서 딱히 리뷰할 게 없다ㅠ..
 *
 */
public class _2438_2 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int size	= Integer.parseInt( br.readLine() );
		int cnt		= size+1;
		
		// 1. while문
		while( --cnt>0 ){
			for( int i=size;i>=cnt;i-- ){
				bw.write("*");
			}
			bw.newLine();
		}
		
		// 2. 이중 for문
		for( int i=0;i<size;i++ ){
			for( int j=0;j<=i;j++ ){
				bw.write("*");
			}
			bw.newLine();
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
