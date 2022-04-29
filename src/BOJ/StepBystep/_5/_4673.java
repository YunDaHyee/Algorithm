package _5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
	@Question
		셀프 넘버는 1949년 인도 수학자 D.R. Kaprekar가 이름 붙였다.
		양의 정수 n에 대해서 d(n)을 n과 n의 각 자리수를 더하는 함수라고 정의하자.
		예를 들어, d(75) = 75+7+5 = 87이다.
		양의 정수 n이 주어졌을 때, 이 수를 시작해서 n, d(n), d(d(n)), d(d(d(n))), ...과 같은 무한 수열을 만들 수 있다. 
		예를 들어, 33으로 시작한다면 다음 수는 33 + 3 + 3 = 39이고, 그 다음 수는 39 + 3 + 9 = 51, 다음 수는 51 + 5 + 1 = 57이다.
		이런식으로 다음과 같은 수열을 만들 수 있다.
		33, 39, 51, 57, 69, 84, 96, 111, 114, 120, 123, 129, 141, ...
		n을 d(n)의 생성자라고 한다. 위의 수열에서 33은 39의 생성자이고, 39는 51의 생성자, 51은 57의 생성자이다.
		생성자가 한 개보다 많은 경우도 있다. 예를 들어, 101은 생성자가 2개(91과 100) 있다. 
		생성자가 없는 숫자를 셀프 넘버라고 한다.
		100보다 작은 셀프 넘버는 총 13개가 있다. 1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97
		10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
	@Input
		입력은 없다.
	@Output
		10,000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 증가하는 순서로 출력한다.
	@history
		
		S T E P >
		0)	엄두도 못냄..;; 뭐 어떻게 접근해야할지 머리가 새하애지고 며칠 동안 알고리즘을 못풀었던 케이스,,
			어떻게 할지 대환한테 계속 어떻게 풀지 막 고민 했었음. 만나서 조언을 얻음
			
		1)	대환이 말했던 거 정확하게는 기억안나지만 대충 전체 수 집합에서 다 하나씩 제거하면서 남은 것들을 보여주는 걸 할 수 있냐고 물어보길래 그거에 딱 꺠달았음.
			a == 1 일 때,  b,c,d,e == 0
			a == 0 일 때,  0 <= b,c,d,e <= 9
			10^4*a + 10^3*b + 10^2*c + 10^1*d + 10^0*e = 10^4*a + 10^3*b + 10^2*c + 10^1*d + 10^0*e + a + b + c + d + e
			뭐 이런 것도 말해주긴 했는데 이건 딱히 도움은 못됨,,큼큼
			
		2,3,4) 는 아래 코드에 씀
		
		생각해보면 쉬웠던 건데 왜이렇게 어렵게 생각했을까...ㅠㅠ
		뭔가 생소한 개념이고 규칙 찾기에 급급해서 쉬운 게 눈에 안보였던 것 같다.
		단순하게 생각할 줄도 알기!! ! !
		
	@author dada
 */
public class _4673 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedWriter		bw		= new BufferedWriter( new OutputStreamWriter(System.out) );
		ArrayList<Integer>	selfNum	= new ArrayList<Integer>();
		
		try{
		    selfNum = fc(); //첨에 입력받는 줄 알고 안에 입력값(=br.readLine())을 집어넣음. 
		    for(int i=0;i<selfNum.size();i++){
				bw.write( String.valueOf(selfNum.get(i)) + "\n" );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			bw.flush();
			bw.close();
		}
	}
	
	public static ArrayList<Integer> fc() { // String n을 받았었음.
		ArrayList<Integer> totalNum	= new ArrayList<Integer>();
		
		for(int i=1;i<=10000;i++){
			totalNum.add(i);
		}
		
		for(int i=1;i<=10000;i++){
			String	tempNum		= String.valueOf(i); // String 변환 - 숫자를 하나씩 쪼개기 위함.
			int		tempNumleng = tempNum.length();	 // i의 크기
			int[]	argNum		= null;				 // 합을 위한 수
			int		sumNumIdx	= 0;				 // 더한 숫자가 totalNum 배열에서 위치하는 인덱스. 없다면 -1
			
			// 4) 3차 때의 소스가 너무 쓸 떄없이 중복되고 긴 것 같길래 바로 간단하게 할 수 있는 법 깨달음!
			argNum = new int[tempNumleng+1];
			argNum[0] = i; 
			for(int j=1;j<=tempNumleng;j++){
				argNum[j] = Integer.parseInt(String.valueOf(tempNum.charAt(j-1)));
			}
			///////////////////////////////////////////////////////////////////////////////////////////////
			
			/* 3) /////////////////////////////////////////////////////////////////////////////////////////
			if( tempNumleng == 1 ){ //1
				argNum		= new int[2];
				argNum[0]	= i; 
				argNum[1]	= i;
				//System.out.println(tempNum.charAt(0) + "+" + tempNum.charAt(0) + "=" + addFn(argNum) ); // 2) 원랜 addFn이란 함수를 안쓰고 그냥 CharAt한 값을 String으로 변환하고 또 그걸 parseInt 했는데 숫자로 안나오고 자꾸 문자로 나와서 함수로 뺌ㅡㅡ 
			}else if( tempNumleng == 2 ){ //10
				argNum		= new int[3];
				argNum[0]	= i;
				argNum[1]	= Integer.parseInt(String.valueOf(tempNum.charAt(0)));
				argNum[2]	= Integer.parseInt(String.valueOf(tempNum.charAt(1)));
				//System.out.println(tempNum + "+" + tempNum.charAt(0) + "+" + tempNum.charAt(1) + "=" + addFn(argNum) );
			}else if( tempNumleng == 3 ){ //100
				argNum		= new int[4];
				argNum[0]	= i;
				argNum[1]	= Integer.parseInt(String.valueOf(tempNum.charAt(0)));
				argNum[2]	= Integer.parseInt(String.valueOf(tempNum.charAt(1)));
				argNum[3]	= Integer.parseInt(String.valueOf(tempNum.charAt(2)));
				//System.out.println(tempNum.charAt(0) + " "+ tempNum.charAt(1)  + " "+ tempNum.charAt(2));
			}else if( tempNumleng == 4 ){ //1000
				argNum		= new int[5];
				argNum[0]	= i;
				argNum[1]	= Integer.parseInt(String.valueOf(tempNum.charAt(0)));
				argNum[2]	= Integer.parseInt(String.valueOf(tempNum.charAt(1)));
				argNum[3]	= Integer.parseInt(String.valueOf(tempNum.charAt(2)));
				argNum[4]	= Integer.parseInt(String.valueOf(tempNum.charAt(3)));
				//System.out.println(tempNum.charAt(0) + " "+ tempNum.charAt(1)  + " "+ tempNum.charAt(2)  + " "+ tempNum.charAt(3));
			}else if( tempNumleng == 5 ){ //10000
				argNum		= new int[6];
				argNum[0]	= i;
				argNum[1]	= Integer.parseInt(String.valueOf(tempNum.charAt(0)));
				argNum[2]	= Integer.parseInt(String.valueOf(tempNum.charAt(1)));
				argNum[3]	= Integer.parseInt(String.valueOf(tempNum.charAt(2)));
				argNum[4]	= Integer.parseInt(String.valueOf(tempNum.charAt(3)));
				argNum[5]	= Integer.parseInt(String.valueOf(tempNum.charAt(4)));
				//System.out.println(tempNum.charAt(0) + " "+ tempNum.charAt(1)  + " "+ tempNum.charAt(2)  + " "+ tempNum.charAt(3) + " " +tempNum.charAt(4));
			}
			*/
			
			sumNumIdx = totalNum.indexOf( addFn(argNum) );
			
			// 해당 수가 totalNum 배열에 없는 경우를 제외하고 나온 수를 totalNum 배열에서 삭제.
			if( sumNumIdx !=  -1 ){
				totalNum.remove(sumNumIdx);
			}
			
			//totalNum.remove( totalNum.indexOf(argNum) );	// 첨엔 아래처럼 단순하게 해당 인덱스에 있는 값을 지우자고 생각해서 없는 경우(-1)는 생각도 안하고 이렇게 해버림;;;
			//totalNum.remove( addFn(argNum) );				// 그리고 해당 값 지울라고 바로 리무버 함수에 지워야할 값을 넣겠다고 해서 넣은 듯.. 
															//	remove 함수는 인덱스로 접근하는건데 저렇게 합을 넣어버림ㅋㅋㅋ;
		}
		
		// 뭐 입력값을 받는다고 생각했는데 생각해보니 그냥 값을 돌리는 거였음.
		/*while( Integer.parseInt(n) <=10000 ){ }*/
		
		return totalNum; // 지울 거 다지운 배열이 바로 simpleNum 배열
	}
	
	public static int addFn(int[] num){
		int sum = 0;
		for(int i=0;i<num.length;i++){
			sum += num[i];
		}
		return sum;
	}
	
	
}