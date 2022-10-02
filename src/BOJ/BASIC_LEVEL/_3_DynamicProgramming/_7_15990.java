/**
 * 
 */
package BASIC_LEVEL._3_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 	@Question
		정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 3가지가 있다.
		합을 나타낼 때는 수를 1개 이상 사용해야 한다.
		단, 같은 수를 두 번 이상 연속해서 사용하면 안 된다.
		1+2+1
		1+3
		3+1
		정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 테스트 케이스의 개수 T가 주어진다.
		각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다.
		n은 양수이며 100,000보다 작거나 같다.
		3
		4
		7
		10
	@Output
		각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지를 출력한다.
		3
		9
		27
	@history
		cf) 정수 N을 1,2,3의 합으로 나타내는 방법
			D[N] = D[N-1]+D[N-2]+D[N-3]

		D[N]	= 정수 N을 1,2,3의 합으로 같은 수를 연속하지 않게 나타내는 방법
		
		연속되지 않게를 어떻게 표현하지..?
		- 1이 맨 앞에 오는 경우
			가능한 다음의 숫자 : 2,3
			D[N-1]	= 1+(N-2)+(N-3)
					= 1+D[N-2]+D[N-3]
		- 2가 맨 앞에 오는 경우
			가능한 다음의 숫자 : 1,3
			D[N-2]	= 2+(N-1)+(N-3)
					= 2+D[N-1]+D[N-3]
		- 3이 맨 앞에 오는 경우
			가능한 다음의 숫자 : 1,2
			D[N-3] 	= 2+(N-1)+(N-2)
					= 3+D[N-1]+D[N-2]
					
		D[N]	= 	1+D[N-2]+D[N-3] + 2+D[N-1]+D[N-3] + 3+D[N-1]+D[N-2]
				=	1+2+3+2(D[N-1]+D[N-2]+D[N-3])
				
		이건 좀 아닌 것 같아서 자료를 참고 했다..
		어쨌든 이론상으론 점화식을 똑같이 세우긴 함
		D[i][j]	= i를 1,2,3의 합으로 나타내는 방법의 수, 마지막에 사용한 수는 j
		D[i][1]	= 	D[i-1][2]+D[i-1][3]
		D[i][2]	= 	D[i-2][1]+D[i-2][3]
		D[i][3]	=	D[i-3][1]+D[i-3][2]
		D[N]	=	D[i-1]([2]+[3]) + D[N-2]([1]+[3]) + D[N-3]([1]+[2])

		[1] 이걸 어떻게 표시하지
		아 그냥 N 대신 들어가는 값인가보다.
		
		- 예외
		n = 0,1,2 => 1
		0,1 : 조합하지 않아도 그 자체로 나타내지므로 1가지 방법만이 존재
		dp[1][1] = 1 (1)
		(dp[1][2] = dp[1][3] = 0이다. 1을 2랑 3으로 표현할 순 X)
		
		2	: 1+1일 순 없고 2 자체로만 나타내지므로
		dp[2][1] = dp[2][3] = 0이고 dp[2][2] = 1이다.
		(2를 1와 3으로 표현할 수 X. 2 자체만으로 가능하니까 1)
		
		3일 떄 예외처리랳야ㅏ나..?
		1+2
		2+1
		3
		3가지..
		dp[3][1] = dp[3][2] = dp[3][3] = 1이다. => 3읆 만들 떄 1로 만드는 경우, 2로 만드는 경우, 3으로 만드는 경우
		
		자료를 참고해서 보니까
		그냥 1,2,3 더하기 문제와 같이 D[0]=1 이런 식으로 처리하면
		아무것도 카드를 사용하지 않은 걸 처리해주면은 중복이 발생한다고 한다.
		memo를 2차원배열로 두고 1,2,3 각각이 맨 앞에 오는 경우와 아닌 경우로 나눠서 예외처리가 필요하다.
		ex)
		D[0] = 1일 때,
		D[0][1] = 1, D[0][2] = 1, D[0][3] = 1로 초기화 한다면
		D[1][1] = D[0][2] = D[0][3] = 2 (중복 발생)
		ex)
		D[i][1]인 경우,
		   i>1	: D[i-1][2] + D[i-1][3]
		   i==1 : 1
		   i<1	: 0 
		   
		처음 풀었는 방식은 너무 오래 걸려서 다른 사람 걸 참고했다.
		
		TopDown : 있는 그대로 호출 스택을 만들기 때문에 스택오버플로우가 날 수 있으므로 입력값만큼 돌게 하는 것이 빠름.
		BottomUp : 입력 받는대로 처리하도록 하면 시간복잡도가 더 커져서 미리 구해놓고 시작하는 게 더 빠름.
		
	@Date
		2022. 4. 4.
 */

public class _7_15990 {
	static long[][] memo = new long[100001][4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader	br			= new BufferedReader(new InputStreamReader(System.in));
		
		int				testCase	= Integer.parseInt( br.readLine() );
		StringBuilder	result		= new StringBuilder();
		memo[1][1] = memo[2][2] = memo[3][3] = 1;
		
		/* TopDown 방식 ========================================================================== */
		while( testCase-->0 ){
			int n			= Integer.parseInt( br.readLine() );
			long tempResult	= 0;
			TopDown( n, 1 );
			for( int i=1;i<4;i++ ){
                tempResult += memo[n][i];
				tempResult %= 1_000_000_009;
			}
			result.append(tempResult);
			result.append("\n");
		}
		/*  ======================================================================================= */
		
		/* BottomUp 방식  ========================================================================= */
		int[] nn = new int[testCase+1];
		
		for( int i=1;i<=testCase;i++ ){
			nn[i] = Integer.parseInt( br.readLine() );
		}
		
		BottomUp();
		
		for( int i=1;i<=testCase;i++ ){
			result.append( (memo[nn[i]][1] + memo[nn[i]][2] + memo[nn[i]][3])%1000000009 );
			result.append("\n");
		}
		/*  ======================================================================================= */
		
		System.out.println(result.toString());
		br.close();
	}

	private static long TopDown(int i,int j) {
		if( i<0 || i<j ){
			return 0;
		}
		
		if ( i==j ){
			// 이걸 안해주면은 해당 인덱스들에서는 1로 리턴되어 빠져나갈 거기 때문에 memo배열에 저장을 안한채로 넘길 것이다..
			// 그래서 이 작업이 필요.
			memo[i][j] = 1;
			return 1;
		}
		
		if( memo[i][j]>0 ){
			return memo[i][j];
		}

		if( i-1>=0 ){
			memo[i][1] = i==1 ? 1 : (TopDown(i-1,2)+TopDown(i-1,3))%1000000009;
		}
		if( i-2>=0 ){
			memo[i][2] = i==2 ? 1 : (TopDown(i-2,1)+TopDown(i-2,3))%1000000009;
		}
		if( i-3>=0 ){
			memo[i][3] = i==3 ? 1 : (TopDown(i-3,1)+TopDown(i-3,2))%1000000009;
		}
		
		return memo[i][j];
	}

	private static void BottomUp() {
		for( int i=1;i<=100000;i++ ){
			// 값이 바뀔 수도 있으니까 i==j일 때 1 반환 처리가 필요함
			if( i-1>=0 ){
				memo[i][1] = i==1 ? 1 : (memo[i-1][2]+memo[i-1][3])%1000000009; 
			}
			if( i-2>=0 ){
				memo[i][2] = i==2 ? 1 : (memo[i-2][1]+memo[i-2][3])%1000000009;
			}
			if( i-3>=0 ){
				memo[i][3] = i==3 ? 1 : (memo[i-3][1]+memo[i-3][2])%1000000009;
			}
		}
	}
	

}
