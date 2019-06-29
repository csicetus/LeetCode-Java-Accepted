/*
 * 94. Binary Tree Inorder Traversal
 * Target: Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Difficulty：Medium
 * Classification：Hashtable, Stack, Tree
 */

/*
 * Solution 1
 * 2019-06-29  Runtime: 0 ms
 * Algorithm: => Recursion
 * Time complexity: O(n), Space complexity: O(h), h is the height of binary tree
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        getRes(root, res);
        return res;
    }
    
    private void getRes(TreeNode node, List<Integer> res) {
        if (node == null) return;
        getRes(node.left, res);
        res.add(node.val);
        getRes(node.right, res);
    }
}


/*
 * Solution 2
 * 2019-06-29  Runtime: 1 ms
 * Algorithm: => Stack
 * Time complexity: O(n), Space complexity: O(h), h is the height of binary tree
 */
 
 class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}


/*
 * Solution 3
 * 2019-06-29  Runtime: 1 ms
 * Algorithm: => Morris Traversal
 * Time complexity: O(n), Space complexity: O(1)
 */

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            // cur.left is null, save the value of cur, update cur = cur.right
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                // cur.left is not null
                // find the rightest node of left subtree as node last
                TreeNode last = cur.left;
                while (last.right != null && last.right != cur) {
                    last = last.right;
                }
                // last.right is null, then last.right = cur, update cur = cur.left
                if (last.right == null) {
                    last.right = cur;
                    cur = cur.left;
                } 
                // Last.right is not null, indicating that it has been visited before, the second time visit here, 
                // indicating that the current subtree traversal is complete, save the value of cur, update cur = cur.right
                if (last.right == cur) {
                    last.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
