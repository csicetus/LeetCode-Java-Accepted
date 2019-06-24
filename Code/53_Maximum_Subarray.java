/*
 * 53. Maximum Subarray
 * Target: Find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * Difficulty：Easy
 * Classification：Array, Divide and Conquer, Dynamic Programming
 */

/*
 * Solution 1
 * 2019-06-23  Runtime: 1 ms
 * Algorithm: => DP.
 * Time complexity: O(n). Space complexity: O(n).
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int num_pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num_pre = Math.max(num_pre + nums[i], nums[i]);
            max = Math.max(max, num_pre);
        }
        return max;
    }
}


/*
 * Solution 2
 * 2019-06-24  Runtime: 322 ms
 * Algorithm: => Compare one by one.
 * Time complexity: O(k*n). Space complexity: O(1).
 */
