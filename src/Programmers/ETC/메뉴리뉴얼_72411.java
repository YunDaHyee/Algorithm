/**
 * 
 */
package ETC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 	@Question
		레스토랑을 운영하던 스카피는 코로나19로 인한 불경기를 극복하고자 메뉴를 새로 구성하려고 고민하고 있습니다.
		기존에는 단품으로만 제공하던 메뉴를 조합해서 코스요리 형태로 재구성해서 새로운 메뉴를 제공하기로 결정했습니다.
		어떤 단품메뉴들을 조합해서 코스요리 메뉴로 구성하면 좋을 지 고민하던 "스카피"는
		이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했습니다.
		단, 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다.
		또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 했습니다.
		
		예를 들어, 손님 6명이 주문한 단품메뉴들의 조합이 다음과 같다면,
		(각 손님은 단품메뉴를 2개 이상 주문해야 하며, 각 단품메뉴는 A ~ Z의 알파벳 대문자로 표기합니다.)
		
		손님 번호	주문한 단품메뉴 조합
		1번 손님	A, B, C, F, G
		2번 손님	A, C
		3번 손님	C, D, E
		4번 손님	A, C, D, E
		5번 손님	B, C, F, G
		6번 손님	A, C, D, E, H
		가장 많이 함께 주문된 단품메뉴 조합에 따라 "스카피"가 만들게 될 코스요리 메뉴 구성 후보는 다음과 같습니다.
		
		코스 종류		메뉴 구성	설명
		요리 2개 코스	A, C		1번, 2번, 4번, 6번 손님으로부터 총 4번 주문됐습니다.
		요리 3개 코스	C, D, E		3번, 4번, 6번 손님으로부터 총 3번 주문됐습니다.
		요리 4개 코스	B, C, F, G	1번, 5번 손님으로부터 총 2번 주문됐습니다.
		요리 4개 코스	A, C, D, E	4번, 6번 손님으로부터 총 2번 주문됐습니다.
		
		[문제]
		각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열 orders,
		"스카피"가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 course가 매개변수로 주어질 때,
		"스카피"가 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 return 하도록 solution 함수를 완성해 주세요.

	@Restrictions
		orders 배열의 크기는 2 이상 20 이하입니다.
		orders 배열의 각 원소는 크기가 2 이상 10 이하인 문자열입니다.
		각 문자열은 알파벳 대문자로만 이루어져 있습니다.
		각 문자열에는 같은 알파벳이 중복해서 들어있지 않습니다.
		course 배열의 크기는 1 이상 10 이하입니다.
		course 배열의 각 원소는 2 이상 10 이하인 자연수가 오름차순으로 정렬되어 있습니다.
		course 배열에는 같은 값이 중복해서 들어있지 않습니다.
		정답은 각 코스요리 메뉴의 구성을 문자열 형식으로 배열에 담아 사전 순으로 오름차순 정렬해서 return 해주세요.
		배열의 각 원소에 저장된 문자열 또한 알파벳 오름차순으로 정렬되어야 합니다.
		만약 가장 많이 함께 주문된 메뉴 구성이 여러 개라면, 모두 배열에 담아 return 하면 됩니다.
		orders와 course 매개변수는 return 하는 배열의 길이가 1 이상이 되도록 주어집니다.
		
	@Input.Output
		[입출력 예]
		
		orders												course	result
		["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]		[2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
		["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	["ACD", "AD", "ADE", "CD", "XYZ"]
		["XYZ", "XWY", "WXA"]								[2,3,4]	["WX", "XY"]
		입출력 예에 대한 설명
		입출력 예 #1
		문제의 예시와 같습니다.
		
		입출력 예 #2
		AD가 세 번, CD가 세 번, ACD가 두 번, ADE가 두 번, XYZ 가 두 번 주문됐습니다.
		요리 5개를 주문한 손님이 1명 있지만 최소 2명 이상의 손님에게서 주문된 구성만 코스요리 후보에 들어가므로
		요리 5개로 구성된 코스요리는 새로 추가하지 않습니다.
		
		입출력 예 #3
		WX가 두 번, XY가 두 번 주문됐습니다.
		3명의 손님 모두 단품메뉴를 3개씩 주문했지만 최소 2명 이상의 손님에게서 주문된 구성만 코스요리 후보에 들어가므로
		요리 3개로 구성된 코스요리는 새로 추가하지 않습니다.
		또, 단품메뉴를 4개 이상 주문한 손님은 없으므로
		요리 4개로 구성된 코스요리 또한 새로 추가하지 않습니다.

	@history
		N = 추가하게될 코스요리의 메뉴 구성 - 각 코스요리 순서, 전체 순서 둘 다 알파벳 순으로 오름차순으로 정렬
		
		조합으로 풀어야함.
		순서 상관없음
		단순히 개수만 체크하는 게 아니고 그 구성이 뭔지도 알아야함..
		등장횟수 체크 해야하나?
		횟수는 그렇다 쳐도 어떻게 모든 경우의 조합을 다 저장하지?
		5C2+5C3+5C4+5C5
		2C1+2C2
		
		각 문자열에 같은 알파벳이 중복해서 안들어있으니까
		조합 가능한 경우의 수의 최대값 = 최고 긴 길이-1
		=> 첫 번째 예에서는 4번째 자리까지 조합 가능함
		
		다 돌면서 .. 조합 배열을 구성하고 해당 조합이 있으면 카운팅하는 방식..
		아나 ㅡㅡ 순서 상관있네 .. 왔따갔따 하는 오만 조합이 아니고 걍 그 제자리에서 순서네;;
		
		BFS로 다시 풀어야함 ㅎㅎ
		왔다갔따 오만가지의 조합이 아니기 때문에 이건 bfs..
		아닌 듯;; 한 방향으로만 진행되는 거에 하는거니까.. 
		
		아니 여러개 조합 맞는데?ㅋㅋㅋㅋㅋ
		
		여러개 조합 아닌 줄 알고 prefix 이런식으로 접근할랬는데 여러개 조합이 맞았어서 접음..ㅎㅎ
		
		근데 index로 구분할 필요가 있나..?
		같은 건 안들어갈텐데
		
		결국 CombinationSet 클래스로 구현해서 구조체처럼 하려다가 인덱스의 필요성을 못느껴서
		횟수만 넣는 것으로 함..
		
	@Date
		2022. 6. 16.
 */

public class 메뉴리뉴얼_72411 {
	//static Map<Integer, Map<String,CombinationSet>> courses = new HashMap<Integer, Map<String,CombinationSet>>();
	static boolean[] visitedDigit;
	static Map<Integer, Map<String,Integer>> courses = new HashMap<Integer, Map<String,Integer>>();
	static int[] courseMax = new int[11]; // course의 경우에 따라 구한 조합들 중 가장 많이 주문된 횟수를 저장.
	
	public static void main(String[] args) {
		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}; 
		//	{ "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" }; 
		// { "XYZ", "XWY", "WXA" }; 
		int[] course = {2,3,4};
		//{2,3,5};
		
		List<String> result = new ArrayList<String>();

		for( int c : course ){
			courses.put( c, new HashMap<String,Integer>() );
			for( int i=0;i<orders.length;i++ ) {
				String[] splitOrder = orders[i].split("");
				visitedDigit = new boolean[splitOrder.length]; // order별로 방문 자릿수 체크 배열을 새로 생성
				dfs( splitOrder, 0, 0, c, "" ); // 현재 course
			}
		}
		
		for( int count : courses.keySet() ){
			Map<String, Integer> temp = courses.get(count);
			for( String key : temp.keySet() ){
				int maxCount	= courseMax[key.length()];
				int	currentCount= temp.get(key);
				if( currentCount>1 && (maxCount<currentCount||maxCount==currentCount) ){ // 최소 2명 이상의 손님에게서 주문된 구성만 코스요리 후보 && 현재 코스의 최대 요리개수와 같크
					result.add(key);
				}
			}
		}
		
		result.sort(null);
	}
	
	
	private static void dfs(String[] splitOrder, int startIndex, int digit, int currentCourseCount, String temp) {
		if( digit == currentCourseCount ){ // 증가 자리수==코스 음식 개수
			char[] tempArray =  temp.toCharArray();
			Arrays.sort(tempArray);
			temp = new String(tempArray);
			
			Map<String, Integer> combinationSet	= courses.get(currentCourseCount);
			
			if( combinationSet!=null && combinationSet.containsKey(temp) ){
				int currentCount = combinationSet.get(temp);
				combinationSet.put( temp, currentCount+1 );
				if( courseMax[digit]<currentCount+1 ) {
					courseMax[digit] = currentCount+1;
				}
				return;
			}
			
			combinationSet.put( temp, 1 );
		}
		
		/*if( digit>1 ){
			char[] tempArray =  temp.toCharArray();
			Arrays.sort(tempArray);
			temp = new String(tempArray);
			
			Map<String, Integer> combinationSet	= courses.get(digit);
			if( combinationSet.containsKey(temp) ){
				int currentCount = combinationSet.get(temp);
				combinationSet.put(temp, currentCount+1 );
				if( courseMax[digit]<currentCount+1 ) {
					courseMax[digit] = currentCount+1;
				}
			}else {
				combinationSet.put( temp, 1 );
			}
		}*/
		
		for( int i=startIndex;i<=splitOrder.length-1;i++ ){
			if ( !visitedDigit[i] ) {  // 한번 사용된 요소는 다시 사용하면 안되므로 필터링
        		visitedDigit[i] = true; // 재귀 들어가기 전에 T를 해줘서 다음 문자가 같은 게 오지 않도록 하기 위함
				dfs( splitOrder, i+1, digit+1, currentCourseCount, temp+splitOrder[i] );
				visitedDigit[i] = false; // 빠져나온 후에는 F를 해줘서 다음 턴에서 앞에 오는 문자들이 다시 올 수 있도록 풀어줌.
        	}
		}
		
	}
	
}

class CombinationSet{
	int index;
	int count;
	
	public CombinationSet(int index, int count) {
		super();
		this.index = index;
		this.count = count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isEqual(int compareIndex) {
		return index==compareIndex?true:false;
	}
	
}


