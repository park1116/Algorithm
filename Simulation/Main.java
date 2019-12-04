import java.util.Scanner;

public class Main {
	static boolean[] visited;
	static int[] arr, result;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = -1;
		while (N != 0) {
			N = input.nextInt();
			arr = new int[N];
			visited = new boolean[N];
			result = new int[6];
			for (int i = 0; i < N; i++) {
				arr[i] = input.nextInt();
			}
			dfs(0, 0);
			System.out.println();
		}
	}

	public static void dfs(int start, int count) {
		if (count == 6) {
			for (int i : result)
				System.out.print(i + " ");
			System.out.println();
			return;
		}
		for (int i = start; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[count] = arr[i];
				count++;
				dfs(i + 1, count);
				visited[i] = false;
				count--;
			}
		}
	}
}