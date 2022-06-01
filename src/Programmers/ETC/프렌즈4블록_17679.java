/**
 * 
 */
package ETC;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 	@Question
		블라인드 공채를 통과한 신입 사원 라이언은 신규 게임 개발 업무를 맡게 되었다.
		이번에 출시할 게임 제목은 "프렌즈4블록".
		같은 모양의 카카오프렌즈 블록이 2×2 형태로 4개가 붙어있을 경우 사라지면서 점수를 얻는 게임이다.
		
		만약 판이 위와 같이 주어질 경우, 라이언이 2×2로 배치된 7개 블록과 콘이 2×2로 배치된 4개 블록이 지워진다.
		같은 블록은 여러 2×2에 포함될 수 있으며, 지워지는 조건에 만족하는 2×2 모양이 여러 개 있다면 한꺼번에 지워진다.
		
		블록이 지워진 후에 위에 있는 블록이 아래로 떨어져 빈 공간을 채우게 된다.
		
		만약 빈 공간을 채운 후에 다시 2×2 형태로 같은 모양의 블록이 모이면 다시 지워지고 떨어지고를 반복하게 된다.
		
		위 초기 배치를 문자로 표시하면 아래와 같다.
		TTTANT
		RRFACC
		RRRFCC
		TRRRAA
		TTMMMF
		TMMTTJ
		각 문자는 라이언(R), 무지(M), 어피치(A), 프로도(F), 네오(N), 튜브(T), 제이지(J), 콘(C)을 의미한다
		
		입력으로 블록의 첫 배치가 주어졌을 때, 지워지는 블록은 모두 몇 개인지 판단하는 프로그램을 제작하라.
		
	@Restrictions
		입력으로 판의 높이 m, 폭 n과 판의 배치 정보 board가 들어온다.
		2 ≦ n, m ≦ 30
		board는 길이 n인 문자열 m개의 배열로 주어진다. 블록을 나타내는 문자는 대문자 A에서 Z가 사용된다.
		
		입력으로 주어진 판 정보를 가지고 몇 개의 블록이 지워질지 출력하라.
		
	@Input.Output
		m	n	board															answer
		4	5	["CCBDE", "AAADE", "AAABF", "CCBBF"]							14
		6	6	["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]	15
		예제에 대한 설명
		입출력 예제 1의 경우, 첫 번째에는 A 블록 6개가 지워지고, 두 번째에는 B 블록 4개와 C 블록 4개가 지워져, 모두 14개의 블록이 지워진다.
		입출력 예제 2는 본문 설명에 있는 그림을 옮긴 것이다. 11개와 4개의 블록이 차례로 지워지며, 모두 15개의 블록이 지워진다.

	@history
		풀이법 - BFS. 이유 - 가중치가 1인 기준으로 위아래옆..인 줄 알았는데
		연속으로 4칸 이상 갈 수 있는 걸 찾아야하니까 DFS로 풀어야 한다..
		Two Dots 문제 참고하기..
		
		삭제하는 걸 어떻게 처리하지..
		마지막 위치에 넣는다...?
		
	@Date
		2022. 6. 1.
 */

public class 프렌즈4블록_17679 {
	public static String[][] matrix;	// 원본 값 넣을 매트릭스
	public static boolean[][] check;	// 방문여부 배열
	
	/* 좌표값 - 상하좌우 순 */
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) {
		int m=4;
		//6;
		int n=5;
		//6;
		String[] board= {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		//{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		
		check		= new boolean[m][n];
		matrix		= new String[m][n];
		int result	= 0;
		
		/* 값 넣기 */
		for( int i=0;i<m;i++ ){
			String[] b = board[i].split("");
			for( int j=0;j<n;j++ ) {
				matrix[i][j] = b[j];
			}
		}
		
		/* 겜 시작 */
		// 옮겨넣는거는 어디서 어떻게 넣어야하는지도 까다롭고 시간복잡도도 증가함..check안된 i,j 인덱스 나올떄까지 continue.. 아니 이미 된거면 인덱스를 그만큼 넓게 줘야함..
		for( int i=0;i<m;i++ ) {
			for( int j=0;j<n;j++ ) {
				if( !check[i][j] ) {
					if( start(i,j,-1,-1,1,matrix[i][j]) ){
						result+=2;
					}
				}
			} //행크기(m)-1, n-1
		}
		System.out.println( result );
		
	}
	
	/*재정렬 하는 것보다
	check 배열 계속 같은 거 찾는 게
	똑같은 거 계쏙 반복해야하니까
	더 오래걸림..*/
	
	// TODO 지우는 건 어케하지
	public static boolean start(int x, int y, int pastX, int pastY, int count, String type) {
		
		// TODO 없어지기 전까지는 중복을 허용함. 그럼 없어지고 나서 check 배열에 넣어야함.
		// 이미 방문한 점을 또 방문하면 사이클 존재
		if( count>=4 ) {
			check[x][y] = true;
			return true;
		}
		
		for( int k=0;k<4;k++ ){
			int nextX = x+dx[k];
			int nextY = y+dy[k];
			// !! 재정렬하는 게 필요해서 재정렬을 안할 순 없는 듯..!!!!!
			/*
			 * 
			*/ 
			/*while( check[nextX][nextY] ) {// 이미 체크 되어있으면 건너띄어야함. 어떻게 다음 거를..체크하지..
				for( int t=0;t<4;t++ ){
					nextX = (x+1)+dx[k];
					nextY = y+dy[k];
				}
				if( validCoordinate(nextX,nextY) ) {
					
				}
			}*/
			if( 0<=nextX&&nextX<matrix.length && 0<=nextY&&nextY<matrix[0].length ){ // 주어진 범위 내의 값이고
				if( !(nextX==pastX && nextY==pastY) ){
					if( matrix[nextX][nextY].equals(type) ){ // 이전 좌표값과 현재 좌표값이 다르고 동일한 블록 타입일 때
						count++;
						if( start( nextX, nextY, x, y, count, type) ) { // 현재 좌표값을 next로 하고 이전 좌표값을 x,y로 한다.
							return true;
						}
					}
				}
			}
		}
		
		return false; 
	}
	
	static public boolean validCoordinate(int x, int y) {
		if( 0<=x&&x<matrix.length && 0<=y&&y<matrix[0].length ){
			return true;
		}
		return false;
	}
}

