////////////// sol 1: DP

// Time: O(kn); Space: O(k)
// stock => transactions k = arbitrary
class Solution {
    public int maxProfit(int k, int[] prices) {
        // if k >= n / 2, k = Inf
        if (k >= prices.length / 2) {
            int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
            for (int i = 0; i < prices.length; i++) {
                // T_ik0 = max(T_(i-1)k0, T_(i-1)k1 + prices[i]);
                T_ik0 = Math.max(T_ik0, T_ik1 + prices[i]);
                // T_ik1 = max(T_(i-1)k1, T_(i-1)(k-1)0 - prices[i]);
                // T_(i-1)(k-1)0 = T_(i-1)k0 when k = Inf
                T_ik1 = Math.max(T_ik1, T_ik0 - prices[i]);
            }
            return T_ik0;
        }
        
        // if k < n / 2, calculate T[j] one by one
        int[] T_ik0 = new int[k + 1];
        int[] T_ik1 = new int[k + 1];
        Arrays.fill(T_ik1, Integer.MIN_VALUE);
        for (int price: prices) {
            //
            for (int j = k; j > 0; j--) {
                // T_ik0[j] = max(T_(i-1)k0[j - 1], T_(i-1)k1[j - 1] + price);
                T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + price);
                // T_ik1[j] = max(T_(i-1)k1[j - 1], T_(i-1)k0[j - 1] - price);
                T_ik1[j] = Math.max(T_ik1[j], T_ik0[j - 1] - price);
            }
        }
        return T_ik0[k];
    }
}
