package StepBystep.none;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
 */


/**
	문제
		첫째 줄에는 별 1개, 둘째 줄에는 별 3개, ..., N번째 줄에는 별 2×N-1개를 찍는 문제
		별은 가운데를 기준으로 대칭이어야 한다.
	
	입력
		첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
		5
	
	출력
		첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
		    *
		   ***
		  *****
		 *******
		*********
 	history
 		별을 찍고나서 뒤에 공백도 처리해줘야 한다고 생각했는데 그냥 앞에 공백만 처리해주면 되는거였따

		- 타 코드 Review
		StringBUilder를 이용해서 append로 쭉 붙여가지고 마지막에 출력하는 게 많이 보였다.
		그거 말고 그냥 나는 출력하는 방식으루만 함,,
 *
 */
public class _2442 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int size	= Integer.parseInt( br.readLine() );	// 고정 전체 라인 수
		int halfCnt = ((2*size)-1)/2;						// 총 찍어야 하는 별의 수의 절반까지가 공백의 size
		int line	= 0;									// 변하는 전체 라인 수
		
		while( ++line<=size ) {
			for( int i=halfCnt--;i>0;i-- ) {
				bw.write(" ");
			}
			for( int j=1;j<=(2*line)-1;j++ ) {
				bw.write("*");
			}
			bw.newLine();
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
