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
		5
	@Output
		첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
		    *
		   ***
		  *****
		 ******* 7 = 2*4 - 1
		********* 9 =(2*5)-1
		 ******* line-1 = 6
		  *****
		   ***
		    *
	@history
		거의 껴맞추기식 코드가 됨..
		while문을 할 때는 좀 정확하게 할 수 있을 때 해야겠다. 안그러면 뒤죽박죽 돼서 잘 몰겠다,,
		그냥 이럴 때는 for문으로 해야겠다..
		
		-타 코드 Review
		내가 또 너무 많은 변수를 남발한 것 같다는 생각이 듬..
		이 코드는 바깥 for문만 설정해서 안에는 같게 적용한 코드인데 이렇게 효율적으로 짜야함ㅠ
		안그럼 너무 뒤죽박죽이라 모른다..
 *
 */
public class _2444 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int size	= Integer.parseInt( br.readLine() );
		/*
		int halfSize= (2*size-1)/2;
		int maxStar = 2*size-1;
		int line	= 0;
		
		while( ++line<=size ){
			for( int i=halfSize--;i>0;i-- ){
				bw.write(" ");
			}
			for( int i=1;i<=(2*line)-1;i++ ){
				bw.write("*");
			}
			bw.newLine();
		}
		
		while( line++<=maxStar ){
			for( int i=++halfSize+1;i>0;i-- ){
				bw.write(" ");
			}
			for( int i=0;i<=maxStar-(2*halfSize)-3;i++ ){
				bw.write("*");
			}
			bw.newLine();
		}
		*/
		
		// - 타 코드 적용
		for( int i=1;i<=size;i++ ){
			for( int j=0;j<size-i;j++ ){
				bw.write(" ");
			}
			for( int j=0;j<(2*i)-1;j++ ){
				bw.write("*");
			}
			bw.newLine();
		}
		
		for( int i=size;i>0;i-- ){
			for( int j=0;j<size-i;j++ ){
				bw.write(" ");
			}
			for( int j=0;j<(2*i)-1;j++ ){
				bw.write("*");
			}
			bw.newLine();
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
