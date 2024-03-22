import java.util.*;

public class BOJ_2512 {
	static int N, total, sum;
	static int[] city;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		city = new int[N];
		for (int i = 0; i < N; i++) {
			city[i] = sc.nextInt();
			sum += city[i];
		}
		total = sc.nextInt();
		Arrays.sort(city);

		if (total >= sum) {
			System.out.println(city[N - 1]);
			return;
		}

		int low = 0;
		int high = city[N - 1];

		while (low <= high) {
			int mid = (low + high) / 2;
			sum = 0;
			for (int i = 0; i < N; i++) {
				if (mid < city[i]) {
					sum += mid;
				} else {
					sum += city[i];
				}
			}

			if (sum <= total) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		System.out.println(high);
	}
}
