/*
 * 230. Kth Smallest Element in a BST
 * Target: Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *         You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * Difficulty：Easy
 * Classification：Binary Search, Tree
 */

/*
 * Solution 1
 * 2019-08-27  Runtime: 1 ms
 * Algorithm: => DFS and inorder. 
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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> values = inorder(root, new ArrayList<Integer>());
        return values.get(k - 1);
    }
    private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }
}


/*
 * Solution 2
 * 2019-08-27  Runtime: 1 ms
 * Algorithm: => Iteration and Stack. 
 * Time Complexity: O(h+k). Space Conplexity: O(h+n)
 */
 
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int cnt = 0;
        while (!stack.isEmpty() || cur != null) {
            if (cur == null) {
                TreeNode n = stack.pop();
                while (++cnt == k) return n.val;
                cur = n.right;
            } else {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return -1;
    }
}


/*
 * Solution 3 Follow Up
 * 2019-08-27  Runtime: 1 ms
 * Algorithm: => Divide and conquer. 
 * Time Complexity: O(h+k). Space Conplexity: O(h+n)
 */
