package problem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Arrays;
import java.util.stream.IntStream;

import static problem.Solution.problem;

public class Problem19 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=19
        problem("Counting Sundays",
                () -> between(1901, 2000));
    }

    static long between(int startYear, int endYear) {
        return IntStream.rangeClosed(startYear, endYear)
                .mapToLong(Problem19::numberOfSundaysInAYear).sum();
    }

    static long numberOfSundaysInAYear(int year) {
        return Arrays.stream(Month.values())
                .filter(month -> firstDayOfWeekIsASunday(year, month))
                .count();
    }

    static boolean firstDayOfWeekIsASunday(int year, Month month) {
        LocalDate date = Year.of(year).atMonth(month).atDay(1);
        return (DayOfWeek.from(date).equals(DayOfWeek.SUNDAY));
    }

    private Problem19() {}
}
