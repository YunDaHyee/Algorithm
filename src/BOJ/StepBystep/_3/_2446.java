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
		*********
		 *******
		  *****
		   ***
		    *
		   ***
		  *****
		 *******
		*********
	@history
		끝에 공백은 안중요한 듯..그냥 작성을 안하면 된다!
		했다가 출력양식이 틀렸따고 웅앵 거리더라ㅠ
 *
 */
public class _2446 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int size = Integer.parseInt( br.readLine() );
		
		for( int i=0;i<size;i++ ){ //라인
			for( int j=0;j<i;j++ ){// 첫 공백
				bw.write(" ");
			}
			for( int j=1;j<(2*size)-(2*i);j++ ){// 별
				bw.write("*");
			}
			/*for( int j=0;j<i;j++ ){// 두번째 공백
				bw.write(" ");
			}*/
			bw.newLine();
		}
		
		for( int i=size-2;i>=0;i-- ){ //라인
			for( int j=0;j<i;j++ ){// 첫 공백
				bw.write(" ");
			}
			for( int j=1;j<(2*size)-(2*i);j++ ){// 별
				bw.write("*");
			}
			/*for( int j=0;j<i;j++ ){// 두번째 공백
				bw.write(" ");
			}*/
			bw.newLine();
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
