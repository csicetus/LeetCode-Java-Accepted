/*
 * 100. Same Tree
 * Target: Given two binary trees, write a function to check if they are the same or not.
 *         Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * Difficulty：Easy
 * Classification：Tree, DFS
 */

/*
 * Solution 1
 * 2019-07-25  Runtime: 0 ms
 * Algorithm: => DFS: Inorder Traversal
 * Time Complexity: O(N), N is the number of Node. Space Conplexity: O(h), h is the height of tree, from long(N) to N.
 * Note that it can use preorder, postorder Traversal of DFS or BFS.
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (!isSameTree(p.left, q.left)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        if (!isSameTree(p.right, q.right)) {
            return false;
        }
        return true;
    }
}
