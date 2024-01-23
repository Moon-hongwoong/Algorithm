import java.util.*;

public class BOJ_1149 {
	static int[][] dp; // dp[i][0] 은 i번 째를 R색으로 칠했을 때 최소값
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		dp = new int[N][3];
		
		int[] R = new int[N];
		int[] G = new int[N];
		int[] B = new int[N];
		
		for(int i = 0; i < N; i++) {
			int red = sc.nextInt();
			R[i] = red;
			int green = sc.nextInt();
			G[i] = green;
			int blue = sc.nextInt();
			B[i] = blue;
		}
		
		dp[0][0] = R[0];
		dp[0][1] = G[0];
		dp[0][2] = B[0];
		
		for(int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + R[i];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + G[i];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + B[i];
		}
		
		int answer = Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);
		System.out.println(answer);
	}
}
