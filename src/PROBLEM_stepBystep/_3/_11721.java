package _3;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
	@Question
		알파벳 소문자와 대문자로만 이루어진 길이가 N인 단어가 주어진다. 한 줄에 10글자씩 끊어서 출력하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 단어가 주어진다. 단어는 알파벳 소문자와 대문자로만 이루어져 있으며, 길이는 100을 넘지 않는다. 길이가 0인 단어는 주어지지 않는다.
	@Output
		입력으로 주어진 단어를 열 개씩 끊어서 한 줄에 하나씩 출력한다. 단어의 길이가 10의 배수가 아닌 경우에는 마지막 줄에는 10개 미만의 글자만 출력할 수도 있다.
		BaekjoonOnlineJudge 입력 시 ,
			BaekjoonOn
			lineJudge
		OneTwoThreeFourFiveSixSevenEightNineTen 입력 시 ,
			OneTwoThre
			eFourFiveS
			ixSevenEig
			htNineTen
	@history
		맨 처음에는 아래의 조건을 정규식으로 짜려고 했었다. 
		
		입력으로 주어진 단어를 열 개씩 끊어서 한 줄에 하나씩 출력한다. 단어의 길이가 10의 배수가 아닌 경우에는 마지막 줄에는 10개 미만의 글자만 출력할 수도 있다.
		
		근데 내가 아직 정규식 서툴러서 그런지 시발 존나 못찾겠더라고.. 처음에 [a-zA-Z]{10} 이거 했는데도 존나 안걸려,,,
		그래서 어제 새벽처럼 정규식 조~~~~~~~~온나 찾아 헤매다가 안되겠어서 그냥 나눗셈에 기반한 정석대로 풀자는 생각으로 했는데
		이것도 회사에서 문제 푸는 거 눈치보면서 하느라 좀 머리가 안돌아갔나봐.
		그래서 회사에서 짠 거 다 지우고 집에서 노래도 끄고 천천히 생각하면서 했더니 됨! 
	@author dada
 */
public class _11721 {
	public static void main(String[] args) {
		Scanner sc		= new Scanner(System.in);
		Pattern pt		= Pattern.compile("[a-zA-Z]{1,100}");
		String 	ck		= "";
		int		ckSize	= 0;
		int		ckMok	= 0;
		int		ckNmg	= 0;
		int		startNum= -10;
		int		endNum 	= 0;

		try {
			
			while (true) {
				
				ck = sc.next();

				if (pt.matcher(ck).find() == true) {
					ckSize = ck.length(); //19
					if (ckSize > 10) {
						ckNmg = ckSize % 10; // 2 //9 
						ckMok = ckSize / 10;
					} else {
						ckNmg = ckSize;
						ckMok = 0;
					}

					while(true){
						if(ckMok >= 1){ //2 //1 //0
							startNum += 10; // 0 // 10 
							endNum += 10; // 10 // 20
							System.out.println( ck.substring(startNum, endNum) ); //0~10
							ckMok--;
						}else{
							if( ckNmg == ckSize ){
								System.out.println(ck);
							}else{
								System.out.println( ck.substring( endNum,ckSize ) );
							}
							break;
						}
					}
					break;
				} else {
					continue;
				} // regex
			} // while
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
	}
}
