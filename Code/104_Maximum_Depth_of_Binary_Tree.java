/*
 * 104. Maximum Depth of Binary Tree
 * Target: Given a binary tree, find its maximum depth.
*          The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Difficulty：Easy
 * Classification：Tree, DFS
 * Note: same as lc111
 */

/*
 * Solution 1
 * 2019-07-25  Runtime: 0 ms
 * Algorithm: => Recursion.
 * Time Complexity: ?. Space Conplexity: O(1)
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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}



/*
 * Solution 2
 * 2019-07-25  Runtime: 2 ms
 * Algorithm: => BFS
 * Time Complexity: ?. Space Conplexity: ?
 */
 
 class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = q.poll();
                if (curNode != null) {
                    if (curNode.left != null) {
                        q.offer(curNode.left);
                    }
                    if (curNode.right != null) {
                        q.offer(curNode.right);
                    }
                }
            }
            level++;
        }
        return level;
    }
}
