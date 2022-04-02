/**
 * 
 */
package _3_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 	@Question
		요즘 민규네 동네에서는 스타트링크에서 만든 PS카드를 모으는 것이 유행이다.
		PS카드는 PS(Problem Solving)분야에서 유명한 사람들의 아이디와 얼굴이 적혀있는 카드이다.
		각각의 카드에는 등급을 나타내는 색이 칠해져 있고, 다음과 같이 8가지가 있다.
		
		전설카드
		레드카드
		오렌지카드
		퍼플카드
		블루카드
		청록카드
		그린카드
		그레이카드
		
		카드는 카드팩의 형태로만 구매할 수 있고
		카드팩의 종류는 카드 1개가 포함된 카드팩, 카드 2개가 포함된 카드팩, ... 카드 N개가 포함된 카드팩과 같이 총 N가지가 존재한다.
		민규는 카드의 개수가 적은 팩이더라도 가격이 비싸면 높은 등급의 카드가 많이 들어있을 것이라는 미신을 믿고 있다.
		따라서, 민규는 돈을 최대한 많이 지불해서 카드 N개 구매하려고 한다.
		카드가 i개 포함된 카드팩의 가격은 Pi원이다.
		
		예를 들어, 카드팩이 총 4가지 종류가 있고, P1 = 1, P2 = 5, P3 = 6, P4 = 7인 경우에 민규가 카드 4개를 갖기 위해 지불해야 하는 금액의 최댓값은 10원이다.
		2개 들어있는 카드팩을 2번 사면 된다.
		P1 = 5, P2 = 2, P3 = 8, P4 = 10인 경우에는 카드가 1개 들어있는 카드팩을 4번 사면 20원이고, 이 경우가 민규가 지불해야 하는 금액의 최댓값이다.
		마지막으로, P1 = 3, P2 = 5, P3 = 15, P4 = 16인 경우에는 3개 들어있는 카드팩과 1개 들어있는 카드팩을 구매해 18원을 지불하는 것이 최댓값이다.

		카드 팩의 가격이 주어졌을 때, N개의 카드를 구매하기 위해 민규가 지불해야 하는 금액의 최댓값을 구하는 프로그램을 작성하시오.
		N개보다 많은 개수의 카드를 산 다음, 나머지 카드를 버려서 N개를 만드는 것은 불가능하다.
		즉, 구매한 카드팩에 포함되어 있는 카드 개수의 합은 N과 같아야 한다.
		
	@Input
		첫째 줄에 민규가 구매하려고 하는 카드의 개수 N이 주어진다. (1 ≤ N ≤ 1,000)
		둘째 줄에는 Pi가 P1부터 PN까지 순서대로 주어진다. (1 ≤ Pi ≤ 10,000)
		1.
		4
		1 5 6 7
		
		2.
		5
		10 9 8 7 6
		
		3.
		10
		1 1 2 3 5 8 13 21 34 55
		
		4.
		10
		5 10 11 12 13 30 35 40 45 47
		
		5.
		4
		5 2 8 10
		
		6.
		4
		3 5 15 16
		
	@Output
		첫째 줄에 민규가 카드 N개를 갖기 위해 지불해야 하는 금액의 최댓값을 출력한다.
		1. 10
		2. 50
		3. 55
		4. 50
		5. 20
		6. 18	
		
	@history
		카드 개수 : i개 
		돈 많이 내서 카드 i개 구입 원함 = 최대값
		카드가 i개 포함된 카드팩 가격 Pi
		카드 i개가 포함된 카드팩 P[i]
		
		D[N]	= N개의 카드를 구매하기 위해 민규가 지불해야 하는 금액의 최댓값
		 		= N-i개의 카드 금액 최대값+ Pi(i개의 카드 구매금액)
		 		= MAX( D[N-i]  + Pn )
		 		
		 		N개의 카드팩에 들어있는 카드의 개수 i가 몇 개 들었는지 알 수 없으므로
		 		전 것을 가지고 구하는 방법으로 접근한다.
		 		카드가 i개 들어있는 카드팩을 구매하고
		 		나머지는 N-i개를 적절히 잘 구매하면 되므로(카드 N개가 있을 때, 마지막 카드를 빼면 N-i)
		 		합을 구해주면 그게 마지막에 i번쨰 카드를 구매했을 때 N개가 되는 비용임.

				변수 범위 : 1<=i<=N
				
		 		N = 변수가 아니고 정해져있는 값
				i = 카드의 개수. 제일 적은 개수의 카드팩을 구매하면 i의 최소값은 1.
				i<=N : 경우에 따라서는 한번에 n개 들어있는 카드팩을 구매할 수 있음
	
		
		for( int i=1;i<cardPackPrices.length;i++ ){
			memo[i] = TopDown(n-i);
			memo[n] = Math.max( TopDown(n), memo[i]+cardPackPrices[i] );
		}
		
		이렇게 하면 n-i는 구할 수 있지만 n은 영원히 구할 수 없는데 어떻게 해야되지..?
		=> 대안 : 
				for( int i=1;i<cardPackPrices.length;i++ ){
					if( n-i <= 0 ){// 계쏙 뺴주는 거라서 전처리 필요
						break;
					}
					memo[i] = TopDown(n-i); 
					memo[n] = Math.max( memo[n], memo[i]+cardPackPrices[i] );
				}
				이렇게 하긴 했지만 답이 일치하지가 않다..
		=> 대안 :
			n-i를 구할 때마다 넣는 게 아니고 memo[i]에 넣는 게 아니고
			max를 그떄마다 줘서 그 값과 비교하게 해야한다.
			int max = 0;
		
			for( int i=1;i<cardPackPrices.length;i++ ){
				if( n-i <= 0 ){// 계쏙 뺴주는 거라서 전처리 필요
					break;
				}
				max = Math.max( max, TopDown(n-i)+cardPackPrices[i] );
			}
			
				
	@Date
		2022. 4. 1.
 */

public class _5_11052_v2 {
	private static int[] memo = new int[1001], cardPackPrices=new int[1001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int buyCardCount = Integer.parseInt(br.readLine());
		String[] raws	 = br.readLine().split(" ");
		
		for( int i=1;i<=buyCardCount;i++ ){
			cardPackPrices[i] = Integer.parseInt(raws[i-1]);
		}
		
		//System.out.println( TopDown(buyCardCount) );
		System.out.println( BottomUp(buyCardCount) );
		
		br.close();
	}

	private static int TopDown(int n) {
		
		if( n==0 ){ // 계쏙 빼주는 거라서 0일 때 음수가 되지 않도록 하기 위함
			return 0;
		}
		
		if( memo[n]>0 ){
			return memo[n];
		}
		
		int max = 0;
		
		for( int i=1;i<=n;i++ ){
			max = Math.max( max, TopDown(n-i)+cardPackPrices[i] );
		}
		
		memo[n] = max;
		
		return memo[n];
	}
	
	private static int BottomUp(int n) {
		for( int i=1;i<=n;i++ ){
			for( int j=1;j<=i;j++ ){
				// Math.max로 하나, 이거로 하나... 어차피 더 큰 값이 들어간다는 점이 같고 더 크지 않으면 그대로 그 값이 들어간다는건데 왜 다르지 결과가?
				// 아 내가 카드팩 가격 배열에서 i번째의 값을 가져와서 값이 다른 것이었다..^^;
                memo[i] = Math.max( memo[i], memo[i-j] + cardPackPrices[j] );
			}
		}
		return memo[n];
	}
}
