import java.math.BigInteger;
import java.io.FileReader;
import java.io.BufferedReader;

public class SumBigNumbers {

  public static void main(String[] args) {
    if (args.length != 1) {
      throw new IllegalArgumentException("You must pass in the data file of numbers.");
    }

    sumNums(args[0]);
  }

  public static void sumNums(String filePath) {
    BigInteger sum = new BigInteger("0");
    try {
      BufferedReader br = new BufferedReader(new FileReader(filePath));
      String curNum = br.readLine();
      while (curNum != null) {
        BigInteger current = new BigInteger(curNum.trim());
        sum = sum.add(current);
        curNum = br.readLine();
      }
      System.out.println(sum.toString());
    } catch (Exception e) {
      e.printStackTrace();
      System.err.println("You FUcked UP");
    }
  }
}
