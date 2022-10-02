/**
 * 
 */
package BASIC_LEVEL._2_Math.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
	@문제
		골드바흐의 추측: 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.
		짝수 N을 두 소수의 합으로 나타내는 표현을 골드바흐 파티션이라고 한다.
		짝수 N이 주어졌을 때, 골드바흐 파티션의 개수를 구해보자.
		두 소수의 순서만 다른 것은 같은 파티션이다.
		
	@입력
		첫째 줄에 테스트 케이스의 개수 T (1 ≤ T ≤ 100)가 주어진다.
		각 테스트 케이스는 한 줄로 이루어져 있고, 정수 N은 짝수이고, 2 < N ≤ 1,000,000을 만족한다.
		5
		6
		8
		10
		12
		100	
	@출력
		각각의 테스트 케이스마다 골드바흐 파티션의 수를 출력한다.
		1
		1
		2
		1
		6
	@HISTORY
		골든바흐의 추측
		짝 = 소1+소2
		소수 == 2 이상의 수, 루트N보다 작같 자연수로 떨어지면 안된다.
		2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다 => 5보다 큰 홀수는 세 소수의 합으로 표현 가능하다.
		N = a+b => N-b = a
		
	@Date
		2021. 11. 24. 
 */

public class _6_17103 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br		= new BufferedReader( new InputStreamReader(System.in) );
		StringBuilder 	result	= new StringBuilder();
		
		int		count	= Integer.parseInt(br.readLine());
		int		even	= 1000000;
		boolean[] flags = new boolean[even];
		
		flags[0] = flags[1] = true;
		
		for( int i=2;i<even;i++ ){
			if( !flags[i] ){
				for( int j=i*2;j<even;j+=i ){ // 두번째 배수부터니까
					flags[j] = true;
				}
			}
		}
		
		while( count-->0 ){
			int partition = 0;
			even = Integer.parseInt(br.readLine());
			for( int i=2;i<=even/2;i++ ){ // 소수가 2부터니까
				if(!flags[i]&&!flags[even-i]){
					partition++;
				}
			}
			result.append(partition+"\n");
		}
		
		System.out.println(result);
		
		br.close();
	}
}
