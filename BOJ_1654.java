package BOJ;

import java.util.*;

public class BOJ_1654 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt(); // �������� ������ �ִ� ������ ���� ( 1 <= K <= 10,000 )
		int N = sc.nextInt(); // �ʿ��� ������ ���� ( 1 <= N <= 1,000,000 )
		
		int[] line = new int[K];
		
		long max = 0;
		
		for (int i = 0; i < K; i++) {
			line[i] = sc.nextInt();
			if(max < line[i]) {
				max = line[i];
			}
		}
		
		max++;
		
		long min = 0;
		long mid = 0;
		
		while(min < max) {
			mid = (min + max) / 2;
			
			long count = 0;
			
			for(int i = 0; i < line.length; i++) {
				count += (line[i] / mid);
			}
			
			if(count < N) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		System.out.println(min - 1);
	}
}
