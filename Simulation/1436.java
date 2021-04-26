import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		System.out.println(title());
	}

	public static String title() {
		List<String> arr = new ArrayList<String>();  
		for (int i = 666; arr.size() < N; i++) {
			int count = 0;
			boolean flag = false;
			String title = String.valueOf(i);
			if(title.indexOf("666") > -1)
				flag=true;
			if(flag)
				arr.add(title);
		}
		return arr.get(N - 1);
	}
}