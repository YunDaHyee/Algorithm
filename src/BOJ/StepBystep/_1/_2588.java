/**
 * 
 */
package StepBystep._1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**

(세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.

(1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 (1)의 위치에 들어갈 세 자리 자연수가, 둘째 줄에 (2)의 위치에 들어갈 세자리 자연수가 주어진다.
472
385

출력
첫째 줄부터 넷째 줄까지 차례대로 (3), (4), (5), (6)에 들어갈 값을 출력한다.
2360
3776
1416
181720

이발 집가서 리스트로 짠다 개빡침

 */
public class _2588 {
	public static void main(String[] args) throws IOException {

		BufferedReader	br		= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw		= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		StringBuilder	numA	= new StringBuilder(4).append( br.readLine() );
		StringBuilder	numB	= new StringBuilder(4).append( br.readLine() );
		int result = 0;
		
		for( int i=2;i>=0;i-- ) {
			int intB	=  numB.charAt(i);
			char setNum	= 0;
			char nmg	= 0;
			StringBuilder subSum	= new StringBuilder(4);
			for( int j=2;j>=0;j-- ) {
				int intA = Character.getNumericValue( numA.charAt(j) );
				String multi = Integer.toString( intB * intA );
				if( nmg != 0 ) {
					multi = Integer.toString( Integer.parseInt(multi)+Character.getNumericValue( nmg ) );
					nmg = 0;
				}
				if( Integer.parseInt(multi)>9 ) {
					nmg = multi.charAt(0);
					setNum = multi.charAt(1);
				}else {
					setNum = multi.charAt(0);
				}
				 
				subSum.append( setNum );
				
				if( j==0 && nmg!=0 ) {
					subSum.append( nmg );
				}
			}
			StringBuilder reverse = subSum.reverse();
			bw.write( reverse +"\n" );
			for( int j=i;j<2;j++ ) {
				reverse.append("0");
			}
			result += Integer.parseInt( reverse.toString() );
			bw.flush();
		}
		bw.write( Integer.toString(result) );
		bw.flush();
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}
