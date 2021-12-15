/**
 * 
 */
package _2_Math.연습문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
	@문제
		정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
	@입력
		첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.
		72
	@출력
		N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.
		2
		2
		2
		3
		3
	@HISTORY
		소인수분해
		== 1보다 큰 자연수를 소인수(소수인 인수)들만의 곱으로 나타내는 것
		== 합성수를 소수의 곱으로 나타내는 방법
		
		소수찾기에서 했떤 것의 응용인데
		N을 소인수분해 했을 때, 나타날 수 있는 인수 중에서 가장 큰 값은 루트N이므로
		소수를 찾지 않고도 2부터 루트N까지 돌면서 N을 나눌 수 있으면 나눌 수 없을 때까지 계속 나누면 된다.
		즉, 소수찾기에서는
		for (int i=2; i*i<=n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		이 과정을 한번만 실행하고 소수의 조건을 충족하기 위해 2 이상의 수부터 i*i<=n까지 진행하면서 
		나머지가 0이 될 수 있는 n인 경우 소수가 아닌 걸로 판가름 해서 소수를 찾았는데
		
		여기서는
		이걸 역이용해서 소수가 나올때까지 소수인 인수를 분해하고 그걸 출력해낸다.
		1
		 
	@Date
		2021. 12. 15.
 */

public class _910_11653 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br		= new BufferedReader( new InputStreamReader(System.in) );
		int				number	= Integer.parseInt(br.readLine());
		
		for(int i=2;i*i<=number;i++ ){
			while( number%i==0 ){
				System.out.println(i);
				number/=i;
			}
		}
		
		if( number>1 ){
			System.out.println(number);
		}
	}
}
