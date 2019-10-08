package Main.Simulation;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int salt = input.nextInt();
		int answer = -1;
		int three = 0;
		if (salt % 5 == 0)
			answer = salt / 5;
		if (salt % 3 == 0)
			three = salt / 3;
		for (int i = salt / 5; i >= 0; i--) {
			int tmp = salt - (5 * i);
			if (tmp % 3 == 0) {
				answer = i + (tmp / 3);
				break;
			}
		}
		if (answer == -1 && three != 0)
			answer = three;
		System.out.println(answer);
	}
}