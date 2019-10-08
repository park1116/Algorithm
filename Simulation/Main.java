package Main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean[] flag = new boolean[10];
	static int[] hitter = new int[10];
	static int nextHitter;
	static int N;
	static int[][] arr;
	static int answer;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		arr = new int[N][9];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = input.nextInt();
			}
		}
		dfs(0);
		System.out.println(answer);
	}

	public static void dfs(int cnt) {
		if (cnt == 9) {
			int tmp = play();
			if (answer < tmp) {
				answer = tmp;
			}
			return;
		} else if (cnt == 3) {
			hitter[cnt] = 0;
			flag[0] = true;
			dfs(cnt + 1);
			flag[0] = false;
		} else {
			for (int i = 1; i < 9; i++) {
				if (!flag[i]) {
					flag[i] = true;
					hitter[cnt] = i;
					dfs(cnt + 1);
					flag[i] = false;
				}
			}
		}
	}

	public static int play() {
		int score = 0;
		int i = 0;
		boolean[] base = new boolean[3];
		for (int inning = 0; inning < N; inning++) {
			int out = 0;
			Arrays.fill(base, false);
			while (true) {
				if (i == 9)
					i = 0;
				int now = arr[inning][hitter[i]];
				if (now == 0) {
					out++;
					if (out == 3) {
						i++;
						break;
					}
				} else if (now == 1) {
					if (base[2]) {
						base[2] = false;
						score++;
					}
					if (base[1]) {
						base[2] = true;
						base[1] = false;
					}
					if (base[0]) {
						base[1] = true;
					}
					base[0] = true;
				} else if (now == 2) {
					if (base[2]) {
						base[2] = false;
						score++;
					}
					if (base[1]) {
						score++;
					}
					if (base[0]) {
						base[2] = true;
						base[0] = false;
					}
					base[1] = true;
				} else if (now == 3) {
					if (base[2]) {
						score++;
					}
					if (base[1]) {
						base[1] = false;
						score++;
					}
					if (base[0]) {
						base[0] = false;
						score++;
					}
					base[2] = true;
				} else if (now == 4) {
					for (int j = 2; j >= 0; j--) {
						if (base[j]) {
							score++;
							base[j] = false;
						}
					}
					score++;
				}
				i++;
			}
		}
		return score;
	}
}