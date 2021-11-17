package _1_DataStructure.Deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
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
	2가지 방법으로 풀었다.
	1. Deque 직접 구현
	2. Deque 클래스를 통해 구현
	
	1 - 계쏙 틀렸다고 나온다..개빡침. 뭐가 문젠지 모르겠음^^ 며칠을 고민했는지 모르겠다. 나중에 시간 나면 꼭....제발...,,,해결해보기,,,
	2 - 이 방법으로는 해결했따.
	deque.peekFirst() / deque.peekLast()로 null 구분 했었는데 남이 한 코드 중에서 isEmpty로 검사하는 걸 보고 이거로 바꾸니까 시간도 훨 단축됐다. 
*/

public class deque_1_10866 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(	new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );

		// 1. Deque 직접 구현
		deque deque = new deque();
		// 2. Deque 클래스 이용
		// Deque<Integer> deque = new LinkedList<Integer>(); 
		
		int cnt = Integer.parseInt( br.readLine() );
		
		while( cnt-->0 ) {
			StringTokenizer st	= new StringTokenizer( br.readLine() );
			String			cmd = st.nextToken();
			
			// 1. Deque 직접 구현.
			switch( cmd ) {
				case "push_front" :
					deque.push_front( Integer.parseInt(st.nextToken()) );
					bw.flush();
					break;
				case "push_back" :
					deque.push_back( Integer.parseInt(st.nextToken()) );
					bw.flush();
					break;
				case "pop_front" :
					bw.write( deque.pop_front()+"\n" );
					bw.flush();
					break;
				case "pop_back" :
					bw.write( deque.pop_back()+"\n" );
					bw.flush();
					break;
				case "size" :
					bw.write( deque.size()+"\n" );
					bw.flush();
					break;
				case "empty" :
					bw.write( deque.empty()+"\n" );
					bw.flush();
					break;
				case "front" :
					bw.write( deque.front()+"\n" );
					bw.flush();
					break;
				case "back" :
					bw.write( deque.back()+"\n" );
					bw.flush();
					break;
			}

		// 2. Deque 클래스 이용
		/*
			switch( cmd ) {
				case "push_front" :
					deque.addFirst( Integer.parseInt(st.nextToken()) );
					bw.flush();
					break;
				case "push_back" :
					deque.addLast( Integer.parseInt(st.nextToken()) );
					bw.flush();
					break;
				case "pop_front" :
					bw.write( deque.peekFirst()==null ? -1+"\n" : deque.pollFirst() +"\n" ); //deque.peekFirst() 대신 isEmpty()로
					bw.flush();
					break;
				case "pop_back" :
					bw.write( deque.peekLast()==null ? -1+"\n" : deque.pollLast() +"\n" );
					bw.flush();
					break;
				case "size" :
					bw.write( deque.size()+"\n" );
					bw.flush();
					break;
				case "empty" :
					bw.write( deque.isEmpty() ? 1 +"\n" : 0 +"\n" );
					bw.flush();
					break;
				case "front" :
					bw.write( deque.peekFirst()==null ? -1+"\n" : deque.peekFirst()+"\n" );
					bw.flush();
					break;
				case "back" :
					bw.write( deque.peekLast()==null ? -1+"\n" : deque.peekLast()+"\n" );
					bw.flush();
					break;
			}
		*/
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}

class deque {
	List<Integer> deque;
	int front,back,idx;
	
	public deque() {
		this.deque	= new LinkedList<Integer>();
		this.front	= 0;
		this.back	= 0;
		this.idx	= 0; // 새로운 dt가 들어갈 idx (포인터역할)
	}
	
	public void push_front(int x) {
		deque.add(x);
		front = x;
		if( back==0 ) {
			back = x;
		}
		idx++;
	}
	
	public void push_back(int x) {
		deque.add( idx++, x );// idx= 1. idx%size= 1/15 = 1 -> 뒤에서추가되어야하는인덱스
		back = x;
		if( front==0 ) {
			front = x;
		}
	}
	
	public int pop_back() {
		int result = 0;
		
		if( idx==0 ) {
			result = -1;
		}else {
			if( --idx == 0 ) {
				front	= 0;
				back	= 0;
			}else {
				back	= deque.get(1);
			}
			result	= deque.remove(0);
		}
		return result;
	}
	
	public int pop_front() {
		int result = 0;
		
		if( idx==0 ) {
			result = -1;
		}else {
			if( (idx-1) == 0 ) {
				front	= 0;
				back	= 0;
			}else {
				front	= deque.get(idx-2);
			}
			result	= deque.remove(--idx);
		}
		return result;
	}
	
	public int size() {
		return idx;
	}
	
	public int empty() {
		return idx==0 ? 1 : 0;
	}
	
	public int front() {
		return front==0 ? -1 : front;
	}
	
	public int back() {
		return back==0 ? -1 : back;
	}
	
}
