import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MaxPathSum {
  public static void main(String[] args) {
    if (args.length != 1) {
      throw new IllegalArgumentException("Please Enter a file representing the triangle.");
    }

    ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();

    try {
      BufferedReader reader = new BufferedReader(new FileReader(args[0]));
      String line = reader.readLine();
      while (line != null) {
        ArrayList<Integer> currentRow = new ArrayList<Integer>();
        String[] list = line.split(" ");
        for(String element : list) {
          currentRow.add(Integer.parseInt(element));
        }
        triangle.add(currentRow);
        line = reader.readLine();
      }
    } catch (Exception e) {
      System.err.println("Reading the file went wrong");
    }
    System.out.println(bestPath(0, 0, triangle));
  }

  public static int bestPath(int level, int position, ArrayList<ArrayList<Integer>> triangle) {
    ArrayList<Integer> currentLevel = triangle.get(level);
    if (level == triangle.size() - 1) {
      return currentLevel.get(position);
    } else {
      return currentLevel.get(position) + Math.max(bestPath(level + 1, position, triangle), bestPath(level + 1, position + 1, triangle));
    }
  }
}
