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

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int levelSize = q.size();        
            List<Integer> temp = new LinkedList<>();          
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = q.poll();
                if (cur != null) {
                    // 0, 2, 4, 2n lines
                    if (level % 2 == 0) {
                        temp.add(cur.val);
                    // 1, 3, 5, 2n + 1 lines
                    } else {
                        temp.add(0, cur.val);
                    }
                    q.offer(cur.left);
                    q.offer(cur.right);
                } 
            }
            if (temp.size() > 0) {
                res.add(temp);
            }
            level++;
        }
        return res;
    }
}


////////// sol 3: stack

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.add(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> temp = new ArrayList<>();          
            while (!s1.isEmpty()) {
                TreeNode cur = s1.pop();
                temp.add(cur.val);
                if (cur.left != null) {
                    s2.add(cur.left);
                } 
                if (cur.right != null) {
                    s2.add(cur.right);
                }
            }
            res.add(temp);
            temp = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode cur = s2.pop(); 
                temp.add(cur.val);
                if (cur.right != null) {
                    s1.add(cur.right);
                }
                if (cur.left != null) {
                    s1.add(cur.left);
                } 
            }
            if (temp.size() > 0) {
                res.add(temp);
            }
        }
        return res;
    }
}
