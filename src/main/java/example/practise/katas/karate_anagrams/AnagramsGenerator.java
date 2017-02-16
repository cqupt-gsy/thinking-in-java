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
        fileParserUtils.readFile(FILENAME)
                .forEach(line -> {
                    String sortedLine = Arrays
                            .stream(line.toLowerCase().split(""))
                            .sorted()
                            .collect(Collectors.joining());
                    List<String> anagrams = result.get(sortedLine);
                    if (anagrams == null) {
                        anagrams = new ArrayList<>();
                    }
                    anagrams.add(line);
                    result.put(sortedLine, anagrams);
                });
        return result.entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
