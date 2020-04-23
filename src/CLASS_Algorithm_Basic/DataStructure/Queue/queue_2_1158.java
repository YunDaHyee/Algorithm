package DataStructure.Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
	1 2 3 4 5 6 7 -> 1 2 4 5 6 7 -> 1 2 4 5 7 -> 1 4 5 7 -> 1 4 5 -> 1 4 -> 4  
		2					4				1			3		2		1		1
		6/3 =2
		
	@Question
		요세푸스 문제는 다음과 같다.
		1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
		이제 순서대로 K번째 사람을 제거한다.
		한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
		이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
		원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
		예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
		N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)
		7 3
	@Output
		예제와 같이 요세푸스 순열을 출력한다.
		<3, 6, 2, 7, 5, 1, 4>
	@History
		나는 문제풀이에서 본 것처럼 고대로 풀었다.
		K번째 수가 아니면 삭제했다가 다시 삽입하는 과정을 넣었는데 이것때문에 오래 걸리는 듯함.
		- 남들 코드 보고 배운 점 : 추가/삭제하는 작업 없이 바로 인덱스+cnt%사이즈 해서 나오는 수에 해당되는 인덱스의 수를 출력하는 것.
		아직 나는 알고리즘의 ㅇ자도 모르는 듯 하다..^^
		직관적으로 인덱스를 지정해서 푸는 건 1차적인거고 2차적으로 생각할 땐 계산해서 그 값이 나오게 하는 방법을 생각해내기

		아.. 근데 queue로 구현하고 싶은데 list를 써서 index로 바로 접근하는 게 요지에 맞는지 모르곘다..
		ㅠ 바로 출력도 안됨..
		이 부분이 가능하려면 Queue<Integer>로 받는 것이 아니라 List로 받아야 가능임..
		백준이 배포해준 소스 보니까 내가 정석대로 잘푼 거 맞음..
		나는 단지 반복적인 추가/삭제에 따른 비효율성을 제거하고싶어서 생각했던건데
		다른 방법을 찾아보니까 다들 List로 받아서 작업한다ㅡㅡ;; List로 하면 다르다해서 안한건데;;
		
		출처: https://mygumi.tistory.com/57 [마이구미의 HelloWorld]
		문제에서는 M번째를 죽인다. 규칙이 존재한다.
		문제를 풀 때 어떠한 패턴이 존재한다면 나머지(%) 연산으로도  한 번 해볼 수 있다는 생각을 하길 바란다.
		출처: https://mygumi.tistory.com/57 [마이구미의 HelloWorld]
		
		라고함.. 나머지 연산을 이용해서 풀어보는 것 기억해두기!!
		
 *
 */
public class queue_2_1158 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(	new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		StringTokenizer st = new StringTokenizer( br.readLine() );
		int people	= Integer.parseInt( st.nextToken() ); // 사람 수
		int cnt		= Integer.parseInt( st.nextToken() ); // 번째 수
	    int idx1    = 1; // 1번 풀이에 필요한 변수
	    int idx2    = 0; 
		    
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for( int i=1;i<=people;i++ ) {
			queue.add(i);
		}
		
		bw.write("<");
		
		while( !queue.isEmpty() ){
			// 1. 추가/삭제 하는 작업
			/*
			if( idx1==cnt ) {
				idx1 = 1;
				bw.write( String.valueOf(queue.poll()) );
				if( queue.size()!=0 ) {
					bw.write(", ");
				}
				bw.flush();
			}else {
				idx1++;
				queue.add( queue.poll() );
			}
			*/
			// 2. 추가/삭제 없이 출력해야할 숫자를 계산해서 출력
			/*
	`			-1+3%7 = 2, 1+3%6 = 4,  3+3%5 = 1, 0+3%5 = 3 , 2/4 = 2, 1/3 = 1 , 1/2 = 1, 1/1 = 0
		    	아래와 같이 하면 조세퍼스 원리에 따라 출력해야할 인덱스가 나옴..
		    	하지만 이 방식이 되려면 ArrayList<Integer>로 받아야 가능임ㅠ
		        idx2 = (idx2 + cnt)%queue.size();
			 */
	    	//만약 사이즈가 일정하다면?(poll을 안한다면)
	    	idx2--;
	    	idx2 = (idx2 + cnt)%cnt; // 0+3%3 = 0(+1), 1+3%3 = 1(+2), 3+3%3 = 0(+1) , 4%3 = 1(+1)
			bw.write( queue.toArray()[idx2].toString() );
			if( queue.size()!=0 ) {
				bw.write(", ");
			}
			bw.flush();
		}
		
		bw.write(">");
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}
