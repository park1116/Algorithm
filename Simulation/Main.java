package Main.Simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N, M;
	static int[][] maze;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		maze = new int[N][M];
		visited = new boolean[N][M];
		String[] str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = input.next();
			for (int j = 0; j < M; j++) {
				maze[i][j] = str[i].charAt(j) - 48;
			}
		}
		bfs(0, 0);
		System.out.println(maze[N - 1][M - 1]);
	}

	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y));
		while (!q.isEmpty()) {
			Point now = q.remove();
			for (int i = 0; i < 4; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];
				if (nextX < 0 || nextY < 0 || nextX > M - 1 || nextY > N - 1)
					continue;
				if (visited[nextY][nextX])
					continue;
				if (maze[nextY][nextX] != 0) {
					q.add(new Point(nextX, nextY));
					visited[nextY][nextX] = true;
					maze[nextY][nextX] = maze[now.y][now.x] + 1;
				}
			}
		}
	}
}