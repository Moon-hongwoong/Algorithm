import java.util.*;

public class BOJ_1991 {
	static int N;
	static int[][] tree;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		tree = new int[N][2];
		sc.nextLine(); // 개행 버림
		for (int i = 0; i < N; i++) {
			String parent = sc.next();
			String child1 = sc.next();
			String child2 = sc.next();

			tree[parent.charAt(0) - 'A'][0] = (child1.charAt(0) - 'A' == -19) ? -1 : child1.charAt(0) - 'A';
			tree[parent.charAt(0) - 'A'][1] = (child2.charAt(0) - 'A' == -19) ? -1 : child2.charAt(0) - 'A';
		}

		preOrder(0);
		sb.append('\n');
		inOrder(0);
		sb.append('\n');
		postOrder(0);
		sb.append('\n');

		System.out.println(sb);
	}

	public static void preOrder(int x) {
		if (x == -1) {
			return;
		}
		sb.append((char) (x + 'A'));
		preOrder(tree[x][0]);
		preOrder(tree[x][1]);
	}

	public static void inOrder(int x) {
		if (x == -1) {
			return;
		}
		inOrder(tree[x][0]);
		sb.append((char) (x + 'A'));
		inOrder(tree[x][1]);
	}

	public static void postOrder(int x) {
		if (x == -1) {
			return;
		}
		postOrder(tree[x][0]);
		postOrder(tree[x][1]);
		sb.append((char) (x + 'A'));
	}
}
