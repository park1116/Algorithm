import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int N, max, min;
	static int[] arr;
	static int[] op;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		max = -1000000000;
		min = 1000000000;
		N = sc.nextInt();
		arr = new int[N];
		op = new int[4];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			op[i] = sc.nextInt();
		}
		backtracking(arr[0], 1);
		System.out.println(max);
		System.out.println(min);
	}

	public static void backtracking(int value, int idx) {
		if (idx == N) {
			if (max < value) {
				max = value;
			}
			if (min > value) {
				min = value;
			}
			return;
		}

		for (int j = 0; j < 4; j++) {
			if (op[j] > 0) {
				op[j]--;
				switch (j) {
				case 0:
					backtracking(value + arr[idx], idx + 1);
					break;
				case 1:
					backtracking(value - arr[idx], idx + 1);
					break;
				case 2:
					backtracking(value * arr[idx], idx + 1);
					break;
				case 3:
					backtracking(value / arr[idx], idx + 1);
					break;
				}
				op[j]++;
			}
		}
	}
}