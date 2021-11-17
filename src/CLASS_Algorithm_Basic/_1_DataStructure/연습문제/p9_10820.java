package _1_DataStructure.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**

@문제
	문자열 N개가 주어진다.
	이때, 문자열에 포함되어 있는 소문자, 대문자, 숫자, 공백의 개수를 구하는 프로그램을 작성하시오.
	각 문자열은 알파벳 소문자, 대문자, 숫자, 공백으로만 이루어져 있다.
@입력
	첫째 줄부터 N번째 줄까지 문자열이 주어진다. (1 ≤ N ≤ 100) 문자열의 길이는 100을 넘지 않는다.
	This is String
	SPACE    1    SPACE
	 S a M p L e I n P u T     
	0L1A2S3T4L5I6N7E8
@출력
	첫째 줄부터 N번째 줄까지 각각의 문자열에 대해서 소문자, 대문자, 숫자, 공백의 개수를 공백으로 구분해 출력한다.
	10 2 0 2
	0 10 1 8
	5 6 0 16
	0 8 9 0
@HISTORY
	eof 26
	공백 32(=97-65)
	숫자 48~57 
	대문자 65~90
	소문자 97~122
	
	자꾸 NullPointerException만 10번 정도 나길래 뭔가 했더니
	null 검증을 안해서였다..ㅡㅡ
 */
public class p9_10820 {
	public static void main(String args[]) throws IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter	bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String			raw		= null;
		StringBuilder	result	= new StringBuilder();
		
		while( (raw = br.readLine())!=null ){
			int[]	counts	= new int[4];
			
			for( char word : raw.toCharArray()){
				if( word==26 ){
					break;
				}else if( word<123 && word>96 ){
					counts[0]++;
				}else if( word<91 && word>64 ){
					counts[1]++;
				}else if( word<58 && word>47 ){
					counts[2]++;
				}else if( word==32 ){
					counts[3]++;
				}
			}
			for( int count : counts ){
				result.append(count+" ");
			}
			result.append("\r");
		}
		
		bw.write(result.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
}

