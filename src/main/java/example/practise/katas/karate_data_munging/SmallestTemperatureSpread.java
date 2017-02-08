package example.practise.katas.karate_data_munging;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.io.FileUtils.readLines;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class SmallestTemperatureSpread {
    private final String FILENAME = "weather.dat";
    private final String ENCODING = "utf-8";
    private final String FIRST_SKIP_LINE_HEAD = "Dy";
    private final String LAST_SKIP_LINE_HEAD = "mo";
    private final String DELIMITER = " ";
    private final int FIRST_COLUMN = 0;
    private final int SECOND_COLUMN = 1;
    private final int THIRD_COLUMN = 2;
    private List<DailyTemperature> dailyTemperatureDataList;

    public DailyTemperature calculateSmallestTemperatureSpread() throws IOException {
        dailyTemperatureDataList = buildDailyTemperatureDataList();
        dailyTemperatureDataList.forEach(this::calculateTemperatureSpread);
        return dailyTemperatureDataList
                .stream()
                .reduce((firstDailyTemperature, secondDailyTemperature)
                        -> firstDailyTemperature.getTemperatureSpread() < secondDailyTemperature.getTemperatureSpread()
                        ? firstDailyTemperature : secondDailyTemperature)
                .get();
    }

    private List<DailyTemperature> buildDailyTemperatureDataList() throws IOException {
        final URL filePath = this.getClass().getClassLoader().getResource(FILENAME);
        final List<String> fileContent = readLines(new File(filePath.getPath()), ENCODING);
        return fileContent
                .stream()
                .filter(content -> !isBlank(content))
                .filter(this::isSkipLine)
                .map(this::buildDailyTemperature)
                .collect(Collectors.toList());
    }

    private boolean isSkipLine(String content) {
        return !(content.contains(FIRST_SKIP_LINE_HEAD) || content.contains(LAST_SKIP_LINE_HEAD));
    }

    private DailyTemperature buildDailyTemperature(String content) {
        List<String> items = Arrays.stream(content.trim().split(DELIMITER))
                .filter(item -> !isBlank(item))
                .collect(Collectors.toList());

        return new DailyTemperature(
                Integer.valueOf(items.get(FIRST_COLUMN)),
                items.get(SECOND_COLUMN),
                items.get(THIRD_COLUMN));
    }

    private void calculateTemperatureSpread(DailyTemperature dailyTemperature) {
        dailyTemperature.setTemperatureSpread();
    }

    public List<DailyTemperature> getDailyTemperatureDataList() {
        return dailyTemperatureDataList;
    }

    public void setDailyTemperatureDataList(List<DailyTemperature> dailyTemperatureDataList) {
        this.dailyTemperatureDataList = dailyTemperatureDataList;
    }
}
