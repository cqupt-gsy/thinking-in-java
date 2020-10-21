package programming.practise.leetcodes.arrays;

// 第一个错误的版本
public class BadVersion {
    public static void main(String[] args) {

    }

    public int firstBadVersion(int n) {
        int begin = 1;
        int end = n;
        while (begin < end) {
            int index = begin + (end - begin) / 2;
            if (isBadVersion(index)) {
                end = index;
            } else {
                begin = index + 1;
            }

        }
        return begin;
    }

    private boolean isBadVersion(int index) {
        return false;
    }
}
