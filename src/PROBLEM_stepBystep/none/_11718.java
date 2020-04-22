package none;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * 
	@Question
		입력 받은 대로 출력하는 프로그램을 작성하시오.
	@Input
		입력이 주어진다. 입력은 최대 100줄로 이루어져 있고, 알파벳 소문자, 대문자, 공백, 숫자로만 이루어져 있다.
		각 줄은 100글자를 넘지 않으며, 빈 줄은 주어지지 않는다. 또, 각 줄은 공백으로 시작하지 않고, 공백으로 끝나지 않는다.
		Hello
		Baekjoon
		Online Judge
	@Output
		입력받은 그대로 출력한다.	
		Hello
		Baekjoon
		Online Judge
	@history
		input 조건은 딱히 신경 안쓸거다...존나 스트레스ㅡㅡ 휴;
		어쨌든 이 문제도 EOF를 알아내서 해야하는 소스였음.
		10951이랑 EOF를 알아내서 처리 해야한다는 점이 비슷하긴 한데
		차이점으로는
		
		10951 : 숫자 두개를 입력 받아서 덧셈을 출력하는 거
		11718 : 문자 그대~로 출력하는 거
 *
 */
public class _11718 {
	public static void main(String args[]) throws IOException{
		BufferedReader		br			= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter		bw			= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		/* 
		 * 문제 설명상으론 되어야 할 것 같은데 맞추지 못한 코드..
		 * input의 조건은 굳이 명시하지말라고 되어있긴 함..어차피 input 데이터들은 조건에 맞는 데이터들이 들어간다고..
		 * 
		ArrayList<String>	inputArr	= new ArrayList<String>();
		
			for( int i=0;i<100;i++ ){
				inputStr.append( br.readLine() );
				if( inputStr!=null && inputStr.length()!=0 && !inputStr.toString().startsWith(" ") && !inputStr.toString().endsWith(" ") ){
					if( inputStr.length()<100 ){
						bw.write( inputStr+"\n");
						bw.flush();
					}else{
						break;
					}
				}else{
					break;
				}
				inputStr.setLength(0);
			}
		*/
		String input = "";
		while( (input = br.readLine()) != null && input.length()!=0 ){
			bw.write( input+"\n" );
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
}
