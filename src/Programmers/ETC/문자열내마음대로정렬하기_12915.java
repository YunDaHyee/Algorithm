package ETC;

import java.util.Arrays;

/**
	@Question
		문자열로 구성된 리스트 strings와 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
		예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
		
	@Restrictions
		strings는 길이 1 이상, 50이하인 배열입니다.
		strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
		strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
		모든 strings의 원소의 길이는 n보다 큽니다.
		인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
	
	@Input.Output
		strings					n	return
		
		["sun", "bed", "car"]	1	["car", "bed", "sun"]
		"sun", "bed", "car"의 1번째 인덱스 값은 각각 "u", "e", "a" 입니다.
		이를 기준으로 strings를 정렬하면 ["car", "bed", "sun"] 입니다.
		
		["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]
		"abce"와 "abcd", "cdx"의 2번째 인덱스 값은 "c", "c", "x"입니다.
		따라서 정렬 후에는 "cdx"가 가장 뒤에 위치합니다.
		"abce"와 "abcd"는 사전순으로 정렬하면 "abcd"가 우선하므로, 답은 ["abcd", "abce", "cdx"] 입니다.
		
	@history
		인덱스 n의 기준으로 정렬하기
		단, 인덱스의 값이 동일하면 원래 단어의 사전순으로 위치 시키기
		
		무조건 정렬 순서를 입출력 예시로만 생각해서 구현했다.
		코드 실행하면 분명 맞는데 자꾸 테스트케이스들을 통과하지 못함..
		
		- 다른 사람 풀이 참조
		애초에 사전순으로 먼저 정렬을 한 뒤에 n번째 인덱스 값으로 정렬하면 된다.
		관점을 전환하는 연습이 필요하다.,

	@Date
		2022. 9. 26.
 */
public class 문자열내마음대로정렬하기_12915 {
	public static void main(String[] args) {
		String[] strings
		//= {"sun", "bed", "car"};
		= {"abce", "abcd", "cdx"};
		int n //= 1;
		=2;
		
		String[]	answer	= new String[strings.length];
		
		/* 남 풀이 참조 */
		Arrays.sort(strings); // 사전순으로 먼저 정렬
		
		for( int i=0;i<strings.length;i++ ){
			strings[i] = strings[i].charAt(n) + strings[i]; // 인덱스에 알파벳이 들어감.
		}
		
		Arrays.sort(strings); // 인덱스 n의 char로 두 번째 정렬
		
		for( int i=0;i<strings.length;i++ ){
			answer[i] = strings[i].substring(1); // 인덱스에 알파벳이 들어감.
		}
		
		/*
		// 틀린 풀이
		int[]		alpabet = new int[25];			// 해당 char로 값을 찾아올 수 있게 알파벳 만큼 배열을 만듦.
		List<String>[] hold	= new ArrayList[25];	// char이 여러개일 수도 있기 때문에 list로 줌
		String[]	answer	= new String[strings.length];
		
		for( int i=0;i<25;i++ ){	
			hold[i] = new ArrayList<String>();
		}
		
		for( int i=0;i<strings.length;i++ ){
			int tobeIndex = strings[i].charAt(n)-'a';
			
			if( alpabet[tobeIndex]!=0 ){ // 이미 값이 있으면
				int existIndex = alpabet[tobeIndex];
				hold[existIndex].add(strings[existIndex]);
				hold[existIndex].add(strings[i-1]);
				continue;		
			}	
			
			alpabet[tobeIndex] = i+1; 
		}
		
		int index = 0;
		
		for( int a : alpabet ){
			if( a==0 ){
				continue;
			}
			if( !hold[a].isEmpty() ){
				hold[a].sort(null);
				for( String string : hold[a] ){
					answer[index++] = string; 
				}
				continue;
			}	
			answer[index++] = strings[a-1]; 
		}*/
	}

}

