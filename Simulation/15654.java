import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static int[] result;
	static int M;
	static int N;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		M = input.nextInt();
		N = input.nextInt();
		arr = new int[M];
		visited = new boolean[M];
		result = new int[N];
		for (int i = 0; i < M; i++) {
			arr[i] = input.nextInt();
		}
		Arrays.sort(arr);
		dfs(0);
	}

	// dfs
	public static void dfs(int num) {
		if (num == N) {
			resultArray(result);
			return;
		}
		for (int i = 0; i < M; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[num] = arr[i];
				dfs(num + 1);
				visited[i] = false;
			}
		}
	}

	// 배열을 출력하는 함수
	public static void resultArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}