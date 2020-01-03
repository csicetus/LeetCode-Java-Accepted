////////// sol 1: dp

// Time: O(n); Space: O(n)
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

////////// sol 2: fibonacci

// Time: O(n); Space: O(1)
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int first = 1, second = 2;
        int preSec = 2;
        for (int i = 3; i <= n; i++) {
            preSec = second;
            second = first + second;
            first = preSec;
        }
        return second;
    }
}
