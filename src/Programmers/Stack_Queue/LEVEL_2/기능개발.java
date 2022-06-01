/**
 * 
 */
package Stack_Queue.LEVEL_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 	@Question
		프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다.
		각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
		또, 각 기능의 개발속도는 모두 다르기 때문에
		뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
		먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와
		각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
		각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
		
	@Restrictions
		작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
		작업 진도는 100 미만의 자연수입니다.
		작업 속도는 100 이하의 자연수입니다.
		배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다.
		예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
		
	@Input.Output
		progresses					speeds				return
		[93, 30, 55]				[1, 30, 5]			[2, 1]
		[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
		
		입출력 예 #1
		첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
		두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다.
		하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
		세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.
		따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.
		
		입출력 예 #2
		모든 기능이 하루에 1%씩 작업이 가능하므로, 작업이 끝나기까지 남은 일수는 각각 5일, 10일, 1일, 1일, 20일, 1일입니다.
		어떤 기능이 먼저 완성되었더라도 앞에 있는 모든 기능이 완성되지 않으면 배포가 불가능합니다.
		따라서 5일째에 1개의 기능, 10일째에 3개의 기능, 20일째에 2개의 기능이 배포됩니다.
		
	@history
		개발은 먼저 되도 배포는 앞에 거 되어야 가능
		=> queue로 푼다. 나갈 떄 같이 나가야함.
		배포 되어야하는 순서대로니까 맨 앞이 젤 먼저 되어야함.
		
		- 남 코드
		1. 스택/큐 안쓰고 시간도 느리긴 한데 아이디어가 좋은 방법
		while 문에서 하루 하루 증가하다가 100을 넘으면 '배포일' 입니다.
	 	'배포일'에 해당 작업을 배포하고 다음 작업으로 넘어갑니다(for 문).
	 	다음 작업이 100을 넘었으면 같은 '배포일'의 배포 횟수가 올라갑니다.
	 	100 미만이면 다음 '배포일'을 만날 때까지 반복합니다.
		int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
		
		2. 100퍼가 되는 완료일을 미리 계산해서 peek보다 크면 q 사이즈만큼 정답리스트에 넣고 큐 비워주는 방법.
		Queue<Integer> q = new Practice<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) { // 7<3이면 false. 7<9이면 true. 앞선 배포일보다 다음의 것이 더 클 때 비워준다.
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date);
        }

        answerList.add(q.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
		
	@Date
		2022. 5. 1.
 */

public class 기능개발 {
	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
						 //{95, 90, 99, 99, 80, 99};
						//{10, 10};
		int[] speeds = {1, 30, 5};
					//{1, 1, 1, 1, 1, 1};
					//{10, 90};
		
		List<Integer>	days				= new ArrayList<Integer>();
		
		/* 첨 시도 코드*/
		/*Deque<Integer>	deque				= new Practice<Integer>(); //프로세스큐
		Deque<Integer>	speedsDeque			= new Practice<Integer>(); // 시간큐
		int				progressesCount		= 0;
		
		for( int progress : progresses ) {
			deque.offer(progress);
		}
		for( int speed : speeds ) {
			speedsDeque.offer(speed);
		}
		
		// 시간초 표현하는 반복문
		while( !deque.isEmpty() ) {
			for( int i=0;i<deque.size();i++ ) {
				int currentProgress = deque.poll();
				int currentTime		= speedsDeque.poll();
				deque.offer( currentProgress+currentTime );
				speedsDeque.offer( currentTime );
			}
			
			while( true ) {
				if( deque.isEmpty()||deque.peek()<100 ) {
					break;
				}
				deque.poll();
				speedsDeque.poll();
				++progressesCount;
			}
			
			if( progressesCount!=0 ) {
				days.add( progressesCount );
				progressesCount = 0;
			}
		}
		*/
		
		
		/* 남 소스 보고 바꾼 거 */
		Queue<Integer> queue = new LinkedList<Integer>();
		
		//100퍼가 되는 완료일을 미리 계산해서 peek보다 크면 q 사이즈만큼 정답리스트에 넣고 큐 비워주는 방법.
		for( int i=0;i<speeds.length;i++ ) {
			int currentDeployDate = (int)Math.ceil((100-progresses[i])/(double)speeds[i]); // 완료일 계산하는 거.  // 7<3이면 false. 7<9이면 true. 앞선 배포일보다 다음의 것이 더 클 때 비워준다.
			if( !queue.isEmpty() && queue.peek()<currentDeployDate ){
				days.add( queue.size() );
				queue.clear();
			}
			queue.offer( currentDeployDate );
		}
		
		days.add( queue.size() );
		
		Integer[] result = days.toArray( new Integer[]{days.size()} ); // 리스트 -> 배열
		System.out.println( Arrays.toString(result) );
		
		
	}

}
