package StepBystep._3;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
	@Question
		첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제. 하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
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
		라인 바꾸고 찍는건 괜찮았는데 오른쪽 정렬을 어떻게 해야하는지 감이 안섰다, 순간..
		그래서 뭐 함수 같은 거 있는 줄 알고 print 함수에 관한 또다른 함수가 있나 싶어서 막 뒤졌다.
		근데 찾아보니까 중첩 포문을 이용.. 답을 쓰고 얼떨결에 맞추긴 했는데 솔직히 이해가 잘 안갔다;;;;
		졸라 어이 없었다...,,
		하쥐만 난 포기하지 않고 3을 대입후에 개개의 for문을 이해하면서 따라 들어갔더니 이해가 됐다!
		
		- 교훈 : 집중이 안될 땐 노래를 끄자. 그리고 for문을 하나씩 이해하자..
	@author dada
 */
public class _2439 {
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
                        	for( int k=i;k>1;k-- ){
                        		System.out.print(" ");
                        	}
                        	for( int j=i; j<=chkNum; j++ ){
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
