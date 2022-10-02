/**
 * 
 */
package BASIC_LEVEL._3_DynamicProgramming;

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
		D[N] = n을 1,2,3의 합으로 나타내는 방법의 수 = D[N-1]+D[N-2]+D[N-3]	
		그 숫자까지 도는데 
		- Top-down 방식(재귀)
		- Bottom-up 방식(반복문)
	@Date
		2022. 1. 11.
 */

public class _4_9095 {
	static int[] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		memo = new int[11];//11보다 작은 수가 들어오는 거니까
		int count = Integer.parseInt(br.readLine()); // 3
		memo[0] = 1; // 0을 만드는 방법은 아무것도 안넣는 건데 이것도 방법이니까 카운팅함
		memo[1] = 1; // 1				  0+1(0 만드는 법)
		memo[2] = 2; // 2				  1+1(1 만드는법), 0+2
		memo[3] = 4; // 3				  1+1+1(2 만드는법), 2+1, 1+2, 0+3
		while( count-->0 ) {
			int n=Integer.parseInt(br.readLine());
			
			// 1. 재귀
			System.out.println( go(0, n));
			
			// 2. 반복문
			/*
			for( int exist=4;exist<=n;exist++ ){
				memo[exist] = memo[exist-3]+memo[exist-2]+memo[exist-1];
			}
			System.out.println(memo[n]);
			*/
		}
		br.close();
	}
	
	public static int go(int sum, int N) {
		// 재귀로 계속 +1씩 더하는 식이라서 들어온 값보다 합이 넘어가는 경우는 리턴
		if( sum==0 ){
			return 0;
		}
		
		// 들어온 값과 일치하면 목표값이 된 것이므로 cnt++
		if( sum==N ){
			return 1;
		}
		
		
		int now = 0;
		
		// 1,2,3을 넣는 경우 각각 재귀호출 - 목표값과 일치한다면 1이 반환되므로 now에 차곡차곡 값이 쌓일것..
		for( int i=1;i<=3;i++ ){
			now += go( sum+i, N );
		}
		
		return now;
	}


}
