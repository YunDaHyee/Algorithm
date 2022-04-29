/**
 * 
 */
package _3_DynamicProgramming;

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
		1번 문제에서 풀었던 형태가 유지되는 게 아니라 문제에 따라 바뀜..
		네모 전체 그림을 채운다고 했을 때, 네모 앞 쪽부분은 다 똑같이 채워질거고 끝에 어떻게 놓냐에 따라서 달라지는거라서 끝에 기준 n-1,n-2으로 한 것인 듯 하다
		
		- Top-down 방식(재귀)
			value = 9부터 시작해서 쭉 2까지 들어간다.
			value=2일 때,
			go(2-1)로 1이 들어갔을 때 1이 반환되면 n1=1이 됨
			go(value-2)로 넘어가서 2-2=0로 0이 들어갔을 때 역시 1을 반환해서 n1+n2 = 2 되고 %=10007 = 2. 즉, memo[2]=2
			value=3 일 때,
			n1=2(이유;3-1=2=>memo[2]=2이므로), n2=1(이유;go(3-2=1)이 들어가는데 1 반환)  +=> 3%= 10007 = 3. 즉, memo[3]=3
			value=4 일 때,
			n1=3(이유;4-1=3=>memo[3]=3이므로), n2=2(이유;go(4-2=2)이 들어가는데 2 반환)  +=> 3%= 10007 = 5. 즉, memo[4]=5
			이런식으로 쭉 계속 참조해서 맨 마지막 값을 반환해냄.
			
		- Bottom-up 방식(반복문)
			
	@Date
		2022. 1. 11.
 */

public class _2_11726 {
	static int[] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		memo = new int[1001];
		//System.out.println(go(Integer.parseInt(br.readLine()))); // Top-down
		int N = Integer.parseInt(br.readLine());
		memo[0] = memo[1] = 1; 
		
		for( int i=2;i<=1000;i++ ){
			memo[i] = (memo[i-1] + memo[i-2])%10007; // 작은 것부터 올라가는 거니까 다 memo[i]==0이기 때문에 굳이 조건문을 넣을 필요는 없다.
		}
		System.out.println(memo[N]);
		br.close();
	}
	
	public static int go(int N) {
		if( N<=1 ) return 1; // n-1, n-2가 0이 되면 안되니까 적어도 2*1은 될 수 있게 1,2보다 각각 하나씩 큰 2,3을 리턴해줘야할 것 같은..아닌가봄 // <- 이 이론은 맞는데 2*n에서 -1나 -2를 해줄 때 0이면은 -1이 되고 1일 때는 0이 되므로 둘 다 1로 저장해둠
		if( memo[N]>0 ) return memo[N];
		
		int n1=go(N-1);
		int n2=go(N-2);
		memo[N]=(n1+n2)%10007;
		
		return memo[N];
	}


}
