package StepBystep._4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
	@Question
		세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다.
		일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다.
		그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
		예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
		세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 시험 본 과목의 개수 N이 주어진다. 이 값은 1000보다 작거나 같다.
		둘째 줄에 세준이의 현재 성적이 주어진다. 이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.
		3
		40 80 60
	@Output
		첫째 줄에 새로운 평균을 출력한다. 정답과의 절대/상대 오차는 10-2까지 허용한다.
		75.00
	@history
		S T E P >
			1)	정수형으로 안바꿔서 뭐 오만 이상한 값들이 나왔었다.
				그래서 첨에 avgSum 만 float으로 바꿨고 잘 될 줄 알았는데 계속 이상한 값이 나오길래 tempNum이랑 maxNum도 float으로 바꾸니까 제대로 나옴!
				
	@author dada
 */
public class _1546 {
	public static void main(String[] args) throws IOException {
		
	    String          strSubjCnt  = "";
	    int             numSubjCnt  = 0;
	    float           maxScore    = 0;
	    float           avgSum      = 0;
	    String          strScore    = "";
	    String[]        arrScore    = null;
	    BufferedReader  br          = new BufferedReader( new InputStreamReader(System.in) );
	    BufferedWriter  bw          = new BufferedWriter( new OutputStreamWriter(System.out) );
	
	    try{
	        strSubjCnt      = br.readLine();
	        numSubjCnt      = Integer.parseInt(strSubjCnt);
	        
	        while(true){
	            strScore    = br.readLine();
	            arrScore    = strScore.split(" ");
	            
	            if( numSubjCnt == arrScore.length ){
	                
	                for(int i=0;i<arrScore.length;i++){
	                    int tempNum = Integer.parseInt(arrScore[i]);
	                    if(tempNum > maxScore){
	                        maxScore = tempNum;
	                    }
	                }
	                
	                for(int i=0;i<arrScore.length;i++){
	                    float tempNum = Integer.parseInt(arrScore[i]);
	                    avgSum += tempNum/maxScore*100;
	                }
	                
	                bw.write( String.valueOf(avgSum/numSubjCnt) );
	                
	                break;
	                
	            }else{
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