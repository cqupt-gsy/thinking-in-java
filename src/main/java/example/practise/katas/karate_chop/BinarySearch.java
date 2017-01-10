package example.practise.katas.karate_chop;

import java.util.List;
import java.util.function.Predicate;

class BinarySearch {

    private static final int DEFAULT_RESULT = -1;

    Integer loopChop(Integer element, List<Integer> dataList) {
        if (dataList != null) {
            int beginIndices = 0;
            int endIndices = dataList.size();
            while (beginIndices != endIndices) {
                int midIndices = (beginIndices + endIndices) / 2;
                if (createCompareRule(dataList.get(midIndices)).test(element)) {
                    endIndices = midIndices;
                } else if (createCompareRule(element).test(dataList.get(midIndices))) {
                    beginIndices = midIndices;
                    ++beginIndices;
                } else {
                    return midIndices;
                }
            }
        }
        return DEFAULT_RESULT;
    }

    public Integer recursiveChop(Integer element, List<Integer> dataList) {
        return null;
    }

    private Predicate<Integer> createCompareRule(Integer origin) {
        return targets -> targets < origin;
    }
}
