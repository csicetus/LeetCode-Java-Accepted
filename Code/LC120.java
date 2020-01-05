///////// sol 1: dp

// dp from bottom to top
// Time: O(n)?; Space: O(n). n is the total size of triangle
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int totalSize = triangle.size();
        int levelSize = triangle.get(totalSize - 1).size();
        // dp[i] is min path sum from bottom to curr position
        int[] dp = new int[levelSize];
        // copy last row of triangle to dp
        for (int i = 0; i < levelSize; i++) {
            dp[i] = triangle.get(totalSize - 1).get(i);
            //System.out.print(" " + dp[i]);
        }
        
        // update dp
        // dp[i] = Math.min(dp[i], dp[i + 1] + curval)
        for (int i = levelSize - 2; i >= 0; i--) {
            List<Integer> curr = triangle.get(i);
            for (int j = 0; j < curr.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + curr.get(j);
                System.out.println(dp[j]);
            }
        }
        
        return dp[0];
    }
}
