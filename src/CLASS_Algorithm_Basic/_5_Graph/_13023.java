package _5_Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

//import javafx.util.Pair;

/**
 * 
	@Question
		BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다.
		사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.
		
		오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.
		
		A는 B와 친구다.
		B는 C와 친구다.
		C는 D와 친구다.
		D는 E와 친구다.
		
		위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.
		
	@Input
		첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.
		둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b)
		같은 친구 관계가 두 번 이상 주어지는 경우는 없다.
		1.
		5 4
		0 1
		1 2
		2 3
		3 4
		
		2.
		5 5
		0 1
		1 2
		2 3
		3 0
		1 4
		
		3.
		6 5
		0 1
		0 2
		0 3
		0 4
		0 5
		
		4.
		8 8
		1 7
		3 7
		4 7
		3 4
		4 6
		3 5
		0 4
		2 7
		
	@Output
		문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.
		1. 1
		2. 1
		3. 0
		4. 1
		
	@History
		정점 : N / 간선 : M.
		간선만큼 반복문 진행.
		문제 요지 : (A - (B) - (C )- (D) -E)인 관계냐? 1 / 0
		
		다했는데 런타임에러가 난다.. 왤까? 존나 짱난다 시발 하루종일 이것만 했는데...하 -> 틀린이유 : 1로 나오고 시스템 종료 되기 전에 bw.flush() 안해줘서..;;; 출력이 안되어서 틀렸다고 뜬 듯..
		
		
 */
public class _13023 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );

		String[] raw = br.readLine().split(" ");
		int N = Integer.parseInt( raw[0] ); // 정점 = 사람
		int M = Integer.parseInt( raw[1] ); // 간선 = 관계 수
		
		boolean[][]				adjacencyMatrix	= new boolean[N][N];		// 인접행렬. A[i]이니까 i만큼. 즉 사람 수 만큼임
		List<Integer>[]			adjacencyList	= new ArrayList[N];			// 인접리스트. 기록3 - 배열의 초기화를 첨 깨닫다;;ㅅㅂ;; 근데 해줘도 인덱스 접근이 안됨..ㅠ 배열로 이요하고자 할 떄는 리스트 함수를 쓰더라도 배열을 쓰자. List<Integer>[] 일케. 그러면 사이즈를 지정함과 동시에 인덱스로의 접근이 가능해진다!! 나는 int/string 이런것만 해야할줄알았는데 미처 생각을 그까지 못했다!꿀팁이다!!
		List<Edge> edgeList						= new ArrayList<Edge>();	// 간선리스트

		// 기록4. 초기화를 간단하게 할 수 있는 함수는 없다. 반복문은 돌려줘야만함.. 어쩔 수 없다.
		for (int i=0; i<N; i++) {
            adjacencyList[i] = new ArrayList<Integer>(); // [ [],[],[],[],[] ]형태가 됨
        }
		
		//boolean flag = false;  - ●
		
		// 1. 값 넣기
		for( int i=0;i<M;i++ ){
			raw			= br.readLine().split(" ");
			int from	= Integer.parseInt( raw[0] );
			int to		= Integer.parseInt( raw[1] );
			
			//인접행렬, 인접리스트, 간선리스트 순으로 넣고 있음. 두번씩 넣는 이유는 양방향이기 때문.
			adjacencyMatrix[from][to] = adjacencyMatrix[to][from] = true;
			adjacencyList[from].add(to); // 기록2. 초기화가 안됐는데 어떻게 인덱스로 접근해야할까.. 정점들이 많을지 모르니까 초기화를 내 맘대로 할 수도 없다.<-이게 고민이었는데 기록3을 통해 깨닳음. 그러면 [ [1],[],[],[3,1],[] ] 이런형태가 돼!  
			adjacencyList[to].add(from);
			edgeList.add( new Edge(from, to) );
			edgeList.add( new Edge(to, from) );
			/*
			// Pair 클래스를 이용
			edgeList.add( new Pair<Integer, Integer>(from, to) );
			edgeList.add( new Pair<Integer, Integer>(to, from) );
			*/
		}
		
		M*=2; // 양방향이기 떄문에 친구관계도 두배
		
		// 2. 관계 구하기
		for( int i=0;i<M;i++ ){
			for( int j=0;j<M;j++ ){
				 // 키가 1.. 하시발 맵으로 하면 키가 겹치는데 어떻게 함?ㅋㅋㅋㅋㅋㅋㅋ
				//--> 기록1: 처음에 Map으로 했었는데 키의 중복을 처리할 수 없어서 Pair라는 클래스를 처음 써봄..근데 클래스 직접 만들어서 하는 방식으로 하는 게 코테 직접 할 때 더 현실성 있는 듯..?
				int A = edgeList.get(i).from;
				int B = edgeList.get(i).to;
				int C = edgeList.get(j).from;
				int D = edgeList.get(j).to;
				/*
				// Pair 클래스를 이용
				int A = edgeList.get(i).getKey();
				int B = edgeList.get(i).getValue();
				int C = edgeList.get(j).getKey();
				int D = edgeList.get(j).getValue();
				 */
				
				// 간선리스트 : 모든 간선 구하기 O(차수) -> A-B,C-D 관계 구하기
				if( A == B || A == C || A == D || B == C || B == D || C == D ){
					continue;
				}
				
				// 인접행렬 : 임의의 두 정점이 연결되어있는지 아닌지를 알기 위함 O(1) -> B-C 관계 구하기
				if( !adjacencyMatrix[B][C] ){
					continue;
				}
				
				// 인접리스트 : 한 정점과 연결된 모든 간선을 구하기 O(차수) -> D-E 관계 구하기
				//for( int E=0;E<adjacencyList.length;E++ ){ // 기록5. 이렇게 하면 adjacencyList의 인덱스마다 다 조회하는 거니까 넘 커짐.. D랑 연결된 정점만 구하면 되니까 D배열만 조회하면돼
				for( int E : adjacencyList[D] ){
					if( E == A || E == B || E == C || E == D ){
						continue;
					}
					bw.write(1);
					//flag = true; - ●
					//break; - ●
					bw.flush();
					System.exit(0); // 헐.. 처음 알았음....아예 프로그램 종료하는건가봐;; flag 쓰고 break문 걸고 했는데 이럴필요 없겠다...!!꿀팁..!! break 걸어서 처리한 로직은 ●들  
				}
				
				// if( flag ) break; - ●
			} // for2
			
			/* - ●
			if( flag ){
				break;
			}else{
				if( i==M-1 ){
					bw.write( 0+"\n" );
				}
			}
			*/
			
		}//for 1
		
		bw.write(0);
		
		br.close();
		bw.flush();
		bw.close();
	}
	
}

// 클래스 직접 만들어서 사용. 특정한 한 쌍을 이용한 구현이 필요하다면 내가 클래스 만들어서 하기
class Edge{
	int from, to;
	Edge(int from, int to){
		this.from = from;
		this.to = to;
	}
}
