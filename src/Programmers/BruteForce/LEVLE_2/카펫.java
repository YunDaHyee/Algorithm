/**
 * 
 */
package BruteForce.LEVLE_2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 	@Question
		Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
		Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
		Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때
		카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
	
	@Restrictions
		갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
		노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
		카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다. => 가로>=세로
		
	@Input.Output
		brown	yellow	return
		10			2	[4, 3]
		8			1	[3, 3]
		24			24	[8, 6]
		
	@history
		최소의 수 : 브(B) - 8, 노(Y) - 1 => 3*3
		
		B - 8 10 12 14 16 19 20 22 24
		Y - 1  2  3  4  5  6  7  8  9
		
		가로 : B/3
		세로 : Y/3
				=> Y<=3 => 3
				=> 그 외 => Y/3 + 1 을 3의배수보다 작같을떄까지 반복문 돌리면서 합산. 단 가로보다 큰지 확인하고 크다면 그 값-3 = (그 값보다 한 칸 작은 값)

		잘못접근한 듯 ㅋ
		중간에만 노란색 있음 되고 테두리가 얼마나 될지는 모르는 거기때문에..
		다시 하기....ㅎㅎ..
		
		노란색 개수가 중요한 듯 하다.
		
		Y	= (x-2)(y-2)
			= xy-2x-2y+4
			
		B	= xy - (x-2)(y-2)
			= xy - (xy-2x-2y+4)
			= xy - xy+2x+2y-4
			= 2x+2y-4
		
		방정식은 도출 안하고
		뭔가 규칙으로만 찾으려고 해서 처음부터 잘못 접근했던 문제..
		식 세우기 연습하기!
		
	@Date
		2022. 4. 20.
 */

public class 카펫 {

	public static void main(String[] args) throws IOException {
		int brown=24, yellow=24;
		int[] result = new int[2];
		
		Map<Integer,Integer> divisors = new HashMap<Integer,Integer>();
		
		int xPLUSy = (brown+4)/2;
		int xMULTy = yellow+(2*xPLUSy)-4;
		
		
		for( int i=1;i<=xMULTy;i++ ) {
			if( xMULTy%i==0 ) {
				divisors.put(i,xMULTy/i);
			}
		}
		
		for( int i : divisors.keySet() ) {
			if( i+divisors.get(i) == xPLUSy ) {
				result[0] = Math.max(i,divisors.get(i));
				result[1] = Math.min(i,divisors.get(i));
				break;
			}
		}
		
		
		/*result[0] = (brown/3)+(brown%3);
		
		int tempLength = yellow/3;  // 세로
		
		if( tempLength<=3 ) {
			tempLength = 3;
		}else {
			int result1 = 1;
			tempLength++; // 1부터 시작하니까 1 더해줌
			for( int i=1;;i++ ) {
				if( 3*i>tempLength ){
					break;
				
				}
				result1=3*i;
			}
			if( result[0]<result1 ){
				result1-=3;
			}
			tempLength = result1;
		}
		result[1]=tempLength;
		
		*/
		System.out.println(result[0]);
		System.out.println(result[1]);
		
	}
	
}