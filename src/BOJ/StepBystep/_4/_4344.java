package StepBystep._4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
	@Question
		대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
	@Input
		첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
		둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다.
		점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
		5
		5 50 50 70 80 100
		7 100 95 90 80 70 60 50
		3 70 90 80
		3 70 90 81
		9 100 99 98 97 96 95 94 93 91
	@Output
		각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
		40.000%
		57.143%
		33.333%
		66.667%
		55.556%
	@history
		S T E P >
			1) 이 라인마다 배열을 받는 걸 어떻게 접근할까 하다가 두가지를 떠올렸다.
				
				1. 라인마다 배열로 받기
				2. 전체 다 받고 개행문자 구분 후에 안에서 띄어쓰기로 구분
				
				첫번짼 너무 메모리 낭비가 심할 것 같아서 두번째로 선택함
				
			2)	개행문자로 구분해야되는데 \n 이거는 문자 그대로 출력해버리더라..
				그래서 검색해보다가 System.lineSeparator() 이걸 알아냄.
				이거 자체가 \n\r를 의미하더라고! 그래서 이걸로 하니까 됨!
	
			3)	학생점수의 비율인 줄 알고 배열에 평균넘은 학생 점수 / 총 학생 점수 계산한 값을 저장해서 자꾸 값이 0.xxx 이런식으로 나옴.
				근데 다시 보니까 학생의 비율이라 명수로 따지니까 됨,,
				의외로 로직은 쉽게 잘 짠 것 같다!!!
			
	@author dada
 */
public class _4344 {
	public static void main(String[] args) throws IOException {

		int             numCnt      = 0;
        String          strArr      = ""; 
        String[]        numArr      = null;
        Double[]        numSumArr   = null;
        BufferedReader  br          = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw          = new BufferedWriter(new OutputStreamWriter(System.out));
        
        try{
        	
            numCnt      = Integer.parseInt(br.readLine());
            numSumArr   = new Double[numCnt];
            
            for(int i=0;i<numCnt;i++){
                strArr += br.readLine();
                strArr += System.lineSeparator();
            }
            
            numArr = strArr.split( System.lineSeparator() );
            
            for(int i=0;i<numArr.length;i++){
                int         tempCnt     = 0;
                Double      tempSum     = 0.0;
                Double      tempAvg     = 0.0;
                Double      tempIfSum   = 0.0;
                
                String[]    tempArr     = numArr[i].split(" ");
                
                tempCnt = Integer.parseInt(tempArr[0]);
                
                for(int j=1;j<tempArr.length;j++){
                    tempSum += Double.parseDouble(tempArr[j]);
                }
                
                tempAvg = tempSum / tempCnt;
                
                for(int j=1;j<tempArr.length;j++){
                    if( Double.parseDouble(tempArr[j]) > tempAvg ){
                        tempIfSum++;
                    }
                }
                numSumArr[i] = tempIfSum / tempCnt;
            }
            
            for(int i=0;i<numSumArr.length;i++){
                bw.write( String.format("%.3f",numSumArr[i]*100) + "%" + System.lineSeparator() );
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
