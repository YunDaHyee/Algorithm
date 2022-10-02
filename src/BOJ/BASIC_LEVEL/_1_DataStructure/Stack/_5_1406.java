package BASIC_LEVEL._1_DataStructure.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

/**
 * 
	@Question
		한 줄로 된 간단한 에디터를 구현하려고 한다.
		이 편집기는 영어 소문자만을 기록할 수 있는 편집기로, 최대 600,000글자까지 입력할 수 있다.
		이 편집기에는 '커서'라는 것이 있는데,
		커서는 문장의 맨 앞(첫 번째 문자의 왼쪽), 문장의 맨 뒤(마지막 문자의 오른쪽),
		또는 문장 중간 임의의 곳(모든 연속된 두 문자 사이)에 위치할 수 있다.
		즉 길이가 L인 문자열이 현재 편집기에 입력되어 있으면,
		커서가 위치할 수 있는 곳은 L+1가지 경우가 있다.
		이 편집기가 지원하는 명령어는 다음과 같다.
		
	    L   커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
	    D   커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
	    B   커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
	        삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
	    P $ $라는 문자를 커서 왼쪽에 추가함
	
	    초기에 편집기에 입력되어 있는 문자열이 주어지고, 그 이후 입력한 명령어가 차례로 주어졌을 때, 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 구하는 프로그램을 작성하시오.
	    단, 명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치하고 있다고 한다.
	    
	@Input
		첫째 줄에는 초기에 편집기에 입력되어 있는 문자열이 주어진다.
	    이 문자열은 길이가 N이고, 영어 소문자로만 이루어져 있으며, 길이는 100,000을 넘지 않는다.
	    둘째 줄에는 입력할 명령어의 개수를 나타내는 정수 M(1 ≤ M ≤ 500,000)이 주어진다.
	    셋째 줄부터 M개의 줄에 걸쳐 입력할 명령어가 순서대로 주어진다.
	    명령어는 위의 네 가지 중 하나의 형태로만 주어진다.
	    abcd
	    3
	    P x
	    L
	    P y
	    OR
	    abc
	    9
	    L
	    L
	    L
	    L
	    L
	    P x
	    L
	    B
	    P y
	    OR
	    dmih
	    11
	    B
	    B
	    P x
	    L
	    B
	    B
	    B
	    P y
	    D
	    D
	    P _2638
	@Output
		첫째 줄에 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 출력한다.
	    abcdyx
	    OR
	    yxabc
	    OR
	    yxz
	@History
		1. Stack으로 구현
		역순으로 한단 거 깜빡하고 있엇음..ㅠ
		나는 처음에 CURSOR를 써서 구현했는데
		생각해보니, CURSOR의 개념이 문자열로 할 때는 필요했지만
		Stack으로 구현할 때는 CURSOR의 역할을 Stack을 분기하는 거로 처리하므로 필요가 없던 거였다.
		그래서 Cursor를 지우니 좀 더 빨라지고 메모리도 확실히 줄어듬! 
		
		2. LinkedListf로 구현
		링크드리스트로 처음 구현한 결과, 시간초과가 났다..
		
		고민하다가 구글링 후 알게된 것 :
		연결리스트의 특징상, 정해진 위치에 삽입, 삭제, 추가는 모두 O(1)에 끝난다.
		하지만 임의의 원소를 찾는 다거나 확인하여 변경한다는 것은 O(n)이 걸린다.
		이 문제는 정해진 위치에 연산을 하는 것이며
		배열이나 vector의 경우 O(n)이 걸리기 때문에 시간초과가 나므로 연결리스트를 써야 한다.  
		
		LinkedList<Character>	leftList= new LinkedList<Character>(), rightList	= new LinkedList<Character>();
		이걸로 짰었는데 시간초과 나는 게 이거  때문인가 해서 구글링 하다가 커서로 하는 방법이 있길래 했는데 시간초과 계쏙 됨..
		
		그래서 또 고민하다가 구글링 후 알게된 것 :
		ListIterator<>
		Iterator를 사용합시다.
		Iterator는 Java Collection에 저장된 요소에 접근하는데 사용되는 표준화된 인터페이스입니다.
		이 문제에서는 ListIterator를 사용하는 것이 좋겠습니다.
		- Iterator는 단방향으로만 이동할 수 있고, 재사용이 안됩니다.
		- ListIterator는 양방향으로 이동이 가능하지만, List인터페이스를 구현한 Collection에서만 사용 가능합니다.
		출처: https://stack07142.tistory.com/37?category=215147 [Hello World]
		
		아무리..소스를 고쳐봐도..remove() 메소드를 쓰는 것 자체가 O(N)이 걸리므로 시간초과가 날 수 밖에 없다.
		그래서 생각한 게 LinkedList 자체도 두개로 나눠서 푸는 것.. 한번 해본다.
		했는데~~~~시간초과 된다 시양 어케 시간초과 안나고 푸는지 모르겠음 ㅡㅡ
		넘어갈거다 빡쳐서 일주일 넘게 이것만 푼 듯ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
 *
 */
public class _5_1406 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
	    BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );

	    // 1. Stack으로 구현 ===================================================================================
	    /*
	    Stack<Character>    leftStack   = new Stack<Character>(), rightStack    = new Stack<Character>();
	    String              str         = br.readLine();
	    
	    for( Character each : str.toCharArray() ) {
	        leftStack.push(each);
	    }

	    int             cnt     = Integer.parseInt( br.readLine() );
	    //int             cursor  = str.length();

	    while( cnt-->0 ) {
	        StringTokenizer command = new StringTokenizer( br.readLine() );
	        switch( command.nextToken() ) {
	            case "L" :
	                //if( cursor!=0 && !leftStack.isEmpty() ) {
                	if( !leftStack.isEmpty() ) {
	                    //cursor--;
	                    rightStack.push( leftStack.pop() );
	                }
	                break;
	            case "D" :
	                //if( cursor!=(leftStack.size()+rightStack.size()) && !rightStack.isEmpty() ){
                	if( !rightStack.isEmpty() ){
	                    //cursor++;
	                    leftStack.push( rightStack.pop() );
	                }
	                break;
	            case "B" :
	            	//if( cursor!=0 && !leftStack.isEmpty() ) {
	                if( !leftStack.isEmpty() ) {
	                    //cursor--;
	                    leftStack.pop();
	                }
	                break;
	            case "P" :
	                //cursor++;
	                Character addStr = command.nextToken().toCharArray()[0];
	                leftStack.push( addStr );
	                break;
	        }
	    }

	    // HOW TO	1. for 써서 그대로 출력 - 이게 쫌 더 빠르긴 함. for문이라 하더라도 간단한 반복문이라 그런 듯?
	    for( int i=0;i<leftStack.size();i++ ){
	    		bw.write( leftStack.get(i) );
	    }
	    
	    //			2. 뽑아서 오른쪽 스택에 쌓아서 오른쪽 출력 시에 출력
	    //
	    //while( !leftStack.isEmpty() ){
	    //	rightStack.push( leftStack.pop() );
	    //}
     	//
	    
	    while( !rightStack.isEmpty() ){
	        bw.write( rightStack.pop() );
	    }
	    
	    */
	    // 2. LinkedList로 구현 ===================================================================================
	    // (1) 하나의 LinkedList
	    /*
			LinkedList<Character>   list    = new LinkedList<Character>();
		    String             		str		= br.readLine();
		    
		    for( char each : str.toCharArray() ){
		        list.push(each);
		    }
	
		    ListIterator<Character>   itr   = list.listIterator(list.size()); 
		    int                       cnt   = Integer.parseInt( br.readLine() );
	
		    while( cnt-->0 ) {
		        StringTokenizer command = new StringTokenizer( br.readLine() );
		        switch( command.nextToken() ) {
		            case "L" :
		                if( itr.hasPrevious() ) {
		                    itr.previous();
		                }
		                break;
		            case "D" :
		                if( itr.hasNext() ){
		                    itr.next();
		                }
		                break;
		            case "B" :
		                if( itr.hasPrevious() ) {
		                    itr.previous();
		                    itr.remove();
		                }
		                break;
		            case "P" :
		                Character addStr = command.nextToken().charAt(0);
	                	itr.add(addStr);
		                break;
		            default :
	            		break;
		        }
		    }
	        
	        int cursor = itr.nextIndex();
		    
		    if( cursor==list.size() ) { // 2
		    	for( int i=0;i<list.size();i++ ) {
		    		bw.write( list.get(i) );
		    	}		    
		    }else {
		    	for( int i=0;i<=cursor;i++ ) {
			    	bw.write( list.get(i) );
			    }
			    for( int i=list.size()-1;i>=cursor+1;i-- ) {
			    	bw.write( list.get(i) );
			    }
		    }
	     
	     */
	    
	    // (2) 2개의 LinkedList 
	    LinkedList<Character>   list        = new LinkedList<Character>();
	    LinkedList<Character>   listRight   = new LinkedList<Character>();
	    String                  str         = br.readLine();

	    for( char each : str.toCharArray() ){
	        list.push(each);
	    }

	    int cnt     = Integer.parseInt( br.readLine() );

	    while( cnt-->0 ) {
	        StringTokenizer command = new StringTokenizer( br.readLine() );
	        switch( command.nextToken() ) {
	            case "L" :
	                if( !list.isEmpty() ) {
	                    listRight.push( list.pop() );
	                }
	                break;
	            case "D" :
	                if( !listRight.isEmpty() ){
	                    list.push( listRight.pop() );
	                }
	                break;
	            case "B" :
	                if( !list.isEmpty() ) {
	                    list.pop();
	                }
	                break;
	            case "P" :
	                Character addStr = command.nextToken().charAt(0);
	                list.push(addStr);
	                break;
	            default :
	                break;
	        }
	    }

	    //for( int i=list.size()-1;i>=0;i-- ) {
	    while( !list.isEmpty() ) {
	        //bw.write( list.get(i) );
	        bw.write( list.pop() );
	    }

	    while( !listRight.isEmpty() ) {
	        bw.write( listRight.pop() );
	    }

	    br.close();
	    bw.flush();
	    bw.close();


		
	}
}
