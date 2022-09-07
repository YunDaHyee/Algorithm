package Leetcode.Graph;

import java.util.ArrayList;
import java.util.List;

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
	
	@Date
 */

public class count_nodes_equal_to_average_of_subtree_2265 {
	static Integer[] list =
		{4,8,5,0,1,null,6};
		//{1};
	static boolean[] check = new boolean[list.length];
	static int index;
	static int answer;
	static int subNodeCount;
	// 서브 트리마다 서브트리의 값들과 개수를 리턴해야함.
	static TreeNode mainNodes = null; // 루트 기준으로 초기화
	public static void main(String[] args) {
		initialization();			// 1. 트리의 값 초기화
		setValue(mainNodes);	// 2. 인덱스가 아닌 원래 값으로 다시 넣기
		
		traversal(mainNodes, 0, 0);
	}
	
	// 루트노드가 현재 값과 같을 떄
	private static int traversal(TreeNode node, int root, int subNodeSum) {
		if( node==null ){
			subNodeCount=0;
			subNodeSum=0;
			return 0;
		}
		
		subNodeSum += traversal( node.left, node.val, subNodeSum );
		
		subNodeCount++;
		subNodeSum += node.val; // 루트 포함 수..
		
		if( node.left==null && node.right==null ){
			return subNodeSum;
		}
		
		subNodeSum += traversal( node.right, node.val, subNodeSum );
		subNodeCount++;
		
		if( subNodeSum/subNodeCount == root ) {
			answer++;
		}
		
		return answer;
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
