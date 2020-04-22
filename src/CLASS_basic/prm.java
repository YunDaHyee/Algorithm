import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
	문제 설명
		문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
		s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
		
	제한 사항
		str은 길이 1 이상인 문자열입니다.
		
	입출력 예
		s	return
	Zbcdefg	gfedcbZ
	bcdefgZ

 */
public class prm {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = "Zbcdefg";
		char[] newS = new char[s.length()];
		for( int i=0;i<s.length();i++ ) {
			newS[i] = s.charAt(i);
		}
		
		int cnt = -1;
		while( cnt++<s.length() ) {
		//for( int i=0;i<s.length();cnt++ ) {
			int k = 0;
			char c = newS[0];
			for( int j=0;j<s.length()-cnt;j++ ) {
				char nextC = newS[j];
				if( c < nextC ) {
					newS[j] = c;
					newS[k] = nextC;
					k = j;
				}
			}
		}
		
		String dd = "";
		for( int i=0;i<newS.length;i++ ) {
			dd+= newS[i];
		}
		
		bw.write(dd);
		
		br.close();
		bw.flush();
		bw.close();
	}
}
