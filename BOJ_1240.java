import java.util.*;

public class BOJ_1240 {
	static int N, M;
	static int[][] relation;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		relation = new int[N + 1][N + 1];
		for (int i = 0; i < N - 1; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int distance = sc.nextInt();
			relation[from][to] = distance;
			relation[to][from] = distance;
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			bfs(from, to);
		}
		System.out.println(sb);
	}

	public static void bfs(int from, int to) {
		Queue<Integer> node = new LinkedList<>();
		Queue<Integer> distance = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		
		node.add(from);
		distance.add(0);

		while (!node.isEmpty()) {
			int nowNode = node.poll();
			int nowDistance = distance.poll();
			visited[nowNode] = true;
			if (nowNode == to) {
				sb.append(nowDistance).append('\n');
				return;
			}

			for (int i = 1; i < N + 1; i++) {
				if (!visited[i] && relation[nowNode][i] != 0) {
					node.add(i);
					distance.add(nowDistance + relation[nowNode][i]);
				}
			}
		}
	}
}
