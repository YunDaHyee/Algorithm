/**
 * 
 */
package Basic_Level._2_Math.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
	@문제
		양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.
	@입력
		첫째 줄에 테스트 케이스의 개수 t (1 ≤ t ≤ 100)이 주어진다.
		각 테스트 케이스는 한 줄로 이루어져 있다.
		각 테스트 케이스는 수의 개수 n (1 < n ≤ 100)가 주어지고, 다음에는 n개의 수가 주어진다.
		입력으로 주어지는 수는 1,000,000을 넘지 않는다.
		3
		4 10 20 30 40
		3 7 5 12
		3 125 15 25
	@출력
		각 테스트 케이스마다 가능한 모든 쌍의 GCD의 합을 출력한다.
		70
		3
		35
	@HISTORY
		최대공약수(GCD. Greatest Common Divisor) : 공통된 약수 중 가장 큰 정수.
		HOW TO
		1)	O(N) - 작은 수~큰 약수가 될 수 있는 후보까지 나눠가면서 최대공약수를 구한다.
		2)	O(logN) - 유클리드 호제법 ☑
			GCD(A,B) = GCD(B,r). r==0이 되는 그때의 B가 최대공약수
			- HOW TO
				1) 재귀
				2) while문
		 
		 작은수가 항상 a가 되니까 나눠지는 수는 계속 2만 나오는 중..
		 가능한 모든 쌍이면은 하나의 수마다 나머지 수들을 다 매칭시켜야한단건가??
		 GCD(GCD(a,b),c) 이런식으로 했었는데 바꿔보겠다.
		 첫번째꺼 했는데 164 나옴;;
		 같은 거나 두번째 숫자가 더 큰 경우는 배제 했는데도 크다..
		 
		 남 거 본 결과 :
		 	-	이중포문의 j가 0부터 매번 시작하는 게 아니라 i부터 시작
		 	-	이중포문의 i는 numberA이므로 length-1 까지여야 한다.
		 	  	(끝나는 수가 다른 건 마지막 숫자는 다음 숫자가 없으니까 비교할 게 없어서임.)
	 		-	sumGCD의 자료형은 int가 아닌 long이어야 한다.
	 			1,000,000를 넘진 않아도 그 값의 언저리 값이면은 int의 범위를 넘어서기 때문
	 			
	 	하 그래도 안되는데 어떻게 70이 나오지?
	 	
	 	하도하도 안돼서 그냥 다른 사람 거 소스 가지고 디버깅 해봤는데
	 	첫 번째 요소를 제외하고 숫자 배열을 만들어서 한다는 게 내 소스랑 다른 점이었다.
	 	왜 빼는거지??
	 	
	 	아ㅡㅡ한 라인별로 가장 앞에 있는 수는 나열하는 n개의 수였다..
	 	하.....이것 때문에 하루종일 삽질을 했는 것 같은데
	 	진작 디버깅 해볼걸.. 앞으로는 안되면 남 소스 가지고 직접 디버깅을 해봐야겠다.
	 	진짜 단순한 해결방안이었는데 이제라도 깨달았으니 됐다..
	 	
	@Date
		2021. 11. 24. 
 */

public class _1_9613 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
		StringBuffer	result		= new StringBuffer();
		int 			caseCount	= Integer.parseInt(br.readLine());
		
		while(caseCount-->0){
			long		sumGCD	= 0;
			String[]	raws	= br.readLine().split(" ");
			
			for( int i=1;i<raws.length-1;i++ ){
				for( int j=i+1;j<raws.length;j++ ){
					sumGCD += getGCD(Integer.parseInt(raws[i]), Integer.parseInt(raws[j]));
				}
			}
			result.append(sumGCD+"\n");
		}
		System.out.println(result);
		br.close();
	}

	public static int getGCD( int numberA, int numberB ) {
		while( numberB!=0 ){
			int r = numberA%numberB;
			numberA = numberB;
			numberB = r;
		}
		return numberA;
	}
}
