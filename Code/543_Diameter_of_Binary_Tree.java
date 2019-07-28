/*
 * 543. Diameter of Binary Tree
 * Target: Given a binary tree, you need to compute the length of the diameter of the tree. 
 *         The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * Difficulty：Easy
 * Classification：Tree
 */

/*
 * Solution 1
 * 2019-07-28  Runtime: 0 ms
 * Algorithm: => DFS.
 * Time Complexity: O(N), N is the number of nodes. Space Conplexity: O(N)
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
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        height(root);
        return res - 1;
    }
    
    private int height(TreeNode node) {
        if (node == null) return 0;
        int L = height(node.left);
        int R = height(node.right);
        res = Math.max(res, L + R + 1);
        return Math.max(L, R) + 1;
    }
}
