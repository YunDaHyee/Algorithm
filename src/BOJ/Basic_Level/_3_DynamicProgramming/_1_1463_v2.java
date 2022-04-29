/**
 * 
 */
package _3_DynamicProgramming;

import java.awt.event.TextEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 	@Question
		정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
		
		X가 3으로 나누어 떨어지면, 3으로 나눈다.
		X가 2로 나누어 떨어지면, 2로 나눈다.
		1을 뺀다.
		
		정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
		연산을 사용하는 횟수의 최솟값을 출력하시오.
	@Input
		첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
		1.2
		2.10
	@Output
		첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
		1.1
		2.3
	@history
		- 문제 그대로 나열
			X가 3으로 나눠 떨어지는 경우, X/3
			X가 2로 나눠 떨어지는 경우, X/2
			다 안되면 -1
		
			N을 1로 만든다 == 작게 만든다 == 작게 만들려면 3으로 나눠야 빨리 작게 만들 수 있음. ==> 작게 만드는 것은 최소값을 찾는다는 것
			3으로 나누다가 안되면 2로 나누고 안되면 1 빼기
		
		- 문제 구분
			큰 문제(메인 문제)	: D[N]	= N을 1로 만드는 최소 연산 횟수
			작 문제 1			:	1. N을 N/3으로 만듦 = D[N]/3 = N/3을 1로 만드는 최소 연산 횟수 => D[N/3]=(N/3)/3을 1로 만드는 횟수. 
									2. N/3을 1로 만듦
			작 문제 2			: D[N/2]= N/2을
									1.N을 N/2로 만듦
									2. N/2를 1로
			작 문제 3			: D[N-1]= N-1을
									1.N을 N-1로 만듦
									1.N-1을 1로 만듦
		
		- 점화식 정의
			D[N] = min(D[N/3],D[N/2],D[N-1])+1
			1을 1로 만드는 경우가 1가지가 있으므로(D[1]=0) +1이 되는 것.
			시복잡 : N개*O(1)(이유 - 단순히 3개의 최소값을 구하고 있음)
		
		- 초기화
			1을 1로 만드는 경우는 연산을 사용하지 않아도 정답 구할 수 있으므로 0번만에 답을 만드는 것
			따라서 d[1] = 0
		
		- 풀이방법
			- Top-down 방식(재귀)
				n-1 -> x/2 -> x/3 순으로 아무것도 아닌 상황의 비교를 먼저 해줌으로써
				최소값을 구하는 데에 비교군을 좁혀 나가는 느낌
				
			- Bottom-up 방식(반복문)
				1을 제외하고 가장 작은 수인 2~N까지 증가해나가면서 차례대로 처리한다.
				
				함수 호출횟수 * 문제 푸는 데에 걸리는 시간 
		
	@Date
		2022. 03. 20.
 */

public class _1_1463_v2 {
	public static int[] memo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo = new int[N+1];
		System.out.println( TopDown(N) );
		System.out.println( BottomUp(N) );
		br.close();
	}

	public static int TopDown(int X) {
		if( X==1 ){
			return 0;
		}
		if( memo[X]>0 ){
			return memo[X]; 
		}
		
		memo[X]		= TopDown(X-1)+1;
		
		int temp	= 0;
		
		if( X%2==0 ){
			temp = TopDown(X/2)+1;
			if( memo[X] > temp ){
				memo[X] = temp;
			}
		}
		 
		if( X%3==0 ){
			temp = TopDown(X/3)+1;
			if( memo[X] > temp ){
				memo[X] = temp;
			}
		}
		
		return memo[X];
	}

	public static int BottomUp(int X){
		memo[1]		= 0;
		
		for( int i=2;i<X+1;i++ ){
			memo[i] = memo[i-1]+1;
			if( i%2==0 && memo[i]>memo[i/2]+1 ){
				memo[i] = memo[i/2]+1;
			}
			if( i%3==0 && memo[i]>memo[i/3]+1 ){
				memo[i] = memo[i/3]+1;
			}
		}
		
		return memo[X];
	}
}
