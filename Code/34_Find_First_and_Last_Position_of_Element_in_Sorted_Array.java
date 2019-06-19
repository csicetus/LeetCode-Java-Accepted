/*
 * 34. Find First and Last Position of Element in Sorted Array
 * Target: Find the starting and ending position of a given target value..
 * Difficulty：Medium
 * Classification：Array, Binary Search
 * Note: Pay attention to the boundary problem!!! Is there an equal sign? Especially two numbers, e.g. [1,3] tar = 3.
 */
 
 /*
 * Solution 1
 * 2019-06-17  Runtime: 0 ms
 * Algorithm: => Binary Search.
 * Time complexity: O(logn). Space complexity: O(1).
 */
 
 class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] res = { -1, -1 };
        
        if (nums.length == 0) {
            return res;
        }
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                end = mid - 1;
            }else if (nums[mid] < target) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        if (start == nums.length || nums[start] != target) {
            return res;
        }
        
        res[0] = start;
        start = 0;
        end = nums.length - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                start = mid + 1;
            }else if (nums[mid] < target) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }     
        res[1] = end;
        
        return res;
    }
}
