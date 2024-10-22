package utils;

import java.io.InputStream;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {
    public static Stream<String> getNames(String file) {
        return getNamesWithoutQuotes(file).sorted();
    }

    public static Stream<String> getStrings(String file) {
        return getStringsBetweenSeparator(file,"\\R");
    }

    public static String getString(String file) {
        return getStrings(file).collect(Collectors.joining("\n"));
    }

    private static Stream<String> getNamesWithoutQuotes(String file) {
        return getStringsBetweenCommas(file).map(FileUtils::removeQuotes);
    }

    private static Stream<String> getStringsBetweenCommas(String file) {
        return getStringsBetweenSeparator(file, ",");
    }

    public static Stream<String> getStringsBetweenSeparator(String file, String separator) {
        try {
            return new Scanner(getStream(file)).useDelimiter(separator).tokens();
        } catch (Exception ignored) {
        }
        System.err.println("Could not load " + file+" substituted dummy");
        return Stream.of("\"ANN\",\"BOB\"");
    }

    private static InputStream getStream(String file) {
        return getResourceAsStream(file);
    }

    private static InputStream getResourceAsStream(String file) {
        return FileUtils.class.getResourceAsStream(file);
    }

    private static String removeQuotes(String s) {
        return s.replace("\"", "");
    }


}
