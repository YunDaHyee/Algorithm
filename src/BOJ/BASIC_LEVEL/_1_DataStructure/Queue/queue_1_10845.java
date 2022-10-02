package Basic_Level._1_DataStructure.Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
		2. Queue 클래스를 활용해서 구현
		O(1)로 짜도록 유의해서 해야지! bw.write안에서 바로 삼항연산자를 쓸 수 있다!
		queue도 스택의 일종이니까 LinkedList 또는 ArrayList를 통해 구현 가능하다.
 *
 */
public class queue_1_10845 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader	br		= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw		= new BufferedWriter( new OutputStreamWriter(System.out) );
		int				cnt		= Integer.parseInt( br.readLine() );
		
		// 1. 직접 만든 queue 클래스 객체 생성 후 호출해서 구현.
		/*
			queue			queue	= new queue( cnt );
			
			while( cnt-->0 ) {
				StringTokenizer st		= new StringTokenizer( br.readLine() );
				String			command	= st.nextToken();
				
				switch( command ) {
					case "push":
						int num = Integer.parseInt( st.nextToken() );
						queue.push(num);
						break;
					case "pop":
						bw.write( String.valueOf(queue.pop())+"\n" );
						bw.flush();
						break;
					case "front":
						bw.write( String.valueOf(queue.front())+"\n" );
						bw.flush();
						break;
					case "back":
						bw.write( String.valueOf(queue.back())+"\n" );
						bw.flush();
						break;
					case "size":
						bw.write( String.valueOf(queue.size())+"\n" );
						bw.flush();
						break;
					case "empty":
						bw.write( String.valueOf(queue.empty())+"\n" );
						bw.flush();
						break;
				}
			}//while
		 */		
		// 2. Queue 클래스 이용
		Queue<Integer>	queue	= new LinkedList<Integer>(); // 굳이 Queue의 구현체 안써도 되고 LinkedList 써도 됨
		int				lastNum = 0;
		
		while( cnt-->0 ){
			StringTokenizer st		= new StringTokenizer( br.readLine() );
			String			command	= st.nextToken();
			switch( command ) {
				case "push" :
					int num = Integer.parseInt( st.nextToken() );
					lastNum = num;
					queue.add(num);
					break;
				case "pop" :
						bw.write( !queue.isEmpty() ? String.valueOf(queue.poll())+"\n" : "-1\n");
					break;
				case "front" :
						bw.write( !queue.isEmpty() ? String.valueOf(queue.peek())+"\n" : "-1\n" );
					break;
				case "back" :
						bw.write( !queue.isEmpty() ? String.valueOf(lastNum)+"\n" : "-1\n" );
					break;
				case "size" :
						bw.write( String.valueOf(queue.size())+"\n" );
					break;
				case "empty" :
						bw.write( !queue.isEmpty() ? "0\n" : "1\n" );
					break;
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}

//queue 직접 구현 -> 모든 연산이 O(1)에 가능
class queue { 
	Integer[] queue;
	int begin;
	int end;
	
	public queue(int cnt) {
		//this.queue = new PriorityQueue<Integer>(cnt);
		this.queue	= new Integer[cnt];
		this.begin	= 0;
		this.end	= 0;
	}
	
	public void push(int num) {
		queue[end++] = num;
	}
	
	public int pop() {
		int result = 0;
		
		if( begin==end ) {
			result = -1;
		}else {
			result = queue[begin];
			queue[begin++] = 0;
		}
		return result;
	}
	
	public int front() {
		int result = 0;
		
		if( begin==end ) {
			result = -1;
		}else {
			result = queue[begin];
		}
		return result;
	}
	
	public int back() {
		int result = 0;
		
		if( begin==end ) {
			result = -1;
		}else {
			result = queue[end-1];
		}
		return result;
	}
	
	public int size() {
		//return begin==end ? 0 : end;
		return end-begin;
	}
	
	public int empty() {
		//return size()==0 ? 1 : 0;
		return begin==end ? 1 : 0;
	}
}
