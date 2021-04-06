import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[] visit;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		map = new int[N + 1][N + 1];
		visit = new boolean[1001];
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			map[s][e] = map[e][s] = 1;
		}
		dfs(N, V);
		visit = new boolean[1001];
		System.out.println();
		bfs(N, V);
	}

	public static void dfs(int size, int start) {
		visit[start] = true;
		System.out.print(start + " ");
		for (int i = 1; i <= size; i++) {
			if (map[start][i] == 1 && !visit[i]) {
				dfs(size, i);
			}
		}
	}

	public static void bfs(int size, int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visit[start] = true;
		while (!q.isEmpty()) {
			int num = (int) q.poll();
			System.out.print(num + " ");
			for (int i = 1; i <= size; i++) {
				if (map[num][i] == 1 && !visit[i]) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
	}
}