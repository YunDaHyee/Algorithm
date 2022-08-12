package Basic_Level._5_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
	@Question
		그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
		단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
		정점 번호는 1번부터 N번까지이다.
	@Input
		첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
		다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
		어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
		입력으로 주어지는 간선은 양방향이다.
		1.
		4 5 1
		1 2
		1 3
		1 4
		2 4
		3 4
		
		2.
		5 5 3
		5 4
		5 2
		1 2
		3 4
		3 1
		
		3.
		1000 1 1000
		999 1000
	@Output
		첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.
		V부터 방문된 점을 순서대로 출력하면 된다.
		
		1.
		1 2 4 3
		1 2 3 4
		
		2.
		3 1 2 5 4
		3 1 4 2 5
		
		3.
		1000 999
		1000 999
	@history
		예전이랑 비교해보면
		특정 처리를 할 떄에 왜 그걸 해주는지에 대해서 정확하게 알 수 있게 된 것 같다.

	@Date
		2022. 8. 12.
 */

public class _1260_v2 {
	static List<Integer>[] aList; // 인접리스트
	static boolean[] check1; // 방문 여부 배열
	static boolean[] check2; // 방문 여부 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] info = br.readLine().split(" ");
		
		aList = new ArrayList[Integer.parseInt(info[0])+1]; // 정점 개수만큼 크기 설정
		//check1 = check2 = new boolean[aList.length]; // 아 이렇게 하니까 같은 레퍼런스라서 같은 값 공유하네;;
		check1 = new boolean[aList.length]; // 정점 개수만큼 크기 설정
		check2 = new boolean[aList.length];
		
		// 인접리스트 초기화
		for(int i=1;i<=Integer.parseInt(info[0]);i++ ){ //간선개수만큼 입력 받기
			aList[i] = new ArrayList<Integer>();
		}
		
		// 그래프값 저장 - 그래프의 값을 인접리스트에 넣어주기
		for(int i=0;i<Integer.parseInt(info[1]);i++ ){ //간선개수만큼 입력 받기
			String[] nodes = br.readLine().split(" ");
			int A = Integer.parseInt(nodes[0]);
			int B = Integer.parseInt(nodes[1]);
			aList[A].add( B ); 
			aList[B].add( A ); 
		}
		
		/* 
		 	`방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문한다.`
		 	라는 조건이 있기 때문에 오름차순으로 정렬을 해줌
		 	< 두 번째 예제 >
		 	
		 	- BEFORE 
		 	리스트 = [2, 3], [5, 1], [4, 1], [5, 3], [4, 2]
		 	결과 =
		 	3 4 5 2 1 
			3 4 1 5 2 
			
		 	- AFTER
		 	리스트 = [2, 3], [1, 5], [1, 4], [3, 5], [2, 4]
		 	결과 =
		 	3 1 2 5 4 
			3 1 4 2 5 
		 */
		for(int i=1;i<=Integer.parseInt(info[0]);i++ ){
			aList[i].sort( Comparator.naturalOrder() );
		}
		
		// 그래프 탐색 - 탐색 시작 정점 번호를 넣음
		DFS( Integer.parseInt(info[2]) );
		System.out.println();
		BFS( Integer.parseInt(info[2]) );
		
		br.close();
	}

	private static void DFS(int node) {
		if( check1[node] ){
			return;
		}
		
		// void로 해놨으니까 보여지는 건 어디 자료구조에 저장안하고 그냥 출력만 하면 돼.
		System.out.print(node+" ");
		
		check1[node] = true; // 방문 표시
		
		// 해당 node로 갈 수 있는 데까지 깊게 들어가는 것
		for( int i:aList[node] ){
			DFS(i);
		}
		/*
			 for( int i=0;i<aList[node].size();i++ ){ // aList 안의 각각의 배열은 인덱스 0부터 시작하니까
				DFS(aList[node].get(i));
			}
		*/
	}
	
	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();

		// 시작점에 대한 초기화
		queue.offer(node); // 탐색에 이용할 큐에다가 시작점 올리기
		check2[node] = true; // 방문함
		
		// 탐색 시작 - 큐가 빌 때까지
		while( !queue.isEmpty() ){
			int currentTargetNode = queue.poll(); // 현재 노드 빼주기
			System.out.print(currentTargetNode+" "); // 현재 노드 출력해서 방문 표시
			for( int connectedNode : aList[currentTargetNode] ){ // 간선이 있는 것만 돌림
				if( !check2[connectedNode] ){ // 방문 안했으면
					queue.offer(connectedNode); // 큐에다가 연결된 노드 올리기
					check2[connectedNode] = true; // 방문함
				}
			}
		}
	}
}