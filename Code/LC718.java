/////////////// sol 1: DP

// Time&Space: O(m*n)
class Solution {
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null) return 0;
        int m = A.length, n = B.length;
        int max = 0;
        // dp[i][j] means len of longest repeated 
        // subarry ending with num[i-1], num[j-1]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // i , j for dp is original plus 1
                // for A, B should minus 1
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
