/*
 * 98. Validate Binary Search Tree
 * Target: Given a binary tree, determine if it is a valid binary search tree (BST).
 * Difficulty：Medium
 * Classification：Tree, DFS
 */

/*
 * Solution 1
 * 2019-06-30  Runtime: ? ms
 * Algorithm: => Inorder
 * Time complexity: >, Space complexity: ?
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        List<Integer> res = new ArrayList<>();
        getRes(root, res);
        System.out.println(res);
        int pre = res.get(0);
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) - res.get(i - 1) < pre) return false;
        }
        return true;
    }
    private void getRes(TreeNode node, List<Integer> res) {
        if (node == null) return;
        getRes(node.left, res);   
        res.add(node.val);
        getRes(node.right, res);
    }
}
