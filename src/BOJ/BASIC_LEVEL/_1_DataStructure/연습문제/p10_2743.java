package BASIC_LEVEL._1_DataStructure.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**

@문제
	알파벳으로만 이루어진 단어를 입력받아, 그 길이를 출력하는 프로그램을 작성하시오.
@입력
	첫째 줄에 영어 소문자와 대문자로만 이루어진 단어가 주어진다. 단어의 길이는 최대 100이다.
	pulljima
@출력
	첫째 줄에 입력으로 주어진 단어의 길이를 출력한다.
	8
@HISTORY
 */
public class p10_2743 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter	bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(br.readLine().length()+"");
		
		br.close();
		bw.flush();
		bw.close();
	}
}

