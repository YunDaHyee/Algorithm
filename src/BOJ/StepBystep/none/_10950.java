package StepBystep.none;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
	@Question
		두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 테스트 케이스의 개수 T가 주어진다.
		각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
		5
		1 1
		2 3
		3 4
		9 8
		5 2
	@Output
		각 테스트 케이스마다 A+B를 출력한다.
		2
		5
		7
		17
		7
	@history
		이클립스 자체에서는 flush를 for문 내에서 해주지 않으면은 테스트 케이스를 다 입력해야 출력이 됨.
		따라서 for문 내에서 출력이 되게 하려면 flush를 for문 내에서 해야함.
		근데 정답제출 하니까 for문 안에 flush가 있든 없든 다 맞다고는 나오는데 없는 게 시간이 더 빠름.
 *
 */
public class _10950 {
	public static void main(String args[]) throws IOException{
		BufferedReader		br			= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter		bw			= new BufferedWriter( new OutputStreamWriter(System.out) );
		int					caseCnt		= 0;
		//ArrayList<Integer> 	resultArr	= new ArrayList<Integer>();
		
		caseCnt = Integer.parseInt( br.readLine() );
		
		for( int i=0;i<caseCnt;i++ ){
			// ▼ String[] 로 사용하는 경우
			//String[]  numberArr	= br.readLine().split("\\s");
			//bw.write( Integer.toString(Integer.parseInt(numberArr[0]) + Integer.parseInt(numberArr[1]))+"\n" );
			
			// ▼ StringToeknizer 로 사용하는 경우
			StringTokenizer  numberArr	= new StringTokenizer( br.readLine()," " );
			bw.write( Integer.toString(Integer.parseInt(numberArr.nextToken()) + Integer.parseInt(numberArr.nextToken()))+"\n" );

			//bw.flush();
		}
		
		/*for( Integer result : resultArr ){
			bw.write( String.valueOf(result)+"\n" );
		}*/
		br.close();
		bw.flush();
		bw.close();
		
	}
}
