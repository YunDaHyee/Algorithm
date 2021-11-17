package _1_DataStructure.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**

@문제
	네 자연수 A, B, C, D가 주어진다. 이때, A와 B를 붙인 수와 C와 D를 붙인 수의 합을 구하는 프로그램을 작성하시오.
	두 수 A와 B를 합치는 것은 A의 뒤에 B를 붙이는 것을 의미한다. 즉, 20과 30을 붙이면 2030이 된다.
@입력
	첫째 줄에 네 자연수 A, B, C, D가 주어진다. (1 ≤ A, B, C, D ≤ 1,000,000)
	10 20 30 40
	0 	1 2	 3
@출력
	A와 B를 붙인 수와 C와 D를 붙인 수의 합을 출력한다.
	4060
@HISTORY
	NumberFormatException이 계속 발생했다..
	int와 long의 차이가 숫자의 범위라고 했는데
	입력 조건 범위(1 ≤ A, B, C, D ≤ 1,000,000)가 그렇게 크지 않아서
	int로도 가능할 거라 생각하고 애꿎은 자료구조만 계속 바꿔가면서 풀었다.
	하지만 결국 문제는 범위 문제였다ㅠ
	long으로 바꿔주니 바로 해결됨..
	
	
 */
public class p12_10824 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter	bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] rawWord = br.readLine().split(" ");
		long sum = 0;
		
		for( int i=0;i<4;i+=2 ){
			sum += Long.parseLong(rawWord[i]+rawWord[i+1]);
		}
		
		bw.write(sum+"");
		
		br.close();
		bw.flush();
		bw.close();
	}
}

