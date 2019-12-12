import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] sh = new int[3];
		int[] sm = new int[3];
		int[] ss = new int[3];
		int[] fh = new int[3];
		int[] fm = new int[3];
		int[] fs = new int[3];
		for (int i = 0; i < 3; i++) {
			sh[i] = input.nextInt();
			sm[i] = input.nextInt();
			ss[i] = input.nextInt();
			fh[i] = input.nextInt();
			fm[i] = input.nextInt();
			fs[i] = input.nextInt();
			int[] result = cal(sh[i], sm[i], ss[i], fh[i], fm[i], fs[i]);
			for (int j : result)
				System.out.print(j + " ");
			System.out.println();
		}
	}

	// 근무시간을 계산하는 함수
	public static int[] cal(int sh, int sm, int ss, int fh, int fm, int fs) {
		int h, m, s = 0;
		if (fs >= ss)
			s = fs - ss;
		else {
			fm = fm - 1;
			s = (fs + 60) - ss;
		}
		if (fm >= sm)
			m = fm - sm;
		else {
			fh = fh - 1;
			m = (fm + 60) - sm;
		}
		h = fh - sh;
		int[] arr = new int[3];
		arr[0] = h;
		arr[1] = m;
		arr[2] = s;
		return arr;
	}
}