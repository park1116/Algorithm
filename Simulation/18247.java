import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int i = 0; i < T; i++) {
			int N = input.nextInt();
			int M = input.nextInt();
			if (N < 12 || M < 4)
				System.out.println(-1);
			else {
				System.out.println(M * 11 + 4);
			}
		}
	}
}