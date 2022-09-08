package Leetcode.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.text.Position;

/**
	https://leetcode.com/problems/surrounded-regions/
	
	@Question	
		Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
		A region is captured by flipping all 'O's into 'X's in that surrounded region.
		'X'와 'O'를 포함하는 m x n 매트릭스 보드가 주어지면 'X'로 4방향으로 둘러싸인 모든 영역을 캡처합니다.
		영역은 해당 영역에서 모든 'O'를 'X'로 반전하여 캡처됩니다.
		
	@Example		
		Example 1:
			Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
			Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
			Explanation: Notice that an 'O' should not be flipped if:
			- It is on the border, or
			- It is adjacent to an 'O' that should not be flipped. - 
			The bottom 'O' is on the border, so it is not flipped.
			The other three 'O' form a surrounded region, so they are flipped.
			설명: 다음과 같은 경우 'O'를 뒤집으면 안 됩니다.
			- 국경에 있거나
			- 뒤집으면 안되는 'O'에 인접해 있습니다.
			아래쪽 'O'는 테두리에 있으므로 뒤집히지 않습니다.
			나머지 3개의 'O'는 둘러싸인 영역을 형성하므로 뒤집혀 있습니다.
		
		Example 2:
			Input: board = [["X"]]
			Output: [["X"]]

	@Constraints
		m == board.length
		n == board[i].length
		1 <= m, n <= 200
		board[i][j] is 'X' or 'O'.
		
	@history			
		BFS
		바뀌면 안되는 곳
		1.	가쪽
		2.	뒤집으면 안되는 'O'에 인접해있는 곳 - X로 둘러싸여있는 곳
			처음엔 이해가 안갔는데 생각해보니 양 방향이 다 가쪽이어서 중심인 곳인 듯 하다.
		 	근데 X/O로 이미 다 둘러싸여있으면은 중심이어도 바꿀 수 있나봄;;
		 	뒤집으면 안되는 '0'에 대해 테케 하면서 알아가는 중;;;
		인덱스로 일일이 접근할 순 없고
		x가 0/length-1
		y가 0/length-1
		
		00	01 02	03
		10	11 12	13
		20	21 22	23
		30 31 32	33
		
		00 01 02
		10 11 12
		20 21 22
		
		int	centerCount = 0,
		xCount		= 0,
		oCount		= 0;
		centerCount는 4인데 0부터 도니까 -1, 다 O 아니어야하니까 3 미만
		// 모든 길이 X로 둘러 싸여있을 때
		if( (current.X!=0&&current.X!=M-1)&&(current.Y!=0&&current.Y!=N-1) ){ // 가쪽아닐 때
			if( pathCount==xCount&&pathCount!=oCount ){
				if( !check[current.X][current.Y] ){
					board[current.X][current.Y] = 'X';
				}
			}
		}
		이런식으로 o,x 별 카운트 해서 마지막에 뭔가 해주려고 했는데
		if( centerCount==3 && xCount!=0 && oCount==0 ){ // centerCount는 4인데 0부터 도니까 -1, 다 O 아니어야하니까 3 미만
				board[N/2][M/2] = 'X';
			}
		A예시에서 맞으면 B예시에서 틀리고 계쏙 이래가지고 버림..
		
		그래서 1차로 돌아서 가쪽에 제외한 상태로 바뀌게 하고
		중간에 바뀐 좌표값에 대해 list에 추가하고
		추가한 좌표들에 대해서 2차로 검사하는 식으로 진행
		
		단순히 o 하나가 4방면에 둘러싸여있는 것만 생각하고 풀었는데
		o 집단이 둘러싸여있는 걸 고려해야하는 문제였다.
		
   @Date
      2022. 9. 8.
 */
class Coordinate2 {
	int X,Y;

	public Coordinate2(int x, int y) {
		super();
		X = x;
		Y = y;
	}
}

public class surrounded_regions_130 {
	static int M,N;
	static boolean[][]	check;
	static int[][]		group;

	public static void main(String[] args) {
		char[][]			board =  
		//{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}}; //=> [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
		//{{'X'}};
		//{{'O','O'},{'O','O'}};
		//{{'O','O','O'},{'O','O','O'},{'O','O','O'}}; // => [["O","O","O"],["O","O","O"],["O","O","O"]]
		//{{'X','X','X'},{'X','O','X'},{'X','X','X'}}; // => [["X","X","X"],["X","X","X"],["X","X","X"]]
		//{{'O','O','O'},{'O','X','O'},{'O','O','O'}};
		//{{'X','O','X'},{'X','O','X'},{'X','O','X'}}; // => [["X","O","X"],["X","O","X"],["X","O","X"]]//틀
		//{{'O','X','O'},{'X','O','X'},{'O','X','O'}}; //=>[["O","X","O"],["X","X","X"],["O","X","O"]]
		//{{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
		//=> [["X","O","X","O","X","O"],["O","X","X","X","X","X"],["X","X","X","X","X","O"],["O","X","O","X","O","X"]]
		//{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
		//=>[["O","X","X","O","X"],["X","X","X","X","O"],["X","X","X","O","X"],["O","X","O","O","O"],["X","X","O","X","O"]]
		{{'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'},{'X','X','X','X','X','X','X','X','X','O','O','O','X','X','X','X','X','X','X','X'},{'X','X','X','X','X','O','O','O','X','O','X','O','X','X','X','X','X','X','X','X'},{'X','X','X','X','X','O','X','O','X','O','X','O','O','O','X','X','X','X','X','X'},{'X','X','X','X','X','O','X','O','O','O','X','X','X','X','X','X','X','X','X','X'},{'X','X','X','X','X','O','X','X','X','X','X','X','X','X','X','X','X','X','X','X'}};
		//=>[["X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"],["X","X","X","X","X","X","X","X","X","O","O","O","X","X","X","X","X","X","X","X"],["X","X","X","X","X","O","O","O","X","O","X","O","X","X","X","X","X","X","X","X"],["X","X","X","X","X","O","X","O","X","O","X","O","O","O","X","X","X","X","X","X"],["X","X","X","X","X","O","X","O","O","O","X","X","X","X","X","X","X","X","X","X"],["X","X","X","X","X","O","X","X","X","X","X","X","X","X","X","X","X","X","X","X"]]

		M = board.length;
		N = board[0].length;
		
		check = new boolean[M][N];
		group	= new int[M][N];
		
		int	groupNo	= 0;
		
		// 그룹번호 묶기
		for( int i=0;i<M;i++ ){
			for( int j=0;j<N;j++ ){
				if( check[i][j] ){
					continue;
				}
				if( board[i][j]=='O' ){
					if( (i!=0&&i!=M-1)&&(j!=0&&j!=N-1) ){ // 가쪽아닐 때
						BFS(board, ++groupNo, i, j);
						continue;
					}
					group[i][j] = -1;
				}else {
					group[i][j] = -2;
				}
			}
		}
		
		// 그룹번호 별 값 바꾸기
		for( int i=1;i<=groupNo;i++ ) {
			for( int j=0;j<M;j++ ){
				for( int k=0;k<N;k++ ){
					int targetGroupNo = group[j][k];
					if( targetGroupNo>0 && i==targetGroupNo ){
						board[j][k] = 'X';
					}
				}
			}
		}
	}
	
	private static void BFS(char[][] board, int groupNo, int i, int j) {
		// COORDINATE
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		Queue<Coordinate2>	queue		= new LinkedList<Coordinate2>();
		List<Coordinate2> negativeList	= new ArrayList<Coordinate2>(); // 가쪽 목록
		List<Coordinate2> groupList		= new ArrayList<Coordinate2>(); // 같은 그룹 번호 목록
		
		// 값 초기화
		group[i][j] = groupNo;
		queue.offer( new Coordinate2(i, j) );
		
		// 각 그룹번호별 집의 수 세기
		while( !queue.isEmpty() ){
			Coordinate2 current		= queue.poll();
			for( int k=0;k<4;k++ ){
				int nextX		= current.X+dx[k],
					nextY		= current.Y+dy[k];
				
				if( nextX>-1 && nextX<M && nextY>-1 && nextY<N ){
					if( check[nextX][nextY] ) {
						continue;
					}
					
					check[nextX][nextY] = true;
					
					Coordinate2 nextTarget = new Coordinate2(nextX,nextY);
					
					if( (nextX!=0&&nextX!=M-1)&&(nextY!=0&&nextY!=N-1) ){ // 가쪽 아닐 때
						if( board[nextX][nextY]=='O' ){
							group[nextX][nextY] = groupNo;
							groupList.add( nextTarget );
							queue.offer( nextTarget );
						}
						continue;
					}
					
					// 가쪽일 떄
					negativeList.add(nextTarget);
					
					if( board[nextX][nextY]=='O' ){
						group[nextX][nextY] = -1;
						continue;
					}
					
					group[nextX][nextY] = -2;
				}
			}
		}
		
		// 그룹 다 돌고나서 그룹 근처 숫자들 체크 - -2가 아닌 게 있으면 바뀔 대상이 아닌 것
		for( Coordinate2 c : negativeList ){
			if( group[c.X][c.Y]!=-2 ){
				group[i][j] = 0; // 자기자신 외에는 안담길 수 있으므로 자기자신을 넣어줌
				for( Coordinate2 cc : groupList ){ // 그룹 내 모든 숫자들이 다 바껴야함.
					group[cc.X][cc.Y] = 0;
				}
				break;
			}
		}
	}
	
}