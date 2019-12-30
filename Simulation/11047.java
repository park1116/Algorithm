import java.util.Scanner;

public class Main {
	static int N, K;
	static int[] A;

	public static int counting(int value) {
		int count = N - 1;
		int result = 0;
		while (value != 0) {
			if (value >= A[count]) {
				result += value / A[count];
				value = value % A[count];
			} else
				count--;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		K = input.nextInt();
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = input.nextInt();
		}
		System.out.println(counting(K));
	}
}
