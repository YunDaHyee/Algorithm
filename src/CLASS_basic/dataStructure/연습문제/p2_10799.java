package dataStructure.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


/**
@문제
	여러 개의 쇠막대기를 레이저로 절단하려고 한다.
	효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고, 레이저를 위에서 수직으로 발사하여 쇠막대기들을 자른다.
	쇠막대기와 레이저의 배치는 다음 조건을 만족한다.
	
	쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다. - 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓는다.
	각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
	레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다. 
	아래 그림은 위 조건을 만족하는 예를 보여준다.
	수평으로 그려진 굵은 실선은 쇠막대기이고, 점은 레이저의 위치, 수직으로 그려진 점선 화살표는 레이저의 발사 방향이다.
	
	이러한 레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있다.
	
	레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ‘( ) ’ 으로 표현된다. 또한, 모든 ‘( ) ’는 반드시 레이저를 표현한다.
	쇠막대기의 왼쪽 끝은 여는 괄호 ‘ ( ’ 로, 오른쪽 끝은 닫힌 괄호 ‘) ’ 로 표현된다. 
	위 예의 괄호 표현은 그림 위에 주어져 있다.
	
	쇠막대기는 레이저에 의해 몇 개의 조각으로 잘려지는데, 위 예에서 가장 위에 있는 두 개의 쇠막대기는 각각 3개와 2개의 조각으로 잘려지고,
	이와 같은 방식으로 주어진 쇠막대기들은 총 17개의 조각으로 잘려진다. 
	
	쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때, 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램을 작성하시오.
		
@입력
	한 줄에 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다. 괄호 문자의 개수는 최대 100,000이다. 
	()(((()())(())()))(())
	(((()(()()))(())()))(()()) // 26개
	레이저 : 제일 작은 1세트
	막대기 : (1세트 포함해서)두세트 이상
	
	
@출력
	잘려진 조각의 총 개수를 나타내는 정수를 한 줄에 출력한다.
	17
	24
@HISTORY
	막대기수 + 레이저수 + 1층에서 쪼개지는 수 = 총 쪼개지는 수
	나오길래 그렇게 하려고 일단 막대기수 하는 건 해냈는데 문제는 레이저 수였다.
	레이저는 제일 안쪽에 있는 괄호쌍인데 그거를 구하려면 변수도 많아지고 너무 복잡해지는 게 문제였음.
	(괄호 안에 괄호의 쌍들이 몇개 나올지도 모르는 일이고.. 넘 복잡)
	그래서 그냥 강의에서 가르쳐준대로 그냥 풀기로 함... 어떻게 이렇게 생각해냈을까 싶기도 함...ㅠ아직 멀었다ㅠ
	한 몇 주일을 고민한 것 같은데 일단은 아래와 같이 짰다.
	
	idx와 top의 차 == dif
	dif = 1 : 레이저. S, top-- 후 스택의 크기 만큼 더해주고
	 	!=  : 막대기. S, 스택의 크기는 레이저가 자르는 쇠막대기 수와 같음.
	 		  레이저로 두번 짜르면 세 개의 막대기가 나오니까 +1을 해줘야함.
	 			  		 
	 (가 나올 때 : top을 증가시켜줘야하는데 dif만큼 더해줘야함.
	 			    처음에는 1씩만 증가하는 거로 했었는데 그렇게 하면 온전히 (가 나온 횟수로만 카운트 되기 때문에
	 			    지나온 인덱스들의 수만큼은 더해지지 않는 것이 문제였음.
	 )가 나올 때 : dif = 1 -> 괄호쌍들 중에서 가장 안쪽에 있는 쌍들임. 그러므로 레이저. S, top-- 후 스택의 크기 만큼 더해줌.
	 				   !=  -> 막대기. S, 스택의 크기는 레이저가 자르는 쇠막대기 수와 같음.
	 		  					레이저로 두번 짜르면 세 개의 막대기가 나오니까 기존 total 값에 +1을 해줘야함.

	 이렇게 했는데 개느리다. 이유를 생각해보다가 toCharArray()로 바꿔서 다시 for 문 돌리는 것이 느리게 하는 게 아닌가 싶어서 또 수정함.
	 for->while문, Characher->Integer 이런식으로 다양하게 고쳐서 해봤는데 속도 자체는 다 느린 듯...ㅠ
	 
	- 남의 코드 보고 :
	배열에다가 괄호가 아닌 index를 담더라..한번 해보겠다우...내 코드에 적용해서 인덱스를 담는 것으로 성공함!
	
*/
public class p2_10799 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br		= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw		= new BufferedWriter( new OutputStreamWriter(System.out) );

		//Stack<Character>stack	= new Stack<Character>();
		Stack<Integer>stack2	= new Stack<Integer>();
		String			bracket = br.readLine();
		
		int				total	= 0;
		int				idx		= -1;
		int				top		= -1;
		
		//for( char each : bracket ) { //원 
		while( ++idx<bracket.length() ) {
			//idx++; // 0 1 2 3 4 | 5 6 7
			char each = bracket.charAt(idx);
			if( each=='(' ) {
				top += idx-top; // 0 1 2 3 | 4 5
				//stack.push(each);//원
				stack2.push(idx);
			
			}else{
				//stack.pop();//원 
				stack2.pop();
				//if( idx-top == 1 ){//원
				if( top == idx-1 ){
					top--;
					//total += stack.size();//원
					total += stack2.size();
				}else {
					total++;
				}
			}
			
		}
		
		bw.write( String.valueOf(total) );
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}
