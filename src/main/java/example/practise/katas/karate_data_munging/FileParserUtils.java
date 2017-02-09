/*
* 心得：
* 1. 解决问题永远不要想太远，重复利用的事情留给重构来做（不要过度设计）
* 2. 重构时一定要以解决坏味道为目的，不需要套用设计模式，设计模式是重构出来的
* 3. 这次重构手法不熟练，需要继续练习
* 4. 这次重构刚开始就想着套用设计模式（导致重构步伐太大，并发现不可用），是错误的，需要引起注意
* 5. 这次重构的步伐跨度有点大，下次要小步重构（不要太小，找到自己合适的步伐即可）
*/



package example.practise.katas.karate_data_munging;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.io.FileUtils.readLines;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class FileParserUtils {

    private String filename;

    private String skipHead;
    private String skipTail;

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


    List<FileContent> readFile() throws IOException {
        return ((List<String>) readLines(new File(
                this.getClass().getClassLoader().getResource(filename).getPath()), encoding))
                .stream()
                .filter(content -> !isBlank(content) && this.isSkipLine(content))
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    boolean isSkipLine(String content) {
        return !(content.contains(skipHead) || content.contains(skipTail));
    }

    FileContent parseLine(String content) {
        final List<String> lineItems = Arrays.stream(content.trim().split(delimiter))
                .filter(item -> !isBlank(item))
                .collect(Collectors.toList());
        return new FileContent(lineItems.get(firstColumn), lineItems.get(secondColumn), lineItems.get(thirdColumn));
    }

}
