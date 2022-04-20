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
		1. 경우의 수 찾기
		경우의 수 : N명중 몇 명 고르기 : 9명 중 7명 => 9명 중에 2명 아닌 사람 찾으면 된다 => N^2 => 9C2 => 9*8/2! => 36
		2. 문제에서 주어지는 계산 시간복잡도 구하기 : 나머지 난쟁들 키의 합 고르는 데의 시간 복잡도 : N
		총 O(N^3)
		
		7
		8
		10
		13
		15
		19
		20
		23
		25
		
	@Date
		2022. 1. 16.
 */

public class _1_2309 {
	static int sum = 0;
	static int[] dwarfs = new int[9];

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for( int i=0;i<9;i++ ){
			int height = Integer.parseInt(br.readLine());
			dwarfs[i] = height;
			sum+=height; // sum = 140
		}
		
		Arrays.sort(dwarfs);
		
		/*
		1. for문
		for( int i=0;i<9;i++ ){
			for( int j=i+1;j<9;j++ ){
				if( sum - dwarfs[i] - dwarfs[j] == 100 ){ // 2개르 뺐을 때 100이 되면 그 두개가 범인이니까
					for( int k=0;k<9;k++ ){
						if( i==k||j==k ){
							continue;
						}
						System.out.println(dwarfs[k]);
					}
					System.exit(0);
				}
			}
		}
		*/
		
		// 2. for문 + 재귀
		/*for( int i=0;i<9;i++ ){
			go(i,0);
		}*/
		
		go(0,0); // 3. 오로지 재귀 호출로만
		
		br.close();
	}

	/**
	 * @param sum
	 * @param dwarfs
	 * @return
	 */
	public static void go(int first, int second) {
		if( second==9 ){
			first++;
			second=0;
		}
		
		if( sum - dwarfs[first] - dwarfs[second] == 100 ){
			for( int i=0;i<9;i++ ){
				if( first==i||second==i ){
					continue;
				}
				System.out.println(dwarfs[i]);
			}
			System.exit(0);
		}else{
			go(first,++second);
		}
		
		/*
		if( second==9 ){
			return;
		}
		
		if( sum - dwarfs[first] - dwarfs[second] == 100 ){
			for( int i=0;i<9;i++ ){
				if( first==i||second==i ){
					continue;
				}
				System.out.println(dwarfs[i]);
			}
			System.exit(0);
		}else{
			go(first,++second);
		}
 		*/
		}
}
