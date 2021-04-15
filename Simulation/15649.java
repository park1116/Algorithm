import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M + 1];
		visit = new boolean[N + 1];
		backtracking(1);
	}

	public static void backtracking(int num) {
		if (num - 1 == M) {
			result();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				arr[num] = i;
				visit[i] = true;
				backtracking(num + 1);
				visit[i] = false;
			}
		}
	}

	public static void result() {
		for (int i = 1; i <= M; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}