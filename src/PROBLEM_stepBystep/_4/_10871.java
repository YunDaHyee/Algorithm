package _4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
	@Question
		정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 N과 X가 주어진다. (1 ≤ N, X ≤ 10,000)
		둘째 줄에 수열 A를 이루는 정수 N개가 주어진다. 주어지는 정수는 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
		10 5
		1 10 4 9 2 3 8 5 7 6
	@Output
		X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다. X보다 작은 수는 적어도 하나 존재한다.
		1 4 2 3
	@history
		S T E P >
			1)	맨 처음에 readLine 을 받을 때, 어떻게 하면 N개만큼 받게 하지? 이 생각 하다가
				배열로 만든 다음에 사이즈로 접근하자 해서 그렇게 함.
				
		어느정도 이제 문제 해결능력이 조금씩은 감이 잡히는 느낌이다..!
		
	@author dada
 */
public class _10871 {
	public static void main(String[] args) throws IOException {
		
		String				strNX	= "";
		String				strA	= "";
		String[]			strArrNX= null;
		String[]			strArrA	= null;
		int					numX	= 0;
		ArrayList<Integer>	numArr	= new ArrayList<Integer>(); 
		BufferedReader		br		= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter		bw		= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		try{
			
			strNX		= br.readLine(); // N : 정수 갯수  // X :비교 대상 수
			strArrNX	= strNX.split(" ");
			
			while(true){
				
				strA	= br.readLine();
				strArrA	= strA.split(" ");
				if( Integer.parseInt(strArrNX[0]) == strArrA.length ){
					numX = Integer.parseInt(strArrNX[1]);
					for(int i=0;i<strArrA.length;i++){
						int tempNum = Integer.parseInt(strArrA[i]);
						if( numX > tempNum ){
							numArr.add(tempNum);
						}
					}
					for(int i=0;i<numArr.size();i++){
						if( numArr.get(i) != 0 ){
							bw.write( String.valueOf(numArr.get(i)) + " " );
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
			bw.flush();
			bw.close();
			br.close();
		}
		
		
	}    
}