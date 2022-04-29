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
		- Top-down 방식(재귀)
		배열로 했다가 많이 느리길레 List로 해봤지만 배열로 한 것보다 더 오래 걸려서 지웠다.
		
		- Bottom-up 방식(반복문)
		확실히 반복문이 빠르다는 것을 느꼈다.
		
		더 연습해보고 어느 방식에 뭘 사용해야할지를 알아야할 듯 하다.
		
	@Date
		2022. 1. 10.
 */

public class _1_1463 {
	public static int[] memo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int value = Integer.parseInt(br.readLine());
		memo = new int[value+1]; // value와 같은 값도 포함되니까 +1해줌
		
		memo[1] = 0;
		
		for( int dividend=2;dividend<memo.length;dividend++ ){
			memo[dividend] = memo[dividend-1]+1;
			memoization(2, dividend);
			memoization(3, dividend);
		}
		System.out.println( memo[value] );
		br.close();
	}

	public static void memoization(int divisor, int dividend){
		int tempResult = memo[dividend/divisor]+1;
		if( dividend%divisor==0&&memo[dividend]>tempResult ){
			memo[dividend] = tempResult;
		}
	}
	
	// 재귀용
	/*
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int value = Integer.parseInt(br.readLine());
		memo = new int[value+1]; // value와 같은 값도 포함되니까 +1해줌
		System.out.println( go(value) );
		br.close();
	}
	
	public static int go(int dividend) {
		if( dividend==1 ) return 0;
		if( memo[dividend]>0 ) return memo[dividend];
		
		memo[dividend] = go(dividend-1)+1;
		
		memoization(2, dividend);
		memoization(3, dividend);
		
		return memo[dividend];
	}
	public static void memoization(int divisor, int dividend){
		if( dividend%divisor==0 ){
			int tempResult = go(dividend/divisor)+1;
			if( memo[dividend]>tempResult ){ // 최소값이 들어가는거니까
				memo[dividend] = tempResult;
			}
		}
	}
	*/
	
	
}
