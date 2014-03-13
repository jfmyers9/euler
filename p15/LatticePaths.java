public class LatticePaths {
  public static long[][] calculatedGridVals;

  public static void main(String[] args) {
    if (args.length != 2) {
      throw new IllegalArgumentException("You need to pass in the width and height.");
    }

    int width = Integer.parseInt(args[0]);
    int height = Integer.parseInt(args[1]);

    calculatedGridVals = new long[width + 1][height + 1];
    long numPaths = calculateNumLatticePaths(width, height);

    String output = String.format("The number of lattice paths in a %dx%d grid is %d", width, height, numPaths);
    System.out.println(output);
  }

  public static long calculateNumLatticePaths(int width, int height) {
    if (calculatedGridVals[width][height] != 0) {
      return calculatedGridVals[width][height];
    }

    if (width == 0 || height == 0) {
      calculatedGridVals[width][height] = 1;
      return 1;
    }

    if (width == 1 && height == 1) {
      calculatedGridVals[width][height] = 2;
      return 2;
    }
    long widthFirst = calculateNumLatticePaths(width - 1, height);
    long heightFirst = calculateNumLatticePaths(width, height - 1);
    calculatedGridVals[width][height] = widthFirst + heightFirst;
    return calculatedGridVals[width][height];
  }
}
