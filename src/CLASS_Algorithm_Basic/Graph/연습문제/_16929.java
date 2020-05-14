package Graph.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/**
	Two Dots
	
	@Question
		Two Dots는 Playdots, Inc.에서 만든 게임이다.
		게임의 기초 단계는 크기가 N×M인 게임판 위에서 진행된다.
		(그림)
		각각의 칸은 색이 칠해진 공이 하나씩 있다.
		이 게임의 핵심은 같은 색으로 이루어진 사이클을 찾는 것이다.
		다음은 위의 게임판에서 만들 수 있는 사이클의 예시이다.
		(그림)
		점 k개 d1, d2, ..., dk로 이루어진 사이클의 정의는 아래와 같다.
			모든 k개의 점은 서로 다르다. 
			k는 4보다 크거나 같다.
			모든 점의 색은 같다.
			모든 1 ≤ i ≤ k-1에 대해서, di와 di+1은 인접하다.
			또, dk와 d1도 인접해야 한다. 두 점이 인접하다는 것은 각각의 점이 들어있는 칸이 변을 공유한다는 의미이다.
		게임판의 상태가 주어졌을 때, 사이클이 존재하는지 아닌지 구해보자.
		
	@Input
		첫째 줄에 게임판의 크기 N, M이 주어진다.
		둘째 줄부터 N개의 줄에 게임판의 상태가 주어진다.
		게임판은 모두 점으로 가득차 있고, 게임판의 상태는 점의 색을 의미한다.
		점의 색은 알파벳 대문자 한 글자이다.
		제한 - 2 ≤ N, M ≤ 50
		
		3 4
		AAAA
		ABCA
		AAAA
		
		3 4
		AAAA
		ABCA
		AADA
		
		4 4
		YYYR
		BYBY
		BBBY
		BBBY
		
		7 6
		AAAAAB
		ABBBAB
		ABAAAB
		ABABBB
		ABAAAB
		ABBBAB
		AAAAAB
		
		2 13
		ABCDEFGHIJKLM
		NOPQRSTUVWXYZ
	@Output
		사이클이 존재하는 경우에는 "Yes", 없는 경우에는 "No"를 출력한다.
		Yes
		No
		Yes
		Yes
		No
	@History
		인덱스를 넣어야할 것 같다.
		위아래양옆의 방향을 써야 하는 거는 다 dx,dy를 써야하는 듯.
*/
public class _16929 {
	private static int[][]	checkMatrix;	// 방문배열
	private static int[] dx = { -1,1,0,0 },
						 dy = { 0,0,1,-1 };
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st= new StringTokenizer( br.readLine() );
		int				N = Integer.parseInt( st.nextToken() ),
						M = Integer.parseInt( st.nextToken() );

		List<Character>	numList	= new ArrayList<Character>();
		char[][]	BOARD		= new char[N][M];					// 세로가로
		checkMatrix				= new int[N][M];				// 방문 배열
		
		for( int i=0;i<N;i++ ){
			String line = br.readLine();
			for( int j=0;j<M;j++ ){
				char each	= line.charAt(j);
				BOARD[i][j] = line.charAt(j);
				numList.add(each);
			}
		}
		
		BFS( BOARD, numList, N, M );
		
		for( int i=0;i<numList.size();i++ ){
			BFS( BOARD, numList.get(i), N, M );
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static String BFS(char[][] BOARD, Character each, int N, int M ) {
		Queue<POSITION>	queue		= new LinkedList<POSITION>();
		//int[][]			checkMatrix	= new int[N][M]; // 방문 배열

		checkMatrix[0][0] = 1;
		queue.add( new POSITION(0, 0) );
		
		//for( int i=0;i<numList.size();i++ ) {
			//char		each		= numList.get(i);
			
			while( !queue.isEmpty() ){
				boolean		cycleFlag	= false;
				POSITION 	P			= queue.poll();
				
				int curX = P.x, curY = P.y;
				for( int j=0;j<N;j++ ){
					for( int k=0;k<M;k++ ){
						if( BOARD[curX][curY]==BOARD[j][k] && checkMatrix[j][k]<2 ){
							checkMatrix[j][k]++;
							queue.add( new POSITION(curX, curY) );
						}else{
							cycleFlag = true;
						}
					}
				}
				
				if( cycleFlag ){
					return "Yes";
				}
			}
		//}
		return "No";
	}
}
