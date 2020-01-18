//////////////// sol 1: DP

// Time: O(m*n); Space: O(n)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                // temp store unchanged dp[j] as line 1
                int temp = dp[j];
                // we add one row and one col at the beginning
                // two index corresbonding to text1, text2 should -1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = prev + 1;
                } else {
                    // compare unchanged dp[j] and changed dp[j - 1]
                    // get max as new dp[j]
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        return dp[n];
    }
}
