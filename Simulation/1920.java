import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] A, arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		M = sc.nextInt();
		arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(A);
		for (int i = 0; i < M; i++) {
			System.out.println(check(i));
		}
	}

	public static int check(int idx) {
		int start = 0;
		int end = N - 1;
		if(arr[idx] < A[start] || arr[idx] > A[end])
			return 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == arr[idx]) {
				return 1;
			} else if (A[mid] < arr[idx]) {
				start = mid + 1;
			} else if(A[mid] > arr[idx]) {
				end = mid - 1;
			}
		}
		return 0;
	}
}