import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Calendar;

public class SundaysOnFirstOfMonth {
  public static void main(String[] args) {
    if (args.length != 2) {
      throw new IllegalArgumentException("You need to enter a starting year and an ending year.");
    }

    int startingYear = Integer.parseInt(args[0]);
    int endingYear = Integer.parseInt(args[1]);

    if (endingYear < startingYear) {
      throw new IllegalArgumentException("You must have endingYear be after startingYear");
    }

    Calendar calendar = Calendar.getInstance();
    calendar.set(1900 + startingYear, 1, 1);
    int daysInWeek = 7;
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    int differenceFromSunday = daysInWeek - dayOfWeek;
    System.out.println("Day: " + dayOfWeek);
    System.out.println("Difference: " + differenceFromSunday);

    HashMap<Integer, Integer> numDaysForMonth = new HashMap<Integer, Integer>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("days_per_month"));
      String line = reader.readLine();
      while (line != null) {
        String[] data = line.split(" ");
        numDaysForMonth.put(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
        line = reader.readLine();
      }
    } catch (Exception e) {
      System.err.println("Reading the file went wrong");
    }

    int totalDaysPassed = 0;
    int numSundays = 0;
    for (int i = startingYear; i <= endingYear; i++) {
      for (int j = 1; j <= 12; j++) {
        totalDaysPassed += numDaysForMonth.get(j);
        if (j == 2 && ((i % 100) == 0 && (i % 400) == 0) && (i % 4) == 0) {
          totalDaysPassed++;
        }
        if ((totalDaysPassed % daysInWeek) == differenceFromSunday && !(j == 12 && i == endingYear)) {
          System.out.println("Year: " + i);
          System.out.println("Month: " + ((j+1) % 12));
          System.out.println("-------------------");
          numSundays++;
        }
      }
    }
    System.out.println("Total Num of Sundays on the first of the month from Jan 1, " + startingYear + " to Dec 31, " + endingYear + ": " + numSundays);
  }
}
