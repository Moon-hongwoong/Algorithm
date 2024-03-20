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
		
		int low = 1; // �ּ� �Ÿ� = 1
		int high = house[N-1] - house[0] + 1; // �ִ� �Ÿ� = ������ �� - ù �� + 1
		
		while(low < high) {
			int mid = (low + high) / 2;
			
			if(canInstall(mid) < C) { // �Ÿ��� �ʹ� ��ٸ� �ִ� �Ÿ��� �ٿ��� ��.
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		
		System.out.println(low - 1); // Upper Bound�� Ž�� ���� �ʰ��ϴ� ù ��° ���̱� ������ - 1
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
