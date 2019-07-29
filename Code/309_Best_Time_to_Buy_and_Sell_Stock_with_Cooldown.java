/*
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * Target: Design an algorithm to find the maximum profit. Buy one and sell one share of the stock multiple times)
 *         You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *         After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Difficulty：Medium
 * Classification：DP
 * Same as 121. Best Time to Buy and Sell Stock, 122 Best Time to Buy and Sell Stock II
 */

/*
 * Solution 1
 * 2019-07-29  Runtime: 0 ms
 * Algorithm: => DP. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75931/Easiest-JAVA-solution-with-explanations
 * Time Complexity: O(n). Space Conplexity: O(1)
 */
 
 class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;
        for (int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s0;
    }
}
