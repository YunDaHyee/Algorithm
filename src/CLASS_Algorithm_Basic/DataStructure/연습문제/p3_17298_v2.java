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
		BufferedWriter	bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int				cnt		= Integer.parseInt( br.readLine() );
		
		String[] 		arr 	= new String[cnt];
		StringBuilder	sb		= new StringBuilder();
		Stack<Integer>	stack	= new Stack<Integer>();
		
		arr = br.readLine().split(" ");
		
		int curNum = Integer.parseInt(arr[0]);
		stack.push(curNum);
		
		while(stack.isEmpty()){
			
		};
		
		for( int i=0;i<cnt;i++ ){
			curNum = Integer.parseInt(arr[i]);
			boolean flag = false;
			for( int j=i+1;j<cnt;j++ ){
				int pushNum = 0;
				int peekNum = Integer.parseInt(arr[j]);
				if( curNum < peekNum ){
					pushNum = peekNum;
				}else {
					if( !stack.isEmpty() ){
						stack.pop();
					}
					stack.push(curNum);
					pushNum = curNum;
				}
				sb.append( pushNum+" " );
			}
			if( i!=cnt-1 ){
				int peekNum = stack.peek();
				int pushNum = 0;
				if( curNum < peekNum ){
					pushNum = peekNum;
				}else{
					stack.pop();
					stack.push(curNum);
					pushNum = curNum;
				}
				sb.append( pushNum+" " );
			}else{
				sb.append(-1);
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}
}






























