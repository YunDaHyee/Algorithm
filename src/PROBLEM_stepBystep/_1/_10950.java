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
		두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 테스트 케이스의 개수 T가 주어진다.
		각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
		5
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
		
 *		
 */
public class _10950 {
	public static void main(String[] args) throws IOException {
		BufferedReader	br	= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw	= new BufferedWriter( new OutputStreamWriter(System.out) );
		StringTokenizer st	= null;
		int[]			sum;
		int				cnt	= 0;
		int				i	= -1; // -1인 건 증감연산자를 통해 진행되므로 배열인덱스로 사용하기 위해서
		
		cnt = Integer.parseInt( br.readLine() );
		sum = new int[cnt];
		
		while( ++i<cnt ) {
			st = new StringTokenizer(br.readLine());
			sum[i] = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		};
		
		
		for( int j:sum ) {
			bw.write( String.valueOf(sum[j]) );
		}
		
		bw.flush();
		br.close();
		bw.close();
	}

}
