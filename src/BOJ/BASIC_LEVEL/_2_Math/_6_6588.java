/**
 * 
 */
package BASIC_LEVEL._2_Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

/**
	@문제
		1742년, 독일의 아마추어 수학가 크리스티안 골드바흐는 레온하르트 오일러에게 다음과 같은 추측을 제안하는 편지를 보냈다.
		4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
		예를 들어 8은 3 + 5로 나타낼 수 있고, 3과 5는 모두 홀수인 소수이다. 또, 20 = 3 + 17 = 7 + 13, 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23 이다.
		이 추측은 아직도 해결되지 않은 문제이다.
		백만 이하의 모든 짝수에 대해서, 이 추측을 검증하는 프로그램을 작성하시오.
		
	@입력
		입력은 하나 또는 그 이상의 테스트 케이스로 이루어져 있다. 테스트 케이스의 개수는 100,000개를 넘지 않는다.
		각 테스트 케이스는 짝수 정수 n 하나로 이루어져 있다. (6 ≤ n ≤ 1000000)
		입력의 마지막 줄에는 0이 하나 주어진다.
		8
		20
		42
		0
		
	@출력
		각 테스트 케이스에 대해서, n = a + b 형태로 출력한다.
		이때, a와 b는 홀수 소수이다.
		숫자와 연산자는 공백 하나로 구분되어져 있다.
		만약, n을 만들 수 있는 방법이 여러 가지라면, b-a가 가장 큰 것을 출력한다.
		또, 두 홀수 소수의 합으로 n을 나타낼 수 없는 경우에는 "Goldbach's conjecture is wrong."을 출력한다.
		8 = 3 + 5
		20 = 3 + 17
		42 = 5 + 37
		
	@HISTORY
		소수 구하는건 했는데
		n 만들 수 있는 방법이 여러가지인데 b-a가 가장 큰 걸 어떻게 하지?..
		N=a+b -> N-b=a
		
		b-a 가장 큰 것에 대한 출력에 대해 집착을 하는 바람에
		다 계산해놓고 재 뿌린 꼴..
		걍 N-i 했으면 끝났을 일이었따..ㅜㅜ
		처음에는 에라토스테네스의 체를 while문 안에 넣어서 그런지
		시간초과가 났었는데
		다른 사람 거 안보고라도
		밖에서 최대수인 1000000까지 구하게 하는 걸 생각해내서 다행이다.
		그것때문에 조금 더 수월했다.
	
	@Date
		2021. 11. 22. 
 */

public class _6_6588 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw			= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int even = 1000000;
		boolean[] flags = new boolean[even+1];
		StringBuffer result = new StringBuffer();
		
		flags[0] = flags[1] = true;
		
		for( int i=2;i<=even;i++ ){
			if( !flags[i] ){
				for( int j=i*2;j<=even;j+=i ){
					if( !flags[j] ){
						flags[j] = true;
					}
				}
			}
		}
		
		while( (even = Integer.parseInt(br.readLine()))!=0 ){
			boolean successFlag = false;
			for( int i=2;i<=even/2;i++ ){
				int subtractionValue = even-i;
				if( !flags[i]&&!flags[subtractionValue] ){
					result.append(even+" = "+i+" + "+subtractionValue+"\n");
					successFlag = true;
					break;
				}
			}
			
			if(!successFlag){
				result.append("Goldbach's conjecture is wrong.\n");
			}
		}
		
		bw.write(result.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
}
