package Basic_Level._6_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 	@Question
		이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.
		  	A              0 
		  B	  C         1     2
		D	 E	F    3      4   5
				 G               6
		예를 들어 위와 같은 이진 트리가 입력되면,
		
		전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
		중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
		후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
		가 된다.
	@Input
		첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다.
		둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다.
		노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다.
		자식 노드가 없는 경우에는 .으로 표현한다.
		7
		A B C
		B D .
		C E F
		E . .
		F . G
		D . .
		G . .
	@Output
		첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다.
		각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.
		ABDCEFG
		DBA ECFG
		DBEGFCA
	@history
		숫자로 바꿔야함;; 아스키코드값으로 바꿔줌
		- 전위 : 노드 방문 -> 왼 -> 오 (전위는 DFS랑 같음)
		- 중위 : 왼 -> 노드 방문 -> 오 
		- 후위 : 왼 -> 오 -> 노드 방문 
		
		< 인접리스트로의 구현 >
		트리만의 고유한 저장 방법으로 배열이나 node 객체를 만들어서 사용해서 하면 편하기야 하겠지만
		dfs 공부도 할겸 인접리스트로 구현해보고 싶었다.
		같은 DFS 코드로 이걸 어떻게 중,후위를 분리시키지
		도저히 생각이 안떠올라서 검색했떠니
		LIST를 따로 두는 방법이 있었다.
		근데 이 방법보단 다른 방법을 찾아보고 싶었다..
		
		- 1차 시도
			1.
				2*node, 2*node+1를 해서 왼,오 자식을 인자로 들어오게 할거니까
				node>aList.length인지 조건을 둠.
			
			2.
				트리의 순회가 DFS로 할 수 있는 건 맞는데 
				그래프랑 똑같이 풀면 안되고 왼,오 노드 들어오는 식으로 구분을 줘야함.
				그래서 for문 없앰 
			
			결과 :
			전위 순회를 먼저 돌려봤는데 위에서부터 루트-왼-오 순으로 결과가 출력됨.
			연결된 정점만 인접리스트에다가 넣기 위해서 .는 걸러서 넣었는데 걍 넣어서 자식이 없다는 걸 표현하기로 해봄
			아 근데 그렇게 하면 인덱스를 표시할 수가 없는데...ㅠㅠ
			2*node, 2*node+1은 안되는건가
		
		- 2차
			이전에 시도한 적이 있었는데 foreach문을 써서 인덱스*2가 아닌 값*2를 한 게 문제였다.
			그리고 2*i을 하면 0인덱스에서 0이 들어가니까 +1을 해저ㅜ야한다.
			i=0부터 시작해야돼. 그래야 처음부터 돌지. 그래서 i=0은 바꾸면 안돼
		
		- N차..
			여러가지 시도들이 있었는데
			아래의 포맷을 가지고 전,중,후위를 하려했다.
			for (int i = 0; i < aList[node].size(); i++) {
				DFS(2 * i + 1, "POST", check);
			}
			for (int i = 0; i < aList[node].size(); i++) {
				DFS(2 * i + 2, "POST", check);
			}
			System.out.print(Character.toChars(node + 65));
			- 문제점
				1. 인접리스트가 연결된 정점을 모두 담는 리스트니까 처음에는 그에 맞춰서 아래와 같이 모든 정점을 다 저장했었다.
					[[1, 2], [0, 3], [0, 4, 5], [1], [2], [2, 6], [5]]
					근데 이렇게 하니까 부모-자식을 구분하는 게 눈으로는 그러려니 하는데 이걸 코드로 처리하려니까 좀 까다로웠다.
				2. 나와야 하는 결과값에서 조금씩 순서가 달랐고 그에 맞춰서 각각 수정을 할수록 점점 코드간의 연광성이 커지면서 복잡해지기만 함..
			- 대안
				1. 주변에 조언을 들은 결과, 반복문과 혼용해서 쓰는 건 순수한 DFS가 아니라고 해서 반복문을 빼고 순수한 DFS로 바꿈
				2. 부모,자식간에 값이 있는 것만 각각 쌍방저장으로 했었는데
					자식만 저장하도록 하기 위해서 자식이 없는 것은 -1로 표시해서 일방 저장으로 저장함.
				3. 아래와 같이 list의 함수를 이용해서 루트 기준의 왼쪽, 오른쪽을 가져오도록 함
					DFS(aList[node].get(0), "PRE", check);
					DFS(aList[node].get(1), "PRE", check);
					
			그랬더니 훨씬 깔끔해지고 인접리스트로의 구현이 완성됨. -^^-
			
		< node 객체 구현 >
		

			
	@Date
		2022. 8. 15.
 */

public class _1991 {
	static List<Integer>[] aList;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 트리 저장 방식
		/* 1. 그래프이므로 그래프와 같은 방식 */
		
		aList = new ArrayList[N];
		boolean[] check1 = new boolean[N];
		boolean[] check2 = new boolean[N];
		boolean[] check3 = new boolean[N];

		// 인접리스트 초기화
		for( int i = 0; i < aList.length; i++ ){
			aList[i] = new ArrayList<Integer>();
		}

		// 트리 저장 - 인접리스트에 값 넣기
		for (int i = 0; i < N; i++) {
			String[] nodes = br.readLine().split(" ");
			int pNode = nodes[0].charAt(0) - 'A';
			int leftCNode = nodes[1].charAt(0) - 'A' !=-19 ? nodes[1].charAt(0) - 'A' : -1;
			int rightCNode = nodes[2].charAt(0) - 'A'!=-19 ? nodes[2].charAt(0) - 'A' : -1;
			// 왼,오 각각 다 연결해주되, .(아스키코드로 -18)이면 넘어가기
			aList[pNode].add(leftCNode); // 0 1 2
			aList[pNode].add(rightCNode);
			// 쌍방저장으로 했었는데 자식만 저장하도록 함.
		}

		// 트리 탐색
		DFS(0, "PRE", check1);	// 전 - DFS와 결과가 같다.
		System.out.println();
		DFS(0, "IN", check2);	// 중. 사이즈 끝에서 거슬러올라가야하나 하면서 aList.length()-1이렇게도 해봄..
		System.out.println();
		DFS(0, "POST", check3); // 후

		br.close();
	}

	private static void DFS(int node, String order, boolean[] check) {
		if ( node==-1||check[node] ){
			return;
		}

		check[node] = true;

		switch (order) {
			case "PRE":
				/*System.out.print( Character.toChars(node+65) );
				
				for( int i : aList[node] ){
					DFS(i, "PRE", check);
				}*/

				/*
				System.out.print( Character.toChars(node+65) );
				DFS( 2*node, "PRE", check );
				DFS( 2*node+1, "PRE", check );
				*/
				System.out.print(Character.toChars(node + 65));
				DFS(aList[node].get(0), "PRE", check);
				DFS(aList[node].get(1), "PRE", check);
				/*for (int i : aList[node]) {
					DFS(i, "PRE", check);
				}*/
				break;
			case "IN":
				//	   0		 1		2		3 	  4		5	    6
				// [ [1, 2], [0, 3], [0, 4, 5], [1], [2], [2, 6], [5] ] 
				/*for (int i = 0; i < aList[node].size(); i++) {
					
					int nextLeft = flag?2*i+2:2*i+1;
					
					if( node!=0 && nextLeft == aList[node].get(i) && nextLeft<node ){
						System.out.print(Character.toChars(node + 65));
						flag = false;
						return;
					}
					
					if( node!=0 && aList[node].size()<3 ){
						System.out.print(Character.toChars(node + 65));
					}
					
					DFS(nextLeft, "IN", check);
				}
				
				System.out.print(Character.toChars(node + 65));
				
				if( node!=0 && aList[node].size()<3 ){
					return;
				}
				
				for (int i = 0; i < aList[node].size(); i++) {
					flag = true;
					DFS(2 * i + 2, "IN", check);
					System.out.print(Character.toChars(node + 65));
				}
				*/
				DFS(aList[node].get(0), "IN", check);
				System.out.print(Character.toChars(node + 65));
				DFS(aList[node].get(1), "IN", check);
				break;
			case "POST":
				/*for( int i : aList[node] ){
					DFS(2*i, "IN", check);
				}
				for( int i : aList[node] ){
					DFS(2*i+1, "IN", check);
				}
				System.out.print( Character.toChars(node+64) );*/

				/*DFS( 2*node, "POST", check );
				DFS( 2*node+1, "POST", check );
				System.out.print( Character.toChars(node+65) );*/
				
				/*for (int i = 0; i < aList[node].size(); i++) {
					DFS(2 * i + 1, "POST", check);
				}
				for (int i = 0; i < aList[node].size(); i++) {
					DFS(2 * i + 2, "POST", check);
				}
				System.out.print(Character.toChars(node + 65));*/
				DFS(aList[node].get(0), "POST", check);
				DFS(aList[node].get(1), "POST", check);
				System.out.print(Character.toChars(node + 65));
				break;
		}

	}

}
