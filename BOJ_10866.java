package BOJ;

import java.util.*;

public class BOJ_10866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new LinkedList<>();

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String command = sc.next();
			if (command.equals("push_back")) {
				int num = sc.nextInt();
				sc.nextLine();
				deque.addLast(num);
			} else if (command.equals("push_front")) {
				int num = sc.nextInt();
				sc.nextLine();
				deque.addFirst(num);
			} else if (command.equals("pop_front")) {
				if (!deque.isEmpty()) {
					int num = deque.pollFirst();
					sb.append(num).append('\n');
				} else {
					sb.append(-1).append('\n');
				}
			} else if (command.equals("pop_back")) {
				if (!deque.isEmpty()) {
					int num = deque.pollLast();
					sb.append(num).append('\n');
				} else {
					sb.append(-1).append('\n');
				}
			} else if (command.equals("size")) {
				sb.append(deque.size()).append('\n');
			} else if (command.equals("empty")) {
				if (deque.isEmpty()) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
			} else if (command.equals("front")) {
				if (!deque.isEmpty()) {
					int num = deque.peekFirst();
					sb.append(num).append('\n');
				} else {
					sb.append(-1).append('\n');
				}
			} else if (command.equals("back")) {
				if (!deque.isEmpty()) {
					int num = deque.peekLast();
					sb.append(num).append('\n');
				} else {
					sb.append(-1).append('\n');
				}
			}
		}
		System.out.println(sb);
	}
}
