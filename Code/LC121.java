/////////////// sol 1: one pass

// Time: O(n); Space: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}


//////////////// sol 2: one  pass (stock series)

// Time: O(n); Space: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int T_i10 = 0;
        int T_i11 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            // T_i10 = max(T_i10, T_i11 + prices[i]);
            T_i10 = Math.max(T_i10, T_i11 + prices[i]);
            // T_i11 = max(T_i11, T_i00 - prices[i]);
            // T_i00 = 0
            T_i11 = Math.max(T_i11, -prices[i]);
        }
        return T_i10;
    }
}
