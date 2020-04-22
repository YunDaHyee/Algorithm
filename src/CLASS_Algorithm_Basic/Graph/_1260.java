package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
		첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
		1.
		1 2 4 3
		1 2 3 4
		
		2.
		3 1 2 5 4
		3 1 4 2 5
		
		3.
		1000 999
		1000 999
	@History
		Comparator.naturalOrder() : 오름차순 정렬
 *
 */
public class _1260 {

	static List<Integer>[] aList;								// 인접리스트. 0은 걍 바로 넣는 것이기 떔에
	static Boolean[]		check;								// 방문 체크 배열
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws IOException {

		String[]	raw = br.readLine().split(" ");
		int			N	= Integer.parseInt( raw[0] );	// 정점
		int			M	= Integer.parseInt( raw[1] );	// 간선
		int			V	= Integer.parseInt( raw[2] );	// 시작 정점
		
		aList = new ArrayList[N+1];
		check = new Boolean[N+1];
		
		// 인접리스트 초기화
		for( int i=1;i<=N;i++ ){ // 실제 인덱스에 마주처서 하려고 0은 일부러 비워두는 것 같다!
			aList[i] = new ArrayList<Integer>();
			check[i] = false;
		}
		
		// 인접리스트 값 넣기
		for( int i=0;i<M;i++ ){
			raw = br.readLine().split(" ");
			int from	= Integer.parseInt(raw[0]);
			int to		= Integer.parseInt(raw[1]);
			aList[from].add(to); // 양방향이니까
			aList[to].add(from); // 두번 해주기
		}
		// aList = [[1,2], [2,3],... ] 
		
		// 정렬 하는 이유가 제일 작은 번호를 0에 위치시킬라고 하는가보다.
		for( int i=1;i<=N;i++ ){
			aList[i].sort( Comparator.naturalOrder() );
		}
		
		
		dfs(V);
		bw.write("\n");
		
		//초기화 또..해주기..ㅠ
		for( int i=1;i<=N;i++ ){ // 실제 인덱스에 마주처서 하려고 0은 일부러 비워두는 것 같다!
			check[i] = false;
		}
		
		bfs(V);
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int V) throws IOException{
		// 1. 스택 직접 안쓰는 구현 - 재귀로 풀기 - 어차피 aList 안에 또 배열이 있으니까 그 자체가 이미 스택임 => 이게 더 빠르다!
		if( check[V] ){ // 이미 방문한 적 있으면 재끼기
			return; // 리턴하면 dfs를 호출한 부분으로 들어감. 그래서 다시for문 쪽으로 가는거야.
		}
		
		check[V] = true;
		
		bw.write( V + " " );
		
		for( int i : aList[V] ){ // 정점 V 중에 방문하지 않은 곳이 있다면
			if( !check[i] ){
				dfs(i);
			}
		}
		
		
		// 2. 스택 직접 쓰는 구현
		/*
		Stack<Integer> stack = new Stack<Integer>();		// 스택
		stack.push(V);
		check[V] = true;
		bw.write( V + " " );
		
		while( !stack.isEmpty() ){
			boolean flag = false;
			V = stack.peek();
			
			for( int i=0;i<aList[V].size();i++ ){ // dfs 함수 들어오기전에 정렬 했으니까 0부터가 젤 작은 수임. 그래서 forEach말고 for문 돌려야돼
				int next = aList[V].get(i);
				
				if( !check[next] ){	// next가 방문하지 않은 정점일 때
					stack.push(next); //5
					check[next] = true;
					bw.write( next + " " );
					flag = true;
					break;
				}
			}
			
			if( !flag ){
				stack.pop();
			}
		}
		*/
	}
	
	public static void bfs(int V) throws IOException { // 큐를 난 전역으로 선언했었는데 이 안에서 걍 하면 되는구나. 어차피 여기서 aList 갖고 출력 다하고 하는거니까 그러는 게 맞네.
		Queue<Integer> queue = new LinkedList<Integer>();	// 큐

		// 찐 Start에 대한 설정
		queue.add( V );
		check[V] = true;

		while( !queue.isEmpty() ){
			V = queue.poll();
			bw.write( V + " " );
			for( int i : aList[V] ){
				if( !check[i] ){
					check[i] = true;
					queue.offer(i);
				}
			}
		}
	}
	
}

/*
 	간선리스트로 푸는 법. cnt 함수 이용하는 걸 내가 13023에서 안해봤었는데 시간나면 해보기 꼭
 	
 	import java.util.*;
class Edge implements Comparable<Edge> {
    int from, to;
    Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
    public int compareTo(Edge that) {
        if (this.from < that.from) {
            return -1;
        } else if (this.from == that.from) {
            if (this.to < that.to) {
                return -1;
            } else if (this.to == that.to) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
public class Main {
    static Edge[] edge;
    static int[] cnt;
    static boolean[] check;
    static void dfs(int node) {
        check[node] = true;
        System.out.print(node + " ");
        for (int i=cnt[node-1]; i<cnt[node]; i++) {
            int next = edge[i].to;
            if (check[next] == false) {
                dfs(next);
            }
        }
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start] = true;
        while (!q.isEmpty()) {
            int node = q.remove();
            System.out.print(node + " ");
            for (int i=cnt[node-1]; i<cnt[node]; i++) {
                int next = edge[i].to;
                if (check[next] == false) {
                    check[next] = true;
                    q.add(next);
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        edge = new Edge[2*m];
        cnt = new int[n+1];
        check = new boolean[n+1];
        for (int i=0; i<m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            edge[i] = new Edge(from, to);
            edge[m+i] = new Edge(to, from);
        }
        m *= 2;
        Arrays.sort(edge);
        for (int i=0; i<m; i++) {
            cnt[edge[i].from] += 1;
        }
        for (int i=1; i<=n; i++) {
            cnt[i] += cnt[i-1];
        }
        dfs(start);
        System.out.println();
        check = new boolean[n+1];
        bfs(start);
        System.out.println();
    }
}
 	
 
 */
