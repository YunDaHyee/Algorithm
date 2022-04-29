package StepBystep._3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
	@Question
		N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
		1)1
		  1
		2)5
		  54321
		3)25
		  7000000000000000000000000
		4)11
		  10987654321
	@Output
		입력으로 주어진 숫자 N개의 합을 출력한다.
		1) 1
		2) 15
		3) 7
		4) 46
	@history
		정규식이 좀 골치아팠지만,,쉽게 해결 가능했다,,
 *
 */
public class _11720_2 {
	public static void main(String args[]) throws IOException{
		BufferedReader	br		= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw		= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int				cnt		= Integer.parseInt( br.readLine() );
		String[]		numArr	= br.readLine().split("|[^0-9$]");
		int				sum		= 0; 
		
		for( int i=0;i<cnt;i++ ){
			sum += Integer.parseInt(numArr[i]);
		}
		
		bw.write( Integer.toString(sum) );
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}
