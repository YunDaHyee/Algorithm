package Basic_Level._1_DataStructure.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

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
	
	    초기에 편집기에 입력되어 있는 문자열이 주어지고, 그 이후 입력한 명령어가 차례로 주어졌을 때,
	    모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 구하는 프로그램을 작성하시오.
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
	    P z
	@Output
		첫째 줄에 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 출력한다.
	    abcdyx
	    
	    yxabc

	    yxz
	@History
		- Stack 구현
			이슈1)
			출력할 때 charAt(i)을 이용하는 거로 작성했었다.
			근데 생각해보니까 String을 이용했을 때의 시간복잡도 때문에 Stack을 사용한건데
			조회할 때 이걸 또 쓰려니까 좀 앞,뒤가 안맞는 것 같아서
			Stack을 이용해서 출력 했다.
			
			이슈2)
			right는 괜찮은데 left가 출력될 때 반대로 출력됐다.
			처음엔 StringBuilder로 합쳐서 출력할까도 했는데 이건 결국 다를 바가 없다..
			그래서 생각해보다가 안되겠어서 다른 사람들 코드를 봤는데
			right에다가 left를 넣는 것이 괜찮아 보여서 사용!
			
			이슈3)
			흠.. 그런데도 속도가 좀 느리길래
			while문 내의 switch문에서 split을 매번 하는 것 때문에 그런가 하고
			default로 빼서 처리하게끔 했다.
			와우 그랬더니 속도가 반으로 줄어들었다,,
			이런 작은 게 성능을 좌우한다니..ㅠ 앞으로 더 생각해볼 것!
		
		- LinkedList 구현
			이슈4)
			LinkedList로 구현을 했는데 시간초과가 났다..
			index용으로 cursor라는 변수를 두고 삭제,추가할 때에만 메소드를 이용하는 식으로 구현했다.
			인덱스 변경을 수동으로 하기 때문에 뭔가 더 빠를 거라 생각했는데 그게 아녔다.
			
			검색을 한 결과 : 
			삽입/삭제 시 이전 요소와 다음 요소의 정보를 가지고 있는 것이 유리한점으로 언급했었다.
			하지만 결국 ArrayList와 상대적으로 유리한 것이다.
			결국 삽입/삭제 시 그 인덱스에 바로 접근하는 것이 아니다.
			head와 tail을 제외하고는 하나하나 살펴보면서 찾아가 처리하기 때문에 완전히 효율적이라고는 볼 수 없다.
			그렇다면 여기서 무엇이 있었으면 좋겠는가?
			위치를 찾아가지 말고 문제의 커서처럼 해당하는 위치에 있으면서 삽입/삭제를 처리할 수 있기만 하면 된다.
			이때 활용할 수 있는 것이 ListIterator가 되겠다.
			https://mygumi.tistory.com/62
			
			구현 전에 ArrayList와 LinkedList의 차이점을 보고 시작했는데
			삽입삭제가 쉽다는 장점만을 보고 팠더니 LinkedList의 단점을 간과했던 것 같다.
			ListIterator를 이용했더니 해결
		
	@Date
		2021/02/19
 *
 */
public class _5_1406_v2 {
	public static void main(String args[]) throws IOException {
		BufferedReader		br		= new BufferedReader( new InputStreamReader(System.in) );
	    BufferedWriter		bw		= new BufferedWriter( new OutputStreamWriter(System.out) );
	    
	    String				orgStr	= br.readLine();
	    int				commandCnt	= Integer.parseInt(br.readLine());

	    // 1. Stack으로 구현
    /*
		Stack<Character>	left	= new Stack<Character>();
	    Stack<Character>	right	= new Stack<Character>();
	
	    for( char str : orgStr.toCharArray() ){
	    	left.push( str );
	    }
	    
	    while( commandCnt-->0 ) {
	    	String cmd = br.readLine();
	    	switch( cmd ){
	    		case "L" :
	    			if( !left.isEmpty() ){
	    				right.push( left.pop() );
	    			}
	    			break;
	    		case "D" :
	    			if( !right.isEmpty() ){
	    				left.push( right.pop() );
	    			}
	    			break;
	    		case "B" :
	    			if( !left.isEmpty() ){
	    				left.pop();
	    			}
	    			break;
	    		default :
	    			left.push( cmd.charAt(2) );
	    			break;
	    	}
	    }
	    
	    while( !left.isEmpty() ) {
	    	right.push( left.pop() );
	    }
	    
	    while( !right.isEmpty() ) {
	    	bw.write( right.pop() );
	    }
    */
	    // 2. LinkedList로 구현
	    LinkedList<Character>	list	= new LinkedList<Character>();
	    
	    for( char str : orgStr.toCharArray() ){
	    	list.add( str );
	    }
	    
	    /*
		// (1) 수동 위치 입력 - 시간 초과
	    int						cursor	= 0;
	    
	    cursor = list.size(); // 삽입이 될 위치. 이 위치의 오른쪽에 삽입이 됨.
	    while( commandCnt-->0 ) {
	    	String cmd = br.readLine();
	    	switch( cmd ){
	    		case "L" :
	    			if( cursor!=0 ){
	    				cursor--;
	    			}
	    			break;
	    		case "D" :
	    			if( cursor!=list.size() ){
	    				cursor++;
	    			}
	    			break;
	    		case "B" :
	    			if( cursor!=0 ){
	    				list.remove(--cursor);
	    			}
	    			break;
	    		default :
	    			list.add( cursor++, cmd.charAt(2) );
	    			break;
	    	}
	    }
	    */
	    
	    // (2) ListIterator 이용
	    ListIterator<Character> li = list.listIterator(orgStr.length());
	    
	    while( commandCnt-->0 ) {
	    	String cmd = br.readLine();
	    	switch( cmd ){
		    	case "L" :
		    		if( li.hasPrevious() ){
		    			li.previous();
		    		}
		    		break;
		    	case "D" :
		    		if( li.hasNext() ){
		    			li.next();
		    		}
		    		break;
		    	case "B" :
		    		if( li.hasPrevious() ){
		    			li.previous();
		    			li.remove();
		    		}
		    		break;
		    	default :
		    		li.add( cmd.charAt(2) );
		    		break;
	    	}
	    }
	    
	    for( char str : list ){
	    	bw.write( str );
	    }
	    
	    bw.flush();
	    br.close();
	    bw.close();
	}
}
