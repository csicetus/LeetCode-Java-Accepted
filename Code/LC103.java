////////// sol 1: dfs

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfsHelper(root, res, 0);
        return res;
    }
    
    public void dfsHelper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (level >= res.size()) {
            res.add(new ArrayList<Integer>());
        }
        // line 0, 2, ..., 2n. Add to tail
        if (level % 2 == 0) {
            res.get(level).add(root.val);
        // line 1, 3, ..., 2n + 1. Add to head
        } else {
            res.get(level).add(0, root.val);
        }
        dfsHelper(root.left, res, level + 1);
        dfsHelper(root.right, res, level + 1);
    }
}


////////// sol 2: bfs
