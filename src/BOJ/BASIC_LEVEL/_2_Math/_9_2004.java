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
		(n
		 m)의 끝자리 0의 개수를 출력하는 프로그램을 작성하시오.
		
	@입력
		첫째 줄에 정수 n, m (0<=m<=n<=2,000,000,000, n!=0)이 들어온다.
		25 12
	@출력
		첫째 줄에 (n
		 		   m)의 끝자리 0의 개수를 출력한다.
		2
	@HISTORY
		n!/(n-m)!*m!
		둘 중의 최소값이 전체 10의 개수와 같은 의미를 가진대서
		countBy2>countBy5?countBy5:countBy2 이런식으로 했는데 잘못 생각해낸 듯 했다.
		
		- 남 거 찾아본 결과 :
		...2의 승수(a1 - b1, c1) 와 5의 승수(a2 - b2 - c2) 가 구해졌으면
		이제 겹치는(짝지을 수 있는) 개수를 구하면 되므로, 2와 5의 승수 중 최솟값을 출력하면 된다.
		https://st-lab.tistory.com/166
		=> nF,nmF,mF 별로 2,5 개수를 구하고 총합의 2,5 개수 중에 최소값을 출력하는 것
		
		중복된 코드를 조금이라도 더 줄이겠다고 굳이굳이 반복문을 쓰는 방법을 생각해내긴 했는데
		아무래도 직관적인 첫 번째 방법이 가장 간단한 것 같다.
		성능에 큰 차이는 없으니 그냥 읽기 쉬운 거로 택하겠다.
	@Date
		2021. 11. 24. 
 */

public class _9_2004 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
	
		String[] raws = br.readLine().split(" ");
		
		// 1. 반복되는 코드는 많지만 직관적이긴 함
		int zeroCountBy2 = 0, zeroCountBy5 = 0;
		
		zeroCountBy2 = getZeroCountBy2( Integer.parseInt(raws[0]) )
						- getZeroCountBy2( Integer.parseInt(raws[0])-Integer.parseInt(raws[1]) )
						- getZeroCountBy2( Integer.parseInt(raws[1]) );
		zeroCountBy5 = getZeroCountBy5( Integer.parseInt(raws[0]) )
						- getZeroCountBy5( Integer.parseInt(raws[0])-Integer.parseInt(raws[1]) )
						- getZeroCountBy5( Integer.parseInt(raws[1]) );
		// 2. for문으로 중복 코드 조금이라도 더 줄이기
		/*
		int zeroCountBy2 = getZeroCountBy2( Integer.parseInt(raws[0]) );
		int zeroCountBy5 = getZeroCountBy5( Integer.parseInt(raws[0]) );
		
		for( int i=0;i<2;i++ ){
			int value = Integer.parseInt(raws[i]);
			if( i==0 ){
				value = Integer.parseInt(raws[0])-Integer.parseInt(raws[1]);
			}
			zeroCountBy2-=getZeroCountBy2(value);
			zeroCountBy5-=getZeroCountBy5(value);
		}
		*/
		System.out.println(Math.min(zeroCountBy2, zeroCountBy5));
		
		br.close();
	}
	
	public static int getZeroCountBy2(int number) {
		int result = 0;
		while( number>=2 ){
			result += (number/=2);
		}
		return result;
	}
	
	public static int getZeroCountBy5(int number) {
		int result = 0;
		while( number>=5 ){
			result += (number/=5);
		}
		return result;
	}
}
