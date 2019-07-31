/*
 * 221. Maximal Square
 * Target: Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * Difficulty：Medium
 * Classification：DP
 */

/*
 * Solution 1
 * 2019-07-30  Runtime: 4 ms
 * Algorithm: => DP.
 * Time Complexity: O(M*N). Space Conplexity: O(M*N)
 */
 
 class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = row > 0 ? matrix[0].length : 0;
        
        // dp(i,j) represents the side length of the maximum square 
        // whose bottom right corner is the cell with index (i,j) in the original matrix.
        int[][] dp = new int[row + 1][col + 1];
        int maxLen = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }
}


/*
 * Solution 2
 * 2019-07-30  Runtime: 4 ms
 * Algorithm: => DP. Optimal of sol 1.
 * Time Complexity: O(M*N). Space Conplexity: O(N)
 */
 
 class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = row > 0 ? matrix[0].length : 0;
        int[] dp = new int[col + 1];
        int maxLen = 0, pre = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                int tmp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), pre) + 1;
                    maxLen = Math.max(maxLen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                pre = tmp;
            }
        }
        return maxLen * maxLen;
    }
}
