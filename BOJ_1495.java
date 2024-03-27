import java.util.*;

public class BOJ_1495 {
	static int N, S, M, answer;
	static int[] volume;
	static int[] dp; // 테이블 정의 : dp[i] = j -> j번째 연주에서 i의 volume으로 연주가 가능하다.

	public static void main(String[] args) {
		input();
		maxVolume();
	}

	public static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		M = sc.nextInt();
		volume = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			volume[i] = sc.nextInt();
		}
	}

	public static void maxVolume() {
		dp = new int[M + 1];
		Arrays.fill(dp, -1);
		dp[S] = 0;
		for (int i = 1; i < N + 1; i++) {
			List<Integer> list = new ArrayList<>();

			for (int j = 0; j < M + 1; j++) {
				if (dp[j] == i - 1) {
					int nextVolume1 = j + volume[i];
					int nextVolume2 = j - volume[i];
					if (0 <= nextVolume1 && nextVolume1 <= M) {
						list.add(nextVolume1);
					}
					if (0 <= nextVolume2 && nextVolume2 <= M) {
						list.add(nextVolume2);
					}
				}
			}
			for (int volume : list) {
				dp[volume] = i;
			}
		}

		answer = -1;
		for (int i = 0; i < M + 1; i++) {
			if (dp[i] == N) {
				answer = Math.max(answer, i);

			}
		}
		System.out.println(answer);
	}
}
