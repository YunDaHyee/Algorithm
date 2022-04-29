/**
 * 
 */
package _3_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 	@Question
 		2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
		아래 그림은 2×17 직사각형을 채운 한가지 예이다.
	@Input
		첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
		1.2
		2.8
		3.12
	@Output
		첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
		1.3
		2.171
		2.2731
	@history
		2*(n-1),2*(n-2),2*2(n-1)
		라고 생각했었는데
		2*2는 2*1를 두개 놓는 꼴이니까 결국 이것도 n-2인 것과 같다.
		
		- Top-down 방식(재귀)
		- Bottom-up 방식(반복문)
			
	@Date
		2022. 1. 11.
 */

public class _3_11727 {
	static int[] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//System.out.println(go(Integer.parseInt(br.readLine()))); // 재귀
		
		int N = Integer.parseInt(br.readLine());
		
		memo = new int[1001];
		memo[0] = memo[1] = 1; // 0이나 1일 경우에 -1이나 0이 되므로 값은 1로 설정해줌.
		
		for( int i=2;i<=N;i++ ){
			memo[i] = (memo[i-1]+2*memo[i-2])%10007;
		}
		
		System.out.println(memo[N]);
		br.close();
	}
	
	public static int go(int N) {
		if( N==0||N==1 ) return 1;
		if( memo[N]>0 ) return memo[N];
		memo[N] = (go(N-1)+2*(go(N-2)))%10007;
		return memo[N];
	}


}
