/*
 * 16. 3Sum Closest
 * Target: Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 
 *         Return the sum of the three integers.
 * Difficulty：Medium
 * Classification：String, Two Pointers
 */

/*
 * Solution 1
 * 2019-07-13  Runtime: 7 ms
 * Algorithm: => Two Pointers. Firstly sort the array, then go through the array and update sub and sum.
 * Time Complexity: O(n^2), Space Conplexity: O(1)
 */


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        int sub = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (Math.abs(nums[l] + nums[r] + nums[i] - target) < sub) {
                    sum = nums[l] + nums[r] + nums[i];
                    sub = Math.abs(target - sum);
                }
                if (nums[l] + nums[r] + nums[i] > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return sum;
    }
}
