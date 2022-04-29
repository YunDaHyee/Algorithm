package _3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
	@Question
		알파벳 소문자와 대문자로만 이루어진 길이가 N인 단어가 주어진다.
		한 줄에 10글자씩 끊어서 출력하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 단어가 주어진다.
		단어는 알파벳 소문자와 대문자로만 이루어져 있으며, 길이는 100을 넘지 않는다.
		길이가 0인 단어는 주어지지 않는다.
		1)BaekjoonOnlineJudge
		2)OneTwoThreeFourFiveSixSevenEightNineTen
	@Output
		입력으로 주어진 단어를 열 개씩 끊어서 한 줄에 하나씩 출력한다.
		단어의 길이가 10의 배수가 아닌 경우에는 마지막 줄에는 10개 미만의 글자만 출력할 수도 있다.	
		1)BaekjoonOn
		  lineJudge
		2)OneTwoThre
		  eFourFiveS
		  ixSevenEig
		  htNineTen
	@history
		19 - 19/10 => 몫: 1, 나머지: 9. 10글자 출력하고 그 다음 줄에 한글자
		첨에 배열에다가 추가하고 마지막에 for문으로 한꺼번에 출력하려고 했는데 그렇게 하니까 괜히 더 복잡해지는 듯 했음.
		(사실 이걸 카페에서 초안으로 짰었는데 넘 집중 안된 것도 있던 것 같다.. 집 와서 짜니까 잘 짜짐..난 아무래도 집 성향인 듯;)
		저렇게 다 짜고 제출했는데 틀렸다고 뜨는거야;
		그래서 size가 10 이상인거, 10인거 해봤는데 다 잘됐는데 왜지...하고 생각하는 순간
		10 미만인 거는 테스트를 안했다는 생각에 헐레벌떡 했는데 역시나 출력이 안되더라,,
		아뿔싸,,if( mok!=0 ){}else{} 부분의 else에서 10미만인 거를 처리해주지 않았따,,
		그래서 했더니 됨!ㅎㅎ
		반례 찾는 연습하기 ^^
		
		- 타 코드 Review 
		길이도 짧고 시간도 짧게 걸리는 사람 코드를 봤는데,,하 역시 난 한참 멀었단 생각을 했다,,(하지만 성장 가능성이 매우 높음)
		변수 자체도 없고 간단한,,,하 그렇게 짜야되는데 나는 너무 줄줄 늘여놓는다ㅠ
		단순하게 생각하는 연습하기...
		정처기 때를 떠올려보자,,생각해보면 그때는 그렇게 변수를 늘여놓지 않았따..ㅠ
		변수쟁이가 됨;; 
 *
 */
public class _11721_2 {
	public static void main(String args[]) throws IOException{
		BufferedReader	br		= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw		= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		StringBuilder	word	= new StringBuilder();
		word.append( br.readLine() );
		
		/* 내 코드
		int 			mok		= 0;
		int				nmg		= 0;
		int				startNum= 0;
		int				endNum	= 0;
		
		int				wordSize	= word.length();
		int				variableNum = wordSize;
		
		while( true ) {
			mok = variableNum / 10; //1
			nmg = variableNum - (10 * mok); //9 
			
			if( mok!=0 ){
				//endNum = 10;
				while( mok!=0 ){
					bw.write( word.substring(startNum,endNum+=10)+"\n" );
					startNum = endNum;
					mok--;
				}
				if( nmg>10 ){
					variableNum = nmg;
					continue;
				}else if( nmg<=10 ){
					bw.write( word.substring(endNum,wordSize) );
					break;
				}else if( nmg==0 ) {
					break;
				}
			}else{
				bw.write( word.substring(startNum,wordSize) );
				break;
			}
			
		}//while
		 */
		
		// 타 코드 적용
		for( int i=0;i<word.length();i++ ){
			bw.write( word.charAt(i) );
			if( (i+1)%10==0 ){
				bw.newLine();
			}
			bw.flush();
		}
		
	br.close();
	bw.close();
	
	}
}
