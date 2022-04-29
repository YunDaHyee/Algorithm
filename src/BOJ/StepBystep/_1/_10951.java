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
		입력은 여러 개의 테스트 케이스로 이루어져 있다.
		각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
		1 1
		2 3
		3 4
		9 8
		5 2
	@Output
		각 테스트 케이스마다 A+B를 출력한다.
		2
		5
		7
		17
		7
	@history
		1년 전에는 문자열로 받은 뒤에 split으로 잘라서 쓰는 걸로 했고 시간초가 훨씬 적게 걸렸던데
		왜 똑같은 소스로 했는데도 지금은 더 걸리는거지..?
		자바 버전 8->11 인 차이밖에 없는데 그 차이가 큰가,,
 *		
 */
public class _10951 {
	public static void main(String[] args) throws IOException {
		BufferedReader	br	= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw	= new BufferedWriter( new OutputStreamWriter(System.out) );
		StringTokenizer st	= null;
		String			raw = "";
		
		while( (raw = br.readLine())!=null ){
			st = new StringTokenizer(raw);
			int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
			bw.write( String.valueOf(sum)+"\n" );
		}
		
		bw.flush();
		br.close();
		bw.close();
	}

}
