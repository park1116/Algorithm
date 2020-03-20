import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int[] book = new int[N];
		int result = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		PriorityQueue<Integer> minus = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			book[i] = input.nextInt();
			if (book[i] < 0)
				minus.add(book[i]);
			else
				queue.add(book[i]);
		}
		Stack<Integer> plus = new Stack<Integer>();
		while (!queue.isEmpty()) {
			plus.push(queue.poll());
		}
		int num1 = 0, num2 = 0;
		if (minus.size() > 0)
			num1 = minus.peek();
		if (plus.size() > 0)
			num2 = plus.peek();
		if ((num1 * (-1)) < num2) {
			result += num2;
			for (int i = 0; i < M; i++)
				if(plus.size()>0)
					plus.pop();
				else
					break;
		} else {
			result += num1 * (-1);
			for (int i = 0; i < M; i++)
				minus.poll();
		}

		while (!plus.isEmpty()) {
			result += plus.pop() * 2;
			for (int i = 1; i < M; i++) {
				if(plus.size()>0)
					plus.pop();
				else
					break;
			}
		}
		while (!minus.isEmpty()) {
			result += minus.remove() * (-2);
			for (int i = 1; i < M; i++)
				minus.poll();
		}
		System.out.println(result);
	}
}