package programming.practise.katas.karate_data_munging;

import java.util.function.BinaryOperator;

public class ComparatorFactory {

    public BinaryOperator<FileContent> getMinimalComparator() {
        return (firstContent, secondContent)
                -> firstContent.getResult() < secondContent.getResult()
                ? firstContent : secondContent;
    }
}
