package problem.no21to30.problem22;

import java.io.InputStream;
import java.util.Scanner;
import java.util.stream.Stream;

class FileUtils {
    static Stream<String> getNames(String file) {
        return getNamesWithoutQuotes(file).sorted();
    }

    private static Stream<String> getNamesWithoutQuotes(String file) {
        return getNamesBetweenCommas(file).map(FileUtils::removeQuotes);
    }

    private static Stream<String> getNamesBetweenCommas(String file) {
        return new Scanner(getResourceAsStream(file)).useDelimiter(",").tokens();
    }

    private static InputStream getResourceAsStream(String file) {
        return NamesScores.class.getResourceAsStream(file);
    }

    private static String removeQuotes(String s) {
        return s.replace("\"", "");
    }
}
