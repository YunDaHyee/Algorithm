package DivideConquer;

/**
 * 
 */

/**
 	@Question
		Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
		A circular array means the end of the array connects to the beginning of the array.
		Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
		A subarray may only include each element of the fixed buffer nums at most once.
		Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
		
		길이가 n인 원형 정수 배열 nums가 주어지면 nums의 비어 있지 않은 하위 배열의 가능한 최대 합을 반환합니다.
		원형 배열은 배열의 끝이 배열의 시작에 연결됨을 의미합니다.
		공식적으로 nums[i]의 다음 요소는 nums[(i + 1) % n]이고 nums[i]의 이전 요소는 nums[(i - 1 + n) % n]입니다.
		하위 배열은 고정 버퍼 수의 각 요소를 최대 한 번만 포함할 수 있습니다.
		공식적으로 하위 배열 nums[i], nums[i + 1], ..., nums[j]의 경우 k1 % n == k2 % n인 i <= k1, k2 <= j가 존재하지 않습니다.
	
	@Example
		Example 1:
		Input: nums = [1,-2,3,-2]
		Output: 3
		Explanation: Subarray [3] has maximum sum 3.

		Example 2:
		Input: nums = [5,-3,5]
		Output: 10
		Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.

		Example 3:
		Input: nums = [-3,-2,-3]
		Output: -2
		Explanation: Subarray [-2] has maximum sum -2.
		
	@Constraints
		n == nums.length
		1 <= n <= 3 * 104
		-3 * 104 <= nums[i] <= 3 * 104
		
	@history
		배열 요소 중에서 나올 수 있는 최대값들의 합
		
	@Date
		2022. 7. 25.
 */

public class maximum_sum_circular_subarray_918 {
	static int result = (int)(-3*Math.pow(10, 4));//ㅈㄱ
	public static void main(String[] args) {
		int[] nums = 
		//{1,-2,3,-2};
		{5,-3,5};
		//{-3,-2,-3};
		
		dfs( nums, 0, (int)(-3*Math.pow(10, 4))-1, (int)(-3*Math.pow(10, 4)) );
		
		System.out.println( result ); // 제곱근이야
	}
	
	public static void dfs(int[] nums, int depth, int max, int currentNumber) {
		if( nums.length==depth ){
			return;
		}
		
		if( max<currentNumber ){
			max = currentNumber;
		/*}else if( max==currentNumber ){
			result += currentNumber;*/
		}else{
			result = max;
		}
	
		depth=(depth+1)%nums.length;
		dfs( nums, depth, max, nums[depth] );
		
	}
	
}

