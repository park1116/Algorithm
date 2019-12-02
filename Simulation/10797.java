import java.util.Scanner;

public class Main {
	static int day;
	static int[] car;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		day = input.nextInt();
		car = new int[5];
		int num = day % 10;
		int result = 0;
		for (int i = 0; i < 5; i++) {
			car[i] = input.nextInt();
			if(num==car[i])
				result++;
		}
		System.out.println(result);
	}
}
