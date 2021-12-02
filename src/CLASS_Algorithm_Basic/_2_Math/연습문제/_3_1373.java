/**
 * 
 */
package _2_Math.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
	@문제
		2진수가 주어졌을 때, 8진수로 변환하는 프로그램을 작성하시오.
	@입력
		첫째 줄에 2진수가 주어진다.
		주어지는 수의 길이는 1,000,000을 넘지 않는다.
		11001100
	@출력
		첫째 줄에 주어진 수를 8진수로 변환하여 출력한다.
		314
	@HISTORY
		몫, 나머지 다 구했었는데 안구해도 될 듯..
		그냥 그거에 따라서 앞에 0이 몇개 붙고 안붙고 차이기 때문에
		0만 string으로 붙여버리면 됐었다.
	@Date
		2021. 11. 29.
 */

public class _3_1373 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br	= new BufferedReader( new InputStreamReader(System.in) );
		
		StringBuilder	result	= new StringBuilder();
		String			raws	= br.readLine();
		
		switch(raws.length()%3){
			case 1:
				raws = "00"+raws; // 셋째자리만 값이 있는거니까 2의 0승인 1만 곱해주면 되니까
				break;
			case 2:
				raws = "0"+raws; // 그치 둘째 자리는 2의 1승이니까 2만 곱함 되고 마지막 자리는 2의 0승 곱하는거니까 그 자리만 곱함 되지..
				break;
		}
		
		for (int i = 0; i < raws.length(); i += 3) {
			// 각 자리마다 2의 2승(=4), 1승(=2), 0승(=1)을 곱해주는 것.
			result.append(
					(int)
					(
						(raws.charAt(i)-'0') * 4
						+ (raws.charAt(i+1)-'0') * 2
						+ raws.charAt(i + 2)-'0'
					)
			);
		}
		
		System.out.print(result);
		
		br.close();
	}
	
}
