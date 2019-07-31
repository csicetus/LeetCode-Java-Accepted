/*
 * 494. Target Sum
 * Target: You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
 *         Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * Difficulty：Medium
 * Classification：DP, DFS
 */

/*
 * Solution 1
 * 2019-07-31  Runtime: 380 ms
 * Algorithm: => DFS.
 * Time Complexity: ?. Space Conplexity: ?
 */
 
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return helperDFS(nums, S, 0, 0);
    }
    
    private int helperDFS(int[] nums, int tar, int sum, int index) {
        if (nums.length == index) {
            return sum == tar ? 1 : 0;
        }
        return helperDFS(nums, tar, sum + nums[index], index + 1) + helperDFS(nums, tar, sum - nums[index], index + 1);
    }
}


/*
 * Solution 2
 * 2019-07-31  Runtime: 1 ms
 * Algorithm: => DP. The original problem statement is equivalent to:
 *               Find a subset of nums that need to be positive, and the rest of them negative, such that the sum is equal to target.
 *               sum(P) - sum(N) = target
 *               sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
 *               2 * sum(P) = target + sum(nums) => Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2
 * Time Complexity: ?. Space Conplexity: O(N)
 */
 
 class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum < S || (sum + S) % 2 > 0) {
            return 0;
        }
        S = (S + sum) >> 1;
        int[] dp = new int[S + 1];
        dp[0] = 1; 
        for (int n : nums) {
            for (int i = S; i >= n; i--) {
                dp[i] += dp[i - n]; 
            }
        }
        return dp[S];
    }
}


 
