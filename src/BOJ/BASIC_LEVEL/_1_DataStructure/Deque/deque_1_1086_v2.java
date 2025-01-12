package BASIC_LEVEL._1_DataStructure.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
@Question	
	정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
	
	명령은 총 여덟 가지이다.
	
	push_front X: 정수 X를 덱의 앞에 넣는다.
	push_back X: 정수 X를 덱의 뒤에 넣는다.
	pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	size: 덱에 들어있는 정수의 개수를 출력한다.
	empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
	front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	@Input
		첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
		둘쨰 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
		주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
		문제에 나와있지 않은 명령이 주어지는 경우는 없다.
	15
	push_back 1
	push_front 2
	front
	back
	size
	empty
	pop_front
	pop_back
	pop_front
	size
	empty
	pop_back
	push_front 3
	empty
	front
@출력
	출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
	2
	1
	2
	0
	2
	1
	-1
	0
	1
	-1
	0
	3
@HISTORY
*/

public class deque_1_1086_v2 {
	public static void main(String args[]) throws IOException {
		BufferedReader 	br	= new BufferedReader(	new InputStreamReader(System.in) );
		StringBuilder	sb	= new StringBuilder();
		String tempResult	= "";
		
		int cnt = Integer.parseInt( br.readLine() );
		
		// 1. LinkedList로 구현
		/*
			 ArrayDeque VS LinkedList 성능 차이
			- 양 끝의 데이터를 add / remove할 때 : ArrayDeque > LinkedList
			- 반복 작업에서 현재 요소를 삭제할 때 : ArrayDeque < LinkedList
		 */
		LinkedList<String> deque = new LinkedList<String>();
		
		while( cnt-->0 ){
			StringTokenizer cmd = new StringTokenizer( br.readLine() );
			switch( cmd.nextToken() ){
				case "push_front" :
					deque.offerFirst( cmd.nextToken() );
					break;
				case "push_back" :
					deque.offerLast( cmd.nextToken() );
					break;
				case "pop_front" :
					if( deque.isEmpty() ) {
						tempResult = "-1";
					}else {
						tempResult = deque.pollFirst();
					}
					sb.append( tempResult+"\n" );
					break;
				case "pop_back" :
					if( deque.isEmpty() ) {
						tempResult = "-1";
					}else {
						tempResult = deque.pollLast();
					}
					sb.append( tempResult+"\n" );
					break;
				case "size" :
					sb.append( deque.size()+"\n" );
					break;
				case "empty" :
					if( deque.isEmpty() ) {
						tempResult = "1";
					}else {
						tempResult = "0";
					}
					sb.append( tempResult+"\n" );
					break;
				case "front" :
					if( deque.isEmpty() ) {
						tempResult = "-1";
					}else {
						tempResult = deque.peekFirst();
					}
					sb.append( tempResult+"\n" );
					break;
				case "back" :
					if( deque.isEmpty() ) {
						tempResult = "-1";
					}else {
						tempResult = deque.peekLast();
					}
					sb.append( tempResult+"\n" );
					break;
			}
		}
		
		System.out.print( sb );
		
		br.close();
	}
}
