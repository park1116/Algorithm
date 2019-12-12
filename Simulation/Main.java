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
	static int result;
	static boolean popCheck;
	static int[] xDir = { -1, 0, 1, 0 };
	static int[] yDir = { 0, 1, 0, -1 };
	static char[][] map = new char[12][6];

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 12; i++) {
			String str = input.next();
			for (int j = 0; j < 6; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		search();
		System.out.println(result);
	}

	// ����� ��ȸ�ϴ� �Լ�
	public static void search() {
		for (int i = 11; i >= 0; i--) {
			for (int j = 0; j < 6; j++) {
				pop(j, i);
			}
		}
		if (popCheck) {
			result++;
			popCheck = false;
			drop();
			search();
		} else
			return;
	}

	// 4���� ���� �� ����� �ִٸ� ������ �Լ�
	public static void pop(int sx, int sy) {
		boolean[][] visited = new boolean[12][6];
		Queue<Point> q = new LinkedList<Point>();
		Queue<Point> save = new LinkedList<Point>();
		visited[sy][sx] = true;
		q.add(new Point(sx, sy));
		save.add(new Point(sx, sy));
		while (!q.isEmpty()) {
			Point p = q.remove();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + xDir[i];
				int ny = p.y + yDir[i];
				if (nx < 0 || ny < 0 || nx >= 6 || ny >= 12)
					continue;
				if (!visited[ny][nx] && map[p.y][p.x] != '.'
						&& map[ny][nx] == map[p.y][p.x]) {
					visited[ny][nx] = true;
					q.add(new Point(nx, ny));
					save.add(new Point(nx, ny));
				}
			}
		}
		if (save.size() >= 4) {
			while (!save.isEmpty()) {
				Point p = save.remove();
				map[p.y][p.x] = '.';
			}
			popCheck = true;
		}
	}

	// �������� ����� �Ʒ��� �������� �Լ�
	public static void drop() {
		for (int i = 11; i >= 0; i--) {
			for (int j = 0; j < 6; j++) {
				if (map[i][j] == '.') {
					for (int k = i; k >= 0; k--) {
						if (map[k][j] != '.') {
							map[i][j] = map[k][j];
							map[k][j] = '.';
							break;
						}
					}
				}
			}
		}
	}
}