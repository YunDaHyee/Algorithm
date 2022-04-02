/**
 * 
 */
package _3_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
		
		카드는 카드팩의 형태로만 구매할 수 있고, 카드팩의 종류는 카드 1개가 포함된 카드팩, 카드 2개가 포함된 카드팩, ... 카드 N개가 포함된 카드팩과 같이 총 N가지가 존재한다.
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
		5. 18	
		
	@history
		D[N] = 카드 N개를 구매할 때에 지불해야하는 최대값
		D[N-i] : 카드 N-i개 구매 비용의 최대값
		i개를 구매하면 N개를 구매한 것..
		memo[N-i]+cardPack[i] = 이전 카드들의 최대 비용 + 현재 카드 구매가격
		그래서 현재 카드 구매가격을 더하기 전 가격이랑 위의 값과 비교해서 더 큰 값을 넣는다.
		처음에 이해가 안가서 며칠이나 고민했던 문제..
		나중에 복기를 위해 상세히 적어보려고 한다.
		
		- Bottom-up 방식(반복문)
		- Top-down 방식(재귀)
			0까지 타고 들어가서
			0, 0+1=1 => max = 1. 1 반환
			
			0, 1+1 => max = 2
			2, 0+5 => max = 5. 5 반환
			
			0, 5+1 => max = 6
			6, 1+5
			6, 0+6. 6 반환
			
			0, 6+1 => max = 7
			7, 5+5 => max = 10
			10, 1+6
			10, 0+7. 10 반환
			
			
			
		
		
	@Date
		2022. 1. 20.
 */

public class _5_11052 {
	private static int[] memo,cardPacks=null;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 1;
		int N = Integer.parseInt(br.readLine());
		memo = new int[N+1];
		cardPacks = new int[N+1];
		for( String pack : br.readLine().split(" ") ){
			cardPacks[count++] = Integer.parseInt(pack);
		}
		
		// 1. Bottom-up 방식
		for( int i=1;i<=N;i++ ){
			for( int newCard=1;newCard<=i;newCard++ ){
				int existingPrice = memo[i];
				int addedPrice = memo[i-newCard]+cardPacks[newCard];
				memo[i]= max( existingPrice,addedPrice ); // 기존에 있는(이전에 구했던) 비용과 이전 비용에 현재 가격을 더한 비용의 비교
			}
		}
		
		System.out.println(memo[N]);
		
		// 2. Top-down 방식
		//System.out.println(go(N));
		
		br.close();
	}

	/**
	 * @param i
	 * @param j
	 * @return
	 */
	public static int max(int i, int j) {
		return i>j ? i : j;
	}
	
	
	public static int go(int n){
		int max = 0;

		if(n==0){ // n-i 해서 들어오기 때문에 0이 될 수 밖에 없으므로 그에 대한 반환 처리
			return 0;
		}
		
		if(memo[n]>0){ // n-i 했을 때에 중복한 값을 부르면 기존에 있는 값 반환 처리
			return memo[n];
		}
		
		for( int i=1;i<=n;i++ ){
			max = max(max,go(n-i)+cardPacks[i]);
		}
		
		memo[n] = max;
		
		return memo[n];
	}
}
