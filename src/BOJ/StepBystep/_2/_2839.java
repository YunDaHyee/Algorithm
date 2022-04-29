package StepBystep._2;

import java.util.Scanner;

public class _2839 {

	public static void main(String[] args) {
		Scanner sc		= new Scanner(System.in);
		int totalSugar	= sc.nextInt(); // 설탕 kg
		int pocketCount	= 0;			// 봉지 개수
		
		int fiveNmg		= 0;			// 5로 나누고 나서의 나머지
		int fiveMok		= 0;			//     나눌 때 몫
		sc.close();
		/*if(totalSugar>=3 & totalSugar<=5000){
			if(totalSugar<5){
				System.out.println(-1);
				return;
			}else if(){
				pocketCount = totalSugar/5;
				
				fiveNmg		= totalSugar%5;
				switch(fiveNmg){
					case 1 :
						pocketCount++;
						break;
					default :
						pocketCount += fiveNmg/3;
						if(fiveNmg%3 != 0){
							pocketCount++;
						}
						break;
				}//switch
				System.out.println(pocketCount);
			}
		}*/
		if(totalSugar>=3 & totalSugar<=5000){
			if(totalSugar%5 == 0){
				pocketCount++; 
				return;
			}else{
				fiveMok		= totalSugar/5;
				fiveNmg		= totalSugar%5;
				pocketCount = fiveMok;
				
				switch(fiveNmg){
					case 1 :
						pocketCount++;
						System.out.println(pocketCount);
						return;
					default :
						for(int i=fiveMok; i>0; i--){
							int nmg = totalSugar - (i*5);
							if(nmg%3 == 0){
								pocketCount += nmg/3;
								System.out.println(pocketCount);
								return;
							}else{
								continue;
							}
						}
						break;
				}//switch
			}
			
			if(totalSugar%3==0){
				pocketCount += fiveNmg/3;
				System.out.println(pocketCount);
				return;
			}else{
				System.out.println(-1);
			}
		}
		return;
	}
}
