package example.practise.katas.katate_conflict_objective;

import example.practise.katas.karate_data_munging.FileParserUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.collect.ImmutableSet.copyOf;

public class ConflictObjective {

    private final String FILENAME = "wordlist.txt";
    private List<String> wordNeedToMatch;
    private int wordLength = 6;
    private FileParserUtils fileParserUtils;
    private Set<String> pairWordList; //if using contains and the content is huge, should be use Set than List

    public ConflictObjective() throws IOException {
        initialParameters();
    }

    public ConflictObjective(int wordLength) throws IOException {
        this.wordLength = wordLength;
        initialParameters();
    }

    public List<String> generateConflictObjective() {
        return wordNeedToMatch
                .stream()
                .map(this::matchPairs)
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toList());
    }

    private String matchPairs(String word) {
        for (int endIndex = 1; endIndex < wordLength; endIndex++) {
            String prefix = word.substring(0, endIndex);
            String suffix = word.substring(endIndex);
            if (pairWordList.contains(prefix) && pairWordList.contains(suffix)) {
                return String.format("%s + %s => %s", prefix, suffix, prefix + suffix);
            }
        }
        return null;
    }

    private void initialParameters() throws IOException {
        this.fileParserUtils = new FileParserUtils();
        wordNeedToMatch = new ArrayList<>();
        pairWordList = new HashSet<>();
        constructWordList();
    }

    private void constructWordList() throws IOException {
        copyOf(fileParserUtils.readFile(FILENAME)).forEach(word -> {
            if (word.length() == wordLength) {
                wordNeedToMatch.add(word);
            } else if (word.length() < wordLength) {
                pairWordList.add(word);
            }
        });
    }
}
