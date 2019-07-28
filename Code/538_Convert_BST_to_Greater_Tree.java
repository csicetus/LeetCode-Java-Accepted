/*
 * 538. Convert BST to Greater Tree
 * Target: Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to 
 *         the original key plus sum of all keys greater than the original key in BST.
 * Difficulty：Easy
 * Classification：Tree
 */

/*
 * Solution 1
 * 2019-07-28  Runtime: 0 ms
 * Algorithm: => Recusion.
 * Time Complexity: O(n). Space Conplexity: O(n)
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
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}


/*
 * Solution 2
 * 2019-07-28  Runtime: 3 ms
 * Algorithm: => Iteration.
 * Time Complexity: O(n). Space Conplexity: O(n)
 */
 
 class Solution {
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.add(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }
        return root;
    }
}

/*
 * Solution 3
 * 2019-07-28  Runtime: 3 ms
 * Algorithm: => Reverse Morris In-order Traversal.
 * Time Complexity: O(n). Space Conplexity: O(1)
 */
 
class Solution {
    // Get the node with the smallest value greater than this one.
    private TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        while (node != null) {
            // If there is no right subtree, visit this node and continue traversing left.
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            } 
            /* If there is a right subtree, then there is at least one node that has a 
             * greater value than the current one. So we must traverse that subtree first.
             */
            else {
                TreeNode succ = getSuccessor(node);
                // If the left subtree is null, then we have never been here before.
                if (succ.left == null) {
                    succ.left = node;
                    node = node.right;
                } 
                // If there is a left subtree, it is a link that we created on a previous pass, so we should unlink it and visit this node.
                else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }      
        return root;
    }
}
