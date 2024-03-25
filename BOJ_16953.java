import java.util.*;

public class BOJ_16953 {
	static int A, B;
	static boolean[] visited;
	static int answer = -1;

	public static void main(String[] args) {
		input();
		bfs();
		System.out.println(answer);
	}

	public static void input() {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		visited = new boolean[B + 1];
	}

	public static void bfs() {
		Queue<Integer> number = new LinkedList<>();
		Queue<Integer> count = new LinkedList<>();

		number.add(A);
		count.add(1);
		visited[A] = true;
		while (!number.isEmpty()) {
			int nowNumber = number.poll();
			int nowCount = count.poll();

			if (nowNumber == B) {
				answer = nowCount;
				return;
			}
			if (nowNumber * 2 <= B && !visited[nowNumber * 2]) {
				number.add(nowNumber * 2);
				count.add(nowCount + 1);
				visited[nowNumber * 2] = true;
			}
			if (nowNumber * 10 + 1 <= B && !visited[nowNumber * 10 + 1]) {
				number.add(nowNumber * 10 + 1);
				count.add(nowCount + 1);
				visited[nowNumber * 10 + 1] = true;
			}
		}
	}
}
