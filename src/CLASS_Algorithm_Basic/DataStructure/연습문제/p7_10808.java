package DataStructure.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**

@문제
	알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.
	
@입력
	첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
	baekjoon
@출력
	단어에 포함되어 있는 a의 개수, b의 개수, …, z의 개수를 공백으로 구분해서 출력한다.
	1 1 0 0 1 0 0 0 0 1 1 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0
@HISTORY

 */
public class p7_10808 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter	bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[]				rawWord		= br.readLine().split("{0}");
		Map<Character, Integer> wordCount	= new HashMap<Character, Integer>(25);
		
		/*
		for( int i=97;i<122;i++ ) {
			wordCount.put((char) i, 0);
		}
		
		for( int i=0;i<rawWord.length;i++ ) {
			char charWord	= rawWord[i].charAt(0);
			int beforeCount = wordCount.get(charWord);
			wordCount.put( charWord, ++beforeCount );
		}
		 */
		
		// 스택 버전
		Stack<Character> stack = new Stack<Character>();
		for( int i=0;i<rawWord.length;i++ ) {
			stack.push(rawWord[i].charAt(0));
		}
		while(!stack.isEmpty()) {
			char charWord	= stack.pop();
			if( wordCount.get(charWord)==null ) {
				wordCount.put(charWord,0);
			}else {
				int beforeCount = wordCount.get(charWord);
				wordCount.put( charWord, ++beforeCount );
			}
		}

		for( char i=97;i<123;i++ ) {
			if( wordCount.get(i)==null ) {
				bw.write(i,0);
			}else {
				int beforeCount = wordCount.get(charWord);
				wordCount.put( charWord, ++beforeCount );
			}
			
			bw.write(wordCount.get((char)i).toString());
			if( i==122 ) {
				break;
			}
			bw.write(" ");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}

