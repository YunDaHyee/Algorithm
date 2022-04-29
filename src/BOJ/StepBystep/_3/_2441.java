package _3;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
	@Question
		첫째 줄에는 별 N개, 둘째 줄에는 별 N-1개, ..., N번째 줄에는 별 1개를 찍는 문제. 하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
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
		역시.. 나도 모르게 앞에꺼랑 답을 좀만 고치면 되겠지라는 생각으로 풀었던 것 같다..
		다시 앞선 문제처럼 for문을 다시 짚어가면서 품;;ㅠ;;ㅈㅅ;;;
	@author dada
 */
public class _2441 {
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
                    	
                    	 for( int i=chkNum;i>0;i-- ){ //3
                             for( int j=i;j<chkNum;j++ ){ //3
                                 System.out.print(" ");
                             }
                             for( int k=0;k<i;k++ ){
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
