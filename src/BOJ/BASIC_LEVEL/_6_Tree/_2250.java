package Basic_Level._6_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 	@Question
		이진트리를 다음의 규칙에 따라 행과 열에 번호가 붙어있는 격자 모양의 틀 속에 그리려고 한다. 이때 다음의 규칙에 따라 그리려고 한다.
        
        1. 이진트리에서 같은 레벨(level)에 있는 노드는 같은 행에 위치한다.
        2. 한 열에는 한 노드만 존재한다.
        3. 임의의 노드의 왼쪽 부트리(left subtree)에 있는 노드들은 해당 노드보다 왼쪽의 열에 위치하고, 오른쪽 부트리(right subtree)에 있는 노드들은 해당 노드보다 오른쪽의 열에 위치한다.
        4. 노드가 배치된 가장 왼쪽 열과 오른쪽 열 사이엔 아무 노드도 없이 비어있는 열은 없다.
        
        이와 같은 규칙에 따라 이진트리를 그릴 때 각 레벨의 너비는 그 레벨에 할당된 노드 중 가장 오른쪽에 위치한 노드의 열 번호에서 가장 왼쪽에 위치한 노드의 열 번호를 뺀 값 더하기 1로 정의한다.
        트리의 레벨은 가장 위쪽에 있는 루트 노드가 1이고 아래로 1씩 증가한다.
        아래 그림은 어떤 이진트리를 위의 규칙에 따라 그려 본 것이다.
        첫 번째 레벨의 너비는 1, 두 번째 레벨의 너비는 13, 3번째, 4번째 레벨의 너비는 각각 18이고, 5번째 레벨의 너비는 13이며, 그리고 6번째 레벨의 너비는 12이다.
        
        우리는 주어진 이진트리를 위의 규칙에 따라 그릴 때에 너비가 가장 넓은 레벨과 그 레벨의 너비를 계산하려고 한다.
        위의 그림의 예에서 너비가 가장 넓은 레벨은 3번째와 4번째로 그 너비는 18이다. 너비가 가장 넓은 레벨이 두 개 이상 있을 때는 번호가 작은 레벨을 답으로 한다.
        그러므로 이 예에 대한 답은 레벨은 3이고, 너비는 18이다.
        임의의 이진트리가 입력으로 주어질 때 너비가 가장 넓은 레벨과 그 레벨의 너비를 출력하는 프로그램을 작성하시오
		
		실제 기출문제의 문제 제목은 "이진트리의 너비" 이다.
	@Input
		첫째 줄에 노드의 개수를 나타내는 정수 N(1 ≤ N ≤ 10,000)이 주어진다.
		다음 N개의 줄에는 각 줄마다 노드 번호와 해당 노드의 왼쪽 자식 노드와 오른쪽 자식 노드의 번호가 순서대로 주어진다.
		노드들의 번호는 1부터 N까지이며, 자식이 없는 경우에는 자식 노드의 번호에 -1이 주어진다.
		19
        1 2 3
        2 4 5
        3 6 7
        4 8 -1
        5 9 10
        6 11 12
        7 13 -1
        8 -1 -1
        9 14 15
        10 -1 -1
        11 16 -1
        12 -1 -1
        13 17 -1
        14 -1 -1
        15 18 -1
        16 -1 -1
        17 -1 19
        18 -1 -1
        19 -1 -1
	@Output
		첫째 줄에 너비가 가장 넓은 레벨과 그 레벨의 너비를 순서대로 출력한다.
		너비가 가장 넓은 레벨이 두 개 이상 있을 때에는 번호가 작은 레벨을 출력한다.
		3 18
	@history
	  N = 너비가 가장 넓은 레벨과 그 레벨의 너비
	  너비 = 가장 오른쪽에 위치한 열 번호 - 가장 왼쪽에 위치한 열 번호 +1
	  큰 너비가 중복 시, 작은 수의 레벨이 정담
	  
	  3번 규칙을 통해서 열이 의미하는 것은 인오더 방문순서이란 걸 알 수 있다.
      => 인오더 활용 문제
	  
	  각각의 width와 level을 어떻게 저장? => 일단 맵으로 .. 하지만 이거는 너비,레벨이 다 구해진 다음에 해야함.
	  열번호는 어떻게 구해?
	    => 모르겠따.. :
    	    - 인덱스로 접근하는건가 해서 생각해본 것들..
    	    1번쨰(루트) 열번호 = (19/2) + 1 = 10
    	    2번쨰 열번호     10/2+2
    	    15-3 = 12 + 1 = 13
	    => 답 참고 :
    	    1.	NODE2 객체에서 열과 깊이를 가리키는 변수를 추가로 두는 것. 행은 가장 왼쪽까지 간 다음에 거기서부터 차오르는 것.
    	    	레벨은 같은 행에서는 같으니까 한번 돌 때 같은 값으로 돌아준다.
    	   	2.	루트 노드가 항상 첫 번째가 아닐 수도 있음..
    	   		그래서 부모노드가 없는 거를 루트노드로 설정해주기 위해서 flag 배열이 필요함
    		
    	=> 깨달은 점
			1.	한가지의 로직에서 모든 것을 다 풀려고 하지 말기
				선행이 필요한 것이 있으므로 순차적으로 하는 것을 꼭 생각하기
			2.	부모노드가 항상 첫 번째가 아닐 수도 있다.
				주어진 예에서는 1부터 시작하지만 만약 5 부터 시작한다면 아래와 같은 코드를 짰을 때 무조건 첫 번째에서만 들어감..
				N으로 19을 쳤다고 해서 1~19 아닐 수도 있음. 번호는 아마 무작위로 들어갈 것..
				근데 그렇다고 아무번호가 들어가는 건 아니고 1~19 면은 번호중에서 위치가 랜더믕로 들어가는 것 같다.
				그냥 순서가 다르게 들어갈 수도 있다는 것, 꼭 1이 첫 번째가 아니라는 것!!
				따라서 바로 DFS를 돌면 안되고 root 변수를 따로 두고 끝까지 돌게 해야함. 
				// 부모노드가 없는 것을 루트노드로 설정
				for( int i=1;i<=N;i++ ){
					if( !rootFlag[i] ){
						// 각 노드의 너비,레벨 구하기
						DFS(i, 1);
						break;
					}
				}
		- 풀이 방법
			1.  NODE 객체에 row,level 필드를 두고 값 초기화하는 정도로만 DFS로 순회하는 방법
			2.  밖에서 한번 더 순회하는 것 거치도록 DFS로 순회 하는 방법
	@Date
		2022. 8. 22.
 */

class NODE2 {
	public int left;
	public int right;
	public int row;
	public int level;

	public NODE2(int left, int right) {
		super();
		this.left = left;
		this.right = right;
	}
}

public class _2250 {
	static NODE2[] NODE;
	static int[] leftForLevel,rightForLevel;
	static int row=1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		NODE = new NODE2[N + 1];
		leftForLevel = new int[N + 1];
		rightForLevel = new int[N + 1];
		
		boolean[] rootFlag = new boolean[N + 1];
		int root = 0,
			//maxLevel = 0, // 1번 방법일 때 사용
			maxWidth = 0,
			minLevel = 0;
		
		// 트리 값 초기화
		for (int i = 1; i <= N; i++) {
			String[] nodes = br.readLine().split(" ");
			int center = Integer.parseInt(nodes[0]);
			int left = Integer.parseInt(nodes[1]);
			int right = Integer.parseInt(nodes[2]);
			NODE[center] = new NODE2(left, right);
			if( left!=-1 ) {
				rootFlag[left] = true;
			}
			if( right!=-1 ) {
				rootFlag[right] = true;
			}
		}
		
		/*
			마지막까지 돌게하면 처음으로 0이었던 것만 남고 나머지는 다 0일테니까 끝까지 돌아야돼.
			첨에 나왔다고 바로 DFS로 들어가면 안된다.
		 */
		// 부모노드가 없는 것을 루트노드로 설정
		for( int i=1;i<=N;i++ ){
			if( !rootFlag[i] ){
				root = i;
			}
		}
        
		DFS(root, 1); // 각 노드의 너비,레벨 구하기. 
		
		/* 1번 방법일 때 ============================================================================= */
		// 같은 레벨에서 가장 왼쪽과 가장 오른쪽의 행의 값 구하기
		/*for (int i = 1; i<=N; i++) {
			int tempLevel = NODE[i].level;
			int tempRow = NODE[i].row;
			int leftRow = leftForLevel[tempLevel];
		
			leftForLevel[tempLevel] = leftRow == 0 ? tempRow : Math.min(leftRow, tempRow);
			rightForLevel[tempLevel] = Math.max(rightForLevel[tempLevel], tempRow);
			maxLevel = Math.max(maxLevel, tempLevel); // 최대 레벨 설정
		}*/

		// 최대 너비 구하기
		/*for (int i = 1; i <= maxLevel; i++) {
			int tempWidth = rightForLevel[i] - leftForLevel[i] + 1;
			if (maxWidth < tempWidth) { // 동일 너비가 있을 경우에 작은 레벨로 구하는 것이라서 등호가 들어가지 않음
				maxWidth = tempWidth;
				minLevel = i;
			}
		}*/
		/* ========================================================================================= */
		
		for (int i = 1; i <= N; i++) {
			int tempWidth = rightForLevel[i] - leftForLevel[i] + 1;
			if (maxWidth < tempWidth) { // 동일 너비가 있을 경우에 작은 레벨로 구하는 것이라서 등호가 들어가지 않음
				maxWidth = tempWidth;
				minLevel = i;
			}
		}
		
		System.out.println(minLevel + " " + maxWidth);
		br.close();
	}

	/*
	// NODE 객체에 row,level 필드를 두고 값 초기화하는 정도로만 순회하는 방법
	private static void DFS(int node, int level) {
		if (node == -1) {
			return;
		}
		
		DFS(NODE[node].left, level + 1);
		NODE[node].row = ++row;
		NODE[node].level = level;
		DFS(NODE[node].right, level + 1);
	}*/
	
	// 순회 하면서 level, row 값 지정하는 방법
	private static void DFS(int node, int level) {
		if (node == -1) {
			return;
		}
		
		DFS(NODE[node].left, level + 1);
		/*
		 	작은값 비교이기 때문에 값이 없을 때는 0이 가장 작은 수니까 비교하면 0만 들어가는 걸 방지하기 위해
			처음 순회할 때는 현재 row 값이 들어가도록 함. 그 다음에 순회할 때는 이미 그 행(아마 왼쪽 행)을 방문했다는 것이므로 비교 가능함
		 */
		leftForLevel[level] = leftForLevel[level]==0 ? row : Math.min(leftForLevel[level], row);
		rightForLevel[level] = Math.max(rightForLevel[level], row++);
		DFS(NODE[node].right, level + 1);
	}

}
