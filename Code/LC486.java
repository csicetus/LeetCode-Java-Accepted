////////////// sol 1: DP

// Time: O(n^2); Space: O(n)
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) {
            return true;
        }
        // (n & 1) == 0 will hence be true 
        // if n is even (or negative odd) and false otherwise
        if ((n & 1) == 0) {
            return true;
        }
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // System.out.print("i " + i + " num[i] " + nums[i]);
                // System.out.println("  j" + j + " num[j] " + nums[j]);
                if (i == j) {
                    dp[j] = nums[i];
                } else {
                    dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
                }
            }
        }
        return dp[n - 1] >= 0;
    }
}
