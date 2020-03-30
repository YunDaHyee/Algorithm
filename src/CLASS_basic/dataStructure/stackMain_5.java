/**
 * 
 */
package dataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

/**
	@문제
		한 줄로 된 간단한 에디터를 구현하려고 한다.
		이 편집기는 영어 소문자만을 기록할 수 있는 편집기로, 최대 600,000글자까지 입력할 수 있다.
		이 편집기에는 '커서'라는 것이 있는데, 커서는 문장의 맨 앞(첫 번째 문자의 왼쪽), 문장의 맨 뒤(마지막 문자의 오른쪽), 또는 문장 중간 임의의 곳(모든 연속된 두 문자 사이)에 위치할 수 있다.
		즉 길이가 L인 문자열이 현재 편집기에 입력되어 있으면, 커서가 위치할 수 있는 곳은 L+1가지 경우가 있다.
		이 편집기가 지원하는 명령어는 다음과 같다.
		
		L	커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
		D	커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
		B	커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
			삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
		P $	$라는 문자를 커서 왼쪽에 추가함
		
		초기에 편집기에 입력되어 있는 문자열이 주어지고, 그 이후 입력한 명령어가 차례로 주어졌을 때, 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 구하는 프로그램을 작성하시오.
		단, 명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치하고 있다고 한다.
		
	@입력
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
		OR
		abc : |cba -> x|cba -> |xcba -> y|xcba 
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
		OR
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
	@출력
		첫째 줄에 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 출력한다.
		abcdyx
		OR
		yxabc
		OR
		yxz
	@HISTORY
		Stack으로 푸는 것 말고 LinkedList로 푸는 것에 대한 고찰..>
		아무리..소스를 고쳐봐도..remove() 메소드를 쓰는 것 자체가 O(N)이 걸리므로 시간초과가 날 수 밖에 없다.
		그래서 생각한 게 LinkedList 자체도 두개로 나눠서 푸는 것.. 한번 해본다.
		했는데~~~~시간초과 된다 시양 어케 시간초과 안나고 푸는지 모르겠음 ㅡㅡ
		넘어갈거다 빡쳐서 일주일 넘게 이것만 푼 듯ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
		
		
 */
public class stackMain_5 {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
	    BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );

        // LinkedList로 구현
	    LinkedList<Character>   list    	= new LinkedList<Character>();
	    LinkedList<Character>   listRight	= new LinkedList<Character>();
	    String                  str			= br.readLine();
	    
	    for( char each : str.toCharArray() ){
	        list.push(each);
	    }
	    
	    int cnt     = Integer.parseInt( br.readLine() );

	    while( cnt-->0 ) {
	        StringTokenizer command = new StringTokenizer( br.readLine() );
	        switch( command.nextToken() ) {
	            case "L" :
	                if( !list.isEmpty() ) {
	                    listRight.push( list.pop() );
	                }
	                break;
	            case "D" :
	                if( !listRight.isEmpty() ){
	                	list.push( listRight.pop() );
	                }
	                break;
	            case "B" :
	            	if( !list.isEmpty() ) {
	                	list.pop();
	                }
	                break;
	            case "P" :
	                Character addStr = command.nextToken().charAt(0);
	                list.push(addStr);
	                break;
	            default :
            		break;
	        }
	    }
	    
    	//for( int i=list.size()-1;i>=0;i-- ) {
	    while( !list.isEmpty() ) {
    		//bw.write( list.get(i) );
    		bw.write( list.pop() );
    	}
    	
    	while( !listRight.isEmpty() ) {
    		bw.write( listRight.pop() );
    	}
	    
	    br.close();
	    bw.flush();
	    bw.close();
		
	}
}
