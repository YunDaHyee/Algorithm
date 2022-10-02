package BASIC_LEVEL._5_Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
		
 */
public class _11724 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		String[]	raw = br.readLine().split(" ");
		int			N	= Integer.parseInt(raw[0]); // 정점
		int			M	= Integer.parseInt(raw[1]); // 간선
		
		boolean[]	check	= new boolean[N+1];
		int			cnt		= 0;// 연결요소 개수
		
		// 인접리스트 구현
		 List<Integer>[] aList	= new ArrayList[N + 1];
		
		// 초기화
		for (int i = 1; i <= N; i++) {
			check[i] = false;
			aList[i] = new ArrayList<Integer>();
		}

		// 값 초기화
		for (int i = 0; i < M; i++) {
			raw = br.readLine().split(" ");
			int from = Integer.parseInt(raw[0]);
			int to = Integer.parseInt(raw[1]);
			aList[from].add(to);
			aList[to].add(from);
		}
		//					1		2		3	4		5		6
		// aList : [null, [2, 5], [1, 5], [4], [3, 6], [2, 1], [4]]

		for( int i=1;i<=N;i++ ) {
			if( !check[i] ) {
				// DFS
				dfs( aList, check, i );
				cnt++;
				
				// BFS
				// bfs( aList, check, i ); // 한번 넘겼을 때, 그 한번에 담겨져 있는 정점들의 연결고리들을 다 탐색하다가 돌아오는거지
			}
		}
		
		bw.write( String.valueOf(cnt) );

		br.close();
		bw.flush();
		bw.close();
	}
	
	// DFS - 인접리스트 구현
	static void dfs( List<Integer>[] aList, boolean[] check, int N ) {
		if( check[N] ) {
			return;
		}
		
		check[N] = true;
		
		for( int i=0;i<aList[N].size();i++ ) { // 1. [2,5]->[1, 5]->[2, 1].......... 2.  3:[4]->4:[3, 6]->6:[4]
			int next = aList[N].get(i);
			if( !check[next] ) {
				dfs( aList, check, next );
			}
		}
	}
	
	// BFS - 인접리스트 구현
	/*
	static void bfs( List<Integer>[] aList, boolean[] check, int N ) {
		Queue<Integer>	queue = new LinkedList<Integer>();
		
		// 시작점 설정
		queue.add( N );
		check[ N ] = true;
		
		while (!queue.isEmpty()) {
			int V = queue.poll();
			for (int i = 0; i < aList[V].size(); i++) { //1->2->5
				int next = aList[V].get(i); // 1. [2,5]->[1, 5]->[2, 1].......... 2.  3:[4]->4:[3, 6]->6:[4]
				if (!check[next]) { // 방문 안했으면
					queue.offer(next);
					check[next] = true;
				}
			}
		}
	}
	*/
}
