package _3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
	@Question
		N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램을 작성하시오. 출력 형식에 맞춰서 출력하면 된다.
	@Input
		첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 9보다 작거나 같다.
		2
	@Output
		출력형식과 같게 N*1부터 N*9까지 출력한다.
		2 * 1 = 2
		2 * 2 = 4
		2 * 3 = 6
		2 * 4 = 8
		2 * 5 = 10
		2 * 6 = 12
		2 * 7 = 14
		2 * 8 = 16
		2 * 9 = 18
	@history
		while이 조금 더 빠르긴 함,,
 *
 */
public class _2739_2 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int dan = Integer.parseInt( br.readLine() );
		/*for( int i=1;i<=9;i++ ){
			bw.write( dan+" * "+i+" = "+dan*i+"\n" );
		}*/
		
		int i = 0;
		while(++i<=9){
			bw.write( dan+" * "+i+" = "+dan*i+"\n" );
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
