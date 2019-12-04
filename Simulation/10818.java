import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int min = 1000000, max = -1000000;
		for (int i = 1; i <= N; i++) {
			int tmp = input.nextInt();
			if (min > tmp)
				min = tmp;
			if (max < tmp)
				max = tmp;
		}
		System.out.println(min + " " + max);
	}
}
