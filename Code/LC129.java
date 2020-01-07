///////// sol 1: recursion/dfs(best)


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
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }
    
    private int sumNumbersHelper(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        int leftSum = sumNumbersHelper(root.left, sum);
        int rightSum = sumNumbersHelper(root.right, sum);
        return leftSum + rightSum;
    }
}


//////// sol 2: stack

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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> stackSum = new Stack<Integer>();
        stack.push(root);
        stackSum.push(root.val);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            int value = stackSum.pop();
            if (curr.left == null && curr.right == null) {
                sum += value;
            }
            if (curr.left != null) {
                stack.push(curr.left);
                stackSum.push(value * 10 + curr.left.val);
            }
            if (curr.right != null) {
                stack.push(curr.right);
                stackSum.push(value * 10 + curr.right.val);
            }
        }
        return sum;
    }
}
