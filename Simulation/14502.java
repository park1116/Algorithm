import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, result;
	static int[][] map;
	static int[][] wallMap;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		result = -1;
		map = new int[N][M];
		wallMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dfs(0);
		System.out.println(result);
	}

	public static void dfs(int wall) {
		if (wall == 3) {
			bfs();
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(wall + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	public static void bfs() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				wallMap[i][j] = map[i][j];
			}
		}

		Queue<Integer> queueX = new LinkedList<Integer>();
		Queue<Integer> queueY = new LinkedList<Integer>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (wallMap[i][j] == 2) {
					queueX.add(j);
					queueY.add(i);
				}
			}
		}
		while (!queueX.isEmpty() && !queueY.isEmpty()) {
			int x = queueX.remove();
			int y = queueY.remove();
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
					if (wallMap[ny][nx] == 0) {
						wallMap[ny][nx] = 2;
						queueX.add(nx);
						queueY.add(ny);
					}
				}
			}
		}
		safeCheck();
	}

	public static void safeCheck() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (wallMap[i][j] == 0) {
					count++;
				}
			}
		}
		result = Math.max(result, count);
	}
}