package _2;

import java.util.Scanner;
/*
	문제
	두 자연수 A와 B가 주어진다. 이 때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오. 
	
	입력
	두 자연수 A와 B가 주어진다. (1 ≤ A, B ≤ 10,000)
	
	출력
	첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력한다.
*/

public class _10869 {

	public static void main(String[] args) {
		int A,B;
		String tempText;
		
		Scanner sc	= new Scanner(System.in);
        while(true){
        	tempText	= sc.nextLine();
        	if(tempText.length()==3){
		    	A			= Integer.parseInt( tempText.split("\\s")[0] );
		    	B			= Integer.parseInt( tempText.split("\\s")[1] );
		    	break;
	        }else{
	        	System.out.println("두개의 수를 하나씩 띄어쓰기 후 엔터를 누르세요");
	        	System.out.println("------------------");
	        	continue;
	        }
        }
        sc.close();
        System.out.println("------------------");
        System.out.println("A와 B : " + A+" "+B);
        System.out.println(A+B);
        System.out.println(A*B);
        System.out.println(A/B);
        System.out.println(A%B);
	}

}
