package StepBystep._3;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
	@Question
		자연수 N이 주어졌을 때, N부터 1까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 100,000보다 작거나 같은 자연수 N이 주어진다.
	@Output
		첫째 줄부터 N번째 줄 까지 차례대로 출력한다.
	@history
		2741의 문제에서 그냥 꺼꾸로 출력하는 것이라 쉽게 가능했다.
	@author dada
 */
public class _2742 {
	public static void main(String[] args) {
        Scanner sc     = new Scanner(System.in);
        Pattern ptn    = Pattern.compile("(^[0-9]*$)");
        String  chk    = "";
        int  chkNum    = 0;
        
        try{
            while(true){
                chk = sc.next();
                
                if( ptn.matcher(chk).find() == true ){
                    chkNum = Integer.parseInt(chk);
                    if( chkNum <= 100000 ){
                        for( int i=chkNum; i>0; i-- ){
                            System.out.println(i);
                        }
                        break;
                    }
                }else{
                    continue;
                }
            }
        }catch(Exception e){
        	e.printStackTrace();
        }finally{
            sc.close();
        }
    }
}
