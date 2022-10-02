/**
 * 
 */
package BASIC_LEVEL._3_DynamicProgramming;

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
		
		카드는 카드팩의 형태로만 구매할 수 있고, 카드팩의 종류는 카드 1개가 포함된 카드팩, 카드 2개가 포함된 카드팩, ... 
		카드 N개가 포함된 카드팩과 같이 총 N가지가 존재한다.
		
		민규는 지난주에 너무 많은 돈을 써 버렸다.
		그래서 오늘은 돈을 최소로 지불해서 카드 N개를 구매하려고 한다.
		카드가 i개 포함된 카드팩의 가격은 Pi원이다.
		
		예를 들어, 카드팩이 총 4가지 종류가 있고, P1 = 1, P2 = 5, P3 = 6, P4 = 7인 경우에
		민규가 카드 4개를 갖기 위해 지불해야 하는 금액의 최솟값은 4원이다.
		1개 들어있는 카드팩을 4번 사면 된다.
		
		P1 = 5, P2 = 2, P3 = 8, P4 = 10인 경우에는 카드가 2개 들어있는 카드팩을 2번 사면 4원이고, 이 경우가 민규가 지불해야 하는 금액의 최솟값이다.
		
		카드 팩의 가격이 주어졌을 때, N개의 카드를 구매하기 위해 민규가 지불해야 하는 금액의 최솟값을 구하는 프로그램을 작성하시오.
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
		첫째 줄에 민규가 카드 N개를 갖기 위해 지불해야 하는 금액의 최솟값을 출력한다.
		1. 4
		2. 6
		3. 5
		4. 26
		5. 4
		5. 10
	@history
		최소값을 찾는 것이기 때문에 초기값 설정이 중요하다.
		
	@Date
		2022. 1. 27.
 */

public class _6_16194 {
	static int[] cardPackPrices, memo;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		cardPackPrices = new int[N+1];
		memo = new int[N+1];
		int index = 1;
		memo[0] = 0;
		
		for( int i=1;i<=N;i++ ){
			memo[i] = -1;
		}
		
		for( String price : br.readLine().split(" ")){
			cardPackPrices[index++] = Integer.parseInt(price);
		}
		
		/*
		// 1. Bottom-up
		for( int i=1;i<=N;i++ ){
			for( int j=1;j<=i;j++ ){
				int existingPrice = memo[i];
				int addedPrice = memo[i-j]+cardPackPrices[j];
				memo[i] = min(existingPrice,addedPrice);
			}
		}
		System.out.println(memo[N]);
		*/
		
		
		// 2. Top-down
		System.out.println(go(N));
		
		br.close();
	}

	/**
	 * @param n
	 * @return
	 */
	private static int go(int n) {
		int min = -1;
		if( n==0 ){
			return 0;
		}
		
		if( memo[n]>0 ){
			return memo[n];
		}
		
		for( int i=1;i<=n;i++ ){
			min = min( min, go(n-i)+cardPackPrices[i] );
		}
		
		memo[n] = min;
		
		return memo[n];
	}

	/**
	 * @param existingPrice
	 * @param addedPrice
	 * @return
	 */
	private static int min(int existingPrice, int addedPrice) {
		return existingPrice==-1||existingPrice>addedPrice ? addedPrice : existingPrice;
	}
	
	
}
