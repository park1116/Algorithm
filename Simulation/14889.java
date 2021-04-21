import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		backtracking(0, 0);
		System.out.println(min);
	}

	public static void backtracking(int idx, int count) {
		if (count == N / 2) {
			score();
			return;
		}
		for (int i = idx; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				backtracking(i + 1, count + 1);
				visit[i] = false;
			}
		}
	}

	public static void score() {
		int sScore = 0;
		int lScore = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visit[i] && visit[j]) {
					sScore += arr[i][j];
					sScore += arr[j][i];
				} else if (!visit[i] && !visit[j]) {
					lScore += arr[i][j];
					lScore += arr[j][i];
				}
			}
		}

		int val = Math.abs(sScore - lScore);

		if (val == 0) {
			System.out.println(val);
			System.exit(0);
		}

		min = Math.min(val, min);
	}
}