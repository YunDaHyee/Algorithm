/**
 * 
 */
package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 	@Question
		ROR 게임은 두 팀으로 나누어서 진행하며 상대 팀 진영을 먼저 파괴하면 이기는 게임입니다.
		따라서, 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리합니다.
		
		지금부터 당신은 한 팀의 팀원이 되어 게임을 진행하려고 합니다.
		다음은 5 x 5 크기의 맵에 당신의 캐릭터가 (행: 1, 열: 1) 위치에 있고
		상대 팀 진영은 (행: 5, 열: 5) 위치에 있는 경우의 예시입니다.
		(최단거리1_sxuruo.png)
		
		검은색 부분은 벽으로 막혀있어 갈 수 없는 길, 흰색 부분은 갈 수 있는 길입니다.
		캐릭터가 움직일 때는 동, 서, 남, 북 방향으로 한 칸씩 이동하며 게임 맵을 벗어난 길은 갈 수 없습니다.
		
		아래 예시는 캐릭터가 상대 팀 진영으로 가는 두 가지 방법을 나타내고 있습니다.
		
		첫 번째 방법은 11개의 칸을 지나서 상대 팀 진영에 도착했습니다.
		(최단거리2_hnjd3b.png)
		
		두 번째 방법은 15개의 칸을 지나서 상대팀 진영에 도착했습니다.
		(최단거리3_ntxygd.png)
		
		위 예시에서는 첫 번째 방법보다 더 빠르게 상대팀 진영에 도착하는 방법은 없으므로 이 방법이 상대 팀 진영으로 가는 가장 빠른 방법입니다.
		
		만약, 상대 팀이 자신의 팀 진영 주위에 벽을 세워두었다면 상대 팀 진영에 도착하지 못할 수도 있습니다.
		예를 들어, 다음과 같은 경우에 당신의 캐릭터는 상대 팀 진영에 도착할 수 없습니다.
		(최단거리4_of9xfg.png)
		
		게임 맵의 상태 maps가 매개변수로 주어질 때, 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요.
		단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.

	@Restrictions
		maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
		n과 m은 서로 같을 수도, 다를 수도 있지만 n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
		maps는 0과 1로만 이루어져 있으며 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
		처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
		
	@Input.Output
		maps															answer
		[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
		[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	-1
		
		입출력 예 설명
		입출력 예 #1		
		주어진 데이터는 다음과 같습니다.
		(그림)
		캐릭터가 적 팀의 진영까지 이동하는 가장 빠른 길은 다음 그림과 같습니다.
		(그림)
		따라서 총 11칸을 캐릭터가 지나갔으므로 11을 return 하면 됩니다.
		
		입출력 예 #2
		문제의 예시와 같으며, 상대 팀 진영에 도달할 방법이 없습니다. 따라서 -1을 return 합니다.


	@history
		N = 캐릭터가 상대 팀 진영에 가장 빠르게 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값
			갈 수 있는 방법 없으면 -1
		
		가장 빠르게 -> 최단거리 탐색 => BFS
		반복문 돌면서 벽 여부와 상대 진영에 도착 여부를 탐색한다.
		만약 탐색이 다 끝났는데도 큐가 안비어있으면 -1 출력 
		
	@Date
		2022. 6. 9.
 */

public class 게임맵최단거리_1844 {
	public static void main(String[] args) {
		int[][] maps = //{ {1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1} }; 
			{ {1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1} }; 
        
        int[] dx = {-1,1,0,0}, dy = {0,0,-1,1}; // 좌표평면
        Queue<POSITION> queue = new LinkedList<POSITION>();
        
        int N = maps.length;
        int M = maps[0].length;
        
        boolean[][] check	= new boolean[N][M]; // 방문 여부 배열
        int[][] distance	= new int[N][M]; // 거리에 따른 증가 배열
        
        /* 시작 위치에 대한 초기값 설정*/
        queue.add( new POSITION(0,0) );
        check[0][0] = true;
        distance[0][0] = 1;
        
        //boolean breakFlag = false; // 이거 어디 위치시킬지 고민해보기 - 끝까지 다 탐색해야하므로 이건 둘 필요 없음.
        
        /* 게임 진행 */
        while( !queue.isEmpty() ){ 
        	POSITION currentPosition = queue.poll(); // 큐에서 빼면서 다음 타겟으로 전진한 셈.
        	
    		for( int i=0;i<4;i++ ){
    			int sideX = dx[i]+currentPosition.x;
    			int sideY = dy[i]+currentPosition.y;
    			if( sideX>=0 && sideX<N && sideY>=0 && sideY<M
    				&& !check[sideX][sideY]
    				&& maps[sideX][sideY]==1
    			){
    				check[sideX][sideY] = true;
    				queue.add( new POSITION(sideX,sideY) ); // 다음에 갈 타겟 좌표를 큐에 넣는 것.
    				distance[sideX][sideY] = distance[currentPosition.x][currentPosition.y]+1; // 현재 좌표값의 누적거리값에서 +1
					/*
						if( sideX==N-1 && sideY==M-1 ){
	    					breakFlag=true;
	    					break;
	    				}
					*/
				}
    		}
    		
			/*if( breakFlag ) {
				break;
			}*/
        }
        
		/*if( !breakFlag ) {
			answer = -1;
		}*/
        
        System.out.println(distance[N-1][M-1]);
	}
}

class POSITION {
	int x;
	int y;
	/**
	 * @param x
	 * @param y
	 */
	public POSITION(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}


