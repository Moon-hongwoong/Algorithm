package SWEA;

import java.util.*;

public class SWEA_7728 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine();
		
		for (int tc = 1; tc <= testCase; tc++) {
			String number = sc.nextLine();
			boolean[] vary = new boolean[10];
			int count = 0;
			
			for (int i = 0; i < number.length(); i++) {
				int num = number.charAt(i) - '0';
				if(!vary[num]) {
					vary[num] = true;
					count++;
				}
				if(count == 10) {
					break;
				}
			}
			
			System.out.println("#" + tc + " " + count);
		}

	}
}
