/////////////// sol 1: DP

// Time: O(n); Space: O(1)
// stock => transactions k = Inf
class Solution {
    public int maxProfit(int[] prices) {
        int T_ik0 = 0;
        int T_ik1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            // T_ik0 = max(T_ik0, T_ik1 + prices[i]);
            T_ik0 = Math.max(T_ik0, T_ik1 + prices[i]);
            // T_ik1 = max(T_ik1, T_i(k-1)0 - prices[i]);
            // T_i(k-1)0 = T_ik0 when k = Inf
            T_ik1 = Math.max(T_ik1, T_ik0 - prices[i]);
        }
        return T_ik0;
    }
}
