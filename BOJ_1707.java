import java.util.*;

public class BOJ_1707 {
	static int V, E;
	static ArrayList<ArrayList<Integer>> relation;
	static int[] colors;
	static boolean isBipartite;
	static final int RED = 1;
	static final int BLUE = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			V = sc.nextInt();
			E = sc.nextInt();
			relation = new ArrayList<>();
			colors = new int[V + 1];
			isBipartite = true;
			for (int i = 0; i <= V; i++) {
				relation.add(new ArrayList<>());
				colors[i] = 0;
			}

			for (int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				relation.get(from).add(to);
				relation.get(to).add(from);
			}
			
			for (int i = 1; i <= V; i++) {
				if(!isBipartite) {
					break;
				}
				
				if(colors[i] == 0) {
					bfs(i, RED);
				}
			}
			
			System.out.println(isBipartite ? "YES" : "NO");
		}
	}

	public static void bfs(int startNode, int color) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startNode);
		colors[startNode] = color;
		
		while(!queue.isEmpty()) {
			int nowNode = queue.poll();
			
			for(int nextNode: relation.get(nowNode)) {
				if(colors[nextNode] == 0) {
					queue.add(nextNode);
					colors[nextNode] = colors[nowNode] * -1;
				} else if(colors[nextNode] + colors[nowNode] != 0) {
					isBipartite = false;
					return;
				}
			}
		}
		
	}
}
