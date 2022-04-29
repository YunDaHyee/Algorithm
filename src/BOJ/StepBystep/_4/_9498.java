package StepBystep._4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

/**
	@Question
		시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
	@Input
		첫째 줄에 시험 점수가 주어진다. 시험 점수는 0보다 크거나 같고, 100보다 작거나 같은 자연수이다.
		100
	@Output
		시험 성적을 출력한다.
		A
	@history
		어려움이 없었따!
	@author dada
 */
public class _9498 {
	public static void main(String[] args) throws IOException {
		String 			scoreSt	= "";
		String			grade	= "";
		Pattern			pt		= Pattern.compile("\\d");
		BufferedReader	br		= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw		= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		try{
			while(true){
				scoreSt = br.readLine();
				if( pt.matcher(scoreSt).find() ){
					int score = Integer.parseInt(scoreSt);
					
					if( score >= 90 && score <= 100 ){
						grade = "A";
					}else if( score >= 80 && score <= 89 ){
						grade = "B";
					}else if( score >= 70 && score <= 79 ){
						grade = "C";
					}else if( score >= 60 && score <= 69 ){
						grade = "D";
					}else{
						grade = "F";
					}
					
					bw.write(grade);
					
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