package WeeklyProjects;
import java.util.GregorianCalendar;

// 0-based date
public class MyDate {
    private int year;
    private int month;
    private int day;

    // No-arg constructor
    public MyDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        this.year = calendar.get(GregorianCalendar.YEAR);
        this.month = calendar.get(GregorianCalendar.MONTH);
        this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }

   // MyDate constructor
    public MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }

    // Constructor with specified year, month, and day
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Year getter
    public int getYear() {
        return year;
    }

    // Month getter
    public int getMonth() {
        return month;
    }

    // Day getter
    public int getDay() {
        return day;
    }

    // Sets a new date based on elapsed time
    public void setDate(long elapsedTime) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);
        this.year = calendar.get(GregorianCalendar.YEAR);
        this.month = calendar.get(GregorianCalendar.MONTH);
        this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }
}
