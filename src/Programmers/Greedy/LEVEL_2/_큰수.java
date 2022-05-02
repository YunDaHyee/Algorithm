/**
 * 
 */
package Greedy.LEVEL_2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @문제
	0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
	예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
	0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
	
	제한 사항
	numbers의 길이는 1 이상 100,000 이하입니다.
	numbers의 원소는 0 이상 1,000 이하입니다.
	정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
	입출력 예
	numbers	return
 * @입력
	[6, 10, 2]	
	[3, 30, 34, 5, 9]
 * @출력
 * 	"6210"
 * "9534330"
 * 실행한 결괏값 "9533034"이(가) 기댓값 "9534330"와(과) 다릅니다.
 * @HISTORY
 * 
 * @Date 2021. 12. 07.
 */

public class _큰수 {
	public static void main(String args[]) throws IOException {

		// public String solution(int[] numbers) {
		int[] numbers = {3, 30, 34, 5, 9};

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
			
			int count = 0;
			
			StringBuilder secondGroup = new StringBuilder();
			
			while( count++<=numbers.length-1){
				for( int secondBoundaryIndex=0;secondBoundaryIndex<nonFristNumbers.length;secondBoundaryIndex++ ){
					String secondReaderNumber = nonFristNumbers[secondBoundaryIndex];
					secondGroup.append(secondReaderNumber);
					StringBuilder group = new StringBuilder();
					for( int k=1;k<nonFristNumbers.length;k++ ){
						String number = nonFristNumbers[k];
						if( secondBoundaryIndex<k&&number!=secondReaderNumber ){
							group.append(number);
						}
					}
					String resultNumber = stringNumbers[i] + secondGroup + group;
					totalNumber.push(Integer.parseInt(resultNumber));
					
				}
				secondGroup.append(nonFristNumbers[count]);
			}
		}

		while (!totalNumber.isEmpty()) {
			int popNumber = totalNumber.pop();
			if (popNumber > maxNumber) {
				maxNumber = popNumber;
			}
		}
		answer = maxNumber + "";

		System.out.println(answer);
	}
}
