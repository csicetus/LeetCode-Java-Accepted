/*
 * 238. Product of Array Except Self
 * Target: Given an array nums of n integers where n > 1,  
 *         return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *         Note: Please solve it without division and in O(n).
 * Difficulty：Medium
 * Classification：Array
 */

/*
 * Solution 1
 * 2019-08-01  Runtime: 1 ms
 * Algorithm: => Left and Right product lists.
 * Time Complexity: O(N). Space Conplexity: O(N) where N represents the number of elements in the input array. 
 */
 
 class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];
        int[] res = new int[len];
        L[0] = 1;
        for (int i = 1; i < len; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        R[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            res[i] = L[i] * R[i];
        }
        return res;
    }
}

 
/*
 * Solution 2
 * 2019-08-01  Runtime: 1 ms
 * Algorithm: => Left and Right product lists. Optimal of sol 1.
 *               Calculate without int[] L, int[] R, using variable R instead.
 * Time Complexity: O(N). Space Conplexity: O(1)
 */
 
 class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] = res[i] * R;
            R *= nums[i];
        }        
        return res;
    }
}
