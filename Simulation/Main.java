import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.next();
		char[] ch = new char[str.length() + 1];
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			ch[i] = str.charAt(i);
		}
		for (int i = 0; i < str.length(); i++) {
			if (ch[i] == 'c' && i != str.length() - 1) {
				if (ch[i + 1] == '=' || ch[i + 1] == '-') {
					result++;
					i++;
					continue;
				}
			}
			if (ch[i] == 'd' && i != str.length() - 1) {
				if (ch[i + 1] == '-') {
					result++;
					i++;
					continue;
				}
			}
			if (ch[i] == 'd' && i != str.length() - 2) {
				if (ch[i + 1] == 'z' && ch[i + 2] == '=') {
					result++;
					i = i + 2;
					continue;
				}
			}
			if (ch[i] == 'l' || ch[i] == 'n' && i != str.length() - 1) {
				if (ch[i + 1] == 'j') {
					result++;
					i++;
					continue;
				}
			}
			if (ch[i] == 's' || ch[i] == 'z' && i != str.length() - 1) {
				if (ch[i + 1] == '=') {
					result++;
					i++;
					continue;
				}
			}
			result++;
		}
		System.out.println(result);
	}
}