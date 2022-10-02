package Basic_Level._5_Graph.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
		
		왜자꾸 틀리는지 이해가 안갔는데 접근 자체가 잘못된 듯..
		재귀로 풀어야 하는 듯 하다..
		=> 재귀로 푼 것
		
		아이디어가 생각이 안나서.. 백준 거를 보고 했는데 디버깅을 통해 이해는 함.
		주석 달기 이따가...지금은 멍해서 걍 문제풀고만 싶다ㅠ..
*/
public class _16929_2 {
	private static int[]		dx = { -1,1,0,0 }, dy = { 0,0,1,-1 };
	private static boolean[][]	checkMatrix;// 방문배열
	private static char[][]		BOARD;		// 게임판
	private static int			N,M;		// 세로가로
	
	public static void main(String args[]) throws IOException{
		BufferedReader	br	= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter	bw	= new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st	= new StringTokenizer( br.readLine() );
		
		N			= Integer.parseInt( st.nextToken() );
		M			= Integer.parseInt( st.nextToken() );
		BOARD		= new char[N][M];
		checkMatrix	= new boolean[N][M];

		// 게임판 입력받기
        /*
		이렇게 하면 한번에 입력 가능함.
		for(int i=0; i<N; i++) {
            BOARD[i] = br.readLine().toCharArray();
        }
         */
		for( int i=0;i<N;i++ ){
			String line = br.readLine();
			for( int j=0;j<M;j++ ){
				BOARD[i][j] = line.charAt(j);
			}
		}
		
		for( int i=0;i<N;i++ ){
			for( int j=0;j<M;j++ ){
				if( !checkMatrix[i][j] ){
					if( BFS(  -1, -1, i, j, BOARD[i][j] ) ){
						bw.write("Yes");
						bw.flush();
						System.exit(0);
					}
				}
			}
		}
		
		bw.write("No");
		
		br.close();
		bw.flush();
		bw.close();
	}

	// 출발점 X,Y 와 도착점 X,Y 와 그 char 값
	private static boolean BFS( int toPointX, int toPointY, int fromPointX, int fromPointY, char each ){
		if( checkMatrix[fromPointX][fromPointY] ){
			return true;
		}
		
		checkMatrix[fromPointX][fromPointY] = true;
		
		for( int k=0;k<4;k++ ){
			int realX = dx[k]+fromPointX,
				realY = dy[k]+fromPointY;
			if( realX>=0 && realX<N && realY>=0 && realY<M ) {
				if( !(realX==toPointX && realY==toPointY) ){
					if( each==BOARD[realX][realY] ){
						if( BFS(fromPointX, fromPointY, realX, realY, each) ){
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
}
