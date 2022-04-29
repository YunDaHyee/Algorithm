/**
 * 
 */
package Basic_Level._2_Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
	@문제
		M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
	@입력
		첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000)
		M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
		3 16
	@출력
		한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
		3
		5
		7
		11
		13
	@HISTORY
		에르토스테네스의 체로 풀었는데 시간이 넘 오래 걸림..
		뭐가 문제일까 고민해보다가
		문득 매번 System.out.println을 호출해서 바로 출력하는 게 오래 걸리는 것의 원인일까 하고
		StringBuilder로 담아서 출력해주는 것으로 고쳤더니
		시간이 확 줄었다.
		호출스택에 System.out.println() 부르는 게 큰 비용이 드나보다.
		
		
	@Date
		2022. 4. 21.
 */

public class _5_1929_v2 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br		= new BufferedReader( new InputStreamReader(System.in) );
		String[]		primes	= br.readLine().split(" ");
		int min = Integer.parseInt(primes[0]), max = Integer.parseInt(primes[1]);
		StringBuilder	result	= new StringBuilder();
		boolean[]		check	= new boolean[max+1];
		//int[] result = new int[max+1];
		//int primeCount = 0;
		
		check[0] = check[1] = true;
		
		for( int i=2;i<=max;i++ ) {
			if( !check[i] ) {
				//result[primeCount++] = i;
				for( int j=i*2;j<=max;j+=i ) {
					check[j] = true;
				}
			}
		}
		
		for( int i=min;i<=max;i++ ) {
			if( !check[i] ) {
				result.append(i);
                result.append("\n");
			}
		}
		
        System.out.println( result.toString() );
		
		br.close();
	}
}
