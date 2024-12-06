package utils;

import java.io.InputStream;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {
    public static Stream<String> getNames(String file) {
        Stream<String> stream = getNamesWithoutQuotes(file);
        if (stream == null) return null;
        return stream.sorted();
    }

    public static Stream<String> getStrings(String file) {
        return getStringsBetweenSeparator(file, "\\R");
    }

    public static String getString(String file) {
        Stream<String> stream = getStrings(file);
        if (stream == null) return null;
        return stream.collect(Collectors.joining("\n"));
    }

    private static Stream<String> getNamesWithoutQuotes(String file) {
        Stream<String> stream = getStringsBetweenCommas(file);
        if (stream == null) return null;
        return stream.map(FileUtils::removeQuotes);
    }

    private static Stream<String> getStringsBetweenCommas(String file) {
        return getStringsBetweenSeparator(file, ",");
    }

    public static Stream<String> getStringsBetweenSeparator(String file, String separator) {
        try {
            return new Scanner(getStream(file)).useDelimiter(separator).tokens();
        } catch (Exception ignored) {
        }
        System.err.println("Could not load " + file);
        return null;
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

    public static String concat(String... a) {
        for (String i : a)
            if (i != null) return i;

        return "";
    }

    public static Stream<String> concat(Stream<String> i, String orElse) {
        if (i != null) return i;

        return Stream.of(orElse.split("\\R"));
    }

    private FileUtils() {
    }
}
