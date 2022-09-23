/**
 * 
 */
package ETC;

/**
 	@Question
		양의 정수 n이 주어집니다.
		이 숫자를 k진수로 바꿨을 때, 변환된 수 안에 아래 조건에 맞는 소수(Prime number)가 몇 개인지 알아보려 합니다.
		
			0P0처럼 소수 양쪽에 0이 있는 경우
			P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
			0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
			P처럼 소수 양쪽에 아무것도 없는 경우
			(단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.
			예를 들어, 101은 P가 될 수 없습니다.)
			
		예를 들어, 437674을 3진수로 바꾸면 211020101011입니다.
		여기서 찾을 수 있는 조건에 맞는 소수는 왼쪽부터 순서대로 211, 2, 11이 있으며, 총 3개입니다.
		(211, 2, 11을 k진법으로 보았을 때가 아닌, 10진법으로 보았을 때 소수여야 한다는 점에 주의합니다.) 
		211은 P0 형태에서 찾을 수 있으며, 2는 0P0에서, 11은 0P에서 찾을 수 있습니다.
		
		정수 n과 k가 매개변수로 주어집니다.
		n을 k진수로 바꿨을 때, 변환된 수 안에서 찾을 수 있는 위 조건에 맞는 소수의 개수를 return 하도록 solution 함수를 완성해 주세요.
		
	@Restrictions
		1 ≤ n ≤ 1,000,000
		3 ≤ k ≤ 10
		정확성 테스트 : 10초
		
	@Input.Output
		입출력 예
		n		k	result
		437674	3	3
		110011	10	2
		
		입출력 예 #1
		문제 예시와 같습니다.
		
		입출력 예 #2
		110011을 10진수로 바꾸면 110011입니다.
		여기서 찾을 수 있는 조건에 맞는 소수는 11, 11 2개입니다.
		이와 같이, 중복되는 소수를 발견하더라도 모두 따로 세어야 합니다.


	@history
		진수 변환 후의 숫자에서
		10진수로서 조건 3가지 중에 부합하는 숫자들의 개수 반환
		
		처음에 조건이 까다로운가 싶었는데 생각해보니까
		사실 조건은 그렇게 신경쓰지 않아도 된다.
		0을 기준으로 나누면 0을 제외한 값들이 추출되기 때문이다.
		
		0대로 짜르면
		211
		2
		1
		1
		11
		이중에서 소수
		
		L100
		처음에는 while( n>0 ) 대신에 n!=k-1까지 반복되게 하고 마지막에 따로 n을 append 해주는 작업을 해줬는데
		그럴 필요가 없었다. 
		
	@Date
		2022. 6. 1.
 */

public class k진수에서소수개수구하기_92335 {
	public static void main(String[] args) {
		int n = //437674;
		110011;
		int k = //3;
		10;
		
		/*	소수 판별-에라토스테네스의 체. 주어진 범위 내의 값을 다 구하고 시작 */
		/*	n을 진수 변환 했을 때의 나올 수 있는 최대 길이로 크기를 설정 해야하는데
		 *	k진수로 바꾸고나서 문자를 이어붙이다보면 1 <= n <= 1000000인 n을 거뜬히 뛰어넘을 수 있으므로 이 방법은 ㄴㄴ
		 */
		/*boolean[] sieve = new boolean[n*10];
		sieve[0] = sieve[1] = true; // 0,1은 미리 초기화
		for( int i=2;i<=n;i++ ){
			if( !sieve[i] ){
				for( int j=i*2;j<=n;j+=i ){
					sieve[j] = true;
				}
			}
		}*/
		
		/* 1. 진법 변환 */
		//long			temp	= n;
		StringBuilder	numbers = new StringBuilder(); 
		//if( k!=10 ) {
			//while( temp!=k-1 ) {
			while( n>0 ) {
				//temp = n/k;
				numbers.append((long)n%(long)k);
				n/=(long)k;
				//n = temp;
			}
		//}
		//numbers.append(n);
		numbers.reverse();
		
		/* 2. 조건 부합 여부 */
		int			primeCount		= 0;
		String[]	splitNumbers	= numbers.toString().split("0");
		for( String raw : splitNumbers ){
			if( raw.isEmpty() ) {
				continue;
			}
			
			Long number	= Long.parseLong(raw);
			boolean primeFlag	= true;
			
			if( number<2 ){
				continue;
			}
			
			for( long j=2;j*j<=number;j++ ){
				if( number%j==0 ){
					primeFlag = false;
					break;
				}
			}
			
			if( primeFlag ){
				primeCount++;
			}
		}
		
		System.out.println(primeCount);
		
	}
}


