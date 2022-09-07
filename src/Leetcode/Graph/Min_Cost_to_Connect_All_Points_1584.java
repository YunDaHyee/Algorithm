/**
 * 
 */
package Graph;

/**
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

public class Min_Cost_to_Connect_All_Points_1584 {
	static boolean[][] check;
	public static void main(String[] args) {
		int[][] points =
		{{0,0},{2,2},{3,10},{5,2},{7,0}};
		// {{3,12},{-2,5},{-4,1}};
		
		int[][] matrix = new int[107][107];
		
		// 초기화
		for( int[] coordinate:points ){
			int x = Math.abs(coordinate[0]);
			int y = Math.abs(coordinate[1]);
			matrix[x][y] = 1;
		}
		
		System.out.println(matrix);
	}
}
