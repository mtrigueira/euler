package utils;

import problem.no21to30.Problem22;

import java.io.InputStream;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileUtils {
    public static Stream<String> getNames(String file) {
        return getNamesWithoutQuotes(file).sorted();
    }

    public static Stream<String> getStrings(String file) {
        return getStringsBetweenSeparator(file,"\\R");
    }

    private static Stream<String> getNamesWithoutQuotes(String file) {
        return getStringsBetweenCommas(file).map(FileUtils::removeQuotes);
    }

    private static Stream<String> getStringsBetweenCommas(String file) {
        return getStringsBetweenSeparator(file, ",");
    }

    private static Stream<String> getStringsBetweenSeparator(String file, String seperator) {
        try {
            return new Scanner(getResourceAsStream(file)).useDelimiter(seperator).tokens();
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
