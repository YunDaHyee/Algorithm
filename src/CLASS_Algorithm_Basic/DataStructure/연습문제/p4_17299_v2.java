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
 */	
public class p4_17299_v2 {
	public static void main(String args[]) throws IOException {
		BufferedReader 	br	= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw	= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int				cnt = Integer.parseInt( br.readLine() );
		
		StringTokenizer st	= new StringTokenizer( br.readLine() );
		
		int[]			rawArr	= new int[cnt];
		int[]			cntArr	= new int[cnt];
		boolean[]		flagArr	= new boolean[cnt];
		Stack<Integer>	idxStack= new Stack<Integer>();
		
		for( int i=0;i<cnt;i++ ){
			rawArr[i] = Integer.parseInt( st.nextToken() );
		}
		
		idxStack.push(0);
		
		// 횟수 배열 F 구하기
		for( int i=1;i<cnt;i++ ){
			if( !flagArr[i] ) {
				idxStack		= new Stack<Integer>();
				int	targetNum	= rawArr[i];
				int	targetCnt	= 1;
				
				idxStack.push(i);
				
				for( int j=i+1;j<cnt;j++ ){
					if( targetNum == rawArr[j] ){
						targetCnt++;
						flagArr[j] = true;
						idxStack.push(j);
					}
				}
				
				while( !idxStack.isEmpty() ){
					cntArr[idxStack.pop()]=targetCnt;
				}
			}
		}
		
		// 오등큰수 구하기
		Stack<Integer>	stack	= new Stack<Integer>();
		int[]			NGF		= new int[cnt];
		
		stack.push(0);
		
		for( int i=1;i<cnt;i++ ){
			int curCnt = cntArr[i];
			while( !stack.isEmpty() && curCnt > cntArr[stack.peek()] ){
				NGF[stack.pop()] = rawArr[i];
			}
			stack.push(i);               
		}
		
		while( !stack.isEmpty() ){
			NGF[stack.pop()] = -1;
		}
		
		for( int i : NGF ){
			bw.write( i + " ");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}





















































