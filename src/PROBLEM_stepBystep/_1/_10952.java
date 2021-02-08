/**
 * 
 */
package _1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
	@Question
		두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
	@Input
		입력은 여러 개의 테스트 케이스로 이루어져 있다.
		각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
		입력의 마지막에는 0 두 개가 들어온다.
		1 1
		2 3
		3 4
		9 8
		5 2
		0 0
	@Output
		각 테스트 케이스마다 A+B를 출력한다.
		2
		5
		7
		17
		7
	@history
		1년 전에는 반복문 들어가기 전에 1회차 입력을 먼저 받고 반복문 안에서는 마지막 쯤에 입력을 받는 거루 했다.
		그렇게 할까 하다가 두번의 입력문이 들어가는 게 중복되는 느낌이어서 퐘하는 거로다가 했는데 흠.. 뭐가 더 효율적일까
		근데 그렇게 시간차가 크게 날 것 같진 않으니까 중복이 되지 않는 거로 가야겠다.
 *		
 */
public class _10952 {
	public static void main(String[] args) throws IOException {
		BufferedReader	br	= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw	= new BufferedWriter( new OutputStreamWriter(System.out) );
		StringTokenizer st	= null;
		
		while(true){
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			if( num1==0 && num2==0 ) {
				break;
			}
			bw.write( String.valueOf(num1 + num2)+"\n" );
		}
		
		bw.flush();
		br.close();
		bw.close();
	}

}
