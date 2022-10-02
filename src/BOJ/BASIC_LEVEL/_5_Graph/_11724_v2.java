package BASIC_LEVEL._5_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 
	@Question
		방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
	
	@Input
		첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2)
		둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v)
		같은 간선은 한 번만 주어진다.
		
		1.
		6 5
		1 2
		2 5
		5 1
		3 4
		4 6
	
		2.
		6 8
		1 2
		2 5
		5 1
		3 4
		4 6
		5 4
		2 4
		2 3
		
	@Output
		첫째 줄에 연결 요소의 개수를 출력한다.
		1. 2
		2. 1
	@History
		BFS로 푼다.
		{ {2,5} , .. }
		
		하나의 연결요소 조건 = 하나의 그래프(연결요소에 있는 것들)의 정점들이 연결되어 있어야 하고 다른 정점으로 가는 방법이 없어야 한다.
		하나의 정점 안에서 다 돌면 answer++라고 생각했는데
		인풋값을 눈으로 봤을 때는 이게 한 점이 싸이클 만드는 게 보이는거지,
		하나의 정점안에는 여러가지 요소가 더 있을 수 있으니까
		뭔가 다른 척도가 필요함
		
		모르겠어서 답을 참조함.
		for문을 바깥에서 돌리는 걸 이용을 해야한다.
		그래야 인접리스트 배열의 모든 요소들에 접근을 할 수 있기 때문이다.
		DFS,BFS 안에서 모든 것을 다 해결하려고 하지말고 그 방법들을 가지고 다른 것도 응용하면서 하는 생각을 기르기
		
		- 자료구조
		인접행렬보다 인접리스트가 보통은 빠르다고 해서 그걸로 구현했는데
		이 문제에서는 임의의 두 정점 사이에 (u,v) 간선이 있는지 없는지를 확인해야하므로
		인접행렬이 더 빠르게 풀린다.
		
 */
public class _11724_v2 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[]	raw = br.readLine().split(" ");
		int			N	= Integer.parseInt(raw[0]); // 정점
		int			M	= Integer.parseInt(raw[1]); // 간선
		
		List<Integer>[] adjList		= new ArrayList[N+1];		// 인접 리스트
		boolean[][]		adjMatrix	= new boolean[N+1][N+1];	// 인접 행렬 
		
		// BFS 용 변수
		Queue<Integer>	queue	= new LinkedList<Integer>();
		boolean[]		check	= new boolean[N+1];
		int				answer	= 0;

		// DFS 용 변수
		boolean[]		check2	= new boolean[N+1];
		int				answer2	= 0;
		
		// 인접리스트 - 초기화
		for( int i=1;i<=N;i++ ){
			adjList[i] = new ArrayList<Integer>();
		}
		
		// 그래프의 값 저장 - 1. 인접리스트에 값 초기화
		for( int i=0;i<M;i++ ){
			raw = br.readLine().split(" ");
			int A = Integer.parseInt(raw[0]);
			int B = Integer.parseInt(raw[1]);
			adjList[A].add(B);
			adjList[B].add(A);
		}
		
		// 그래프의 값 저장 - 2. 인접행렬에 값 초기화
		for( int i=0;i<M;i++ ){
			raw = br.readLine().split(" ");
			int A = Integer.parseInt(raw[0]);
			int B = Integer.parseInt(raw[1]);
			adjMatrix[A][B] = adjMatrix[B][A] = true;
		}
		
		// BFS
		for( int i=1;i<=N;i++ ){
			if( !check[i] ){
				queue.offer(i);
				check[i] = true;
				while( !queue.isEmpty() ){
					int start = queue.poll();
					for( int node : adjList[start] ){
						if( !check[node] ){
							queue.offer(node);
							check[node] = true;
						}
					}
				}
				answer++;
			}
		}
		
		// DFS
		for( int i=1;i<=N;i++ ){
			if( check2[i] ){
				continue;
			}
			// DFS( adjList, check2, i );	// 인접리스트 사용
			DFS( adjMatrix, N, check2, i ); // 인접행렬 사용
			answer2++;
		}
		
		System.out.println(answer);
		System.out.println(answer2);
		
		br.close();
	}
	
	// DFS
	static void DFS(boolean[][] adjMatrix, int N, /*List<Integer>[] adjList,*/ boolean[] check2, int start ) {
		check2[start] = true;
		
		// 인접리스트
		/*
		for( int node : adjList[start] ){
			if( !check2[node] ){
				DFS( adjList, check2, node );
			}
		}
		*/
		
		// 인접행렬
		for( int i=1;i<=N;i++ ){
			if( adjMatrix[start][i] && !check2[i] ){
				DFS( adjMatrix, N, check2, i );
			}
		}
	}
	
}
