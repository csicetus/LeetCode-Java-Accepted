/*
 * 101. Symmetric Tree
 * Target: Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * Difficulty：Easy
 * Classification：Tree, DFS, BFS
 */

/*
 * Solution 1
 * 2019-07-01  Runtime: 1 ms
 * Algorithm: => Recursion
 * Time complexity: O(n), Space complexity: O(n) worsest, n is the number of nodes in binary tree
 */
 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }
}


/*
 * Solution 2
 * 2019-07-01  Runtime: 1 ms
 * Algorithm: => Stack
 * Time complexity: O(n), Space complexity: O(h), h is the height of binary tree
 */
