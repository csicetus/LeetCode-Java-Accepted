///////////////// sol 1: dp

// Time: O(n^3 / k); Space: O(n^2)
class Solution {
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - K) % (K - 1) > 0) return -1;
        
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
            //System.out.println(prefix[i]);
        }
        
        int[][] dp = new int[n][n];
        for (int m = K; m <= n; m++) {
            for (int i = 0; i + m <= n; i++) {
                int j = i + m - 1;
                // System.out.print("m " + m + "  ");
                // System.out.print("i " + i + "  ");
                // System.out.println("j " + j);
                
                // stones[i] ~ stones[j] will merge as much as possible.
                // Finally (j - i) % (K - 1) + 1 piles will be left.
                // It's less than K piles and no more merger happens.
                dp[i][j] = Integer.MAX_VALUE;
                // m move K - 1 to make sure left part can be merge to 1 pile
                for (int mid = i; mid < j; mid += K - 1) {
                    // dp[i][j] means the minimum cost to merge stones[i] - stones[j]
                    // dp[i][mid] can be merged to 1 pile
                    // dp[mid + 1][j] can be merged to determined piles
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j]);
                }
                
                // when we found a solution when
                // (len - 1) % (K - 1) == 0
                if ((j - i) % (K - 1) == 0) {
                    // for the last merge
                    // the cost is previous cost plus all of elem
                    // so dp[i][j] += sum(A[i]~A[j])
                    dp[i][j] += prefix[j + 1] - prefix[i];
                }
            }
        }
        return dp[0][n - 1];
    }
}
