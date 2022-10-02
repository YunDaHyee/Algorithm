package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
	https://leetcode.com/problems/deepest-leaves-sum/

	@history
		1. 값 초기화
		완전이진트리가 아니니까 2*n+1,2는 안돼. 인덱스로 여기선 접근 못해. 트리 모양이 어떻게 바뀔지 모르기 떄문에 => 근데 인덱스로 접근하기 위해서 저렇게 함
		노드의 left,right로 접ㄱ근한다
		
		treenode 자체가 배열을 이루고 있는데 맨 처음에 TreeNode[] 이렇게 해버림
		아니 근데 그거 아님 접근을 할 수가 업슨ㄴ데
		근데 배열로 하면은 서로 연결이 끊겨버림..루트기준 왼쪽/오른쪽 노드가 쭉 연결되어이썽야해
		그래서 배열로 하면 안됨
		
		0일 떄 값을 안넣으려고 했는데 인풋으로 들어오는 건 0도 값이 있을 것 같아서 걍 넣음
		=> 인덱스로 접근을 해야 왼,오 구분을 할 수가 있을 것 같아서 2*n+1,2로 두고 해당 인덱스에 값이 없을 때는 0이 아닌 값이 나올때까지 인덱스 증가하게 함
		
		2. 리프노드에서의 합을 구하기
		트리의 깊이를 재야하는데 어느 기준으로 해야하지
		정점개수=8/2 = 4
		배열길이/2 => 13/2 = 6 = 부모노드 수 => 부모노드수+1 = 높이
		값 초기화랑 순회하면서 구하는 것은 따로 가야한다.!!
		
		3. 같은 수 일떄 어떡?
		찾아본 결과 이진트리에서는 값의 중복이 있으면 안되므로 카운트를 넣어야 함..!
		검색을 목적으로 하는 자료구조이기 때문에 중복이 많을 수 있는 경우 굳이 트리에 중복노드를 삽입해서 검색 속도를 느리게 할 필요가 없기 때문이다.
		굳이 중복을 허용하는 이진탐색트리를 만들 필요가 있을까? 합당한 이유가 있다면 굳이 중복된 노드를 트리에 삽입하는 것 보다는 노드에 count 값을 가지게 하는 것으로 처리하는 게 효율적이라고 생각한다.
		근데 인덱스로 하는건 좋은데..
		나중에 값을 더할 땐 어떻게 더하지..
		더하니까 인덱스 합만 나옴..
		=> 값 초기화할 때는 인덱스로 하고 말단 노드에서는 해당 노드의 값을 넣도록 함..ㅎㅎ
		더 좋은 방법이 있을 것 같긴한데 일단 이번 문제를 풀기 위한 임시방편으로 처리한 것..

	@Date
		
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
}

public class deepest_leaves_sum_1302 {
	static int[] list =
		//{1,2,3,4,5,0,6,7,0,0,0,0,8}; // 총 13개. 2 나누기하면 7. 7전까지만 해야해. 부모는 6개
		{6,7,8,2,7,1,3,9,0,1,4,0,0,0,5};
	    //{50,0,54,98,6,0,0,0,34};
	static TreeNode mainNodes = null; // 루트 기준으로 초기화
	static int sum;	
	static int maxDepth;
	public static void main(String[] args) {
		
		// 1. 트리의 값 초기화
		for( int i=0;i<list.length/2;i++ ){
			/*
			// 노드 값으로 트리 초기화
			int root = list[i];
			int left = list[(2*i)+1];
			int right = list[(2*i)+2];
			*/
			
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
			
			initialization( mainNodes, root, left, right);
		}
		
		// 2. 말단 노드에 한해서만 노드 값으로 넣기 ( 이 문제를 풀기 위해서 추가한 로직 )
		initializationForLeafNode(mainNodes, 0);
		maxDepth = 0;
		
		// 3. 트리 순회 - 높이 찾기 - 중위순회로 찾는다
		traversal(mainNodes,0);
		
		System.out.println("총 - "+mainNodes.toString());
		System.out.println(sum);
	}

	private static void traversal(TreeNode node, int depth) {
		/*if( currentNode.left==null && currentNode.right==null ) {
			if( maxDepth<depth ){
				sum+=currentNode.val;
				maxDepth = depth;
				return;
			}
		}
		
		if( currentNode.left!=null&&currentNode.left.val!=0 ){
			depth++;
			traversal(currentNode.left, depth);
		}
		
		if( currentNode.right!=null&&currentNode.right.val!=0 ){
			depth++;
			traversal(currentNode.right, depth);
		}*/
		if (node == null) {
	        return;
	    }
		
		// 왼,오 둘 다 널이면 말단 노드
		if( node.left==null && node.right==null ) {
			if( maxDepth<depth ){
				maxDepth = depth;
				sum = node.val;
			}else if( maxDepth==depth ){
				sum+=node.val;
			}
			return;
		}
		
		traversal(node.left, depth+1);
		traversal(node.right, depth+1);
	}				
	
	private static void initialization(TreeNode node, int root, Integer left, Integer right) {
		if( node==null||root==0 ){
			return;
		}
		
		if( node.val==root ){
			put(node, left, right);
			return;	
		}
		
		initialization( node.left, root, left, right );
		initialization( node.right, root, left, right );
	}
	private static void initializationForLeafNode(TreeNode node, int depth) {
		if (node == null) {
	        return;
	    }
		
		if( maxDepth<depth ){
			maxDepth = depth;
		}
		
		if( maxDepth==depth ){
			if( node.left==null && node.right==null ) {
				node.val=list[node.val];
				return;
			}
		}
		
		initializationForLeafNode(node.left, depth+1);
		initializationForLeafNode(node.right, depth+1);
	}
	private static void put(TreeNode nodes, Integer left, Integer right) {
		nodes.left = left==null ? null : new TreeNode(left);
		nodes.right = right==null ? null : new TreeNode(right);
		/*if( left!=0 ){
			nodes.left = new TreeNode(left);
		}
		if( right!=0 ){
			nodes.right = new TreeNode(right);
		}*/
	}

}
