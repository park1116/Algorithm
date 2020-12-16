import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int min = 65;
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer stTemp = new StringTokenizer(br.readLine());
			String strTemp = stTemp.nextToken();
			for (int j = 0; j < M; j++) {
				map[i][j] = strTemp.charAt(j);
			}
		}
		for (int i = 0; i < N - 8 + 1; i++) {
			for (int j = 0; j < M - 8 + 1; j++) {
				int temp = colorCheck(j, i ,'W');
				if (min > temp)
					min = temp;
				temp = colorCheck(j, i ,'B');
				if (min > temp)
					min = temp;
			}
		}
		System.out.println(min);
	}

	public static int colorCheck(int x, int y, char start) {
		int count = 0;
		boolean flag;
		if (map[y][x] == start)
			flag = true;
		else
			flag = false;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (flag) {
					if (map[y + i][x + j] == 'B')
						count++;
				} else {
					if (map[y + i][x + j] == 'W')
						count++;
				}
				flag = !flag;
			}
			flag = !flag;
		}
		return count;
	}
}