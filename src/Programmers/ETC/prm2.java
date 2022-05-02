package ETC;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class prm2 {

	/*
		임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
		n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
		
		제한 사항
		n은 1이상, 50000000000000 이하인 양의 정수입니다.
		입출력 예
		n	return
		121	144 => 121 - in : 11의 제곱근. out : 12의 제곱
		3	-1
	 */
	public static void main(String[] args) throws IOException {
		/*
			함수(long n) {
		      long answer = 0;
		      return answer;

		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long n = 121;
		double Geun = Math.sqrt(n);
		double answer = Geun - Math.round(Geun);
		if( answer == 0.0 ) {
			bw.write( String.valueOf(Math.round( (Geun+1)*(Geun+1) )));
		}else {
			bw.write("-1");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
