/*
 * 279. Perfect Squares
 * Target: Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * Difficulty：Medium
 * Classification：Math, DP, BFS
 */

/*
 * Solution 1
 * 2019-07-30  Runtime: 20 ms
 * Algorithm: => DP.
 * Time Complexity: O(n^2). Space Conplexity: O(n)
 */
 
 class Solution {
    public int numSquares(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
