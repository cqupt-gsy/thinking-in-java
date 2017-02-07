package example.practise.katas.karate_data_munging;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class SmallestTemperatureSpreadTest {

    @Test
    public void shouldReturnDataListFromWeatherFile() throws IOException {
        //Given
        SmallestTemperatureSpread smallestTemperatureSpread = new SmallestTemperatureSpread();

        //When
        smallestTemperatureSpread.calculateSmallestTemperatureSpread();

        //Then
        assertThat(smallestTemperatureSpread.getDailyTemperatureDataList().size()).isEqualTo(30);
        assertThat(smallestTemperatureSpread.getDailyTemperatureDataList().get(0).getDay()).isNotEqualTo("Dy");
        assertThat(smallestTemperatureSpread.getDailyTemperatureDataList().get(0).getDay()).isEqualTo(1);
        assertThat(smallestTemperatureSpread.getDailyTemperatureDataList().get(0).getMaxTemperature()).isEqualTo("88");
        assertThat(smallestTemperatureSpread.getDailyTemperatureDataList().get(0).getMinTemperature()).isEqualTo("59");
        assertThat(smallestTemperatureSpread.getDailyTemperatureDataList().get(29).getDay()).isNotEqualTo("mo");
        assertThat(smallestTemperatureSpread.getDailyTemperatureDataList().get(29).getDay()).isEqualTo(30);
        assertThat(smallestTemperatureSpread.getDailyTemperatureDataList().get(29).getMaxTemperature()).isEqualTo("90");
        assertThat(smallestTemperatureSpread.getDailyTemperatureDataList().get(29).getMinTemperature()).isEqualTo("45");
        assertThat(smallestTemperatureSpread.getDailyTemperatureDataList().get(8).getDay()).isEqualTo(9);
        assertThat(smallestTemperatureSpread.getDailyTemperatureDataList().get(8).getMaxTemperature()).isEqualTo("86");
        assertThat(smallestTemperatureSpread.getDailyTemperatureDataList().get(8).getMinTemperature()).isEqualTo("32*");
        assertThat(smallestTemperatureSpread.getDailyTemperatureDataList().get(25).getDay()).isEqualTo(26);
        assertThat(smallestTemperatureSpread.getDailyTemperatureDataList().get(25).getMaxTemperature()).isEqualTo("97*");
        assertThat(smallestTemperatureSpread.getDailyTemperatureDataList().get(25).getMinTemperature()).isEqualTo("64");

    }

    @Test
    public void shouldReturnDataListWithTemperatureSpread() throws IOException {
        //Given
        SmallestTemperatureSpread smallestTemperatureSpread = new SmallestTemperatureSpread();

        //When
        smallestTemperatureSpread.calculateSmallestTemperatureSpread();

        //Then
        assertThat(smallestTemperatureSpread.getDailyTemperatureDataList().get(0).getTemperatureSpread()).isEqualTo(29);
        assertThat(smallestTemperatureSpread.getDailyTemperatureDataList().get(29).getTemperatureSpread()).isEqualTo(45);
    }

    @Test
    public void shouldReturnSmallestTemperatureSpread() throws IOException {
        //Given
        SmallestTemperatureSpread smallestTemperatureSpread = new SmallestTemperatureSpread();

        //When
        DailyTemperature dailyTemperature = smallestTemperatureSpread.calculateSmallestTemperatureSpread();

        //Then
        assertThat(dailyTemperature.getDay()).isEqualTo(14);
        assertThat(dailyTemperature.getMaxTemperature()).isEqualTo("61");
        assertThat(dailyTemperature.getMinTemperature()).isEqualTo("59");
        assertThat(dailyTemperature.getTemperatureSpread()).isEqualTo(2);
    }
}
