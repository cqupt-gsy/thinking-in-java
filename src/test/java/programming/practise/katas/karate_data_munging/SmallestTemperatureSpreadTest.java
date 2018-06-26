package programming.practise.katas.karate_data_munging;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class SmallestTemperatureSpreadTest {

    private SmallestTemperatureSpread smallestTemperatureSpread;

    @Before
    public void setUp() throws Exception {
        smallestTemperatureSpread = new SmallestTemperatureSpread();
    }

    @Test
    public void shouldReturnDataListFromWeatherFile() throws IOException {
        //When
        smallestTemperatureSpread.calculateSmallestTemperatureSpread();

        //Then
        assertThat(smallestTemperatureSpread.getFileContentList().size()).isEqualTo(30);
        assertThat(smallestTemperatureSpread.getFileContentList().get(0).getFirstColumn()).isNotEqualTo("Dy");
        assertThat(smallestTemperatureSpread.getFileContentList().get(0).getFirstColumn()).isEqualTo("1");
        assertThat(smallestTemperatureSpread.getFileContentList().get(0).getSecondColumn()).isEqualTo("88");
        assertThat(smallestTemperatureSpread.getFileContentList().get(0).getThirdColumn()).isEqualTo("59");
        assertThat(smallestTemperatureSpread.getFileContentList().get(29).getFirstColumn()).isNotEqualTo("mo");
        assertThat(smallestTemperatureSpread.getFileContentList().get(29).getFirstColumn()).isEqualTo("30");
        assertThat(smallestTemperatureSpread.getFileContentList().get(29).getSecondColumn()).isEqualTo("90");
        assertThat(smallestTemperatureSpread.getFileContentList().get(29).getThirdColumn()).isEqualTo("45");
        assertThat(smallestTemperatureSpread.getFileContentList().get(8).getFirstColumn()).isEqualTo("9");
        assertThat(smallestTemperatureSpread.getFileContentList().get(8).getSecondColumn()).isEqualTo("86");
        assertThat(smallestTemperatureSpread.getFileContentList().get(8).getThirdColumn()).isEqualTo("32*");
        assertThat(smallestTemperatureSpread.getFileContentList().get(25).getFirstColumn()).isEqualTo("26");
        assertThat(smallestTemperatureSpread.getFileContentList().get(25).getSecondColumn()).isEqualTo("97*");
        assertThat(smallestTemperatureSpread.getFileContentList().get(25).getThirdColumn()).isEqualTo("64");

    }

    @Test
    public void shouldReturnDataListWithTemperatureSpread() throws IOException {
        //When
        smallestTemperatureSpread.calculateSmallestTemperatureSpread();

        //Then
        assertThat(smallestTemperatureSpread.getFileContentList().get(0).getResult()).isEqualTo(29);
        assertThat(smallestTemperatureSpread.getFileContentList().get(29).getResult()).isEqualTo(45);
    }

    @Test
    public void shouldReturnSmallestTemperatureSpread() throws IOException {
        //When
        FileContent fileContent = smallestTemperatureSpread.calculateSmallestTemperatureSpread();

        //Then
        assertThat(fileContent.getFirstColumn()).isEqualTo("14");
        assertThat(fileContent.getSecondColumn()).isEqualTo("61");
        assertThat(fileContent.getThirdColumn()).isEqualTo("59");
        assertThat(fileContent.getResult()).isEqualTo(2);
    }
}
