package StepBystep.none;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
	@Question
		입력 받은 대로 출력하는 프로그램을 작성하시오.
	@Input
		입력이 주어진다. 입력은 최대 100줄로 이루어져 있고, 알파벳 소문자, 대문자, 공백, 숫자로만 이루어져 있다.
		각 줄은 100글자를 넘지 않으며, 빈 줄이 주어질 수도 있고, 각 줄의 앞 뒤에 공백이 있을 수도 있다.
		    Hello
		
		Baekjoon     
		   Online Judge    
	@Output
		입력받은 그대로 출력한다.
		    Hello
		
		Baekjoon     
		   Online Judge    
	@history
		11718이랑 다른 점은 앞,뒤,빈줄이 가능하다는 점인데
		그렇게 되면, 11718은 input.length()!=0 조건이 포함되어야 하고 11719는 조건이 포함되면 안되어야 하는건데
		(물론 최대100줄,각줄100글자안넘는 건 물론이지만 앞,뒤 공백 안된다/된다는 조건도 input으로 이미 갖춰져 나온다는 가정하에!)
		백준에서는 input.length()!=0 이걸 포함 하든 안하든 11718,11719 둘 다 맞다고 나옴,,,
		혼란이다;;
		 
 *
 */
public class _11719 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		String input = "";
		
		while( (input = br.readLine())!=null ){
			bw.write( input+"\n" );
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
}
