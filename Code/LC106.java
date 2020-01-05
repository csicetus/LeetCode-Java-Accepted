////////// sol 1: recursion

// Time: O(n); Space:O(n)
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int m = inorder.length, n = postorder.length;
        if (m == 0 || n == 0 || m != n) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < m; i++) {
            map.put(inorder[i], i);
        }
        return buildSubTree(inorder, 0, m - 1, postorder, 0, n - 1, map);
    }
    
    private TreeNode buildSubTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> map) {
        if (inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIdx = map.get(postorder[postEnd]);
        TreeNode leftSubNode = buildSubTree(inorder, inStart, rootIdx - 1, postorder, postStart, postStart + (rootIdx - inStart - 1), map);
        // the length of right subtree is postEnd - 1 because last one is root
        TreeNode rightSubNode = buildSubTree(inorder, rootIdx + 1, inEnd, postorder, postStart + (rootIdx - inStart), postEnd - 1, map);
        root.left = leftSubNode;
        root.right = rightSubNode;
        return root;
    }
}
