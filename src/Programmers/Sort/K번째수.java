/**
 * 
 */
package Sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 	@Question
		배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
		
		예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
		
		array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
		1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
		2에서 나온 배열의 3번째 숫자는 5입니다.
		배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
		commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를
		배열에 담아 return 하도록 solution 함수를 작성해주세요.
			
	@Restrictions
		array의 길이는 1 이상 100 이하입니다.
		array의 각 원소는 1 이상 100 이하입니다.
		commands의 길이는 1 이상 50 이하입니다.
		commands의 각 원소는 길이가 3입니다.

	@Input.Output
		array					commands							return
		[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
		
		[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
		[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
		[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.
		
	@history
		N = commands 배열의 요소들로 조작해서 array의 i~j번쨰 사이의 값을 추출한 배열에서 k번째 숫자 구하기
		0부터 시작하니까 k+1한 값 찾기
		
		1.
		나는 직접 구현했는데
		남 거 보니까 Arrays.copyOfRange() 라는 함수가 있었다.
		public static int [] copyOfRange (int [] 복사할 원본 배열, int 원본 배열에서 복사할 범위의 시작 인덱스, int 원본 배열에서 복사할 범위의 끝 인덱스)
		
		2.
		라이브러리를 아예 안쓰면 프로그래머스에서 점수를 더 높이 주나보다.
		라이브러리 안쓰고 퀵정렬 구현한 코드
		
	@Date
		2022. 5. 3.
 */

public class K번째수 {
	public static void main(String args[]) throws IOException {

		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = { {2, 5, 3}, {4, 4, 1}, {1, 7, 3} };
		
		List<Integer> Ks = new ArrayList<Integer>();
		
		/* 내 첫 코드 */
		/*List<Integer> newArray = new ArrayList<Integer>();
		
		for( int i=0;i<commands.length;i++ ) {
			for( int j=commands[i][0]-1;j<=commands[i][1]-1;j++ ) {
				newArray.add(array[j]);
			}
			
			// 미리 정렬해놓으면 그 이후부턴느 순서가 유지라고 생각했는데 문제에 자른 후 정렬임.
			newArray.sort(null);
			
			// for문 돌면서 k 인덱스 값 찾을까 했는데 어차피 값 다 들어간 후가 완성된 배열이라서 여기서 또 따로 해줘야함..
			for( int j=0;j<newArray.size();j++ ) {
				if( j==commands[i][2]-1 ) {
					Ks.add( newArray.get(j) );
					newArray.clear();
					break;
				}
			}
		}*/
		
		
		/* 남 코드 보고 참고 */
		for( int i=0;i<commands.length;i++ ){
			int[] newArray2 = Arrays.copyOfRange( array,commands[i][0]-1,commands[i][1] );
			Arrays.sort(newArray2);
			Ks.add( newArray2[ commands[i][2]-1 ] );
		}

		/* 남 코드 2 */
		int n = 0;
        int[] ret = new int[commands.length];

        while(n < commands.length){
            int m = commands[n][1] - commands[n][0] + 1;

            if(m == 1){
                ret[n] = array[commands[n++][0]-1];
                continue;
            }

            int[] a = new int[m];
            int j = 0;
            for(int i = commands[n][0]-1; i < commands[n][1]; i++)
                a[j++] = array[i];

            sort(a, 0, m-1);

            ret[n] = a[commands[n++][2]-1];
        }

		
		Integer[] answer = Ks.toArray(new Integer[Ks.size()]);
		System.out.println(answer.toString());
	}
	
	/* 남 코드 2 */
	public static void sort(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(pl + pr) / 2];

		do {
			while (a[pl] < x)
				pl++;
			while (a[pr] > x)
				pr--;
			if (pl <= pr) {
				int temp = a[pl];
				a[pl] = a[pr];
				a[pr] = temp;
				pl++;
				pr--;
			}
		} while (pl <= pr);

		if (left < pr)
			sort(a, left, pr);
		if (right > pl)
			sort(a, pl, right);
	}
}
