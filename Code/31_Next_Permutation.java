/*
 * 31. Next Permutation
 * 2019-06-16  Runtime: 5 ms
 * Target: Implement next permutation.
 * Difficulty：Medium
 * Classification：Array
 * Algorithm: => Look for the first smaller number x from the back, find the first number y larger than x from the number 
 *               after this number, exchange, and then reverse numbers after the number y.
 * Time complexity: O(n), Space complexity: O(1)
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
