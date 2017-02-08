package example.practise.katas.karate_data_munging;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.commons.io.FileUtils.readLines;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class FileParserUtils {

    private String filename;

    private String skipHead;
    private String skipTail;

    private String firstColumnInfo;
    private String secondColumnInfo;
    private String thirdColumnInfo;

    private int firstColumn = 0;
    private int secondColumn = 1;
    private int thirdColumn = 2;
    private String delimiter = " ";
    private String encoding = "utf-8";

    public FileParserUtils(String filename, String skipHead, String skipTail) {
        this.filename = filename;
        this.skipHead = skipHead;
        this.skipTail = skipTail;
    }

    public FileParserUtils(
            String filename,
            String skipHead,
            String skipTail,
            int firstColumn,
            int secondColumn,
            int thirdColumn) {
        this.filename = filename;
        this.skipHead = skipHead;
        this.skipTail = skipTail;
        this.firstColumn = firstColumn;
        this.secondColumn = secondColumn;
        this.thirdColumn = thirdColumn;
    }


    public FileParserUtils(
            String filename,
            String skipHead,
            String skipTail,
            String encoding,
            String delimiter,
            int firstColumn,
            int secondColumn,
            int thirdColumn) {
        this.encoding = encoding;
        this.filename = filename;
        this.skipHead = skipHead;
        this.skipTail = skipTail;
        this.delimiter = delimiter;
        this.firstColumn = firstColumn;
        this.secondColumn = secondColumn;
        this.thirdColumn = thirdColumn;
    }

    Stream<String> readFile() throws IOException {
        return ((List<String>) readLines(new File(
                this.getClass().getClassLoader().getResource(filename).getPath()), encoding))
                .stream()
                .filter(content -> !isBlank(content));
    }

    boolean isSkipLine(String content) {
        return !(content.contains(skipHead) || content.contains(skipTail));
    }

    void parseLine(String content) {
        final List<String> lineItems = Arrays.stream(content.trim().split(delimiter))
                .filter(item -> !isBlank(item))
                .collect(Collectors.toList());
        setFirstColumnInfo(lineItems.get(firstColumn));
        setSecondColumnInfo(lineItems.get(secondColumn));
        setThirdColumnInfo(lineItems.get(thirdColumn));
    }

    public void setFirstColumnInfo(String firstColumnInfo) {
        this.firstColumnInfo = firstColumnInfo;
    }

    public String getFirstColumnInfo() {
        return firstColumnInfo;
    }

    public void setSecondColumnInfo(String secondColumnInfo) {
        this.secondColumnInfo = secondColumnInfo;
    }

    public String getSecondColumnInfo() {
        return secondColumnInfo;
    }

    public void setThirdColumnInfo(String thirdColumnInfo) {
        this.thirdColumnInfo = thirdColumnInfo;
    }

    public String getThirdColumnInfo() {
        return thirdColumnInfo;
    }
}
