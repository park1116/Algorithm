import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dirX = { -1, 0, 1, 0 };
	static int[] dirY = { 0, 1, 0, -1 };
	static int[][] map;
	static int K, N;
	static Queue<Point> queue1;
	static Queue<Point> queue2;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		K = input.nextInt();
		map = new int[N][N];
		queue1 = new LinkedList<Point>();
		queue2 = new LinkedList<Point>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = input.nextInt();
				if (map[i][j] != 0) {
					queue1.add(new Point(j, i, map[i][j]));
				}
			}
		}
		int S = input.nextInt();
		int X = input.nextInt();
		int Y = input.nextInt();
		for (int i = 0; i < S; i++) {
			Queue<Point> temp = null;
			if (queue2.isEmpty())
				temp = queue1;
			else
				temp = queue2;
			multiply(temp);
		}
		System.out.println(map[X - 1][Y - 1]);
	}

	public static void multiply(Queue<Point> temp) {
		boolean flag;
		if (queue2.isEmpty())
			flag = true;
		else
			flag = false;
		for(int num = 1; num <= K; num++) {
			for (int j = 0; j < temp.size(); j++) {
				Point now = temp.poll();
				if (now.getNum() == num) {
					for (int i = 0; i < 4; i++) {
						int nx = now.getX() + dirX[i];
						int ny = now.getY() + dirY[i];
						if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
							if (map[ny][nx] == 0) {
								map[ny][nx] = num;
								if (flag)
									queue2.add(new Point(nx, ny, num));
								else
									queue1.add(new Point(nx, ny, num));
							}
						}
					}
				}
				temp.add(now);
			}
		}
		if(temp.equals(queue2)) 
			queue2.clear();
		else
			queue1.clear();
	}
}

class Point {
	int x;
	int y;
	int num;

	public Point(int x, int y, int num) {
		super();
		this.x = x;
		this.y = y;
		this.num = num;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}