package StepBystep._3;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
	@Question
		N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
	@Output
		입력으로 주어진 숫자 N개의 합을 출력한다.
		1
		1
		입력 시, 1
	@history
		시발 정규식;; 새시간동안;;
	@author dada
 */
public class _11720 {
	public static void main(String[] args) {
        Scanner sc		= new Scanner(System.in);
        Pattern ptn		= Pattern.compile("(^[0-9]*$)");
        String  chk1	= "";
        String  chk2	= "";
        String[]chkArr	= null;
        int		chkCnt	= 0;
        int		chkSum	= 0;
        
        try{
            while(true){
                chk1 = sc.next();
                chk2 = sc.next();
                
                if( ptn.matcher(chk1).find() == true && ptn.matcher(chk2).find() == true ){
                    chkCnt	= Integer.parseInt(chk1);
                    //chkNum	= Integer.parseInt(chk2);
                    if( chkCnt >= 1 && chkCnt <= 100 ){
                    	System.out.println("chk2 : "+chk2);
                    	// ^([[:alpha:]]+ ?)+$
                    	// (^(\\d)$)+g  -> 1 됨
                    	// 	(^(\\d)$)? -> 5 됨
                    	//(\\d){0,1}(\\d){0,1}(\\d){0,1}
                    	if( chk2.length() == 1 ){
                    		chkArr = chk2.split("(^(\\d)$)+g");
                    	}else{
                    		chkArr = chk2.split("(^(\\d)$)?");
                    	}
                    	System.out.println(chkArr.length);
                    	for(int i=0;i<chkArr.length;i++){
                    		System.out.println(chkArr[i]);
                    		chkSum += Integer.parseInt(chkArr[i]);
                    	}
                    	System.out.println(chkSum);
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
