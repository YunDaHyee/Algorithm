/**
 * 
 */
package Intermediate_Level._1_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 	@Question
		준규가 가지고 있는 동전은 총 N종류이고 각각의 동전을 매우 많이 가지고 있다.
		동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다.
		이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
		둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
		
		1.
		10 4200
		1
		5
		10
		50
		100
		500
		1000
		5000
		10000
		50000
		
		2.
		10 4790
		1
		5
		10
		50
		100
		500
		1000
		5000
		10000
		50000
	@Output
		첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
		1. 6
		2. 12
	@history
		문제에 쓰인 표현 : 매우 많이, 적절히
		N 종류로 K원 만든다.
		주어진 동전의 가치 Ai가 하나씩만 있는건지..여러개가 되는건지 모르겠는데 일단은 후자라고 생각하고 푼다..
		
		동전 10종류 갖고 있고 그 가치들이 쭉 나열된 것인데 가치가 제한 있는 것이지, 가치의 개수는 제한이 없는 듯.
		
		- N
		K를 만드는 데에 사용되는 동전 개수의 최소값
		
		- 최적의 해가 보장되는 이유 :
		큰 단위가 작은 단위의 배수
		
		- 전략
		즉, N개의 동전 중 가장 큰 가치를 지닌 동전부터 탐색하여
		동전의 가치가 K보다 클 경우는 넘어가고 아닐경우는 최대 구성 가능한 개수를 더해주면 된다.
		
		딱 맞게 떨어지는 큰 값부터 먼저 사용 후 쫌쫌값 덧셈
		
		- 예제에 전략 적용
		1)
		A 단계 최적 = 1000*4+100*2=> 6 => 독립적(조건1)이고 부분 최적해끼리의 합이지만 전체 최적해(조건2)이기도 함
		B 단계 최적 = 500*8+100*2=> 10 => 독립적(조건1)이고 부분 최적해끼리의 합이지만 전체 최적해(조건2)이기도 함
		C 단계 최적 = 100*40+100*2=> 42 => 독립적(조건1)이고 부분 최적해끼리의 합이지만 전체 최적해(조건2)이기도 함
		D 단계 최적 = 50*80+100*2=> 82 => 독립적(조건1)이고 부분 최적해끼리의 합이지만 전체 최적해(조건2)이기도 함
		E 단계 최적 = 10*400+100*2=> 402 => 독립적(조건1)이고 부분 최적해끼리의 합이지만 전체 최적해(조건2)이기도 함
		F 단계 최적 = 5*800+100*2=> 802 => 독립적(조건1)이고 부분 최적해끼리의 합이지만 전체 최적해(조건2)이기도 함
		G 단계 최적 = 1*4200 => 4200 => 독립적(조건1)이고 부분 최적해끼리의 합이지만 전체 최적해(조건2)이기도 함
		최소값은 6
		
		2)
		A 단계 최적 = 1000*4+500*1+100*2+50*1+10*4 => 12 => 독립적(조건1)이고 부분 최적해끼리의 합이지만 전체 최적해(조건2)이기도 함
		B 단계 최적 = 500*9+200*1+50*1+10*4 => 15 => 독립적(조건1)이고 부분 최적해끼리의 합이지만 전체 최적해(조건2)이기도 함
		C 단계 최적 = 100*47+100*2+50*1+10*4 => 54 => 독립적(조건1)이고 부분 최적해끼리의 합이지만 전체 최적해(조건2)이기도 함
		..
		..
		최소값은 12
		
		근데 최소값 구하기에다가 오름차순으로 주어진다면
		제일 큰 값부터 처리한다면은 제일 첫 번째 단계에서 행하는 결과값이 답 아닐까..?
		라는 생각으로 접근함.
		(처음에는 문제에 오름차순으로 주어진다는 내용을 못봐서 오름차순 정렬을 추가했었다.)
		
		N개의 동전 중 가장 큰 가치를 지닌 동전부터 탐색하여,
		동전의 가치가 K보다 클 경우는 넘어가고 아닐경우는 최대 구성 가능한 개수를 더해줌
		
		- 시간복잡도
		화폐의 종류가 K일 때 시간복잡도는 O(k)를 따른다.
		즉, 화폐의 종류 수에 영향을 받음
		
	@Date
		2022. 4. 17.
 */

public class _11047 {
	static List<Integer> Ai = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] raw = br.readLine().split(" ");
		int N = Integer.parseInt(raw[0]), K = Integer.parseInt(raw[1]);
		int result = 0;
		
		while( N-->0 ) {
			Ai.add(Integer.parseInt(br.readLine()));
		}
		
		System.out.println( greedy(K) ); // 1. 재귀
		
		for( int i=Ai.size()-1; (i>=0 && K>0) ;i-- ) {
			int currentValue = Ai.get(i);
			result += K/currentValue;
			K = K%currentValue;
		}
		
		System.out.println( result ); // 2. 반복문
		
		br.close();
	}
	
	public static int greedy(int remainder) {
		if( remainder==0 ) {
			return 0;
		}
		
		int result = 0;
		
		// 큰 값부터 조회할 거니까 역순으로 시작
		for( int i=Ai.size()-1;i>=0;i-- ) {
			int currentValue = Ai.get(i);
			
			if( remainder<currentValue ) {
				continue;
			}
			
			result += remainder/currentValue;
			remainder = remainder%currentValue;
			
			greedy(remainder);
		}
		
		return result;
	}

}
