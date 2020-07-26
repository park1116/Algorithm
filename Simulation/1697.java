import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int K = input.nextInt();
		if (N >= K)
			System.out.println(N - K);
		else
			System.out.println(move(N, K));
	}

	public static int move(int N, int K) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] second = new int[100001];
		queue.add(N);
		second[N] = 1;
		while (!queue.isEmpty()) {
			int now = queue.remove();
			for (int i = 0; i < 3; i++) {
				int next;
				if (i == 0)
					next = now - 1;
				else if (i == 1)
					next = now + 1;
				else
					next = now * 2;
				if (next == K) {
					return second[now];
				}
				if (0 <= next && next <= 100000) {
					if (second[next] == 0) {
						second[next] = second[now] + 1;
						queue.add(next);
					}
				}
			}
		}
		return 0;
	}
}