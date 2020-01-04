////////// sol 1: fabonacci

// Time: O(n); Space: O(1)
class Solution {
    public int fib(int N) {
        if (N == 0) return 0;
        int first = 0;
        int second = 1;
        int preSec = 1;
        for (int i = 1; i < N; i++) {
            preSec = second;
            second = first + second;
            first = preSec;
        }
        return second;
    }
}

////////// sol 2: dp

// Time: O(n); Space: O(n)
class Solution {
    public int fib(int N) {
        if (N == 0) return 0;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[N];
    }
}
