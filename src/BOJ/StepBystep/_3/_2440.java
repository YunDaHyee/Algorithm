package _3;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
	@Question
		첫째 줄에는 별 N개, 둘째 줄에는 별 N-1개, ..., N번째 줄에는 별 1개를 찍는 문제
	@Input
		첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
	@Output
		첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
		5 입력 시,
	  	*****
		****
		***
		**
		*
	@history
	@author dada
 */
public class _2440 {
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
                    if( chkNum >= 1 && chkNum <= 100 ){
                    	
                        for( int i=chkNum; i>0; i-- ){
                        	for( int j=i; j>0; j-- ){
                        		System.out.print("*");
                        	}
                        	System.out.println();
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
