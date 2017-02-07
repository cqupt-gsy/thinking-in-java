package example.practise.katas.karate_data_munging;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.io.FileUtils.readLines;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class SmallestTemperatureSpread {
    private final String FILENAME = "weather.dat";
    private final String ENCODING = "utf-8";
    private final String FIRST_SKIP_LINE_HEAD = "Dy";
    private final String LAST_SKIP_LINE_HEAD = "mo";
    private final String FIRST_COLUMN_DELIMITER = "  ";
    private final String THIRD_COLUMN_DELIMITER = "   ";
    private final int FIRST_COLUMN = 0;
    private final int SECOND_COLUMN = 1;
    private final int THIRD_COLUMN = 1;
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

    private void calculateTemperatureSpread(DailyTemperature dailyTemperature) {
        int maxTemperature = parseTemperature(dailyTemperature.getMaxTemperature());
        int minTemperature = parseTemperature(dailyTemperature.getMinTemperature());
        dailyTemperature.setTemperatureSpread(maxTemperature - minTemperature);
    }

    private int parseTemperature(String temperature) {
        if (temperature.contains("*")) {
            temperature = temperature.substring(0, temperature.indexOf("*"));
        }
        return Integer.valueOf(temperature);
    }

    private boolean isSkipLine(String content) {
        return !(content.contains(FIRST_SKIP_LINE_HEAD) || content.contains(LAST_SKIP_LINE_HEAD));
    }
    
    private DailyTemperature buildDailyTemperature(String content) {
        final String[] firstColumnItems = content.trim().split(FIRST_COLUMN_DELIMITER);
        final String[] thirdColumnItems = content.trim().split(THIRD_COLUMN_DELIMITER);
        return new DailyTemperature(
                Integer.valueOf(firstColumnItems[FIRST_COLUMN]),
                firstColumnItems[SECOND_COLUMN].trim(),
                thirdColumnItems[THIRD_COLUMN].trim());
    }

    public List<DailyTemperature> getDailyTemperatureDataList() {
        return dailyTemperatureDataList;
    }

    public void setDailyTemperatureDataList(List<DailyTemperature> dailyTemperatureDataList) {
        this.dailyTemperatureDataList = dailyTemperatureDataList;
    }
}
