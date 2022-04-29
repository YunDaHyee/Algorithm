/**
 * 
 */
package StepBystep._1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
	@Question
		Hello World!를 출력하시오.
	@Input
	@Output
		Hello World!
	@history
 *		
 */
public class _2557 {
	public static void main(String args[]) throws IOException {
		// 입출력이 많지 않으니 이거로 해도 될 것 같다.
		// System.out.println("Hello world!");
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		bw.write("Hello world!");
		bw.flush();
		bw.close();
	}
}
