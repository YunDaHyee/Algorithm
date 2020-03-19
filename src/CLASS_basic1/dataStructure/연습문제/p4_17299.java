package dataStructure.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**

@문제
	오등큰수
	
	크기가 N인 수열 A = A1, A2, ..., AN이 있다.
	수열의 각 원소 Ai에 대해서 오등큰수 NGF(i)를 구하려고 한다.
	Ai가 수열 A에서 등장한 횟수를 F(Ai)라고 했을 때, Ai의 오등큰수는 오른쪽에 있으면서 수열 A에서 등장한 횟수가 F(Ai)보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다.
	그러한 수가 없는 경우에 오등큰수는 -1이다.
	예를 들어, A = [1, 1, 2, 3, 4, 2, 1]인 경우 F(1) = 3, F(2) = 2, F(3) = 1, F(4) = 1이다. -> 1은 3번, 2는 2번, 3은 1번,4는 1번
	A1의 오른쪽에 있으면서 등장한 횟수가 3보다 큰 수는 없기 때문에, NGF(1) = -1이다. A3의 경우에는 A7이 오른쪽에 있으면서 F(A3=2->2) < F(A7=1->3) 이기 때문에, NGF(3) = 1이다.
	NGF(4) = 2, NGF(5) = 2, NGF(6) = 1 이다.
	
@입력
	첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.
	7
	1 1 2 3 4 2 1

@출력
	총 N개의 수 NGF(1), NGF(2), ..., NGF(N)을 공백으로 구분해 출력한다.
	-1 -1 1 2 2 1 -1
	
@HISTORY
	* 1차 풀이
	f(A숫자) = 수열 A에서 등장한 횟수. :  등장횟수가 젤 크면 -1
	A3의 경우에는 A7이 오른쪽에 있으면서 F(A3=2) < F(A7=1) 이기 때문에, NGF(3) = 1이다. : A3의 등장횟수2  < A7의 등장횟수 3.
																	  					  3에는 A7가 1이니까. NGF는 해당 해당수를 넣는거야.
	스택 : 1 1 2 3 4 2 1
	NGF : 
	f(A1)=3. 인데 아무것도 이것보다 더 큰 수는 없었으니까 NGF(1) = -1, NGF(2) = -1.
	F(A3=2) < F(A7=1) 이기 때문에, NGF(3) = 1,
	F(A3=2->2) >  F(A5=4->1)     , NGF(4) = 2,
	F(A5=4->1)  =  F(A4=3->1)	 , NGF(5) = 2. 똑같으니까 걍 똑가티.
	
	how do i compare between a maximum num and a current num? 
	i think, it has to need a variable that save a temporary num.
	
	=======================
	분명 오큰수와 같은 방법으로 풀 수 있다고 했다. 근데 아무리 생각해도 stack2을 단순히 횟수만을 더하기엔 같은 수의 중복인지 다른 수의 중복인지 구별할 길이 없었다.
	온전히 오큰수 풀이와 같은 방법으로 풀 수 없다고 판단했음.
	So, i plan to use this method for solve.
	" N번 조회 후 중복 cnt 세리고 그 다음에 stack2 push,pop 하며 오등큰수 처리 "
	After N count inquiry, count duplicated num. and then solve 5thBigNum with stack2 push and pop

	* 2차 풀이 - 이유 : 시간초과
	어떻게든 풀었는데 (cnt만큼 돌게 하려고 마지막에 어거지로 푼 게 있었긴 함) 시간초과가 났다.
	어거지로 푼 것 때문에 '아씨 이건 스파게티다'라고 느껴서 엎고 다시 풀고팠는데 푼 게 있기 때문에 아까워서 그냥 끝까지 풀었다.
	근데 마침 시간초과가 나서 엎구 다시 풀었다.
	1차 풀이 했을 땐, 문제 자체가 이해되지 않아서 벅벅 댔는데 지금은 이해가 된 상태라 생각만 잘 하면 쉽게 풀리지 않을까 생각함. -> 200319 개뿔^^
	
	* 3차 풀이 - 이유 : 2차 풀이의 답이 해답이 안났다.
	2차 풀이에서 stack에 숫자 배열의 인덱스가 아니라 f 배열의 인덱스를 저장했다.
	왜냐면 num은 1부터였고 f의 인덱스 = num-1하면 됐어서
	중복숫자 비교할 때 편하게 하기 위함이었다.  
	그래서 0~3까지의 인덱스만 존재했는데
	반복문 안에 반복문을 넣을 생각을 못했다.
	하긴 했지만 생각만 해보다 그친 듯 하다...
	반복분을 넣었으면 됐었을까?ㅠ 아무튼 됨!
 */	
public class p4_17299 {
	public static void main(String args[]) throws IOException {
		BufferedReader 	br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		/*
		
		// 1차로 푼 것
		
		int				cnt = Integer.parseInt( br.readLine() );
		String[]		arr = br.readLine().split(" "); // 1 1 2 3 4 2 1
		int[]			f	= new int[cnt];
		int[]			ngf = new int[cnt];
		stack2<Integer>	stack2= new stack2<Integer>(); // 횟수를 저장하는 스택
		int				totalCnt = 0;
		
		// 1. f 구하기
		for( int i=0;i<arr.length;i++ ) {
			int curNum = Integer.parseInt( arr[i] );
			for( int j=0;j<=i;j++ ) {
				int forNum = Integer.parseInt( arr[j] );
				if( curNum == forNum ) {
					f[j==0?j:j-1]++;
					break;
				}
			}
		}
		
		for( int i=0;i<f.length;i++ ) {
			if( f[i]!=0 ) {
				totalCnt++;
			}
		}
		
		int				nmg = cnt%totalCnt;
		
		// 2. ngf 구하기
		for( int i=0;i<nmg+cnt;i++ ){
			
			// 0 1 2 3 4 5 6 -> 7-3=4 , 7-2=5, 7-1=6 ..7-3=4, 8-3=5, 9-3=6
			int curNum = Integer.parseInt(arr[ i >= cnt ? i-nmg : i]); // 해당 수
			int curNumCntIdx = (totalCnt*curNum-totalCnt)/totalCnt; // 해당 수의 해당개수에 해당되는 인덱스
		
			if( stack2.isEmpty() ) {
				stack2.push( curNumCntIdx );
			}else {
				int curNumCnt = f[curNumCntIdx]; // 해당 수의 해당개수
				
				if( f[stack2.peek()] < curNumCnt ) {
					ngf[  i >= cnt ? i-nmg-1 : stack2.pop() ] = curNum;
				}else{
					stack2.push( curNumCntIdx );
				}
			}
		}
		
		for( int i=0;i<ngf.length;i++ ) {
			int each = ngf[i];
			if( each==0 ) {
				bw.write( "-1 " );
			}else {
				bw.write( String.valueOf(each)+" " );
			}
		}
		*/
		
		/**
		 
		 // 2차로 푼 것
		 
		 */
		/*

		/*
		int				cnt = Integer.parseInt( br.readLine() ); //총 개수
		String[]		arr = br.readLine().split(" "); // 1 1 2 3 4 2 1
		int[]			f	= new int[cnt]; // 중복개수. 인덱스 = 해당 숫자-1
		int[]			ngf = new int[cnt];
		Stack<Integer>	stack= new Stack<Integer>(); // f의 인덱스 담음
		
		// 1. f 구하기
		for( int i=0;i<arr.length;i++ ) {
			f[ Integer.parseInt(arr[i])-1 ]++;
		}
		// f = 3 2 1 1
		// 2.ngf 구하기
		// F(A3=2->2) < F(A7=1->3) 이기 때문에, NGF(3) = 1이다.
		boolean flag = false;
		int IdxNgf = 0;
		
		for( int i=0;i<cnt; ) {
			int curCntIdxOfNum	= Integer.parseInt(arr[i])-1; // cnt의 인덱스
			
			if( stack.isEmpty() ) {
				i++;
				stack.push( curCntIdxOfNum );
			}else{
				
				if( f[stack.peek()] < f[curCntIdxOfNum] ){ 
					flag = true;
					stack.pop();
					ngf[i] = Integer.parseInt(arr[i]);
				}else {
					i++;
					stack.push( curCntIdxOfNum );
				}
			}
			
			if( i==7 && !flag ) {
				flag = false;
				ngf[IdxNgf++] = -1;
				i = IdxNgf;
				stack.clear();
			}
		}
		
		for( int i=0;i<ngf.length;i++ ) {
			bw.write( String.valueOf(ngf[i]) );
		}
		
		br.close();
		bw.flush();
		bw.close();

		 */
		
		
		/*
		 * 7
	1 1 2 3 4 2 1
	-1 -1 1 2 2 1 -1
		 */
		int				cnt = Integer.parseInt( br.readLine() ); //총 개수
		String[]		arr = br.readLine().split(" "); // 1 1 2 3 4 2 1 = 6
		int[]			f	= new int[cnt]; // 중복개수. 인덱스 = 해당 숫자-1
		int[]			ngf = new int[cnt];
		Stack<Integer>	stack= new Stack<Integer>();
		
		// 1. f 구하기
		for( int i=0;i<cnt;i++ ) {
			f[ Integer.parseInt(arr[i])-1 ]++;
		}
		// f = 3 2 1 1
		
		// 2.ngf 구하기
		// F(A3=2->2) < F(A7=1->3) 이기 때문에, NGF(3) = 1이다.
		
		// 처음에는 스택에 담긴 것이 없어서 스택에 담기고 시작하는데 비교해야할 대상이 곧 자기이기 때문에 0은 걍 삽입 하고 1부터 시작해야 런티암 에러가 안남
		stack.push(0);
		
		for( int i=1;i<cnt;i++ ) {
			int curCntIdxOfNum	= Integer.parseInt(arr[i])-1; // cnt의 인덱스
			
			if( stack.isEmpty() ) {
				stack.push( i );
			}else{
				while( !stack.isEmpty() && f[ Integer.parseInt(arr[stack.peek()])-1 ] < f[curCntIdxOfNum] ) { // //  f[top인덱스] 와 현재수의cnt배열에 있는 인덱스
					ngf[stack.pop()] = Integer.parseInt(arr[i]);
				}
				stack.push( i );
			}
		}
		
		/*
			반복문이 모두 끝난 후에도 stack에 값이 있다면 빌 때까지 해당 인덱스에 -1을 넣는다.
			한번 더 반복문 돌면서 하기엔 메모리가 낭비되는 느낌이라
			출력할 때 나는 그냥 -1으로 출력하는 것으로 처리함.
		*/
		/*
		while (!stack.isEmpty()) {
            ngf[stack.pop()] = -1;
        }
        */
		
		for( int i=0;i<cnt;i++ ) {
			int num = ngf[i];
			bw.write( num==0 ? -1+" " : num +" " );
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}





















































