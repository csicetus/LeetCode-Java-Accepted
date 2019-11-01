/*
 * 113. Path Sum II
 * Target: Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *         Note: A leaf is a node with no children.
 * Difficulty：Medium
 * Classification：Tree, DFS
 */

/*
 * Solution 1
 * 2019-10-29  Runtime: 1 ms
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (root == null) {
            return res;
        }
        pathSumHelper(root, sum, temp, res);
        return res;
    }
    
    private void pathSumHelper(TreeNode cur, int sum, List<Integer> temp, List<List<Integer>> res) {  
        if (cur.left == null && cur.right == null) {
            if (cur.val == sum) {
                temp.add(cur.val);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            }  
            return;
        }
        if (cur.right == null) {
            temp.add(cur.val);
            pathSumHelper(cur.left, sum - cur.val, temp, res);
            temp.remove(temp.size() - 1);
            return;
            
        }
        if (cur.left == null) {
            temp.add(cur.val);
            pathSumHelper(cur.right, sum - cur.val, temp, res);
            temp.remove(temp.size() - 1);
            return;
        }
        temp.add(cur.val);
        pathSumHelper(cur.left, sum - cur.val, temp, res);
        temp.remove(temp.size() - 1);
        
        temp.add(cur.val);
        pathSumHelper(cur.right, sum - cur.val, temp, res);
        temp.remove(temp.size() - 1);
        return;
    }
}


/*
 * Solution 2
 * 2019-11-01  Runtime: 1 ms
 * Algorithm: => DFS
 * Time Complexity: ?, Space Conplexity: O(1)
 */

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int pathSum = 0;
        //stack.push(root);
        /*int i = 0;*/
        while (!stack.isEmpty() || cur != null) {
            /*System.out.println("No. " + i);*/
            while (cur != null) {
                stack.push(cur);
                pathSum += cur.val;
                temp.add(cur.val);
                cur = cur.left;
            }
            cur = stack.peek();
            /*System.out.println(cur.val);*/
            if (cur.left == null && cur.right == null && pathSum == sum) {
                res.add(new ArrayList<>(temp));
            }
            if (cur.right == null || cur.right == pre) {
                TreeNode popNode = stack.pop();
                pathSum -= popNode.val;
                temp.remove(temp.size() - 1);
                pre = cur;
                cur = null;
            } else {
                cur = cur.right;
                /*System.out.println("cur  " + cur.val);*/
            }
            /*i++;*/
        }
        
        return res;
    }
}
