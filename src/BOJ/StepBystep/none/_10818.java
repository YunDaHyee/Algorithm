package StepBystep.none;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 
	@Question
		N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다.
		둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
		모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
		5
		20 10 35 30 7
	@Output
		첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
		7 35	
	@history
		맞게 했는데 왜 안됐지 싶었는데 일단 최대,최소 값을 문제에서 주어진 값으루다가 했음.
		맨 첨엔 최대는 1000000,최소는 -1000000로 했는데
		생각해보니까 그거보다 같거나 크/작인데 그걸 최대최소로 해버리니까 당연 결과는 걔들이 나오지;
		그래서 반대루 설정함. 최대는 -1000000로, 최소는 1000000로.
		
		-타 코드 Review
		StringTokenizer
		Integer.MAX_VALUE/MIN_VALUE
		MATH.max(비교값1,2),MATH.min(비교값1,2)
		while문
		
		여러가지 테스틀 해본 결과, StringTokenizer+while문+MATH 클래스 조합이 가장 빠르고 편했다.
		StringTokenizer를 이용하면 반복문 내에서 직접적인 접근을 안해도
		nextToken()을 이용해서 접근할 수 있으니까 문자열 배열,for문을 이용안해도 됨.
 *
 */
public class _10818 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br		= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw		= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int				count	= Integer.parseInt( br.readLine() );
	
		/*
		int				max		= -1000000;
		int				min		= 1000000;
		
		String[]		numArr	= new String[count];
		numArr					= br.readLine().split(" ");
		
		for( int i=0;i<count;i++ ){
			int tempNum = Integer.parseInt(numArr[i]);
			if( tempNum > max ){
				max = tempNum;
			}
			if( tempNum < min ){
				min = tempNum;
			}
		}
		*/
		
		// 타 코드 이용
		int				max		= Integer.MIN_VALUE;
		int				min		= Integer.MAX_VALUE;
		StringTokenizer st		= new StringTokenizer( br.readLine() );
		
		while( count>0 ){ // 타 코드에서는 st.hasMoreToken()을 이용해서 조건을 걸었었는데 그러면은 count의 역할이 없어져서 이렇게...
			int tempNum = Integer.parseInt( st.nextToken() );
			/*
			// 1. 단순 IF문
			if( tempNum > max ){
				max = tempNum;
			}
			if( tempNum < min ){
				min = tempNum;
			}
			*/

			// 2. MATH 클래스의 max(),min() 이용
			max = Math.max( tempNum, max );
			min = Math.min( tempNum, min );
			count--;
		}
		
		
		bw.write( min+" "+max );
		
		br.close();
		bw.flush();
		bw.close();
	}
}
