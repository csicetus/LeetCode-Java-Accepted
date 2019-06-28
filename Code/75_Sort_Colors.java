/*
 * 75. Sort Colors
 * Target: Given an array with n objects colored red, white or blue, sort them in-place so that 
 *         objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Difficulty：Medium
 * Classification：Array, Two pointers, Sort
 */

/*
 * Solution 1
 * 2019-06-27  Runtime: 2 ms
 * Algorithm: => First, iterate the array counting number of 0's, 1's, and 2's, 
 *               then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Time complexity: O(n) Space complexity: O(1)
 */
 
 class Solution {
    public void sortColors(int[] nums) {
        int num0 = 0;
        int num1 = 0;
        for (int num : nums) {
            if (num == 0) {
                num0++;
            } 
            if (num == 1) {
                num1++;
            }
        }
        System.out.println(num1);
        for (int i = 0; i < num0; i++) {
            nums[i] = 0;
        } 
        for (int i = num0; i < num0 + num1; i++) {
            nums[i] = 1;
        }
        for (int i = num0 + num1; i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}

 
/*
 * Solution 2
 * 2019-06-27  Runtime: 0 ms
 * Algorithm: => Two pointers.
 * Time complexity: O(n) Space complexity: O(1)
 */
 
 class Solution {
    public void sortColors(int[] nums) {
        int pos_z = 0;
        int pos_t = nums.length - 1;
        for (int i = 0; i <= pos_t; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[pos_z];
                nums[pos_z] = tmp;
                pos_z++;
            } else if (nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[pos_t];
                nums[pos_t] = tmp;
                pos_t--;
                i--;    // Note that we should check the number from pos_t before i++.
            }
        }
    }
}
 
 
/*
 * Solution 3
 * 2019-06-27  Runtime: 0 ms
 * Algorithm: => Three pointers
 * Time complexity: O(n) Space complexity: O(1)
 */
 
 class Solution {
    public void sortColors(int[] nums) {
        int n0 = -1, n1 = -1, n2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[++n2] = 2;
                nums[++n1] = 1;
                nums[++n0] = 0;
            } else if (nums[i] == 1) {
                nums[++n2] = 2;
                nums[++n1] = 1;
            } else {
                nums[++n2] = 2;
            }
        }
    }
}
