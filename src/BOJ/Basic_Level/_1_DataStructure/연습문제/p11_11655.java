package Basic_Level._1_DataStructure.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**

@문제
	ROT13은 카이사르 암호의 일종으로 영어 알파벳을 13글자씩 밀어서 만든다.
	예를 들어, "Baekjoon Online Judge"를 ROT13으로 암호화하면 "Onrxwbba Bayvar Whqtr"가 된다.
	ROT13으로 암호화한 내용을 원래 내용으로 바꾸려면 암호화한 문자열을 다시 ROT13하면 된다.
	앞에서 암호화한 문자열 "Onrxwbba Bayvar Whqtr"에 다시 ROT13을 적용하면 "Baekjoon Online Judge"가 된다.
	ROT13은 알파벳 대문자와 소문자에만 적용할 수 있다. 알파벳이 아닌 글자는 원래 글자 그대로 남아 있어야 한다.
	예를 들어, "One is 1"을 ROT13으로 암호화하면 "Bar vf 1"이 된다.
	문자열이 주어졌을 때, "ROT13"으로 암호화한 다음 출력하는 프로그램을 작성하시오.
@입력
	첫째 줄에 알파벳 대문자, 소문자, 공백, 숫자로만 이루어진 문자열 S가 주어진다. S의 길이는 100을 넘지 않는다.
	1. Baekjoon Online Judge
	2. One is 1
@출력
	첫째 줄에 S를 ROT13으로 암호화한 내용을 출력한다.
	1. Onrxwbba Bayvar Whqtr
	2. Bar vf 1
@HISTORY
	지금 글자의 다음 글자부터 13 카운팅
	
	남 거--- 절반으로 함
	 for(int i = 0 ; i < arr.length; i++) {
		if(arr[i] >=110) sb.append((char)(arr[i]-13));		n
		else if(arr[i] >=97) sb.append((char)(arr[i]+13));
		else if(arr[i] >=78) sb.append((char)(arr[i]-13));	N
		else if(arr[i] >=65) sb.append((char)(arr[i]+13)); 
		else sb.append(arr[i]);
	}
	
 */
public class p11_11655 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter	bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder result = new StringBuilder();
		
		for( int word : br.readLine().toCharArray() ){
			char dd = 110;
			char dd2 = 78;
			if( word>64 ){
				int maxWord = 90;
				int minWord = 65;
				if(word>96 && word<123){
					maxWord = 122;
					minWord = 97;
				}
				
				int transWord = word+13;
				if( transWord>maxWord ){
					transWord = minWord+(transWord-maxWord-1);
				}
				
				result.append((char)transWord);
				continue;
			}
			result.append((char)word);
		}
		bw.write(result.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
}

