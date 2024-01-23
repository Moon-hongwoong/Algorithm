import java.util.*;

public class BOJ_11659 {
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		dp = new int[N + 1];
		int[] arr = new int[N + 1];
		
		dp[0] = 0;
		for(int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
			dp[i] = dp[i - 1] + arr[i];
		}
		
		for(int i = 1; i <= M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int answer = dp[end] - dp[start - 1];
			sb.append(answer).append('\n');
		}
		
		System.out.println(sb);
	}
}
