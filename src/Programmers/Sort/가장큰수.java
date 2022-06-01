/**
 * 
 */
package Sort;

import java.util.ArrayList;
import java.util.List;

/**
 	@Question
		0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
		0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
		
	@Restrictions
		numbers의 길이는 1 이상 100,000 이하입니다.
		numbers의 원소는 0 이상 1,000 이하입니다.
		정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

	@Input.Output
		numbers				return
		[6, 10, 2]			"6210"
		[3, 30, 34, 5, 9]	"9534330"
		
		[6, 10, 2] => [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
	@history
		나올 수 있는 수의 순열..재귀로 풀기
	@Date
		2022. 5. 3.
 */

public class 가장큰수 {
	static int[] numbers;
	static List<Integer> result = new ArrayList<Integer>();
	static boolean[] check;
		
	public static void main(String args[]) {
		int[] realNumbers = {3, 30, 34, 5, 9};
		//{6, 10, 2};
		String answer = "";
		numbers = realNumbers;
		check = new boolean[numbers.length];
		System.out.println( dfs(0,"") );
	}
	
	public static int dfs(int depth, String number) {
		int combination = 0;
		
		if( depth==numbers.length ){
			result.add( Integer.valueOf(number) );
		}
		
		for( int i=depth;i<numbers.length;i++ ){
			if( !check[i] ){
				check[i] = false;
				combination = dfs( depth+1, number+numbers[i] );
			}
		}
		
		return 0;
	}
	
	/*
	 // 아무것도 모르고 21년도 쯤에 푼 것 - 문자열로만 풀던 그 시절,,
	    String answer = "";
	    String[] stringNumbers = new String[numbers.length];
	    Stack<Integer> totalNumber = new Stack<Integer>();
		int maxNumber = 0;

		for (int i = 0; i < numbers.length; i++) {
			stringNumbers[i] = numbers[i] + "";
		}

		for (int i = 0; i < numbers.length; i++) {
			int index = 0;
			String[] nonFristNumbers = new String[numbers.length-1];
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[i] != numbers[j]) {
					nonFristNumbers[index++]=stringNumbers[j];
				}
			}
			for( int j=0;j<nonFristNumbers.length;j++ ){
				StringBuilder secondGroup = new StringBuilder();
				secondGroup.append(nonFristNumbers[j]);
				for( int k=0;k<nonFristNumbers.length;k++ ){
					if (numbers[j] != numbers[k]) {
						secondGroup.append(nonFristNumbers[k]);
					}
				}
				totalNumber.push(Integer.parseInt(stringNumbers[i] + secondGroup));
			}
		}
	    
	       while (!totalNumber.isEmpty()) {
			int popNumber = totalNumber.pop();
			if (popNumber > maxNumber) {
				maxNumber = popNumber;
			}
		}
	    answer = maxNumber+"";
	    return answer;
	 
	 */
	
}

