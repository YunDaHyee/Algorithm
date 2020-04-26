package Graph.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 
 	@Question
		정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다.
		(그림)
		섬의 개수를 세는 프로그램을 작성하시오.
		한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다. 
		두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다.
		지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.
		
	@Input
		입력은 여러 개의 테스트 케이스로 이루어져 있다.
		각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다.
		w와 h는 50보다 작거나 같은 양의 정수이다.
		둘째 줄부터 h개 줄에는 지도가 주어진다.
		1은 땅, 0은 바다이다.
		입력의 마지막 줄에는 0이 두 개 주어진다.
		1 1
		0
		2 2
		0 1
		1 0
		3 2
		1 1 1
		1 1 1
		5 4
		1 0 1 0 0
		1 0 0 0 0
		1 0 1 0 1
		1 0 0 1 0
		5 4
		1 1 1 0 1
		1 0 1 0 1
		1 0 1 0 1
		1 0 1 1 1
		5 5
		1 0 1 0 1
		0 0 0 0 0
		1 0 1 0 1
		0 0 0 0 0
		1 0 1 0 1
		0 0
		
	@Output
		각 테스트 케이스에 대해서, 섬의 개수를 출력한다.
		0
		1
		1
		3
		1
		9
		
	@history
		경로 얘기 있으니까 '그래프구나?' 하는 생각 가져보기.
		
 */
public class _4963 {
	// 좌표 - 상하좌우,좌상대/우상대/좌하대/우하대... 아 위에가 +1이구나..
	public static int[] dx = { 0,0,-1,1, -1,1,-1,1 };
	public static int[] dy = { 1,-1,0,0, 1,1,-1,-1 };
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		StringTokenizer st = new StringTokenizer( br.readLine() );
		int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
		
		int[][] mapMatrix = new int[h][h];
		
		// 값 초기화
		for( int i=0;i<h;i++ ){
			String line = br.readLine();
			for( int j=0;j<h;j++ ){
				mapMatrix[i][j] = Integer.parseInt( String.valueOf(line.charAt(i)) );
			}
		}
		
		
		
		br.close();
		bw.flush();
		bw.close();
	}
}
