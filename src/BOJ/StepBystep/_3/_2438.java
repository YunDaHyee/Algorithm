package StepBystep._3;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
	@Question
		첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
	@Input
		첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
	@Output
		첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
		5 입력 시,
		*
		**
		***
		****
		*****
	@history
		1차로는 순간 옛날에 별 찍는 거 어려워 했떤 거 생각나서 좀 당황했는데
		for문의 원리대로 차차 하기로 했다.
		1차 for문에서는 먼저 라인을 출력해내고 2차 for문에서는 별을 출력하는 것으로!
		println으로 했다가 'println은 개행을 포함하는 거지!' 란 생각으로
		print로 하고 후에 println으로 개행처리를 해줌
	@author dada
 */
public class _2438 {
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
                        for( int i=0; i<chkNum; i++ ){
                        	for( int j=0; j<=i; j++ ){
                        		System.out.print( "*" );
                        	}
                        	System.out.println();
                        }
                    }
                    break;
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
