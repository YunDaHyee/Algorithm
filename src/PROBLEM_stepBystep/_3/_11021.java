/**
 * 
 */
package _3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**

문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다.
각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
5
1 1
2 3
3 4
9 8
5 2

출력
각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력한다. 테스트 케이스 번호는 1부터 시작한다.
Case #1: 2
Case #2: 5
Case #3: 7
Case #4: 17
Case #5: 7

- 히스토리
StringTokenizer로 하는거랑 성능은 비슷한 듯..? 안할 때가 더 빠르긴 함
 *
 */
public class _11021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int		tCase	= Integer.parseInt( br.readLine() );
		/*
		String[] num	= null;
		
		for( int i=1;i<=tCase;i++ ) {
			num = br.readLine().split(" ");
			bw.write( "Case #"+i+": "+Integer.toString(Integer.parseInt(num[0])+Integer.parseInt(num[1]))+"\n" );
		}
		*/
		
		// 타 코드 적용
		for( int i=1;i<=tCase;i++ ) {
			StringTokenizer num	= new StringTokenizer( br.readLine() );
			bw.write( "Case #"+i+": "+Integer.toString(Integer.parseInt(num.nextToken())+Integer.parseInt(num.nextToken()))+"\n" );
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
