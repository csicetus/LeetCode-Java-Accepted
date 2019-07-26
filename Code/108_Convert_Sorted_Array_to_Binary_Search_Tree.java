/*
 * 108. Convert Sorted Array to Binary Search Tree
 * Target: Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * Difficulty：Easy
 * Classification：Tree, DFS
 */

/*
 * Solution 1
 * 2019-07-25  Runtime: 0 ms
 * Algorithm: => Recursion. Same as DFS: inorder traversal
 * Time Complexity: ?. Space Conplexity: O(1)
 */

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return toBSThelper(nums, 0, nums.length - 1);
    }
    
    private TreeNode toBSThelper(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode res = new TreeNode(nums[mid]);
        res.left = toBSThelper(nums, lo, mid - 1);
        res.right = toBSThelper(nums, mid + 1, hi);
        return res;
    }
}


/*
 * Solution 2
 * 2019-07-25  Runtime: 0 ms
 * Algorithm: => Iteration. THERE IS A PROBELM!!!!!
 * Time Complexity: ?. Space Conplexity: O(1)
 */
 
 class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        TreeNode root = new TreeNode(0);
        Stack<Object> stack = new Stack<>();
        stack.push(nums.length - 1);
        stack.push(0);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = (TreeNode)stack.pop();
            int lo = (int)stack.pop();
            int hi = (int)stack.pop();
            int mid = lo + (hi - lo) / 2;
            if (lo <= mid - 1) {
                tmp.left = new TreeNode(0);
                stack.push(mid - 1);
                stack.push(lo);
                stack.push(tmp.left);
            }
            if (hi >= mid + 1) {
                tmp.right = new TreeNode(0);
                stack.push(hi);
                stack.push(mid + 1);
                stack.push(tmp.right);
            }
        }
        return root;  
    }
}
