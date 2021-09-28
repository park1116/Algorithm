import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int T;
	static String[] str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		str = new String[T];
		for (int i = 0; i < T; i++) {
			str[i] = br.readLine();
		}
		for (int i = 0; i < T; i++) {
			int count = 0;
			for (int j = 0; j < str[i].length(); j++) {
				char c = str[i].charAt(j);
				if (c == '(') {
					count++;
				} else if (c == ')') {
					count--;
				}
				if (count < 0)
					break;
			}
			if (count == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		br.close();
	}
}