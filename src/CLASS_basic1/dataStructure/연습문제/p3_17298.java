package dataStructure.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
	0. 런타임 에러 발생 - 첨에 두번째 while문인 while( i < cnt )에서 nge.size() < cnt로 했었다. nge가 점점 차니까 cnt만큼 돌면 되는 것이라고 했는데 첨에 nge의 사이즈를 지정안하구 했어서 그런 듯..
	   이거 고치고 나니까 딱 런타임에러가 안났다.
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
	

	드디어 맞췄다...하ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ
	근데 생각보다 메모리가 매우매우 많이 나오는 것 같다.ㅠ
	시간복접도는 초기화 하느라 n이 나오고
	while문 안에서 아무래도 인덱스로 접근하는 것이다 보니까 n^2이 나오니까
	n^2라고 할 수 있겠다.
	
	- 타인 코드 보고 고친 점
		StringTokenizer
		int형 배열(not a List Class)
		나도 int형 배열로 해봐야겠다..
		-> 해본 결과 : String
	 				   StringTokenizer : 이걸 이용하면 해당 배열에 접근하는 걸 할 수가 없어서 기존에 내가 쓰던 String 문자열로 함.
	 				   int형 배열	   : 기존에 List Class를 통해 구현한 것을 int형 배열로 바꿔서 했다. 그랬더니 왠지 더 빠를 것 같은 예감이 든다~~~~
					   근데 메모리가 아직도 상당한 수준..ㅠ 아무래도 StirngTokenizer를 써야하나 싶다..
					   String 문자열로 하더라도 인덱스로 접근하는 방식이기 때문에 아무래도 시간복잡도가 N으로 나오는 것 같다. 끝에 있다면 n번 순회해야할테니까
					   
	
*/
public class p3_17298 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int				cnt = Integer.parseInt( br.readLine() );
		
		/*
		1. List 클래스 이용
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
				}else {
					stk.push( i++ );
				}
			}
		}
		
		for( int j=0;j<nge.size();j++ ) {
			int each = nge.get(j);
			bw.write( each==0 ? "-1 " : String.valueOf(nge.get(j)) + " " );
		}
		
		*/
		// 2. StringTokenizer + int형 배열 -> String 문자열 + int형 배열
		//StringTokenizer st	= new StringTokenizer( br.readLine() );
		String[]		arr = br.readLine().split(" ");
		int[]			nge = new int[cnt];
		Stack<Integer>	stk = new Stack<Integer>();
		int				i	= 0;
		//boolean			flag=true;
		int				curNum = 0;
		
		while( i < cnt ) {
			//if( flag==true ) {
				//curNum = Integer.parseInt( st.nextToken() );
				curNum = Integer.parseInt( arr[i] );
			//}
			
			if( stk.isEmpty() ) {
				//flag = true;
				stk.push( i++ );
			}else {
				int topIdx = stk.peek();
				if( Integer.parseInt(arr[topIdx]) < curNum ) {
					//flag = false;
					stk.pop();
					nge[topIdx] = curNum;
					//nge.set( topIdx,curNum );
				}else {
					//flag = true;
					stk.push( i++ );
				}
			}
		}
		
		/*
		for( int j=0;j<nge.size();j++ ) {
			int each = nge.get(j);
			bw.write( each==0 ? "-1 " : String.valueOf(nge.get(j)) + " " );
		}
		*/
		for( int j=0;j<nge.length;j++ ) {
			int each = nge[j];
			bw.write( each==0 ? "-1 " : String.valueOf(each) + " " );
		}
		
		
		br.close();
		bw.flush();
		bw.close();
	}
}






























