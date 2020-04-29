package Graph.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
	@Question
		체스판 위에 한 나이트가 놓여져 있다.
		나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다.
		나이트가 이동하려고 하는 칸이 주어진다.
		나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?
		(그림)
	
	@Input
		입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.
		각 테스트 케이스는 세 줄로 이루어져 있다.
		첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다.
		체스판의 크기는 l × l이다.
		체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다.
		둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.
		3
		8
		0 0
		7 0
		100
		0 0
		30 50
		10
		1 1
		1 1
		
	@Output
		각 테스트 케이스마다 나이트가 몇 번만에 이동할 수 있는지 출력한다.
		5
		28
		0
		
	@History
		원점에서 한번에 움직일 때 원점에서 대각선의 옆쪽만으로 이동이 가능하다.
		좌우상하 좌상대/우상대/좌하대/우하대
		dx = -1,1,0,0,-1,1,-1,1
		dy = 0,0,1,-1 ,1,1,-1,-1
		즉, 아래의 위치로만 움직임 가능.. 
		좌상대일 때는	왼,위	: -1,1 후에		-1,0랑 0,1	
		우상대			오,위	: 1,1			1,0랑 0,1
		좌하대			왼,아래 : -1,-1 후에	-1,0랑 0,-1
		우하대			오,아래 : 1,-1 후에		1,0랑 0,-1
		
*/
public class _7562 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int		cnt			= Integer.parseInt( br.readLine() );	// 테스트 케이스 횟수
		int		size		= Integer.parseInt( br.readLine() );	// 체스 한 변의 길이
		int[][] chessMatrix = new int[size][size];					// 정사각형 행렬
		int[][] checkMatrix = new int[size][size];					// 방문 여부 행렬
		int		moveCnt		= 0;									// 움직임 횟수
		
		for( int i=0;i<cnt;i++ ) {
			moveCnt = 0;
			StringTokenizer st = new StringTokenizer( br.readLine() );
			int curX = Integer.parseInt( st.nextToken() ); // TODO POSITION 클래스로 하는 게 낫나? 그거는 BFS 구현하면서 판단해보기..일단은 이러케 int형으로 놔둠.
			int curY = Integer.parseInt( st.nextToken() );
			st = new StringTokenizer( br.readLine() );
			int goalX = Integer.parseInt( st.nextToken() );
			int goalY = Integer.parseInt( st.nextToken() );
			
			BFS( chessMatrix, checkMatrix, ++moveCnt, curX, curY, goalX, goalY, size );
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static void BFS(int[][] chessMatrix, int[][] checkMatrix, int i, int curX, int curY, int goalX, int goalY, int size) {
		Queue<POSITION> queue = new LinkedList<POSITION>();
		
	}
}
