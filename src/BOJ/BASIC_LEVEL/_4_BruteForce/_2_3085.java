/**
 * 
 */
package Basic_Level._4_BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 	@Question
		상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.
		가장 처음에 N×N크기에 사탕을 채워 놓는다.
		사탕의 색은 모두 같지 않을 수도 있다.
		상근이는 사탕의 색이 다른 인접한 두 칸을 고른다.
		그 다음 고른 칸에 들어있는 사탕을 서로 교환한다.
		이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.
		사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.
		
	@Input
		첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)
		다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다.
		빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.
		사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.
		1.
			3
			CCP
			CCP
			PPC
		2.
			4
			PPPP
			CYZY
			CCPY
			PPCC
		3.
			5
			YCPZY
			CYZZP
			CCPPP
			YCYZC
			CPPZZ
			
	@Output
		첫째 줄에 상근이가 먹을 수 있는 사탕의 최대 개수를 출력한다.
		1. 3
		2. 4
		3. 4
	@history
		
	@Date
		2022. 1. 16.
 */

public class _2_3085 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dx = {-1,1,0,0}, dy = {0,0,1,-1};
		
		int boardSize = Integer.parseInt(br.readLine());
		String[][] candyColors = new String[boardSize][boardSize];
		boolean[][] fixFlag = new boolean[boardSize][boardSize];
		
		int ableEatingCount = 0; // 먹을 수 있는 수
		
		// 사탕 놓기
		for( int i=0;i<boardSize;i++ ){
			candyColors[i] = br.readLine().split("{0}");
		}
		
		// TODO 가장 긴 연속인 거를 찾아야 하니까 사탕교환 하면서 연속인 최대 수를 찾아야함 - 다시풀기
		// 사탕 교환
		for( int i=0;i<boardSize;i++ ){
			int sequence = 0;
			for( int j=0;j<boardSize;j++ ){
				int sideSameCount = 0;
				for( int k=0;k<4;k++ ){
					int sideX = i+dx[k], sideY = j+dy[k];
					if( sideX>=0 && sideX<boardSize && sideY>=0 && sideY<boardSize ){
						String currentColor = candyColors[i][j];
						String sideColor = candyColors[sideX][sideY];
						if( !fixFlag[i][j] && !fixFlag[sideX][sideY] && !currentColor.equals(sideColor) ){ // 색깔이 다르면 교환
							candyColors[i][j] = sideColor;
							candyColors[sideX][sideY] = currentColor;
						}else{
							sideSameCount++;
						}
						if( sideSameCount>=2 ){
							fixFlag[i][j] = true;
						}
					}
				}
			}
			
			if( sequence==boardSize-1 ){ // 먹을 수 있는 거 챙기기
				ableEatingCount+=boardSize;
			}
		}
		
		System.out.println(ableEatingCount);
	}
}