package Leetcode.DivideConquer;

/**
 * 
 */

/**
 	@Question
		Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
		A subarray is a contiguous part of an array.
		
		정수 배열 nums가 주어졌을 때, 가장 큰 합을 갖는 연속적인 하위 배열(최소한 하나의 숫자를 포함)을 찾아 그 합을 반환합니다.
		하위 배열은 배열의 연속적인 부분입니다.
	
	@Example
		Example 1:
		Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
		Output: 6
		Explanation: [4,-1,2,1] has the largest sum = 6.
		
		Example 2:
		Input: nums = [1]
		Output: 1
		
		Example 3:	
		Input: nums = [5,4,-1,7,8]
		Output: 23
		
	@Constraints
		1 <= nums.length <= 105
		-104 <= nums[i] <= 104
		
	@history
		N = 가장 큰 합을 갖는 연속적인 하위 배열을 찾고 그 요소간의 합
		
	@Date
		2022. 8. 1.
 */

public class maximum_subarray_53 {
	public static void main(String[] args) {
		int[] nums = 
		{-2,1,-3,4,-1,2,1,-5,4};
		// {1};
		 //{5,4,-1,7,8};
		
		/* 단순 for문 사용 방식 */
		int[] memo = new int[nums.length];
		// 가장 작은 문제들을 풀어둔다.
		int maxSum = nums[0];//Integer.MIN_VALUE;
		int sum = 0;
		
		/*for( int i=0;i<nums.length;i++ ){
			sum = 0;
			for( int j=i;j<nums.length;j++ ){
				sum += nums[j];
				if( maxSum<sum ){
					maxSum = sum;
				}
			}
		}*/
		for( int i=1;i<nums.length;i++ ){
			for( int j=1;j<=i;j++ ){
				sum = Math.max( memo[i], memo[i-j]+nums[i] );
				if( maxSum<sum ){
					maxSum = sum;
				}
			}
		}
		
		System.out.println(maxSum);
		
		/* 분할정복 알고리즘 사용 방식 */
        if (nums == null || nums.length == 0) {
        	System.out.println( 0 );
        }else {
        	System.out.println( divideConquer(nums, 0, nums.length-1) );
        }
		
		
	}

	private static int divideConquer(int[] nums, int leftIndex, int rightIndex) {
		if( leftIndex==rightIndex ){
			return nums[leftIndex];
		}
		
		int midIndex = (leftIndex+rightIndex)/2;
		int maxValue = Integer.max( divideConquer(nums, leftIndex, midIndex), divideConquer(nums, midIndex+1, rightIndex) );
		int leftMaxSum = semiMaxSum( nums, leftIndex, midIndex );
		int rightMaxSum = semiMaxSum( nums, midIndex+1, rightIndex );
		
		return Integer.max( maxValue, leftMaxSum+rightMaxSum );
	}
	
	private static int semiMaxSum(int[] nums, int startIndex, int endIndex){
		int semiMaxSum = Integer.MIN_VALUE;
		int sum = 0;
		for( int i=startIndex;i<=endIndex;i++ ){
			sum += nums[i];
			if( semiMaxSum<sum ){
				semiMaxSum = sum;
			}
		}
		return semiMaxSum;
	}
	
}

