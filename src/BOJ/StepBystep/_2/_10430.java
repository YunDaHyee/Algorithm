package _2;

import java.util.Scanner;

public class _10430 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A=0,B=0,C=0;
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		sc.close();
		
		System.out.println( (A+B)%C );
		System.out.println( (A%C + B%C)%C );
		System.out.println( (A*B)&C );
		System.out.println( (A%C * B%C)%C );
	}

}
