import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[] A = new int[N];
		int penguin = 0;
		int leftMin = 1000000001;
		int rightMin = 1000000001;
		for (int i = 0; i < N; i++) {
			A[i] = input.nextInt();
			if (A[i] == -1)
				penguin = i;
		}
		for (int i = penguin - 1; i >= 0; i--) {
			if(A[i] < leftMin)
				leftMin = A[i];
		}
		for (int i = penguin + 1; i < N; i++) {
			if(A[i] < rightMin)
				rightMin = A[i];
		}
		System.out.println(leftMin + rightMin);
	}
}