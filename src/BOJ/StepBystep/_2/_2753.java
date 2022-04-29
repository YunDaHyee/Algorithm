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
연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력하는 프로그램을 작성하시오.
윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때 이다.
예를들어, 2012년은 4의 배수라서 윤년이지만, 1900년은 4의 배수이지만, 100의 배수이기 때문에 윤년이 아니다.
하지만, 2000년은 400의 배수이기 때문에 윤년이다.

입력
첫째 줄에 연도가 주어진다. 연도는 1보다 크거나 같고, 4000보다 작거나 같은 자연수이다.
2000

출력
첫째 줄에 윤년이면 1, 아니면 0을 출력한다.
1

- 히스토리
윤년 이라길래 좀 겁먹었는데 알고보니까 좀 쉬운 개념이었다..다행

-타코드 review
한줄에다가 바로 하기..
 */
public class _2753 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int year = Integer.parseInt( br.readLine() );
		
		if( year%4==0 ) {
			if( year%100!=0 || year%400==0 ) {
				bw.write( "1" );
			}else {
				bw.write( "0" );
			}
		}else {
			bw.write( "0" );
		}
		
		// 타 코드 적용
		if( year%4==0 && (year%100!=0 || year%400==0) ) {
			bw.write("1");
		}else {
			bw.write("0");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
