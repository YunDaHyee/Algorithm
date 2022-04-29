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
	@Question
		두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)
	@Output
		첫째 줄에 A/B를 출력한다. 절대/상대 오차는 10-9 까지 허용한다.
	@history
		
 *		
 */
public class _1008 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		try{
			StringBuilder inputStr = new StringBuilder();
			inputStr.append( br.readLine() );
			String[] input = inputStr.toString().split("\\s");
			double result = Double.parseDouble(input[0])/Double.parseDouble(input[1]);
			bw.write( String.valueOf(result) );	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			br.close();
			bw.flush();
			bw.close();
		}
	}

}
