package Basic_Level._1_DataStructure.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * 
	@Question
		스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다.
		스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
		1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
		이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
		임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.
		이를 계산하는 프로그램을 작성하라.
	@Input
		첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다.
		둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다.
		물론 같은 정수가 두 번 나오는 일은 없다.
		8
		4
		3
		6
		8
		7
		5
		2
		1
		OR
		5
		1
		2
		5
		3
		4
		
		+ 1
	1	-
		+ 2
	2	-
		+ 3
		+ 4
		+ 5
	5	-
		
	@출력
		입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다.
		push연산은 +로, pop 연산은 -로 표현하도록 한다.
		불가능한 경우 NO를 출력한다.
		+ 1
		+ 2
		+ 3
		+ 4
4		-
3		-
		+ 5
		+ 6
6		-
		+ 7
		+ 8
8		-
7		-
5		-
2		-
1		-
		OR
		NO
	@HISTORY
		1차 )	stack의 contains를 사용해서 inputNum을 넣는 것을 구현했고 다 풀고나서 시간복잡도가 너무 큰 것 같길래 생각해보니 contains은 사실 이게 쓸 때야 함수로 딱 나와있지만 아마 내부적으로는 반복문을 돌 것 같다..
				그래서 소스상이나 시간복잡도나 전반적으로 개선이 필요한 것 같아서 2차로 함.. 며칠이나 생각한 듯 이거도ㅠ 어쩌면 게을러서;
		2차 )	사실 이게 입력받은 횟수만큼 다 치고 나서 출력을 해야하는 거라서 +- 히스토리를 담아두고 마지막에 출력하는 거여야 하는데 도중에 no가 한번 되면 그 이후로부터는 증감이 되면 안돼.
				그래서 그거에 대한 수정으로 3차를 함
		3차	)	noFlag 붙인 값. 이걸 함으로써 NO 이후에는 쓸 떄 없이 반복문이 돌지않아도 됨..
		
 */
public class _4_1874 {
public static void main(String args[]) throws IOException {
		
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw			= new BufferedWriter( new OutputStreamWriter(System.out) );

		int             autoNum     = 1;
		StringBuilder   sb          = new StringBuilder();
		Stack<Integer>  stack       = new Stack<Integer>();
		int             stackSize   = Integer.parseInt( br.readLine() );
		boolean			noFlag		= false;
		
		while( stackSize-->0 ) {
			int	inputNum	= Integer.parseInt( br.readLine() );
			if( !noFlag ) {
		        while( inputNum>=autoNum ) {
		            stack.push(autoNum++);
		            sb.append("+\n");
		        }
	
			    while( true ){
			    	if( !stack.isEmpty() && stack.pop()==inputNum){
			    		sb.append("-\n");
				        break;
				    	
			    	}else{
			    		noFlag = true;
			    		sb.setLength(0);
				        sb.append("NO\n");
			    		break;
			    	}
			    }
		    }
		}// while

		bw.write( sb.toString() );
		bw.flush();
		
		br.close();
		bw.close();
	
    }
}
