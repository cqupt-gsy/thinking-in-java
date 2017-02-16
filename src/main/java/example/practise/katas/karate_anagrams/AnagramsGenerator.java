package example.practise.katas.karate_anagrams;

import example.practise.katas.karate_data_munging.FileParserUtils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AnagramsGenerator {

    private final FileParserUtils fileParserUtils;
    private final String FILENAME = "wordlist.txt";

    public AnagramsGenerator() {
        fileParserUtils = new FileParserUtils();
    }

    public Map<String, List<String>> generateAnagrams() throws IOException {
        Map<String, List<String>> result = new HashMap<>();
        Map<String, List<String>> finalResult = new HashMap<>();
        fileParserUtils.readFile(FILENAME)
                .forEach(line -> {
                    String sortedLine = Arrays
                            .stream(line.toLowerCase().replace(" ", "").split(""))
                            .sorted()
                            .collect(Collectors.joining());
                    List<String> anagrams = result.get(sortedLine);
                    if (anagrams != null) {
                        anagrams.add(line);
                    } else {
                        List<String> newAnagrams = new ArrayList<>();
                        newAnagrams.add(line);
                        result.put(sortedLine, newAnagrams);
                    }
                });
        result.keySet().forEach(key -> {
            if (result.get(key).size() > 1) {
                finalResult.put(key, result.get(key));
            }
        });
        return finalResult;
    }
}
