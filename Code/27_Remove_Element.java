/*
 * 27. Remove Element
 * Target: Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Difficulty：Easy
 * Classification：Array, Two points
 */

/*
 * Solution 1
 * 2019-07-14  Runtime: 0 ms
 * Algorithm: => Two points with same direction
 * Time Complexity: O(n), Space Conplexity: O(1)
 */

class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
