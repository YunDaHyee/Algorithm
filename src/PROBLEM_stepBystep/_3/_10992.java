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
		1.1
		2.2
		3.3
		4.4
	@Output
		첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
		1.
		*
		2.
		 *
		***
		3.
		  *
		 * *
		*****
		4.
		   *
		  * *
		 *   *
		*******
		마지막행은 2*n-1개
		     *
		    * *
		   *   *
		  *     *
		 *********
		
	@history
		꽤 까다로웠떤 문제..
		사이즈가 3개 이상인 것 부터는 2개가 집을 짓는 형태에다가 중간 여백까지 있어서 좀 다루기 까다로웠다.
		다른 사람 코드 보니까 StringBuilder 로 많이 하던데 나도 StringBuilder로 이 문제를 함 짜봐야겠다.
 *
 */
public class _10992 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int size = Integer.parseInt( br.readLine() );
		
		for( int i=1;i<=size;i++ ){
			for( int j=size-i;j>0;j-- ){
				bw.write(" ");
			}
			if( size>=3 ){
				if( i!=1 && i!=size ){
					bw.write("*");
					for( int k=2;k<(2*i-1);k++ ){
						bw.write(" ");
					}
					bw.write("*");
				}else{
					for( int j=1;j<=(2*i-1);j++ ){
						bw.write("*");
					}
				}
			}else{
				for( int j=1;j<=(2*i-1);j++ ){
					bw.write("*");
				}
			}
			bw.newLine();
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
