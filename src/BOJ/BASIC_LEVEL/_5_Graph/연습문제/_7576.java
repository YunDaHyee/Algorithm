package Basic_Level._5_Graph.연습문제;

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
		철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
		토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다. 
		(그림)
		창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다.
		보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
		하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다.
		대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다.
		철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
		토마토를 창고에 보관하는 격자모양의 상자들의 크기와
		익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
		며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.
		단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.

	@Input
		첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다.
		M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다.
		단, 2 ≤ M,N ≤ 1,000 이다.
		둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
		즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다.
		하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.
		정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다. 
		1.
		6 4
		0 0 0 0 0 0
		0 0 0 0 0 0
		0 0 0 0 0 0
		0 0 0 0 0 1
		
		2.
		6 4
		0 -1 0 0 0 0
		-1 0 0 0 0 0
		0 0 0 0 0 0
		0 0 0 0 0 1
		
		3.
		6 4
		1 -1 0 0 0 0
		0 -1 0 0 0 0
		0 0 0 0 -1 0
		0 0 0 0 -1 1
		
		4.
		5 5
		-1 1 0 0 0
		0 -1 -1 -1 0
		0 -1 -1 -1 0
		0 -1 -1 -1 0
		0 0 0 0 0
		
		5.
		2 2
		1 -1
		-1 1
		
	@Output
		여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.
		만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
		1.8
		2.-1
		3.6
		4.14
		5.0
		
	@History
		- 메모
			4방위
			토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
			처음과 시간흐름에 따른 변화를 일수로 카우트 해야하므로 for문으로 BFS 반복하면서 호출해야함..
			정해진 횟수를 하루라고 치고 그 횟수안에 박스안을 다 조회 할 수 있냐없냐를 파악하면 되지 않을까?
			토마토가 연결요소가 있으면 익는거고 아니면 안익는 거
			일단 연결요소 개수를 다 파악해야할 듯..연결요소만큼 돌고 다 돌았으면 하루가 지난거로 치기
			-1 : 토마토 없음 , 0 : 안익음 , 1 : 익음
			
		- 기록
			기록1 : 첫 상태의 상자를 조회하는 것이기때문에 0 day부터 시작.
					그래야 다음 인덱스부터 1일씩 증가하는 것.
					근데 어차피 0은 자동으로 객체 생성할 때 되어있으니까 따로 해줄 필요 없음.
					근데 0으로 하면..밑에서 출력할 때 안익은거로 될 수 있어서.. 값을 1로 넣어줌.
			기록2 : 근데 days의 초기화를 0으로 하면 여기서 출력할 때 안익은거(0)로 될 수 있어서.. 값을 1로 넣어줬기 땜에 1 빼줌
		
		1.	첫 상태 상자 조회 먼저 하고 그 다음에 뭔가를 처리해줘야 한다고 생각했었는데
			처음에 값 초기화 할 때, 1일 때에만 조건 걸어서 값을 넣으므로 그때 큐에다가 담는 것으로 함.

			걍 단순히 BFS 단계별 그룹핑 했을 때(미로탐색 문제풀이랑 똑같)
			[1, 2, 3, 4, 5, 6]
			[2, 3, 4, 5, 6, 7]
			[3, 4, 5, 6, 7, 8]
			[4, 5, 6, 7, 8, 0]
			이걸 보고 아이디어가 생각나서 1인 애들을 큐에 먼저 넣고 시작하면 되겠다 싶어서 나오는 게 아래와 같은 것이었다.
						
			[9, 8, 7, 6, 5, 4],
			[8, 7, 6, 5, 4, 3],
			[7, 6, 5, 4, 3, 2],
			[6, 5, 4, 3, 2, 1]]
			
		2.	속도 : StringToknizer > String.class.split(" ") : 훨씬 빠름!! 
 *
 */
public class _7576 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		StringTokenizer st= new StringTokenizer( br.readLine() );
		
		int					M				= Integer.parseInt( st.nextToken() ), // 가로
							N				= Integer.parseInt( st.nextToken() ); // 세로
		
		int[] 				dx				= { -1,1,0,0 },
							dy				= { 0,0,1,-1 };
		int[][]				boxMatrix		= new int[N][M],			// 상자 행렬
							incrementMatrix = new int[N][M];			// 요일 증가 행렬
		boolean[][]			flagMatrix		= new boolean[N][M];		// 방문 여부 행렬
		Queue<POSITION>		queue			= new LinkedList<POSITION>();
		int					days			= 0;
		
		// 값 초기화하면서 처음 상태의 상자 탐색
		for( int i=0;i<N;i++ ){
			st = new StringTokenizer( br.readLine() );
			for( int j=0;j<M;j++ ){
				String value = st.nextToken(); 
				if( value.equals("1") ){ // 토마토 있는 자리
					boxMatrix[i][j]			= 1;
					flagMatrix[i][j]		= true;
					incrementMatrix[i][j]	= 1; // 기록1
					queue.add( new POSITION(i, j) );
					
				}else if( value.equals("-1") ){ // 토마토 없는 자리 표시
					boxMatrix[i][j]			= -1;
					incrementMatrix[i][j]	= -1;
				}
			}
		}
		
		// 시간 흐름에 따라 익어가는 토마토 탐색
		while( !queue.isEmpty() ){
			POSITION P = queue.remove();
			int i = P.x;
			int j = P.y;
			for( int k=0;k<4;k++ ){
				int realX = i+dx[k], realY = j+dy[k];
				if( realX>=0 && realX<N && realY>=0 && realY<M ){
					if( boxMatrix[realX][realY]==0 && flagMatrix[realX][realY]==false ){
						flagMatrix[realX][realY]=true;
						queue.add( new POSITION(realX, realY) );
						days = incrementMatrix[realX][realY] = incrementMatrix[i][j]+1;
					}
				}
			}
		}
		
		// 처음부터 익어있었을 경우
		if( days==0 ) {
			bw.write("0");
			
		}else {
			for( int i=0;i<N;i++ ){
				for( int j=0;j<M;j++ ){
					int value = incrementMatrix[i][j];
					if( value!=-1 ) {		// 토마토 있는 자리에서
						if( value==0 ) {	// 안익은 토마토가 있다면
							bw.write("-1");
							bw.flush();
							System.exit(0);
						}
					}
				}
			}
			bw.write( String.valueOf(days-1) ); // 기록2
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
}
