package SWEA;

import java.util.*;

public class SWEA_14692 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int tc = 1; tc <= testCase; tc++) {
			int length = sc.nextInt();
			if(length % 2 == 0) {
				System.out.println("#" + tc + " " + "Alice");
			} else {
				System.out.println("#" + tc + " " + "Bob");
			}
		}
	}
}
