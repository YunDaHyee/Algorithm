package dataStructure.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
@문제
	오큰수
	
	크기가 N인 수열 A = A1, A2, ..., AN이 있다.
	수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다.
	Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다.
	그러한 수가 없는 경우에 오큰수는 -1이다.
	예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다.
	A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.
	
@입력
	첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.
	둘째에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.
	4
	3 5 2 7
	
	4
	9 5 4 8

@출력
	총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.
	5 7 7 -1
	-1 8 8 -1
	
@HISTORY
	오큰수의 정의조차 이해하지 못했음ㅠ 헷갈린다..
	정의를 하고 왔는데 내가 정리한 오큰수:
	수열의 현재수와 스택에 있는 수를 비교해서 스택에다가 인덱스를 넣는 것.
		현재수가 더 크면 pop하고 그 수의 인덱스만 넣고
					작으면 인덱스를 바로 넣고 통과함.
	책에서는 그랬는데 여기선 걍 값을 넣는 듯 함.
	
	아 근데 분석을 했는데 .. 9으로 시작하는 수열은 nge가 -1인거 보면 인덱스마다 한번씩 다 도는 것 같은데..
	0225
	오큰수의 정의를 제대로 알고 싶어서 찾아봤는데 "오큰수 = Ai보다 큰 수 중에 가장 가까운 수" 란다..다시 해봅니다..
	처음에 nge를 스택이 아니라 int형 배열로 했었는데 그래서 beforeIdx랑 beforeNum를 따로 뒀었는데 stack으로 하면서 바꿈..
	그게 사실 해당 수열에의 인덱스 그대로 nge 인덱스에 저장하게 하는거라 해서 첨에 int형 배열로 할라 했던거임.
	돌려보자.. 이 인덱스에 맞춰서 안해도 되는건지.
	근데 애초에 다른 예제로 하니까 ㅋㅋㅋㅋㅋㅋㅋ틀림 하
	4
	9 5 4 8
	이 경우일 때는 안돼. -1 8 8 -1 이게 안나온다.
	대가리 안돌아가서 못풀겠다 효율 개안남 5시간동안 이것만 보고 있었는 듯ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
	
	
	0303 remind 하고 다 지우고 다시 풀 예정.
	-정리
	오큰수 : Ai보다 큰 수 중에 가장 작은 수.
	
	
	
	- 생각 못했던 점 :
	1. 자릿수를 0으로 초기화 하지않은 것.
	2. pop한 자리의 인덱스를 뽑아서 그 자리에 curNum을 넣었어야 했는데 그러지 못한 것.
	3. 출력할 때에 -1로 나오게끔 했어야 했는데 그러지 못한 것. 
	
	1.
	처음에는 자릿수를 cnt만큼 채워넣는단 생각을 못하고
	List<Integer>	nge = new ArrayList<Integer>(cnt); 이런식으로 해버림..
	while문 떄려서 cnt 만큼 0으로 초기화 해줌
	
	2.
	걍 최종적으로 값만 채워넣으면 된단 생각으로 pop한 자리의 index를 이용안하고 걍 add()함수로 추가해버림.
	그러고 나서 set()함수로 pop한 인덱스의 위치에다가 0을 curNum값으로 바꿔 넣는것으로 바꿈
	
	3.
	-1을 실제 nge에다가 넣어야 된다는 생각으로
	i가 cnt수가 되면 처리하게끔 짠거였는데 이상하게 이클립스에서는 맞는데 백준에서는 틀리다고만 나왔음..
	
	아래와 같은 로직들을 추가했었었다
	if( i==cnt ) {
		while( !stk.isEmpty() ) {
			nge.set( stk.pop(), -1 );
		}
	}
	if( stk.isEmpty() ) {
		i++;
		if( i!=cnt ) {
			stk.push( i-1 );
		}
	}
	
	
	여러가지 수정을 거치다가 넣어야된다는 집착을 버리고 (ㅋㅋ)
	출력할 때에 -1이 출력되도록 바꿈
	
				이거 마무리하기~~
	
	
*/
public class p3_17298 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int				cnt = Integer.parseInt( br.readLine() );
		
		String[]		arr = br.readLine().split(" ");
		List<Integer>	nge = new ArrayList<Integer>();
		Stack<Integer>	stk = new Stack<Integer>();
		int				i	= 0;
		
		while( nge.size()<cnt ) {
			nge.add(0);
		}
		
		while( i < cnt ) {
			int curNum = Integer.parseInt( arr[i] );
			if( stk.isEmpty() ) {
				stk.push( i++ );
			}else {
				int topIdx = stk.peek();
				if( Integer.parseInt(arr[topIdx]) < curNum ) {
					stk.pop();
					nge.set( topIdx,curNum );
					/*
					if( stk.isEmpty() ) {
						i++;
						if( i!=cnt ) {
							stk.push( i-1 );
						}
					}
					*/
				}else {
					stk.push( i++ );
				}
				
				/*
				if( i==cnt ) {
					while( !stk.isEmpty() ) {
						nge.set( stk.pop(), -1 );
					}
				}
				*/
			}
		}
		
		for( int j=0;j<nge.size();j++ ) {
			int each = nge.get(j);
			if( each==0 ) {
				bw.write( String.valueOf(-1) );
			}else {
				bw.write( String.valueOf(nge.get(j)) ); 
			}
			bw.write(" ");
			bw.flush();
		}
/*
 * 배열에 할당된 크기를 넘어서 접근했을 때
전역 배열의 크기가 메모리 제한을 초과할 때
지역 배열의 크기가 스택 크기 제한을 넘어갈 때
0으로 나눌 떄
라이브러리에서 예외를 발생시켰을 때
재귀 호출이 너무 깊어질 때
이미 해제된 메모리를 또 참조할 때
 */
		br.close();
		bw.flush();
		bw.close();
	}
}






























