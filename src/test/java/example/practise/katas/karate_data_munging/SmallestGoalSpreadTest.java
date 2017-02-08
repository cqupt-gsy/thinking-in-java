package example.practise.katas.karate_data_munging;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class SmallestGoalSpreadTest {

    private SmallestGoalSpread smallestGoalSpread;

    @Before
    public void setUp() throws Exception {
        smallestGoalSpread = new SmallestGoalSpread();
    }

    @Test
    public void shouldReturnDataListFromFootballFile() throws IOException {
        //When
        smallestGoalSpread.calculateSmallestGoalSpread();

        //Then
        assertThat(smallestGoalSpread.getTeamInfoList().size()).isEqualTo(20);
        assertThat(smallestGoalSpread.getTeamInfoList().get(0).getTeamName()).isNotEqualTo("Team");
        assertThat(smallestGoalSpread.getTeamInfoList().get(0).getTeamName()).isEqualTo("Arsenal");
        assertThat(smallestGoalSpread.getTeamInfoList().get(0).getScored()).isEqualTo(79);
        assertThat(smallestGoalSpread.getTeamInfoList().get(0).getAgainstScored()).isEqualTo(36);
        assertThat(smallestGoalSpread.getTeamInfoList().get(19).getTeamName()).isEqualTo("Leicester");
        assertThat(smallestGoalSpread.getTeamInfoList().get(19).getScored()).isEqualTo(30);
        assertThat(smallestGoalSpread.getTeamInfoList().get(19).getAgainstScored()).isEqualTo(64);
    }

    @Test
    public void shouldReturnDataListWithScoreSpread() throws IOException {
        //When
        smallestGoalSpread.calculateSmallestGoalSpread();

        //Then
        assertThat(smallestGoalSpread.getTeamInfoList().get(0).getScoreSpread()).isEqualTo(43);
        assertThat(smallestGoalSpread.getTeamInfoList().get(19).getScoreSpread()).isEqualTo(34);
    }

    @Test
    public void shouldReturnSmallestTemperatureSpread() throws IOException {
        //When
        TeamInfo teamInfo = smallestGoalSpread.calculateSmallestGoalSpread();

        //Then
        assertThat(teamInfo.getTeamName()).isEqualTo("Aston_Villa");
        assertThat(teamInfo.getScored()).isEqualTo(46);
        assertThat(teamInfo.getAgainstScored()).isEqualTo(47);
        assertThat(teamInfo.getScoreSpread()).isEqualTo(1);
    }

}
