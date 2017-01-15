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
                if (isTestDataSmallerThan(dataList.get(midIndices)).test(element)) {
                    endIndices = midIndices;
                } else if (isTestDataSmallerThan(element).test(dataList.get(midIndices))) {
                    beginIndices = midIndices;
                    ++beginIndices;
                } else {
                    return midIndices;
                }
            }
        }
        return DEFAULT_RESULT;
    }

    Integer recursiveChop(Integer element, List<Integer> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            return DEFAULT_RESULT;
        }
        return recursiveHelper(element, dataList, 0, dataList.size());
    }

    private Integer recursiveHelper(Integer element, List<Integer> dataList, Integer beginIndices, Integer endIndices) {
        if (beginIndices > endIndices || beginIndices >= dataList.size() || endIndices < 0) {
            return DEFAULT_RESULT;
        }
        int midIndices = (beginIndices + endIndices) / 2;
        if (isTestDataSmallerThan(dataList.get(midIndices)).test(element)) {
            return recursiveHelper(element, dataList, beginIndices, --midIndices);
        } else if (isTestDataSmallerThan(element).test(dataList.get(midIndices))) {
            return recursiveHelper(element, dataList, ++midIndices, endIndices);
        } else {
            return midIndices;
        }
    }

    private Predicate<Integer> isTestDataSmallerThan(Integer rawData) {
        return targets -> targets < rawData;
    }
}
