package problem19;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountingSundaysTest {
    @ParameterizedTest
    @ValueSource(ints = {2021, 2022, 2025, 2027, 2028})
    void yearsWithOneMonthStartingOnASunday(int year) {
        assertEquals(1, CountingSundays.numberOfSundaysInAYear(Year.of(year)));
    }

    @ParameterizedTest
    @ValueSource(ints = {2020, 2023, 2024, 2029})
    void yearsWithTwoMonthsStartingOnASunday(int year) {
        assertEquals(2, CountingSundays.numberOfSundaysInAYear(Year.of(year)));
    }

    @ParameterizedTest
    @ValueSource(ints = {2026})
    void yearsWithThreeMonthsStartingOnASunday(int year) {
        assertEquals(3, CountingSundays.numberOfSundaysInAYear(Year.of(year)));
    }

    @Test
    void between2021and2021() {
        assertEquals(1, CountingSundays.between(2021, 2021));
    }

    @Test
    void between2020and2021() {
        assertEquals(3, CountingSundays.between(2020, 2021));
    }

    @Test
    void between2021and2022() {
        assertEquals(6, CountingSundays.between(2024, 2026));
    }
}