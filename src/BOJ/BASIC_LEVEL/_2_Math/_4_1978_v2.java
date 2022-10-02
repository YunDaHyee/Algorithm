/**
 * 
 */
package BASIC_LEVEL._2_Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
	@문제
		주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
	@입력
		첫 줄에 수의 개수 N이 주어진다.
		N은 100이하이다.
		다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
		4
		1 3 5 7
	@출력
		주어진 수들 중 소수의 개수를 출력한다.
		3
	@HISTORY
		소수 = 약수가 1과 자기자신뿐인 수
		시간복잡도 = O(루트 N) 방법으로 풀이
	@Date
		2022. 4. 21.
		
 */

public class _4_1978_v2 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
		String[] primes = new String[Integer.parseInt(br.readLine())];
		primes = br.readLine().split(" ");
		
		int result = 0;
		
		for( int i=0;i<primes.length;i++ ) {
			if( isPrime(Integer.parseInt(primes[i])) ) {
				result++;
			}
		}
		
		System.out.println( result );
		
		br.close();
	}
	
	public static boolean isPrime(int number){
		if( number<2 ) {
			return false;
		}
		
		for( int i=2;i*i<=number;i++ ){
			if( number%i==0 ) {
				return false;
			}
		}
		
		return true;
	}
}
