import java.util.*;

public class BOJ_2579 {
	static int dp[]; // dp[i]= i를 밟지 않고, i번째까지 밟지 않은 값의 최소합

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int total = 0;
		int s[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			int value = sc.nextInt();
			s[i] = value;
			total += value;
		}

		if (n <= 2) {
			System.out.println(total);
		} else {
			dp = new int[n + 1];
			dp[1] = s[1];
			dp[2] = s[2];
			dp[3] = s[3];
			for (int i = 4; i <= n; i++) {
				dp[i] = Math.min(dp[i - 2], dp[i - 3]) + s[i];
			}
			int answer = total - Math.min(dp[n - 1], dp[n - 2]);
			System.out.println(answer);
		}
	}
}
