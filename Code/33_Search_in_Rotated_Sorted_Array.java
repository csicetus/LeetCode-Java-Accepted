/*
 * 33. Search in Rotated Sorted Array
 * Target: Find the specified number in the inverted ordered array.
 * Difficulty：Medium
 * Classification：Array, Binary Search
 */
 
  /*
 * Solution 1
 * 2019-06-15  Runtime: 0 ms
 * Algorithm: => Brute Force.
 * Time complexity: O(n*logn). Space complexity: O(n).
 */
 
 class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int n = nums.length;
        int end = n - 1;
        
        // find min number index
        // while (start < end) {
        //     int mid = (start + end)
        //     if (nums[mid] > nums[end]) {
        //         start = mid + 1;
        //     }
        //     else {
        //         end = mid;
        //     }
        // }
        
        
        while (start < end) {
            int mid = (start + end)
            if (nums[mid] < nums[start]) {
                end = mid + 1;
            }
            else {
                start = mid;
            }
        }
        
        
        // (pos + bias) % n = index
        // (n - 1 + bias) % n = start
        int bias = (start + n) - (n - 1);
    }
}
