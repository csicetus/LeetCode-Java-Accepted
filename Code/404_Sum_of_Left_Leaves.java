/*
 * 404. Sum of Left Leaves
 * Target: Find the sum of all left leaves in a given binary tree.
 * Difficulty：Easy
 * Classification：Tree
 */

/*
 * Solution 1
 * 2019-11-02  Runtime: 0 ms
 * Algorithm: => Recursion
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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sumLeft = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sumLeft += root.left.val;
                /*System.out.println(sumLeft);*/
            } else {
                sumLeft += sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            if (root.right.left != null || root.right.right != null) {
                sumLeft += sumOfLeftLeaves(root.right);
            }
        }
        return sumLeft;
    }
}


/*
 * Solution 2
 * 2019-11-02  Runtime: 1 ms
 * Algorithm: => Iteration
 * Time Complexity: ?, Space Conplexity: O(1)
 */

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sumLeft = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    sumLeft += node.left.val;
                } else {
                    stack.push(node.left);
                }
            }
            if (node.right != null) {
                if (node.right.left != null || node.right.right != null) {
                    stack.push(node.right);
                }
            }
        }
        
        return sumLeft;
    }
}


/*
 * Solution 3
 * 2019-11-02  Runtime: 1 ms
 * Algorithm: => BFS
 * Time Complexity: ?, Space Conplexity: O(1)
 */

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sumLeft = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    sumLeft += node.left.val;
                } else {
                    q.offer(node.left);
                }
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        
        return sumLeft;
    }
}
