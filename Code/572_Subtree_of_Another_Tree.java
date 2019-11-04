/*
 * 572. Subtree of Another Tree
 * Target: Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
 *         A subtree of s is a tree consists of a node in s and all of this node's descendants.
 *         The tree s could also be considered as a subtree of itself.
 * Difficulty：Easy
 * Classification：Tree
 */

/*
 * Solution 1
 * 2019-11-04  Runtime: 5 ms
 * Algorithm: => Recursion
 * Time Complexity: O(m*n), Space Conplexity: O(n)
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }
    
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            if (s == null && t == null) {
                return true;
            }
            return false;
        }
        if (s.val == t.val) {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
        return false;
    }
    
    private boolean traverse(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return isSameTree(s, t) || traverse(s.left, t) || traverse(s.right, t);
    }
}



/*
 * Solution 2
 * 2019-11-04  Runtime: 5 ms
 * Algorithm: => Recursion
 * Time Complexity: O(m^2 + n^2 + m*n), Space Conplexity: O(max(m, n))
 */
 
 class Solution {
    HashSet<String> set = new HashSet<>();
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String t1 = preorder(s, true);
        String t2 = preorder(t, true);
        return t1.indexOf(t2) >= 0;
    }
    
    private String preorder(TreeNode node, boolean isLeft) {
        if (node == null) {
            if (isLeft) {
                return "leftNull";
            }
            return "rightNull";
        }
        return "#" + node.val + " " + preorder(node.left, true) + " " + preorder(node.right, false);
    }
}
