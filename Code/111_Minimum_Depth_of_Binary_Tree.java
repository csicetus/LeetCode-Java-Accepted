/*
 * 111. Minimum Depth of Binary Tree
 * Target: Given a binary tree, find its minimum depth.
*          The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Difficulty：Easy
 * Classification：Tree, DFS, BFS
 * Note: same as lc104
 */

/*
 * Solution 1
 * 2019-07-25  Runtime: 0 ms
 * Algorithm: => Recursion.
 * Time Complexity: ?. Space Conplexity: O(1)
 */

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else {
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}


/*
 * Solution 2
 * 2019-07-25  Runtime: 0 ms
 * Algorithm: => BFS
 * Time Complexity: ?. Space Conplexity: ?
 */
 
 class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int level = 1;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = q.poll();
                if (curNode != null) {
                    if (curNode.left == null && curNode.right == null) {
                        return level;
                    }
                    if (curNode.left != null) {
                        q.offer(curNode.left);
                    }
                    if (curNode.right != null) {
                        q.offer(curNode.right);
                    }
                }
            }
            level++;
        }
        return level;
    }
}
 
