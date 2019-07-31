/*
 * 152. Maximum Product Subarray
 * Target: Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * Difficulty：Medium
 * Classification：Array, DP
 */

/*
 * Solution 1
 * 2019-07-30  Runtime: 2 ms
 * Algorithm: => DP. Store two numbers: max and min.
 * Time Complexity: ?. Space Conplexity: O(1)
 */
 
 class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int product = nums[0], min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
            min = Math.min(Math.min(nums[i] * tmp, nums[i] * min), nums[i]);
            if (product < max) {
                product = max;
            }
        }
        return product;
    }
}

