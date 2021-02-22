package DataStructure.Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

/**
 * 
	@Question
		정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
		명령은 총 여섯 가지이다.
		push X: 정수 X를 큐에 넣는 연산이다.
		pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		size: 큐에 들어있는 정수의 개수를 출력한다.
		empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
		front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	@Input
		첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
		둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
		주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
		문제에 나와있지 않은 명령이 주어지는 경우는 없다.
		15
		push 1
		push 2
		front
		back
		size
		empty
		pop
		pop
		pop
		size
		empty
		pop
		push 3
		empty
		front
	@Output
		출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
		1
		2
		2
		0
		1
		2
		-1
		0
		1
		-1
		0
		3
	@History
		1. Queue 직접 구현
			결과가 똑같이 나오는데 왜 틀리는지 한참을 고민했따..
			진짜 뭐지 싶었는데 한 가지 걸렸떤 게
			switch문에서 push 연산할 때는 default로 둬서 처리하게끔 했는데
			온갖 입력들까지도 거기로 들어가서 틀렸다고 뜬 것 같다.
			역시나 이걸 수정해주니 됐다.
			
		2. Queue 클래스를 활용해서 구현
 *
 */
public class queue_1_10845_v2 {
	static int[]		queue	= null;
	static int			begin	= 0;
	static int			end		= 0;
	
	static LinkedList<Integer> queue2 = null;
	
	public static void main(String args[]) throws IOException {
		BufferedReader	br		= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw		= new BufferedWriter( new OutputStreamWriter(System.out) );
		int				cmdCnt	= Integer.parseInt( br.readLine() );
		
		// 1. 1차원 배열로 구현
		/* queue = new int[cmdCnt]; */
		
		// 2. Queue 클래스 이용
		queue2 = new LinkedList<Integer>();
		
		while( cmdCnt-->0 ) {
			String[] cmd = br.readLine().split(" ");
			switch( cmd[0] ) {
				case "push" :
					push( cmd[1] );
					break;
				case "pop" :
					bw.write( pop()+"\n" );
					break;
				case "size" :
					bw.write( size()+"\n" );
					break;
				case "empty" :
					bw.write( empty()+"\n" );
					break;
				case "front" :
					bw.write( front()+"\n" );
					break;
				case "back" :
					bw.write( back()+"\n" );
					break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

// 1. 1차원 배열로 구현
/*
	public static void push(String num) {
		queue[end++] = Integer.parseInt(num);
	}
	public static String pop() {
		int reuslt = 0;
		if( empty()=="0" ) {
			reuslt = queue[begin];
			queue[begin++] = 0;
		}else {
			reuslt = -1;
		}
		return String.valueOf(reuslt);
	}
	public static String size() {
		return String.valueOf(end-begin);
	}
	public static String empty() {
		return begin==end ? "1" : "0";
	}
	public static String front() {
		return empty()=="1" ? "-1" : String.valueOf(queue[begin]);
	}
	public static String back() {
		return empty()=="1" ? "-1" : String.valueOf(queue[end-1]);
	}
*/
	
	public static void push(String num) {
		queue2.addLast( Integer.parseInt(num) );
	}
	public static String pop() {
		int reuslt = 0;
		if( queue2.size()!=0 ) {
			reuslt = queue2.pollFirst();
		}else {
			reuslt = -1;
		}
		return String.valueOf(reuslt);
	}
	public static String size() {
		return String.valueOf(queue2.size());
	}
	public static String empty() {
		return queue2.isEmpty() ? "1" : "0";
	}
	public static String front() {
		return empty()=="1" ? "-1" : String.valueOf( queue2.peekFirst() );
	}
	public static String back() {
		return empty()=="1" ? "-1" : String.valueOf( queue2.peekLast() );
	}
}
