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
		
		5
		1
		2
		5
		3
		4
		
	@출력
		입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다.
		push연산은 +로, pop 연산은 -로 표현하도록 한다.
		불가능한 경우 NO를 출력한다.
		+
		+
		+
		+
		-
		-
		+
		+
		-
		+
		+
		-
		-
		-
		-
		-
		
		NO
	@HISTORY
		초반에 문제 이해를 못해서 조금 몇 시간을 헤맸다..ㅠㅠ;
		하지만 자꾸 짤수록 엉키길래 다 지우고 새로 짰더니 해결..!
		1년 전 : 전체적으로 flag로 돌아가게끔 해놓고
		또 그 안의 무한루프 속에서
		stack이 비어있는지의 여부와 바로 pop한 값과 inputNum를 가지고 비교하는 식으로 풀어놨다.
		효율은 비슷한데 오늘 짠 것이 가독성이 높고 이해하기도 쉽다!
	@Date
		2021/02/18
		
 */
public class _4_1874_v2 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw			= new BufferedWriter( new OutputStreamWriter(System.out) );
		Stack<Integer> 	numStack	= new Stack<Integer>();
		StringBuilder 	signSb		= new StringBuilder();
		
		int 			goalNum		= Integer.parseInt(br.readLine());
		int 			cnt			= goalNum;
		int				idx			= 1;
		
		while( cnt-->0 ){
			int inputNum = Integer.parseInt(br.readLine());
			
			if( idx<=goalNum ){
				while( idx<=inputNum ){
					numStack.push(idx++);
					signSb.append("+\n");
				}
			}
			
			if( numStack.peek()==inputNum ){
				numStack.pop();
				signSb.append("-\n");
			}
		}
		
		if( numStack.isEmpty() ) {
			bw.write( signSb.toString() );
		}else {
			bw.write("NO");
		}
		
		bw.flush();
		br.close();
		bw.close();
    }
}
