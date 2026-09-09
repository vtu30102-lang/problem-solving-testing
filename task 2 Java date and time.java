import java.time.DayOfWeek;
import java.time.LocalDate;

public class Result {
    public static String findDay(int month, int day, int year) {
        DayOfWeek dayOfWeek = LocalDate.of(year, month, day).getDayOfWeek();
        return dayOfWeek.toString();
    }
}
