package Main.Simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, answer;
	static int[][] field;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int t = 0; t < T; t++) {
			answer = 0;
			M = input.nextInt();
			N = input.nextInt();
			int K = input.nextInt();
			field = new int[N][M];
			for (int i = 0; i < K; i++) {
				int x = input.nextInt();
				int y = input.nextInt();
				field[y][x] = 1;
			}
			for (int j = 0; j < N; j++) {
				for (int l = 0; l < M; l++) {
					bfs(l, j);
				}
			}
			System.out.println(answer);
		}
	}

	public static void bfs(int x, int y) {
		if (field[y][x] == 1) {
			Queue<Point> q = new LinkedList<Point>();
			field[y][x] = 0;
			q.add(new Point(x, y));
			while (!q.isEmpty()) {
				Point now = q.remove();
				for (int i = 0; i < 4; i++) {
					int nextX = now.x + dx[i];
					int nextY = now.y + dy[i];
					if (nextX < 0 || nextY < 0 || nextX > M -1|| nextY > N-1) {
						continue;
					}
					if (field[nextY][nextX] == 1) {
						field[nextY][nextX] = 0;
						q.add(new Point(nextX, nextY));
					}

				}
			}
			answer++;
		}
	}
}