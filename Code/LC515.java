//////////// sol 1: BFS

// Time: O(n); Space: O(n)
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
    public List<Integer> largestValues(TreeNode root) {  
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int queueSize = 1;
        q.offer(root);
        while (queueSize > 0) {
            int largest = Integer.MIN_VALUE;
            for (int i = 0; i < queueSize; i++) {
                //System.out.println("i " + i);
                TreeNode curr = q.poll();
                //System.out.println("curr " + curr.val);
                largest = Math.max(largest, curr.val);
                //System.out.println("largest " + largest);
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            res.add(largest);
            queueSize = q.size();
            //System.out.println("queue size " + queueSize);
            //System.out.println("-------------------");
        }
        return res;
    }
}

//////////// sol 2: DFS

class Solution {
    public List<Integer> largestValues(TreeNode root) {  
        List<Integer> res = new ArrayList<Integer>();
        dfs(root, res, 0);
        return res;
    }
    
    private void dfs(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;
        if (level == res.size()) {
            res.add(root.val);
        } else {
            res.set(level, Math.max(res.get(level), root.val));
        }
        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }
}
