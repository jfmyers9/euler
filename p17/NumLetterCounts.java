import java.util.HashMap;

public class NumLetterCounts {
  public static boolean debug = false;

  public static void main(String[] args) {
    if (args.length == 0) {
      throw new IllegalArgumentException();
    }

    int n = Integer.parseInt(args[0]);

    if (n < 1 || n > 1000) {
      throw new IllegalArgumentException("Must be greater than 0 and less than 1001");
    }

    int count = 0;

    for (int i = 1; i <= n; i++) {
      count += numberToWord(i).length();
      if (debug) {
        System.out.println("Number: " + i);
        System.out.println("Word: " + numberToWord(i));
        System.out.println("Length: " + numberToWord(i).length());
        System.out.println("----------");
      }
    }

    System.out.println("The Number of Letters in the Word Representation of the numbers from 1 to " + n + " is " + count + ".");
  }

  public static String numberToWord(int n) {
    HashMap<Integer, String> baseNumMap = createBaseNumMap();
    HashMap<Integer, String> tensNumMap = createTensNumMap();
    if (n == 1000) {
      return "onethousand";
    } else {
      int hundred = n / 100;
      int ten = (n - hundred * 100) / 10;
      int one = n % 10;
      String hundredString = (hundred == 0) ? "" : baseNumMap.get(hundred) + "hundred";
      String andString = (ten + one == 0 || hundred == 0) ? "" : "and";
      String tenString = (ten <= 1) ? "" : tensNumMap.get(ten);
      String oneString = (ten <= 1) ? baseNumMap.get((ten * 10) + one) : baseNumMap.get(one);
      return hundredString + andString + tenString + oneString;
    }
  }

  public static HashMap<Integer, String> createBaseNumMap() {
    HashMap<Integer, String> result = new HashMap<Integer, String>();
    String[] base = { "", "one", "two", "three", "four", "five", "six", "seven", "eight",
      "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
      "seventeen", "eighteen", "nineteen" };

    for (int i = 0; i <= 19; i++) {
      result.put(i, base[i]);
    }

    return result;
  }

  public static HashMap<Integer, String> createTensNumMap() {
    HashMap<Integer, String> result = new HashMap<Integer, String>();
    String[] tens = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

    for (int i = 0; i < 10; i++) {
      result.put(i, tens[i]);
    }

    return result;
  }
}
