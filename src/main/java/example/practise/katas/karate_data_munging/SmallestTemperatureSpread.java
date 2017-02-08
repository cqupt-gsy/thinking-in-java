package example.practise.katas.karate_data_munging;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SmallestTemperatureSpread {
    private final String FILENAME = "weather.dat";
    private final String SKIP_HEAD = "Dy";
    private final String SKIP_TAIL = "mo";
    private final FileParserUtils fileParserUtils;
    private List<DailyTemperature> dailyTemperatureDataList;

    public SmallestTemperatureSpread() {
        fileParserUtils = new FileParserUtils(FILENAME, SKIP_HEAD, SKIP_TAIL);
    }

    public DailyTemperature calculateSmallestTemperatureSpread() throws IOException {
        dailyTemperatureDataList = buildDailyTemperatureDataList();
        dailyTemperatureDataList.forEach(DailyTemperature::setTemperatureSpread);
        return dailyTemperatureDataList
                .stream()
                .reduce((firstDailyTemperature, secondDailyTemperature)
                        -> firstDailyTemperature.getTemperatureSpread() < secondDailyTemperature.getTemperatureSpread()
                        ? firstDailyTemperature : secondDailyTemperature)
                .get();
    }

    private List<DailyTemperature> buildDailyTemperatureDataList() throws IOException {
        return fileParserUtils.readFile()
                .filter(fileParserUtils::isSkipLine)
                .map(this::buildDailyTemperature)
                .collect(Collectors.toList());
    }

    private DailyTemperature buildDailyTemperature(String content) {
        fileParserUtils.parseLine(content);

        return new DailyTemperature(
                Integer.valueOf(fileParserUtils.getFirstColumnInfo()),
                fileParserUtils.getSecondColumnInfo(),
                fileParserUtils.getThirdColumnInfo());
    }

    public List<DailyTemperature> getDailyTemperatureDataList() {
        return dailyTemperatureDataList;
    }

}
