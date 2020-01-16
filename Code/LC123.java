///////////// sol 1: DP

// Time: O(n); Space: O(1)
// stock => transactions k = 2
class Solution {
    public int maxProfit(int[] prices) {
        int T_i20 = 0, T_i21 = Integer.MIN_VALUE;
        int T_i10 = 0, T_i11 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            // T_i20 = max(T_(i-1)20, T_(i-1)21 + prices[i])
            T_i20 = Math.max(T_i20, T_i21 + prices[i]);
            // T_i21 = max(T_(i-1)21, T_(i-1)10 - prices[i])
            T_i21 = Math.max(T_i21, T_i10 - prices[i]);
            // T_i10 = max(T_(i-1)10, T_(i-1)11 + prices[i])
            T_i10 = Math.max(T_i10, T_i11 + prices[i]);
            // T_i11 = max(T_(i-1)11, T_(i-1)00 - prices[i])
            T_i11 = Math.max(T_i11, -prices[i]);
        }
        return T_i20;
    }
}
