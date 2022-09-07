/**
 * 
 */
package Leetcode.Graph;

import java.util.PriorityQueue;

/**
 	https://leetcode.com/problems/min-cost-to-connect-all-points/
 	
 	@Question
		You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
		The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
		Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
		2D 평면에 있는 일부 점의 정수 좌표를 나타내는 배열 점이 주어집니다.
		여기서 점[i] = [xi, yi]입니다.
		두 점 [xi, yi]와 [xj, yj]를 연결하는 비용은 두 점 사이의 맨해튼 거리입니다.
		|xi - xj| + |yi - yj|, 여기서 |val|은 val의 절대값을 나타냅니다.
		모든 포인트를 연결하기 위한 최소 비용을 반환합니다.
		두 점 사이에 정확히 하나의 단순 경로가 있는 경우 모든 점이 연결됩니다.
		
	@Example
		Example 1:
			Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
			Output: 20
			Explanation: 
			We can connect the points as shown above to get the minimum cost of 20.
			Notice that there is a unique path between every pair of points.
			위와 같이 포인트를 연결하여 최소 비용 20을 얻을 수 있습니다.
			모든 점 쌍 사이에는 고유한 경로가 있습니다.

		Example 2:
			Input: points = [[3,12],[-2,5],[-4,1]]
			Output: 18

	@Constraints
		1 <= points.length <= 1000
		-106 <= xi, yi <= 106
		All pairs (xi, yi) are distinct.
		
	@history
		N = 모든 포인트를 연결하기 위한 최소 비용
		최대한 한번에 많은 점 가기..
		가중치가 있는 최소비용 구하기니까 bfs
		7-5 + 0-2
		=2+2 = 4
		2차원행렬로 표시해보기
		3+2, 12-5 = 5+7 = 12
		-4+2,5-1 = -2+4 = 2
		3+4,12-1 = 7+11 = 18
		
		|xi - xj| + |yi - yj|
		3+2, 12-5 = 5+7 = 12
		2+4,5-1 = 6+4 = 10
		3+4,12-1 = 7+11 = 18
		
		 [[3,12],[-2,5],[-4,1]]
		x-y=0
		3-12=음수
		-2-5=음수
		=> 부호가 같으므로 y=x 기준으로 같은 쪽에 있음
		
		
		
	@Date
		2022. 8. 8.
 */

//좌표값 저장할 클래스
class Coordinate {
	int X; // x값
	int Y; // y값

	public Coordinate(int[] points) {
		super();
		this.X = points[0];
		this.Y = points[1];
	}

	// 두 점 사이의 거리
	public int setWeight(Coordinate nextPoint) {
		return Math.abs(this.X - nextPoint.X) + Math.abs(this.Y - nextPoint.Y);
	}
}

//좌표값 간의 거리를 저장할 클래스
class Edge implements Comparable<Edge> {
	int V; // 노드
	int W; // 가중치

	public Edge(int V, int W) {
		super();
		this.V = V;
		this.W = W;
	}

	@Override
	public int compareTo(Edge e) {
		return (int)(this.W - e.W); // 가중치 비교
	}
}

public class min_cost_to_connect_all_points_1584 {
	static int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};

	//{{3,12},{-2,5},{-4,1}};
	public static void main(String[] args) {
		PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(); // 비용을 오름차순으로 정렬하는 Queue. 트리와의 거리를 기록하고 거리가 짧은 순서가 먼저 poll한다.
		boolean[] visited = new boolean[points.length];
		int minimumCost = 0; // 모든 포인트를 연결하기 위한 최소 비용
		
		// 3번 방법 - 우선순위 큐 안쓰고 직접 거리 비교 - https://leetcode.com/problems/min-cost-to-connect-all-points/discuss/843972/Java-Minimum-Spanning-Tree%3A-Prim-%2B-Kruskal
		
		/*
		// 2번 방법 - 인접리스트 만들고 우선순위 큐로 BFS
		List<Edge>[] coordinates = new ArrayList[points.length];
		
		// 인접리스트에 초기화
		for (int i = 0; i < points.length; i++) {
			coordinates[i] = new ArrayList<>();
		}
		
		// 인접리스트 값 초기화는 할 필요가 없는 게 어차피 리스트의 배열이기 때문에 각 인덱스가 points의 인덱스와 동일하게 들어갈 것임
		
		
			다른 좌표와의 비용 탐색하기 위해서 연결된 선들을 다 만들어 줌. 어차피 다 돌아야하는거니까 굳이 queue는 쓸 필요가 없다.
			각 턴마다 가중치들이 계산되면서 edgeQueue에다가 저장되는 것
			현재 점과 방문하지 않은 해당 점의 비용을 계산해서 간선 큐에 저장해서 인접리스트를 만든다.
		
		for( int targetIndex=0;targetIndex<points.length;targetIndex++ ){
			Coordinate c = new Coordinate(points[targetIndex]);
			for( int nextIndex=0;nextIndex<points.length;nextIndex++ ){ 
				if( targetIndex!=nextIndex && !visited[nextIndex] ){
					coordinates[targetIndex].add( new Edge(nextIndex, c.setWeight(new Coordinate(points[nextIndex]))) );
				}	
			}
		}
		
		edgeQueue.add( new Edge(0,0) );
		
		// BFS
		while( !edgeQueue.isEmpty() ){
			Edge e = edgeQueue.poll();
			if (visited[e.V]) { // 거리가 제일 짧으면서 트리 구성 하지 않은, 제일 처음으로 만나는 애일 때 여기로 들어오게 되고 값 더해주고 나가게 됨
				continue;
			}
			visited[e.V] = true; //방문 여부 표시(트리 추가됨을 표시함)
			minimumCost += e.W;
			
			for( Edge c : coordinates[e.V] ){
				if ( !visited[c.V] ) { // 거리가 제일 짧으면서 트리 구성 하지 않은, 제일 처음으로 만나는 애일 때 여기로 들어오게 되고 값 더해주고 나가게 됨
					edgeQueue.add(c);
				}
			}
			
		}
		*/
		/*
		// 1번 방법
		Queue<Integer> queue = new LinkedList<Integer>();
		List<Coordinate> coordinates = new ArrayList<>();
		int edgeCount = 0; //edge의 개수 측정을 위한 선언, 트리의 edge는 N-1개
		
		// 인접리스트에 값 초기화
		for (int i = 0; i < points.length; i++) {
			coordinates.add(new Coordinate(points[i]));
		}
		
		queue.add(0); // 시작정점 저장
		
		// BFS. 가중치 계산
		while (!queue.isEmpty()) {
			int startIndex = queue.poll(); // 간선	
			visited[startIndex] = true; //방문 여부 표시(트리 추가됨을 표시함)
			Coordinate c = coordinates.get(startIndex); // 시작점에 해당되는 객체를 뺀다.
			for( int i=0;i<points.length;i++ ){ // 다른 좌표와의 비용 탐색
				if( !visited[i] ){ // 방문 유무에 따라 그래프에 사이클이 생기는지 확인. startIndex==i일 때를 따로 두지 않은 건 결국엔 visited로 검사하기 때문에
					edgeQueue.add( new Edge(i, c.setWeight(coordinates.get(i))) ); // 현재 점과 방문하지 않은 해당 점의 비용을 계산해서 간선 큐에 저장.
					// 각 턴마다 가중치들이 계산되면서 edgeQueue에다가 저장되는 것
				}	
			}
			
			while( !edgeQueue.isEmpty() ){
				Edge e = edgeQueue.poll();
				if (!visited[e.V]) { // 거리가 제일 짧으면서 트리 구성 하지 않은, 제일 처음으로 만나는 애일 때 여기로 들어오게 되고 값 더해주고 나가게 됨 
					minimumCost += e.W;
					edgeCount++;
					queue.add(e.V);
					break;
				}
			}
			
			if( edgeCount==points.length-1 ){
				break;
			}
		}
		*/

		System.out.println(minimumCost);
	}

}