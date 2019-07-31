/*
 * 338. Counting Bits
 * Target: Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's 
 *         in their binary representation and return them as an array.
 * Difficulty：Medium
 * Classification：DP, Bit Manipulation
 */

/*
 * Solution 1
 * 2019-07-31  Runtime: 1 ms
 * Algorithm: => DP. Find rules: dp[i] = (i % 2 == 1) ? dp[i/2] + 1: dp[i/2] 
 * Time Complexity: O(n). Space Conplexity: O(n)
 */
 
 class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = (i % 2 == 1) ? dp[i / 2] + 1 : dp[i / 2];
        }
        return dp;
    }
}
 
 
