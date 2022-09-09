package Leetcode.Graph;

/**
 	https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/

  	@Question
		Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.
		이진 트리의 루트가 주어지면 노드 값이 하위 트리 값의 평균과 같은 노드 수를 반환합니다.
		
		Note:
		The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
		A subtree of root is a tree consisting of root and all of its descendants.
		n개 요소의 평균은 n개 요소의 합을 n으로 나누고 가장 가까운 정수로 내림한 것입니다.
		루트의 하위 트리는 루트와 모든 자손으로 구성된 트리입니다.	
	
	@Example
		Example 1:
		Input: root = [4,8,5,0,1,null,6]
		Output: 5
			Explanation: 
			For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
			For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
			For the node with value 0: The average of its subtree is 0 / 1 = 0.
			For the node with value 1: The average of its subtree is 1 / 1 = 1.
			For the node with value 6: The average of its subtree is 6 / 1 = 6.
			
		Example 2:
		Input: root = [1]
		Output: 1
			Explanation: For the node with value 1: The average of its subtree is 1 / 1 = 1.
	 
	@Constraints
		The number of nodes in the tree is in the range [1, 1000].
		0 <= Node.val <= 1000	
		
	@history
		N = 각 루트의 값과 서브트리의 합의 평균이 같을 때를 카운트한 값
		
		원래 왼,오별로 전역변수를 아래와 같게 두고 하려고 했는데 연결이 된 게 없어서..답이 나오지 않는다.
		static int leftSubNodeSum;
		static int leftSubNodeCount;
		static int rightSubNodeSum;
		static int rightSubNodeCount;
		모르겠어서 답을 봤는데 count와 sum을 묶어서 하나의 배열(또는 객체로)을 리턴해주는 방식으로 처리했다.  
 
   @Date
      2022. 9. 9.
 */
public class count_nodes_equal_to_average_of_subtree_2265 {
	static Integer[] list =
		{4,8,5,0,1,null,6};
		//{1};
	static int answer;
	// 서브 트리마다 서브트리의 값들과 개수를 리턴해야함.
	static TreeNode mainNodes = null; // 루트 기준으로 초기화
	public static void main(String[] args) {
		initialization();		// 1. 트리의 값 초기화
		setValue(mainNodes);	// 2. 인덱스가 아닌 원래 값으로 다시 넣기
		
		traversal(mainNodes);
		
		System.out.println( answer );
	}
	
	// 루트노드가 현재 값과 같을 떄
	private static int[] traversal(TreeNode node) {
		/* 내 풀이
		// 이렇게 되어버리면 마지막에 받는애가 node==null로 들어간 상태에서 값을 받는거라서 아무것도 없음..
		if( node==null ){
			return;
		}
		if( node.left==null && node.right==null ){
			if( direct.equals("left") ){
				leftSubNodeSum += node.val;
				leftSubNodeCount++;
			}else {
				rightSubNodeSum += node.val;
				rightSubNodeCount++;
			}
			return 0;
		}
		*/
		if( node==null ){
			return new int[] {0,0};
		}
		
		int[] left	= traversal( node.left );
		int[] right = traversal( node.right );
		
		int currentSubSum	= left[0] + right[0] + node.val;// 루트 포함해야돼서 루트값 더해줌
		int currentSubCount	= left[1] + right[1] + 1;		// 루트 포함해야돼서 1 더해줌
		
		if( currentSubSum/currentSubCount == node.val ) {
			answer++;
		}
		
		return new int[] {currentSubSum,currentSubCount}; // 현재 서브트리의 합과 카운트를 리턴 시켜줌
	}

	private static void setValue(TreeNode node) {
		if( node == null ){
			return;
		}
		
		setValue( node.left);
		node.val = list[node.val];
		setValue( node.right);
	}
	
	private static void initialization() {
		for( int i=0;i<list.length/2;i++ ){
			// 인덱스로 트리 초기화
			int root = i;
			Integer left = (2*i)+1;
			Integer right = (2*i)+2;
			
			if( mainNodes==null ){
				mainNodes = new TreeNode( root );
				setChild(mainNodes, left, right);
				continue;
			}
			
			// 현재 값, 왼쪽 값, 오른쪽 값,
			// 만약 현재 값이 null이면 비어있는 노드이므로 다음 노드가 0이 아닐때까지 증가
			if( list[root]==null ){
				int originalRootIndex = i;
				while( list[++i]!=null ){
					root = i;
					left = (2*originalRootIndex)+1;
					right = (2*originalRootIndex)+2;
					break;
				}
			}
			
			if( list[left]==null ){
				left = null;
			}
			
			if( list[right]==null ){
				right = null;
			}
			
			putData( mainNodes, root, left, right);
		}
	}

	private static void putData(TreeNode node, int root, Integer left, Integer right) {
		if( node==null||root==0 ){
			return;
		}
		
		if( node.val==root ){
			setChild(node, left, right);
			return;	
		}
		
		putData( node.left, root, left, right );
		putData( node.right, root, left, right );
	}
	
	private static void setChild(TreeNode nodes, Integer left, Integer right) {
		nodes.left = left==null ? null : new TreeNode(left);
		nodes.right = right==null ? null : new TreeNode(right);
	}
	
}
