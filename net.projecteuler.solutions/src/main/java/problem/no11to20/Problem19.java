package problem.no11to20;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem19 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=19
        problem("Counting Sundays");
        solution(between(1901, 2000));
    }

    static int between(int startYear, int endYear) {
        return between(Year.of(startYear), Year.of(endYear));
    }

    static int between(Year startYear, Year endYear) {
        int sundays = 0;

        for (Year year = startYear; year.getValue()<=endYear.getValue(); year = year.plusYears(1))
            sundays += numberOfSundaysInAYear(year);

        return sundays;
    }

    static int numberOfSundaysInAYear(Year year) {
        int sundays = 0;

        for (Month month : Month.values())
            if (firstDayOfWeekIsASunday(year, month))
                sundays += 1;

        return sundays;
    }

    static boolean firstDayOfWeekIsASunday(Year year, Month month) {
        LocalDate date = year.atMonth(month).atDay(1);
        return (DayOfWeek.from(date).equals(DayOfWeek.SUNDAY));
    }
}
