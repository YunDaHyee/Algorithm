/**
 * 
 */
package _3_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 	@Question
 		정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다.
 		합을 나타낼 때는 수를 1개 이상 사용해야 한다.
		1+1+1+1
		1+1+2
		1+2+1
		2+1+1
		2+2
		1+3
		3+1
		정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 테스트 케이스의 개수 T가 주어진다.
		각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. 
		n은 양수이며 11보다 작다.
		3
		4
		7
		10
	@Output
		각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.
		7
		44
		274
	@history
		D[N]	= 정수 N을 1,2,3의 합으로 나타내는 방법의 수
				= D[N-1] + D[N-2] + D[N-3]
		
		- 예외
		N=0 => 1
		0은 1,2,3을 조합하지 않아도 그 자체로 완성이므로 방법의 수는 0이지만 이것 또한 개수이므로 1임.
		집합에서 공집합의 경우에는 크기가 0인데 이것도 집합이 있다고 해서 공집합이라고 하는거니까
		그것처럼 문자열도 크기가 0인 문자열, 빈 문자열도도 문자열 하나라고 함.
		
		N=1 => 1
		1 자체가 1,2,3의 합으로 나타낸느 방법 수 중의 하나이므로 1
		
		자꾸 9가 나오는데..
		예외처리를 n<2일 떄 모두 1로 반환하게끔 했는데 1 자체는 어쨌든 조합의 수 중 하나니까 예외처리를 0일 떄만 처리 해야한다.
		그리고 양수가 나올 때만 합산하도록 한다.
		
		문제를 잘못 이해했다..
		1 입력에 1 출력인 줄 알고 풀었는데
		테스트 케이스 개수 받고 그 수만큼 D[N]을 구하는 것이었다.
		문제를 잘 읽고 이해하는 것도 중요하다.
		
		- Top-Down
			
		- Bottom-Up
			1. 11까지 다 구하고 해당 테케 수 만큼 출력되게 하는 방법
			2. 입력마다 매번 배열을 초기화하고 새롭게 값들을 리턴해주는 방법
			
			만약엔 인풋의 숫자 범위가 커지면..?
			불필요하게 많이 돌게 되는 게 아닌가 싶어서 2번 방법으로 풀었다.
		
	@Date
		2022. 3. 31.
 */

public class _4_9095_v2 {
	static int[] memo;
	//static int[] memo = new int[11];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for( int i=0;i<t;i++ ){
			//result.append( TopDown(Integer.parseInt(br.readLine()))+"\n" );
			result.append( BottomUp(Integer.parseInt(br.readLine()))+"\n" );
		}
		System.out.println( result.toString() );
		br.close();
	}
	
	private static int TopDown(int n) {
		if( n==0 ){
			return 1;
		}
		
		if( memo[n]>0 ){
			return memo[n];
		}
		
		// n이 양수일 때만 처리되도록 하기 위함
		if( n-1>=0 ){
			memo[n] += TopDown(n-1);
		}
		if( n-2>=0 ){ 
			memo[n] += TopDown(n-2);
		}
		if( n-3>=0 ){
			memo[n] += TopDown(n-3);
		}
		
		return memo[n];
	}
	
	private static int BottomUp(int n) {
		memo = new int[11];
		memo[0] = 1;
		
		for( int i=1;i<=n;i++ ){
			for( int j=1;j<=3;j++ ){
				if( i-j>=0 ){
					memo[i] += memo[i-j];
				}
			}
		}
		return memo[n];
	}


}
