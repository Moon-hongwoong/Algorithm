import java.util.*;

public class BOJ_1543 {
	static String str;
	static String find;
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		str = sc.nextLine();
		find = sc.nextLine();

		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			for (int j = 0; j < find.length(); j++) {
				if (i + find.length() > str.length()) {
					break;
				}
				if (find.charAt(j) == str.charAt(i + j)) {
					count++;
				}
			}
			if (count == find.length()) {
				answer++;
				i = i + find.length() - 1;
			}
		}

		System.out.println(answer);
	}
}
