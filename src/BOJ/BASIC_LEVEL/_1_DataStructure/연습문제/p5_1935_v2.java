package BASIC_LEVEL._1_DataStructure.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**

@문제
	후위 표기식과 각 피연산자에 대응하는 값들이 주어져 있을 때, 그 식을 계산하는 프로그램을 작성하시오.
	
@입력
	첫째 줄에 피연산자의 개수(1 ≤ N ≤ 26) 가 주어진다. 그리고 둘째 줄에는 후위 표기식이 주어진다.
	(여기서 피연산자는 A~Z의 영대문자이며, A부터 순서대로 N개의 영대문자만이 사용되며, 길이는 100을 넘지 않는다)
	그리고 셋째 줄부터 N+2번째 줄까지는 각 피연산자에 대응하는 값이 주어진다.
	3번째 줄에는 A에 해당하는 값, 4번째 줄에는 B에 해당하는값 , 5번째 줄에는 C ...이 주어진다,
	그리고 피연산자에 대응 하는 값은 100보다 작거나 같은 자연수이다.
	후위 표기식을 앞에서부터 계산했을 때, 식의 결과와 중간 결과가 -20억보다 크거나 같고, 20억보다 작거나 같은 입력만 주어진다.
	1.
		5
		ABC*+DE/-
		1
		2
		3
		4
		5
	
	2.
		1
		AA+A+
		1
5
4
7
@출력
	계산 결과를 소숫점 둘째 자리까지 출력한다.
	6.20
	3.00
	
@HISTORY
	로직은 맞는데 답이 틀림 ㅠㅠ뭐지??
	앞에서부터 계싼하는거면은 나누기나 뺼셈 같은 경우일떄는 앞에 나온 게 먼저라는 건데
	그럼 스택이 아니라 큐로 해야할 것 같은데 큐로하면은 전체 계산이 달라져..이게 맞는지 모르겠따ㅠ
	근데 식 흐름은 스택으로 진행해야하는데 후위표기식을 앞에서부터 계싼한다고 했으니까 모든 수는 뒤에 나온 게 먼저인가봄..
	아니면 수는 큐로, 연산자는 스택으로 해야하는 것 같기도 하다..
	일단 첫번째두번째 수롤 뺴서 순서 바꿔서 계싼하는 거(방법1)로 해보고 스택,큐를 따로 두는거(방법2)를 해봄
	해본 결과, 방법2는 필요가 없다.
	왜냐면 연산자 스택은 따로 두지 않아도 바로 연산하면 되고 흐름 자체는 스택으로 걍 가는 게 맞음..그래서 방법2는 버림
 */	
public class p5_1935_v2 {
	public static void main(String args[]) throws IOException {
		BufferedReader 	br	= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw	= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int			index			= 0;
		int			operandCount	= Integer.parseInt(br.readLine());
		String[]	rawExpress		= br.readLine().split("{0}");
		Double[]	value			= new Double[operandCount];
		Map<String, Double> keyMap	= new HashMap<String, Double>();
		Stack<Double> numberStack	= new Stack<Double>();
		
		// 숫자 입력 받기
		for( int i=0;i<operandCount;i++ ) {
			value[i] = (double) Integer.parseInt(br.readLine());
		}
		
		for( int i=0;i<rawExpress.length;i++ ) {
			String tempCase = rawExpress[i];
			Double tempCalcaulate = 0.0;
			Double firstNumber = 0.0;
			Double secondNumber = 0.0;
			if( Arrays.asList("+", "-", "/","%","*").contains(tempCase) ){
				firstNumber = numberStack.pop();
				secondNumber = numberStack.pop();
			}
			switch( tempCase ){
				case "+" :
					tempCalcaulate = secondNumber + firstNumber;
					break;
				case "-" :
					tempCalcaulate = secondNumber - firstNumber;
					break;
				case "/" :
					tempCalcaulate = secondNumber / firstNumber;
					break;
				case "%" :
					tempCalcaulate = secondNumber % firstNumber;
					break;
				case "*" :
					tempCalcaulate = secondNumber * firstNumber;
					break;
				default :
					if( !keyMap.containsKey(tempCase) ) {
						keyMap.put(tempCase,value[index]);
						if( index < value.length-1 ) {
							index++;
						}
					}
					tempCalcaulate = keyMap.get(tempCase);
					break;
			}
			numberStack.push( Math.round(tempCalcaulate*100)/100.0 );
		}
		
		bw.write(String.format("%.2f", numberStack.pop()));
		
		bw.flush();
		bw.close();
		br.close();
	}
}





















































