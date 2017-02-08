package example.practise.katas.karate_data_munging;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.io.FileUtils.readLines;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class SmallestGoalSpread {
    private final String FILENAME = "football.dat";
    private final String ENCODING = "utf-8";
    private final String FIRST_SKIP_LINE_HEAD = "Team";
    private final String LAST_SKIP_LINE_HEAD = "--";
    private final String DELIMITER = " ";
    private final int FIRST_COLUMN = 1;
    private final int SECOND_COLUMN = 6;
    private final int THIRD_COLUMN = 8;
    private List<TeamInfo> teamInfoList;

    public TeamInfo calculateSmallestGoalSpread() throws IOException {
        teamInfoList = buildTeamInfoList();
        teamInfoList.forEach(this::calculateGoalSpread);
        return teamInfoList
                .stream()
                .reduce((firstTeamInfo, secondTeamInfo)
                        -> firstTeamInfo.getScoreSpread() < secondTeamInfo.getScoreSpread()
                        ? firstTeamInfo : secondTeamInfo)
                .get();

    }

    private List<TeamInfo> buildTeamInfoList() throws IOException {
        final URL filePath = this.getClass().getClassLoader().getResource(FILENAME);
        final List<String> fileContent = readLines(new File(filePath.getPath()), ENCODING);
        return fileContent
                .stream()
                .filter(content -> !isBlank(content))
                .filter(this::isSkipLine)
                .map(this::buildTeamInfo)
                .collect(Collectors.toList());
    }

    private boolean isSkipLine(String content) {
        return !(content.contains(FIRST_SKIP_LINE_HEAD) || content.contains(LAST_SKIP_LINE_HEAD));
    }

    private TeamInfo buildTeamInfo(String content) {
        List<String> items = Arrays.stream(content.trim().split(DELIMITER))
                .filter(item -> !isBlank(item))
                .collect(Collectors.toList());

        return new TeamInfo(
                items.get(FIRST_COLUMN),
                Integer.valueOf(items.get(SECOND_COLUMN)),
                Integer.valueOf(items.get(THIRD_COLUMN)));
    }


    public List<TeamInfo> getTeamInfoList() {
        return teamInfoList;
    }

    private void calculateGoalSpread(TeamInfo teamInfo) {
        teamInfo.setScoreSpread();
    }
}
