import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int H = input.nextInt();
		int M = input.nextInt();
		if (M >= 45)
			M = M - 45;
		else {
			if (H == 0)
				H = 23;
			else
				H = H - 1;
			M = 60 - (45 - M);
		}
		System.out.println(H+" "+M);
	}
}