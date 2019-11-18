import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int result = 0;
		for (int M = 0; M < N; M++) {
			if (sum(M) == N) {
				result=M;
				break;
			}
		}
		System.out.println(result);
	}

	public static int sum(int M) {
		String str = String.valueOf(M);
		int count = str.length();
		int result = M;
		for (int i = 0; i < count; i++) {
			result += str.charAt(i) - '0';
		}
		return result;
	}
}
