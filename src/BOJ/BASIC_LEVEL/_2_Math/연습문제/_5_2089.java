/**
 * 
 */
package BASIC_LEVEL._2_Math.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
	@문제
		-2진법은 부호 없는 2진수로 표현이 된다.
		표기 : 지수지수승 순임
		2진법에서는 20, 21, 22, 23이 표현 되지만
		-2진법에서는 (-2)0 = 1, (-2)1 = -2, (-2)2 = 4, (-2)3 = -8을 표현한다.
		10진수로 1부터 표현하자면 1, 110, 111, 100, 101, 11010, 11011, 11000, 11001 등이다.
		10진법의 수를 입력 받아서 -2진수를 출력하는 프로그램을 작성하시오.
	@입력
		첫 줄에 10진법으로 표현된 수 N이 주어진다.
		-13
	@출력
		-2진법 수를 출력한다.
		110111
	@HISTORY
		<음의 10진수를 2의보수로 나타내기>
		1.	10진법으로 나타나있는 수의 절대값을 8비트로 만들고
			음수이기 때문에 첫 번째 부호비트를 1로 바꾼다.
		2. 1의 보수로 변환(:부호비트는 제외하고 0은 1로, 1은 0로 바꿔준다.) ex) -4: 1111 1011
		3. 2의 보수로 변환(:+0000 0001)
		
		음의 10진수--변환-->2진수 방법을 잘몰라서 검색하다가 나온 2의 보수 변환법대로 풀다가
		이 풀이법으로는 도저히 나올 수 있는 값이 아니다 싶어서 다른 사람의 풀이법을 참조했다.
		
		 -13	= (-2*7)+1
		 7		= (-2*-3)+1
		 -3		= (-2*2)+1
		 
		 나눠떨어지지 않았을 경우, 나머지는 항상 양수여야 하므로
		 값 == (값/-2의 소수점은 버리고 정수부분을 +1 해주는 것)
	@Date
		2021. 12. 02.
 */

public class _5_2089 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );

		//Stack<Integer>	result	= new Stack<Integer>();
		StringBuilder	result	= new StringBuilder();
		int				demical = Integer.parseInt(br.readLine());
		
		if( demical==0 ){
			System.out.println(0);
			return;
		}
		
		while( demical!=1 ){
			//result.push(Math.abs(demical%-2));
			result.append(Math.abs(demical%-2));
			demical = (int) Math.ceil(demical/-2.0);
		}
		
		System.out.println("1"+result.reverse());
		
		/*
		System.out.print(1);
		
		while( !result.isEmpty() ){
			System.out.print( result.pop() );
		}*/
		

		br.close();
	}
}
