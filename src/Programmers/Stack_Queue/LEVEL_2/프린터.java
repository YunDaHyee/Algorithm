/**
 * 
 */
package Stack_Queue.LEVEL_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 	@Question
		일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다.
		그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다.
		이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다.
		이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.
		
		1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
		2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
		3. 그렇지 않으면 J를 인쇄합니다.
		예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
		
		내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.
		
		현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와
		내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때,
		내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
		
	@Restrictions
		현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
		인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
		location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
		
	@Input.Output
		priorities			location	return
		[2, 1, 3, 2]		2			1
		[1, 1, 9, 1, 1, 1]	0			5
		입출력 예 설명
		예제 #1
		문제에 나온 예와 같습니다.
		
		예제 #2
		6개의 문서(A, B, C, D, E, F)가 인쇄 대기목록에 있고 중요도가 1 1 9 1 1 1 이므로 C D E F A B 순으로 인쇄합니다.

	@history
		우선순위 높은 게 먼저 나가야함.
		큐 형태인 줄 알았는데 디큐로 풀어야 하는 듯..
		뒤로 가는 게 아니고 그냥 앞으로 다시 들어감..
		
		우선순위가 있어서 그 값의 인덱스는 고정되지 않고
		우선순위값이라서 값으로 비교하는 건 안됨 (같은 값 있기 떄문)
		퀵정렬로 location을 위치로 잡아서 얼마나 증가하는지 찾아야 할 듯..ㅜㅜ
		정렬 좀 두렵지만..계쏙 두려울 순 없으니까.. 
		ㄴㄴ정렬이 아님
		
		Pair 클래스를 만들어서 인덱스를 같이 주는 방법도 있군..
		알고 있었떤 방법인데 알고리즘 안푼 지 너무 오래 됐어서 까먹었었다..다시 상기 시키기 이참에..
		근데 내가 푼 방식이랑 흐름은 똑같은데
		location 움직여서 그런건가.
		블로그랑 똑같이 풀어도 시간초과가 나면서 안되길래 왠가 했더니..
		첨에 peek으로 하고 나중에 뽑을 때 poll 하느거로 했더니만 되네..
		아니다 이건 상관없는거였따..
		큰 값은 poll을 해줘야하는데 계쏙 offer을 하니까 시간초과가 나는 것이었음..
	@Date
		2022. 5. 9.
 */

class Pair{
	int index;
	int value;
	
	public Pair(int index, int value) {
		this.index = index;
		this.value = value;
	}
}

public class 프린터 {
	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
						 //{1, 1, 9, 1, 1, 1}; // 값으로 비교하면 안됨.. 그럼 같은 숫자가 나오게 되니까
		int location = 2;
					//0;
		
		int			result	= 0; 
		Pair		target	= null;
		Queue<Pair> queue	= new LinkedList<Pair>();
		for( int i=0;i<priorities.length;i++ ){
			queue.offer( new Pair(i,priorities[i]) );
			if( i==location ) {
				target = new Pair(i,priorities[i]);
			}
		}
		
		while( !queue.isEmpty() ) {
			boolean isExistMaxValue = false;
			Pair	currentPriority = queue.poll();
			
			// 한번 더 돌면서 하나라도 현재 값보다 큰 우선순위가 있는지 찾고 없으면 끝까지 돈다.
			for( Pair comparePriority : queue ){
				if( currentPriority.value < comparePriority.value ){
					isExistMaxValue = true;
					break;
				}
			}
			
			if( !isExistMaxValue ) {
				result++;
				if( currentPriority.index==location ) {
					break;
				}
				if( currentPriority.value!=target.value ) {
					continue;
				}
			}
			
			queue.offer( currentPriority );
		}
		
		/*
		int result = 1; //첨에 빠지는 경우 있으니까
		queue<Integer> queue = new Arrayqueue<Integer>();
		
		for( int i=0;i<priorities.length;i++ ){
			queue.offer(priorities[i]);
		}
		queue.offerFirst( queue.pollLast() );// 2
		int popPointer		= queue.size()-1;
		int locationPointer = location+1; // 하나 빼고 추가해주는 작업 해줬으니까
		int firstPriority	= queue.peekFirst();
		
		while( !queue.isEmpty() ) {
			int lastPriority = queue.peekLast();// 오른쪽끝임.  1      
			
			popPointer = queue.size()-1; // 나갈 값은 오른쪽 끝 값 .. 보통은 그러함 // 오른쪽 끝 값>왼쪽끝값이거나 값이 같으면 걍 끝에 있는 거 먼저 나가는 게 맞음..
			
			if( lastPriority<firstPriority ) { 
				popPointer = 0; //  오른쪽 끝 값<왼쪽끝값일경우에만 나갈 값은 왼쪽 끝 값
			}
			
			// 현재 나간 값이 location의 값인지를 어떻게 구분하지.. 현재포인터랑 로케이션포인터가 겹쳐지는 부분을 만들어야하는데
			// 나가는 걸 여기서 위에서 제어하지말고 밑에서 제어해야함. 포인터로 구분하기
			if( popPointer==locationPointer ) {
				break;
			}
			
			if( lastPriority>firstPriority ){ 
				queue.pollLast();
			}else if( lastPriority<firstPriority ){
				queue.pollFirst();
				locationPointer--;
			}else {
				queue.offerFirst( queue.pollLast() );
				locationPointer++;
			}
			
			result++;
			firstPriority = queue.peekFirst();
		}
		*/
		
		System.out.println(result);
	}

	
	
}
