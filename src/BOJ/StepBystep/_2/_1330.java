/**
 * 
 */
package _2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**

문제
두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B가 주어진다. A와 B는 공백 한 칸으로 구분되어져 있다.
1 2
10 2
5 5

출력
첫째 줄에 다음 세 가지 중 하나를 출력한다.
A가 B보다 큰 경우에는 '>'를 출력한다.
<
A가 B보다 작은 경우에는 '<'를 출력한다.
>
A와 B가 같은 경우에는 '=='를 출력한다.
==

// 타 코드 Review
삼항연산자 - 성능은 비슷한 듯..삼항연산자가 메모리는 더 차지한다

 *
 */
public class _1330 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		String[] num = br.readLine().split(" ");
		int numA = Integer.parseInt(num[0]);
		int numB = Integer.parseInt(num[1]);

		/*
		if( numA > numB ) {
			bw.write(">");
		}else if( numA < numB ) {
			bw.write(">");
		}else {
			bw.write("==");
		}
		*/
		
		// 타 코드 적용
		bw.write( numA>numB ? ">" : numA<numB ? "<" : "==" );
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}
