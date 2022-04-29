package StepBystep._3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
	@Question
		예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.
	@Input
		첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
		3
	@Output
		첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
		  *
		 **
		***
		 **
		  *
	@history
		오 이제 적응 좀 되서 빠르게 탁탁 하는 편 같다.
		
		-타 코드 Review
		  for (int i = 1; i <= N * 2 - 1; i++) {
            if (i <= N) {
                for (int j = 1; j <= N - i; j++) {
                    bw.write(" ");
                }
                for (int j = 1; j <= i; j++) {
                    bw.write("*");
                }
            }
            if (i > N) {
                for (int j = 1; j <= i - N; j++) {
                    bw.write(" ");
                }
                for (int j = 1; j <= N * 2 - i; j++) {
                    bw.write("*");
                }
            }
            bw.write("\n");
        }
        
        순방향/역방향인지에 따라 if문을 줘가지고 for문을 두번이나 덜 돌게 할 수 있따.
        이 코드는 좀 배울만한 듯!
        나머지는 다 비슷해가지고 타 코드 리뷰할 게 없었는데 이거는 ㅇㅇ!
		
		
 *
 */
public class _2522 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int size = Integer.parseInt( br.readLine() );
		
		for( int i=0;i<size;i++ ){
			for( int j=size-i;j>1;j-- ){
				bw.write(" ");
			}
			for( int j=0;j<=i;j++ ){
				bw.write("*");
			}
			bw.newLine();
		}
		
		for( int i=size-2;i>=0;i-- ){
			for( int j=size-i;j>1;j-- ){
				bw.write(" ");
			}
			for( int j=0;j<=i;j++ ){
				bw.write("*");
			}
			bw.newLine();
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
