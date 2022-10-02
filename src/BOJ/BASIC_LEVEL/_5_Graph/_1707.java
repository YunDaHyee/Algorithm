package BASIC_LEVEL._5_Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 	문제
		그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때, 그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.
		그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.
	
	입력
		입력은 여러 개의 테스트 케이스로 구성되어 있는데, 첫째 줄에 테스트 케이스의 개수 K(2≤K≤5)가 주어진다.
		각 테스트 케이스의 첫째 줄에는 그래프의 정점의 개수 V(1≤V≤20,000)와 간선의 개수 E(1≤E≤200,000)가 빈 칸을 사이에 두고 순서대로 주어진다.
		각 정점에는 1부터 V까지 차례로 번호가 붙어 있다.
		이어서 둘째 줄부터 E개의 줄에 걸쳐 간선에 대한 정보가 주어지는데, 각 줄에 인접한 두 정점의 번호가 빈 칸을 사이에 두고 주어진다.
		2	// 테스트 케이스 개수(총 2번)
		3 2 // 정점개수 간선개수 (1번)
		1 3 // ▼ 간선들
		2 3
		4 4 // 정점개수 간선개수 (2번)
		1 2 // ▼ 간선들
		2 3
		3 4
		4 2
	
	출력
		K개의 줄에 걸쳐 입력으로 주어진 그래프가 이분 그래프이면 YES, 아니면 NO를 순서대로 출력한다.
		YES
		NO
		
	History
		문제 이해가 잘 안됨 ....ㅠ 간선들의 열이 각 그룹이란 소린가.. 
		이분그래프라고 해서 나는 세로로 된 열이 왼쪽 오른쪽 그룹이라고 생각했었음.
		
 */
public class _1707 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int			cnt = Integer.parseInt( br.readLine() );	// 테스트 케이스 개수
		
		while( cnt-->0 ) {
			String[]	raw = br.readLine().split(" ");
			int			V	= Integer.parseInt( raw[0] );			// 정점 개수
			int			E	= Integer.parseInt( raw[1] );			// 간선 개수
			
			List<Integer>[] aList	= new ArrayList[V+1];			// 인접리스트
			int[]			check	= new int[V+1];					// check - 얘가 color 역할. => 0 : 방문 x / 1 : 방문했는데 그룹번호 1 / 2: 방문했는데 그룹번호 2 
			boolean			flag	= true;							// 이분그래프 구분 Flag
			
			// 초기화
			for( int j=1;j<=V;j++ ) {
				check[j] = 0;
				aList[j] = new ArrayList<Integer>();
			}
			
			// 값 초기화
			for( int j=0;j<E;j++ ) {
				raw = br.readLine().split(" ");
				int from = Integer.parseInt( raw[0] );
				int to = Integer.parseInt( raw[1] );
				aList[from].add(to);
				aList[to].add(from);
			}
			
			// aList : [null, [2], [1, 3, 4], [2, 4], [3, 2]]
			
			// DFS
			// 그룹번호 부여 작업
			for( int j=1;j<=V;j++ ) {
				if( check[j]==0 ) {
					dfs( aList, check, j, 1 ); // 맨 첨의 그룹번호는 1이기 땜에 1넣음
				}
			}
			
			// 겹치는 그룹번호 구분 작업
			for( int j=1;j<=V;j++ ) {
				for( int k : aList[j] ) {
					// 1: [0, 1, 2, 1, 2] , 2: [0,1,1,2] 일 때, aList는 3 3 1,2인데
					// check[1]과 check[3], check[2]과 check[3], check[3]과 check[1] & check[3]과 check[2]가 그룹번호가 같은지 알아보는 것임
					if( check[j]==check[k] ) { 
						flag = false;
						break;
					}
				}
			}
			
			// 이분그래프인지 아닌지 판단
			if( flag ) {
				bw.write("YES\n");
			}else {
				bw.write("NO\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

	// DFS
	private static void dfs(List<Integer>[] aList, int[] check, int V, int groupNum) {
		check[V] = groupNum;
		// aList : [null, [2], [1, 3, 4], [2, 4], [3, 2]]
		// 1: [2] ->2:[1, 3, 4]->3:[2, 4]->4:[3, 2]
		for( int next : aList[V] ){ // for( int i=0;i<aList[V].size();i++ ) { //foreach로 사용하기!
			if( check[next]==0 ){ // 아직 방문안했으면 재귀
				dfs(aList, check, next, 3-groupNum);
				// 처음엔 1로 들어왔으면 그 다음 번호는 2가 되어야 하니까(2+1=3인 점을 이용)
				// 정점이 똑같은 게 들어오면 번호가 다르게 매겨지겠지..??
			}
		}
	}

}
