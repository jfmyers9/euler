import java.math.BigInteger;
import java.io.FileReader;
import java.io.BufferedReader;

public class SumBigNumbers {

  public static void main(String[] argv) {
    sumNums();
  }

  public static void sumNums() {
    BigInteger sum = new BigInteger("0");
    try {
      BufferedReader br = new BufferedReader(new FileReader("data.txt"));
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
