package Main.Simulation;

import java.util.Scanner;

public class Main {
	static int N, answer;
	static boolean[][] exist;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		exist = new boolean[N][N];
			queen(0);
		
		System.out.println(answer);
	}

	// queen�� ���� ��ġ �Լ�
	public static void queen(int row) {
		for (int j = 0; j < N; j++) {
			if (check(row, j)) {
				if (row == N - 1) {
					answer++;
					return;
				}
				exist[row][j] = true;
				queen(row + 1);
				exist[row][j] = false;
			}
		}

	}

	// queen�� ���� �� �ִ��� Ȯ���ϴ� �Լ�
	public static boolean check(int row, int col) {
		if (checkH(row, col) && checkL(row, col) && checkR(row, col))
			return true;
		return false;
	}

	// ���� Ȯ��
	public static boolean checkH(int row, int col) {
		int i = row;
		while (i > 0) {
			i--;
			if (exist[i][col])
				return false;
		}
		return true;
	}

	// ���� �밢�� Ȯ��
	public static boolean checkL(int row, int col) {
		int i = row;
		int j = col;
		while (i > 0 && j > 0) {
			i--;
			j--;
			if (exist[i][j])
				return false;
		}
		return true;
	}

	// ���� �밢�� Ȯ��
	public static boolean checkR(int row, int col) {
		int i = row;
		int j = col;
		while (i > 0 && j < N - 1) {
			i--;
			j++;
			if (exist[i][j])
				return false;
		}
		return true;
	}
}