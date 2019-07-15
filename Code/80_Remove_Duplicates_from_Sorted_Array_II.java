/*
 * 80. Remove Duplicates from Sorted Array II
 * Target: Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * Difficulty：Medium
 * Classification：Array, Two pointers
 */

/*
 * Solution 1
 * 2019-07-14  Runtime: 1 ms
 * Algorithm: => Two points with same direction
 * Time Complexity: O(n), Space Conplexity: O(1)
 */
 
 class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        int count = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
                count = 1;
            } else {
                if (count < 2) {
                    i++;
                    nums[i] = nums[j];
                    count++;
                }
            }
        }
        return i + 1;
    }
}
