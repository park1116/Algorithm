import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int K;
	static int[] num;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		K = input.nextInt();
		num = new int[K];
		Stack<Integer> temp = new Stack<Integer>();
		int result = 0;
		for (int i = 0; i < K; i++) {
			num[i] = input.nextInt();
			if (num[i] == 0) {
				temp.pop();
			} else
				temp.push(num[i]);
		}
		while (!temp.isEmpty()) {
			result += temp.pop();
		}
		System.out.println(result);
	}
}
