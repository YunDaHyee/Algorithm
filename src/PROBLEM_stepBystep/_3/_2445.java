package _3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
	@Question
		예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.
	@Input
		첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
		5
	@Output
		첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
		*        *
		**      **
		***    ***
		****  ****
		**********
		****  ****
		***    ***
		**      **
		*        *
	@history
		조금씩 감이 오는 느낌..? 조금씩은 중첩for문을 다룰 줄 알겠따,,
 *
 */
public class _2445 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int size = Integer.parseInt( br.readLine() );
		
		for( int i=0;i<size;i++ ){ //라인
			for( int j=0;j<=i;j++ ){//첫번째 별
				bw.write("*");
			}
			for( int k=(2*size)-(2*i);k>2;k-- ){ //공백
				bw.write(" ");
			}
			for( int k=0;k<=i;k++ ){//두번째 별
				bw.write("*");
			}
			bw.newLine();
		}
		
		for( int i=size-2;i>=0;i-- ){ //라인
			for( int j=0;j<=i;j++ ){//첫번째 별
				bw.write("*");
			}
			for( int k=(2*size)-(2*i);k>2;k-- ){ //공백
				bw.write(" ");
			}
			for( int k=0;k<=i;k++ ){//두번째 별
				bw.write("*");
			}
			bw.newLine();
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
