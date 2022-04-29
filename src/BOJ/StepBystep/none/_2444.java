/**
 * 
 */
package none;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

입력
첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
5

출력
첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
 *
 */
public class _2444 {
	public static void main(String args[]) throws IOException  {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		br.close();
		bw.flush();
		bw.close();
	}
}
