import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(avg());
		System.out.println(center());
		System.out.println(mode());
		System.out.println(range());
		br.close();
	}

	public static int avg() {
		int result = 0;
		for (int i = 0; i < N; i++) {
			result += num[i];
		}
		return (int) Math.round((double)result / N);
	}

	public static int center() {
		Arrays.sort(num);
		return num[N / 2];
	}

	public static int mode() {
		int[] mode = new int[8001];
		int idx = 0, max = Integer.MIN_VALUE;
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			mode[num[i] + 4000]++;
		}
		for (int i = 0; i <= 8000; i++) {
			if (max < mode[i]) {
				max = mode[i];
				idx = i - 4000;
				flag = false;
			} else if (max == mode[i] && !flag) {
				idx = i - 4000;
				flag = true;
			}
		}
		return idx;
	}

	public static int range() {
		return num[N - 1] - num[0];
	}
}