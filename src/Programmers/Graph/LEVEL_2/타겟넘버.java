/**
 * 
 */
package Graph.LEVEL_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 	@Question
		n개의 음이 아닌 정수들이 있습니다.
		이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
		예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
		-1+1+1+1+1 = 3
		+1-1+1+1+1 = 3
		+1+1-1+1+1 = 3
		+1+1+1-1+1 = 3
		+1+1+1+1-1 = 3
		사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
		숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
		
	@Restrictions
		주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
		각 숫자는 1 이상 50 이하인 자연수입니다.
		타겟 넘버는 1 이상 1000 이하인 자연수입니다.
		
	@Input.Output
		numbers			target	return
		[1, 1, 1, 1, 1]		3		5
		[4, 1, 2, 1]		4		2
		
		+4+1-2+1 = 4
		+4-1+2-1 = 4
		총 2가지 방법이 있으므로, 2를 return 합니다.
		
	@history
		N = target 값을 만드는 방법의 수
		
		이걸 어떻게 DFS,BFS로 접근하지
		
		DFS : 한번 갈 떄, 깊게 가기
		BFS : 한번 갈 때, 넓게 가기
		
		가중치가 1인 배열에서 제일 빠르게 타겟넘버를 만드는 방법을 찾아야 하니까 BFS 적용 
		정점으로 치환해서 생각한다면,
		수들을 정점으로 잡고 큐의 있는 수를 기준으로 +_ 연산해서 타겟넘버 만드는 수 카운팅
		
		근데 인접리스트를 구성을 해야하는데
		가중치가 있는 것 아닌가..?
		근데 순서를 안바꾼다고 했으니까 현 위치 기준으로 앞,뒤로 -,+이고 가증치가 1임.
		
		target==현재 숫자랑 같으면 그 이후로는 더해
		값을 카운팅하고 +1 +1
		
		더하는 경우는 앞에, 빼는 경우는 뒤에
		조회하면서 더하는 거 한번씩 빼는 거 한 번씪
		
		맨처음에는 총 합이 얼마인지를 알아야 이걸 어떻게 돌릴질 알 듯..?
		8이니까 그 값을 기준으로
		8에서 얼마를 뺴야 target이 되는지를 알지
		근데 순서는 못바꾸니까 가중치는 1이야.
		근데 총합이 target이랑 상관있나?
		그렇다한들 어느선에서 +/-가 교차되어야 하는지는..모르곘는데
		
		총합이 아니고 저기서 나올 수 있는 최대값을 구해야될 듯
		아냐 그게 또 8이기 되는 거기떔에 의미 없다.
		
		4-1-2-1를 1,2,3,4로 세우고 인접리스트를 구성함.
		값에 따라 가중치를 뒀다. 근데 각 요소들간의 거리가 1이기때문에 BFS로 구할 수 있음.
		A[1] (2,-3)
		A[2] (1,+3) (3,+1)
		A[3] (2,-1) (4,-1)
		A[4] (3,+1)
		
		갔을 떄의 요소로 최대한 다 파악하도록
		
		- 남 코드 본 후
		ㅋ..dfs로 풀면 되는 것이었음..^^
		0부터 최대한 끝의 요소까지 들어갔다가
		다시 반대로 타고 들어오면서 플러스,마이너스 했을 때의 모든 경우의 조합을 찾는 식
		문제에 최단/소 비용 찾는 게 아니니까 BFS가 아니야!!!
		다시 풀기!!  
	@Date
		2022. 5. 1.
 */

public class 타겟넘버 {
	static int[] numbers = null;
	static int target = 4;
	public static void main(String[] args) {
		numbers = new int[]{4, 1, 2, 1};//{1, 1, 1, 1, 1};

		/*
		// 혼자 생각해본 거..
		
		// 값이 0부터 들어가기 때문에 +1한 크기 
		boolean[] check = new boolean[numbers.length+1];
		List<int[]>[] aList = new ArrayList[numbers.length+1]; // 인접리스트
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// 인접리스트 초기화
		for( int i=1;i<=numbers.length;i++ ) {
			aList[i] = new ArrayList<int[]>();
		}
		
		// 인접리스트 값 초기화
		if( numbers.length<3 ) {
			aList[0].add( new int[]{ 0,Math.abs(numbers[0]-numbers[1]) } );
			aList[1].add( new int[]{ 1,Math.abs(numbers[0]-numbers[1]) } );
		}else {
			for( int i=0;i<numbers.length;i++ ) {
				if( i!=0&&i!=numbers.length-1 ) {
					// numbers 기준 : i = 자기, i-1 = 자기 전, i+1 = 자기 다음
					// aList 기준 : i+1 = 자기, i= 자기 전, i+2 = 자기 다음
					
					// 자기거에 넣기 - 절대값 부호는 numbers[인덱스]에서 max,min비교로 넣기
					aList[i+1].add( new int[]{ i,Math.abs(numbers[i]-numbers[i-1]) } );
					aList[i+1].add( new int[]{ i+2,Math.abs(numbers[i]-numbers[i+1]) } );
					
					aList[i].add( new int[]{ i+1,Math.abs(numbers[i]-numbers[i-1]) } ); // 자기전거에 넣기
					aList[i+2].add( new int[]{ i+1,Math.abs(numbers[i]-numbers[i+1]) } );// 자기 다음 거에 넣기
				}
			}
		}
		
		check[1] = true;
		queue.offer(1);
		
		while( !queue.isEmpty() ) {
			int V = queue.poll();
			for( int i=1;i<aList[V])
		}
		*/
		System.out.println( dfs(0,0) );
	}

	private static int dfs(int depth, int sum) {
		if( depth==numbers.length ) {
			if( sum==target ) {
				return 1;
			}
			return 0;
		}
		
		int result = 0;
		
		result += dfs( depth+1, sum+numbers[depth] ); // 더하기연산 요소 끝까지 넣음
		result += dfs( depth+1, sum-numbers[depth] ); 
		
		return result;
	}
}
