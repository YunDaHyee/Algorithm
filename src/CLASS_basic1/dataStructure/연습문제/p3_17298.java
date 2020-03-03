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
		
		while( nge.size() != cnt ) {
			int curNum = Integer.parseInt( arr[i] );
			if( stk.isEmpty() ) {
				stk.push( i++ );
			}else {
				if( Integer.parseInt(arr[stk.peek()]) < curNum ) {
					stk.pop();
					nge.add( curNum );
					if( stk.isEmpty() ) {
						i++;
						if( i!=cnt ) {
							stk.push( i );
						}
					}
				}else {
					stk.push( i++ );
				}
				
				if( i==cnt ) {
					nge.add(-1);
					if( !stk.isEmpty() ) {
						nge.add(0, -1);
					}
				}
			}
		}
		
		for( int j=0;j<nge.size();j++ ) {
			bw.write( String.valueOf(nge.get(j))+" " );
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}






























