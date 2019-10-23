/*
 * 110. Balanced Binary Tree
 * Target: Given a binary tree, determine if it is height-balanced.
 * Difficulty：Easy
 * Classification：Tree, DFS
 */

/*
 * Solution 1
 * 2019-10-22  Runtime: 1 ms
 * Algorithm: => Recursion
 * Time Complexity: ?, Space Conplexity: O(1)
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean diff = Math.abs(heightOfTree(root.left) - heightOfTree(root.right)) <= 1;
        return diff && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }
}



/*
 * Solution 2
 * 2019-10-22  Runtime: 11 ms
 * Algorithm: => Optimal of sol 1. Recursion
 * Time Complexity:?, Space Conplexity: O(1)
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return heightOfTree(root) != -1;
    }
    
    private int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        if (leftHeight == -1) return -1;
        if (rightHeight == -1) return -1;
        if (Math.abs(heightOfTree(root.left) - heightOfTree(root.right)) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
