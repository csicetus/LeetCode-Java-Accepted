/*
 * 121. Best Time to Buy and Sell Stock
 * Target: Design an algorithm to find the maximum profit.
 * Difficulty：Easy
 * Classification：Array, DP
 */

/*
 * Solution 1
 * 2019-07-26  Runtime: 240 ms
 * Algorithm: => Brutal.
 * Time Complexity: O(n^2). Space Conplexity: O(1)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > max_profit) {
                    max_profit = prices[j] - prices[i];
                }
            }
        }
        return max_profit;
    }
}


/*
 * Solution 2
 * 2019-07-26  Runtime: 0 ms
 * Algorithm: => One Pass.
 * Time Complexity: O(n). Space Conplexity: O(1)
 * Note: It can also transfer to min_price, for loop should start from 0.
 */

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int max_price = Integer.MIN_VALUE;
        int max_profit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max_price) {
                max_price = prices[i];
            } else if (max_price - prices[i] > max_profit) {
                max_profit = max_price - prices[i];
            }
        }
        return max_profit;
    }
}
