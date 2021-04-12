import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[][] visit;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int y = 0; y < N; y++) {
			String arr = sc.next();
			for (int x = 0; x < M; x++) {
				map[y][x] = arr.charAt(x) - 48;
			}
		}
		count(0, 0);
		System.out.println(map[N - 1][M - 1]);
	}

	public static void count(int x, int y) {
		Queue<Integer> queueX = new LinkedList<Integer>();
		Queue<Integer> queueY = new LinkedList<Integer>();
		queueX.add(x);
		queueY.add(y);
		while (!queueX.isEmpty() && !queueY.isEmpty()) {
			int nowX = queueX.poll();
			int nowY = queueY.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				if (nextX < map[0].length && nextY < map.length && nextX >= 0 && nextY >= 0) {
					if (map[nextY][nextX] != 0 && !visit[nextY][nextX]) {
						queueX.add(nextX);
						queueY.add(nextY);
						visit[nextY][nextX] = true;
						map[nextY][nextX] = map[nowY][nowX] + 1;
					}
				}
			}
		}
	}
}