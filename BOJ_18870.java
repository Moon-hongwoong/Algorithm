import java.util.*;

public class BOJ_18870 {
	static int N;
	static int[] arr, copyArr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		N = sc.nextInt();
		arr = new int[N];
		copyArr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = copyArr[i] = sc.nextInt();
		}

		Arrays.sort(copyArr);
		HashMap<Integer, Integer> rank = new HashMap<>();
		int num = 0;
		for(int i = 0; i < N; i++) {
			if(!rank.containsKey(copyArr[i])) {
				rank.put(copyArr[i], num);
				num++;
			}
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(rank.get(arr[i])).append(' ');
		}
		
		System.out.println(sb);

	}
}
