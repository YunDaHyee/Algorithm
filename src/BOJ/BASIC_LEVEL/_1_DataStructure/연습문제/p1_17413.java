package BASIC_LEVEL._1_DataStructure.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


/**
@문제
	문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.
	
	먼저, 문자열 S는 아래와과 같은 규칙을 지킨다.
	
	알파벳 소문자('a'-'_2638'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
	문자열의 시작과 끝은 공백이 아니다.
	'<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다.
	또, 두 문자의 개수는 같다.
	태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다.
	단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다.
	태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.
	
@입력
	첫째 줄에 문자열 S가 주어진다. S의 길이는 100,000 이하이다.
	baekjoon online judge
	<open>tag<close>
	<int><max>2147483647<long long><max>9223372036854775807
	<   space   >space space space<    spa   c e>
	
@출력
	첫째 줄에 문자열 S의 단어를 뒤집어서 출력한다.
	noojkeab enilno egduj
	<open>gat<close>
	<int><max>7463847412<long long><max>7085774586302733229
	<   space   >ecaps ecaps ecaps<    spa   c e>
	
@HISTORY
	1. 중첩 while문
	2. flag 두기
	
	1. 중첩 while문
	while문을 여러개 둬서 진짜 어떻게 보면 좀 생각없이 짠 코드라고 볼 수 있음..
	잘돌아가게끔 했는데 출력을 아무리 해봐도 틀릴 게 없는데 계쏙 틀렸다고 나왔다.
	짱나서 푸는 법을 갈아엎자 싶어서 2번 방법으로 넘어갔음.
	
	2. flag 두기
	flag로 하니까 오히려 쉽게 풀리고 코드도 훨씬 깔끔해졌다.
	잘 해결했다고 생각하고 제출했는데 또 틀리다는 거다.. 그래서 진짜 테스트케이스 실행해봤는데
	아뿔싸,, 공백( )에 대한 처리를 안한 것이다.
	공백을 기준으로 한 단어의 기준이 되는것인데 내가 그걸 처리 안해줘서 1번에서도 계쏙 틀렸다고 나온 것임..
	공백에 대한 처리를 해주니까 1번도 맞다고 하더라.
	
	=> 의외로 1번이 시간복잡도가 꽤 클 줄 알았는데 오히려 2번보다 시간이 덜 걸린다..
	근데 눈으로 봤을 때, 2번 방법이 더 가독성이 좋아서 2번으로 하는 걸로..!
	
	++20200501
	중첩 반복문을 썼기 때문에 O(N^2)인 줄 알았는데 백준 강의를 듣다보니 이게 O(N)라는 것을 알게 됨..
	이해가 안돼서 알고리즘 방에다가 물어봄..
	"																			"
		n번당 print라는게 n^2만큼 일어나는건 아니잖아요
		무조건 반복문 중첩이라고 n^2라고 하지는않아요
		
		For문에서 n
		print에서 n
		더해서 2n
		표현하면 O(n) 인거같네요
		
		스택에 들어가면 한번씩만 사용되기 때문에
		push가 몇번 이뤄지는지 보시면 될 것 같아요
		
		문자열 길이가 n이라고 하면 print에서 출력량만큼 pop되니까
		print 함수들의 비용의 합이 amortized O(n)이 되겠죠
		s.push가 모두 합쳐서 O(n)번 밖에 안 일어나니까 print도 합쳐서 O(n)
		
	"																			"
		push가 일어나고 print 함수 호출할 때만 while문 더 도는거니까 N^2는 아닌가보다..
		시간복잡도가 최악의 경우일 때에 걸리는 시간 아닌가..?
		다 푸시 일어난다는 전제면 N^2인 것 같은데 아닌가 봄 ..ㅠ

	
*/
public class p1_17413 {
	public static void main(String args[]) throws IOException {
		BufferedReader br	= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw	= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int		idx			= 0;
		char[]	str			= br.readLine().toCharArray(); // 문자열
		Stack<Character> stack= new Stack<Character>();
		
		// 1. 중첩 while문
		while( str.length>idx ) {
			char each = str[idx]; // 0 idx++ 
			
			if( each == '<' ) {
				bw.write('<');
				while( true ) {
					char each2 = str[++idx]; // 중첩 while문 중 처음 while문에서 idx의 값의 증감이 없기 떄문에 여기서 선증가 해줘야함.
					bw.write(each2); // 뒤집기 없이 출력
					if( each2 == '>' ){ // >이면 태그를 닫는 것이므로 
						idx++; //2 // 후증가 처리 해주고 태그 빠져나감.
						break;
					}
				}
				bw.flush();
				
			}else{
				while( str.length>idx ) {
					char each2 = str[idx++];
					if( each2 == '<' ){
						idx--; // 중첩 while문 중 처음 while문에서 idx의 값의 증감이 없기 떄문에 여기서 처리해주고 넘어가야함.
						break;
					}else {
						if( each2 == ' ' ) { // 스페이스는 단어 간의 구분이므로 스페이스가 나오면 한 단어가 끝났다는 것임. 
							while( !stack.isEmpty() ) { // 문자열의 시작과 끝은 공백이 아니기땜에 스택에 무조건 담겨있을 거라는 전제 하에 일케 한 것임.
								bw.write( stack.pop() ); // 그래서 스택이 빌 떄까지 출력
								bw.flush();
							}
							bw.write(" ");
						}else {
							stack.push(each2); // 그냥 보통의 문자이므로 걍 스택에 쌓음.
						}
					}
				}
			}
			
			while( !stack.isEmpty() ) {
				bw.write( stack.pop() );
				bw.flush();
			}
		}
		
		// 2. flag 두기
		/*
		boolean			flag = false;
		
		while( str.length>idx ) {
			char each = str[idx++]; 
			
			if( each == '<' ) {
				flag = true;
				while( !stack.isEmpty() ) { // 어차피 큐는 비어있으면 여기 못들어감.
					bw.write( stack.pop() );
					bw.flush();
				}
			}
			
			if( flag ) { // < 여는 태그일 때,
				bw.write( each ); // 일단 출력
				if( each == '>' ) { // 닫는 태그면 - flag가 true인 상태에서 다음 인덱스로 넘어가기 땜에 each가 > 일 수 있음. 
					flag = false;
				}
				bw.flush();
			}else {
				if( each == ' ' ) { // 스페이스는 단어 간의 구분이므로 스페이스가 나오면 한 단어가 끝났다는 것임. 
					while( !stack.isEmpty() ) { // 문자열의 시작과 끝은 공백이 아니기땜에 스택에 무조건 담겨있을 거라는 전제 하에 일케 한 것임.
						bw.write( stack.pop() ); // 그래서 스택이 빌 떄까지 출력
						bw.flush();
					}
					bw.write(" ");
				}else {
					stack.push( each ); // 그냥 보통의 문자이므로 걍 스택에 쌓음.
				}
			}
		}
		
		while( !stack.isEmpty() ) { // 최종적으로 스택에 남아있는 것들까지 출력
			bw.write( stack.pop() );
			bw.flush();
		}
		*/
		
		br.close();
		bw.flush();
		bw.close();
	}
}
