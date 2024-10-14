package utils;

import problem.no21to30.Problem22;

import java.io.InputStream;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileUtils {
    public static Stream<String> getNames(String file) {
        return getNamesWithoutQuotes(file).sorted();
    }

    private static Stream<String> getNamesWithoutQuotes(String file) {
        return getNamesBetweenCommas(file).map(FileUtils::removeQuotes);
    }

    private static Stream<String> getNamesBetweenCommas(String file) {
        try {
            return new Scanner(getResourceAsStream(file)).useDelimiter(",").tokens();
        } catch (Exception ignored) {
        }
        System.err.println("Could not load " + file+" substituted dummy");
        return Stream.of("\"ANN\",\"BOB\"");
    }

    private static InputStream getResourceAsStream(String file) {
        return Problem22.class.getResourceAsStream(file);
    }

    private static String removeQuotes(String s) {
        return s.replace("\"", "");
    }
}
