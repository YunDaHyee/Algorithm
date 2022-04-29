/**
 * 
 */
package Basic_Level._2_Math.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
	@문제
		수빈이는 동생 N명과 숨바꼭질을 하고 있다.		
		수빈이는 현재 점 S에 있고, 동생은 A1, A2, ..., AN에 있다.
		수빈이는 걸어서 이동을 할 수 있다.		
		수빈이의 위치가 X일때 걷는다면 1초 후에 X+D나 X-D로 이동할 수 있다.		
		수빈이의 위치가 동생이 있는 위치와 같으면, 동생을 찾았다고 한다.
		모든 동생을 찾기위해 D의 값을 정하려고 한다.		
		가능한 D의 최댓값을 구해보자.
	@입력
		첫째 줄에 N(1 ≤ N ≤ 105)과 S(1 ≤ S ≤ 109)가 주어진다.		
		둘째 줄에 동생의 위치 Ai(1 ≤ Ai ≤ 109)가 주어진다.		
		동생의 위치는 모두 다르며, 수빈이의 위치와 같지 않다.
		1.
			3 3
			1 7 11
		2.
			3 81
			33 105 57
		3.
			1 1
			1000000000
	@출력
		가능한 D값의 최댓값을 출력한다.
		1. 2
		2. 24
		3. 999999999
	@HISTORY
		모든 동생을 찾기 위한 D의 최대값 즉, 공통된 최소한의 D 중 최대값 구하기 => 최대공약수 문제
		현재 위치와 각각 동생들과의 거리차 D들을 구한다.
		그리고 그 중에 최대공약수 구하기
		
	@Date
		2021. 11. 24.
 */

public class _2_17087 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br	= new BufferedReader( new InputStreamReader(System.in) );
        
		String[] NS = br.readLine().split(" ");
		String[] Ai = br.readLine().split(" ");
		
		int		headCount	= Integer.parseInt(NS[0]);
		int 	currentIndex= Integer.parseInt(NS[1]);
		int[]	Ds			= new int[headCount];
		int		result		= 0;
		
		for( int i=0;i<headCount;i++ ){
			Ds[i]=Math.abs(currentIndex-Integer.parseInt(Ai[i]));
		}
		
		result = Ds[0];
		
		for( int i=1;i<headCount;i++ ){
			result = getGCD(result,Ds[i]);
		}
		
		System.out.println(result);
		
		br.close();
	}

	public static int getGCD(int numberA, int numberB) {
		while( numberB!=0 ){
			int nmg = numberA%numberB;
			numberA = numberB;
			numberB = nmg;
		}
		
		return numberA;
	}
}
