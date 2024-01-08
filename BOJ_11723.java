import java.util.*;

public class BOJ_11723 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		boolean[] set = new boolean[21];
		int M = sc.nextInt();
		
		for (int i = 0; i < M; i++) {
			String command = sc.next();
			
			if (command.equals("add")) {
				int num = sc.nextInt();
				set[num] = true;
			} else if (command.equals("remove")) {
				int num = sc.nextInt();
				set[num] = false;
			} else if (command.equals("check")) {
				int num = sc.nextInt();
				if (set[num] == true) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
			} else if (command.equals("toggle")) {
				int num = sc.nextInt();
				set[num] = !set[num];
			} else if (command.equals("all")) {
				for(int j = 1; j <= 20; j++) {
					set[j] = true;
				}
			} else {
				for(int j = 1; j <= 20; j++) {
					set[j] = false;
				}
			}
		}
		
		System.out.println(sb);
	}
}
