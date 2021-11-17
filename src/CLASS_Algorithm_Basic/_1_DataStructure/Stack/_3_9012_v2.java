package _1_DataStructure.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 
	@Question
		괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
		그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
		한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다.
		만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다.
		그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다.
		예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다. 
		여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다. 
	@Input
		입력 데이터는 표준 입력을 사용한다.
		입력은 T개의 테스트 데이터로 주어진다.
		입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다.
		각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다.
		하나의 괄호 문자열의 길이는 2 이상 50 이하이다.
		6
		(())()) - ( :3 , ):4 
		(((()())()
		(()())((()))
		((()()(()))(((())))()
		()()()()(()()())()
		(()((())()(
	@Output
		출력은 표준 출력을 사용한다.
		만일 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 한 줄에 하나씩 차례대로 출력해야 한다.
		NO
		NO
		YES
		NO
		YES
		NO
	@History
		1년 전에는 여는 괄호의 개수로 판단하는 식으로 짰따.
		근데 이번에 구현할 때는 Stack만 이용하는 거로 했는데 예전보다는 나름 생각하면서 빨리 짠 것 같다.
 *
 */
public class _3_9012_v2 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader	br		= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw		= new BufferedWriter( new OutputStreamWriter(System.out) );
	    int             testCase= Integer.parseInt( br.readLine() );
	    
	    // 1. Stack 2개 이용 - 여/닫 각각에 대한 스택 
	    /*
	    while( testCase-->0 ){
	    	String				rawData = br.readLine();
	    	Stack<Character>	openVPS	= new Stack<Character>();
	    	Stack<Character>	closeVPS= new Stack<Character>();
	    	for( char c : rawData.toCharArray() ) {
	    		if( c == '(' ) {
	    			openVPS.push(c);
    			}else {
    				closeVPS.push(c);
    				if( !openVPS.isEmpty() ){
    					openVPS.pop();
    					closeVPS.pop();
    				}
    			}
	    	}
	    	
	    	if( openVPS.isEmpty() && closeVPS.isEmpty() ){
	    		bw.write("YES\n");
	    	}else {
	    		bw.write("NO\n");
	    	}
	    }
	    */
	    
	    // 1. Stack 1개 사용 (1) - 꺼내서 (인지 살펴보기
	    /*
	    while( testCase-->0 ){
	    	String				rawData = br.readLine();
	    	Stack<Character>	openVPS	= new Stack<Character>();
	    	for( char c : rawData.toCharArray() ) {
	    		if( c == '(' ) {
	    			openVPS.push(c);
	    		}else{
	    			if( !openVPS.isEmpty() ) {
	    				if( openVPS.peek()=='(' ){ 
	    					openVPS.pop();
	    				}else {
	    					openVPS.push(c);
	    				}
	    			}else {
	    				openVPS.push(c); // VPS 여부 체크에서 비어있지 않음에 걸리도록
	    				break;
	    			}
    			}
	    	}
	    	
	    	if( openVPS.isEmpty() ){
	    		bw.write("YES\n");
	    	}else {
	    		bw.write("NO\n");
	    	}
    	}
		 */	
	    
	    // 3. Stack 1개 사용 (2) - 괄호 짝이 안맞는 (만 남음 - 교안의 해설대로
	    // )를 넣지 않으면 스택에는 어차피 (만 남기 떄문에 peek()하는 건 의미 없어서 지웠더니 훨 깔끔해졌다. 
	    while( testCase-->0 ){
	    	String				rawData = br.readLine();
	    	Stack<Character>	openVPS	= new Stack<Character>();
	    	boolean				breakFlag	= false;
	    	
	    	for( char c : rawData.toCharArray() ){
	    		if( c == '(' ) {
	    			openVPS.push(c);
	    		}else{
	    			if( !openVPS.isEmpty() ){
						openVPS.pop();
	    			}else {
	    				breakFlag = true;
	    				break;
	    			}
		    	}
	    	}
	    	
	    	if( openVPS.isEmpty() && !breakFlag ){
	    		bw.write("YES\n");
	    	}else {
	    		bw.write("NO\n");
	    	}
	    }
	    
	    br.close();
	    bw.flush();
	    bw.close();
		
	}
}
