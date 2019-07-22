/*
 * 35. Search Insert Position
 * Target: Given a sorted array and a target value, return the index if the target is found. 
 *         If not, return the index where it would be if it were inserted in order.
 * Difficulty：Easy
 * Classification：Array, Binary Search
 */

/*
 * Solution 1
 * 2019-07-21  Runtime: 0 ms
 * Algorithm: => Divide and Conquer. Note that r = nums.length rather than nums.length - 1, because when there are only two numbers, 
 *               l == mid, which causes infinite loop. There're 2 solutions：
 *               1. Change the while loop to "while (l <= r)"
 *               2. Change the value of r to "nums.length".
 * Time Complexity: O(logn), n is the length of string. Space Conplexity: O(1)
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length; 
        if (nums.length == 0) return 0;
        while (l < r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
