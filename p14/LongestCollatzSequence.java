import java.util.HashMap;

public class LongestCollatzSequence {

  public static int[] lengths;

  public static void main(String[] args) {
    if (args.length != 1) {
      throw new IllegalArgumentException("You must pass in the max number that we can start from.");
    }

    int n = Integer.parseInt(args[0]);

    int max_length = 0;
    int max_index = 0;

    for (int i = 1; i < n; i++) {
      int length = computeCollatzLength(i);
      if (length > max_length) {
        max_length = length;
        max_index = i;
      }
    }

    System.out.println("Max Starting Number: " + max_index);
    System.out.println("Max Length: " + max_length);
  }

  public static int computeCollatzLength(long n) {
    int length = 1;
    while (true) {
      if (n == 1) {
        return length;
      } else if (n % 2 == 0) {
        length++;
        n = n / 2;
      } else {
        length++;
        n = (3 * n) + 1;
      }
    }
  }
}
