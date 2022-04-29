/**
 * 
 */
package Level_2.BruteForce;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 	@Question
		한자리 숫자가 적힌 종이 조각이 흩어져있습니다.
		흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
		각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
		종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
	
	@Restrictions
		numbers = 길이 1 이상 7 이하인 문자열, 0~9까지 숫자만으로 이루어져 있습니다.
		"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

	@Input.Output
		numbers	return
		"17"	3
		"011"	2
		
		예제 #1
		[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

		예제 #2
		[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
		
		11과 011은 같은 숫자로 취급합니다.
		
	@history
		N = 0~9의 수중 주어진 수만으로 만들 수 있는 소수의 모든 경우의 수 구하기
		
		STEP 1) 손으로 게싼 가능
		STEP 2) 숫자 N개 * 에레토스테네스의 체로 구하면 NLOGN
		
		에레토스테네스의 체로 숫자 다 구해놓고
		조합한 숫자가 소수인지 인덱스로 접근해서 확인
		
		조합이 아닌 순열이 필요하다
		
		- 시행착오
		1. 처음에는 자릿수 for문, 첫째자리 for문, 나머지 자리수 for문 이런식으로 3중 포문을 할까 했는데 이건..아닌 것 같아서 순열 알고리즘을 찾아봤다.
		2. swap함수로 이용하는 코드가 있어서 그걸 이용하려다가 나와있는대로 해도 안되길래 다른 코드를 찾았다
		3. 처음에는 bfs로 접근을 한다는 생각을 못해서 1의 자리 수는 재귀 들어가기전에 반복문을 돌려서 하나씩 넣어줬다.
		4. dfs() 안에서 모든 경우의 수를 combinationNumbers에다가 넣고 빠져나온 뒤에 main에서 소수인지 아닌지를 판단했다가 dfs 내부에서 하는 것으로 바꿈 
		5. 막판에 자꾸 런타임 에러가 났었는데 check 배열이 인덱스 초과가 원인이었다.
		
	@Date
		2022. 4. 20.
 */

public class 소수찾기 {
	//int[]	combinationNumber	= new int[rawsNumbers.length]; // 얼마난 ㅡㄹ어날지 모르기떄문에 배열로 하면 안됨
	//static int[] combinationNumbers = new int[100001];
	static HashSet<Integer> combinationNumbers = new HashSet<Integer>();
	//static char[] swapNumbers 
	//static LinkedList<Integer> swapNumbers = new LinkedList<Integer>();
	static String[] rawsNumbers;
	static boolean[] visitedDigit;
	static boolean[] check = new boolean[10000000];

	public static void main(String[] args) throws IOException {
		String numbers = 
		"17";
		//"011";
		//"001";
		//"234";
			
		int result = 0;
		

		// 소수 미리 구해놓기
		check[0] = check[1] = true;
		
		for( int i=2;i<check.length;i++ ) {
			if( !check[i] ) {
				for( int j=i*2;j<check.length;j+=i ) {
					check[j] = true;
				}
			}
		}

		rawsNumbers = numbers.split("");
		visitedDigit = new boolean[rawsNumbers.length]; // 2만큼
		
		// 1의 자리 수만큼 돌음
		/*for( int i=0;i<rawsNumbers.length;i++ ) {
			combinationNumbers.add( Integer.parseInt(Character.toString(rawsNumbers[i])) );
		}*/
		
		// 숫자 조합 만들기 - 순열 - 돌아가면서 앞자리 세우기 식으로..
		//permutation(0,2); // 현재 자리수, 총 구해야 하는 자릿수
		dfs(0,"");

		/*Iterator<Integer> iterator = combinationNumbers.iterator();
		while( iterator.hasNext() ) {
			if( !check[iterator.next()] ) {
				result++;
			}
		}*/
		
		System.out.println(combinationNumbers.size());

	}
	
	public static void dfs(int digit, String number) {
        if ( digit > rawsNumbers.length ){ // digit을 계속 더하는 식이므로 숫자 배열의 길이를 벗어나지 않도록하기 위함
        	return;
        }
        
        // 소수판단
        if( number!="" && !check[Integer.parseInt(number)] ) {
        	 // 숫자로 변환할 것이라서 빈 문자열이 아니고 소수일 때에만 최종 배열에 넣음
			combinationNumbers.add( Integer.parseInt(number) );
		}
        
        for( int i=0;i<rawsNumbers.length;i++ ){ //0, 2
        	if ( !visitedDigit[i] ) {  // 한번 사용된 요소는 다시 사용하면 안되므로 필터링
        		visitedDigit[i] = true; // 재귀 들어가기 전에 T를 해줘서 다음 숫자가 같은 게 오지 않도록 하기 위함
				dfs( digit+1,number+rawsNumbers[i] );
				visitedDigit[i] = false; // 빠져나온 후에는 F를 해줘서 다음 턴에서 앞에 오는 숫자들이 다시 올 수 있도록 풀어줌
        	}
        }
	}
	
}