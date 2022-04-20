/**
 * 
 */
package _4_BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 	@Question
		왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다.
		일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
		아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다.
		뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
		아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
	@Input
		아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다.
		주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.
		20
		7
		23
		19
		10
		15
		25
		8
		13
	@Output
		일곱 난쟁이의 키를 오름차순으로 출력한다.
		일곱 난쟁이를 찾을 수 없는 경우는 없다.
		7
		8
		10
		13
		19
		20
		23
	@history
		N : 난쟁이 키 목록 -> 찐 난쟁이들 찾기 
		힌트 : 난쟁이 키의 합 == 100
		
		STEP 1)
		9명 중 찐난쟁 7명을 찾는 것 => 9명 중 짭난쟁 2명 찾는 거로 접근 해야함
		9C2 => 9*8/2 = 36가지의 경우의 수.
		사람이 직접 구할 수 있는 수인만큼 그렇게 안 큰 숫자이므로 브루트포스로 풀기 가능
		
		STEP 2)
		난쟁이 수 N * 짭난쟁이 2명 찾기 N^2 => O(N^3)  
		
		다 더했을 때 140이고 거기서 100 뺀 값 == 난쟁이 2명의 키의 합
		=> 그 두 난쟁이 범인이므로 빼고 출력함.
		
		처음에는 4/19 어제 풀었던 프로그래머스/구명보트 문제의 접근 방식이랑 비슷한 것 같아서
		이중포문이 아닌 반복문 1개로 돌릴 수 있는 방법을 꾀해봤는데 잘 안되길래 이중포문으로 구현했다.
		다 풀고나서 뭔가 아쉬운 맘에 반복문 1개로 다시 구현해밨더니 잘 풀렸다.
		
		근데 이중포문이든 단독포문이든 시간은 비슷하다.
		
		
	@Date
		2022. 4. 20.
 */

public class _1_2309_v2 {
	static int sum,tempSum;
	static int[] dwarfs = new int[9];

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for( int i=0;i<9;i++ ) {
			int dwarf = Integer.parseInt(br.readLine());
			dwarfs[i] = dwarf;
			tempSum += dwarf; 
		}
		
		br.close();
		
		Arrays.sort(dwarfs);
		
		StringBuilder result = new StringBuilder();
		
		/*
		// 1-1. for 문 - 이중
		for( int i=8;i>=0;i-- ) {
			for( int j=0;j<i;j++ ) {
				if( (dwarfs[i]+dwarfs[j])==(tempSum-100) ){
					for( int k=0;k<9;k++ ) {
						if( k!=i&&k!=j ) {
							result.append(dwarfs[k]);
							result.append("\n");
						}
					}
					System.out.println(result.toString());
					System.exit(0);
				}
			}
		}*/
		
		// 1-2. for문 - 단독
		for( int i=0,j=8;j>0; ) {
			if( (dwarfs[i]+dwarfs[j])==(tempSum-100) ){
				for( int k=0;k<9;k++ ) {
					if( k!=i&&k!=j ) {
						result.append(dwarfs[k]);
						result.append("\n");
					}
				}
				System.out.println(result.toString());
				System.exit(0);
			}
			
			if( i==7 ) {
				--j;
				i=0;
				continue;
			}
			
			i++;
		}
		
		
		// 2. 재귀
		//getDwarfs( 0, 8 );
	}
	
	static void getDwarfs( int i,int j ) {
		if( i==9 ){
			i=0;
			j--;
		}
		
		if( (dwarfs[i]+dwarfs[j])==(tempSum-100) ){
			for( int k=0;k<9;k++ ) {
				if( i!=k&&j!=k ) {
					System.out.println( dwarfs[k] );
				}
			}
			System.exit(0);
		}
		
		getDwarfs( ++i, j );
	}
	
}
