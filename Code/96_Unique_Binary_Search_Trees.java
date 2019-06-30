/*
 * 96. Unique Binary Search Trees
 * Target: Given n, find the number of structurally unique BST's (binary search trees) that store values 1 ... n.
 * Difficulty：Medium
 * Classification：DP, Tree
 */
 
/*
 * Solution 1
 * 2019-06-29  Runtime: 0 ms
 * Algorithm: => DP.
 * Time complexity: ? , Space complexity: ?
 */
 
 class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
 

/*
 * Solution 1
 * 2019-06-10  Runtime: 0 ms
 * Algorithm: => Iterate.
 * Time complexity: O(m + n), Space complexity: O(1).
 */
