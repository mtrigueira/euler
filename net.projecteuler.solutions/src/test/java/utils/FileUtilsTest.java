package utils;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FileUtilsTest {
    @Test
    public void testConcatWithAllNullInputs() {
        String result = FileUtils.concat(null, null, null);
        assertEquals("", result);
    }

    @Test
    public void testConcatWithEmptyInput() {
        String[] emptyInput = {};
        String result = FileUtils.concat(emptyInput);
        assertEquals("", result);
    }

    @Test
    public void testConcatWithEmptyOrElse() {
        Stream<String> result = FileUtils.concat(null, "");
        assertNotNull(result);
        String collected = result.collect(Collectors.joining());
        assertEquals("",collected);
    }

    @Test
    public void testConcatWithMixedNullAndNonNullStrings() {
        String[] mixedStrings = {null, "Hello", null, "World"};
        String result = FileUtils.concat(mixedStrings);
        assertEquals("Hello", result);
    }

    @Test
    public void testConcatWithNonNullStream() {
        Stream<String> input = Stream.of("test1", "test2");
        Stream<String> result = FileUtils.concat(input, "fallback");
        assertNotNull(result);
        assertArrayEquals(new String[]{"test1", "test2"}, result.toArray(String[]::new));
    }

    @Test
    public void testConcatWithNullInput() {
        String result = FileUtils.concat((String[]) null);
        assertEquals("", result);
    }

    @Test
    public void testConcatWithNullInputStream() {
        Stream<String> inputStream = null;
        String orElse = "Line1\nLine2\nLine3";

        Stream<String> result = FileUtils.concat(inputStream, orElse);

        List<String> resultList = result.toList();
        List<String> expectedList = Arrays.asList("Line1", "Line2", "Line3");

        assertEquals(expectedList, resultList);
    }

    @Test
    public void testConcatWithNullOrElse() {
        Stream<String> input = Stream.of("test");
        assertThrows(NullPointerException.class, () -> FileUtils.concat(null, null));
    }

    @Test
    public void testConcatWithNullOrEmptyInput() {
        assertEquals("", FileUtils.concat());
        assertEquals("", FileUtils.concat((String[]) null));
        assertEquals("", FileUtils.concat(null, null, null));
    }

    @Test
    public void testConcatWithNullStream() {
        String orElse = "fallback\nvalue";
        Stream<String> result = FileUtils.concat(null, orElse);
        assertNotNull(result);
        assertArrayEquals(new String[]{"fallback", "value"}, result.toArray(String[]::new));
    }

    @Test
    public void testConcatWithOrElseContainingSpecialCharacters() {
        String orElse = "test1\\Rtest2";
        Stream<String> result = FileUtils.concat(null, orElse);
        assertNotNull(result);
        assertArrayEquals(new String[]{"test1\\Rtest2"}, result.toArray(String[]::new));
    }

    @Test
    public void testGetNamesSortsAndReturnsValidNames() {
        String testFile = "/test_names.txt";
        List<String> expectedNames = Arrays.asList("Alice", "Bob", "Charlie", "David");

        FileUtils.setResourceGetter((filename)-> new ByteArrayInputStream(expectedNames.stream().collect(Collectors.joining(",")).getBytes()));
        Stream<String> result = FileUtils.getNames(testFile);

        assertNotNull(result);
        List<String> actualNames = result.collect(Collectors.toList());
        assertEquals(expectedNames, actualNames);

        FileUtils.resetDefaultResourceGetter();
    }

    @Test
    public void testGetNamesWithEmptyFile() {
        Stream<String> result = FileUtils.getNames("/empty_file.txt");
        assertNull(result);
    }

    @Test
    public void testGetNamesWithInvalidFilePath() {
        Stream<String> result = FileUtils.getNames("/invalid/file/path.txt");
        assertNull(result);
    }

    @Test
    public void testGetNamesWithNonExistentFile() {
        Stream<String> result = FileUtils.getNames("non_existent_file.txt");
        assertNull(result);
    }

    @Test
    public void testGetNamesWithNullInput() {
        Stream<String> result = FileUtils.getNames(null);
        assertNull(result);
    }

    @Test
    public void testGetString_Invalid() {
        assertNull(FileUtils.getString("/path/to/file.txt"));
        assertNull(FileUtils.getString("non_existent_file.txt"));
        assertNull(FileUtils.getString(null));
    }

    @Test
    void testGetString_Valid() {
        String expectedString = "Hello, World!\nHow are you?";
        InputStream inputStream = new ByteArrayInputStream(expectedString.getBytes());
        FileUtils.setResourceGetter((filename)->inputStream);

        String actualString = FileUtils.getString("ignored");
        assertEquals(expectedString, actualString);

        FileUtils.resetDefaultResourceGetter();
    }

    @Test
    public void testGetStringsBetweenSeparatorWithComma() {
        String fileContent = "apple,banana,cherry,date";
        InputStream inputStream = new ByteArrayInputStream(fileContent.getBytes());
        String fileName = "test.txt";
        String separator = ",";

        FileUtils.setResourceGetter((filename)-> inputStream);

        Stream<String> result = FileUtils.getStringsBetweenSeparator(fileName, separator);

        assertNotNull(result);
        List<String> resultList = result.collect(Collectors.toList());
        List<String> expectedList = Arrays.asList("apple", "banana", "cherry", "date");
        assertEquals(expectedList, resultList);

        FileUtils.resetDefaultResourceGetter();
    }

    @Test
    public void testGetStringsBetweenSeparatorWithEmptyFile() {
        Stream<String> result = FileUtils.getStringsBetweenSeparator("empty.txt", ",");
        assertNull(result);
    }

    @Test
    public void testGetStringsBetweenSeparatorWithEmptySeparator() {
        Stream<String> result = FileUtils.getStringsBetweenSeparator("test.txt", "");
        assertNull(result);
    }

    @Test
    public void testGetStringsBetweenSeparatorWithNonExistentFile() {
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));

        Stream<String> result = FileUtils.getStringsBetweenSeparator("nonexistent.txt", ",");

        assertNull(result);
        assertTrue(errContent.toString().contains("Could not load nonexistent.txt"),
                "Error message should be printed for non-existent file");

        System.setErr(System.err);
    }

    @Test
    public void testGetStringsBetweenSeparatorWithNullFile() {
        Stream<String> result = FileUtils.getStringsBetweenSeparator(null, ",");
        assertNull(result);
    }

    @Test
    public void testGetStringsBetweenSeparatorWithNullSeparator() {
        Stream<String> result = FileUtils.getStringsBetweenSeparator("test.txt", null);
        assertNull(result);
    }
    
    @Test
    public void testGetStringsWithMultipleLines() {
        String testContent = "Line 1\nLine 2\nLine 3";
        InputStream inputStream = new ByteArrayInputStream(testContent.getBytes());

        FileUtils.setResourceGetter((filename)-> inputStream);
        Stream<String> result = FileUtils.getStrings("testFile.txt");

        assertNotNull(result);
        List<String> resultList = result.collect(Collectors.toList());
        assertEquals(3, resultList.size());
        assertEquals("Line 1", resultList.get(0));
        assertEquals("Line 2", resultList.get(1));
        assertEquals("Line 3", resultList.get(2));

        FileUtils.resetDefaultResourceGetter();
    }

    @Test
    public void testGetStringsWithNonExistentFile() {
        Stream<String> result = FileUtils.getStrings("non_existent_file.txt");
        assertNull(result);
    }

    @Test
    public void testGetStringsWithNullInput() {
        Stream<String> result = FileUtils.getStrings(null);
        assertNull(result);
    }
}