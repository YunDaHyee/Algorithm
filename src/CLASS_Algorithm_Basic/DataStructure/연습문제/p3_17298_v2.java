package DataStructure.연습문제;

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
	
*/
public class p3_17298_v2 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br = new BufferedReader( new InputStreamReader(System.in) );
		
		int				cnt		= Integer.parseInt( br.readLine() );
		
		String[] 		arr 	= new String[cnt];
		StringBuilder	sb		= new StringBuilder();
		
		arr = br.readLine().split(" ");
		
		/*
		// 1. 배열로만 풀기
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
		
		// 2. Stack 이용해서 풀기
		Stack<Integer> stack = new Stack<Integer>();
		
		for( int i=arr.length-1;i>=0;i-- ){
			stack.push( Integer.parseInt(arr[i]) );
		}
		int idx = 1;
		// 전체 수 자체는 스택으로 풀 수 있찌만 안에 숫자들을 접근할 떄는 배열로 해야한다..
		// pop을 해서 숫자가 없는데 어떻게 비교를 해요!!
		// 근데 결국 stack을 써도 idx를 쓰는데 의미가 있느가 싶다ㅠ
		// TODO 인덱스 넣는거로 방식 확인하기
		while( !stack.isEmpty() ){
			int popNum = stack.pop(); // 5
			boolean flag = false;
			for( int i=idx;i<cnt;i++ ){
				int peekNum = Integer.parseInt(arr[i]); // 5 2
				if( popNum < peekNum ){
					flag = true;
 					sb.append( peekNum );
					break;
				}
			}
			if( !flag ){
				sb.append( -1 );
			}
			
			if( !stack.isEmpty() ){
				sb.append(" ");
			}
			idx++;
		} // while
		
		/*
		int dupleCnt = 1;
		if( stack.size()!=0 ){
			int peekNum = stack.peek();
			while( true ){
				dupleCnt++;
				stack.pop(); // 5
				if( stack.size()!=0 ){
					peekNum = stack.peek();
				}else{
					break;
				}
				if( popNum < peekNum ){
					flag = true;
					break;
				}
			}
			if( flag ){
				for( int i=0;i<dupleCnt;i++ ) {
					sb.append( peekNum+" " );
				}
			}else{
				sb.append(-1);
			}
		}
		*/
		
		System.out.println(sb);
		
		br.close();
	}
}






























