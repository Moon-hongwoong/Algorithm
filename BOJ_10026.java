import java.util.*;

public class BOJ_10026 {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int answer1, answer2;
	static int[] deltaRow = { 0, 0, -1, 1 };
	static int[] deltaCol = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new char[N][N];

		sc.nextLine(); // 개행 버림
		for (int i = 0; i < N; i++) {
			String color = sc.nextLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = color.charAt(j);
			}
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs1(i, j, map[i][j]);
					answer1++;
				}
			}
		}
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs2(i, j, map[i][j]);
					answer2++;
				}
			}
		}
		
		System.out.println(answer1 + " " + answer2);
	}

	public static void dfs1(int row, int col, char color) {
		visited[row][col] = true;
		for (int i = 0; i < 4; i++) {
			int newRow = row + deltaRow[i];
			int newCol = col + deltaCol[i];

			if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= N || visited[newRow][newCol]) {
				continue;
			}

			if (color != map[newRow][newCol]) {
				continue;
			}

			dfs1(newRow, newCol, color);
	
		}
		return;
	}
	
	public static void dfs2(int row, int col, char color) {
		visited[row][col] = true;
		for (int i = 0; i < 4; i++) {
			int newRow = row + deltaRow[i];
			int newCol = col + deltaCol[i];

			if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= N || visited[newRow][newCol]) {
				continue;
			}
			
			if(color == 'B') {
				if(map[newRow][newCol] != 'B') {
					continue;
				}
			} else {
				if(map[newRow][newCol] == 'B') {
					continue;
				}
			}
			
			dfs2(newRow, newCol, color);
	
		}
		return;
	}
}
