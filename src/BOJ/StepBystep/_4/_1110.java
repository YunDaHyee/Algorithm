package StepBystep._4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
	@Question
		0보다 크거나 같고, 99보다 작거나 같은 정수가 주어질 때 다음과 같은 연산을 할 수 있다.
		먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고, 각 자리의 숫자를 더한다.
		그 다음, 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다. 다음 예를 보자.
		26부터 시작한다.
		2+6 = 8이다. 새로운 수는 68이다.
		6+8 = 14이다. 새로운 수는 84이다.
		8+4 = 12이다. 새로운 수는 42이다.
		4+2 = 6이다. 새로운 수는 26이다.
		위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.
		N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 N이 주어진다. N은 0보다 크거나 같고, 99보다 작거나 같은 정수이다.
		26
	@Output
		첫째 줄에 N의 사이클 길이를 출력한다.
		4
	@history
		S T E P >
			1) 배열로 접근했다가 charAt 이용함.
			
			2) 규칙이 있는 것 같아서 생각해봄,,,,,,,,,,,,,(생각중,,)
			
	@author dada
 */
public class _1110 {
	public static void main(String[] args) throws IOException {

		int             cnt         = 1;
        int             sum         = 0;
        String          ifNum       = "";
        String          firstNum    = "";
        String          strSum      = "";
        String          newNum      = "";
        BufferedReader  br          = new BufferedReader( new InputStreamReader(System.in) );
        BufferedWriter  bw          = new BufferedWriter( new OutputStreamWriter(System.out) );
        
        try{
            
            firstNum    = br.readLine();
            ifNum       = firstNum;
            
            while(true){
                
                if( ifNum.length() == 1){
                    ifNum = "0" + ifNum;
                }
                
                // 배열을 꼭 안해도 좀 더러워도 charAt 이런식으로 접근할 수 있음.
                // 아래에 주석을 한 건 배열로 접근했을 때의 코드들임.
                //String[] numArr = ifNum.split("\\d");
                //sum     = Integer.parseInt( numArr[0] ) + Integer.parseInt( numArr[1] );
                sum     = Integer.parseInt( String.valueOf(ifNum.charAt(0)) ) + Integer.parseInt( String.valueOf(ifNum.charAt(1)) );
                
                if( String.valueOf(sum).length() == 1 ){
                    strSum = "0" + sum;
                }else{
                    strSum = String.valueOf(sum);
                }
                
                //newNum  = numArr[1] + strSum.indexOf(1);
                newNum  = String.valueOf( ifNum.charAt(1) ) + String.valueOf( strSum.charAt(1) );
                
                if( Integer.parseInt(newNum) == Integer.parseInt(firstNum) ){
                    bw.write( String.valueOf(cnt) );
                    break;
                }else{
                    ifNum = newNum;
                    cnt++;
                    continue;
                }
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            bw.flush();
            bw.close();
            br.close();
        }
		
    }
}
