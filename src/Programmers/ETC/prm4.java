package ETC;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class prm4 {

	/*
		문제 설명
			함수 solution은 정수 n을 매개변수로 입력받습니다.
			n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
			예를들어 n이 118372면 873211을 리턴하면 됩니다.
		
		제한 조건
			n은 1이상 8000000000 이하인 자연수입니다.
			
		입출력 예
			n	return
			118372	873211
	 */
	public static void main(String[] args) throws IOException {
		/*
			 public long solution(long n) {
			      long answer = 0;
			      return answer;
			  }
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long n = 118372;
		char[] arr = String.valueOf(n).replaceAll("/(.0+$)/", "").toCharArray();
		char max = 0;
		int idx = 0;
		//N^2
		for( int i=0;i<arr.length;i++ ){ //전체 횟수 for문
			int original = i;
			char curN = arr[i];
			for( int j=idx;j<arr.length;j++ ) {
				char nextN = arr[j];
				if( curN < nextN ) {
					arr[i] = nextN;
					arr[j] = curN;
					i = j;
					if( max < nextN ) {
						max = nextN;
					}
				}
			}
			idx++;
			i = original;
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
