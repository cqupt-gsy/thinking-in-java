package example.practise.katas.karate_data_munging;

public class DailyTemperature {
    private int day;
    private String maxTemperature;
    private String minTemperature;
    private int temperatureSpread;

    public DailyTemperature(int day, String maxTemperature, String minTemperature) {
        this.day = day;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
    }

    public int getDay() {
        return day;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public int getTemperatureSpread() {
        return temperatureSpread;
    }

    public void setTemperatureSpread() {
        int maxTemperature = parseTemperature(this.getMaxTemperature());
        int minTemperature = parseTemperature(this.getMinTemperature());
        this.temperatureSpread = maxTemperature - minTemperature;
    }

    private int parseTemperature(String temperature) {
        if (temperature.contains("*")) {
            temperature = temperature.substring(0, temperature.indexOf("*"));
        }
        return Integer.valueOf(temperature);
    }
}
