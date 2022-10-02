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
		상왼왼대,상왼위대,상오위대,상오오대,하왼왼대,하왼밑대,하오밑대,하오오대ㅋㅋㅋㅋ.... 
		좌상대일 때는	왼,위	: -1,1 후에		-1,0랑 0,1	=> -2,1 과 -1,2		상왼왼대 상왼위대 -'
		우상대			오,위	: 1,1			0,1랑 1,0	=>  1,2 과  2,1  	상오위대 상오오대   '-
		좌하대			왼,아래 : -1,-1 후에	-1,0랑 0,-1	=> -2,-1과 -1,-2	하왼왼대 하왼밑대 -.
		우하대			오,아래 : 1,-1 후에		0,-1랑 1,0	=>  1,-2과 2,-1		하오밑대 하오오대   .-
		dx = -2, -1,1,2, -2,-1,1 ,2
		dy =  1, 2 ,2,1, -1,-2,-2,-1
		
		처음에 최종목적지까지 가는 최단경로를 찾아서 chessMatrix를 완성하고
		(최종목적지까지 가는 최단경로를 찾아야 할 듯.. 그래서 그거를 카운트 하는 거로.. 단순히 체크배열 써서 하면됨)
		그렇게 완성된 chessMatrix를 기반으로 bfs를 해야할 것 같다.
		
		아니다..최단경로 찾으면서 어쨌든 목적지까지 가는 걸 카운트 하면 돼...
		
		// 20200513 최종
		일단은 어렵게 느껴졌던/어렵게 꼬였던 문제다라고 생각한 이유 :
		움직일 수 있는 거리가 특이하게 되어있었다는 점 : 내 주변 말고 내 주변에 있는 왼오위/왼오아래
		
		단순하게 이동하는 게 아니라 특이한 방향성으로 움직여야 했던 점이
		뭔가 어렵게 풀어야한다고 느껴졌던 것 같다.
			1. 이떄까지와는 다르게 전체 행렬이 주어지지 않고 오로지 출발점과 도착점만을 줬기 때문에
				내가 전체행렬을 채워야 한다고 생각함.
				따라서 갈 수 있는 길에 대한 BFS를 작업하여 chessMatrix를 완성해서
				다시 BFS를 처리 해주려고 한 점 
			2. 처음에 출발점(curX,Y)은 방문한 게 아니라 그냥 그 점 자체였는데 체크한 점
			3. moveCnt를 써서 뭔가 증가 변수를 따로 두려고 한 점
			4. 출발점과 도착점이 같아졌을 때 반복문을 중단시키고 아래와 같이 증가배열의 해당 인덱스의 값을 리턴해주려고 한 점
				// 맞으면 멈추는 거로 했는데 이게 딱히 필요 없는 것 같음. 어차피 일로 들어오지도 않아.
				if( realX==goalX && realY==goalY ) { //if( realX==goalX && realY==goalY ) { 맞으면 멈추는거로
					return incrementMatrix[goalX][goalY];
				}
			5. incrementMatrix 증가배열을 채우는 것은 완성했지만
				그 자체의 리턴값이 아니라 단계별로 채워진 값에 따라서 출발점과 도착점이 같아졌을 떄의 뭔가 처리를 해주려 한 점
				(4번과의 혼종이다..)
			6. 이게 맞는데 왜 틀리지 하는 찰나에, 출발점과 도착점이 같다..는 건 뭔가 예외처리..!!?!?
				했는데도 틀리길래 뭐지 했는데 개행 안해줘서
				어쩄든 둘 다 처리 안해줘서 틀린거였다.
				
			이러한 시행착오 끝에 완성한 7562
			시간복잡도는 N^2
		
*/
public class _7562 {
	private static int[] dx = { -2, -1,1,2, -2,-1, 1 ,2 }; 
	private static int[] dy = { 1 , 2 ,2,1, -1,-2,-2 ,-1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int		cnt			= Integer.parseInt( br.readLine() );		// 테스트 케이스 횟수
		
		for( int i=0;i<cnt;i++ ) {
			int		size		= Integer.parseInt( br.readLine() );	// 체스 한 변의 길이
			StringTokenizer st = new StringTokenizer( br.readLine() );
			int curX = Integer.parseInt( st.nextToken() ); // TODO POSITION 클래스로 하는 게 낫나? 그거는 BFS 구현하면서 판단해보기..일단은 이러케 int형으로 놔둠.
			int curY = Integer.parseInt( st.nextToken() );
			st = new StringTokenizer( br.readLine() );
			int goalX = Integer.parseInt( st.nextToken() );
			int goalY = Integer.parseInt( st.nextToken() );
			
			// 출발점==도착점일 떄 예외처리를 해줬어야했다!!!! 난 마지막 테케는 왜 안맞지 했더니...ㅠ 바부..
			if( curX==goalX && curY==goalY ) {
				bw.write( "0\n" ); // 마지막에 틀렸다고 잠깐 나왔었는데 개행을 안해줘서 그럼
			}else {
				bw.write( String.valueOf(BFS( curX, curY, goalX, goalY, size ))+"\n" );
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static int BFS( int curX, int curY, int goalX, int goalY, int size) {
		Queue<POSITION> queue			= new LinkedList<POSITION>();
		int[][]			chessMatrix		= new int[size][size];			// 정사각형 행렬
		boolean[][]		checkMatrix		= new boolean[size][size];		// 방문 여부 행렬
		int[][]			incrementMatrix = new int[size][size];			// 증가 행렬. 최단거리 구하기 위함.
		
		int	moveCnt = -1; // 이걸 만들어줘서 체크해줘야하나 했는데 그럴 필요 없었고 내가 생각했떤 것보다 훨씬 간단...ㅠ 내가 넘 어렵게 생각했다.
		//처음에 출발점(curX,Y)은 방문한 게 아니라 그냥 그 점 자체야.
		//chessMatrix[curX][curY] = 1;
		//checkMatrix[curX][curY] = true;
		// TODO 처음위치에서 갈 수 있는 초기값 세팅 해줘야할 듯.
		queue.add( new POSITION(curX, curY) );
		
		while( !queue.isEmpty() ) {
			POSITION P = queue.poll();
			curX = P.x;
			curY = P.y;
			for( int i=0;i<8;i++ ) {
				int realX = dx[i]+curX;
				int realY = dy[i]+curY;
				if( realX>=0 && realX<size && realY>=0 && realY<size ){
					// 갈 수 있는 곳 길 만들어주기
					if( !checkMatrix[realX][realY] ){
						checkMatrix[realX][realY] = true;
						queue.add( new POSITION(realX, realY) ); // TODO 몰겠따 토마토문제처럼 해야하는건지..하ㅠ // 지금 출발점 기준으로 끝점까지 가는 데에 걸리는 이동수
						incrementMatrix[realX][realY] = incrementMatrix[curX][curY]+1;
					}
					/*
					if( !checkMatrix[realX][realY] ){
						chessMatrix[realX][realY] = 1;
						//checkMatrix[realX][realY] = true; //첨에 갈 수 있는곳이니까 이걸 체크해버리면 안될 듯.
						queue.add( new POSITION(realX, realY) ); // TODO 몰겠따 토마토문제처럼 해야하는건지..하ㅠ // 지금 출발점 기준으로 끝점까지 가는 데에 걸리는 이동수
					}
					*/
				}
			}
		}
		
		//incre 안에 있는 숫자들(i)은 x,y가 i번쨰에 갈 수 있는 곳들. 해당 i번쨰에 
		/*
		for( int i=0;i<size;i++ ) {
			for( int j=0;j<size;j++ ) {
				int value = (size+i)-size+1;
				if( incrementMatrix[i][j] == value ) {
					moveCnt++; // 의미있나 모르겠다
				}
			}
		}
		*/
		/*
		while( !queue.isEmpty() ) {
			POSITION P = queue.poll();
			curX = P.x;
			curY = P.y;
			for( int i=0;i<8;i++ ) {
				int realX = dx[i]+curX;
				int realY = dy[i]+curY;
				if( realX>=0 && realX<size && realY>=0 && realY<size ){ // 1이면 초기값에서 갈 수 있는 곳. 2면 방문했따는 것.
					if( chessMatrix[realX][realY]==1 && !checkMatrix[realX][realY] ){ // 새로운 조건 :  chessMatrix[curX][curY]==1 &
						//moveCnt++;
						chessMatrix[realX][realY] = 2;
						checkMatrix[realX][realY] = true;
						queue.add( new POSITION(realX, realY) ); // TODO 몰겠따 토마토문제처럼 해야하는건지..하ㅠ
						incrementMatrix[realX][realY] = incrementMatrix[curX][curY]+1;
						/*
						 * 맞으면 멈추는 거로 했는데 이게 딱히 필요 없는 것 같음. 어차피 일로 들어오지도 않아.
						if( realX==goalX && realY==goalY ) { //if( realX==goalX && realY==goalY ) { 맞으면 멈추는거로
							return incrementMatrix[goalX][goalY];
						}
						*
					}
				}
			}
		}
		*/
		// 첨엔 토마토 문제처럼 했는데 생각해보니까 이렇게 푸는 게 아니 ㄴ것 같아ㅓㅅ 여러 고민ㅇ르 함.
		
		return incrementMatrix[goalX][goalY];
		//return incrementMatrix[goalX][goalY]!=0 ? incrementMatrix[goalX][goalY]+1 : 0;
	}
}
