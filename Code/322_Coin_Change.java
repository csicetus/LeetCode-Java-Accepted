/*
 * 322. Coin Change
 * Target: You are given coins of different denominations and a total amount of money amount. 
 *         Write a function to compute the fewest number of coins that you need to make up that amount. 
 *         If that amount of money cannot be made up by any combination of the coins, return -1.
 * Difficulty：Medium
 * Classification：DP
 */

/*
 * Solution 1
 * 2019-07-30  Runtime: 23 ms
 * Algorithm: => DP - Top down, Recursion.
 * Time Complexity: O(S*N). Space Conplexity: O(S)
 */
 
 class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return 0;
        return coinChange(coins, amount, new int[amount]);
    }
    
    private int coinChange(int[] coins, int remain, int[] count) {
        if (remain < 0) return -1;
        if (remain == 0) return 0;
        if (count[remain - 1] != 0) return count[remain - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, remain - coin, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        count[remain - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[remain - 1];
    }
}


/*
 * Solution 2
 * 2019-07-30  Runtime: 9 ms
 * Algorithm: => DP - Bottom Up, Iteration.
 * Time Complexity: O(S*N). Space Conplexity: O(S)
 */
 
 class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] <= amount ? dp[amount] : -1;
    }
}
