package StepBystep._1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 
	@Question
		아래 예제와 같이 고양이를 출력하시오.
	@Input
		X
	@Output
		\    /\
		 )  ( ')
		(  /  )
		 \(__)|
	@history
		1. 이클립스 내에서 특수문자는 \(역슬래시)를 사용하기!
		2. 첨엔 꼼수?는 아니고 걍 당근 되는 줄 알고
			bw.write( "\\    /\\\r\n )  ( ')\r\n(  /  )\r\n \\(__)|" ); 이렇게 했는데
			출력 형식이 잘못됐다는 오류가 남 ㅠ 그래서 .. 절케 함..
 *
 */
public class _10171 {
	public static void main(String args[]) throws IOException{
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		try{
			bw.write( "\\    /\\" );
			bw.newLine();
			bw.write( " )  ( ')" );
			bw.newLine();
			bw.write( "(  /  )" );
			bw.newLine();
			bw.write( " \\(__)|" );
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			bw.flush();
			bw.close();
		}
	}
}
