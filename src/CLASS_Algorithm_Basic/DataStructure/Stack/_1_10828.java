/**
 * 
 */
package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
	@문제
		단순 Stack 구현
		정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
		명령은 총 다섯 가지이다.
		push X	: 	정수 X를 스택에 넣는 연산이다.
		pop		:	스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다.
					만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		size	:	스택에 들어있는 정수의 개수를 출력한다.
		empty	:	스택이 비어있으면 1, 아니면 0을 출력한다.
		top		:	스택의 가장 위에 있는 정수를 출력한다.
					만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		
	@입력
		첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
		둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
		주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
		문제에 나와있지 않은 명령이 주어지는 경우는 없다.
	
	@출력
		출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
		
	@HISTORY
		남들 코드 본 뒤 수정한 점 : StringTokenizer, clean code
 */

public class _1_10828 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw			= new BufferedWriter( new OutputStreamWriter(System.out) );
		StringTokenizer	rawCommand	= null;
		
		int				commandCnt	= Integer.parseInt(br.readLine());
		
		Stack<Integer>	stack		= new Stack<Integer>();
		
		while( commandCnt-->0 ) {
			rawCommand 		= new StringTokenizer( br.readLine() );
			String	command	= rawCommand.nextToken();
			boolean flag	= stack.empty();	
			
			switch( command ) {
				case "pop" :
					if( !flag ) { 
						bw.write( stack.pop() + "\n" );
					}else {
						bw.write("-1\n");
					}
					bw.flush();
					break;
				case "size" :
					bw.write( stack.size() + "\n" );
					bw.flush();
					break;
				case "empty" :
					if( flag ) { 
						bw.write( "1\n" );
					}else {
						bw.write( "0\n" );
					}
					bw.flush();
					break;
				case "top" :
					if( !flag ) { 
						bw.write( stack.peek() + "\n" );
					}else {
						bw.write( "-1\n" );
					}
					bw.flush();
					break;
				case "push" :
					int numX = Integer.parseInt( rawCommand.nextToken() );
					stack.push(numX);
					break;
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}

class stack {
	/*
	내가 한 것
	BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
	int top;
	int size;
	int stack[];
	
	public stack(int commandCnt) {
		top = -1;
		stack = new int[commandCnt];
	}
	
	public void pop() throws IOException {
		if( top==-1 ) {
			bw.write("-1\n");
		}else {
			bw.write( String.valueOf(stack[top--]+"\n") );
		}
		bw.flush();
	}
	
	public void size() throws IOException {
		if( top==-1 ) {
			size = 0;
		}else {
			size = top+1;
		}
		bw.write( String.valueOf(size)+"\n" );
		bw.flush();
	}
	
	public void empty() throws IOException {
		if( top==-1 ) {
			bw.write( "1\n" );
		}else {
			bw.write( "0\n" );
		}
		bw.flush();
		
	}
	
	public void top() throws IOException {
		if( top==-1 ) {
			bw.write( "-1\n" );
		}else {
			bw.write( stack[top]+"\n");
		}
		bw.flush();
	}
	
	public void push(int i) throws IOException {
		stack[++top] = i;
		bw.flush();
	}
	*/
	/* 남 코드 보고 수정
	int top;
	int stack[];
	
	public stack(int commandCnt) {
		this.top = -1;
		this.stack = new int[commandCnt];
	}
	
	public int pop() {
		return top==-1 ? -1 : stack[top--];
	}
	
	public int size() {
		return top+1;
	}
	
	public int empty() {
		return top==-1 ? 1 : 0;
	}
	
	public int top() {
		return top==-1 ? -1 : stack[top];
	}
	
	public void push(int i){
		stack[++top] = i;
	}
	*/
}
