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
		2.	뒤집으면 안되는 'O'에 인접해있는 곳
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
		이런식으로 o,x 별 카운트 해서 마지막에 뭔가 해주려고 했는데
		if( centerCount==3 && xCount!=0 && oCount==0 ){ // centerCount는 4인데 0부터 도니까 -1, 다 O 아니어야하니까 3 미만
				board[N/2][M/2] = 'X';
			}
		A예시에서 맞으면 B예시에서 틀리고 계쏙 이래가지고 버림..
		
		그래서 1차로 돌아서 가쪽에 제외한 상태로 바뀌게 하고
		중간에 바뀐 좌표값에 대해 list에 추가하고
		추가한 좌표들에 대해서 2차로 검사하는 식으로 진행
		
	@Date
		
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
	public static void main(String[] args) {
		char[][]			board =  
		//{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}}; //=> [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
		//{{'X'}};
		//{{'O','O'},{'O','O'}};
		//{{'O','O','O'},{'O','O','O'},{'O','O','O'}}; // => [["O","O","O"],["O","O","O"],["O","O","O"]]
		//{{'X','X','X'},{'X','O','X'},{'X','X','X'}}; // => [["X","X","X"],["X","X","X"],["X","X","X"]]
		//{{'O','O','O'},{'O','X','O'},{'O','O','O'}};
		//{{'X','O','X'},{'X','O','X'},{'X','O','X'}}; // => [["X","O","X"],["X","O","X"],["X","O","X"]]//틀
		// 가쪽에 X가 있으면 뒤집을 수 있지만 가쪽에 O가 있으면 인접해있으니까 못뒤집어서 그대로 출력해야함.
		// 4방면으로 둘러싸여있어야돼
		// 중간에 X이지만 O들이 가쪽에 있어서 
		// 중간에 O이지만
		//{{'O','X','O'},{'X','O','X'},{'O','X','O'}}; //=>[["O","X","O"],["X","X","X"],["O","X","O"]]
		{{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
		//=> [["X","O","X","O","X","O"],["O","X","X","X","X","X"],["X","X","X","X","X","O"],["O","X","O","X","O","X"]]
		/**
		원래
		X','O','X','O','X','O
		O','X','O','X','O','X
		X','O','X','O','X','O
		O','X','O','X','O','X
		 
		 *중간
		 X, O, X, O, X, O
		 O, X, X, X, X, X
		 X, X, X, X, X, O
		 O, X, X, X, X, X
		 
		 X, O, X, O, X, O 맞
		 O, X, O, X, O, X
		 X, O, X, O, X, O
		 O, X, O, X, O, X 맞
		  
		 */
		/** 답
		 X","O","X","O","X","O
		 O","X","X","X","X","X
		 X","X","X","X","X","O
		 O","X","O","X","O","X
		 */

		
		// COORDINATE
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		int M = board.length,
			N = board[0].length;
		
		boolean[][]			check	= new boolean[M][N];
		Queue<Coordinate2>	queue	= new LinkedList<Coordinate2>();
		List<Coordinate2>	list	= new ArrayList<Coordinate2>();
		
		queue.offer( new Coordinate2(0, 0) );
		
		
		// 기본 룰대로
		while( !queue.isEmpty() ){
			int	centerCount = 0,
				xCount		= 0,
				oCount		= 0;
			Coordinate2 current		= queue.poll();
			boolean flag = false;
			for( int i=0;i<4;i++ ){
				int nextX		= current.X+dx[i],
					nextY		= current.Y+dy[i];
				if( nextX>-1 && nextX<M && nextY>-1 && nextY<N ){
					if( !check[nextX][nextY] ){
						Coordinate2 c= new Coordinate2(nextX,nextY);
						if( board[nextX][nextY]=='O' ){
							list.add( c );
							flag = true;
						}
						centerCount++;
						queue.offer( c );
					}
				}
			}
			if( !check[current.X][current.Y] && !flag ) {
				check[current.X][current.Y] = true;
				board[current.X][current.Y] = 'X';
			}
		}
		
		for( Coordinate2 changedC : list ){
			queue.add( changedC );
		}
		
		check = new boolean[M][N];
		
		while( !queue.isEmpty() ){
			Coordinate2 current		= queue.poll();
			boolean oFlag = false;
			for( int i=0;i<4;i++ ){
				int nextX		= current.X+dx[i],
					nextY		= current.Y+dy[i];
				if( nextX>-1 && nextX<M && nextY>-1 && nextY<N ){
					if( !check[nextX][nextY] ){
						if( (nextX!=0&&nextX!=N-1)&&(nextY!=0&&nextY!=N-1) ){ // // 가쪽일 때
						}else {
							if( board[nextX][nextY]=='O' ){
								oFlag = true;
							}
						}
						check[nextX][nextY] = true;
					}
				}
			}
			if( oFlag ) {
				board[current.X][current.Y] = 'O';
			}
		}
		
		for( char[] t : board ){
			for( char tt : t ){
				System.out.print(tt);
			}
			System.out.println();
		}
	}
	
	/*public void BFS() {
		// 기본 룰대로
		while( !queue.isEmpty() ){
			int	centerCount = 0,
				xCount		= 0,
				oCount		= 0;
			Coordinate2 current		= queue.poll();
			
			for( int i=0;i<4;i++ ){
				int nextX		= current.X+dx[i],
					nextY		= current.Y+dy[i];
				if( nextX>-1 && nextX<N && nextY>-1 && nextY<M ){
					if( !check[nextX][nextY] ){
						Coordinate2 c= new Coordinate2(nextX,nextY);
						if( (nextX!=0&&nextX!=N-1)&&(nextY!=0&&nextY!=N-1) ){ // 가쪽이 아닐 때만
							if( board[nextX][nextY]=='O' ){
								board[nextX][nextY] = 'X';
								list.add( c );
							}
						}
						centerCount++;
						check[nextX][nextY] = true;
						queue.offer( c );
					}
				}
			}
		}
	}*/
}