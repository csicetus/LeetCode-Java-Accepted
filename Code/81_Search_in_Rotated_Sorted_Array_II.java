/*
 * 81. Search in Rotated Sorted Array II
 * Target: Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *         (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *         You are given a target value to search. If found in the array return true, otherwise return false.
 * Difficulty：Medium
 * Classification：Array, Binary Search
 */

/*
 * Solution 1
 * 2019-08-07  Runtime: 1 ms
 * Algorithm: => Binary Search.
 * Time Complexity: worse case: O(n). Space Conplexity: O(1). 
 */

class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            // skip duplicates from the left
            while (l < r && nums[l] == nums[l + 1]) l++;
            // skip duplicates from the right
            while (l < r && nums[r] == nums[r - 1]) r--;
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            } 
            // The low part
            if (nums[mid] <= nums[r]) {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } 
            // The high part
            else if (nums[mid] >= nums[l]) {
                if (nums[mid] > target && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } 
        }
        return false;
    }
}
