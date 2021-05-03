import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] A;
	static boolean[] robot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
		A = new int[2 * N];
		robot = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i <= 2 * N - 1; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int result = 1;
		while(true) {
			first();
			second();
			third();
			if(fourth() == -1) {
				result++;
			} else {
				System.out.println(result);
				break;
			}
		}
		br.close();
	}

	public static void first() {
		int upSideTemp = A[N - 1];
		int downSidTemp = A[2 * N - 1];
		for (int i = N - 1; i >= 1; i--) {
			robot[i] = robot[i - 1];
			A[i] = A[i - 1];
			A[N + i] = A[N + i - 1];
		}
		robot[0] = false;
		A[N] = upSideTemp;
		A[0] = downSidTemp;
		if (robot[N - 1])
			robot[N - 1] = false;
	}

	public static void second() {
		for (int i = N - 2; i >= 1; i--) {
			if (robot[i] && !robot[i + 1] && A[i + 1] >= 1) {
				robot[i + 1] = true;
				robot[i] = false;
				A[i + 1]--;
			}
		}
	}

	public static void third() {
		if (A[0] != 0) {
			robot[0] = true;
			A[0]--;
		}
	}

	public static int fourth() {
		int result = 0;
		for (int i = 0; i <= 2 * N - 1; i++) {
			if (A[i] == 0) {
				result++;
			}
			if (result == K) {
				return result;
			} 
		}
		return -1;
	}
}