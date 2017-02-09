package example.practise.katas.karate_data_munging;

import java.io.IOException;
import java.util.List;

public class SmallestGoalSpread {
    private final String FILENAME = "football.dat";
    private final String SKIP_HEAD = "Team";
    private final String SKIP_TAIL = "--";
    private final int FIRST_COLUMN = 1;
    private final int SECOND_COLUMN = 6;
    private final int THIRD_COLUMN = 8;
    private final FileParserUtils fileParserUtils;
    private final ComparatorFactory comparatorFactory;
    private List<FileContent> fileContentList;

    public SmallestGoalSpread() {
        fileParserUtils = new FileParserUtils(FILENAME, SKIP_HEAD, SKIP_TAIL, FIRST_COLUMN, SECOND_COLUMN, THIRD_COLUMN);
        comparatorFactory = new ComparatorFactory();
    }

    public FileContent calculateSmallestGoalSpread() throws IOException {
        fileContentList = fileParserUtils.readFile();
        fileContentList.forEach(FileContent::setResult);
        return fileContentList
                .stream()
                .reduce(comparatorFactory.getMinimalComparator())
                .get();

    }

    public List<FileContent> getTeamInfoList() {
        return fileContentList;
    }

}
