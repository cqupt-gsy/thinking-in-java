package example.practise.katas.karate_data_munging;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SmallestGoalSpread {
    private final String FILENAME = "football.dat";
    private final String SKIP_HEAD = "Team";
    private final String SKIP_TAIL = "--";
    private final String DELIMITER = " ";
    private final int FIRST_COLUMN = 1;
    private final int SECOND_COLUMN = 6;
    private final int THIRD_COLUMN = 8;
    private final FileParserUtils fileParserUtils;
    private List<TeamInfo> teamInfoList;

    public SmallestGoalSpread() {
        fileParserUtils = new FileParserUtils(FILENAME, SKIP_HEAD, SKIP_TAIL, FIRST_COLUMN, SECOND_COLUMN, THIRD_COLUMN);
    }

    public TeamInfo calculateSmallestGoalSpread() throws IOException {
        teamInfoList = buildTeamInfoList();
        teamInfoList.forEach(TeamInfo::setScoreSpread);
        return teamInfoList
                .stream()
                .reduce((firstTeamInfo, secondTeamInfo)
                        -> firstTeamInfo.getScoreSpread() < secondTeamInfo.getScoreSpread()
                        ? firstTeamInfo : secondTeamInfo)
                .get();

    }

    private List<TeamInfo> buildTeamInfoList() throws IOException {
        return fileParserUtils.readFile()
                .map((content) -> buildTeamInfo())
                .collect(Collectors.toList());
    }

    private TeamInfo buildTeamInfo() {
        return new TeamInfo(
                fileParserUtils.getFirstColumnInfo(),
                Integer.valueOf(fileParserUtils.getSecondColumnInfo()),
                Integer.valueOf(fileParserUtils.getThirdColumnInfo()));
    }


    public List<TeamInfo> getTeamInfoList() {
        return teamInfoList;
    }

}
