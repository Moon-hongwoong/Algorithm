import java.util.*;

public class BOJ_11726 {
	static int[] dp; // dp[i] = 2 * i 를 만들 수 있는 경우의 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		if (n <= 2) {
			System.out.println(n);
		} else {
			dp = new int[n + 1];
			dp[1] = 1;
			dp[2] = 2;
			for (int i = 3; i <= n; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
			}
			System.out.println(dp[n]);
		}

	}
}
