import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class prm3 {

	/*
		두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
		배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
		예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

		제한 사항
		두 수는 1이상 1000000이하의 자연수입니다.
		
		입출력 예
		n	m	return
		3	12	[3, 12]
		2	5	[1, 10]
		
		입출력 예 설명
		입출력 예 #1
		위의 설명과 같습니다.
		
		입출력 예 #2
		자연수 2와 5의 최대공약수는 1, 최소공배수는 10이므로 [1, 10]을 리턴해야 합니다.
	 */
	public static void main(String[] args) throws IOException {
		/*
			 public int[] solution(int n, int m) {
			      int[] answer = {};
			      return answer;
			  }
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = 3, m = 12;
		
		/*
		 최대공약수와 최소공배수를 구할 두 수 중 큰수와 작은수를 정한 뒤 큰 수를 작은수로 나누어 나머지를 구합니다.
		 이때 나머지가 0이면 그때의 작은수가 최대공약수이고, 원래의 두수를 곱한 값을 최대공약수로 나눈 값이 최소공배수입니다
		 
		 */
		
		int maxDivisor = 0;		// 최대공약수
		int minMultiple = 0;	// 최소공배수
		
		int big, small;
		
		if( n<m ) {
			big		= m;
			small	= n;
		}else {
			big		= n;
			small	= m;
		}
		
		while(true){
			int nmg = big%small;
			if( nmg==0 ) {
				maxDivisor	= small;
				minMultiple = (big*small)/maxDivisor;
				break;
			}else {
				big		= small;  // 작은 수가 큰 수
				small	= nmg; // 나머지가 작은 수
				continue;							
			}
		}
		
		int[] answer = { small, big };
		
		//Developer.D
		
		br.close();
		bw.flush();
		bw.close();
	}

}
