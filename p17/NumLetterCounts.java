import java.util.HashMap;

public class NumLetterCounts {
  public static void main(String[] args) {
    int count = 0;
    for (int i = 1; i <= 99; i++) {
      System.out.println(numberToWord(i));
    }
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
      if (ten <= 1) {
        return baseNumMap.get((ten * 10) + one);
      }
      return tensNumMap.get(ten) + baseNumMap.get(one);
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
    String[] tens = { "", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety" };

    for (int i = 0; i < 10; i++) {
      result.put(i, tens[i]);
    }

    return result;
  }
}
