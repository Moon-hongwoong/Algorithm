import java.util.*;

public class BOJ_9095 {
	static int dp[] = new int[11]; // dp[i] = i를 1, 2, 3의 합으로 나타낼 수 있는 경우의 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i <= 10; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			sb.append(dp[n]).append('\n');
		}
		
		System.out.println(sb);
	}
}
