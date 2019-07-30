/*
 * 114. Flatten Binary Tree to Linked List
 * Target: Given a binary tree, flatten it to a linked list in-place.
 * Difficulty：Medium
 * Classification：Tree, DFS
 */

/*
 * Solution 1
 * 2019-07-29  Runtime: 1 ms
 * Algorithm: => Recursion.
 * Time Complexity: ?. Space Conplexity: O(N)
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
    public void flatten(TreeNode root) {
        helper(root, null);
    }
    
    private TreeNode helper(TreeNode root, TreeNode pre) {
        if (root == null) return pre;
        root.right = helper(root.left, helper(root.right, pre));
        root.left = null;
        return root;
    }
}


/*
 * Solution 2
 * 2019-07-29  Runtime: 2 ms
 * Algorithm: => Iteration.
 * Time Complexity: ?. Space Conplexity: O(N)
 */
 
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode pre = new TreeNode(-1);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            pre.right = cur;
            pre.left = null;
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            pre = cur;
        }
    }
}
