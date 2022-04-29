package StepBystep._3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
	@Question
		자연수 N이 주어졌을 때, N부터 1까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 100,000보다 작거나 같은 자연수 N이 주어진다.
		5
	@Output
		첫째 줄부터 N번째 줄 까지 차례대로 출력한다.
		5
		4
		3
		2
		1
	@history
		2741에서 역으로 출력하면 되는 것. 이것도 역시 어려움 없었다.
		
		- 타 코드 Review
		빠르고 짧은 타 코드를 찾다가 while문을 이용한 코드가 있었는데
		for문의 성능 비교에 대해서 공부한 적이 있는데 while문이 성능이 젤 좋았던 게 떠올랐다.
		그게 생각이 나서 적용해봄 
		근데 백준 채점 결과로 봤을 땐 뭐 비슷한 것 같다,,
		이거로는 뭔가 체감이 안되지만 아무튼 내가 봤던 코드는 그럼..
		
 *
 */
public class _2742_2 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		/* 내 코드
		int cnt = Integer.parseInt( br.readLine() );
		for( int i=cnt;i>0;i--){
			bw.write( i+"\n");
		}
		*/
		/* 타 코드 적용 */
		int cnt = Integer.parseInt( br.readLine() )+1;
		while(--cnt>0){
			bw.write( cnt+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
