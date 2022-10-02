package BASIC_LEVEL._1_DataStructure.Queue;

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
	1 2 3 4 5 6 7 -> 1 2 4 5 6 7 -> 1 2 4 5 7 -> 1 4 5 7 -> 1 4 5 -> 1 4 -> 4  
		2					4				1			3		2		1		1
		6/3 =2
		
	@Question
		요세푸스 문제는 다음과 같다.
		1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
		이제 순서대로 K번째 사람을 제거한다.
		한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
		이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
		원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
		예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
		N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)
		7 3
	@Output
		예제와 같이 요세푸스 순열을 출력한다.
		<3, 6, 2, 7, 5, 1, 4>
	@History
		처음에는 배열에 K 개수만큼 보다 적게 남으면
		반복문을 나와서 남은 거를 빌 때까지 pop해주는 거로 했었음
		근데 자꾸 틀리길래 가만 보니까 그게 아니라
		남은 것도 K 차례로 출력되게 해야되는 것 같음..
		역시 맞았다..
 *
 */
public class queue_2_1158_v2 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(	new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		Queue<Integer>		queue		= new LinkedList<Integer>();
		StringBuilder		resultSb	= new StringBuilder();

		StringTokenizer		st			= new StringTokenizer( br.readLine() );
		
		int					cnt			= Integer.parseInt(st.nextToken());
		int					multiples	= Integer.parseInt(st.nextToken());
		
		for( int i=1;i<=cnt;i++ ){
			queue.offer( i );
		}

		resultSb.append( "<" );
		
		for( int i=1;;i++ ) {
			if( i==multiples ){
				i = 0;
				resultSb.append( queue.poll() );
				if( queue.size()!=0 ) {
					resultSb.append(", ");
				}else {
					break;
				}
			}else{
				queue.offer( queue.poll() );
			}
		}
		
		resultSb.append( ">" );
		
		/*
		// 가져올 인덱스를 수식으로 구하고 get함수로 가져오는 것.
		// 시간이 진짜 훨 적게 걸리긴 하는데
		// queue를 구현하기 위한 방법인지는 잘 모르겠따...
		int temp = 0;
		LinkedList<Integer> link = new LinkedList<>();
		resultSb.append( "<" );
		while( cnt>1 ){
			temp = temp+multiples-1%(cnt--);
			resultSb.append(link.get(temp)).append(", ");
			link.remove(temp);
		}
		resultSb.append(link.get(0)).append(">");
		*/
		
		bw.write( resultSb.toString() );
		
		bw.flush();
		bw.close();
		br.close();
	}
}
