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
	서울 지하철 2호선
	
	@Question
		서울 지하철 2호선은 다음과 같이 생겼다.
		(2호선 노선도 그림)
		지하철 2호선에는 51개의 역이 있고, 역과 역 사이를 연결하는 구간이 51개 있다.
		즉, 정점이 51개이고, 양방향 간선이 51개인 그래프로 나타낼 수 있다.
		2호선은 순환선 1개와 2개의 지선으로 이루어져 있다.
		한 역에서 출발해서 계속 가면 다시 출발한 역으로 돌아올 수 있는 노선을 순환선이라고 한다.
		지선은 순환선에 속하는 한 역에서 시작하는 트리 형태의 노선이다.
		
		두 역(정점) 사이의 거리는 지나야 하는 구간(간선)의 개수이다.
		역 A와 순환선 사이의 거리는 A와 순환선에 속하는 역 사이의 거리 중 최솟값이다.
		
		지하철 2호선과 같은 형태의 노선도가 주어졌을 때, 각 역과 순환선 사이의 거리를 구해보자.
		
	@Input
		첫째 줄에 역의 개수 N(3 ≤ N ≤ 3,000)이 주어진다.
		둘째 줄부터 N개의 줄에는 역과 역을 연결하는 구간의 정보가 주어진다.
		같은 구간이 여러 번 주어지는 경우는 없고, 역은 1번부터 N번까지 번호가 매겨져 있다.
		임의의 두 역 사이에 경로가 항상 존재하는 노선만 입력으로 주어진다.
		
		4
		1 3
		4 3
		4 2
		1 2
		
		6
		1 2
		3 4
		6 4
		2 3
		1 3
		3 5
		
		51
		1 2
		2 3
		3 4
		4 5
		5 6
		6 7
		7 8
		8 9
		9 10
		10 11
		11 12
		12 13
		13 14
		14 15
		15 16
		16 17
		17 18
		18 19
		19 20
		20 21
		21 22
		22 23
		23 24
		24 25
		25 26
		26 27
		27 28
		28 29
		29 30
		30 31
		31 32
		32 33
		33 34
		34 35
		35 36
		36 37
		37 38
		38 39
		39 40
		40 41
		41 42
		42 43
		43 1
		11 44
		44 45
		45 46
		46 47
		34 48
		48 49
		49 50
		50 51
		서울 지하철 2호선 노선이다.
		1번부터 43번까지는 역 번호와 일치하며, 성수역은 11번, 신도림역은 34번이다.
		
		38
		1 2
		2 3
		3 4
		4 5
		5 6
		6 1
		1 7
		7 8
		8 9
		9 10
		10 11
		11 12
		12 13
		13 14
		14 15
		15 16
		16 17
		17 18
		18 19
		19 20
		20 21
		21 22
		22 23
		23 24
		24 25
		25 26
		26 27
		27 28
		28 29
		29 30
		30 31
		31 32
		32 33
		33 34
		34 35
		35 36
		36 37
		37 38
		서울 지하철 6호선이다. 실제로는 일부 구간이 양방향이 아니다.
		
		12
		1 3
		3 4
		4 5
		5 6
		6 7
		7 8
		8 4
		2 3
		7 9
		9 12
		7 10
		10 11
	@Output
		총 N개의 정수를 출력한다. 1번 역과 순환선 사이의 거리, 2번 역과 순환선 사이의 거리, ..., N번 역과 순환선 사이의 거리를 공백으로 구분해 출력한다.
		0 0 0 0
		0 0 0 1 1 2
		0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 2 3 4 1 2 3 4
		0 0 0 0 0 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32
		2 2 1 0 0 0 0 0 1 1 2 2
	@History
		
*/
public class _16947 {
	private static int[]		dx = { -1,1,0,0 }, dy = { 0,0,1,-1 };
	private static boolean[]	checkM;
	
	public static void main(String args[]) throws IOException{
		BufferedReader	br		= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter	bw		= new BufferedWriter(new OutputStreamWriter(System.out));
		int				cnt		= Integer.parseInt( br.readLine() );
		boolean[]		lineM	= new boolean[cnt+1];
		checkM					= new boolean[cnt+1];
		// 선 연결하기
		for( int i=1;i<=cnt;i++ ) {
			StringTokenizer st	= new StringTokenizer( br.readLine() );
			lineM[Integer.parseInt(st.nextToken())] = true;
		}
		
		for( int i=1;i<=cnt;i++ ) {
			BFS()
		}
		BFS()
		br.close();
		bw.flush();
		bw.close();
	}

	private static int cyclePoint = 0;
	
	private static boolean BFS( boolean[] lineM, int cnt, int fromPointX, int fromPointY ){
		if( checkM[fromPointX] ) {
			return true;
		}
		Queue<POSITION> queue = new LinkedList<POSITION>();
		queue.add( new POSITION(fromPointX, fromPointY) );
		checkM[fromPointX]=true;
		
		while( !queue.isEmpty() ){
			if( lineM[realX] && !checkM[realX] ){
				queue.add( new POSITION(realX, realY) );
				checkM[realX][realY] = true;
				
			}
		}
		
		return false;
	}
}
