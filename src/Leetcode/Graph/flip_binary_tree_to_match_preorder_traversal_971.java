package Leetcode.Graph;

import java.util.ArrayList;
import java.util.List;

/**
	https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
 	
 	@Question
		n개의 노드가 있는 이진 트리의 루트가 제공되며 각 노드에는 1에서 n까지의 값이 고유하게 할당됩니다.
		또한 이진 트리의 원하는 전위순회인 n개의 값 voyage의 시퀀스가 ​​제공됩니다.
		이진 트리의 모든 노드는 왼쪽 및 오른쪽 하위 트리를 교환하여 뒤집을 수 있습니다.
		예를 들어 노드 1을 뒤집으면 다음과 같은 효과가 있습니다.
		
		트리의 전위순회가 항해와 일치하도록 가장 작은 수의 노드를 뒤집습니다.
		모든 반전된 노드의 값 목록을 반환합니다.
		어떤 순서로든 답변을 반환할 수 있습니다.
		전위순회 일치 항해를 만들기 위해 트리의 노드를 뒤집는 것이 불가능한 경우 목록 [-1]을 반환합니다.

	@Example
		Input: root = [1,2], voyage = [2,1]
		Output: [-1]
		Explanation: It is impossible to flip the nodes such that the pre-order traversal matches voyage.
		선주문 순회가 항해와 일치하도록 노드를 뒤집는 것은 불가능합니다.
		
		Input: root = [1,2,3], voyage = [1,3,2]
		Output: [1]
		Explanation: Flipping node 1 swaps nodes 2 and 3, so the pre-order traversal matches voyage.
		노드 1을 뒤집으면 노드 2와 3이 바뀌므로 선주문 순회는 항해와 일치합니다.
		
		Example 3:
		Input: root = [1,2,3], voyage = [1,2,3]
		Output: []
		Explanation: The tree's pre-order traversal already matches voyage, so no nodes need to be flipped.
		트리의 사전 주문 순회는 이미 항해와 일치하므로 노드를 뒤집을 필요가 없습니다.

	@Constraints
		The number of nodes in the tree is n.
		n == voyage.length
		1 <= n <= 100
		1 <= Node.val, voyage[i] <= n
		All the values in the tree are unique.
		All the values in voyage are unique.

	@history
		원하는 결과값(전위순회한 결과)인 voyage와 일치하도	록 노드를 바꾸고 바꾼 노드들의 목록을 구한다.
		여기서의 노드는 부모노드를 말함.
		=> N = 전위순회를 한 결과로 나타내야함.
		
		TreeNode와 int[] 을 받는 거니까 처음부터 비교할 순 없다.. 
		dfs 전에 할 수 있는 작업은 길이가 2 이하면은 스위치를 할 수 없으니까 그때는 -1 반환하는 것
		=> 이렇게 하니까 
		[1], [1] 이 예시에서 []가 나와야하는데 -1가 나오는 상황이 발생했다.. 자리수로 판단하면 안될 듯 하다.
		
		switch 하기 전과 voyage의 결과가 같다면 빈 리스트..
		그러면 voyage랑 같은지 비교해야하나..
 */
public class flip_binary_tree_to_match_preorder_traversal_971 {
	static int[] list =
		//{1,2};
		{1,2,3};
	static TreeNode mainNodes = null; // 루트 기준으로 초기화
	static List<Integer> answer = new ArrayList<Integer>();
	static int index;
	
	public static void main(String[] args) {
		// 1. 트리의 값 초기화
		initialization();
		
		// 2. 인덱스가 아닌 값으로 다시 넣기
		putValue(mainNodes, 0, 1);
		
		int[] voyage = //{2,1};
		{1,3,2};
		//{1,2,3};
		
		if( !preOrder( mainNodes,voyage ) ){
			answer = new ArrayList<Integer>();
			answer.add(-1);
		}
		
		System.out.println(answer);
	}
	
	// voyage 값과 일치하는지 boolean으로 파악하는 것. 처음엔 switchNode = new int[voyage.length]만큼 주고 숫자를 직접 옮겨 담으면서 비교를 할랬는데 그렇게 직접 옮기면 시간복잡도가 증가하게 되니까 이게 훨씬 간단하다.
	private static boolean preOrder(TreeNode node, int[] voyage ) {
		if( node==null ){
			return true;
		}
		
		if( node.val!=voyage[index++] ){
			return false;
		}

		// 왼쪽이 비어있진 않는데 왼쪽 값이 voyage값과 다르면
		if( node.left!=null && node.left.val!=voyage[index] ) {
			answer.add(node.val); // 그땐 교환의 대상
			return preOrder(node.right, voyage) && preOrder(node.left, voyage); // 오른쪽, 왼쪽 순으로 검사. 둘 다 true여야함
		}
		
		// 왼쪽이 비어있거나 왼쪽 값이 voyage 값이 다를 때
		return preOrder(node.left, voyage) && preOrder(node.right, voyage); // 왼쪽, 오른쪽순으로 검사. 둘 다 true여야함
	}

	private static void putValue(TreeNode node, int root, int value) {
		if( node == null ){
			return;
		}
		
		if( node.val==root ){
			node.val = value;
			node.left.val = ++value;
			node.right.val = ++value;
			return;	
		}
		
		putValue( node.left, root, value );
		putValue( node.right, root, value );
	}
	
	private static void initialization() {
		for( int i=0;i<list.length/2;i++ ){
			// 인덱스로 트리 초기화
			int root = i;
			Integer left = (2*i)+1;
			Integer right = (2*i)+2;
			
			if( mainNodes==null ){
				mainNodes = new TreeNode( root );
				put(mainNodes, left, right);
				continue;
			}
			
			// 현재 값, 왼쪽 값, 오른쪽 값,
			// 만약 현재 값이 0이면 비어있는 노드이므로 다음 노드가 0이 아닐때까지 증가
			if( list[i]==0 ){
				int originalRootIndex = i;
				while( list[++i]!=0 ){
					root = i;
					left = (2*originalRootIndex)+1;
					right = (2*originalRootIndex)+2;
					break;
				}
			}
			
			if( list[left]==0 ){
				left = null;
			}
			
			if( list[right]==0 ){
				right = null;
			}
			
			traversal( mainNodes, root, left, right);
		}
	}

	private static void traversal(TreeNode node, int root, Integer left, Integer right) {
		if( node==null||root==0 ){
			return;
		}
		
		if( node.val==root ){
			put(node, left, right);
			return;	
		}
		
		traversal( node.left, root, left, right );
		traversal( node.right, root, left, right );
	}
	
	private static void put(TreeNode nodes, Integer left, Integer right) {
		nodes.left = left==null ? null : new TreeNode(left);
		nodes.right = right==null ? null : new TreeNode(right);
	}
}
