import java.util.*;

public class BOJ_1260 {
	static StringBuilder sb = new StringBuilder();
	static int N, M, V;
	static boolean[][] relation;
	static boolean[] visited;
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 정점의 개수
		M = sc.nextInt(); // 간선의 개수
		V = sc.nextInt(); // 탐색 시작 정점
		relation = new boolean[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			relation[from][to] = true;
			relation[to][from] = true;
		}

		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N + 1];
		bfs(V);
		
		System.out.println(sb);
		sc.close();
	}

	public static void dfs(int startNode) {
		visited[startNode] = true;
		sb.append(startNode).append(" ");

		for (int i = 1; i <= N; i++) {
			if(relation[startNode][i] && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int startNode) {
		Queue<Integer> queue = new LinkedList<>();
		visited[startNode] = true;
		queue.add(startNode);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now).append(" ");
			for(int i = 1; i <= N; i++) {
				if(relation[now][i] && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
