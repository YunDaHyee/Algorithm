/**
 * 
 */
package Sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;



/**
 	@Question
		H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다.
		어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다.
		위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
		어떤 과학자가 발표한 논문 n편 중,
		h번 이상 인용된 논문이 h편 이상이고
		나머지 논문이 h번 이하 인용되었다면
		h의 최댓값이 이 과학자의 H-Index입니다.
		
		어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때,
		이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
			
	@Restrictions
		과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
		논문별 인용 횟수는 0회 이상 10,000회 이하입니다.

	@Input.Output
		citations		return
		[3, 0, 6, 1, 5]		3
		이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다.
		그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.

	@history
		논문 수 구하기 => 배열의 사이
		논문의 인용 횟수 => 배열의 각 요소값
		각 값을 카운트 했을 때,
		3편의 논문은 3번 이상, 나머지는 그 값(3) 이하 인용돼서 H-Index는3 
		
		정렬
		0 1 3 5 6
		
		중간값...
		0 1 5 6
		4/2 = 2.. 인덱스 2보다 아래인 값
		
		5/2 = 2... 인덱스 2보다 아래인 값
		
		0 1 3 5 6
		인용된 횟수의 공통된 최대값!!
		
		제일 많이 인용된 횟수가 아니고 h의 최대값을 찾아야함.
		
		아니 문제 설명 넘 부족하다
		ㅡㅡ 첨에 인용된 횟수 == 만족하는 논문 수 인 줄 알았더니
		걍 최대값 차즌ㄴ거였다
	@Date
		2022. 5. 15.
 */
public class HIndex {
	public static void main(String args[]) throws IOException {

		
		int[] citations = {3, 0, 6, 1, 5};
						//{0,5,2};
		//{10,10,10,10,10};
		//{0, 0, 0, 0, 0};
		
		int max = citations.length; // 예외가 없다면 적어도 논문 개수만큼 다 인용되도록 하기 위함
		
		Arrays.sort(citations);
		
		/*
			Array.sort(배열,Collections.reverseOrder()) 사용하면 되는데
			라이브러리 의존도를 낮추고
			int의 원시적 타입 배열인 Integer[]에 넣는 추가 작업을 피하기 위해 직접 reverse 구현
		*/
		
		for( int i=citations.length-1;i>=0;i-- ){
			int currentCitation = citations[i];
			if( currentCitation<=citations.length-1-i ){ // 4-4 -> 4-3 -> 4-3 -> 4-2 -> 4-1 -> 4-0
				max = citations.length-1-i; // 해당 인덱스 리턴
				break;
			}
		}
			
		System.out.println( max );
		
	}
}
