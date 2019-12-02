import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	static int[][] map;
	static int count, size;
	static int[] dirX = { -1, 0, 1, 0 };
	static int[] dirY = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		size = input.nextInt();
		map = new int[size][size];
		for (int i = 0; i < size; i++) {
			String str = input.next();
			for (int j = 0; j < size; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		Vector<Integer> vector = countAll();
		int[] arr = new int[vector.size()];
		for (int i = 0; i < arr.length; i++)
			arr[i] = vector.get(i);
		Arrays.sort(arr);
		System.out.println(count);
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	// 총 단지 수를 구하는 함수
	public static Vector countAll() {
		Vector<Integer> vector = new Vector<Integer>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] == 1) {
					count++;
					map[i][j] = 0;
					vector.add(countHouse(j, i, 1));
				}
			}
		}
		return vector;
	}

	// 각 단지의 수를 구하는 함수
	public static int countHouse(int x, int y, int countH) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dirX[i];
			int ny = y + dirY[i];
			if (nx < 0 || ny < 0 || nx > size - 1 || ny > size - 1)
				continue;
			if (map[ny][nx] == 1) {
				countH++;
				map[ny][nx] = 0;
				countH = countHouse(nx, ny, countH);
			}
		}
		return countH;
	}
}