/*
 * 416. Partition Equal Subset Sum
 * Target: Given a non-empty array containing only positive integers, 
 *         find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * Difficulty：Medium
 * Classification：DP
 */

/*
 * Solution 1
 * 2019-07-31  Runtime: 18 ms
 * Algorithm: => DP. 0/1 knapsack problem.
 *               Assume dp[i][j] means whether the specific sum j can be gotten from the first i numbers
 * Time Complexity: ?. Space Conplexity: O(n^2)
 */
 
 class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum & 1) == 1) return false;
        sum /= 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }
        dp[0][0] = true;
        for (int i = 1; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum];
    }
}
 
 /*
 * Solution 2
 * 2019-07-31  Runtime: 12 ms
 * Algorithm: => DP. Optimal of sol 1.
 * Time Complexity: ?. Space Conplexity: O(n)
 */
 
 class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum & 1) == 1) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);

        dp[0] = true;
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j >= nums[i - 1]) {
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
        }
        return dp[sum];
    }
}
