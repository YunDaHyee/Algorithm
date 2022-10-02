/**
 * 
 */
package Basic_Level._3_DynamicProgramming;

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
		D[N]	= 1×2, 2×1과 2×2 타일로 채우는 방법의 수
				= D[1*2] + D[2*1] + D[2*2]
				= 2*D[N-1] + D[N-2] (XXX)
				= D[N-1] + 2*D[N-2] (OOO)
				
		2*2를 하나짜리로 쳐서 1개의 타일이라고 생각했는데 크기 2가 빠지니까 n-2이다.
		(2*1를 2개 놓는 꼴이니까 n-2과 같은 게 아닐까 추측..)
				
		
		- 예외
			n = 1 -> 2*1
			2*1 - 1가지
			=> 총 1가지.
				(2*1에다가 1*2와 2*2를 넣기에는 세로가 짤려서 못 넣음)
				
		- Top-down
			
		- Bottom-up
		
		10007을 안나눠줘도 값은 같은데 혹시 모를 큰 값에 대비해서 나눠주는 것일까..?
		
	@Date
		2022. 3. 31.
 */

public class _3_11727_v2 {
	static int[] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		memo = new int[10001];
		int n = Integer.parseInt(br.readLine());
		System.out.println( TopDown(n));
		System.out.println( BottomUp(n));
		
		br.close();
	}
	private static int TopDown(int n) {
		if( n<=1 ){
			return 1;
		}
		
		if( memo[n]>0 ){
			return memo[n]; 
		}
		
		memo[n] = ( TopDown(n-1) + 2*TopDown(n-2) )%10007;
		
		return memo[n];
	}
	
	private static int BottomUp(int n) {
		memo[0] = memo[1] = 1;
		
		for( int i=2;i<=n;i++ ){
			memo[i] = ( memo[i-1] + 2*memo[i-2] )%10007;
		}
		
		return memo[n];
	}


}
