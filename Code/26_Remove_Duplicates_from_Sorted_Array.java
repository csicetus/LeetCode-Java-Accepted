/*
 * 26. Remove Duplicates from Sorted Array
 * Target: Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Difficulty：Easy
 * Classification：Array, Two points
 */

/*
 * Solution 1
 * 2019-07-09  Runtime: 0 ms
 * Algorithm: => Two points with same direction
 * Time Complexity: O(n), Space Conplexity: O(1)
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }   
        }
        return i + 1;
    }
}
