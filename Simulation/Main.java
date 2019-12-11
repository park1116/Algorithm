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
	static int H;
	static int W;
	static int max = -1;
	static int[] xDir = { -1, 0, 1, 0 };
	static int[] yDir = { 0, 1, 0, -1 };
	static char[][] map;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		H = input.nextInt();
		W = input.nextInt();
		map = new char[H][W];
		for (int i = 0; i < H; i++) {
			String str = input.next();
			for (int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		settingStart();
		System.out.println(max);
	}

	// 맵에서 처음부터 끝까지 출발하는 지점 정하는 함수
	public static void settingStart() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'L') {
					bfs(j, i);
				}
			}
		}
	}

	// 출발점에서 가장 멀리있는 지점까지 걸리는 시간
	public static void bfs(int sx, int sy) {
		int result = 0;
		int[][] time = new int[H][W];
		boolean[][] visited = new boolean[H][W];
		Queue<Point> q = new LinkedList<Point>();
		visited[sy][sx] = true;
		q.add(new Point(sx, sy));
		while (!q.isEmpty()) {
			Point p = q.remove();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + xDir[i];
				int ny = p.y + yDir[i];
				if (nx < 0 || ny < 0 || nx >= W || ny >= H)
					continue;
				if (!visited[ny][nx] && map[ny][nx] == 'L') {
					visited[ny][nx] = true;
					time[ny][nx] = time[p.y][p.x] + 1;
					q.add(new Point(nx, ny));
				}
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				result = time[i][j];
				if (max < result)
					max = result;
			}
		}
	}
}