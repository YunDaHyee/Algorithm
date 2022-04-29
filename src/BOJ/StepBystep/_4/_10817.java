package StepBystep._4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
	@Question
		세 정수 A, B, C가 주어진다. 이때, 두 번째로 큰 정수를 출력하는 프로그램을 작성하시오. 
	@Input
		첫째 줄에 세 정수 A, B, C가 공백으로 구분되어 주어진다. (1 ≤ A, B, C ≤ 100)
		20 30 10
	@Output
		두 번째로 큰 정수를 출력한다.
		20
	@history
		S T E P >
			1)	코드에 써놨찌만 두 번째로 큰 정수가 아스키코드로 출력이 돼서 String으로 변환!
			2)	코드에 써놨지만 출력값들이 다르게 나오는 거
			3)	아 그래서 2번까지 했는데 존나 자꾸 런타임 오류가 나는거야.. 시바 이번에도 막 이것저것 바꾸다가
				아 설마 Pattern 클래스 땜에 그런건가 해서 Pattern이랑 while문 지우니까 맞춤;; 노어이;;
				이것도 조건식이랑 마찬가지로 어차피 입력값들은 다 숫자고 범위에 포함되는 숫자니까 앞으로도 굳이 정규식이랑 while문 할 필요는 없을 듯,,
	@author dada
 */
public class _10817 {
	public static void main(String[] args) throws IOException {
		
		String			numSt	= "";
		String[]		numArr	= null;
		int				maxNum	= 0;
		int				maxIdx	= 0;
		int				secNum	= 0;
		int				tempNum = 0;
		BufferedReader	br		= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter	bw		= new BufferedWriter(new OutputStreamWriter(System.out));
		// Pattern 		pt		= Pattern.compile("\\d\\s\\d\\s\\d");
		
		try{
			
			// while(true){
				numSt = br.readLine();
				
				// if( pt.matcher(numSt).find() ){
					numArr = numSt.split(" ");
					
					for (int i = 0; i < numArr.length; i++) {
						tempNum = Integer.parseInt(numArr[i]);
						if (tempNum > maxNum) {
							maxNum = tempNum;
							maxIdx = i;
						}
					}
		
					for (int i = 0; i < numArr.length; i++) {
						tempNum = Integer.parseInt(numArr[i]);
						/*
							if( tempNum != maxNum ){} 이 조건으로 밖에 한번 더 감쌌다가 같은 수도 포함 시켜서 비교해야된다는 거 깨달아서 뺌.
							근데 같은 수도 포함시켜서 비교 해야되는데 20 10 10 이 입력되었을 때 20이 나와야 되는데 10 이 나옴.
							그래서 해당 숫자로 접근하는 게 아니라 인덱스로 접근하기로 함.
						 */
						if (i != maxIdx) {
							if (tempNum > secNum) {
								secNum = tempNum;
							}
						}
					}
		
					bw.write(String.valueOf(secNum)); // 아스키코드로 출력이 돼서 String으로 변환!
		
				//	break;
				// }else{
				//	continue;
				// }
			// }
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			bw.flush();
			bw.close();
			br.close();
		}
		
	}    
}