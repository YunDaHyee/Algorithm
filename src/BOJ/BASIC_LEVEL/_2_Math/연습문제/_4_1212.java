/**
 * 
 */
package BASIC_LEVEL._2_Math.연습문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/**
	@문제
		8진수가 주어졌을 때, 2진수로 변환하는 프로그램을 작성하시오.
	@입력
		첫째 줄에 8진수가 주어진다. 주어지는 수의 길이는 333,334을 넘지 않는다.
		314
	@출력
		첫째 줄에 주어진 수를 2진수로 변환하여 출력한다.
		수가 0인 경우를 제외하고는 반드시 1로 시작해야 한다.
		11001100
	@HISTORY
		8진수의 한자리씩을 2진수 3자리로 바꿔서 처리.
		
		일일이 다 나누면 시간초과가 발생한다고 함..
		그렇다면 내 코드도 엄청 오래 걸릴 것이라고 예상했지만
		자꾸 틀렸다고 나오는 게 싫어서 일단은 내가 구현한 코드가 답이 되도록 하는 것이 1차 목표였다.
		겨우겨우 답을 맞췄고 시간은 2320ms...ㅎㅎ다시 구현해본다.
		
		찾은 방법
		1. Scanner 클래스의 nextBigInteger(8) 메서드로 BigInteger를 받고 toString(2)로 받는 것 - 이건 숏코딩에도 불구하고 시간이 진짜 많이 걸린다..
		2. Integer 클래스의 toBinaryString(숫자)로 바로 받는 것
		3. 8진수의 값들을 미리 배열에 저장해두고 한자리씩 인덱스 별 값을 가져오는 것 - 이게 젤 빠름
		
		밑으로 갈 수록 복잡한 방법이다.
		처음에는 3번째 방법이 '자리수별로 배열을 만들어서 하는 걸 어떻게 안거지..?' 라는 생각때문에 잘 이해가 안갔다.  
		생각해보니까 8진수가 들어온다하면은 8보다 큰같 수(8,9,10)은 들어올 일이 없으니까 8진수 값들을 배열로 두고 인덱스로 접근해서 값을 가져오는 게 가능하겠다.
	@Date
		2021. 12. 01.
 */

public class _4_1212 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br		= new BufferedReader( new InputStreamReader(System.in) );
		
		String			raws	= br.readLine();
		StringBuilder	result	= new StringBuilder();
		
		//4. 1번 방법 - 진짜 오래 걸림
		System.out.println(new BigInteger(new Scanner(System.in).next(), 8).toString(2));
		
		//3. 2번 방법
		/*
		if(raws.equals("0")) {
            System.out.print(0);
            return;
        }
		
		for( int i=0;i<raws.length();i++ ){
			String binary = Integer.toBinaryString(raws.charAt(i)-'0');
			if( i!=0 ){
				if(binary.length()==2){
					binary = "0"+binary;
				}else if(binary.length()==1){
					binary = "00"+binary;
				}
			}
			result.append( binary );
		}
		
		System.out.print(result);
		*/
		
		//2. 3번 방법
		/*
		String[]		binarys = {"000","001","010","011","100","101","110","111"};
		
		if(raws.equals("0")) {
            System.out.print(0);
            return;
        }
		
		for( int i=0;i<raws.length();i++ ){
			String binary = binarys[raws.charAt(i)-'0']; // CharAt(int i) - '0'을 통해 char형의 문자들을 int형으로 변환시킬 수 있다.
			result.append( i==0? binary.replaceFirst("0*|00*", ""):binary );
		}
		
		System.out.print(result);
		*/
		
		//1. 일일이 나누는 방식
		/*
		Stack<String>	binary	= new Stack<String>();
		 if(raws.length() == 1 && raws.equals("0")) {
            System.out.println(0);
            return;
        }
		
		for( int i=raws.length()-1;i>=0;i-- ){
			String	temp		= "";
			String	rawsNumber	= ""; 
			int		number		= raws.charAt(i)-'0';
			while( number!=0 ){
				temp = number%2+temp;
				number/=2;
			}
			rawsNumber = temp.toString();
					
			if( rawsNumber.length()<3 ){
				switch(rawsNumber.length()%3){
					case 1:
						rawsNumber = "00"+rawsNumber;
						break;
					case 2:
						rawsNumber = "0"+rawsNumber;
						break;
				}
			}
			
			binary.push(rawsNumber==""?"000":rawsNumber);
		}
		
		System.out.print(binary.pop().replaceFirst("0*|00*", ""));
		while(!binary.isEmpty()){
			System.out.print(binary.pop());
		}
		*/
		
		br.close();
	}
}
