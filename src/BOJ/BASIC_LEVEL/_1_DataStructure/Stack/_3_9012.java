package BASIC_LEVEL._1_DataStructure.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * 
	@Question
		괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
		그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
		한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다.
		만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다.
		그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다.
		예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다. 
		여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다. 
	@Input
		입력 데이터는 표준 입력을 사용한다.
		입력은 T개의 테스트 데이터로 주어진다.
		입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다.
		각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다.
		하나의 괄호 문자열의 길이는 2 이상 50 이하이다.
		6
		(())()) - ( :3 , ):4 
		(((()())()
		(()())((()))
		((()()(()))(((())))()
		()()()()(()()())()
		(()((())()(
	@Output
		출력은 표준 출력을 사용한다.
		만일 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 한 줄에 하나씩 차례대로 출력해야 한다.
		NO
		NO
		YES
		NO
		YES
		NO
	@History
		일단 풀 수 있는 방법이 1. Stack 이용 2. Stack 크기만을 이용해서 여는 괄호의 개수로만 접근 이렇게 두가지라고 함.
		두가지를 다 해본다!
		1. Stack 이용
		계속 첨 넣을 때만 값이 똑바로 나오고 점점 while문 진행할수록 데이터가 사라질 게 안사라지고 이랬는데
		알고보니까 stack을 전역으로 선언해놓고 계쏙 같은 메모리를 참조했던 것이었다ㅠ 그러니까 자꾸 안사라지지;;
		아무튼 그래서 수정함.
    	남들 코드 본 뒤  : Flag
					       사실 Flag를 나도 생각하긴 했었따. 내가 자주 즐겨쓰는 방법이기도 했고!
					       근데 안썼던 이유는 뭔가 오로지 for문안에서 해결을 하고 싶어서!인데 나보다 코드가 짧고 메모리가 적게드는 사람을 보니 Flag를 썼더라구
					       
    	2. Stack 크기만을 이용해서 여는 괄호의 개수로만 접근 
    	결론부터 말하자면 너무 pop의 기능에 치우쳐져서만 생각하느라 어렵게 구현하다보니 스파게티 코드가 된 것 같다.
		스택을 구현하지 않고 스택의 크기만 이용해서 몇개의 여는 괄호가 스택에 들어가있는지로 구현할 수 있때서
		방법1) 스택에 여는 괄호만 추가 후에 말그대로 "스택의 크기"만을 가지고 구해볼라함..미친 듯ㅠ 당연히 반례 왕창
		방법2) 스택을 구현안한다했으니까 push는 하되,
				빼서 굳이 배열에서 사라지는 거로만 구현하려다 보니까 substring을 씀
        	  	얘는 첫번째 인덱스에 있는 거만 사라져야만 쓸 수 있는 코드였음.
        	  	그니까 중간 거는 못사라지게 한단거지.
        	  	
		남들 코드 본 뒤  :         	  	
			한 3일 고민하다가 구글링함..ㅎㅎ..방법은 아주 간단했다..내가 너무 어렵게 생각했어..
 *
 */
public class _3_9012 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader	br		= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw		= new BufferedWriter( new OutputStreamWriter(System.out) );
	    int             testCase= Integer.parseInt( br.readLine() );
	    
	    while( testCase-->0 ) {
	    	
	        /* 1. Stack 이용
	    	Stack<Character> stack  = null;
	    	while( testCase-->0 ) {
		    	stack = new Stack<Character>();
		    	String vpsSet = br.readLine()+'\n';
				for( char eachPs : vpsSet.toCharArray() ) {
		            if( eachPs == '(' ) {
		                stack.push(eachPs);
		                
		            }else if( eachPs == ')' ){
		            	if( !stack.isEmpty() ) {
	                		stack.pop();
		                }else{
		                	bw.write("NO\n");
		                	bw.flush();
		                	break;
		                }
		            	
		            }else{
		            	if( stack.isEmpty() ) {
		            		bw.write("YES\n");
		            	}else{
		            		bw.write("NO\n");
		            	}
		            }
		            bw.flush();
		        }
	        }
	        */
	        /*
	         2. 여는 괄호의 개수로만 접근
	         */
	    	String	vpsSet	= br.readLine();
	    	int		cnt		= 0;

	    	for( char eachPs : vpsSet.toCharArray() ){
	    		if( eachPs == '(' ){
	    			cnt++;
	    		}else{
	    			cnt--;
	    		}
	    		if( cnt<0 ){
	    			break;
	    		}
	    	}
	    	
	    	if( cnt==0 ){ // 괄호는 짝이기 때문에 +- 상쇄돼서 0이 됨.
	    		bw.write("YES\n");
    			bw.flush();
	    	}else{
	    		bw.write("NO\n");
    			bw.flush();
	    	}
	    	// 반례 : 라고 할 것도 없는 게 중간에 것이 사라지면 방법이 없음.. substring이므로 첨에만 아닌 경우가 존재할 때만이 사용 가능..
	    	/*
	    	int		vpsSetLeng	= vpsSet.length();
	    	int		coupleCnt	= 0;
	    	int		startIdx	= 0;
	    	int		stackSize	= 0;
			for( int i=0;i<vpsSetLeng;i++ ){
	    		char eachPs		= vpsSet.charAt(i);
	            
	        	if( eachPs == '(' ) {
	            	//stack.push(eachPs);
	        		stackSize++;
	            }else{
	            	if( stackSize==0 ){
	            		bw.write("NO\n");
	            		bw.flush();
	            		break;
	            	}else{
	            		if( i!=vpsSetLeng-1 ){
		            		String subStr	= vpsSet.substring(startIdx, i+1);
		            		int		idx		= subStr.lastIndexOf("(");
		            		if( idx != -1 ){
		            			coupleCnt++;
		            			stackSize--;
		            			startIdx = idx+2; // 하나만 없어지는 게 아니라 쌍으로 없어지는 거니까
		            		}
	            		}else{
	            			if( stackSize==0 ){
	            				bw.write("YES\n");
	    	            		bw.flush();
	    	            		break;
	            			}else{
	            				bw.write("NO\n");
	    	            		bw.flush();
	    	            		break;
	            			}
	            		}
	            	}
	            }
	        }
	        */
	    	// 이것의 반례 = ())( : stack길이(=2)*2 = 4 = vps길이. 하지만 짝이 맞지 않음
        	//bw.write( stack.size()*2 == (vpsSet.length()) ? "YES\n" : "NO\n" );
        	//bw.write( stack.size()==coupleCnt ? "YES\n" : "NO\n" );
	       // bw.flush();
	    }//while
	    
	    br.close();
	    bw.flush();
	    bw.close();
		
	}
}
