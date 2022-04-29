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
		N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.
	@입력
		첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)
		10
		3
	@출력
		첫째 줄에 구한 0의 개수를 출력한다.
		2
		0
	@HISTORY
		-	NumberFormatException이 계속 나길래 뭐가 또 문제지 싶었는데
			생각해보니까 그냥 한번의 출력으로만 하면 되는건데 while문으로 0이 나올 때까지 반복되도록 했다.
		-	처음에는 i%5==0만 해줬는데 소인수분해야한다는 걸 깜빡했다.
			N		: 100/5	=>	20(:아직 소인수분해 되는 수이므로)/5 =>	4
			개수	: 			20										24 
	@Date
		2021. 11. 23. 
 */

public class _8_1676 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
		//BufferedWriter	bw			= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int N			= Integer.parseInt(br.readLine());
		int zeroCount	= 0;
		
		while( N>=5 ){
			zeroCount+=(N/=5);
		}
		
		System.out.println(zeroCount);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
}
