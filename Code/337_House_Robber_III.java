/*
 * 337. House Robber III
 * Target: The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root."
 *         Besides the root, each house has one and only one parent house. 
 *         After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
 *         It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *         Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * Difficulty：Medium
 * Classification：Tree, DFS
 */

/*
 * Solution 1
 * 2019-08-05  Runtime: 634 ms
 * Algorithm: => Recurtion. Termination condition: rob(root) without any calculation: the tree is empty -> the amount of money is zero.
 *               Recurrence relation: without alerting the police -> 1. Don't rob root: res = rob(root.left) + rob(root.
 *               2. Rob root: res = rob(root) + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right)
 *               3. Compare step 1 and step 2, find the max result.
 * Time Complexity: ?. Space Conplexity: ?
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
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        if (root.left != null) {
            res += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            res += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(root.val + res, rob(root.left) + rob(root.right));
    }
}


/*
 * Solution 2
 * 2019-08-05  Runtime: 4 ms
 * Algorithm: => Recurtion. Optimal of sol 1. Use dp and HashMap, store TreeNode that will be used repeatly.
 *               For example, rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right) will be used by
 *               both rob(root) and rob(root.left) + rob(root.right).
 * Time Complexity: ?. Space Conplexity: ?
 */
 
 class Solution {
    public int rob(TreeNode root) {
        return helperRob(root, new HashMap<>());
    }
    private int helperRob(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int res = 0;
        if (root.left != null) {
            res += helperRob(root.left.left, map) + helperRob(root.left.right, map);
        }
        if (root.right != null) {
            res += helperRob(root.right.left, map) + helperRob(root.right.right, map);
        }
        res = Math.max(root.val + res, helperRob(root.left, map) + helperRob(root.right, map));
        map.put(root, res);
        return res;
    }
}



/*
 * Solution 3
 * 2019-08-05  Runtime: 1 ms
 * Algorithm: => DP and Recurtion. Optimal of sol 1, sol 2. Use dp, store TreeNode that will be used repeatly.
 *               node[0] means the amount of money with the condition that this node is not robbed; 
 *               node[1] means the amount of money with the condition that this node is robbed.
 *               res[0] -> Not Rob root but Rob root.left(root.left return int[2] so compare L[0], L[1], choose the max)
 *               + Rob root.right(root.right return int[2] so compare R[0], R[1], choose the max) 
 * Time Complexity: ?. Space Conplexity: ?
 */
 
 class Solution {
    public int rob(TreeNode root) {
        int[] res = helperRob(root);
        return Math.max(res[0], res[1]);
    }
    private int[] helperRob(TreeNode root) {
        if (root == null) return new int[2];
        int[] L = helperRob(root.left);
        int[] R = helperRob(root.right);       
        int[] res = new int[2];
        res[0] = Math.max(L[0], L[1]) + Math.max(R[0], R[1]);
        res[1] = root.val + L[0] + R[0];
        return res;
    }
}
