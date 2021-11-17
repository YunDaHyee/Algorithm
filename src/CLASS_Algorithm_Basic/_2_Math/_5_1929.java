/**
 * 
 */
package _2_Math;

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
		에라토스테네스의 체로 풀었는데
		처음의 반복문의 범위를 min<=max로 했었는데
		이렇게 하니까 4를 검증해내지 못하는 치명적인 단점이 있었다.
		그래서 생각해보니 원래 소수이려면 2<=max로 해줌.
		그래서 출력할 때 min부터 출력하도록 하게끔 했는데 맞왜틀이었다..
		한 30분 고민했나? 안되겠어서 다른 사람 꺼 봤는데
		nonPrimeFlags이 관건이었나보다.
		0과 1은 소수가 아닌 거로 초기화 해주는 게 중요했다.
		그걸 고쳐주니 됐다.
		휴 하루종일 이것만 풀었네ㅠ
		-20211117- 
 */

public class _5_1929 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw			= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		String[] numbers = br.readLine().split(" ");
		int min = Integer.parseInt(numbers[0]), max = Integer.parseInt(numbers[1]);
		boolean[] nonPrimeFlags = new boolean[max+1];
		
		nonPrimeFlags[0] = nonPrimeFlags[1] = true;
		
		for( int i=2;i<=max;i++ ){
			if( !nonPrimeFlags[i] ){
				for( int j=i*2;j<=max;j+=i ){
					nonPrimeFlags[j] = true;					
				}
			}
		}
		
		for( int i=min;i<=max;i++ ){
			if( !nonPrimeFlags[i] ){
				bw.write(i+"\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
