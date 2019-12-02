import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int time = 0;
		for (int i = 0; i < 4; i++) {
			int second = input.nextInt();
			time += second;
		}
		System.out.println(time / 60);
		System.out.println(time % 60);
	}
}