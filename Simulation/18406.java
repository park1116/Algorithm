import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int temp = N;
		int count = 1;
		int result1 = 0, result2 = 0;
		while (temp >= 10) {
			temp = temp / 10;
			count++;
		}
		temp = N;
		for (int i = 0; i < count / 2; i++) {
			result1 += temp % 10;
			temp /= 10;
		}
		for (int i = 0; i < count / 2; i++) {
			result2 += temp % 10;
			temp /= 10;
		}
		if(result1 == result2)
			System.out.println("LUCKY");
		else
			System.out.println("READY");
	}
}