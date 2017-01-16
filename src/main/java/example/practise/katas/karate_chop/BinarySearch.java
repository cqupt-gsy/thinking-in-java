package example.practise.katas.karate_chop;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class BinarySearch {

    private static final int DEFAULT_RESULT = -1;

    Function<Integer, Integer> loopChop(List<Integer> dataList) {
        return element -> {
            if (dataList != null) {
                int beginIndices = 0;
                int endIndices = dataList.size();
                while (beginIndices != endIndices) {
                    int midIndices = (beginIndices + endIndices) / 2;
                    Integer rawData = dataList.get(midIndices);
                    if (isTestDataSmallerThan(rawData).test(element)) {
                        endIndices = midIndices;
                    } else if (isTestDataSmallerThan(element).test(rawData)) {
                        beginIndices = midIndices;
                        ++beginIndices;
                    } else {
                        return midIndices;
                    }
                }
            }
            return DEFAULT_RESULT;
        };
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

    Integer apiChop(Integer element, List<Integer> dataList) {
        int result = Collections.binarySearch(dataList, element);
        return result < 0 ? DEFAULT_RESULT : result;
    }

    Integer funChop(Integer element, List<Integer> dataList) {
        if (dataList.isEmpty()) {
            return DEFAULT_RESULT;
        }
        int midIndices = dataList.size() / 2;
        for (int i = 0; i < dataList.size(); i++) {
            Integer midValue = dataList.get(midIndices);
            if (midValue.equals(element)) {
                return midIndices;
            } else if (isTestDataSmallerThan(midValue).test(element)) {
                midIndices = midIndices / 2;
                midIndices = midIndices < 0 ? 0 : midIndices;
            } else {
                midIndices = (++midIndices + dataList.size()) / 2;
                midIndices = midIndices > dataList.size() - 1 ? dataList.size() - 1 : midIndices;
            }
        }
        return DEFAULT_RESULT;
    }
}
