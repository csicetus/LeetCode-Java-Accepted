//////////sol 1

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                TreeNode cur = q.poll();
                if (i == level - 1) {
                    res.add(cur.val);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
        return res;
    }
}


//////////sol 2

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }
        if (level == res.size()) {
            res.add(root.val);
        }
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}
