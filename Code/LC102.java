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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();      
        helper(root, res, 0);      
        return res;
    }
    
    private void helper(TreeNode root, List<List<Integer>> res, int height) {
        if (root == null) {
            return;
        }
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        helper(root.left, res, height + 1);
        helper(root.right, res, height + 1);        
    }
}


////////// sol 2: bfs

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();      
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < level; i++) {
                TreeNode cur = q.poll();
                if (cur != null) {
                    temp.add(cur.val);
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
            }
            // filter temp is []
            if (temp.size() > 0) {
                res.add(temp);
            }
        }           
        return res;
    }
}
