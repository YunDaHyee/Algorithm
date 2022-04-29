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
		1. 1
		2. 2
		3. 3
		4. 4
	@Output
		첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
		1. *
		2.
		 *
		* *
		3.
		  *
		 * *
		* * *
		4.
		   *
		  * *
		 * * *
		* * * *
	@history
		원칙상 별 사이에 띄어쓰기 하는 부분이 
		
		bw.write("*");
		if( j!=i ){
			bw.write(" ");
		}
		
		일케 되어야 할 거 같은데
		걍 bw.write("* "); 이것두 맞다고 쳐진다..
		큼큼,,
		
		- 타 코드 Review
		사람들이 StringBuilder로 많이 조지던데 난 일단 그냥 출력하는 방식으로다가 하고 있음..
		
		StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            // 앞 공백
            for (int k = 0; k < n - i; k++)
                sb.append(" ");
            // 별 찍기
            for (int j = 0; j < i; j++) {
                sb.append("*");
                sb.append(" ");
            }
            sb.append("\n");
        }
		
 *
 */
public class _10991 {
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
				if( j!=i ){
					bw.write(" ");
				}
			}
			bw.newLine();
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
