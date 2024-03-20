import java.util.*;

public class BOJ_2110 {
	static int N, C, answer;
	static int[] house;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		C = sc.nextInt();
		house = new int[N];
		
		for(int i = 0; i < N; i++) {
			house[i] = sc.nextInt();
		}
		
		Arrays.sort(house);
		
		int low = 1; // 최소 거리 = 1
		int high = house[N-1] - house[0] + 1; // 최대 거리 = 마지막 집 - 첫 집 + 1
		
		while(low < high) {
			int mid = (low + high) / 2;
			
			if(canInstall(mid) < C) { // 거리가 너무 길다면 최대 거리를 줄여야 함.
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		
		System.out.println(low - 1); // Upper Bound는 탐색 값을 초과하는 첫 번째 값이기 때문에 - 1
	}
	
	public static int canInstall(int distance) {
		int count = 1;
		int lastLocate = house[0];
		
		for(int i = 1; i < house.length; i++) {
			int locate = house[i];
			
			if(locate - lastLocate >= distance) {
				count++;
				lastLocate = locate;
			}
		}
		return count;
	}
	
}
