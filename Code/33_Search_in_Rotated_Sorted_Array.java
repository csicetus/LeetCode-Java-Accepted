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
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        int j = i + 1;
        if (j > 0) {
            while (i >= 0 && nums[i] >= nums[i + 1] ) {
                i--;
            }
            if (i < 0) {
                reverse(nums, 0);
                return;
            }
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
            reverse(nums, i + 1);
        }
    }
    
    public void swap(int[] nums, int s1, int s2) {
        int temp = nums[s1];
        nums[s1] = nums[s2];
        nums[s2] = temp;
    }
    
    public void reverse(int[] nums, int k) {
        int m = k, n = nums.length - 1;
        while (m < n) {
            swap(nums, m, n);
            m++;
            n--;
        }        
    }
}
