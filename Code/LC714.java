/////////////// sol 1: DP

// Time: O(n); Space: O(1)
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // day(i-1): sell; day(i): nothing => cash[i - 1]
            // day(i-1): hold; day(1): sell => hold[i - 1] + prices - fee
            // cash[i] = max(cash[i - 1], hold[i - 1] + prices[i] - fee)
            cash = Math.max(cash, hold + prices[i] - fee);
            
            // day(i-1): hold; day(i): nothing => hold[i - 1]
            // day(i-1): sell; day(1): buy => cash[i - 1] + prices[i]
            // day(i-1): hold; day(1): sell and buy => 
            //          (hold[i - 1] + prices[i] - fee) - prices[i] 
            //          = hold[i - 1] - fee < hold[i - 1]
            // cash[i] = max(hold[i - 1], cash[i - 1] + prices[i])
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
