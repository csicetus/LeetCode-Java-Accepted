/*
 * 671. Second Minimum Node In a Binary Tree
 * Target: Given a non-empty special binary tree consisting of nodes with the non-negative value, 
 *         where each node in this tree has exactly two or zero sub-node.
 *         If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
 *         More formally, the property root.val = min(root.left.val, root.right.val) always holds.
 *         Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 *         If no such second minimum value exists, output -1 instead.
 * Difficulty：Easy
 * Classification：Tree
 */

/*
 * Solution 1
 * 2019-08-27  Runtime: 1 ms
 * Algorithm: => DFS and HashSet. 
 * Time Complexity: O(n). Space Conplexity: O(n)
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
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        dfs(root, set);
        int minVal = root.val;
        long res = Long.MAX_VALUE;
        for (int s : set) {
            if (s > minVal && s < res) {
                res = s;
            }
        }
        return res < Long.MAX_VALUE ? (int)res : -1;
    }
    
    private void dfs(TreeNode root, Set<Integer> set) {
        if (root != null) {
            set.add(root.val);
            dfs(root.left, set);
            dfs(root.right, set);
        }
    }
}


/*
 * Solution 2
 * 2019-08-27  Runtime: 0 ms
 * Algorithm: => BFS. 
 * Time Complexity: O(n). Space Conplexity: O(n)
 */
 
 class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int minVal = root.val;
        long res = Long.MAX_VALUE;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.val > minVal && cur.val < res) {
                res = cur.val;
            }
            if (cur.left != null) {
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        return res < Long.MAX_VALUE ? (int)res : -1;
    }
}


/*
 * Solution 3
 * 2019-08-27  Runtime: 0 ms
 * Algorithm: => Recursion. 
 * Time Complexity: ?. Space Conplexity: O(1)
 */
 
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null) return -1;
        int l = root.left.val == root.val ? findSecondMinimumValue(root.left) : root.left.val;
        int r = root.right.val == root.val ? findSecondMinimumValue(root.right) : root.right.val;
        return l == -1 || r == -1 ? Math.max(l, r) : Math.min(l, r); 
    }
}
