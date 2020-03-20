import java.util.Scanner;



class Main {

   public static void main(String[] args) {

      Scanner input = new Scanner(System.in);

      int N = input.nextInt();

      long K = input.nextLong();

      int[] course = new int[N + 1];

      for (int i = 0; i < N; i++) {

         course[i] = input.nextInt();

      }

      int position = 0;

      long result = 0;

      long length = 0;

      for (int i = 0; i < N; i++) {

         length += course[i];

      }

      while (result <= K) {

         if (position == N)

            break;

         result += course[position++];

      }

      while (result <= K) {

         result += course[--position];

      }

      if (length > K) {

         System.out.println(position);

      } else {

         System.out.println(position + 1);

      }

   }

}