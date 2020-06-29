import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static int[] result;
	static int M;
	static int N;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		arr = new int[N];
		result = new int[M];
		for (int i = 0; i < N; i++) {
			arr[i] = input.nextInt();
		}
		Arrays.sort(arr);
		dfs(0,0);
	}

	// dfs
	public static void dfs(int num, int start) {
		if (num == M) {
			resultArray();
			return;
		}
		for (int i = start; i < N; i++) {
			result[num] = arr[i];
			dfs(num + 1, i);
		}
	}

	// 배열을 출력하는 함수
	public static void resultArray() {
		for (int i = 0; i < M; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}
}