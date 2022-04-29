package _1_DataStructure.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

/**

@문제
	오등큰수
	
	크기가 N인 수열 A = A1, A2, ..., AN이 있다.
	수열의 각 원소 Ai에 대해서 오등큰수 NGF(i)를 구하려고 한다.
	Ai가 수열 A에서 등장한 횟수를 F(Ai)라고 했을 때, Ai의 오등큰수는 오른쪽에 있으면서 수열 A에서 등장한 횟수가 F(Ai)보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다.
	그러한 수가 없는 경우에 오등큰수는 -1이다.
	예를 들어, A = [1, 1, 2, 3, 4, 2, 1]인 경우 F(1) = 3, F(2) = 2, F(3) = 1, F(4) = 1이다. -> 1은 3번, 2는 2번, 3은 1번,4는 1번
	A1의 오른쪽에 있으면서 등장한 횟수가 3보다 큰 수는 없기 때문에, NGF(1) = -1이다. A3의 경우에는 A7이 오른쪽에 있으면서 F(A3=2->2) < F(A7=1->3) 이기 때문에, NGF(3) = 1이다.
	NGF(4) = 2, NGF(5) = 2, NGF(6) = 1 이다.
	
@입력
	첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.
	7
	1 1 2 3 4 2 1

@출력
	총 N개의 수 NGF(1), NGF(2), ..., NGF(N)을 공백으로 구분해 출력한다.
	-1 -1 1 2 2 1 -1
	
@HISTORY
	일단 수열 A에서 등장한 횟수(=F(Ai))를 구한다. 근데 이거를 쉽게 접근하기 위해서 횟수를 A 배열의 값의 위치와 같게 위치시킴
	시행착오 1> 시간초과
	처음에는 방문 여부 배열을 써서 반복문이 처리되는 횟수를 줄이려고 했는데
	오히려 인덱스를 조회해서 값을 가져오는 시간이 더 걸리나보다..
	그것도 아녔음..
	횟수 배열 F 구하는 반복문 안에서 현재 인덱스 이후의 요소 탐색 반복문 + 중복된 인덱스 담는 스택 비우는 반복문
	두가지를 해서 그런지 자꾸 시간초과가 났따..
	하루 내내 고민을 해봐도 답이 안나오길래 rawArr의 위치마다 횟수를 입력시키는 배열은 무리인 것 같아서
	그냥 해당 값을 인덱스로 쓰는 cntArr2를 만듦(지금은 cntArr로 바꿈)
	시간초과가 계쏙 난다..
	아.. 회수 배열 F 구하는 거에서 이중 포문말고 그 값을 인덱스로 씀으로써 해결!
	
	시행착오 2> 런타임 에러 (ArrayIndexOutOfBounds)
	시간초과는 해결했는데 인덱스 초과 에러가 났따..
	cntArr의 크기를 cnt만큼했는데 나는 cntArr의 인덱스로 해당 인덱스의 값으로 쓰도록 했었는데
	생각해보니까 수열의 값으로 cnt 보다 큰 숫자를 입력할 수 있으므로 cnt 보다 더 큰 인덱스로 줘야했음..!!!
	
	시행착오 3> 메모리 초과
	cntArr 배열의 크기를 Integer.MAX_VALUE로 줬었는데 너무 커서 그랬나보다
	문제에 주어진 범위인 1000000보다 큰 1000001로 줌으로써 해결
	
	코드리뷰 >
	오른쪽에 있는 수가 기준이니까 Stack 2개를 쓸 필요 없이 deque로 풀면 더 간단하겠다..
	
 */	
public class p4_17299_v2 {
	public static void main(String args[]) throws IOException {
		BufferedReader 	br		= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw		= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int				cnt		= Integer.parseInt( br.readLine() );
		
		StringTokenizer st		= new StringTokenizer( br.readLine() );
		
		int[]			rawArr	= new int[cnt];
		int[]			cntArr	= new int[1000001];
		int[]			NGF		= new int[cnt]; // 오등큰수 배열
		
		for( int i=0;i<cnt;i++ ){
			rawArr[i]=Integer.parseInt( st.nextToken() );
		}
		
		// 횟수 배열 F 구하기
		for( int i=0;i<cnt;i++ ){
			cntArr[rawArr[i]]++;
		}
		
		
		// 오등큰수 구하기
		
		/*
		// 1. Stack 2개로 구현  ----------------------------------------------------------------
		Stack<Integer>	stack	= new Stack<Integer>(); // Ai 조회하는 Stack
		Stack<Integer>	stack2	= new Stack<Integer>(); // Ai의 인덱스 Stack

		//stack.push(rawArr[0]); // rawArr[0]의 값을 인덱스로 쓴다. 그러면 cntArr2[값]에서 값에 해당되는 횟수를 바로 가져옴 
		//stack2.push(0); // rawArr[0]의 값을 가진 인덱스. 즉, 0

		for( int i=0;i<cnt;i++ ){
			int curValue = rawArr[i];
			while( !stack.isEmpty() && cntArr[curValue] > cntArr[stack.peek()] ){
				NGF[stack2.pop()] = curValue;
				stack.pop();
			}
			stack.push(curValue);
			stack2.push(i);  
		}
		
		while( !stack2.isEmpty() ){
			NGF[stack2.pop()] = -1;
		}
		*/
		// -------------------------------------------------------------------------------------
		
		
		// 2. deque로 구현 ---------------------------------------------------------------------
		Deque<Integer>	deque	= new LinkedList<Integer>();
		
		deque.offer(rawArr[cnt-1]);
		NGF[cnt-1] = -1;
		
		for( int i=cnt-2;i>=0;i-- ){
			int curValue = rawArr[i];
			while( !deque.isEmpty() && cntArr[curValue] >= cntArr[deque.getLast()] ){
				deque.pollLast();
			}
			
			if( deque.isEmpty() ){
				NGF[i] = -1;
			}else{
				NGF[i] = deque.getLast();
			}
			
			deque.offer( curValue );
		}
		
		// -------------------------------------------------------------------------------------
		
		for( int i : NGF ){
			bw.write( i + " " );
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}





















































