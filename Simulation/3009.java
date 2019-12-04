import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] x = new int[3];
		int[] y = new int[3];
		int countX = 0, countY = 0;
		int resultX = 0, resultY = 0;
		for (int i = 0; i < 3; i++) {
			x[i] = input.nextInt();
			y[i] = input.nextInt();
		}
		for (int i = 0; i < 3; i++) {
			if (x[0] == x[i])
				countX++;
			if (y[0] == y[i])
				countY++;
		}
		if (countX == 1)
			resultX = x[0];
		else if(x[0] != x[1])
			resultX = x[1];
		else
			resultX = x[2];
		if (countY == 1)
			resultY = y[0];
		else if(y[0] != y[1])
			resultY = y[1];
		else
			resultY = y[2];		
		System.out.println(resultX + " " + resultY);
	}
}
