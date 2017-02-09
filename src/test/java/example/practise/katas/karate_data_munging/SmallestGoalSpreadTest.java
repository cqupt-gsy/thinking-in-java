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
        assertThat(smallestGoalSpread.getTeamInfoList().get(0).getFirstColumn()).isNotEqualTo("Team");
        assertThat(smallestGoalSpread.getTeamInfoList().get(0).getFirstColumn()).isEqualTo("Arsenal");
        assertThat(smallestGoalSpread.getTeamInfoList().get(0).getSecondColumn()).isEqualTo("79");
        assertThat(smallestGoalSpread.getTeamInfoList().get(0).getThirdColumn()).isEqualTo("36");
        assertThat(smallestGoalSpread.getTeamInfoList().get(19).getFirstColumn()).isEqualTo("Leicester");
        assertThat(smallestGoalSpread.getTeamInfoList().get(19).getSecondColumn()).isEqualTo("30");
        assertThat(smallestGoalSpread.getTeamInfoList().get(19).getThirdColumn()).isEqualTo("64");
    }

    @Test
    public void shouldReturnDataListWithScoreSpread() throws IOException {
        //When
        smallestGoalSpread.calculateSmallestGoalSpread();

        //Then
        assertThat(smallestGoalSpread.getTeamInfoList().get(0).getResult()).isEqualTo(43);
        assertThat(smallestGoalSpread.getTeamInfoList().get(19).getResult()).isEqualTo(34);
    }

    @Test
    public void shouldReturnSmallestTemperatureSpread() throws IOException {
        //When
        FileContent fileContent = smallestGoalSpread.calculateSmallestGoalSpread();

        //Then
        assertThat(fileContent.getFirstColumn()).isEqualTo("Aston_Villa");
        assertThat(fileContent.getSecondColumn()).isEqualTo("46");
        assertThat(fileContent.getThirdColumn()).isEqualTo("47");
        assertThat(fileContent.getResult()).isEqualTo(1);
    }

}
