package Basic_Level._1_DataStructure.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**

@문제
	접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열이다.
	baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지가 있고,
	이를 사전순으로 정렬하면, aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.
	문자열 S가 주어졌을 때, 모든 접미사를 사전순으로 정렬한 다음 출력하는 프로그램을 작성하시오.
@입력
	첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000보다 작거나 같다.
	baekjoon
@출력
	첫째 줄부터 S의 접미사를 사전순으로 한 줄에 하나씩 출력한다.
	aekjoon
	baekjoon
	ekjoon
	joon
	kjoon
	n
	on
	oon
@HISTORY
	subString VS 이중포문
	속도에서의 승자는 함수라서 더 오래걸릴 줄 알았던 subString이었다.
	
	문자열로 받아서 Arrays 클래스의 sort로 처리하냐
	한번에 List로 받고 그 자체 내의 sort로 처리하냐는 거의 같은 듯 하다.
 */
public class p13_11656 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter	bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//List<String>	randomWord	= new ArrayList<String>();
		StringBuilder	result		= new StringBuilder();
		String			rawWord		= br.readLine();
		String[]		randomWord	= new String[rawWord.length()];
		
		for( int i=0;i<rawWord.length();i++ ){
			randomWord[i]=rawWord.substring(i);
		}
		
		Arrays.sort(randomWord);
		
		for(String word : randomWord){
			result.append(word+"\n");
		}
		
		bw.write(result.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
}

