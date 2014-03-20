import java.math.BigInteger;

public class FactorialDigitSum {
  public static void main(String[] args) {
    if (args.length != 1) {
      throw new IllegalArgumentException("You need to pass in a number.");
    }

    BigInteger result = new BigInteger(args[0]);
    result = factorialBigInt(result);
    System.out.println("Factorial Result: " + result.toString());
    System.out.println("Digit Sum: " + digitSum(result.toString()));
  }

  public static BigInteger factorialBigInt(BigInteger n) {
    if (n.intValue() == 1) {
      return n;
    } else {
      return n.multiply(factorialBigInt(n.subtract(new BigInteger("1"))));
    }
  }

  public static int digitSum(String bigNum) {
    int sum = 0;
    for (char c : bigNum.toCharArray()) {
      sum += Character.getNumericValue(c);
    }
    return sum;
  }
}
