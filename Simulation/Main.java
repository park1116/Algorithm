import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int i = 0; i < T; i++) {
			int A = input.nextInt();
			int B = input.nextInt();
			System.out.println("Case #" + (i + 1) + ": " + A + " + " + B + " = " + (A + B));
		}
	}
}