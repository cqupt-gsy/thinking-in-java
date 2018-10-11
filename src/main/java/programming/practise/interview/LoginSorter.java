package programming.practise.interview;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LoginSorter {

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "test.txt";
        String filter = "Login";
        final List<String> contents = filterFileFrom(filename, filter);
        final Map<String, Integer> uniqueContents = uniqueContentsFrom(contents);
        final List<String> sortedFileContents = getSortedContentsFrom(uniqueContents);
        sortedFileContents.forEach(System.out::println);
    }

    public static List<String> filterFileFrom(String filename, String filter) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        return reader.lines().filter(line -> line.contains(filter)).sorted().collect(Collectors.toList());
    }

    public static Map<String, Integer> uniqueContentsFrom(List<String> fileContents) {
        Map<String, Integer> result = new HashMap<>();
        for (String fileContent : fileContents) {
            result.merge(fileContent, 1, (a, b) -> a + b);
        }
        return result;
    }

    public static List<String> getSortedContentsFrom(Map<String, Integer> uniqueContents) {
        return uniqueContents
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
