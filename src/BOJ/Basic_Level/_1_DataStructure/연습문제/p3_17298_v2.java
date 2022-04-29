package Basic_Level._1_DataStructure.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
@문제
	오큰수
	
	크기가 N인 수열 A = A1, A2, ..., AN이 있다.
	수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다.
	Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다.
	그러한 수가 없는 경우에 오큰수는 -1이다.
	예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다.
	A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.
	
@입력
	첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.
	둘째에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.
	4
	3 5 2 7
	
	4
	9 5 4 8

@출력
	총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.
	5 7 7 -1
	-1 8 8 -1
	
@HISTORY
	이 문제를 해결하려면 오큰수가 없는 값의 인덱스를 넣어야 했는데
	값을 넣고 그 자체로 비교를 하다보니 스택 처리가 조금 까다롭게 느껴졌다.
	split으로 처리하고 매번 반복문을 돌면서 Integer로 파싱하는 작업 하는 것
		VS
	StringTokenizer로 처리하고 처음에 한번만에 파싱해주고 넘겨주는 것
	별 거 아니지만 메모리적으로 좀 더 나은 성능을 보였다.
	
*/
public class p3_17298_v2 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br		= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw		= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		
		int				cnt		= Integer.parseInt( br.readLine() ); // 횟수
		
		int[] 			arr 	= new int[cnt]; // 숫자 배열
		//String[] 		arr 	= new String[cnt]; // 숫자 배열
		
		StringTokenizer st		= new StringTokenizer( br.readLine() );
		
		long beforeTime = System.currentTimeMillis();
		
		for(int i = 0;i<cnt;i++ ){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//arr = br.readLine().split(" ");
		
		// 2. Stack 이용해서 풀기
		Stack<Integer>	stack	= new Stack<Integer>();
		int[]			NGE		= new int[cnt];
		
		stack.push(0);
		for( int i=1;i<cnt;i++ ){
			//int curNum = Integer.parseInt( st.nextToken() );
			int curNum = arr[i];
			while( !stack.isEmpty() && curNum > arr[stack.peek()] ){
				NGE[stack.pop()] = curNum;
			}
			stack.push(i);
		}
		
		while( !stack.isEmpty() ){
			NGE[stack.pop()] = -1;
		}
		
		for( int i : NGE ){
			bw.write(i +" ");
		}
		
		long estimatedTime = System.currentTimeMillis() - beforeTime;
		System.out.println();
		System.out.println("걸린 시간 : " + estimatedTime/1000.0 + " milli seconds");
		
		/*
		// 1. 배열로만 풀기
		StringBuilder	sb		= new StringBuilder();
		for( int i=0;i<=cnt-1;i++ ){
			int curNum = Integer.parseInt(arr[i]); // 현재 숫자 - 3 5
			boolean flag = false;
			for( int j=i+1;j<=cnt-1;j++ ){
				int peekNum = Integer.parseInt(arr[j]); // 5 2
				if( curNum < peekNum ){
					flag = true;
 					sb.append( peekNum );
					break;
				}
			}
			if( !flag ){
				sb.append( -1 );
			}
			
			if( i!=cnt-1 ){
				sb.append(" ");
			}
		}
		 */
		
		bw.flush();
		bw.close();
		br.close();
	}
}






























