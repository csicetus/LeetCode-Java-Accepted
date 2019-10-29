/*
 * 112. Path Sum
 * Target: Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
 *         adding up all the values along the path equals the given sum.
 *         Note: A leaf is a node with no children.
 * Difficulty：Easy
 * Classification：Tree, DFS
 */

/*
 * Solution 1
 * 2019-10-29  Runtime: 4 ms
 * Algorithm: => DFS
 * Time Complexity: ?, Space Conplexity: O(1)
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stackSum = new Stack<>();
        TreeNode cur = root;
        stack.push(root);
        stackSum.push(root.val);
        int pathSum = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                pathSum += cur.val;
                stackSum.push(pathSum);
                cur = cur.left;
            }
            cur = stack.pop();
            pathSum = stackSum.pop();
            if (cur.left == null && cur.right == null && pathSum == sum) {
                return true;
            }
            cur = cur.right;
        }
        return false;
    }
}



/*
 * Solution 2
 * 2019-10-29  Runtime: 0 ms
 * Algorithm: => Recursion
 * Time Complexity: ?, Space Conplexity: O(1)
 */
 
 class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return pathSumHelper(root, sum);
    }
    
    private boolean pathSumHelper(TreeNode cur, int sum) {
        if (cur.left == null && cur.right == null) {
            return cur.val == sum;
        }
        if (cur.left != null && cur.right == null) {
            return pathSumHelper(cur.left, sum - cur.val);
        }
        if (cur.right != null && cur.left == null) {
            return pathSumHelper(cur.right, sum - cur.val);
        }
        return pathSumHelper(cur.left, sum - cur.val) || pathSumHelper(cur.right, sum - cur.val);
    } 
}



/*
 * Solution 3
 * 2019-10-29  Runtime: 1 ms
 * Algorithm: => BFS
 * Time Complexity: ?, Space Conplexity: O(1)
 */
 
 class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> qSum = new LinkedList<>();
        q.offer(root);
        qSum.offer(root.val);
        TreeNode cur = root;
        int pathSum = root.val;
        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                cur = q.poll();
                pathSum = qSum.poll();
                if (cur.left == null && cur.right == null && pathSum == sum) {
                    return true;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                    qSum.offer(pathSum + cur.left.val);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                    qSum.offer(pathSum + cur.right.val);
                }
            }
        }
        return false;
    }
}
