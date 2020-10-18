package programming.practise.leetcodes.arrays;

//买卖股票的最佳时机 II
public class SellStock {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int slowIndex = 0;
        int profit = 0;
        for (int fastIndex = 1; fastIndex < prices.length; fastIndex++) {
            if (prices[fastIndex] >= prices[slowIndex]) {
                profit += prices[fastIndex] - prices[slowIndex];
            }
            slowIndex = fastIndex;
        }
        return profit;
    }
}
