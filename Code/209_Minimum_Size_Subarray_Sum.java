/*
 * 209. Minimum Size Subarray Sum
 * Target: Given an array of n positive integers and a positive integer s, 
 *         find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * Difficulty：Medium
 * Classification：Array, Two Pointers, Binary Search
 */


/*
 * Solution 1
 * 2019-07-11  Runtime: 1 ms
 * Algorithm: => Two Pointers (Same direction)
 * Time Complexity: O(n), Space Conplexity: O(1)
 */

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < nums.length; i++) {
            while (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            }
            if (sum >= s) {
                res = Math.min(res, j - i);
            }
            sum -= nums[i];
        }
        if (res == Integer.MAX_VALUE) res = 0;
        return res;
    }
}
