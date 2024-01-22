import java.util.*;

public class BOJ_1463 {
	static int dp[]; // dp[i] = i를 1로 만드는 최소한의 횟수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		dp = new int[N + 1];
		dp[1] = 0;

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
			}
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
			}
		}

		System.out.println(dp[N]);
	}
}
