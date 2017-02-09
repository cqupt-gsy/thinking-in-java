package example.practise.katas.karate_data_munging;

import java.io.IOException;
import java.util.List;

public class SmallestTemperatureSpread {
    private final String FILENAME = "weather.dat";
    private final String SKIP_HEAD = "Dy";
    private final String SKIP_TAIL = "mo";
    private final FileParserUtils fileParserUtils;
    private final ComparatorFactory comparatorFactory;
    private List<FileContent> fileContentList;

    public SmallestTemperatureSpread() {
        fileParserUtils = new FileParserUtils(FILENAME, SKIP_HEAD, SKIP_TAIL);
        comparatorFactory = new ComparatorFactory();
    }

    public FileContent calculateSmallestTemperatureSpread() throws IOException {
        fileContentList = fileParserUtils.readFile();
        fileContentList.forEach(FileContent::setResult);
        return fileContentList
                .stream()
                .reduce(comparatorFactory.getMinimalComparator())
                .get();
    }

    public List<FileContent> getFileContentList() {
        return fileContentList;
    }

}
