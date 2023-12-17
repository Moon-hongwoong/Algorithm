package BOJ;

import java.util.*;

public class BOJ_2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int result1 = gcd(num1, num2);
		System.out.println(result1);
		System.out.println(num1 * num2 / result1);
	}
	
	public static int gcd(int num1, int num2) {
		if(num2 == 0) {
			return num1;
		}
		
		return gcd(num2, num1 % num2);
	}
}
