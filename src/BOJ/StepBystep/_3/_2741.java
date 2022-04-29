package StepBystep._3;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
	@Question
		자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 100,000보다 작거나 같은 자연수 N이 주어진다.
	@Output
		첫째 줄부터 N번째 줄 까지 차례대로 출력한다.
	@history
		처음과 틀렸을 때를 대비해서
		 
		System.out.println( "100,000보다 작거나 같은 자연수 N을 입력하세요." );
		
		를 출력했는데
		이게 정답에서 원하는 결과물이 아니라서 틀렸다고 나왔나봐...
		내가 풀었던 로직은 맞다!
		
		교훈 : 출력 결과에 없는 것은 출력하지 말자,,ㅠ;;
	@author dada
 */
public class _2741 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pattern ptn = Pattern.compile("(^[0-9]*$)");
		String chkNum = "";

		while (true) {
			chkNum = sc.next();

			if (ptn.matcher(chkNum).find() == true) {
				if (Integer.parseInt(chkNum) <= 100000) {
					for (int i = 1; i <= Integer.parseInt(chkNum); i++) {
						System.out.println(i);
					}
					break;
				}
			} else {
				continue;
			}
		}
		
		sc.close();
	}
}
