package problem.no11to20;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Arrays;
import java.util.stream.Stream;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem19 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=19
        problem("Counting Sundays");
        solution(between(1901, 2000));
    }

    static long between(int startYear, int endYear) {
        return between(Year.of(startYear), Year.of(endYear));
    }

    static long between(Year startYear, Year endYear) {
        return Stream.iterate(startYear,
                        year -> year.getValue() <= endYear.getValue(),
                        year -> year.plusYears(1))
                .mapToLong(Problem19::numberOfSundaysInAYear).sum();
    }

    static long numberOfSundaysInAYear(Year year) {
        return Arrays.stream(Month.values())
                .filter(month -> firstDayOfWeekIsASunday(year, month))
                .count();
    }

    static boolean firstDayOfWeekIsASunday(Year year, Month month) {
        LocalDate date = year.atMonth(month).atDay(1);
        return (DayOfWeek.from(date).equals(DayOfWeek.SUNDAY));
    }
}
