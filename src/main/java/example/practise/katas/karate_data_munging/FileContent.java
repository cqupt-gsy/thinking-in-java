package example.practise.katas.karate_data_munging;

import static java.lang.Math.abs;

public class FileContent {
    protected String firstColumn;
    protected String secondColumn;
    protected String thirdColumn;
    private int result;

    public FileContent(String firstColumn, String secondColumn, String thirdColumn) {
        this.firstColumn = firstColumn;
        this.secondColumn = secondColumn;
        this.thirdColumn = thirdColumn;
    }

    public String getFirstColumn() {
        return firstColumn;
    }

    public String getSecondColumn() {
        return secondColumn;
    }

    public String getThirdColumn() {
        return thirdColumn;
    }

    public int getResult() {
        return result;
    }

    public void setResult() {
        int maxValue = parseValue(secondColumn);
        int minValue = parseValue(thirdColumn);
        result = abs(maxValue - minValue);
    }

    private int parseValue(String value) {
        if (value.contains("*")) {
            value = value.substring(0, value.indexOf("*"));
        }
        return Integer.valueOf(value);
    }
}
