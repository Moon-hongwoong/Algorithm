import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9466 {
	static int t, n, find, answer;
	static int[] relation;
	static boolean[] isTeam, visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			relation = new int[n + 1];
			visited = new boolean[n + 1];
			isTeam = new boolean[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				relation[i] = Integer.parseInt(st.nextToken());
			}
		
			answer = 0;
			for (int i = 1; i <= n; i++) {
				find = i;
				
				if (!isTeam[i]) {
					canTeam(i);
				}
			}

			answer = n - answer;
			sb.append(answer).append('\n');
		}

		System.out.print(sb);
	}

	public static void canTeam(int now) {
		if (visited[now]) {
			isTeam[now] = true;
			answer++;
		} else {
			visited[now] = true;
		}

		if (!isTeam[relation[now]]) {
			canTeam(relation[now]);
		}

		visited[now] = false;
		isTeam[now] = true;
	}
}