package Basic_Level._6_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 	@Question
		루트 없는 트리가 주어진다.
		이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
		
	@Input
		첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다.
		둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
		1.
		7
		1 6
		6 3
		3 5
		4 1
		2 4
		4 7
		
		2.
		12
		1 2
		1 3
		2 4
		3 5
		3 6
		4 7
		4 8
		5 9
		57 10
		6 11
		6 12
	@Output
		첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
		1.
			4
			6
			1
			3
			1
			4
		
		2.
			1
			1
			2
			3
			3
			4
			4
			5
			5
			6
			6
	@history
		연결된 두 정점이니까 둘 다 연결되어어야함.
		연결된 정점만 생각하려면 인접리스트로 하는 게 더 나을 것 같아서 NODE 클래스를 이용하지 않았다.
		
		출력할 때 parent 배열에 있는 그대로 출력했더니 답이랑 달라가지고 당황했는데
		각 노드에 맞춰서 부모노드를 출력하는 것이었다.
		
		풀었는데 시간이 너무 오래 걸린다. 다른 방법이 없나?
		그래서 나름 생각한 방법으로 
		모든 수를 받을 100,001 크기의 배열과 입력한 숫자 중 최대값만큼의 크기를 가지는 배열을 뒀다.
		처음엔 첫 번째 배열에서 값을 다 받고 그 중에 max 값을 추려내서 그 만큼의 크기를 갖도록 함.
		근데 더 느리다.
		어차피 처음에 100,000번 도는 것은 같기 때문이지 싶다.
		
		예제 중에 57와 10의 입력이 있었는데 잘못 복사된 예제였다..ㅎㅎ..
		문제와 예제를 잘 보자..
		그런데도 시간이 느리다..ㅜㅜ
		
		
	@Date
		2022. 8. 25.
 */
public class _11725 {
	static boolean[]		check;
	static int[]			parents;
	static List<Integer>[]	nodes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		parents	= new int[N+1];
		check	= new boolean[N+1];
		nodes	= new ArrayList[N+1];
		
		for( int i=1;i<=N;i++ ){
			nodes[i] = new ArrayList<Integer>();
		}
		
		// 노드 값 초기화
		for( int i=1;i<N;i++ ){
			String[] node = br.readLine().split(" ");
			int A = Integer.parseInt(node[0]);
			int B = Integer.parseInt(node[1]);
			nodes[A].add(B);
			nodes[B].add(A);
		}
		
		// 순회
		traversal();
		
		for( int parent : parents ){
			if( parent==0 ) continue;
			System.out.println(parent);
		}
	}

	private static void traversal() {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// 루트노드에 대한 초기화
		queue.offer(1);
		check[1] = true;
		
		while( !queue.isEmpty() ){
			int node = queue.poll();
			for( int n : nodes[node] ){
				if( !check[n] ){
					queue.offer(n);
					check[n] = true;
					parents[n] = node;
				}
			}
		}
	}
}