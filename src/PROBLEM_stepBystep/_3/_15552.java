package _3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

/**
	@Question
		본격적으로 for문 문제를 풀기 전에 주의해야 할 점이 있다. 입출력 방식이 느리면 여러 줄을 입력받거나 출력할 때 시간초과가 날 수 있다는 점이다.
		C++을 사용하고 있고 cin/cout을 사용하고자 한다면, cin.tie(NULL)과 sync_with_stdio(false)를 둘 다 적용해 주고, endl 대신 개행문자(\n)를 쓰자. 단, 이렇게 하면 더 이상 scanf/printf/puts/getchar/putchar 등 C의 입출력 방식을 사용하면 안 된다.
		Java를 사용하고 있다면, Scanner와 System.out.println 대신 BufferedReader와 BufferedWriter를 사용할 수 있다. BufferedWriter.flush는 맨 마지막에 한 번만 하면 된다.
		Python을 사용하고 있다면, input 대신 sys.stdin.readline을 사용할 수 있다. 단, 이때는 맨 끝의 개행문자까지 같이 입력받기 때문에 문자열을 저장하고 싶을 경우 .rstrip()을 추가로 해 주는 것이 좋다.
		또한 입력과 출력 스트림은 별개이므로, 테스트케이스를 전부 입력받아서 저장한 뒤 전부 출력할 필요는 없다. 테스트케이스를 하나 받은 뒤 하나 출력해도 된다.
		자세한 설명 및 다른 언어의 경우는 이 글에 설명되어 있다.
		이 블로그 글에서 BOJ의 기타 여러 가지 팁을 볼 수 있다.
	@Input
		첫 줄에 테스트케이스의 개수 T가 주어진다. T는 최대 1,000,000이다. 다음 T줄에는 각각 두 정수 A와 B가 주어진다. A와 B는 1 이상, 1,000 이하이다.
		5
		1 1
		12 34
		5 500
		40 60
		1000 1000
	@Output
		각 테스트케이스마다 A+B를 한 줄에 하나씩 순서대로 출력한다.
		2
		46
		505
		100
		2000
	@history
		Scanner 클래스랑 println 함수만 주구장창 써왔는데 이 문제에서 제시하기를, 그것들 대신 BufferedReader랑 BufferedWriter를 써보라고 했다.
		그래서 처음으로 두 클래스를 써본 문제!
		
		S T E P >
		
			1)	countSt와 num의 숫자 범위를 정규식으로 뒀었음. 근데 굉장히 여러가지 케이스에서 걸리더라고.
				예를 들어서 첫 번째 조건문에서 ^([0-9]|[1-9][0-9]|[1-9][0-9][0-9])$' 이렇게 뒀었는데
				범위를 둬야할 자릿수가 세자리까지면 어떻게든 저렇게 하겠는데 진짜 자릿수가 커질수록 진짜 저렇게까지 하는 건 아닌 것 같아서 빼고 if문으로 함.
				나중에 기회가 된다면 범위를 두는 효율적인 정규식을 알았으면 좋겠다. 
				
			2)	숫자배열의 사이즈를 미리 지정해야만 두 수의 합을 저장할 숫자배열의 인덱스로 접근할 수 있는데 어떻게 사이즈를 미리 지정하지 할지 고민이었음.
				Integer.maxSize랑 Integer.size로 하니까 시간초과 오류가 났음. 하쒸 ,, 어카지 하다가
				선언을 맨 위에 하겠다는 욕심은 버리고 입력받는 사이즈 만큼의 배열을 생성하면 되겠다 싶어서 countNum으로 지정함.
				( 생각해보면 아주 쉬운 생각인데 왜이렇게 어렵게 생각해내는지...바보같다..)
				
			3)	2번까지 했는데도 시발 자꾸 시간초과 오류가 나는거야.........(지금 와서 생각해보면 step2에서 Integer.maxSize랑 Integer.size를 했어도 맞았을 것 같긴 함)
				아 존나 뭐지 하다가 BOJ 도움말? 같은 걸 봄. 근데 거기서 꽤 여러가지를 꺠달을 수 있었음..진짜 이제라도 알아서 다행이었어.
				일단 여러가지의 입력쌍이 있다고도 했고 입력받는 수의 조건은 이미 그 조건에 포함된 수이기 떄문에 굳이 코드 안에서 조건을 안걸어도 된 다는 거였다;;
				그래서 일단 코드에 있는 수 조건문들을 다 뺌. 그랬더니 됨.................
				허허;; 어이가 없었다..
				
			아무튼 이번 문제도 여러가지를 깨달았다!
				
	@author dada
 */
public class _15552 {
	public static void main(String[] args) throws IOException {
		String          countSt     = "";
        int             countNum	= 0;
        String          num     	= "";
        String[]        numArr		= null;
        int             A			= 0;
        int             B			= 0;
        int             idx			= 0;
        BufferedReader  br			= new BufferedReader( new InputStreamReader(System.in) );
        BufferedWriter  bw			= new BufferedWriter( new OutputStreamWriter(System.out) );
        
        try{
            while(true){
            	countSt = br.readLine();
                if( chkRegex("\\d", countSt) ){
                	countNum = Integer.parseInt( countSt.trim().replaceAll(" ", "") );
                   // if( TT >= 1 && TT <= 1000000 ){
                        Integer AB[] = new Integer[countNum];
                        for(int i=0;i<countNum;i++){
                            while(true){
                                num = br.readLine(); //(\\d\\s\\d){1,1000}
                                if( chkRegex("\\d\\s\\d", num) ){
                                    numArr  = num.split(" ");
                                    //if( A >= 1 && A <= 1000 && B >= 1 && B <= 1000 ){
	                                    A       = Integer.parseInt( numArr[0] );
	                                    B       = Integer.parseInt( numArr[1] );
	                                    AB[idx++] = A + B;
	                                    //AB[idx++] = Integer.parseInt( numArr[0] ) + Integer.parseInt( numArr[1] ); // 이렇게 하면 시간초과 나서 따로 A,B 변수에 넣어줌.
                                        break;
                                    //}else{
                                    //   continue;
                                    //}
                                }else{
                                    continue;
                                }
                            }//while
                        }//for
                        
                        for(int i=0;i<idx;i++){
                            bw.write(AB[i]+"\n");
                        }
                        
                        break;
                    //}else{
                    //    continue;
                    //}
                }else{
                    continue;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            bw.flush();
            br.close();
            bw.close();
        }
    }
    
    public static boolean chkRegex(String regex, String number){
        Pattern pt = Pattern.compile(regex);
        if( pt.matcher(number).find() ){
            return true;
        }else{
            return false;
        }
    }
    
    
}