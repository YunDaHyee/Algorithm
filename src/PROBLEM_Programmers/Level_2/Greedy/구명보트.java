/**
 * 
 */
package Level_2.Greedy;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 	@Question
		무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다.
		구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
		예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면
		2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.
		구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
		사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때,
		모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
	
	@Restrictions
		무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
		각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
		구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
		구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.

	@Input.Output
		people				limit	return
		[70, 50, 80, 50]	100		3
		[70, 80, 50]		100		3
		
	@history
		N = 사람들 구출에 필요한 구명보트 개수의 최소값
		
		일단 제일 무거운 사람들을 먼저 실어야 그 다음쫌쫌들을 여려명 태울 수 있음
		오름차순 정렬 후에 무게 제한 전까지의 돼지들을 싣는다
		
		50 50 70 80
		
		젤 큰 놈인 80. 나머지 무게 =  20
		+1 후에 20보다 작같 애들을 찾고 그만큼 더해줌
		
		- 시간복잡도
		사람들 수가 P이라면, O(P)
		사람들 수에 따라 좌우됨
		
		테케와 효율성에서 오류가 났따.
		
		- 테케에서 오류난 이유
		문제에서 2명밖에 못탄다는 내용을 간과했다...ㅠ

		- 효율성에서 오류난 이유
		아무래도 인덱스 접근을 해서 그런 것 같은데 list로 바꿔봄
	@Date
		2022. 4. 17.
 */

public class 구명보트 {

	public static void main(String[] args) throws IOException {
		int		limit	= 100;
		int[]	people	= //{40,240};
							//{50, 50, 50, 50};
							{10, 100, 30, 70};
							// {70, 80, 50};
		int result = 0;
		
		/* ==================================================================== */
			boolean[] rescuedPeople = new boolean[people.length];
			
			Arrays.sort(people);
			
			for( int i=people.length-1;i>=0;i-- ) {
				int maxPeople = 0;
				
				if( rescuedPeople[i] ) {
					continue;
				}
				
				result++;
				maxPeople++;
				rescuedPeople[i] = true;
				
				int remainder = limit - people[i];
				
				for( int j=i-1;j>=0&&remainder>0&&maxPeople<2;j-- ) {
					int nextPeople = people[j];
					if( !rescuedPeople[j]&&nextPeople<=remainder ) {
						maxPeople++;
						remainder -= nextPeople;
						// TODO 만약 뺀다면은 그 수는 앞으로 실어야할 리스트에서 제거되어야 하는데 스택큐는 값을 계쏙 봐야하니까 의미가 없는데 그렇다고 list의 삭제연산을 넣기엔 너무 시간이 오래 걸릴 것 같고..
						// 탑승자의 인덱스 리스트를 만들어서 참조할 수 있또록 하자!
						rescuedPeople[j] = true;
					}
				}
			}
			
			System.out.println(result);
		/* ==================================================================== */
		
		/* 남 코드 보고 바꿔본 */

		Deque<Integer> peopleDeque = new ArrayDeque<Integer>(50001);
		Arrays.sort(people);
		
		//int passanger = 0;
		
		for( int weight : people ) {
			peopleDeque.add(weight);
		}
		
		//int currentBoatLimit = limit; //이거도 굳이 안둬도 되는 게 그냥 조건문에서 검사할 떄만 현재무게+다음무게<limit 인지만 체크하면 되기떄문
		
		while( !peopleDeque.isEmpty()  ) {
			result++;
			//passanger++;
			//currentBoatLimit -= peopleDeque.pollLast();
			
			//if( !peopleDeque.isEmpty() ) {
				int currentPerson = peopleDeque.pollLast();
				/*if( passanger==2 ) {
					passanger=0;
					continue;
				}*/
				//while( currentBoatLimit>=peopleDeque.peekFirst()&&passanger!=2 ) { // 아 어차피.. 앞뒤로 한번씩만 하니까 두번 채워져서 2인지는 체크 안해도 되게꾸나
				if( !peopleDeque.isEmpty()&&currentPerson+peopleDeque.peekFirst()<=limit ) {
					peopleDeque.pollFirst();
				}
				//currentBoatLimit = limit;
			//}
		}
		
		// => 총 정리 코드
		Arrays.sort(people);
		
		for( int weight : people ) {
            peopleDeque.add(weight);
        }

        while( !peopleDeque.isEmpty()  ) {
            result++;
            int currentPerson = peopleDeque.pollLast();
            if( !peopleDeque.isEmpty() && currentPerson+peopleDeque.peekFirst()<=limit ) {
                peopleDeque.pollFirst();
            }
        }
		
		
		/* 잘한 남 코드 .. 정말 생각을 어케 하냐에 대한 한 끗 차이인 듯하다.. 본받아야지.. */
		Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
		
		/* */
		
		System.out.println(result);
		
	}

}
