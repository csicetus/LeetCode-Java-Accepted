/*
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Target: Given preorder and inorder traversal of a tree, construct the binary tree.
 * Difficulty：Medium
 * Classification：Array, Tree, DFS
 */

/*
 * Solution 1
 * 2019-07-29  Runtime: 12 ms
 * Algorithm: => Recursion.
 * Time Complexity: ?. Space Conplexity: O(1)
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preorder.length == 1) return root;
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        root.left = helper(preorder, inorder, preStart + 1, inStart, inIndex - 1);
        root.right = helper(preorder, inorder, preStart + (inIndex - inStart) + 1, inIndex + 1, inEnd);
        return root;
    }
}
 
 
 /*
 * Solution 2
 * 2019-07-29  Runtime: 3 ms
 * Algorithm: => Recursion, HashTable. Optimal of sol 1.
 * Time Complexity: ?. Space Conplexity: O(n)
 */
 
 class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, 0, inorder.length - 1, map);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preorder.length == 1) return root;
        int inIndex = map.get(root.val);
        root.left = helper(preorder, inorder, preStart + 1, inStart, inIndex - 1, map);
        root.right = helper(preorder, inorder, preStart + (inIndex - inStart) + 1, inIndex + 1, inEnd, map);
        return root;
    }
}


/*
 * Solution 3
 * 2019-07-29  Runtime: 2 ms
 * Algorithm: => Iteration.
 * Time Complexity: ?. Space Conplexity: O(n)
 */
 
 class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode cur = root;
        for (int i = 1, j = 0; i < preorder.length; i++) {
            if (cur.val != inorder[j]) {
                cur.left = new TreeNode(preorder[i]);
                stack.push(cur);
                cur = cur.left;
            } else {
                j++;
                while (!stack.isEmpty() && stack.peek().val == inorder[j]) {
                    cur = stack.pop();
                    j++;
                }
                cur.right = new TreeNode(preorder[i]);
                cur = cur.right;
            }
        }
        return root;
    }
}
