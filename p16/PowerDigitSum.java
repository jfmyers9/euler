import java.math.BigInteger;

public class PowerDigitSum {
  public static void main(String[] args) {
    if (args.length != 1) {
      throw new IllegalArgumentException("You must pass in a power as an argument.");
    }

    int power = Integer.parseInt(args[0]);
    PowerDigitSummer summer = new PowerDigitSummer(power);
    System.out.println("The sum of the digits of 2^" + power + " is " + summer.digitSum() + ".");
  }

  public static class PowerDigitSummer {
    private int power;

    PowerDigitSummer(int power) {
      this.power = power;
    }

    public int digitSum() {
      BigInteger two = new BigInteger("2");
      BigInteger raisedTwo = two.pow(power);

      int sum = 0;
      while (raisedTwo.compareTo(new BigInteger("0")) != 0) {
        sum += raisedTwo.mod(new BigInteger("10")).intValue();
        raisedTwo = raisedTwo.divide(new BigInteger("10"));
      }
      return sum;
    }
  }
}
