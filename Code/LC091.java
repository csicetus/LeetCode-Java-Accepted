/////////////// sol 1: DP

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            String cur = s.substring(i, i + 1);
            int curNum = Integer.valueOf(cur);
            String doubleDigit = s.substring(i - 1, i + 1);
            int doubleDigNum = Integer.valueOf(doubleDigit);
            if (curNum <= 9 && curNum >= 1) {
                dp[i] += dp[i - 1];
            } 
            if (doubleDigNum <= 26 && doubleDigNum >= 10) {
                if (i >= 2) {
                    dp[i] += dp[i - 2];
                } else {
                    dp[i] += 1;
                }
            }
        }
        return dp[n - 1];
    }
}
