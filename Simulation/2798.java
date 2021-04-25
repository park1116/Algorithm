import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(blackJack());
	}

	public static int blackJack() {
		int result = 0;
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int temp = arr[i]+arr[j]+arr[k];
					if(temp == M)
						return temp;
					if(temp < M && result < temp)
						result = temp;
				}
			}
		}
		return result;
	}
}