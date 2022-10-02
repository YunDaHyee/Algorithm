/**
 * 
 */
package BASIC_LEVEL._3_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 	@Question
 		2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
		아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.
	@Input
		첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
		1.2
		2.9
	@Output
		첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
		1.2
		2.55
	@history
		D[N] = 2n크기 정사각형을 1*2, 2*1 타일로 채우는 방법의 수
		사각형이 올 수 있는 가지 수 :
			1. 끝에 1*2 타일 1개 짜리로 채우는 방법 - D[N-1]
			2. 끝에 2*1 타일 2개 짜리로 채우는 방법 - D[N-2]
		따라서, D[N] = D[N-1]+D[N-2]+1
		D[N-1] = 2(n-1)크기 정사각형을 1*2, 2*1 타일로 채우는 방법의 수
		D[N-2] = 2(n-2)크기 정사각형을 1*2, 2*1 타일로 채우는 방법의 수
		
		
		예외 - 	n이 1일 떄는 N이 1이면 2x1 타일을 놓는 방법은 하나 세워두는 것 밖에 없어서 가지수가 1
		D[1] = 2*1크기 정사각형을 1*2, 2*1 타일로 채우는 방법의 수 = 그 자체이므로 1 반환
		2n-2
		2n-4
		
		- Top-down 방식(재귀)
			
		- Bottom-up 방식(반복문)
			
	@Date1
		2022. 3. 27.
 */

public class _2_11726_v2 {
	static int[] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		memo = new int[10001];
		int N = Integer.parseInt(br.readLine());
		//System.out.println( TopDown(N) );
		System.out.println( BottomUp(N) );
		br.close();
	}
	
	public static int TopDown(int N) {
		if( N<2 ){
			return 1;
		}
		
		if( memo[N]>0 ){
			return memo[N];
		}
		
		memo[N] = (TopDown(N-1)+TopDown(N-2))%10007;
		
		return memo[N];
	}

	public static int BottomUp(int N){
		memo[0] = memo[1] = 1;
		
		for( int i=2;i<=N;i++ ){
			memo[i] = (memo[i-1]+memo[i-2])%10007;
		}
		
		return memo[N];
	}

}
