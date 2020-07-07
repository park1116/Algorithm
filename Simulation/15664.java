import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	static int[] result;
	static ArrayList<Integer> arr;
	static int[] checkNum = new int[10001];
	static int M;
	static int N;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		result = new int[M];
		Set<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < N; i++) {
			int temp = input.nextInt();
			checkNum[temp]++;
			set.add(temp);
		}
		arr = new ArrayList<Integer>(set);
		dfs(0, 0);
	}

	// dfs
	public static void dfs(int num, int start) {
		if (num == M) {
			resultArray();
			return;
		}
		for (int i = start; i < arr.size(); i++) {
			if(checkNum[arr.get(i)] > 0) {
				checkNum[arr.get(i)]--;
				result[num] = arr.get(i);
				dfs(num + 1, i);
				checkNum[arr.get(i)]++;
			}
		}
	}

	// 배열을 출력하는 함수
	public static void resultArray() {
		for (int i = 0; i < M; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}
}