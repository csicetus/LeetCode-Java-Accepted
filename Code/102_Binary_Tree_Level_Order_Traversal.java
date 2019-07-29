/*
 * 102. Binary Tree Level Order Traversal
 * Target: Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * Difficulty：Medium
 * Classification：Tree, BFS
 */

/*
 * Solution 1
 * 2019-07-29  Runtime: 1 ms
 * Algorithm: => DFS.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        helper(root, res, 0);
        return res;
    }
    
    private void helper(TreeNode root, List<List<Integer>> res, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        helper(root.left, res, height + 1);
        helper(root.right, res, height + 1);
    }
}
 
 
 /*
 * Solution 2
 * 2019-07-29  Runtime: 1 ms
 * Algorithm: => BFS.
 * Time Complexity: ?. Space Conplexity: O(n)
 */
 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> tmp = new LinkedList<Integer>();
            for (int i = 0; i < level; i++) {
                if (q.peek().left != null) {
                    q.offer(q.peek().left);
                }
                if (q.peek().right != null) {
                    q.offer(q.peek().right);
                }
                tmp.add(q.poll().val);
            }
            res.add(tmp);
        }
        return res;
    }
}
 
