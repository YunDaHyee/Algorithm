package none;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
	@Question
		두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
	@Input
		입력은 여러 개의 테스트 케이스로 이루어져 있다.
		각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
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
		테스트 케이스가 주어지지 않는 경우라서 이런 경우에는 EOF(End Of File)의 끝을 알아낸 후에 출력해야 하는거라 함..
		대개 Scanner로 접근해서 hasNextInt() 함수를 사용하던데 Scanner는 속도가 느리다는 말이 있어서
		BufferedReader로 EOF 탐색하는 방법을 찾게됨! 
 *
 */
public class _10951 {
	public static void main(String args[]) throws IOException{
		BufferedReader		br			= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter		bw			= new BufferedWriter( new OutputStreamWriter(System.out) );
		String				rawNum		= "";
		
		while( (rawNum = br.readLine()) != null && rawNum.length()!=0 ){ //!rawNum.isEmpty()로도 가능
			String[]	numberArr	= rawNum.split("\\s");
			bw.write( Integer.parseInt(numberArr[0]) + Integer.parseInt(numberArr[1]) + "\n" );
			bw.flush();
		}
		
		br.close();
		bw.close();
		
	}
}
