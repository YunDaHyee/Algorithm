package _5_Graph.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
	@Question
		그림 1>과 같이 정사각형 모양의 지도가 있다.
		1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
		철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
		여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
		대각선상에 집이 있는 경우는 연결된 것이 아니다.
		<그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
		지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
	
	@Input
		첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고,
		그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
		7
		0110100
		0110101
		1110101
		0000111
		0100000
		0111110
		0111000
	
	@Output
		첫 번째 줄에는 총 단지수를 출력하시오.
		그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
		3
		7
		8
		9
		
	@History
		1. 상하좌우에 대한 2차원 배열 좌표를 이해 못함..{1,0},{-1,0},{0,1},{0,-1}..
			-> 해결 :	백준이 강의용 노트에다가 필기를 할 때 왼쪽을 x-1,y로 잘못한 것으로 판단됨..
						왜냐면 x축은 가만히 있고 y축만 움직이기 때문에 x,y-1임
		2.	알고리즘을 오랜만에 푸는마당에 2차원배열이 되고 좌표까지 생각해면서 해야하니까 좀 까다롭게 느껴졌던 문제.
		 	그래서 개념을 다시 봤는데도 좌표랑 2차원 배열에 익숙치 않아서 답을 보고 이해하면서 풀었다.
		 	조금씩 연습하는거지~
 */
public class _2667 {
	// x,y 좌표 - 좌우상하
	public static final int[] dx = {-1,1,0,0};
	public static final int[] dy = {0,0,1,-1}; // 위에가 1임.
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int		cnt			= Integer.parseInt( br.readLine() );
		int[][] houseMatrix	= new int[cnt][cnt];	// 집 배열
		int[][] groupMatrix	= new int[cnt][cnt];	// 집에 해당되는 그룹번호(단지번호) 부여 배열
		int		groupN		= 0;					// 그룹번호

		// 값 초기화
		for( int i=0;i<cnt;i++ ) {
			String	line = br.readLine();
			for( int j=0;j<cnt;j++ ) { // 행
				int value = Integer.parseInt( String.valueOf(line.charAt(j)) );
				if( value!=0 ) {
					houseMatrix[i][j] = value;
				}
			}
		}
		
		// 그룹번호 묶기
		for( int i=0;i<cnt;i++ ){
			for( int j=0;j<cnt;j++ ){
				if( houseMatrix[i][j]==1 && groupMatrix[i][j]==0 ) { // 집 O , 방문 X
					BFS( houseMatrix, groupMatrix, i, j, ++groupN, cnt );
				}
			}
		}
		
		// 각 그룹번호별 집의 수 세기 
		int[] groupNArr = new int[groupN];
		for( int i=0;i<cnt;i++ ){
			for( int j=0;j<cnt;j++ ){
				if( groupMatrix[i][j]!=0 ){
					groupNArr[ groupMatrix[i][j]-1 ]++; // 단지가 1부터 시작되니까 인덱스를 위해 -1 해줘야함. 
				}
			}
		}
		
		Arrays.sort( groupNArr );						// 각 그룹번호 별 집의 수 정렬
		bw.write( String.valueOf(groupN+"\n") );		// 총 그룹번호 
		for ( int i=0; i<groupN; i++ ) {
			bw.write( String.valueOf(groupNArr[i])+"\n" );
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static void BFS( int[][] matrix, int[][] group, int i, int j, int groupN, int size ) {
		Queue<POSITION> queue = new LinkedList<POSITION>(); // 방문한 집의 좌표를 담는 Queue

		// 값 초기화
		queue.add( new POSITION(i,j) );
		group[i][j] = groupN;
		
		// 주위에 집이 있/없 구분
		while( !queue.isEmpty() ){
			POSITION P = queue.remove();
			i = P.x;
			j = P.y;
			for( int k=0;k<4;k++ ){ // 방향은 4개에
				int realX = i+dx[k], realY = j+dy[k]; // 현재 방향에 맞춰서 주어진 좌표의 상하좌우를 탐색.
				if( realX >= 0 && realX < size && realY >= 0 && realY < size ){ // 매트릭스 사이즈 안에 있으면서
					if( matrix[realX][realY]==1 && group[realX][realY]==0 ){ // 집O, 방문X
						queue.add( new POSITION(realX, realY) );
						group[realX][realY] = groupN; // 해당 좌표에 해당 그룹번호 부여
					}
				}
			}
		}
	}
}

// 방문한 집의 좌표
class POSITION{
	int x, y;
	
	POSITION(int x, int y){
		this.x = x;
		this.y = y;
	}
}
