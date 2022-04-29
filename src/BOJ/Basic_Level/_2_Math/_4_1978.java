/**
 * 
 */
package _2_Math;

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
 */

public class _4_1978 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw			= new BufferedWriter( new OutputStreamWriter(System.out) );
	
		int			size		= Integer.parseInt(br.readLine());
		String[]	raws		= br.readLine().split(" ");
		int			primeCount	= 0;
		
		for( int i=0;i<size;i++ ){
			if( isPrime(Integer.parseInt(raws[i])) ){
				primeCount++;
			}
		}
		
		bw.write(primeCount+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean isPrime(int number){
		if( number<2 ){
			return false;
		}
		
		for( int i=2;i*i<=number;i++ ){
			if( number%i==0 ){
				return false;
			}
		}
		
		return true;
	}
}
