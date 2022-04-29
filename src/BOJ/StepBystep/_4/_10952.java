/**
 * 
 */
package StepBystep._4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다.
각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
입력의 마지막에는 0 두 개가 들어온다.
1 1
2 3
3 4
9 8
5 2
0 0

출력
각 테스트 케이스마다 A+B를 출력한다.
2
5
7
17
7
 */
public class _10952 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		StringTokenizer num = new StringTokenizer( br.readLine() );
		
//		while( !num[0].equals("0") && !num[1].equals("0") ){
		while( !num.nextToken().equals("0") && !num.nextToken().equals("0") ){
			int sum = Integer.parseInt(num.nextToken()) + Integer.parseInt(num.nextToken());
			bw.write( Integer.toString(sum)+"\n" );
			bw.flush();
			//num = br.readLine().split("\\s");
			num = new StringTokenizer( br.readLine() );
		}
		
		br.close();
		bw.close();
	}
}
