package _1_DataStructure.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**

@문제
	알파벳 소문자로만 이루어진 단어 S가 주어진다.
	각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
@입력
	첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
	baekjoon
@출력
	각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.
	만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.
	1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
@HISTORY

 */
public class p8_10809 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter	bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[]	word	= br.readLine().toCharArray();
		// -1로 초기화 되면 시키고 안되면은 추력할 떄 그냥 한꺼번에 -1 출력되게 하기. 그리고 queue에다가 차례대로 넣으면 순서대로 빠지는거니까 그냥 그거대로 값 늘리면 될 것 같다!
		int[]			alpabet	= new int[26];
		
		for( int i=0;i<26;i++ ){
			alpabet[i] = -1;
		}
		
		for( int i=0;i<word.length;i++ ){
			//97~121
			int value = alpabet[word[i]-97];
			if( value!=-1 ){
				alpabet[word[i]-97]=value;
				continue;
			}
			alpabet[word[i]-97]=i;
		}
		
		
		/*for( int i=0;i<word.length;i++ ){
			//97~121
			int value = alpabet[word[i]-97];
			if( value!=0 ){
				alpabet[word[i]-97]=value;
				continue;
			}
			alpabet[word[i]-97]=i;
		}*/
		
		for( int i : alpabet ){
			bw.write(i+" ");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}

