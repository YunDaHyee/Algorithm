package Graph.연습문제;

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
	
	public static void main(String[] args) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw			= new BufferedWriter( new OutputStreamWriter(System.out) );
	
		String[]		raw			= br.readLine().split(" ");
		int				N			= Integer.parseInt( raw[0] ), M = Integer.parseInt( raw[1] );
		int[][]			mazeMatrix	= new int[N][M];	// 세로,가로
		int[][]			groupMatrix	= new int[N][M];	// 세로,가로
		int minCnt = 0; // 최소한의 칸수
		
		// 값 초기화
		for( int i=0;i<N;i++ ){
			String num = br.readLine();
			for( int j=0;j<M;j++ ){
				if( Integer.parseInt(String.valueOf(num.charAt(j)))!=0 ){
					mazeMatrix[i][j] = 1;
				}
			}
		}
		
		// 인접한 칸들의 거리 측정하기.. TODO 측정이 제대로 안돼,,ㅠㅠ 17 이따구로 나옴...먼가 필터가 필요할 듯..
		for( int i=0;i<N;i++ ){
			for( int j=0;j<M;j++ ){
				if( mazeMatrix[i][j]==1 && groupMatrix[i][j]==0 ){
					BFS( mazeMatrix, groupMatrix, i, j, ++minCnt, N, M );
				}
			}
		}
		
		// 인접한 칸들의 최단거리 구하기
		
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void BFS( int[][] mazeMatrix, int[][] groupMatrix, int i, int j, int minCnt, int N, int M ){
		Queue<COORDINATE> queue = new LinkedList<COORDINATE>();
		/*	생각은 하고 알고리즘을 푸는 것일까..?
						그룹번호를 매길 필요 없기 떄문에 단순히 체크용도로만 쓰기 위한 값들만 있음 되는데
						그저 앞에 문제에서 그렇게 했다고 하는 것 하고는... 에휴..ㅎㅎ...
						TODO 내일 수정하기. 정답 따로.. 내가 한 것 따로
		 */
		queue.add( new COORDINATE(i, j) );
		groupMatrix[i][j] = minCnt; // 거리 측정을 위해 현 위치로부터 4방위에 있는 것들은 +1을 해줘야함. 현 위치에서 거리 +_1로 위치하는 거니까.
		
		while( !queue.isEmpty() ){
			COORDINATE c = queue.remove();
			i = c.x;
			j = c.y;
			for( int k=0;k<4;k++ ){
				int realX = i+dx[k], realY =j+dy[k];
				if( realX>=0 && realX<N && realY>=0 && realY<M ){
					/*
					 * 뭔가 거리를 측정해야할 것 같은데..현재 위치에서 1인 거리일 때만 움직일 수 있게..0이 아니면 무조건 들어가게..
					 * realX,realY로 잡아어야 했는데 i,j로 잡고 했었다..그래서 그런지
						[1, 0, 2, 3, 4, 5], 
						[6, 0, 7, 0, 8, 0], 
						[9, 0, 10, 0, 11, 12],
						[13, 14, 15, 0, 16, 17]
						가나옴..
						바꿔넣으니 15까지만 나온다.
					 */
					if( mazeMatrix[realX][realY]==1 && groupMatrix[realX][realY]==0 ){
						queue.add( new COORDINATE(realX, realY) );
						groupMatrix[realX][realY] = groupMatrix[i][j]+1;
					}
				}
			}
		}
		
	}
}
