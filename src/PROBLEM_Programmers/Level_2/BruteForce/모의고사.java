/**
 * 
 */
package Level_2.BruteForce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 	@Question
		수포자는 수학을 포기한 사람의 준말입니다.
		수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
		수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
		
		1번 수포자가 찍는 방식: 1, 2, 3, 4, 5,
								1, 2, 3, 4, 5, ...
		2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5,
								2, 1, 2, 3, 2, 4, 2, 5, ...
		3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5,
								3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
		
		1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
	
	@Restrictions
		시험은 최대 10,000 문제로 구성되어있습니다.
		문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
		가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

	@Input.Output
		numbers		return
		[1,2,3,4,5]	[1]
		[1,3,2,4,2]	[1,2,3]
		
		예제 #1
		수포자 1은 모든 문제를 맞혔습니다.
		수포자 2는 모든 문제를 틀렸습니다.
		수포자 3은 모든 문제를 틀렸습니다.
		따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

		예제 #2
		모든 사람이 2문제씩을 맞췄습니다.
		
	@history
		N = 가장 문제를 많이 맞힌 사람 찾기 = 정답자의 최대값 찾기 
		STEP1)
		1의 방식	- i~5
		2			- 2 i(자기뺴고)
		3			- 3 자기, (3-2)*2 (3-1)*2 (3+1)*2 (3+2)*2
		
		1,2,3 방식 별로 다 돌려보고 점수를 내서 젤 큰 점수인 사람 출력..
		동 점수가 여러명이면 오름차순으로 출력
		
		STEP2)
		최대 10,000문제 => 3명이니까 30,000 => 시간복잡도 O(N)
		
		1:1 매핑해서 찾는 건 진짜 오래 걸릴거고
		1,2,3배열을 따로 두기보단.. 걍 1,2,3 방법 각각 다르게 하면 될 듯.. 이라고 생각했는데 그렇게 하면 각각 반복문을 따로 돌려야돼..
		같은 인덱스에 그 정답이 있어야함.
		[1,2,3,4,5] 일 때, 인덱스 0에 1 => 답도 인덱스 0에 1
		
		인덱스로 접근하는 방법이 있었는데..
		
		
	@Date
		2022. 4. 26.
 */

public class 모의고사 {

	public static void main(String[] args) throws IOException {
		int[] answers	= {1,2,3,4,5};
		
		int             maxHit      = 0;
        int[]			hits		= new int[3];
		List<Integer>	maxHits		= new ArrayList<Integer>();
        String[]		mathHaters	= { "1,2,3,4,5","2,1,2,3,2,4,2,5","3,3,1,1,2,2,4,4,5,5"}; //찍답 패턴
		
		for( int i=0;i<3;i++ ) {									// 수포자 3명 조회
			String[]	mathHater		= mathHaters[i].split(",");
			int			patternCount	= mathHater.length;         // 찍답 패턴 길이 - 5, 8, 10
			for( int j=0;j<answers.length;j++ ) {                   // 정답 길이==문제 수
				if( answers[j]==Integer.parseInt(mathHater[j%patternCount]) ){
					hits[i]++;
				}
			}
			if( maxHit<hits[i] ) {
				maxHit = hits[i];
			}
		}
		
		for( int i=0;i<hits.length;i++ ) {
			if( maxHit<=hits[i] ) {
				maxHits.add(i+1);
			}
		}
		
		maxHits.sort(null);
        
		Integer[] result = maxHits.toArray(new Integer[maxHits.size()]); // 리스트 -> 배열
		
		System.out.println(Arrays.toString(result));
		
	}
	
}