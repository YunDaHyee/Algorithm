package Basic_Level._5_Graph.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
	@Question
		미로탐색 >
		N×M크기의 배열로 표현되는 미로가 있다.
	여기1	0	1	1	1	1
		1	0	1	0	1	0
		1	0	1	0	1	1
		1	1	1	0	1	1까지
		미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
		이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
		한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
		위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다.
		칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
	
	@Input
		첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다.
		다음 N개의 줄에는 M개의 정수로 미로가 주어진다.
		각각의 수들은 붙어서 입력으로 주어진다.
		
		4 6
		101111
		101010
		101011
		111011
		
		4 6
		110110
		110110
		111111
		111101
		
		2 25
		1011101110111011101110111
		1110111011101110111011101
		
		7 7
		1011111
		1110001
		1000001
		1000001
		1000001
		1000001
		1111111
		
	@Output
		15
		9
		38
		13
		
	@History
		
		
 */
public class _2178 {
	
	private static int[] dx = {-1,1,0,0}, dy = {0,0,1,-1}; // 좌우상하
	private static int[][] mazeMatrix; 
	private static boolean[][] flagMatrix;
	
	public static void main(String[] args) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw			= new BufferedWriter( new OutputStreamWriter(System.out) );
	
		String[]		raw			= br.readLine().split(" ");
		int				N			= Integer.parseInt( raw[0] ), M = Integer.parseInt( raw[1] );
		mazeMatrix	= new int[N][M];	// 세로,가로
		flagMatrix	= new boolean[N][M];// 세로,가로
		// int[][]		groupMatrix	= new int[N][M];	// 세로,가로
		//int minCnt = 0; // 최소한의 칸수
		
		// 값 초기화
		for( int i=0;i<N;i++ ){
			String num = br.readLine();
			for( int j=0;j<M;j++ ){
				if( Integer.parseInt(String.valueOf(num.charAt(j)))!=0 ){
					mazeMatrix[i][j] = 1;
				}
			}
		}
		
		bw.write( String.valueOf(BFS(N, M)) );
		/*
		
		// XX 시행착오들 XX
		 *  
		// 인접한 칸들의 거리 측정해서 최단거리 구하기
		for( int i=0;i<N;i++ ){
			for( int j=0;j<M;j++ ){
				if( mazeMatrix[i][j]==1 && groupMatrix[i][j]==0 ){
					BFS( mazeMatrix, groupMatrix, i, j, ++minCnt, N, M );
				}
			}
		}
		// 인접한 칸들의 최단거리 구하기 -> 위에서 처리를 해주고 뒤에서 또 다른 작업을 풀어줘야 하나 했다..
		 * 
		//bw.write( String.valueOf(minCnt) );
		*/
		
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int BFS(/* int[][] mazeMatrix, int[][] groupMatrix, int i, int j, int minCnt, */int N, int M ){
		Queue<POSITION>		queue			= new LinkedList<POSITION>();
		int[][]				incrementMatrix = new int[N][M]; // BFS 진행 단게에 따른 +1 증가 배열
		
		// int minCnt = 1; // ▣
		/*
			생각은 하고 알고리즘을 푸는 것일까..?
			그룹번호를 매길 필요 없기 떄문에 단순히 체크용도로만 쓰기 위한 값들만 있음 되는데
			함수도 그렇고 매개변수들도 그렇고 그저 앞에 문제에서 했다고 하는 것 하고는... 에휴..ㅎㅎ...
			아무튼, 이 문제에서는 단순히 4방위에다가 최단거리를 구해주면 되는 문제라서 for문에서 BFS 함수를 반복적으로 호출하면서 할 필요 없어.
			호출하면서 해야했던 이유는 그룹핑을 해야했기 때문임..
			그래서 걍 단순 BFS 구현으로 BFS 함수 안에서 check배열로만 체크 해줌 돼.
			
			"
			groupMatrix[i][j] = minCnt; // 거리 측정을 위해 현 위치로부터 4방위에 있는 것들은 +1을 해줘야함.현 위치에서 거리 +_1로 위치하는 거니까.
			뭔가 거리를 측정해야할 것 같은데..현재 위치에서 1인 거리일 때만 움직일 수 있게..0이 아니면 무조건 들어가게..
			"
			
			라고 생각해가지고 그룹핑 해준뒤에 BFS 함수안에서 minCnt를 증가시켜서 하면 되는 줄 알았는데 너무 단순하게 생각한 것 같다.
		 */
		// 값 초기화
		flagMatrix[0][0]		= true;
		incrementMatrix[0][0]	= 1;
		queue.add( new POSITION(0, 0) );
		
		while( !queue.isEmpty() ){
			POSITION P = queue.remove();
			int i = P.x;
			int j = P.y;
			
			// int originalMinCnt = minCnt; // ▣ 
			/* 
				이렇게 하고 밑에서 최종 조건문 들어갔을 때 minCnt=originalMinCnt+1 해주는 거는 단순히 1의 개수만큼 세려주는 것임.. 
				단계별로 1씩 증가한다는 걸 파악해서 하나씩 증가시켜주는 거로 해야함.
				그래서 incrementMatrix 증가배열을 따로 두고 단계별로 증가해주는것임.
			 */
			
			for( int k=0;k<4;k++ ){
				int realX = i+dx[k], realY =j+dy[k];
				if( realX>=0 && realX<N && realY>=0 && realY<M ){
					if( mazeMatrix[realX][realY]==1 && flagMatrix[realX][realY]==false ){
						// minCnt = originalMinCnt+1; // ▣
						flagMatrix[realX][realY] = true;
						queue.add( new POSITION(realX, realY) );
						incrementMatrix[realX][realY] = incrementMatrix[i][j]+1; // 4방위의 중심축(주인공)의 거리수에서 +1을 해줌
					}
				}
			}
		}
		return incrementMatrix[N-1][M-1]; // 0부터 시작하니까 인덱스=사이즈-1 해줘야함.
	}
}
