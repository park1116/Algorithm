import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] A;
	static int[] B;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int S = 0;
		A = new int[N];
		B = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = input.nextInt();
		}
		for (int i = 0; i < N; i++) {
			B[i] = input.nextInt();
		}
		S = sortAsc(N);
		System.out.println(S);
	}

	// 작은 값부터 큰 값으로 정렬후 계산하기
	public static int sortAsc(int size) {
		int[] arr = new int[size];
		int result = 0;
		for (int i = 0; i < size; i++) {
			arr[i] = B[i];
		}
		Arrays.sort(arr);
		Arrays.sort(A);
		for (int i = 0; i < size; i++) {
			result += A[i] * arr[size - 1 - i];
		}
		return result;
	}
}
