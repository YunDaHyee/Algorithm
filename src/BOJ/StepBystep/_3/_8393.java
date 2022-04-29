package StepBystep._3;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
	@Question
		n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.
	@Output
		1부터 n까지 합을 출력한다.
		3 입력 시, 6
	@history
		바로 성공~
	@author dada
 */
public class _8393 {
	public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Pattern ptn = Pattern.compile("(^[0-9]*$)");
        String  chk = "";
        int  chkNum	= 0;
        int	 sumNum	= 0;	
        
        try{
            while(true){
                chk = sc.next();
                
                if( ptn.matcher(chk).find() == true ){
                    chkNum = Integer.parseInt(chk);
                    if( chkNum >= 1 && chkNum <= 10000 ){
                        for(int i=1;i<=chkNum;i++){
                        	sumNum += i;
                        }
                        System.out.println(sumNum);
                    	break;
                    }else{
                    	continue;
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
