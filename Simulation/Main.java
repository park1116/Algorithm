import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = N - i; j > 1; j--) {
				System.out.print(" ");
			}
			for (int j = i; j >= 0; j--)
				System.out.print("*");
			System.out.println();
		}
	}
}