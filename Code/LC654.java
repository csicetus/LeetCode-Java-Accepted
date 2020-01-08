//////////// sol 1: DFS

// Time: O(n^2); Space: O(n)
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length);
    }
    
    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l == r) return null;
        int maxNumIdx = findMaxIndex(nums, l, r);
        TreeNode root = new TreeNode(nums[maxNumIdx]);
        root.left = buildTree(nums, l, maxNumIdx);
        root.right = buildTree(nums, maxNumIdx + 1, r);
        return root;
    }
    
    private int findMaxIndex(int[] nums, int l, int r) {
        int maxNumIdx = l;
        for (int i = l; i < r; i++) {
            if (nums[i] > nums[maxNumIdx]) {
                maxNumIdx = i;
            }
        }
        return maxNumIdx;
    }
}
