import java.util.*;

class BOJ_1939 {
	static int N, M, factory1, factory2, result;

	static class bridge {
		int to, weight;

		public bridge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	static boolean[] visited;
	static ArrayList<ArrayList<bridge>> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		int low = 0;
		int high = 0;
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int value = sc.nextInt();

			list.get(from).add(new bridge(to, value));
			list.get(to).add(new bridge(from, value));
			high = Math.max(high, value);
		}
		
		factory1 = sc.nextInt();
		factory2 = sc.nextInt();
				
		while (low <= high) {
			int mid = (low + high) / 2;
			visited = new boolean[N + 1];
			result = -1;
			dfs(factory1, mid);
			if(result != -1) {
				low = mid + 1;
				
			} else {
				high = mid - 1;
				
			}
		}
		
		System.out.println(high);
	}

	public static void dfs(int now, int limit) {
		if (now == factory2) {
			result = now;
			return;
		}
		visited[now] = true;
		for (bridge nextNode : list.get(now)) {
			if (!visited[nextNode.to] && limit <= nextNode.weight) {
				dfs(nextNode.to, limit);
			}
		}
	}
}