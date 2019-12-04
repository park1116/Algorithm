import java.util.Scanner;

public class Main {

	static int N, M;

	static int[] arr;

	static boolean[] visited;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		N = input.nextInt();

		M = input.nextInt();

		arr = new int[M + 1];

		visited = new boolean[N + 1];

		backtracking(1, 1);

	}

	// 1 ~ N 까지 숫자를 넣는 함수

	static void backtracking(int start, int order) {

		if (order == arr.length) {

			result(arr);

			return;

		}

		for (int i = start; i <= N; i++) {

			if (!visited[i]) {

				arr[order] = i;

				visited[i] = true;

				backtracking(i + 1, order + 1);

				visited[i] = false;

			}

		}

	}

	// M 개의 숫자만 출력하는 함수

	static void result(int[] arr) {

		for (int i = 1; i < arr.length; i++) {

			System.out.print(arr[i] + " ");

		}

		System.out.println();

	}

}